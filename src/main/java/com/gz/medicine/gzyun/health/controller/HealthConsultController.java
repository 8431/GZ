package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;
import com.gz.medicine.gzyun.health.service.HealthConsultService;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 咨询消息
 * jin
 * **/
@Controller
@RequestMapping("/Con")
public class HealthConsultController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthConsultController.class);
    
    @Autowired
    private HealthConsultService conService;
    @Autowired
    private HealthConsultationService consult;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/select", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(PageModel page) {
    	 SimpleResult simpleResult=null;
    	 Page response = null;
         try{

        	 response= conService.queryPageDocid(page);
        	 simpleResult = SimpleResult.success(); 
        	 simpleResult.put("data", response);
         }catch (CommonException e){
             LOGGER.error("HealthConsultController异常："+e.getMessage(),e);
             return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
         }
         return  simpleResult;
    }
    
    
    /**
     * 点击咨询消息触发消除未读以及判断当前时间是否在订单时间内
     * 
     * **/
    @RequestMapping(value = "/upd", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult updateandselect(@Valid HealthConsultation data) {
    	SimpleResult sr = null;
    	String dta = null;
		try {	
	           dta = consult.updateMess(data);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          sr.put("data", dta);
		          return sr;
    }
    
}
