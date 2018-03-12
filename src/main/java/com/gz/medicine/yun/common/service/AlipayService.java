package com.gz.medicine.yun.common.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;

import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName AlipayService
 * @PackageName com.gz.medicine.yun.common.service
 * @Description 支付宝支付 Service
 * @Data 2017-08-17 10:47
 **/
public interface AlipayService {

    /**
     * 订单退款
     * @param tradeno
     * @param orderid
     * @return
     */
   boolean orderPayRefund(String tradeno, String orderid)throws CommonException;
}
