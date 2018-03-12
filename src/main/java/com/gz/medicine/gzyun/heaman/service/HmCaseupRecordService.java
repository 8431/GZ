package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmCaseupRecord;
import com.gz.medicine.gzyun.heaman.request.HmCaseupRecordRequest;

public interface HmCaseupRecordService {
	/**
	 * 病历上传查询接口（查询）
	 * 
	 * @param usrguid
	 * @return
	 * @throws Exception
	 */
	List<HmCaseupRecord> selectByCaseup(String usrguid) throws Exception;

	/**
	 * 查询病例表的前十条
	 * 
	 * @param caseupRecordRequest
	 * @return
	 * @throws Exception
	 */

	List<HmCaseupRecordRequest> ListCaseup(HmCaseupRecordRequest caseupRecordRequest) throws Exception;

	/**
	 * 病例解读详情接口（查询）
	 * 
	 * @param guid
	 * @return
	 * @throws Exception
	 */
	List<HmCaseupRecord> selectByDetails(String guid) throws Exception;

	/**
	 * 病例解读列表接口 （查询）
	 * 
	 * @param usrguid
	 * @return
	 */
	List<HmCaseupRecord> selectByInterpretation(String usrguid) throws Exception;

	/**
	 * 病历上传查询接口（写入）
	 * 
	 * @param caseupRecordRequest
	 * @return
	 * @throws Exception
	 */
	String insertCaseup(HmCaseupRecordRequest caseupRecordRequest) throws Exception;

}
