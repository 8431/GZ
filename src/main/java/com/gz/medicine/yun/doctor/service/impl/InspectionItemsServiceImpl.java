/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.service.impl;

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.gz.medicine.yun.doctor.bean.InspectionItems;
import com.gz.medicine.yun.doctor.service.InspectionItemsService;
import com.gz.medicine.yun.doctor.mapper.InspectionItemsMapper;

/**   
 * @Title: InspectionItemsImpl.java 
 * @Package com.gz.medicine.yun.doctor.serviceImpl
 * @Description: 病历中的-检查项目 ServiceImpl
 * @author fendo
 * @date 2017年12月22日 16时28分09秒 星期五 
 * @version V1.0   
*/
@Service
public class InspectionItemsServiceImpl implements InspectionItemsService{

    public static final Logger LOGGER = Logger.getLogger(InspectionItemsService.class);

	@Autowired
	public InspectionItemsMapper inspectionItemsMapper;

	@Override
	public InspectionItems find(String id) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/find]");
	    InspectionItems inspectionItems;
	    try {
            inspectionItems = inspectionItemsMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("inspectionItems-find()-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-find()-Service层出现异常",e);
        }
		return inspectionItems;
	}

	@Override
	public List<InspectionItems> findList(InspectionItems bean) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/findList]");
	    List<InspectionItems> inspectionItemsList;
	    try {
            inspectionItemsList = inspectionItemsMapper.selectAll(bean);
        }catch (Exception e){
            LOGGER.error("inspectionItems-findList-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-findList()-Service层出现异常",e);
        }
		return inspectionItemsList;
	}

	@Override
	public Page getPage(PageModel page) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/getPage]");
	    Page p=page.getPage();
	    try {
             List<InspectionItems> pageList = inspectionItemsMapper.queryPage(p);
		     p.setParameterType(pageList);
        }catch (Exception e){
            LOGGER.error("inspectionItems-getPage-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-getPage()-Service层出现异常",e);
        }
		return p;
	}

	@Override
	public InspectionItems update(InspectionItems bean) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/update]");
	    try {
           inspectionItemsMapper.updateByPrimaryKeySelective(bean);
        }catch (Exception e){
            LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-update()-Service层出现异常",e);
        }
		return null;
	}

	@Override
	public int insert(InspectionItems bean) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/insert]");
	    int flag;
	    try {
           flag = inspectionItemsMapper.insertSelective(bean);
        }catch (Exception e){
            LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-insert()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int delete(String id) throws CommonException{
	    LOGGER.info("[/InspectionItemsImpl/delete]");
	    int flag;
	    try {
           flag = inspectionItemsMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
            throw  new CommonException("COM001","inspectionItems-delete()-Service层出现异常",e);
        }
		return flag;
	}

	@Override
	public int addInspectionItemsList(List<InspectionItems> inspectionItemsList) throws CommonException {
		try {
			for (InspectionItems inspectionItems : inspectionItemsList) {
				inspectionItemsMapper.insertSelective(inspectionItems);
			}
		}catch (Exception e){
			LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","inspectionItems-delete()-Service层出现异常",e);
		}
		return 0;
	}

	@Override
	public List<InspectionItems> getInspectionItemsList(String sickguid) throws CommonException {
		List<InspectionItems> inspectionItemsList;
		try {
			inspectionItemsList = inspectionItemsMapper.getInspectionItemsList(sickguid);
		}catch (Exception e){
			LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","inspectionItems-delete()-Service层出现异常",e);
		}
		return inspectionItemsList;
	}

	@Override
	public int deleteByInspectionItems(String sickguid) throws CommonException {
		try {
			 inspectionItemsMapper.deleteByInspectionItems(sickguid);
		}catch (Exception e){
			LOGGER.error("inspectionItems-update-Service层出现异常:" + e.getMessage(), e);
			throw  new CommonException("COM001","inspectionItems-delete()-Service层出现异常",e);
		}
		return 0;
	}
}
