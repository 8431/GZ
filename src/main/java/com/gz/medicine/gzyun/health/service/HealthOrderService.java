package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.bean.OrderLog;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthOrderService
 * @PackageName com.gz.medicine.gzyun.health.service
 * @Description 订单
 * @Data 2017-09-21 10:47
 **/
public interface HealthOrderService {

    /**
     * 插入订单并记录日志
     * @param healthyOrder
     * @return
     * @throws CommonException
     */
    OrderLog insertAndLog(HealthyOrder healthyOrder)throws CommonException;

    /**
     * 更新订单并记录日志
     * @param healthyOrder
     * @return
     * @throws CommonException
     */
    OrderLog UpdateOrderAndLog(HealthyOrder healthyOrder, String healthMessage) throws CommonException;


    /**
     * 根据订单ID获取订单
     * @param orderid
     * @return
     * @throws Exception
     */
    HealthyOrder selectOrderById(String orderid) throws CommonException;

    /**
     * 更新订单
     * @param healthyOrder
     * @return
     * @throws CommonException
     */
    int updateByPrimaryKeySelective(HealthyOrder healthyOrder) throws  CommonException;


    /**
     * 根据订单ID获取退款详情
     * @param orderid
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> GetOrderEetails(String orderid)throws CommonException;

    /**
     * 获取所有今天的订单
     * @return
     * @throws CommonException
     */
    List<HealthyOrder> selectByOrderList() throws CommonException;


    /**
     * 超时没支付(30分钟未支付)
     * @return
     * @throws CommonException
     */
    List<HealthyOrder> TimeoutOrderList(String currentTime) throws CommonException;

    /**
     * 订单已过期(1小时)
     * @return
     * @throws CommonException
     */
    List<HealthyOrder> OutDateOrderList(String currentTime) throws CommonException;

    /**
     * 医生24小时未回复
     * @return
     * @throws CommonException
     */
    List<HealthyOrder> OutDateOrderRefundList(String currentTime) throws CommonException;

    /**
     * 前5分钟
     * @return
     * @throws CommonException
     */
    List<HealthyOrder> MinutesOrderList(String currentTime) throws CommonException;

    List<HealthyOrder> SendHoursPushAndMessage(String state) throws CommonException;

}
