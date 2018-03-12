package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthCallStateRecord;
import org.apache.ibatis.annotations.Param;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthCallStateRecordMapper
 * @packageName: com.gz.medicine.gzyun.health.mapper
 * @description: 呼叫状态记录表Mapper
 * @data: 2017-12-19 15:18
 **/
public interface HealthCallStateRecordMapper {

    int deleteByPrimaryKey(String id);

    int insert(HealthCallStateRecord record);

    int insertSelective(HealthCallStateRecord record);

    HealthCallStateRecord selectByPrimaryKey(String id);

    HealthCallStateRecord selectByPrimaryKeySelective(@Param("orderid") String orderid, @Param("callstate") String callstate);

    int updateByPrimaryKeySelective(HealthCallStateRecord record);

    int updateByPrimaryKey(HealthCallStateRecord record);
}