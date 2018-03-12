package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.bean.OrderLog;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthOrderServiceImpl
 * @PackageName com.gz.medicine.gzyun.health.service.impl
 * @Description 订单
 * @Data 2017-09-21 10:47
 **/
@Service
public class HealthOrderServiceImpl implements HealthOrderService {

    public static final Logger LOGGER = Logger.getLogger(HealthOrderServiceImpl.class);

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;

    @Autowired
    private HealthConsultationMapper healthConsultationMapper;

    @Override
    public OrderLog UpdateOrderAndLog(HealthyOrder healthyOrder,String healthMessage) throws CommonException {
        LOGGER.info("[HealthOrderServiceImpl/UpdateOrderAndLog] healthyOrder :" + healthyOrder);
        Map<String,String> maps = null;
        OrderLog og = new OrderLog();
        og.setCreatename(healthyOrder.getUsername());
        og.setUpdatename(healthyOrder.getUpdatename());
        og.setId(UUIDTool.getUUID());
        og.setOrderid(healthyOrder.getId());
        og.setOrderstate(healthyOrder.getOrderstate());
        og.setOperatingtime(new Date());
        og.setUpdatedate(healthyOrder.getUpdatedate());
        og.setOperationcontent(healthMessage);//操作内容
        try {
            healthyOrderMapper.updateByPrimaryKeySelective(healthyOrder);
        }catch (Exception e){
            LOGGER.error("订单提交Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "订单提交Server层异常:", e);
        }
        return og;
    }

    @Override
    public HealthyOrder selectOrderById(String orderid) throws CommonException {
        HealthyOrder healthyOrder;
        try {
            healthyOrder = healthyOrderMapper.selectOrderById(orderid);
        }catch (Exception e){
            LOGGER.error("根据订单ID获取订单失败!!!" + e.getMessage(), e);
            throw  new CommonException("COMMON",e.getMessage());
        }
        return healthyOrder;
    }

    @Override
    public int updateByPrimaryKeySelective(HealthyOrder healthyOrder) throws CommonException {
        int flag = 0;
        try {
            flag = healthyOrderMapper.updateByPrimaryKeySelective(healthyOrder);
        }catch (Exception e){
            LOGGER.error("更新订单失败!!!" + e.getMessage(), e);
            throw  new CommonException("COMMON",e.getMessage());
        }
        return flag;
    }

    @Override
    public List<Map<String, Object>> GetOrderEetails(String orderid) throws CommonException {
        List<Map<String, Object>> mapList;
        try {
            mapList = healthyOrderMapper.selectByOrderLogId(orderid);
        }catch (Exception e){
            LOGGER.error("获取订单退款详情失败!!!" + e.getMessage(), e);
            throw  new CommonException("COMMON",e.getMessage());
        }
        return mapList;
    }

    @Override
    public List<HealthyOrder> selectByOrderList() throws CommonException {
        List<HealthyOrder> healthyOrderList = null;
        try {
            healthyOrderList = healthyOrderMapper.selectByOrderList();
        }catch (Exception e){
            LOGGER.error("获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public List<HealthyOrder> TimeoutOrderList(String currentTime) throws CommonException {
        List<HealthyOrder> healthyOrderList = null;
        try {
            healthyOrderList = healthyOrderMapper.TimeoutOrderList(currentTime);
        }catch (Exception e){
            LOGGER.error("获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public List<HealthyOrder> OutDateOrderList(String currentTime) throws CommonException {
        List<HealthyOrder> healthyOrderList;
        try {
            healthyOrderList = healthyOrderMapper.OutDateOrderList(currentTime);
        }catch (Exception e){
            LOGGER.error("获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public List<HealthyOrder> OutDateOrderRefundList(String currentTime) throws CommonException {
        List<HealthyOrder> healthyOrderList = null;
        try {
            healthyOrderList = healthyOrderMapper.OutDateOrderRefundList(currentTime);
        }catch (Exception e){
            LOGGER.error("获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public List<HealthyOrder> MinutesOrderList(String currentTime) throws CommonException {
        List<HealthyOrder> healthyOrderList;
        try {
            healthyOrderList = healthyOrderMapper.MinutesOrderList(currentTime);
        }catch (Exception e){
            LOGGER.error("获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public List<HealthyOrder> SendHoursPushAndMessage(String state) throws CommonException {
        List<HealthyOrder> healthyOrderList;
        try {
            healthyOrderList = healthyOrderMapper.selectByStateList(state);
        }catch (Exception e){
            LOGGER.error("根据订单状态获取订单列表失败!!!" + e.getMessage(), e);
            throw  new CommonException("001","获取订单列表失败");
        }
        return healthyOrderList;
    }

    @Override
    public OrderLog insertAndLog(HealthyOrder healthyOrder) throws CommonException {
        OrderLog og = new OrderLog();
        //BeanUtils.copyProperties(healthyOrder, og);
        og.setId(UUIDTool.getUUID());
        og.setOrderid(healthyOrder.getId());
        og.setCreatedate(healthyOrder.getCreatedate());
        og.setCreatename(healthyOrder.getCreatename());
        og.setUpdatename(healthyOrder.getUpdatename());
        og.setOrderstate(healthyOrder.getOrderstate());
        og.setOperatingtime(new Date());
        og.setUpdatedate(healthyOrder.getUpdatedate());
        og.setOperationcontent("开始下订单");//操作内容
        try {
            healthyOrderMapper.insert(healthyOrder);
        }catch (Exception e){
            LOGGER.error("订单提交Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "订单提交Server层异常:", e);
        }
        return og;
    }



}
