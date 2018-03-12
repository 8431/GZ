package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;


import com.gz.medicine.gzyun.heaman.reponse.HmHeatReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;
import com.gz.medicine.gzyun.heaman.service.HmHeatService;

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
@RequestMapping("/yunHeat")
public class HmHeatController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmHeatController.class);
    
    @Autowired
    private HmHeatService heatService;
    @Autowired
    Validator validator; 
    
    /**
     * 体温写入
     * jin
     * **/
    @RequestMapping(value = "/Inheat", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult heamanblg(@Valid HmHeatRequest data, BindingResult result ) {
    	  SimpleResult sr=null;
    	  int s = 0;
    	  System.out.println(data);
          try {
        	  if(result.hasErrors()){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  s= heatService.insertHeat(data);
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
    
    @RequestMapping(value = "/Sheat", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sheat(@Valid HmHeatRequest data ) {
		  SimpleResult sr=null;
		  List<HmHeatReponse> heat =new ArrayList<HmHeatReponse>();
		  System.out.println(data);
	      try {
	    	  if(validates(validator, data)!=null){
	    		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
	    	  }
	    	  heat = heatService.queryHeat(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("heat", heat);
        return  sr;
    }
    
	
}
