package com.gz.medicine.yun.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.AliPayUtil;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.yun.common.config.AliPayConfig;
import com.gz.medicine.yun.common.service.AlipayService;
import com.gz.medicine.yun.doctor.controller.DTCaseHistoryController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName AlipayServiceImpl
 * @PackageName com.gz.medicine.yun.common.service.impl
 * @Description 支付宝支付 Service impl
 * @Data 2017-08-17 10:47
 **/
@Service("alipayService")
public class AlipayServiceImpl implements AlipayService {

    public static final Logger LOGGER = Logger.getLogger(AlipayServiceImpl.class);

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;

    @Override
    public boolean orderPayRefund(String tradeno, String orderid) throws CommonException {

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

                        LOGGER.info("订单退款结果：退款成功");
                           return flag;
                    } else {
                        LOGGER.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                        return flag;
                    }
                }
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
        }

//        if (flag) {
//            // 订单查询成功
//        } else { // 订单查询失败
//        }

        return flag;
    }
}
