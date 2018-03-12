package com.gz.medicine.yun.common.service;

import com.gz.medicine.common.exception.CommonException;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName SendMessageService
 * @PackageName com.gz.medicine.yun.common.service
 * @Description 短信发送
 * @Data 2017-11-1 13:50
 **/
public interface SendMessageService {

    /**
     * 订单支付成功
     * 根据订单ID,获取订单信息,然后发送短信
     * @param orderid
     * @return
     * @throws CommonException
     */
    boolean SendMeessageOK(String orderid) throws CommonException;

    /**
     * 订单支付取消
     * 根据订单ID,获取订单信息,然后发送短信
     * @param orderid
     * @return
     * @throws CommonException
     */
    boolean SendMeessageCancel(String orderid) throws CommonException;

    /**
     * 订单支付退款
     * 根据订单ID,获取订单信息,然后发送短信
     * @param orderid
     * @return
     * @throws CommonException
     */
    boolean SendMeessageRefunds(String orderid) throws CommonException;

    /**
     * 定时任务--订单开始前5分钟,根据订单ID,获取订单后,然后发送短信
     * @param orderid
     * @return
     * @throws CommonException
     */
    boolean SendMessageTaskBegin(String orderid) throws CommonException;


    /**
     * 定时任务--订单过期,根据订单ID,获取订单后,然后发送短信
     * @param orderid
     * @return
     * @throws CommonException
     */
    boolean SendMessageTaskOutDate(String orderid) throws CommonException;

}
