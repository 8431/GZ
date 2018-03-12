package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.request.HmSqueRequest;
import com.gz.medicine.gzyun.heaman.service.HmSqueService;

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

/**
 * 问卷信息写入
 * jin
 * **/
@Controller
@RequestMapping("/yunSque")
public class HmSqueController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmSqueController.class);
    
    @Autowired
    private HmSqueService squeService;
    @Autowired
    Validator validator; 
    
    
    @RequestMapping(value = "/Sque", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult heamansque(@Valid HmSqueRequest data ) {
    	  SimpleResult sr=null;
    	  int s = 0;
    	  System.out.println(data);
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  s= squeService.insertSque(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("s", s); 
        return  sr;
    }


	
}
