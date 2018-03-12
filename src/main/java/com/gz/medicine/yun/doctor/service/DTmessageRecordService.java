package com.gz.medicine.yun.doctor.service;

import java.util.List;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupTemplate;
import com.gz.medicine.yun.doctor.request.DTfollowupTemplateRequest;
import org.springframework.stereotype.Service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTmessageRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.reponse.DTfollowupRecordResponse;

@Service("dTmessageRecordService")
public interface DTmessageRecordService {
	/**
	 * 短信记录详情
	 *
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	DTmessageRecord selectByPrimaryKey(String guid) throws CommonException;

	/**
	 * 短信记录详情 list
	 *
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	List<DTmessageRecord> selectByGuidKey(String guid) throws CommonException;

	/**
	 * 短信模板 分页 模糊查
	 *
	 * @param page
	 * @return
	 * @throws CommonException
	 */

	SimpleResult queryPageSelectPrimary(PageModel page) throws CommonException;

	/**
	 * 模板新增 短信模板
	 *
	 * @param dTmessageTemplate
	 * @return
	 * @throws CommonException
	 */
	int AddPrimary(DTmessageTemplate dTmessageTemplate) throws CommonException;

	/**
	 * 模板修改 短信模板
	 *
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	int updateByTemplate(DTmessageTemplate record) throws CommonException;

	/**
	 * 查单个 短信模板
	 *
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	// DTmessageTemplateResponse deleteByPrimaryKey(String guid) throws
	// CommonException;

	/**
	 * 假删除 短信模板
	 *
	 * @param
	 * @return
	 * @throws CommonException
	 */
	int deleteByTemplate(DTmessageTemplate record) throws CommonException;

	/**
	 * 视频详情
	 *
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	List<DTfollowupRecordResponse> selectDTfollowupRecord(String guid) throws CommonException;

	/**
	 * 随访记录 列表
	 */
	SimpleResult selectByMessageRecord(PageModel page) throws CommonException;

	/**
	 * 随访记录 列表 pc端
	 */
	SimpleResult queryPageMessageRecord(PageModel page) throws CommonException;

	/**
	 * 随访模板 www
	 *
	 * @param page
	 * @return
	 */
	Page queryPageFollow(PageModel page) throws CommonException;


	/**
	 * 新增 随访模板  www  2017-11-08
	 *
	 * @return
	 * @throws CommonException
	 */
	String insertFollow(DTfollowupTemplateRequest record) throws CommonException;

	/**
	 * 随访模板 修改 www
	 *
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	String updateByPrimaryKeySelective(DTfollowupTemplateRequest record) throws CommonException;


	/**
	 * 假删
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	String updateState(DTfollowupTemplate record) throws CommonException;


}