package com.gz.medicine.yun.doctor.mapper;

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;

public interface DTmessageTemplateMapper {
	/**
	 * 查单个
	 * 
	 * @param guid
	 * @return
	 */
	int deleteByPrimaryKey(String guid);

	int insert(DTmessageTemplate record);

	int insertSelective(DTmessageTemplate record);

	DTmessageTemplate selectByPrimaryKey(String guid);

	int updateByPrimaryKeySelective(DTmessageTemplate record);

	int updateByPrimaryKey(DTmessageTemplate record);

	/**
	 * 短信模板 模糊查询 名称
	 * 
	 * @return
	 */
	List<DTmessageTemplate> selectPrimary(String templatename);

	/**
	 * 短信模板 模糊查询 名称 分页
	 * 
	 * @return
	 */
	List<DTmessageTemplate> queryPageSelectPrimary(Page pm) throws CommonException;

	/**
	 * 新增
	 * 
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	int insertTemplate(DTmessageTemplate record) throws CommonException;

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	int updateByTemplate(DTmessageTemplate record) throws CommonException;

	/**
	 * 假删除
	 * 
	 * @param
	 * @return
	 * @throws CommonException
	 */
	int deleteByTemplate(DTmessageTemplate record) throws CommonException;
	
	
	/**
	 * 根据医生usrguid随访任务加载短信详情
	 * 
	 * @author 舵主 下午3:57:54
	 */
	List<DTmessageTemplate> loadDetails(String docguid);

}