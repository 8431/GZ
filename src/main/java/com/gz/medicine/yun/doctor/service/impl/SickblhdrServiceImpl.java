/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.service.impl;

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.BeanUtil;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.doctor.bean.DTsickbldtl;
import com.gz.medicine.yun.doctor.mapper.DTsickbldtlMapper;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequest;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequestList;
import com.gz.medicine.yun.doctor.request.SickbldtlRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.gz.medicine.yun.doctor.bean.Sickblhdr;
import com.gz.medicine.yun.doctor.service.SickblhdrService;
import com.gz.medicine.yun.doctor.mapper.SickblhdrMapper;

/**   
 * @Title: SickblhdrImpl.java 
 * @Package com.gz.medicine.yun.doctor.serviceImpl
 * @Description: 病历表 ServiceImpl
 * @author fendo
 * @date 2017年12月22日 10时23分36秒 星期五 
 * @version V1.0   
*/
@Service
public class SickblhdrServiceImpl implements SickblhdrService{

    public static final Logger LOGGER = Logger.getLogger(SickblhdrService.class);

	@Autowired
	public SickblhdrMapper sickblhdrMapper;

	//药品接口
	@Autowired
	private DTsickbldtlMapper dTsickbldtlMapper;


	@Override
	public Sickblhdr find(String id) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/find]");
	    Sickblhdr sickblhdr;
	    try {
            sickblhdr = sickblhdrMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("sickblhdr-find()-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-find()-Service层出现异常",e);
        }
		return sickblhdr;
	}

	@Override
	public List<Sickblhdr> findList(Sickblhdr bean) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/findList]");
	    List<Sickblhdr> sickblhdrList;
	    try {
            sickblhdrList = sickblhdrMapper.selectAll(bean);
        }catch (Exception e){
            LOGGER.error("sickblhdr-findList-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-findList()-Service层出现异常",e);
        }
		return sickblhdrList;
	}

	@Override
	public Page getPage(PageModel page) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/getPage]");
	    Page p=page.getPage();
	    try {
             List<Sickblhdr> pageList = sickblhdrMapper.queryPage(p);
		     p.setParameterType(pageList);
        }catch (Exception e){
            LOGGER.error("sickblhdr-getPage-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-getPage()-Service层出现异常",e);
        }
		return p;
	}

	@Override
	public Sickblhdr update(Sickblhdr bean) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/update]");
	    try {
           sickblhdrMapper.updateByPrimaryKeySelective(bean);
        }catch (Exception e){
            LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-update()-Service层出现异常",e);
        }
		return null;
	}

	@Override
	public int insert(Sickblhdr bean) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/insert]");
	    int flag;
	    try {
           flag = sickblhdrMapper.insertSelective(bean);
        }catch (Exception e){
            LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-insert()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int delete(String id) throws CommonException{
	    LOGGER.info("[/SickblhdrImpl/delete]");
	    int flag;
	    try {
           flag = sickblhdrMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","sickblhdr-delete()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int addRegimenList(List<SickbldtlRequest> sickbldtlRequest) throws CommonException {
		int flag = 0;
		//用药方案
		for (SickbldtlRequest request : sickbldtlRequest) {
			//用药方案
			DTsickbldtl dTsickbldtl=new DTsickbldtl();
			dTsickbldtl.setGuid(UUIDTool.getUUID());
			BeanUtils.copyProperties(request,dTsickbldtl);
			flag = dTsickbldtlMapper.insert(dTsickbldtl);
		}
		return flag;
	}

	@Override
	public int insertDTsickbldtl(DTsickbldtl dtsickbldtl) throws CommonException {
		try {
			dTsickbldtlMapper.insertSelective(dtsickbldtl);
		}catch (Exception e){
			LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","sickblhdr-delete()-Service层出现异常",e);
		}
		return 0;
	}

	@Override
	public int updateDTsickbldtl(DTsickbldtl dtsickbldtl) throws CommonException {
		try {
			dTsickbldtlMapper.updateDTsickbldtl(dtsickbldtl);
		}catch (Exception e){
			LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","sickblhdr-delete()-Service层出现异常",e);
		}
		return 0;
	}

	@Override
	public int deleteDTsickbldtl(String sickguid) throws CommonException {
		try {
			dTsickbldtlMapper.deleteDTsickbldtl(sickguid);
		}catch (Exception e){
			LOGGER.error("sickblhdr-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","sickblhdr-delete()-Service层出现异常",e);
		}
		return 0;
	}
}
