package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.reponse.HmSignReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;
import com.gz.medicine.gzyun.heaman.service.HmSignService;

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


@Controller
@RequestMapping("/Sign")
public class HmSignController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmSignController.class);
    
    @Autowired
    private HmSignService signService;
    @Autowired
    Validator validator; 
    


    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/Select", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult selectSign(@Valid HmHeatRequest data ) {
		  SimpleResult sr=null;
		  List<HmSignReponse> sign =new ArrayList<HmSignReponse>();
		  System.out.println(data);
	      try {
	    	  if(validates(validator, data)!=null){
	    		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
	    	  }
	    	  sign = signService.selectSign(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("sign", sign);
        return  sr;
    }
    
	
}
