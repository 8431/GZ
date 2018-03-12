package com.gz.medicine.yun.common.service;

import com.gz.medicine.common.exception.CommonException;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName WechatPayService
 * @PackageName com.gz.medicine.yun.common.service
 * @Description 微信支付 Service
 * @Data 2017-11-1 13:50
 **/
public interface WechatPayService {

    /**
     * 订单退款
     * @param tradeno
     * @param orderid
     * @return
     */
	boolean orderPayRefund(String tradeno, String orderid) throws CommonException;

}
