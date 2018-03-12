package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmBlgRecord;



public interface HmBlgRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmBlgRecord blgrecord);

    int insertSelective(HmBlgRecord record);

    int updateByPrimaryKeySelective(HmBlgRecord record);

    int updateByPrimaryKey(HmBlgRecord record);
   
    List<HmBlgRecord> selectAll(String string);

	List<HmBlgRecord> selectOne(String string);
}