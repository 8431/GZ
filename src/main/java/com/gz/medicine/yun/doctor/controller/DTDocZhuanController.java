package com.gz.medicine.yun.doctor.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmBlgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmBloReponse;
import com.gz.medicine.gzyun.heaman.request.HmBloRequest;
import com.gz.medicine.gzyun.heaman.service.HmBloService;
import com.gz.medicine.yun.doctor.service.DTDocService;

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
 * 转诊
 * jin
 * **/
@Controller
@RequestMapping("/DocZ")
public class DTDocZhuanController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DTDocZhuanController.class);

    @Autowired
    private DTDocService docService;
    @Autowired
    Validator validator; 
    
    
    
    @RequestMapping(value = "/Zhuan", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
 
    	/**
         * @author jin
         * 分页查询在岗医生  
         **/

        public SimpleResult sdoc(PageModel page) {
        	 SimpleResult simpleResult=null;
             try{
                 simpleResult=docService.queryPageDocin(page);
             }catch (CommonException e){
                 LOGGER.error("DTLogindocController异常："+e.getMessage(),e);
                 return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
             }
             return  simpleResult;
        }
    
}
        
    
    
    

