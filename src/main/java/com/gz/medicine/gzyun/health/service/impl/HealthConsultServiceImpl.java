package com.gz.medicine.gzyun.health.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.reponse.HealthConsultationReponse;
import com.gz.medicine.gzyun.health.service.HealthConsultService;


/**
 *咨询消息
 *jin
 **/
@Service
public class HealthConsultServiceImpl implements HealthConsultService{


    public static final Logger LOGGER = Logger.getLogger(HealthConsultServiceImpl.class);
    
    @Autowired
    private HealthConsultationMapper conmapper; 
	


	@Override
	public Page queryPageDocid(PageModel page) throws CommonException {
		List<HealthConsultationReponse> reponse = null;
		Page p=page.getPage();
       try {
    	   	reponse = conmapper.queryPageDocid(p);
          	p.setParameterType(reponse);
            long currentServerTimeStamp = new Date().getTime();
           	p.put("currentServerTimeStamp",currentServerTimeStamp);
	} catch (Exception e) {
		// TODO: handle exception
		 throw new CommonException("COM001","HealthConsultServiceImpl异常");
	}
				return p;
}
}