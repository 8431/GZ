package com.gz.medicine.yun.bloodpressure.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.bloodpressure.bean.DoctorThrid;
import com.gz.medicine.yun.bloodpressure.mapper.DoctorThridMapper;
import com.gz.medicine.yun.bloodpressure.service.DoctorThridService;

@Service
public class DoctorThridServiceImpl implements DoctorThridService {

    public static final Logger LOGGER = Logger.getLogger(DoctorThridServiceImpl.class);
    
    @Autowired
    private DoctorThridMapper mapper;
	
    /**
     * @author jin
     * 查询在岗医生
     * **/
	@Override
	public List<DoctorThrid> queryDocin() throws CommonException {
        List<DoctorThrid> lists= new ArrayList<DoctorThrid>();
        try {
            lists = mapper.queryById();
        } catch (Exception e) {
            LOGGER.error("DoctorThridServiceImpl异常："+e.getMessage(),e);
            throw new CommonException("COM001","DoctorThridServiceImpl异常");        
        }
        return lists;
    }

}