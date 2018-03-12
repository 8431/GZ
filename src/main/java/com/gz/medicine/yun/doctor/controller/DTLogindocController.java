package com.gz.medicine.yun.doctor.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmBlgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmBloReponse;
import com.gz.medicine.gzyun.heaman.request.HmBloRequest;
import com.gz.medicine.gzyun.heaman.service.HmBloService;
import com.gz.medicine.yun.doctor.reponse.DTdocReponse;
import com.gz.medicine.yun.doctor.request.DTdocRequest;
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
 * 登陆
 * jin
 * **/
@Controller
@RequestMapping("/Login")
public class DTLogindocController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DTLogindocController.class);
    
    @Autowired
    private DTDocService docService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/doc", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(@Valid DTdocRequest data) {
   	SimpleResult sr = null;
		DTdocReponse reponse = new DTdocReponse();
		try {
			if (validates(validator, data) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
			}
			reponse = docService.select(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		sr = SimpleResult.success();
		sr.putData("user", reponse);
		return sr;
    }
    
    
    
    
    
}
