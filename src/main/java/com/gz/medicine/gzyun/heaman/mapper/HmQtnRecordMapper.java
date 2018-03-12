package com.gz.medicine.gzyun.heaman.mapper;

import com.gz.medicine.gzyun.heaman.bean.HmQtnRecord;
import com.gz.medicine.gzyun.heaman.request.HmSqueRequest;

public interface HmQtnRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmSqueRequest data);

    int insertSelective(HmQtnRecord record);

    HmQtnRecord selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmQtnRecord record);

    int updateByPrimaryKey(HmQtnRecord record);
}