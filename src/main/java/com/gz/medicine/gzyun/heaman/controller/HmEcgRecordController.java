package com.gz.medicine.gzyun.heaman.controller;
import com.gz.medicine.common.util.ValidateWithException;


import com.gz.medicine.gzyun.heaman.bean.HmEcgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmEcgReponse;
import com.gz.medicine.gzyun.heaman.request.HmEcgRequest;
import com.gz.medicine.gzyun.heaman.service.HmEcgRecordService;

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
 * 心电接口
 * 舵主
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/gzyunHmEcg")
public class HmEcgRecordController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmEcgRecordController.class);
    
    @Autowired
    private HmEcgRecordService hmEcgService;
    @Autowired
    Validator validator; 
    
    /**
     * 对外暴露的心电测量数据新增接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzHmAddEcg", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult addEcg(@Valid HmEcgRequest data ) {
    	  SimpleResult sr=null;
    	  String code = null;
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  code= hmEcgService.addEcg(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("code", code); 
        return  sr;
    }

    
    
    /**
     * 对外暴露的心电查询接口
     * @param data
     * @return
     */
    @RequestMapping(value = "/gzHmSelEcg", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult selEcg(String usrguid ) {
    	  SimpleResult sr=null;
    	 List<HmEcgReponse> listEcg = null;
          try {
        	  if(validates(validator, usrguid)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, usrguid)); 
        	  }
        	  listEcg= hmEcgService.selEcg(usrguid);// userService.queryUser(data);
		} catch (Exception e) {
			LOGGER.error(e);
		}
            sr = SimpleResult.success(); 
            sr.putData("listEcg", listEcg); 
        return  sr;
    }

	
}
