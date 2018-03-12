package com.gz.medicine.yun.bloodpressure.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.bloodpressure.bean.BloodPressure;
import com.gz.medicine.yun.bloodpressure.mapper.BloodPressureMapper;
import com.gz.medicine.yun.bloodpressure.request.BloodPressureRequest;
import com.gz.medicine.yun.bloodpressure.service.BloodPressureService;


@Service
public class BloodPressureServiceImpl implements BloodPressureService {
    
    @Autowired
    private BloodPressureMapper bloodPressureMapper;

	public String saveBloodPressureInfo(BloodPressureRequest data) throws CommonException {
	//	JSONObject jsonData = JSON.parseObject(data);
		BloodPressure bean=new BloodPressure();
		BeanUtils.copyProperties(data, bean);
		bean.setGuid(UUIDTool.getUUID());
		bean.setCreatedate(new Date());
		int count=bloodPressureMapper.insertSelective(bean);
		return String.valueOf(count);
	}

	@Override
	public String saveUpload(BloodPressureRequest data) throws CommonException {
		BloodPressure bean=new BloodPressure();
		BeanUtils.copyProperties(data, bean);
		bean.setGuid(UUIDTool.getUUID());
		bean.setCreatedate(new Date());
		int count=bloodPressureMapper.insertSelective(bean);
		return String.valueOf(count);
	}


}
