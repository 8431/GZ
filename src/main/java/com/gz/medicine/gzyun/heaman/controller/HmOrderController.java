package com.gz.medicine.gzyun.heaman.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmOrder;
import com.gz.medicine.gzyun.heaman.request.HmOrderRequest;
import com.gz.medicine.gzyun.heaman.service.HmOrderService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Title: HmOrderController.java 
 * @Package com.gz.medicine.gzyun.heaman.controller 
 * @Description: 订单 Controller
 * @Author fendo
 * @Date 2017年8月4日 下午4:32:26 
 * @Version V1.0
 */
@Controller
@RequestMapping(value="hmorder")
public class HmOrderController extends ValidateWithException{

	
	@Autowired
	HmOrderService hmOrderService;
	
    @Autowired
    Validator validator; 
    
	
	/**
	 * 日志对象
	 */
    public static final Logger LOGGER = Logger.getLogger(HmOrderController.class);

    

    
    /**
     * 
     *@Title GetIndentList 
     *@Description: 根据用户编号(USRID)查询订单列表
     *@Author fendo
     *@Date 2017年8月4日 下午5:12:31
     *@param data
     *@param errors
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "/getIndentList", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
	public SimpleResult GetIndentList(String usrguid) {
		
    	SimpleResult simpleResult= null;
		List<Map> resultMap = null;
		try {
			
				
	        	if(!StringUtils.isNotBlank(usrguid)){
	        		return SimpleResult.error(SimpleCode.ERROR.getCode(), "usrguid不能为空！");
	       	  	}
				
	        	HmOrder data=new HmOrder();
	        	data.setUsrguid(usrguid);
				resultMap = hmOrderService.getOrderByUserId(data);

		
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
		simpleResult=new SimpleResult("000","成功");
		simpleResult.put("data", resultMap);
		return simpleResult;
	}
    
    
    /**
     * 
     *@Title WriteCancel 
     *@Description: 取消详情写入
     *@Author fendo
     *@Date 2017年8月7日 下午2:31:45
     *@param data
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "/writeCancel", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult WriteCancel(String usrguid,String orderid,String clordernote) {
    	
    	SimpleResult resultMap=null;
		try {

	        	
			resultMap = hmOrderService.writeCancelByUCO(usrguid,orderid,clordernote);
			return resultMap;

		
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
    	
		
    	
    }
    
    
    /**
     * 
     *@Title GetDetailsRefund 
     *@Description: 退款详情
     *@Author fendo
     *@Date 2017年8月8日 上午10:05:13
     *@param data
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "/getDetailsRefund", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetDetailsRefund(String userguid,String orderid) {
    	SimpleResult resultMap=null;
    	try {
    		HmOrder data=new HmOrder();
    		data.setUsrguid(userguid);
    		data.setOrderid(orderid);
    		resultMap=hmOrderService.GetDetailsRefund(data);
    		return resultMap;
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
    	
    	
    }
   
    
    /**
     * 
     *@Title Paidstatus 
     *@Description: 付费状态
     *@Author fendo
     *@Date 2017年8月8日 下午2:33:34
     *@return SimpleResult  返回 0 未支付 1已支付
     *@throws
     */
    @RequestMapping(value = "/paidstatus", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult Paidstatus(String usrguid) {
    	SimpleResult simpleResult= null;
    	try {
    		HmOrder data=new HmOrder();
    		data.setUsrguid(usrguid);
    		simpleResult=hmOrderService.Paidstatus(data);
    		return simpleResult;
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
    	
    }
    
    /**
     * 
     *@Title AddOrder 
     *@Description: 生成订单
     *@Author fendo
     *@Date 2017年8月8日 下午2:29:59
     *@param data
     *@return SimpleResult
     *@throws
     */
   @RequestMapping(value = "/addOrder", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
   @ResponseBody
   public SimpleResult AddOrder(String orderid,String type,String spbillid,HttpServletRequest request) {
	   
	    SimpleResult simpleResult=null;
	   
		try {
			
			simpleResult=hmOrderService.AddOrder(orderid,type,spbillid,request);
			return simpleResult;
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
   }
    
   
   /***
    * 订单支付接口
    * 舵主
    * @param data
    * @return
 * @throws CommonException 
    */ 
   @RequestMapping(value = "/upOrderfund", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
   @ResponseBody
   public SimpleResult updateOrder(HmOrderRequest data) {
   		SimpleResult resultMap=null;
   		try {
   			hmOrderService.updateOrder(data);
   		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
   		resultMap = SimpleResult.success(); 
        return  resultMap;
   }
}
