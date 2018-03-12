package com.gz.medicine.gzyun.health.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.mapper.healthevaluateMapper;
import com.gz.medicine.gzyun.health.reponse.HealthEvaluteResponse;
import com.gz.medicine.gzyun.health.service.HealthEvaluateService;


/**
 *查询评价
 *jin
 **/
@Service
public class HealthEvaluateServiceImpl implements HealthEvaluateService{


    public static final Logger LOGGER = Logger.getLogger(HealthEvaluateServiceImpl.class);
    
    @Autowired
    private healthevaluateMapper evamapper; 
	

	@Override
	public Page queryPageMyid(PageModel page) throws CommonException {
			Page p=page.getPage();
	        List<HealthEvaluteResponse> reponse= null;
	        try {
	            evamapper.updatIsread(p);
	        	reponse = evamapper.queryPageMyid(p);
	        	p.setParameterType(reponse);
	        	
	        } catch (Exception e) {
	            LOGGER.error("HealthEvaluateServiceImpl异常："+e.getMessage(),e);
	            throw new CommonException("COM001","HealthEvaluateServiceImpl异常");        }
	        return p;
	    }

}