package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmCaseupRecord;
import com.gz.medicine.gzyun.heaman.request.HmCaseupRecordRequest;

public interface HmCaseupRecordMapper {
	int deleteByPrimaryKey(String guid);

	int insert(HmCaseupRecord record);

	int insertSelective(HmCaseupRecord record);

	HmCaseupRecord selectByPrimaryKey(String guid);

	int updateByPrimaryKeySelective(HmCaseupRecord record);

	int updateByPrimaryKey(HmCaseupRecord record);

	// 病历上传查询接口（查询）
	List<HmCaseupRecord> selectByCaseup(String usrguid);

	// 病例解读列表接口 （查询）
	List<HmCaseupRecord> selectByInterpretation(String usrguid);

	// 查询病例前十条
	List<HmCaseupRecordRequest> ListCaseup();

	// 病例解读详情接口（查询）
	List<HmCaseupRecord> selectByDetails(String guid);

	// 病历上传查询接口（写入）
	int insertCaseup(HmCaseupRecord caseupRecord);

}