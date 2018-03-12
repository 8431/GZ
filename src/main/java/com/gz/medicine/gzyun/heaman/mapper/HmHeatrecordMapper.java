package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmHeatrecord;
import com.gz.medicine.gzyun.heaman.bean.HmSignRecord;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;

public interface HmHeatrecordMapper {
    int deleteByPrimaryKey(String guid);

    int insertHeat(HmHeatrecord record);

    int insertSelective(HmHeatrecord record);


    int updateByPrimaryKeySelective(HmHeatrecord record);

    int updateByPrimaryKey(HmHeatrecord record);

	List<HmHeatrecord> queryHeat(HmHeatRequest data);
	
	List<HmSignRecord> selectSign(HmHeatRequest data);
}