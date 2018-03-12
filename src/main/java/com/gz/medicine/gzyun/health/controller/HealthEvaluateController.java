package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.service.HealthEvaluateService;

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
 * 评论查询
 * jin
 * **/
@Controller
@RequestMapping("/Heva")
public class HealthEvaluateController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthEvaluateController.class);
    
    @Autowired
    private HealthEvaluateService evaService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/query", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(PageModel page) {
    	 SimpleResult simpleResult=null;
    	 Page response = null;
         try{

        	 response= evaService.queryPageMyid(page);
        	 simpleResult = SimpleResult.success(); 
        	 simpleResult.put("data", response);
         }catch (CommonException e){
             LOGGER.error("HealthEvaluateController异常："+e.getMessage(),e);
             return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
         }
         return  simpleResult;
    }
    
    
    
    
}
