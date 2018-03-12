package com.gz.medicine.yun.doctor.mapper;

import java.util.List;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTmessageRecord;

public interface DTmessageRecordMapper {
	int deleteByPrimaryKey(String guid);

	int insert(DTmessageRecord record);

	int insertSelective(DTmessageRecord record);

	/**
	 * 短信记录详情
	 * 
	 * @param guid
	 * @return
	 */
	DTmessageRecord selectByPrimaryKey(String guid);

	int updateByPrimaryKeySelective(DTmessageRecord record);

	int updateByPrimaryKey(DTmessageRecord record);

	/**
	 * 短信记录详情
	 * 
	 * @param guid
	 * @return
	 */
	List<DTmessageRecord> selectByGuidKey(String guid);

	/**
	 * 随访记录 列表
	 * 
	 * @param usrguid
	 * @param docguid
	 * @return
	 */
	List<DTmessageRecord> queryPageByMessageRecord(Page page);
}