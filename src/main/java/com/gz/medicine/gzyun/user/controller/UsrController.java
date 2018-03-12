package com.gz.medicine.gzyun.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
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
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.user.mapper.GzLogsMapper;
import com.gz.medicine.gzyun.user.request.RegUserRequest;
import com.gz.medicine.gzyun.user.request.UpDatePwdRequest;
import com.gz.medicine.gzyun.user.request.UpDateRequest;
import com.gz.medicine.gzyun.user.request.UserRegRequest;
import com.gz.medicine.gzyun.user.request.UsrRequest;
import com.gz.medicine.gzyun.user.service.UsrService;

@Controller
@RequestMapping("/gzuser")
public class UsrController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(UsrController.class);

    @Autowired
    private UsrService usrService;


    @Autowired
    Validator validator;


    @Autowired
    GzLogsMapper logsMapper;

    @RequestMapping(value = "/retrieveUserPWD", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult retrieveUserPWD(@Valid UsrRequest usrRequest) {
    	SimpleResult sr=null;
    	String pwd = null;
        try {
        	if(validates(validator, usrRequest)!=null){
        		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, usrRequest));
       	  	}
        	pwd= usrService.retrieveUserPWD(usrRequest);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("pwd", pwd);
        return  sr;
    }

    @RequestMapping(value = "/retrieveUserUUID", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult retrieveUserUUID(@Valid RegUserRequest data) {
    	SimpleResult sr=null;
    	String uuid = null;
        try {
        	if(validates(validator, data)!=null){
        		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
       	  	}
        	uuid= usrService.retrieveUserGzguid(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("uuid", uuid);
        return sr;
    }

    /**
     * @author fendo
     * @Describe 用户注册
     * @param data
     * @return
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult userRegister(@Valid UserRegRequest data) {
    	SimpleResult sr=null;
        try {
        	if(validates(validator, data)!=null){
        		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
       	  	}
    		Map<String, String> params=new HashMap<String, String>();
    		params.put("guid", UUIDTool.getUUID());
    		params.put("phone", data.getPhone());

    		//插入日志
    	    logsMapper.insertGzLogs(params);

    	    //插入数据库
    		usrService.userRegister(data);

			} catch (CommonException e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
			}
	        sr = SimpleResult.success();
	        return sr;
    }

    /**
     * @author fendo
     * @Describe 根据手机号发送验证码
     * @param data
     * @return
     */
    @RequestMapping(value = "/sendAuthCode", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult sendAuthCode(UserRegRequest data) {
    	SimpleResult sr=null;
    	String authCode=null;
		try {
		    authCode=usrService.sendAuthCode(data.getPhone());
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("authCode", authCode);
        return sr;
    }


    /**
     * @author 舵主
     * @Describe 根据GUID修改密码
     * @param data
     * @return
     */
    @RequestMapping(value = "/upGuid", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult updateGuid(UpDatePwdRequest data) {
    	SimpleResult sr=null;
    	String authCode=null;
		try {
			usrService.updateGuidAll(data);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("authCode", authCode);
        return sr;
    }

    /**
     * @author 舵主
     * @Describe 根据手机号修改密码（忘记密码）
     * @param data
     * @return
     */
    @RequestMapping(value = "/upIdPwd", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult updateIdPwd(UpDateRequest data) {
    	SimpleResult sr=null;
    	String authCode=null;
		try {
			usrService.updateIdPwd(data);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("authCode", authCode);
        return sr;
    }


    /**
     * @author 舵主
     * @Describe 根据手机号修改密码（PC端忘记密码）
     * @param data
     * @return
     */
    @RequestMapping(value = "/upIdPwdPC", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult updateIdPwdPC(UpDateRequest data) {
    	SimpleResult sr=null;
    	String authCode=null;
		try {
			usrService.updateIdPwdPC(data);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
        sr = SimpleResult.success();
        sr.putData("authCode", authCode);
        return sr;
    }

}
