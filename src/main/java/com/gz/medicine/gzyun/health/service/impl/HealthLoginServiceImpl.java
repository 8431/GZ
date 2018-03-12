package com.gz.medicine.gzyun.health.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;

import com.gz.medicine.gzyun.health.bean.HealthyLogin;
import com.gz.medicine.gzyun.health.mapper.HealthyLoginMapper;
import com.gz.medicine.gzyun.health.reponse.HealthLoginResponse;
import com.gz.medicine.gzyun.health.request.HealthyLoginRequest;
import com.gz.medicine.gzyun.health.request.HealthyUsrRequest;
import com.gz.medicine.gzyun.health.service.HealthLoginService;


/**
 *登录
 *jin
 **/
@Service
public class HealthLoginServiceImpl implements HealthLoginService{


    public static final Logger LOGGER = Logger.getLogger(HealthLoginServiceImpl.class);
    
    @Autowired
    private HealthyLoginMapper loginmapper; 
	
    @Override
	public HealthLoginResponse queryItemByName(HealthyLoginRequest data) throws CommonException {
    	HealthyLogin log = new HealthyLogin();
    	HealthLoginResponse reponse = new HealthLoginResponse();
		try {
			log = loginmapper.queryItemByName(data);
			if(log != null){
				BeanUtils.copyProperties(log,reponse);
				String usrpw = data.getPassword();//前端传来密码
				String passwd = log.getPassword();//数据库查出的密码
				if(passwd.equals(usrpw)){
					return reponse;
				}else{					
					throw new CommonException("001","用户名或密码错误!");	
				}
			}else{
				throw new CommonException("001", "用户名或密码错误!!");
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("001", "用户名或密码错误!!!", e);
		}
	}

	@Override
	public String updateItemById(HealthyUsrRequest data) throws CommonException {
		String oldpa = data.getOldPass();//前端传来的旧密码
		String newpa = data.getNewPass();//前端传来的新密码
		String password = loginmapper.queryItemById(data);//数据库查出的密码
		try {
			if(oldpa.equals(password)){
				HealthyLogin log = new HealthyLogin();
				log.setId(data.getId());
				log.setPassword(data.getNewPass());
				loginmapper.updateItemById(log);
				return "密码修改成功！";
			}else{
				return "旧密码输入错误！";
				
			}

		} catch (Exception e) {
			throw new CommonException("COM001","在修改密码方法中出错",e);
		}
   

}
}