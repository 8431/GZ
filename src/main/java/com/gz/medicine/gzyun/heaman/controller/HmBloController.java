package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmBlgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmBloReponse;
import com.gz.medicine.gzyun.heaman.request.HmBloRequest;
import com.gz.medicine.gzyun.heaman.service.HmBloService;

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
@RequestMapping("/Blglu")
public class HmBloController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmBloController.class);
    
    @Autowired
    private HmBloService bloService;
    @Autowired
    Validator validator; 
    
    /**
     * 血糖写入
     * jin
     * **/
    @RequestMapping(value = "/Inblg", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult heamanblg(@Valid HmBloRequest data ) {
    	  SimpleResult sr=null;
    	  int s = 0;
    	  System.out.println(data);
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  s= bloService.insertBlo(data);
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
    
    @RequestMapping(value = "/Sblo", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sblo(@Valid HmBloRequest data ) {
		  SimpleResult sr=null;
		  List<HmBloReponse> blo =new ArrayList<HmBloReponse>();
		  System.out.println(data);
	      try {
	    	  if(validates(validator, data)!=null){
	    		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
	    	  }
	    	  blo = bloService.queryBlo(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("blo", blo);
        return  sr;
    }
    
	
}
