package com.gz.medicine.gzyun.heaman.mapper;


import java.util.Date;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmOrder;

/**
 * 
 * @Title: HmOrderMapper.java 
 * @Package com.gz.medicine.gzyun.heaman.mapper 
 * @Description: 订单接口
 * @Author fendo
 * @Date 2017年8月7日 上午10:59:10 
 * @Version V1.0
 */
public interface HmOrderMapper {
	
    int deleteByPrimaryKey(String guid);

    int insert(HmOrder record);

    int insertSelective(HmOrder record);

    HmOrder selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmOrder record);

    int updateByPrimaryKey(HmOrder record);
    
    
    /**
     * 
     *@Title updateByUsrguIdAndOrderId 
     *@Description: 根据UserguId和OrderId修改CLORDERNOTE,CLORDERDAT
     *@Author fendo
     *@Date 2017年8月7日 下午3:46:31
     *@param record
     *@return int
     *@throws
     */
    int updateByUsrguIdAndOrderId(HmOrder record);
    
    /**
     * 
     *@Title getByUsrguIdAndOrderId 
     *@Description: 根据UserguId和OrderId获取订单
     *@Author fendo
     *@Date 2017年8月7日 下午3:45:46
     *@param record
     *@return HmOrder
     *@throws
     */
    HmOrder getByUsrguIdAndOrderId(HmOrder record);
    
    
    /**
     * 
     *@Title getByUsrGuidAsOrdercrtdatDesc 
     *@Description: 根据Usrguid按Ordercrtdat降序
     *@Author fendo
     *@Date 2017年8月8日 下午3:05:24
     *@param usrguid
     *@return List
     *@throws
     */
    List<HmOrder> getByUsrGuidAsOrdercrtdatDesc(String usrguid);

    /**
     * 
     *@Title selectCountByUsrguIdAndOrderId 
     *@Description: 根据UserguId和OrderId统计数量
     *@Author fendo
     *@Date 2017年8月7日 下午3:44:08
     *@param record
     *@return int
     *@throws
     */
    int selectCountByUsrguIdAndOrderId(HmOrder record);
    
    /**
     * 
     *@Title getByUsrguIdAndOrderTypeDesc 
     *@Description: 根据UserguId,和OrderType小于2条件,按OrderType降序
     *@Author fendo
     *@Date 2017年8月8日 下午2:45:29
     *@param record
     *@return HmOrder
     *@throws
     */
    HmOrder getByUsrguIdAndOrderTypeDesc(HmOrder record);
     
    /**
     * 
     *@Title getByOrderId 
     *@Description: 根据订单ID获取订单
     *@Author fendo
     *@Date 2017年8月10日 下午3:47:22
     *@param orderid
     *@return HmOrder
     *@throws
     */
    HmOrder getByOrderId(String orderid);
    
    /**
     * 
     *@Title getSumByOrderId 
     *@Description: 根据订单ID求和
     *@Author fendo
     *@Date 2017年8月10日 下午3:54:12
     *@param orderid
     *@return int
     *@throws
     */
    int getSumByOrderId(String orderid);
    
    /**
     * 
     *@Title updateMedatByOrderId 
     *@Description: 根据orderid修改支付时间
     *@Author fendo
     *@Date 2017年8月10日 下午4:00:39
     *@param orderid
     *@return
     *@throws
     */
    int updateMedatByOrderId(String orderid);
    
    /**
     * 订单支付接口  
     * 舵主
     * @param record
     * @return
     */
    int updateByPrimaryKeyZhifu(HmOrder record);
    
    /**
     * 查询系统时间
     * 舵主
     * @return
     */
    Date selectSysdate();
    
    /**
     * 根据订单编号查询数据
     * 舵主
     * @return
     */
    int selectCount(String orderid);

}