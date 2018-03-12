package com.gz.medicine.yun.doctor.controller;
import com.gz.medicine.common.util.ValidateWithException;

import com.gz.medicine.yun.doctor.service.DTDocplService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 业绩考核
 * jin
 * **/
@Controller
@RequestMapping("/Docpl")
public class DTDocplController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DTDocplController.class);
    
    @Autowired
    private DTDocplService docplService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/Select", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(PageModel page) {
    	 SimpleResult simpleResult=null;
         try{

             simpleResult=docplService.queryPageDocpl(page);
         }catch (CommonException e){
             LOGGER.error("DTDocplController异常："+e.getMessage(),e);
             return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
         }
         return  simpleResult;
    }
    

}
