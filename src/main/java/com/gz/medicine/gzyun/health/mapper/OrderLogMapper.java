package com.gz.medicine.gzyun.health.mapper;

import java.util.List;
import java.util.Map;

import com.gz.medicine.gzyun.health.bean.OrderLog;
import com.gz.medicine.gzyun.health.reponse.HealthLogIdReponse;
import com.gz.medicine.gzyun.health.request.HealthOrderMakeUpdateRequest;

public interface OrderLogMapper {
    int insert(OrderLog record);

    int insertSelective(OrderLog record)throws Exception;;
    
    /**
     * 查询订单日志
     * @author 舵主
     *
     * 下午6:27:54
     */
    List<HealthLogIdReponse> queryItemByIdSelLog(String orderid)throws Exception;
    
    
    /**
     * 新增订单日志
     * @author 舵主
     *
     * 下午6:27:54
     */
    int insertItemByIdSelLog(HealthOrderMakeUpdateRequest logaa)throws Exception;

    /**
     * 查询订单最新的日志
     * @param orderid
     * @return
     * @throws Exception
     */
    OrderLog queryOrderLogByOrderId(String orderid)throws Exception;

    /**
     * 查询患者
     * @param usrid
     * @return
     * @throws Exception
     */
    Map<String,Object>  queryUsrById(String usrid);


}