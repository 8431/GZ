package com.gz.medicine.yun.common.controller;

import com.gz.medicine.common.util.*;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.yun.common.config.WechatPayConfig;
import com.gz.medicine.yun.common.service.SendMessageService;
import com.gz.medicine.yun.doctor.controller.DTCaseHistoryController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName WechatPayController
 * @PackageName com.gz.medicine.yun.common.controller
 * @Description 微信支付
 * @Data 2017-08-17 10:47
 **/
@Controller
@RequestMapping("wechatpay")
public class WechatPayController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryController.class);

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;



    @Autowired
    private HealthConsultationMapper healthConsultationMapper;

    @Autowired
    private HealthOrderService healthOrderService;

    @Autowired
    private SendMessageService sendMessageService;



    /**
     * 签名:排序->拼接key->MD5加密
     *
     * 统一下单
     * @param orderid  订单ID
     * @测试地址 localhost:8080/GZ/wechatpay/pay?orderid=59AA3C5FB7B44BCBE050007F01004CF2
     */
    @RequestMapping(value = "/pay", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult orderPay(String orderid){
        LOGGER.info("[/wechatpay/pay]");
        Map<String, String> restmap = null;
        HealthyOrder healthyOrder=null;
        boolean flag = true; // 是否订单创建成功
        Double cashnum;
        String nonce_str=AliPayUtil.getNonceStr();// 随机字符串
        if("".equals(orderid)&&orderid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入订单ID!!!");
        }
        try {
            healthyOrder=healthyOrderMapper.selectOrderById(orderid);
            if(healthyOrder!=null){
                String body = healthyOrder.getConsultationmethod();
                if("2".equals(body)){
                    body = "图文咨询";
                }else  if("3".equals(body)){
                    body = "语音咨询";
                }else  if("4".equals(body)){
                    body = "视频咨询";
                }
                cashnum=Double.parseDouble(healthyOrder.getOrderamount().toString());
                String total_fee = BigDecimal.valueOf(cashnum).multiply(BigDecimal.valueOf(100))
                        .setScale(0, BigDecimal.ROUND_HALF_UP).toString();
                Map<String, String> parm = new HashMap<String, String>();
                parm.put("appid", WechatPayConfig.APP_ID);//应用ID   ---微信开放平台审核通过的应用APPID
                parm.put("mch_id", WechatPayConfig.MCH_ID);//商户号
                parm.put("device_info", "WEB");
                parm.put("nonce_str", nonce_str);  // 随机字符串
                parm.put("body", body);//商品描述
                parm.put("attach", healthyOrder.getConsultationmethod()); // 附加数据 原样返回
                parm.put("out_trade_no", orderid); //商家订单号
                parm.put("total_fee", total_fee);//商品金额,以分为单位
                parm.put("spbill_create_ip", "127.0.0.1");//AliPayUtil.getRemoteAddrIp(request)
                parm.put("notify_url", WechatPayConfig.NOTIFY_URL);//异步通知地址
                parm.put("trade_type", "APP");//交易类型
                parm.put("sign", AliPayUtil.getSigns(parm, WechatPayConfig.API_SECRET));//签名
                //调用统一下单接口
                String restxml = HttpUtils.post(WechatPayConfig.ORDER_PAY, XmlUtil.xmlFormat(parm, false));
                restmap = XmlUtil.xmlParse(restxml);
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "没有该订单!!!");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        Map<String, String> payMap = new HashMap<String, String>();
        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
            /**
             * 二次签名
             *
             * 统一下单接口返回正常的prepay_id，
             * 再按签名规范重新生成签名后，将数据传输给APP。
             * 参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay
             * **/
            String timestamp=AliPayUtil.payTimestamp();
            payMap.put("appid", WechatPayConfig.APP_ID); //应用ID
            payMap.put("partnerid", WechatPayConfig.MCH_ID);//商户ID
            payMap.put("prepayid", restmap.get("prepay_id"));  //获取预支付id
            payMap.put("package", "Sign=WXPay"); //package的值格式为Sign=WXPay
            payMap.put("noncestr", nonce_str); //随机字符串
            payMap.put("timestamp", timestamp);//时间戳,单位秒
            try {
                String finalsign=AliPayUtil.getSigns(payMap,WechatPayConfig.API_SECRET );
                //打印方便看
                String finaPackage = "appid=" + WechatPayConfig.APP_ID + "&partnerid=" + WechatPayConfig.MCH_ID
                        + "&prepayid=" + restmap.get("prepay_id") + "&package=" + "Sign=WXPay"
                        + "&noncestr=" + nonce_str + "&tamp=" + timestamp
                        + "&sign=" + finalsign;
                System.out.println("二次签名之后的数据:" + finaPackage);
                payMap.put("sign", finalsign);
            } catch (Exception e) {
                flag = false;
            }
        }
        if (flag) {
            //订单获取成功  payMap
            SimpleResult simpleResult=SimpleResult.success();
            simpleResult.putDataAll(payMap);
            return simpleResult;
        } else {
            if (CollectionUtil.isNotEmpty(restmap)) {
                LOGGER.info("订单创建失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }
            //订单获取失败
            SimpleResult simpleResult=SimpleResult.error();
            simpleResult.setMessage("订单创建失败");
            return simpleResult;
        }
    }

    /**
     * 查询支付结果
     * @param tradeid  微信交易订单号
     * @param tradeno  商品订单号
     * @param callback
     */
    @RequestMapping(value = "/pay/query", method = RequestMethod.POST)
    public void orderPayQuery(String tradeid, String tradeno,String callback){
        LOGGER.info("[/order/pay/query]");
        Map<String, String> restmap = null;
        try {
            Map<String, String> parm = new HashMap<String, String>();
            parm.put("appid", WechatPayConfig.APP_ID);
            parm.put("mch_id", WechatPayConfig.MCH_ID);
            parm.put("transaction_id", tradeid);
            parm.put("out_trade_no", tradeno);
            parm.put("nonce_str", AliPayUtil.getNonceStr());
            parm.put("sign", AliPayUtil.getSign(parm, WechatPayConfig.API_SECRET));

            String restxml = HttpUtils.post(WechatPayConfig.ORDER_PAY_QUERY, XmlUtil.xmlFormat(parm, false));
            restmap = XmlUtil.xmlParse(restxml);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
            // 订单查询成功 处理业务逻辑
            LOGGER.info("订单查询：订单" + restmap.get("out_trade_no") + "支付成功");

            //订单支付成功


        } else {
            if (CollectionUtil.isNotEmpty(restmap)) {
                LOGGER.info("订单支付失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }
            //订单支付失败

        }
    }


    /**
     * 订单支付微信服务器异步通知
     */
    @RequestMapping("/pay/notify")
    public void orderPayNotify(HttpServletRequest request,HttpServletResponse response){
        LOGGER.info("微信支付服务器异步通知");
        LOGGER.info("[/order/pay/notify]");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/xml");
        try {
            ServletInputStream in = request.getInputStream();
            String resxml = FileUtil.readInputStream2String(in);
            Map<String, String> restmap = XmlUtil.xmlParse(resxml);
            LOGGER.info("微信支付结果通知：" + restmap);
            if ("SUCCESS".equals(restmap.get("result_code"))) {
                // 订单支付成功 业务处理
                String out_trade_no = restmap.get("out_trade_no"); // 商户订单号
                String transaction_id = (String) restmap.get("transaction_id");//微信支付订单号
                // 通过商户订单判断是否该订单已经处理 如果处理跳过 如果未处理先校验sign签名 再进行订单业务相关的处理
                String sing = restmap.get("sign"); // 返回的签名
                restmap.remove("sign");
                String signnow = AliPayUtil.getSigns(restmap, WechatPayConfig.API_SECRET);
                if (signnow.equals(sing)) {
                    // 进行业务处理
                    LOGGER.info("订单支付通知： 支付成功，订单号" + out_trade_no);
                    // 处理成功后相应给响应xml
                    Map<String, String> respMap = new HashMap<String, String>();
                    respMap = new HashMap<String, String>();
                    respMap.put("return_code", "SUCCESS");  //相应给微信服务器 告诉微信已经收到通知了
                    respMap.put("return_msg", "OK");
                    String resXml = XmlUtil.xmlFormat(restmap, true);
                    response.getWriter().write(resXml);
                    try {

                        HealthyOrder healthyOrdere = healthOrderService.selectOrderById(out_trade_no);
                        if(healthyOrdere !=null && !"".equals(healthyOrdere)){
                                if("1".equals(healthyOrdere.getOrderstate())){
                                    //根据订单ID更新订单状态
                                    //订单状态：待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
                                    HealthyOrder healthyOrders = new HealthyOrder();
                                    healthyOrders.setId(out_trade_no);
                                    healthyOrders.setOrderstate("2");
                                    healthyOrders.setPaymentmethod("2");
                                    healthyOrders.setThirdordercode(transaction_id);
                                    healthyOrders.setCreatedate(new Date());
                                    healthyOrders.setUpdatedate(new Date());
                                    healthyOrders.setCreatename(healthyOrdere.getCreatename());
                                    healthyOrders.setUpdatename(healthyOrdere.getUpdatename());
                                    healthyOrders.setUsername(healthyOrdere.getUsername());
                                    healthOrderService.UpdateOrderAndLog(healthyOrders,"订单支付成功");
                                    Integer count=healthConsultationMapper.selectCountById(out_trade_no);
                                    LOGGER.info("微信支付结果通知-咨询信息统计: " + count);
                                    if(count>0){
                                    }else {
                                        LOGGER.info("微信支付结果通知-咨询信息保存");
                                        HealthConsultation healthConsultation=new HealthConsultation();
                                        HealthyOrder healthyOrder=healthyOrderMapper.selectOrderById(out_trade_no);
                                        healthConsultation.setId(UUIDTool.getUUID());
                                        healthConsultation.setOrderid(out_trade_no);
                                        healthConsultation.setConsultingstate("1");  //ConsultingState
                                        healthConsultation.setState("1");
                                        healthConsultation.setUsrid(healthyOrder.getUsrid());
                                        healthConsultation.setDocid(healthyOrder.getDocid());
                                        healthConsultation.setCreatedate(new Date());
                                        healthConsultation.setUpdatedate(new Date());
                                        healthConsultation.setCreatename(healthyOrder.getCreatename());
                                        healthConsultation.setUpdatename(healthyOrder.getUpdatename());
                                        healthConsultationMapper.insert(healthConsultation);
                                    }
                                    //订单支付成功后,发送短信提示 - 订单支付成功后,推送消息
                                    LOGGER.info("微信支付结果通知-订单支付成功后,发送短信提示 - 订单支付成功后,推送消息");
                                    sendMessageService.SendMeessageOK(out_trade_no);
                                }
                        }

                    } catch (Exception e) {
                        LOGGER.error("订单状态修改接口出现异常："+e.getMessage(),e);
                    }
                } else {
                    LOGGER.info("订单支付通知：签名错误");
                }
            } else {
                if ("FAIL".equals(restmap.get("result_code"))){
                    // 订单支付失败 业务处理
                    String out_trade_no = restmap.get("out_trade_no"); // 商户订单号
                    // 订单支付失败 业务处理
                    //根据订单ID更新订单状态
                    Map<String,String> OrderState=new HashMap<String, String>();

                }
                LOGGER.info("订单支付通知：支付失败，" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    /**
     * 订单退款 需要双向证书验证
     *
     * @param tradeno 微信订单号
     * @param orderid  商家订单号
     * @测试地址: localhost:8080/GZ/wechatpay/pay/refund?orderid=&tradeno=
     */
    @RequestMapping(value = "/pay/refund", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult orderPayRefund(String tradeno, String orderid) {

        LOGGER.info("[/pay/refund]");
        Map<String, String> restmap = null;
        HealthyOrder healthyOrder = null;
        SimpleResult simpleResult = null;

        try {
            healthyOrder = healthyOrderMapper.selectOrderById(orderid);
        } catch (Exception e) {
            LOGGER.error("退款获取订单失败: " + e + " ---- " + e.getMessage());
            return  SimpleResult.error("000","没有当前订单!");
        }

        if(healthyOrder!=null){

            Double cashnum=Double.parseDouble(healthyOrder.getOrderamount().toString());
            String total_fee = BigDecimal.valueOf(cashnum).multiply(BigDecimal.valueOf(100))
                    .setScale(0, BigDecimal.ROUND_HALF_UP).toString();
            try {

                Map<String, String> parm = new HashMap<String, String>();
                parm.put("appid", WechatPayConfig.APP_ID);
                parm.put("mch_id", WechatPayConfig.MCH_ID);
                parm.put("nonce_str", AliPayUtil.getNonceStr());
                parm.put("transaction_id", tradeno);//微信订单号
                parm.put("out_trade_no", orderid);//订单号
                parm.put("out_refund_no", AliPayUtil.getRefundNo()); //退款单号
                parm.put("total_fee", total_fee); // 订单总金额 从业务逻辑获取
                parm.put("refund_fee",total_fee); // 退款金额
                parm.put("op_user_id", WechatPayConfig.MCH_ID);
                parm.put("refund_account", "REFUND_SOURCE_RECHARGE_FUNDS");//退款方式
                parm.put("sign", AliPayUtil.getSigns(parm, WechatPayConfig.API_SECRET));
                String restxml = HttpUtils.posts(WechatPayConfig.ORDER_REFUND, XmlUtil.xmlFormat(parm, false));
                restmap = XmlUtil.xmlParse(restxml);

            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                return  SimpleResult.error("001","微信退款失败!");
            }

            Map<String, String> refundMap = new HashMap<String, String>();
            if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {

                //商户订单号
                String out_trade_no = restmap.get("out_trade_no");
                //微信支付交易号
                String transaction_id = restmap.get("transaction_id");
                //退款单号
                String  refund_id = restmap.get("refund_id");

                refundMap.put("transaction_id", restmap.get("transaction_id")); //微信支付交易号
                refundMap.put("out_trade_no", restmap.get("out_trade_no")); //商户订单号
                refundMap.put("refund_id", restmap.get("refund_id"));   //微信退款单号
                refundMap.put("out_refund_no", restmap.get("out_refund_no"));

                LOGGER.info("订单退款：订单" + restmap.get("out_trade_no") + "退款成功，商户退款单号" + restmap.get("out_refund_no") + "，微信退款单号"
                        + restmap.get("refund_id"));
                try {

                    //根据订单ID更新订单状态
                    Map<String,String> OrderState=new HashMap<String, String>();
                    OrderState.put("orderid",out_trade_no);
                    OrderState.put("orderstate","6"); //付款成功

                    //支付方式(支付宝、微信)1,2
                    OrderState.put("paymentmethod","2");//支付方式
                    OrderState.put("thirdordercode",transaction_id);//第三方订单编号
                    healthyOrderMapper.updateOrderByOrderId(OrderState);  //更新订单

                    //订单支付成功后,发送短信提示 - 订单支付成功后,推送消息
                    sendMessageService.SendMeessageRefunds(out_trade_no);
                    return  SimpleResult.success();
                }catch (Exception e){
                    LOGGER.error("退款之后状态更改失败: " + e + " ---- " + e.getMessage());
                    return  SimpleResult.error("001","退款之后状态更改失败");
                }
            } else {
                if (CollectionUtil.isNotEmpty(restmap)) {
                    LOGGER.info("订单退款失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
                    return  SimpleResult.error("001", "退款失败");
                }
            }
        }else {
            return  SimpleResult.error("001", "没有当前订单信息");
        }
        return simpleResult;
    }

    /**
     * 订单退款查询
     * @param tradeid 微信订单号
     * @param tradeno 商户订单号
     * @param refundid 微信退款号
     * @param refundno 商家退款号
     */
    @RequestMapping(value = "/pay/refund/query", method = RequestMethod.POST)
    public void orderPayRefundQuery(String refundid,
                                    String refundno, String tradeid, String tradeno) {
        LOGGER.info("[/pay/refund/query]");
        Map<String, String> restmap = null;
        try {
            Map<String, String> parm = new HashMap<String, String>();
            parm.put("appid", WechatPayConfig.APP_ID);
            parm.put("mch_id", WechatPayConfig.MCH_ID);
            parm.put("transaction_id", tradeid);
            parm.put("out_trade_no", tradeno);
            parm.put("refund_id", refundid);
            parm.put("out_refund_no", refundno);
            parm.put("nonce_str", AliPayUtil.getNonceStr());
            parm.put("sign", AliPayUtil.getSign(parm, WechatPayConfig.API_SECRET));
            String restxml = HttpUtils.post(WechatPayConfig.ORDER_REFUND_QUERY, XmlUtil.xmlFormat(parm, false));
            restmap = XmlUtil.xmlParse(restxml);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        Map<String, String> refundMap = new HashMap<String, String>();
        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code")) && "SUCCESS".equals(restmap.get("result_code"))) {
            // 订单退款查询成功 处理业务逻辑
            LOGGER.info("退款订单查询：订单" + restmap.get("out_trade_no") + "退款成功，退款状态"+ restmap.get("refund_status_0"));
            refundMap.put("transaction_id", restmap.get("transaction_id"));
            refundMap.put("out_trade_no", restmap.get("out_trade_no"));
            refundMap.put("refund_id", restmap.get("refund_id_0"));
            refundMap.put("refund_no", restmap.get("out_refund_no_0"));
            refundMap.put("refund_status", restmap.get("refund_status_0"));
            //订单退款成功 refundMap

        } else {
            if (CollectionUtil.isNotEmpty(restmap)) {
                LOGGER.info("订单退款失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }

        }
    }

}
