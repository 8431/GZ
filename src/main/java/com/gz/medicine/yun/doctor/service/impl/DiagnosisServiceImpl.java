/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.service.impl;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.bean.Diagnosis;
import com.gz.medicine.yun.doctor.bean.Diagnosisrecords;
import com.gz.medicine.yun.doctor.service.DiagnosisService;
import com.gz.medicine.yun.doctor.mapper.DiagnosisMapper;

/**   
 * @Title: DiagnosisImpl.java 
 * @Package com.gz.medicine.yun.doctor.serviceImpl
 * @Description: 诊断表 ServiceImpl
 * @author fendo
 * @date 2017年12月26日 12时18分34秒 星期二 
 * @version V1.0   
*/
@Service
public class DiagnosisServiceImpl implements DiagnosisService{

    public static final Logger LOGGER = Logger.getLogger(DiagnosisService.class);

	@Autowired
	public DiagnosisMapper diagnosisMapper;

	@Override
	public Diagnosis find(String id) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/find]");
	    Diagnosis diagnosis;
	    try {
            diagnosis = diagnosisMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("diagnosis-find()-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-find()-Service层出现异常",e);
        }
		return diagnosis;
	}

	@Override
	public List<Diagnosis> findList(Diagnosis bean) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/findList]");
	    List<Diagnosis> diagnosisList;
	    try {
            diagnosisList = diagnosisMapper.selectAll(bean);
        }catch (Exception e){
            LOGGER.error("diagnosis-findList-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-findList()-Service层出现异常",e);
        }
		return diagnosisList;
	}

	@Override
	public Page getPage(PageModel page) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/getPage]");
	    Page p=page.getPage();
	    try {
             List<Diagnosis> pageList = diagnosisMapper.queryPage(p);
		     p.setParameterType(pageList);
        }catch (Exception e){
            LOGGER.error("diagnosis-getPage-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-getPage()-Service层出现异常",e);
        }
		return p;
	}

	@Override
	public Diagnosis update(Diagnosis bean) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/update]");
	    try {
           diagnosisMapper.updateByPrimaryKeySelective(bean);
        }catch (Exception e){
            LOGGER.error("diagnosis-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-update()-Service层出现异常",e);
        }
		return null;
	}

	@Override
	public int insert(Diagnosis bean) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/insert]");
	    int flag;
	    try {
           flag = diagnosisMapper.insertSelective(bean);
        }catch (Exception e){
            LOGGER.error("diagnosis-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-insert()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int delete(String id) throws CommonException{
	    LOGGER.info("[/DiagnosisImpl/delete]");
	    int flag;
	    try {
           flag = diagnosisMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("diagnosis-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","diagnosis-delete()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public  Page queryPagelike(PageModel page) throws CommonException {
		LOGGER.info("[/DiagnosisImpl/like]");
		List<Map<String, Object>> mapList;
		Page p = page.getPage();
		try {
			mapList = diagnosisMapper.queryPagelike(p);
			p.setParameterType(mapList);
		}catch (Exception e){
			LOGGER.error("diagnosis-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","diagnosis-delete()-Service层出现异常",e);
		}
		return p;
	}

	@Override
	public List<Diagnosisrecords> getZdMessage(String sickid) throws CommonException {
		List<Diagnosisrecords> diagnosisRecordsList;
        try {
        	diagnosisRecordsList = diagnosisMapper.queryAll(sickid);
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return diagnosisRecordsList;
	}
}
