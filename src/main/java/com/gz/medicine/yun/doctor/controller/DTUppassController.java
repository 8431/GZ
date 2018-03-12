package com.gz.medicine.yun.doctor.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.request.DTusrRequest;
import com.gz.medicine.yun.doctor.service.DTUsrService;

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


@Controller
@RequestMapping("/Uppass")
public class DTUppassController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DTUppassController.class);
    
    @Autowired
    private DTUsrService usrService;
    @Autowired
    Validator validator; 
    
    /**
     * 密码修改
     * jin
     * **/
    @RequestMapping(value = "/Update", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult uppass(@Valid DTusrRequest data) {
    	  SimpleResult sr=null;
    	  String message = null;
    	try {
    		 if(validates(validator, data)!=null){
       		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
       	  }
    		 message = usrService.update(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
    	 sr = SimpleResult.success(); 
         sr.putData("message",message); 
         return  sr;
    }


    
    
}
