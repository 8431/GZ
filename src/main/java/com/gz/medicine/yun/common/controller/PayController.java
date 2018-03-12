package com.gz.medicine.yun.common.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayConstants;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.gz.medicine.common.util.*;
import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthDoctorFormMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.health.service.HealthPushMessageService;
import com.gz.medicine.yun.common.config.AliPayConfig;
import com.gz.medicine.yun.common.config.WechatPayConfig;
import com.gz.medicine.yun.common.service.SendMessageService;
import com.gz.medicine.yun.doctor.controller.DTCaseHistoryController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName PayController
 * @PackageName com.gz.medicine.yun.common.controller
 * @Description 支付退款统一类
 * @Data 2017-10-27 10:47
 **/
@Controller
@RequestMapping("/pay")
public class PayController extends ValidateWithException {


    public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryController.class);

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;

    @Autowired
    private HealthConsultationService healthConsultationService;

    @Autowired
    private HealthConsultationMapper healthConsultationMapper;

    @Autowired
    private HealthOrderService healthOrderService;


    @Autowired
    private HealthPushMessageService healthPushMessageService;

    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private HealthDoctorFormMapper healthDoctorFormMapper;

    /**
     * 订单下单
     * @param payflag 1 支付宝 2 微信
     * @param orderid 订单ID
     * @测试地址: http://localhost:8081/GZ/pay/orderpay?payflag=1&orderid=1509723328459833071000009614
     */
    @RequestMapping(value = "/orderpay", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult orderPay(String payflag,String orderid){
        LOGGER.info("[/pay/orderpay]");
        LOGGER.info("订单下单" + payflag + "----" + orderid);
        SimpleResult simpleResult = null;
        HealthyOrder healthyOrder = null;
        if("".equals(payflag)&&payflag==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入支付类型");
        }
        if("".equals(orderid)&&orderid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入订单ID!!!");
        }
        try {
            healthyOrder=healthyOrderMapper.selectOrderById(orderid);
            if(healthyOrder!=null){
                String subject = healthyOrder.getConsultationmethod();
                if("2".equals(subject)){
                    subject = "图文咨询";
                }else  if("3".equals(subject)){
                    subject = "语音咨询";
                }else  if("4".equals(subject)){
                    subject = "视频咨询";
                }
                //支付宝
                if("1".equals(payflag)){
                    Map<String, String> param = new HashMap<String,String>();
                    Map<String, String> payMap = new HashMap<String, String>();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String timestamp=format.format(new Date());
                    // 公共请求参数
                    param.put("app_id", AliPayConfig.APP_ID);// 商户订单号
                    param.put("method", "alipay.trade.app.pay");// 交易
                    param.put("format", AlipayConstants.FORMAT_JSON);
                    param.put("charset", AlipayConstants.CHARSET_UTF8);
                    param.put("timestamp", timestamp);
                    param.put("version", "1.0");
                    param.put("notify_url", AliPayConfig.REFUND_NOTIFY); // 支付宝服务器主动通知商户服务
                    param.put("sign_type", AlipayConstants.SIGN_TYPE_RSA);
                    Map<String, Object> pcont = new HashMap<String,Object>();
                    // 支付业务请求参数
                    pcont.put("out_trade_no", orderid); // 商户订单号
                    pcont.put("total_amount", String.valueOf(healthyOrder.getOrderamount()));// 交易金额
                    pcont.put("subject",subject); // 订单标题
                    pcont.put("body", healthyOrder.getConsultingdescription());// 对交易或商品的描述
                    pcont.put("product_code", AliPayConfig.QUICK_MSECURITY_PAY);// 销售产品码
                    param.put("biz_content", JSON.toJSONString(pcont)); // 业务请求参数  不需要对json字符串转义
                    param.put("sign", AliPayUtil.getSign(param, AliPayConfig.APP_PRIVATE_KEY)); // 业务请求参数
                    payMap.put("orderStr", AliPayUtil.getSignEncodeUrl(param, true));
                    simpleResult = SimpleResult.success();
                    simpleResult.put("data",payMap);
                    LOGGER.info("支付宝支付返回结果:" + payMap);
                    return simpleResult;
                    //微信
                }else if("2".equals(payflag)){
                    Map<String, String> restmap = null;
                    Double cashnum;
                    String nonce_str = AliPayUtil.getNonceStr();// 随机字符串
                    cashnum=Double.parseDouble(healthyOrder.getOrderamount().toString());
                    String total_fee = BigDecimal.valueOf(cashnum).multiply(BigDecimal.valueOf(100))
                            .setScale(0, BigDecimal.ROUND_HALF_UP).toString();
                    Map<String, String> parm = new HashMap<String, String>();
                    parm.put("appid", WechatPayConfig.APP_ID);//应用ID   ---微信开放平台审核通过的应用APPID
                    parm.put("mch_id", WechatPayConfig.MCH_ID);//商户号
                    parm.put("device_info", "WEB");
                    parm.put("nonce_str", nonce_str);  // 随机字符串
                    parm.put("body", subject);//商品描述
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
                        String finalsign=AliPayUtil.getSigns(payMap,WechatPayConfig.API_SECRET );
                        //打印方便看
                        String finaPackage = "appid=" + WechatPayConfig.APP_ID + "&partnerid=" + WechatPayConfig.MCH_ID
                                + "&prepayid=" + restmap.get("prepay_id") + "&package=" + "Sign=WXPay"
                                + "&noncestr=" + nonce_str + "&tamp=" + timestamp
                                + "&sign=" + finalsign;
                        System.out.println("二次签名之后的数据:" + finaPackage);
                        payMap.put("sign", finalsign);
                        //订单获取成功  payMap
                        simpleResult=SimpleResult.success();
                        simpleResult.put("data",payMap);
                        LOGGER.info("微信支付返回结果:" + payMap);
                        return simpleResult;
                    }
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "没有该订单!!!");
            }
        }catch (Exception e){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "在执行SQL时出现错误!!!");
        }

        return simpleResult;
    }


    /**
     * 订单退款
     * @param orderid
     * @测试地址: http://localhost:8081/GZ/pay/refund?orderid=1509723328459833071000009614
     */
    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult orderPayRefund(String orderid) {
        LOGGER.info("[/pay/refund]");
        Map<String, String> restmap = null;
        HealthyOrder healthyOrder = null;
        SimpleResult simpleResult = null;
        if("".equals(orderid)&&orderid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入订单ID!!!");
        }
        try {
            healthyOrder = healthyOrderMapper.selectOrderById(orderid);
            LOGGER.info("[/pay/refund] 退款: " + healthyOrder.toString());
            if(healthyOrder!=null){
                String payflag = healthyOrder.getPaymentmethod();
                String tradeno = healthyOrder.getThirdordercode();
                if("".equals(payflag) && payflag == null){
                    return SimpleResult.error("COMM01","支付类型不能为空!!!!");
                }
                if("".equals(tradeno) && tradeno == null){
                    return SimpleResult.error("COMM01","第三方支付编号不能为空!!!!");
                }

                if(!"6".equals(healthyOrder.getOrderstate())){
                    return SimpleResult.error("001","对不起,当前状态不能退款,请联系管理员!");
                }

                //支付宝
                if("1".equals(payflag)){
                    AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest(); // 统一收单交易退款接口
                    Map<String, Object> alipaymap = new HashMap<String, Object>();// 返回支付宝退款信息
                    // 只需要传入业务参数
                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("out_trade_no", healthyOrder.getId()); // 商户订单号
                    param.put("trade_no", tradeno);// 支付宝交易号
                    param.put("refund_amount", healthyOrder.getOrderamount());// 退款金额
                    param.put("refund_reason", "正常退款");// 退款描述
                    param.put("out_request_no", AliPayUtil.getRefundNo()); //退款单号
                    alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义
                    AlipayTradeRefundResponse alipayResponse = AliPayConfig.getInstance().execute(alipayRequest);
                    if (alipayResponse.isSuccess()) {
                        // 调用成功，则处理业务逻辑
                        if ("10000".equals(alipayResponse.getCode())) {
                            //商户订单号
                            String out_trade_no = alipayResponse.getOutTradeNo();
                            //支付宝交易号
                            String trade_no = alipayResponse.getTradeNo();
                            // 订单创建成功
                            alipaymap.put("out_trade_no", out_trade_no);
                            alipaymap.put("trade_no", trade_no);
                            alipaymap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());// 用户的登录id
                            alipaymap.put("gmt_refund_pay", alipayResponse.getGmtRefundPay()); // 退看支付时间
                            alipaymap.put("buyer_user_id", alipayResponse.getBuyerUserId());// 买家在支付宝的用户id

                            //订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8)
                            HealthyOrder healthyOrders = new HealthyOrder();
                            healthyOrders.setId(alipayResponse.getOutTradeNo());
                            healthyOrders.setOrderstate("7");
                            //healthyOrders.setCreatedate(new Date());
                            healthyOrders.setUpdatedate(new Date());
                            healthyOrders.setCreatename(healthyOrder.getCreatename());
                            healthyOrders.setUpdatename("客服人员");
                            healthyOrders.setUsername(healthyOrder.getUsername());
                            healthOrderService.UpdateOrderAndLog(healthyOrders,"订单退款成功");
                            LOGGER.info("[支付宝退款-发送短信提示并推送消息]");
                            //发送短信提示 -- 并推送消息
                            sendMessageService.SendMeessageRefunds(out_trade_no);
                            LOGGER.info("[支付宝退款-更改医生排班状态]");
                            //更改医生排班状态
                            HealthDoctorForm healthDoctorForm = new HealthDoctorForm();
                            healthDoctorForm.setDocid(healthyOrder.getDocid()); //医生ID
                            healthDoctorForm.setFormdate(healthyOrder.getReservationdate()); //预约日期
                            healthDoctorForm.setFormstarttime(healthyOrder.getReserstarttime());//预约开始时间
                            healthDoctorForm.setFormendtime(healthyOrder.getReserendtime()); //预约结束时间
                            healthDoctorForm.setFormstate("0");//设置状态为 0 未预约
                            healthDoctorFormMapper.updateDocFormState(healthDoctorForm);

                            simpleResult = SimpleResult.success();
                            return simpleResult;

                        } else {
                            simpleResult = SimpleResult.error();
                            LOGGER.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                            return simpleResult;
                        }
                    }
                    //微信
                }else if("2".equals(payflag)){

                    Double cashnum=Double.parseDouble(healthyOrder.getOrderamount().toString());
                    String total_fee = BigDecimal.valueOf(cashnum).multiply(BigDecimal.valueOf(100))
                            .setScale(0, BigDecimal.ROUND_HALF_UP).toString();
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
                    Map<String, String> refundMap = new HashMap<String, String>();
                    if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
                        //商户订单号
                        String out_trade_no = restmap.get("out_trade_no");
                        //微信交易号
                        String transaction_id = restmap.get("transaction_id");
                        refundMap.put("transaction_id", transaction_id);
                        refundMap.put("out_trade_no", out_trade_no);
                        refundMap.put("refund_id", restmap.get("refund_id"));
                        refundMap.put("out_refund_no", restmap.get("out_refund_no"));
                        LOGGER.info("订单退款：订单" + restmap.get("out_trade_no") + "退款成功，商户退款单号" + restmap.get("out_refund_no") + "，微信退款单号"
                                + restmap.get("refund_id"));


                        //订单状态：待支付(1)、付款成功(2)、订单已取消(3)、订单关闭(4)、订单完成(5)、退款审核中(6)、退款成功(7)、订单已过期(8)
                        HealthyOrder healthyOrders = new HealthyOrder();
                        healthyOrders.setId(restmap.get("out_trade_no"));
                        healthyOrders.setOrderstate("7");
                        //healthyOrders.setCreatedate(new Date());
                        healthyOrders.setUpdatedate(new Date());
                        healthyOrders.setCreatename(healthyOrder.getCreatename());
                        healthyOrders.setUpdatename("客服人员");
                        healthyOrders.setUsername(healthyOrder.getUsername());
                        healthOrderService.UpdateOrderAndLog(healthyOrders,"订单退款成功");
                        LOGGER.info("[微信退款-发送短信提示并推送消息]");
                        //发送短信提示 -- 并推送消息
                        sendMessageService.SendMeessageRefunds(out_trade_no);

                        LOGGER.info("[微信退款-更改医生排班状态]");
                        //更改医生排班状态
                        HealthDoctorForm healthDoctorForm = new HealthDoctorForm();
                        healthDoctorForm.setDocid(healthyOrder.getDocid()); //医生ID
                        healthDoctorForm.setFormdate(healthyOrder.getReservationdate()); //预约日期
                        healthDoctorForm.setFormstarttime(healthyOrder.getReserstarttime());//预约开始时间
                        healthDoctorForm.setFormendtime(healthyOrder.getReserendtime()); //预约结束时间
                        healthDoctorForm.setFormstate("0");//设置状态为 0 未预约
                        healthDoctorFormMapper.updateDocFormState(healthDoctorForm);

                        return  SimpleResult.success();
                    } else {
                        if (CollectionUtil.isNotEmpty(restmap)) {
                            LOGGER.info("订单退款失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
                            return  SimpleResult.error("001", "退款失败: " + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
                        }
                    }
                }
            }else {
                return  SimpleResult.error("001", "没有当前订单信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return  SimpleResult.error("001", "退款失败");
        }

        return simpleResult;
    }

}
