package com.gz.medicine.yun.bloodpressure.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.bloodpressure.bean.DoctorThrid;
import com.gz.medicine.yun.bloodpressure.service.DoctorThridService;

/**
 * 查询在岗医生 
 * jin
 * **/
@Controller
@RequestMapping("/DoctorThrid")
public class DoctorThridController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(DoctorThridController.class);

    @Autowired
    private DoctorThridService thridService;
    @Autowired
    Validator validator; 
    
    @RequestMapping(value = "/sonlinedoc", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult sdoc() {
    	 SimpleResult sr= new SimpleResult();
         try{
        	 List<DoctorThrid> lists= new ArrayList<DoctorThrid>();
        	 lists=thridService.queryDocin();
             sr=SimpleResult.success();
             sr.put("data",lists);
         }catch (CommonException e){
             LOGGER.error("DoctorThridController异常："+e.getMessage(),e);
             return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
         }
         return sr;
    }
    
}
