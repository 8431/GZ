package com.gz.medicine.gzyun.health.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.reponse.HealthLoginResponse;
import com.gz.medicine.gzyun.health.request.HealthyLoginRequest;
import com.gz.medicine.gzyun.health.request.HealthyUsrRequest;


/**
 * 登录
 * jin
 * **/


@Service("loginService")
public interface HealthLoginService {
	
	
	HealthLoginResponse queryItemByName(HealthyLoginRequest data) throws CommonException;
    
	String updateItemById(HealthyUsrRequest data) throws CommonException; 
   
}
