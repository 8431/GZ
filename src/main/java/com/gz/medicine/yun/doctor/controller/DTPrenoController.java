package com.gz.medicine.yun.doctor.controller;
import com.gz.medicine.common.util.ValidateWithException;

import com.gz.medicine.yun.doctor.service.DTPrenoService;

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
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 *线上预约
 * jin
 * **/
@Controller
@RequestMapping("/Docpre")
public class DTPrenoController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DTPrenoController.class);

   @Autowired
   DTPrenoService prenoService;
   @Autowired
    Validator validator;
    @RequestMapping(value = "/On", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(PageModel page) {
    	 SimpleResult simpleResult=null;
         try{
             simpleResult=prenoService.queryPagePreno(page);
         }catch (CommonException e){
             LOGGER.error("DTPrenoController异常："+e.getMessage(),e);
             return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
         }
         return  simpleResult;
    }
    
	
}
