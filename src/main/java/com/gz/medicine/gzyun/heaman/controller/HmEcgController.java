package com.gz.medicine.gzyun.heaman.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.heaman.bean.HmEcgabno;
import com.gz.medicine.gzyun.heaman.service.HmEcgService;
import com.gz.medicine.gzyun.heaman.service.HmOrderService;

/**
 * 
 * @Title: HmEcgController.java 
 * @Package com.gz.medicine.gzyun.heaman.controller 
 * @Description: 心电 Controller
 * @Author fendo
 * @Date 2017年8月8日 下午4:44:04 
 * @Version V1.0
 */
@Controller
@RequestMapping(value="hmEcg")
public class HmEcgController {
	
	@Autowired
	HmEcgService hmEcgService;
	
	

	
	/**
	 * 日志对象
	 */
    public static final Logger LOGGER = Logger.getLogger(HmEcgController.class);
    
    
    
    /**
     * 
     *@Title ECGabno 
     *@Description: 心电异常写入
     *@Author fendo
     *@Date 2017年8月8日 下午4:56:03
     *@param data
     *@return
     *@throws
     */
    @RequestMapping(value = "/ECGabno", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
	public SimpleResult ECGabno(String usrguid,String type,String value) {

    	SimpleResult simpleResult= null; 
    	
    	try {
    		simpleResult=hmEcgService.ECGabno(usrguid,type,value);
    		return simpleResult;
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
    	
	}

}
