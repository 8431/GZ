package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmTxpRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmTxpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmEcgRequest;
import com.gz.medicine.gzyun.heaman.request.HmTxpRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmTxpRecordService;

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

/**
 * 尿酸接口控制层
 * 
 * 舵主
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/gzyunHmTxp")
public class HmTxpRecordController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmTxpRecordController.class);
    
    @Autowired
    private HmTxpRecordService hmTxpService;
    @Autowired
    Validator validator; 
    
    /**
     * 对外暴露的尿酸测量数据新增接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzyunAddTxp", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult addEcg(@Valid HmTxpRecordRequest data ) {
    	  SimpleResult sr=null;
    	  String code = null;
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  code= hmTxpService.addTxp(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("code", code); 
        return  sr;
    }

    
    
    /**
     * 对外暴露的尿酸查询接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzyunSelTxp", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult selEcg(String usrguid ) {
    	  SimpleResult sr=null;
    	  List<HmTxpRecordReponse> listReponse = new ArrayList<HmTxpRecordReponse>();
    	  List<HmTxpRecord> list = null;
          try {
        	  if(validates(validator, usrguid)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, usrguid)); 
        	  }
        	  
        	  listReponse= hmTxpService.selTxp(usrguid);// userService.queryUser(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("listReponse", listReponse); 
        return  sr;
    }

	
}
