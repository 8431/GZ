package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmBlpRecord;

/**
 * 血压接口mapper
 * 舵主
 * @author Administrator
 *
 */
public interface HmBlpRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmBlpRecord record);

    int insertSelective(HmBlpRecord record);

    List<HmBlpRecord> selectByPrimaryKeyAll(String guid);

    int updateByPrimaryKeySelective(HmBlpRecord record);

    int updateByPrimaryKey(HmBlpRecord record);
}