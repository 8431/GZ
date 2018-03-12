package com.gz.medicine.gzyun.push.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.user.request.PushRequest;

/**
 * @Title PushMessageService
 * @Description 消息推送的Service
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
public interface PushMessageService {

    /**
     * @Description 消息推送插入
     * @param pushRequest
     * @return
     * @throws CommonException
     */
    int insertPushMessage(PushRequest pushRequest) throws CommonException;


    /**
     * @Description 向指定设备推送消息
     * @param pushRequest
     * @return
     * @throws CommonException
     */
    String PushMessage(PushRequest pushRequest) throws CommonException;

    /**
     * @Description 向指定设备推送消息--订单支付成功后
     * @param healthyOrder
     * @return
     * @throws CommonException
     */
    String PushMessageEquipmentOK(HealthyOrder healthyOrder) throws CommonException;

    /**
     * @Description 向指定设备推送消息--订单取消后
     * @param userid
     * @return
     * @throws CommonException
     */
    String PushMessageEquipmentCancel(String userid) throws CommonException;

    /**
     * @Description 向指定设备推送消息--订单退款后
     * @param healthyOrder
     * @return
     * @throws CommonException
     */
    String PushMessageEquipmentRefunds(HealthyOrder healthyOrder) throws CommonException;

    /**
     * 定时任务扫描-推送
     * @param healthyOrder , pushMessage
     * @return
     * @throws CommonException
     */
    String PushMessageTask(HealthyOrder healthyOrder, String pushMessage , String typeContent,String flag)throws CommonException;

    /**
     * 定时任务---订单超时，超时没支付，推送消息
     * @return
     * @throws CommonException
     */
    String PushMessageTimeoutOrder(HealthyOrder healthyOrder)throws CommonException;

    /**
     * 定时任务--订单过期,1小时,按预约开始时间来算,给患者推送消息
     * @return
     * @throws CommonException
     */
    String PushMessageOutDateOrder(HealthyOrder healthyOrder)throws CommonException;


    boolean SendHoursPushAndMessage()throws Exception;

}
