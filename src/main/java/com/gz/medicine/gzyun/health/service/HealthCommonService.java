package com.gz.medicine.gzyun.health.service;

import java.util.Map;

import com.gz.medicine.common.exception.CommonException;

/**
 * 
 * @author zhao
 *
 */
public interface HealthCommonService {
	
	public Map<String,Object> querySystemTime() throws CommonException;

}
