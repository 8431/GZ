package com.gz.medicine.gzyun.heaman.mapper;

import com.gz.medicine.gzyun.heaman.bean.HmPermsgRecord;
import com.gz.medicine.gzyun.heaman.request.HmPermsgRequest;

public interface HmPermsgRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmPermsgRecord record);

    int insertSelective(HmPermsgRecord record);

    HmPermsgRecord selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmPermsgRecord record);

    int updateByPrimaryKey(HmPermsgRecord record);
    
    HmPermsgRecord select(HmPermsgRequest data);
}