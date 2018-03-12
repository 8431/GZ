package com.gz.medicine.yun.common.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.gz.medicine.common.util.*;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.mapper.healthDoctorMapper;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.yun.common.config.AliPayConfig;
import com.gz.medicine.yun.common.service.SendMessageService;
import com.gz.medicine.yun.doctor.controller.DTCaseHistoryController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName AlipayController
 * @PackageName com.gz.medicine.yun.common.controller
 * @Description 支付宝支付
 * @Data 2017-08-17 10:47
 **/
@Controller
@RequestMapping("/alipay")
public class AlipayController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryController.class);

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;

    @Autowired
    private HealthConsultationMapper healthConsultationMapper;


    @Autowired
    private HealthConsultationService healthConsultationService;

    @Autowired
    private HealthOrderService healthOrderService;


    @Autowired
    private healthDoctorMapper healthDoctorMapper;

    @Autowired
    private SendMessageService sendMessageService;


    /**
     * 支付下单
     * @param orderid  订单id
     * @测试地址: localhost:8080/GZ/alipay/pay?orderid=59AA3C5FB7B44BCBE050007F01004CF2
     */
    @RequestMapping(value = "/pay", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult orderPay(String orderid){
        HealthyOrder healthyOrder;
        Map<String, String> param = new HashMap<String,String>();
        Map<String, String> payMap = new HashMap<String, String>();
        LOGGER.info("[/alipay/pay]");
        LOGGER.info("微信支付下单");
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
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "没有该订单!!!");
            }
        } catch (Exception e) {
            LOGGER.error("咨询订单接口出现异常："+e.getMessage(),e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "在执行SQL时出现错误!!!");
        }
        SimpleResult simpleResult=SimpleResult.success();
        simpleResult.put("data",payMap);
        return simpleResult;
    }

    /**
     * 订单查询
     * @param request
     * @param response
     * @param tradeno 支付宝订单交易编号
     * @param orderno 商家交易编号
     * @param callback
     */
    @RequestMapping(value = "/pay/query", method = RequestMethod.POST)
    public SimpleResult orderPayQuery(HttpServletRequest request, HttpServletResponse response, String tradeno, String orderno,String callback){
        LOGGER.info("[/alipay/pay/query]");
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest(); // 统一收单线下交易查询
        // 只需要传入业务参数
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("out_trade_no", orderno); // 商户订单号
        param.put("trade_no", tradeno);// 交易金额
        alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义
        Map<String, String> restmap = new HashMap<String, String>();// 返回提交支付宝订单交易查询信息
        boolean flag = false; // 查询状态
        try {
            AlipayTradeQueryResponse alipayResponse = AliPayConfig.getInstance().execute(alipayRequest);
            if (alipayResponse.isSuccess()) {
                // 调用成功，则处理业务逻辑
                if ("10000".equals(alipayResponse.getCode())) {
                    // 订单创建成功
                    flag = true;
                    restmap.put("order_no", alipayResponse.getOutTradeNo());
                    restmap.put("trade_no", alipayResponse.getTradeNo());
                    restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());
                    restmap.put("trade_status", alipayResponse.getTradeStatus());
                    LOGGER.info("订单查询结果：" + alipayResponse.getTradeStatus());
                } else {
                    LOGGER.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (flag) {
            // 订单查询成功
            SimpleResult simpleResult=SimpleResult.success();
            simpleResult.putDataAll(restmap);
            return simpleResult;
        } else { // 订单查询失败
            SimpleResult simpleResult=SimpleResult.error() ;
            simpleResult.putDataAll(restmap);
            return simpleResult;
        }

    }

    /**
     * 订单退款
     * @param tradeno 支付宝交易订单号
     * @param orderid 商家交易订单号
     * @测试地址: localhost:8080/GZ/alipay/pay/refund?orderid=&tradeno=
     */
    @RequestMapping(value = "/pay/refund", method = RequestMethod.POST)
    @ResponseBody
    public SimpleResult orderPayRefund(String tradeno, String orderid) {
        LOGGER.info("[/alipay/refund]");
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest(); // 统一收单交易退款接口
        boolean flag = false; // 查询状态
        Map<String, Object> restmap = new HashMap<String, Object>();// 返回支付宝退款信息
        HealthyOrder healthyOrder= null;
        try {
            healthyOrder = healthyOrderMapper.selectOrderById(orderid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(healthyOrder!=null){
            // 只需要传入业务参数
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("out_trade_no", healthyOrder.getId()); // 商户订单号
            param.put("trade_no", tradeno);// 支付宝交易号
            param.put("refund_amount", healthyOrder.getOrderamount());// 退款金额
            param.put("refund_reason", "正常退款");// 退款描述
            param.put("out_request_no", AliPayUtil.getRefundNo()); //退款单号
            alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义
            try {
                AlipayTradeRefundResponse alipayResponse = AliPayConfig.getInstance().execute(alipayRequest);
                if (alipayResponse.isSuccess()) {
                    // 调用成功，则处理业务逻辑
                    if ("10000".equals(alipayResponse.getCode())) {
                        // 订单创建成功
                        flag = true;
                        restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
                        restmap.put("trade_no", alipayResponse.getTradeNo());
                        restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());// 用户的登录id
                        restmap.put("gmt_refund_pay", alipayResponse.getGmtRefundPay()); // 退看支付时间
                        restmap.put("buyer_user_id", alipayResponse.getBuyerUserId());// 买家在支付宝的用户id
                        try {
                            //根据订单ID更新订单状态
                            Map<String,String> OrderState=new HashMap<String, String>();
                            OrderState.put("orderid",alipayResponse.getOutTradeNo());
                            OrderState.put("orderstate","6"); //退款成功
                            //支付方式(微信、支付宝)1,2
                            OrderState.put("paymentmethod","2");//支付方式
                            OrderState.put("thirdordercode",alipayResponse.getOutTradeNo());//第三方订单编号
                            healthyOrderMapper.updateOrderByOrderId(OrderState);  //更新订单
                        }catch (Exception e){
                            LOGGER.error(e);
                        }
                        LOGGER.info("订单退款结果：退款成功");
                    } else {
                        LOGGER.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                    }
                }
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
        }else {
            return  SimpleResult.error("001","没有该订单!!!");
        }
        if (flag) {
            // 订单查询成功
            SimpleResult simpleResult=SimpleResult.success();
            simpleResult.putDataAll(restmap);
            return simpleResult;
        } else { // 订单查询失败
            SimpleResult simpleResult=SimpleResult.error() ;
            simpleResult.putDataAll(restmap);
            return simpleResult;
        }
    }


    /**
     * 统一收单交易退款查询
     * @param orderno
     * @param tradeno
     * @测试地址: localhost:8080/GZ/alipay/pay/refund/query?orderid=&tradeno=
     */
    @RequestMapping(value = "/pay/refund/query", method = RequestMethod.POST)
    public SimpleResult orderPayRefundQuery(String orderno,String tradeno){
        LOGGER.info("[alipay/pay/refund/query]");
        if (StringUtil.isEmpty(orderno) && StringUtil.isEmpty(tradeno)) {
            //商家订单号或支付宝订单号不能为空
            return SimpleResult.error("001","商家订单号或支付宝订单号不能为空");
        }
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest(); // 统一收单交易退款查询
        // 只需要传入业务参数
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("out_trade_no", orderno); // 商户订单号
        param.put("trade_no", tradeno);// 交易金额
        param.put("out_request_no", orderno);// 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
        alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义
        Map<String, Object> restmap = new HashMap<String, Object>();// 返回支付宝退款信息
        boolean flag = false; // 查询状态
        try {
            AlipayTradeFastpayRefundQueryResponse alipayResponse = AliPayConfig.getInstance().execute(alipayRequest);
            if (alipayResponse.isSuccess()) {
                // 调用成功，则处理业务逻辑
                if ("10000".equals(alipayResponse.getCode())) {
                    // 订单创建成功
                    flag = true;
                    restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
                    restmap.put("trade_no", alipayResponse.getTradeNo());
                    restmap.put("out_request_no", alipayResponse.getOutRequestNo());// 退款订单号
                    restmap.put("refund_reason", alipayResponse.getRefundReason()); // 退款原因
                    restmap.put("total_amount", alipayResponse.getTotalAmount());// 订单交易金额
                    restmap.put("refund_amount", alipayResponse.getTotalAmount());// 订单退款金额
                    LOGGER.info("订单退款结果：退款成功");
                } else {
                    LOGGER.info("订单失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (flag) {
            // 订单查询成功
            SimpleResult simpleResult=SimpleResult.success();
            simpleResult.putDataAll(restmap);
            return simpleResult;
        } else { // 订单查询失败
            SimpleResult simpleResult=SimpleResult.error() ;
            simpleResult.putDataAll(restmap);
            return simpleResult;
        }
    }

    /**
     * 订单支付服务器异步通知
     * @param request
     * @param response
     * @测试地址:   https://localhost:8080/GZ/alipay/pay/notify
     */
    @RequestMapping(value = "/pay/notify", method = RequestMethod.POST)
    public void orderPayNotify(HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("[/alipay/pay/notify]");
        LOGGER.info("支付宝支付结果通知" + request.getParameterMap());
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        String trade_status=request.getParameter("trade_status");
        for (Iterator iter = request.getParameterMap().keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) request.getParameterMap().get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
            System.out.println(params);
            //验证签名
            //boolean flag = AlipaySignature.rsaCheckV1(params, AliPayConfig.ALIPAY_PUBLIC_KEY,  AlipayConstants.CHARSET_UTF8,  AlipayConstants.SIGN_TYPE_RSA2);
            boolean flag = AlipaySignature.rsaCheckV1(params, AliPayConfig.ALIPAY_PUBLIC_KEY, AlipayConstants.CHARSET_UTF8,AliPayConfig.SIGN_TYPE);
            if(flag){
                //交易状态: TRADE_SUCCESS-支付成功  TRADE_CLOSED-交易关闭  具体参考:https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7629140.0.0.F5jvqF&treeId=204&articleId=105301&docType=1#s1
                if("TRADE_SUCCESS".equals(params.get("trade_status"))){
                    //付款金额
                    String amount = params.get("buyer_pay_amount");
                    //商户订单号
                    String out_trade_no = params.get("out_trade_no");
                    //支付宝交易号
                    String trade_no = params.get("trade_no");
                    try {

                        HealthyOrder healthyOrdere = healthOrderService.selectOrderById(out_trade_no);
                        if(healthyOrdere!=null && !"".equals(healthyOrdere)){

                            if("1".equals(healthyOrdere.getOrderstate())){
                                //订单状态：待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
                                HealthyOrder healthyOrders = new HealthyOrder();
                                healthyOrders.setId(out_trade_no);
                                healthyOrders.setThirdordercode(trade_no);
                                healthyOrders.setOrderstate("2");
                                healthyOrders.setPaymentmethod("1");
                                healthyOrders.setCreatedate(new Date());
                                healthyOrders.setUpdatedate(new Date());
                                healthyOrders.setCreatename(healthyOrdere.getCreatename());
                                healthyOrders.setUpdatename(healthyOrdere.getUpdatename());
                                healthyOrders.setUsername(healthyOrdere.getUsername());
                                healthOrderService.UpdateOrderAndLog(healthyOrders,"订单付款成功");
                                //订单支付成功后,插入咨询信息
                                Integer count=healthConsultationMapper.selectCountById(out_trade_no);
                                LOGGER.info("支付宝支付结果通知-咨询信息统计: " + count);
                                if(count>0){
                                }else {
                                    LOGGER.info("支付宝支付结果通知-咨询信息保存");
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

                            }
                            //订单支付成功后,发送短信提示 - 订单支付成功后,推送消息
                            //同时给用户-医生-客服发送短信
                            LOGGER.info("支付宝支付结果通知-订单支付成功后,发送短信提示 - 订单支付成功后,推送消息");
                            sendMessageService.SendMeessageOK(out_trade_no);
                        }


                    } catch (Exception e) {
                        LOGGER.error("订单状态修改接口出现异常："+e.getMessage(),e);
                    }
                    LOGGER.info("订单支付成功" );
                //退款 交易关闭
                }else  if("TRADE_CLOSED".equals(params.get("trade_status"))){
                    //商户订单号
                    String out_trade_no = params.get("out_trade_no");
                    //根据订单ID更新订单状态
                    //订单状态：待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
//                    HealthyOrder healthyOrders = new HealthyOrder();
//                    healthyOrders.setId(out_trade_no);
//                    healthyOrders.setOrderstate("5");
//                    healthyOrders.setPaymentmethod("1");
//                    healthOrderService.UpdateOrder(healthyOrders,"订单退款成功!!!!");
                }
            }else {//验证失败
                LOGGER.info("订单支付失败" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
