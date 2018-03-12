package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.bean.HealthAddrInfo;
import com.gz.medicine.gzyun.health.service.HealthAddrInfoService;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 地址
 * jin
 * **/
@Controller
@RequestMapping("/address")
public class HealthAddrInfoController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthAddrInfoController.class);

	private static final Object HealthAddrInfoRequest = null;
    
    @Autowired
    private HealthAddrInfoService infoService;
    @Autowired
    Validator validator; 
    
    /**
     * 新增地址
     * jin
     * **/
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult insert(@Valid HealthAddrInfo record) {
    	SimpleResult sr = null;
		 try {
      	  if(validates(validator, record)!=null){
        		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
       	  	}
      	infoService.insertSelective(record);
		 } catch (Exception e) {
				LOGGER.error(e);
			}
	          sr = SimpleResult.success();
	          return sr;
    
    }
    
    /**
     * 删除地址
     * jin
     * **/
    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult delete(@Valid HealthAddrInfo record) {
    	SimpleResult sr = null;
		try {
	       	  if(validates(validator, record)!=null){
	         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
	        	  	}
	       	  infoService.deletebuid(record);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          return sr;
    }
    
    
    /**
     * 修改地址
     * jin
     * **/
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult updatebyid(@Valid HealthAddrInfo record) {
    	SimpleResult sr = null;
		try {
	       	  if(validates(validator, record)!=null){
	         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
	        	  	}
	       	  infoService.updatebyid(record);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          return sr;
    }
    
    /**
     * 查询地址
     * jin
     * **/
    @RequestMapping(value = "/select", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult select(@Valid HealthAddrInfo record) {
    	SimpleResult sr = null;
    	List<HealthAddrInfo> list = new ArrayList<HealthAddrInfo>();
		try { 
			if(validates(validator, record)!=null){
  		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record)); 
  	  }
	       	 list=infoService.selectbyuid(record);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          sr.putData("list", list);
		          return sr;
    }
}
