package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.reponse.HealthLoginResponse;
import com.gz.medicine.gzyun.health.request.HealthyLoginRequest;
import com.gz.medicine.gzyun.health.service.HealthLoginService;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 登陆
 * jin
 * **/
@Controller
@RequestMapping("/HLogin")
public class HealthLoginController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthLoginController.class);
    
    @Autowired
    private HealthLoginService loginService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/in",method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc(@Valid HealthyLoginRequest data) {
   	SimpleResult sr = null;
   	HealthLoginResponse reponse = new HealthLoginResponse();
		try {
			if (validates(validator, data) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
			}
			reponse = loginService.queryItemByName(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(e.getCode(), e.getDesc());
		}
		sr = SimpleResult.success();
		sr.putData("user", reponse);
		return sr;
    }
    
    
    
    
    
}
