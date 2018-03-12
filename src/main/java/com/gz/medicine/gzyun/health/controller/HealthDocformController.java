package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.reponse.HealthDocformResponse;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;
import com.gz.medicine.gzyun.health.service.HealthDocformService;

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

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 排班查询
 * jin
 * **/
@Controller
@RequestMapping("/Dform")
public class HealthDocformController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthDocformController.class);
    
    @Autowired
    private HealthDocformService formService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/select",method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(@Valid HealthyDocformRequest data) {
   	SimpleResult sr = null;
   	List<HealthDocformResponse> reponse = new ArrayList<HealthDocformResponse>();
		try {
			if (validates(validator, data) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
			}
			reponse = formService.queryItemDocId(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		sr = SimpleResult.success();
		sr.putData("list", reponse);
		return sr;
    }
    /**
     * 修改为停诊
     * 
     * **/
    @RequestMapping(value = "/update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult updatebyid( HealthyDocformRequest data) {
    	SimpleResult sr = null;
    	String dta = null;
		try {
	       	  if(validates(validator, data.getId())!=null){
	         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data.getId()));
	        	  	}
	           dta = formService.update(data);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          sr.put("data", dta);
		          return sr;
    }
    
    /**
     * 排班预约管理查询所有医生当天排班
     * **/
    @RequestMapping(value = "/qbydate",method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult querybydate(@Valid PageModel page) {
   	SimpleResult sr = null;

		try {
			sr = formService.querybyDdoc(page);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		return sr;
    }
    
    
    /**
     * 排班预约管理查询单个医生当天排班
     * **/    
    @RequestMapping(value = "/qbyone",method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult querybyone(@Valid PageModel page) {
   	SimpleResult sr = null;
 
		try {
			
			sr = formService.querybyDdocOne(page);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		return sr;
    }
    /**
     * 查询修改状态为停诊的个数
     * **/    
    @RequestMapping(value = "/querst",method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult queryStateId(@Valid HealthyDocformRequest data) {
   	SimpleResult sr = new SimpleResult();
		try {
			int a = formService.queryStateId(data);
			sr = SimpleResult.success();
			sr.putData("number", a);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		return sr;
    }
    
}
