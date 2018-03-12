package com.gz.medicine.gzyun.health.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.service.HealthCommonService;

@Service("HealthCommonService")
public class HealthCommonServiceImpl implements HealthCommonService {

	@Override
	public Map<String,Object> querySystemTime() throws CommonException {
		Map<String,Object> map = new HashMap<String, Object>();
		String systemTime = System.currentTimeMillis() + "";
		map.put("systemTime", systemTime);
		return map;
	}

}
