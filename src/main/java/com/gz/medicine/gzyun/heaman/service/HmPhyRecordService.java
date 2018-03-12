package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmPhyRecord;
import com.gz.medicine.gzyun.heaman.request.HmPhyRecordRequest;

public interface HmPhyRecordService {

	/**
	 * 体检报告查询接口（查询）
	 * 
	 * @param usrguid
	 * @return
	 */
	List<HmPhyRecord> selectByPhyRecord(String usrguid) throws CommonException;

	/**
	 * 体检报告解读列表接口 （查询）
	 * 
	 * @param usrguid
	 * @return
	 */
	List<HmPhyRecord> selectByTJInterpretation(String usrguid) throws CommonException;

	/**
	 * 体检报告解读详情接口（查询）
	 * 
	 * @param guid
	 * @return
	 */
	List<HmPhyRecord> selectByDetails(String guid) throws CommonException;
	
	/**
	 * 体检报告写入接口（写入）
	 * @param hmPhyRecord
	 * @return
	 * @throws Exception
	 */
	String insertPhyRecord(HmPhyRecordRequest hmPhyRecordRequest) throws CommonException;
}
