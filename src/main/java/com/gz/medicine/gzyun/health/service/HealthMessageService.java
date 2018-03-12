package com.gz.medicine.gzyun.health.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.request.HealthmessageRequest;


/**
 * 发送短信
 * **/


@Service("messageService")
public interface HealthMessageService {
	
	/**
	 * 随访任务发送短信
	 * @author 舵主
	 * 下午4:00:48
	 */
	 String queryIdByOrder (HealthmessageRequest record) throws CommonException;

	
   
}
