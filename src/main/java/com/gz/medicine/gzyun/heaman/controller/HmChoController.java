package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.reponse.HmChoReponse;
import com.gz.medicine.gzyun.heaman.request.HmChoRequest;
import com.gz.medicine.gzyun.heaman.service.HmChoService;

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
@RequestMapping("/HmCho")
public class HmChoController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmChoController.class);
    
    @Autowired
    private HmChoService choService;
    @Autowired
    Validator validator; 
    
    /**
     * 胆固醇写入
     * jin
     * **/
    @RequestMapping(value = "/Incho", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult insert(@Valid HmChoRequest data, BindingResult result ) {
    	  SimpleResult sr=null;
    	  int s = 0;
    	  System.out.println(data);
          try {
        	  if(result.hasErrors()){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  s= choService.insert(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("s", s); 
        return  sr;
    }


    
    
    	/**
    	 * 查询
    	 * 
    	 * **/
    
    @RequestMapping(value = "/Scho", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult queryCho(@Valid HmChoRequest data ) {
		  SimpleResult sr=null;
		  List<HmChoReponse> cho =new ArrayList<HmChoReponse>();
		  System.out.println(data);
	      try {
	    	  if(validates(validator, data)!=null){
	    		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
	    	  }
	    	 cho = choService.queryCho(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("cho", cho);
        return  sr;
    }
    
	
}
