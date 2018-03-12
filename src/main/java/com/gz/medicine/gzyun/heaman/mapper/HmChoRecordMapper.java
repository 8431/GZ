package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmChoRecord;
import com.gz.medicine.gzyun.heaman.request.HmChoRequest;


public interface HmChoRecordMapper {
	int insert(HmChoRecord record);

    int insertSelective(HmChoRecord record);
    
    List<HmChoRecord> queryCho(HmChoRequest data);
}