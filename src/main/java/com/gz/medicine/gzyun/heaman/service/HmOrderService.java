package com.gz.medicine.gzyun.heaman.service;



import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.heaman.bean.HmOrder;
import com.gz.medicine.gzyun.heaman.request.HmOrderRequest;

/**
 * 
 * @Title: HmOrderService.java 
 * @Package com.gz.medicine.gzyun.heaman.service 
 * @Description: 订单 接口
 * @Author fendo
 * @Date 2017年8月4日 下午4:39:45 
 * @Version V1.0
 */
public interface HmOrderService {

	/**
	 * 
	 *@Title getOrderByUserId 
	 *@Description: 根据用户编号(USRID)查询订单
	 *@Author fendo
	 *@Date 2017年8月4日 下午4:42:04
	 *@param data
	 *@return String
	 *@throws CommonException
	 */
	List<Map> getOrderByUserId(HmOrder data)throws CommonException;
	
	
	/**
	 * 
	 *@Title writeCancelByUCO 
	 *@Description: 根据Usrguid,clordernote,orderid取消详情写入
	 *@Author fendo
	 *@Date 2017年8月7日 下午3:13:28
	 *@param data
	 *@return String
	 *@throws CommonException
	 */
	SimpleResult writeCancelByUCO(String usrguid,String orderid,String clordernote)throws CommonException;
	
	
	/**
	 * 
	 *@Title GetDetailsRefund 
	 *@Description: 根据Usrguid,orderid,获取订单退款详情
	 *@Author fendo
	 *@Date 2017年8月8日 上午10:08:57
	 *@param data
	 *@return SimpleResult
	 *@throws CommonException
	 */
	SimpleResult GetDetailsRefund(HmOrder data)throws CommonException;
	
	
	/**
	 * 
	 *@Title Paidstatus 
	 *@Description: 根据Usrguid返回付费状态
	 *@Author fendo
	 *@Date 2017年8月8日 下午2:38:40
	 *@param data
	 *@return
	 *@throws CommonException
	 *@throws
	 */
	SimpleResult Paidstatus(HmOrder data)throws CommonException;
	
	/**
	 * 
	 *@Title AddOrder 
	 *@Description: 根据OrderId,Type,Spbillid生成订单接口
	 *@Author fendo
	 *@Date 2017年8月8日 下午1:46:18
	 *@param data
	 *@return SimpleResult
	 *@throws CommonException
	 */
	SimpleResult AddOrder(String orderId,String type,String spbillid,HttpServletRequest request)throws CommonException;
	
	/**
	 * 订单支付接口  
	 * 舵主
	 * @param data
	 * @return
	 * @throws CommonException
	 */
	void updateOrder(HmOrderRequest data)throws CommonException;
	
	
	/**
	 * 获取系统当前时间
	 * 舵主
	 * @return
	 * @throws CommonException
	 */
	String selectSysdate() throws CommonException;
	
	
	/**
	 * 根据订单编号查询数据
	 * 舵主
	 * @return
	 * @throws CommonException
	 */
	int selectCount(String orderid) throws CommonException;
	
}
