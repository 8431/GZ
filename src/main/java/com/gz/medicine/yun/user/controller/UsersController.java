package com.gz.medicine.yun.user.controller;
import com.google.gson.Gson;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.ValidateWithException;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.yun.doctor.bean.Diagnosis;
import com.gz.medicine.yun.user.bean.Usr;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.user.request.SelUserRequest;
import com.gz.medicine.yun.user.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/yunUser")
public class UsersController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(UsersController.class);
    
    @Autowired
    private UserService userService;
    @Autowired
    Validator validator; 
    
    @RequestMapping(value = "/yunGetUser", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult user(@Valid SelUserRequest data ) {
    	  SimpleResult sr=null;
    	  String pwd = null;
          try {
        	  if(validates(validator, data)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
        	  }
        	  pwd= userService.queryUser(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc()); 
		}
        sr = SimpleResult.success(); 
        sr.putData("pwd", pwd); 
        return  sr;
    }

    /**
     *
     *@Title findById
     *@Description: 根据ID获取用户
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二
     *@param id(主键)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/yunUser/findById?id=xxxx
     */
    @RequestMapping(value="findById",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult findById(String id,String institutionsId){
        LOGGER.info("[/DiagnosisController/findById]");
        SimpleResult simpleResult;
        Usr usr;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            if(StringUtils.isEmpty(id)){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "用户ID不能为空!!");
            }
            usr = userService.findById(id);
            simpleResult.put("data",usr);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    public static void main(String[] args) {
        String re="{'data':{'name':'200.00'}}";
        Gson gn=new Gson();
        Map<String,String> mp=gn.fromJson(re, Map.class);
    }

    

}
