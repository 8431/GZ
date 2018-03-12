package com.gz.medicine.gzyun.health.controller;
import com.gz.medicine.common.util.ValidateWithException;

import com.gz.medicine.gzyun.health.request.HealthyUsrRequest;
import com.gz.medicine.gzyun.health.service.HealthLoginService;


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

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;

/**
 * 修改密码
 * jin
 * **/
@Controller
@RequestMapping("/Upass")
public class HealthUppassController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HealthUppassController.class);
    
    @Autowired
    private HealthLoginService logService;
    @Autowired
    Validator validator; 
    
    /**
     * 密码修改
     * jin
     * **/
    @RequestMapping(value = "/Upda", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult uppass(@Valid HealthyUsrRequest data) {
    	  SimpleResult sr=null;
    	  String message = null;
    	  String code=null;
    	try {
    		 if(validates(validator, data)!=null){
       		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
       	  }
    		 message = logService.updateItemById(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
    	
    	if("密码修改成功！".equals(message)){
    		code="000";
    	}else{
    		code="001";
    	}
    	if(code=="000"){
    		List<Map> me=new ArrayList<Map>();
    		Map<String,String> sm=new HashMap<String,String>();
    		sm.put("message", message);
    		me.add(sm);
    		
    		Map<String, Object> maps=new HashMap<String,Object>();
    		maps.put("data", me);
    		sr =new SimpleResult();
    		sr.put("code", code);
    		sr.putAll(maps);
    		sr.put("message", "成功！");
    		
    	}else{
    		List<Map> me=new ArrayList<Map>();
    		Map<String,String> sm=new HashMap<String,String>();
    		sm.put("message", message);
    		me.add(sm);
    		
    		sr =new SimpleResult();
    		sr.put("code", code);
    		sr.put("message", message);
    		
    	}
		
//    	 sr = SimpleResult.success(); 
//         sr.putData("message",message); 
         return  sr;
    }


    
    
}
