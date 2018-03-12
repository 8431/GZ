package com.gz.medicine.yun.bloodpressure.service;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.bloodpressure.request.BloodPressureRequest;

@Service("bloodPressureService")
public interface BloodPressureService {
	
     String saveBloodPressureInfo(BloodPressureRequest data) throws CommonException;

     /**
      * 保存上传数据
      * @param data
      * @return
      * @throws CommonException
      */
     String saveUpload(BloodPressureRequest data)throws CommonException;
}
