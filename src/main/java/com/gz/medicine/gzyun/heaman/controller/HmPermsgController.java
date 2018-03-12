package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.reponse.HmPermsgReponse;
import com.gz.medicine.gzyun.heaman.request.HmPermsgRequest;
import com.gz.medicine.gzyun.heaman.service.HmPermsgService;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 健康指数
 * jin
 **/
@Controller
@RequestMapping("/permsg")
public class HmPermsgController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmPermsgController.class);
    
    @Autowired
    private HmPermsgService msgService;
    @Autowired
    Validator validator; 
    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/select", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult select(@Valid HmPermsgRequest data ) {
		  SimpleResult sr=null;
		  HmPermsgReponse permsgRep =new HmPermsgReponse();
		  System.out.println(data);
	      try {
	    	  if(validates(validator, data)!=null){
	    		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
	    	  }
	    	  permsgRep = msgService.select(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("permsgRep", permsgRep);
        return  sr;
    }
    
	
}
