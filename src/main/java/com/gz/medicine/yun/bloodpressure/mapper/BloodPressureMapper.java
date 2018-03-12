package com.gz.medicine.yun.bloodpressure.mapper;


import com.gz.medicine.yun.bloodpressure.bean.BloodPressure;

public interface BloodPressureMapper {

    int deleteByPrimaryKey(String guid);

    int insert(BloodPressure record);

    int insertSelective(BloodPressure record);

    BloodPressure selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(BloodPressure record);

    int updateByPrimaryKey(BloodPressure record);
}