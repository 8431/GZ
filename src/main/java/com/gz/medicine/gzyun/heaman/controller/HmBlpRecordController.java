package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;

import com.gz.medicine.gzyun.heaman.reponse.HmBlpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmBlpRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmBlpRecordService;

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

/**
 * 血压接口控制层
 * 
 * 舵主
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/gzyunHmBlp")
public class HmBlpRecordController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmBlpRecordController.class);
    
    @Autowired
    private HmBlpRecordService hmBlpRecordService;
    @Autowired
    Validator validator; 
    
    /**
     * 对外暴露的血压数据新增接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzyunAddBlp", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult addBlp(@Valid HmBlpRecordRequest data ) {
    	  SimpleResult sr=null;
    	  String code = null;
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  code= hmBlpRecordService.addBlp(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("code", code); 
        return  sr;
    }

    
    
    /**
     * 对外暴露的血压查询接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzyunSelBlp", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult selBlp(String usrguid ) {
    	  SimpleResult sr=null;
    	 List<HmBlpRecordReponse> listEcg = null;
          try {
        	  if(validates(validator, usrguid)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, usrguid)); 
        	  }
        	  listEcg= hmBlpRecordService.selBlp(usrguid);// userService.queryUser(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("listEcg", listEcg); 
        return  sr;
    }

	
}
