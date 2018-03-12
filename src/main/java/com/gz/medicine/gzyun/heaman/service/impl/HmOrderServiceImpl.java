package com.gz.medicine.gzyun.heaman.service.impl;

import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.BeanUtils;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.common.util.IPUtils;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.heaman.bean.HmOrder;
import com.gz.medicine.gzyun.heaman.mapper.HmOrderMapper;
import com.gz.medicine.gzyun.heaman.request.HmOrderRequest;
import com.gz.medicine.gzyun.heaman.service.HmOrderService;

/**
 * 
 * @Title: HmOrderServiceImpl.java 
 * @Package com.gz.medicine.gzyun.heaman.service.impl 
 * @Description: 订单 接口实现类
 * @Author fendo
 * @Date 2017年8月4日 下午4:43:55 
 * @Version V1.0
 */
@Service
public class HmOrderServiceImpl implements HmOrderService {

	
	@Autowired
	HmOrderMapper hmOrderMapper;
	
	/**
	 * 日志对象
	 */
    public static final Logger LOGGER = Logger.getLogger(HmOrderServiceImpl.class);
	
	@Override
	public List<Map> getOrderByUserId(HmOrder data) throws CommonException {
		
		List<Map> resultMap=new ArrayList<Map>();

	
		try {
			List<HmOrder> listHmOrder=hmOrderMapper.getByUsrGuidAsOrdercrtdatDesc(data.getUsrguid());
			if(listHmOrder.size()>0) {
				for (HmOrder hmOrder : listHmOrder) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("ORDERID", hmOrder.getOrderid());
					map.put("ORDERNAME", hmOrder.getOrdername());
					map.put("ORDERMON", hmOrder.getOrdermon().toString());
					String ORDERCRTDAT=hmOrder.getOrdercrtdat().toString();
					map.put("ORDERCRTDAT", ORDERCRTDAT.substring(0, 10));
					map.put("ORDERTYPE", hmOrder.getOrdertype());
					resultMap.add(map);
					
				}
				return resultMap;
			}else {
				throw new CommonException("COM001","没有您的订单");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CommonException("COM001","查询用户订单错误",e);
		}
		
		
	}

	@Override
	public SimpleResult writeCancelByUCO(String usrguid,String orderid,String clordernote) throws CommonException {
		
		SimpleResult simpleResult=null;
		int count=0;
		HmOrder hmOrder=null;
		String orderType=null;
		
		
    	if(!StringUtils.isNotBlank(usrguid)){
    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "Usrguid不能为空！");
   	  	}
    	
