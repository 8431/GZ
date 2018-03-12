package com.gz.medicine.yun.bloodpressure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.bloodpressure.bean.DoctorThrid;

@Service("DoctorThridService")
public interface DoctorThridService {
	  
    /**
     * 查询在岗医生，@jin
     * @return
     * @throws CommonException
     */
	List<DoctorThrid> queryDocin() throws CommonException;

}