    	if(!StringUtils.isNotBlank(orderid)) {
    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "Orderid不能为空！");
    	}
		
    	if(!StringUtils.isNotBlank(clordernote)) {
    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "Clordernote不能为空！");	
    	}	
		
    	HmOrder data=new HmOrder();
    	data.setUsrguid(usrguid);
    	data.setOrderid(orderid);
    	data.setClorderdat(clordernote);
		
		//防止乱输入数据导致执行SQL报错
		try {
			//根据UserguId和OrderId统计数量
			count=hmOrderMapper.selectCountByUsrguIdAndOrderId(data);
			//根据UserguId和OrderId获取订单
			hmOrder=hmOrderMapper.getByUsrguIdAndOrderId(data);
			
			//获取订单类型
			orderType=hmOrder.getOrdertype();
		} catch (Exception e) {
			LOGGER.error(e);
			throw new CommonException("COM001","对不起没有找到当前数据!!");
		}
		
	
		if(count>0) {
			
			Date currentTime=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			data.setClorderdat(formatter.format(currentTime));
			
			//未支付  修改状态为5 取消订单
			if("0".equals(orderType)) {
				try {
					data.setOrdertype("5");
					hmOrderMapper.updateByUsrguIdAndOrderId(data);
				} catch (Exception e) {
					LOGGER.error(e);
					throw new CommonException("COM001","订单修改操作失败!!");
				}
			}
			//支付成功  修改状态为2 
			if("1".equals(orderType)) {
				try {
					data.setOrdertype("2");
					hmOrderMapper.updateByUsrguIdAndOrderId(data);

				} catch (Exception e) {
					LOGGER.error(e);
					throw new CommonException("COM001","订单修改操作失败!!");
				}
			}

			simpleResult=SimpleResult.success();
			return simpleResult;
			
		}
		simpleResult=SimpleResult.success();
		return simpleResult;
	}

	@Override
	public SimpleResult GetDetailsRefund(HmOrder data) throws CommonException {
		
		SimpleResult simpleResult=null;
		
		try {
			if(!StringUtils.isNotBlank(data.getUsrguid())) {
	    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "usrguid不能为空！");	
			}
			
			if(!StringUtils.isNotBlank(data.getOrderid())) {
	    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "orderid不能为空！");	
			}
			
			HmOrder hmOrder=hmOrderMapper.getByUsrguIdAndOrderId(data);
			if(hmOrder!=null) {
				Map<String, String> map=new HashMap<String,String>();
				map.put("ORDERMON", hmOrder.getOrdermon().toString());
				map.put("CLORDERDAT", hmOrder.getClorderdat());
				map.put("ORDERTYPE", hmOrder.getOrdertype());
				map.put("REVIEWDAT", hmOrder.getReviewdat());
				map.put("REFUNDSDAT ", hmOrder.getRefundsdat());
				
				simpleResult=SimpleResult.success();
				simpleResult.putDataAll(map);
				return simpleResult;
			}else {
	    		return SimpleResult.error(SimpleCode.ERROR.getCode(), "此订单不存在！");	
			}
				
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "此订单不存在！");	
		}

		
		
	}

	@Override
	public SimpleResult AddOrder(String orderId,String type,String spbillid,HttpServletRequest request) throws CommonException {
		
		
		try {
			
			//如果IP为空,就从请求中获取IP
			if("".equals(spbillid)) {
				spbillid=IPUtils.getIpAddr(request);
			}
						
			if(StringUtils.isNotBlank(orderId) && StringUtils.isNotBlank(type)) {
				
				//根据订单id获取订单
				HmOrder hmOrder=hmOrderMapper.getByOrderId(orderId);
				
				//根据订单id求和
				int sum=hmOrderMapper.getSumByOrderId(orderId);
				
				//类型 1支付宝 2 微信
				if("2".equals(type)) {
					//根据orderid修改支付时间
					int status=hmOrderMapper.updateMedatByOrderId(orderId);
				}
				
				
				//调用微信支付接口
				
				
				return SimpleResult.success();
			}
				
			return SimpleResult.error("001", "传过来的数据不能为空");

			
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error("001", "发生错误");
		}
		
	}

	@Override
	public SimpleResult Paidstatus(HmOrder data) throws CommonException {
		
		SimpleResult simpleResult=null;
		HmOrder hmOrder=null;
		
		if(!StringUtils.isNotBlank(data.getUsrguid())) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "请登入您的账号！");	
		}
		
		try {
			data.setOrdertype("2");
			hmOrder=hmOrderMapper.getByUsrguIdAndOrderTypeDesc(data);
			if(hmOrder!=null) {
				Map<String, String> map=new HashMap<String,String>();
				simpleResult=new SimpleResult(hmOrder.getOrdertype(),"支付状态 0 未支付 1已支付");
				//map.put("stat", hmOrder.getOrdertype());
				simpleResult.putAll(map);
				return simpleResult;
			}
			
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "付费失败！");	
			
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "进入请求付费状态报错！");	
		}
		
	}

	
	
	/**
	 * 订单支付接口 
	 * 舵主
	 */
	@Override
	public void updateOrder(HmOrderRequest data) throws CommonException {
		HmOrder source = new HmOrder();
		try {
			if(data.getOrderid()!=null&&data.getMeofpay()!=null){
				// 判断支付方式
				if(data.getMeofpay()=="1"){
					data.setMeofpay("支付宝");
				}if(data.getMeofpay()=="2"){
					data.setMeofpay("微信");
				}if(data.getMeofpay()=="3"){
					data.setMeofpay("网银");
				}
				// 获取系统当前时间用于支付时间
				String date = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
				// 根据订单编号查询数据库 
				Double cnt =Double.valueOf(selectCount(data.getOrderid()));
				// 根据订单编号查询
				if(cnt!=0){ // 不为空，只进行修改
					data.setMedat(date);// 加入查询出来的系统当前时间
					data.setOrdertype("1");
					
					BeanUtils.copyProperties(data, source);
					hmOrderMapper.updateByPrimaryKeyZhifu(source);
				}else{// 为空抛出异常
					throw new  CommonException("COM001","订单编号不存在");
				}
			}else{
				throw new  CommonException("COM001","传过来的数据不能为空");
			}
		} catch (Exception e) {
			throw new  CommonException("COM001","在订单支付接口中，发生错误",e);
		}
		
		
	}

	
	/**
	 * 获取系统当前时间
	 * 舵主
	 */
	@Override
	public String selectSysdate() throws CommonException {
		Date date = hmOrderMapper.selectSysdate();
		String dateString = DateUtils.formatDateTime(date);
		return dateString;
	}

	
	/**
	 * 根据订单编号查询数据
	 * 舵主
	 */
	@Override
	public int selectCount(String orderid) throws CommonException {
		int count =hmOrderMapper.selectCount(orderid);
		return count;
	}

	

	
	
}
