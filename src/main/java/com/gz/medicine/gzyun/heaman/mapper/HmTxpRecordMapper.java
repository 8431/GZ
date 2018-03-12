package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmTxpRecord;

/**
 * 尿酸mapper层
 * 
 * 舵主
 * @author Administrator
 *
 */
public interface HmTxpRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmTxpRecord record);

    int insertSelective(HmTxpRecord record);

    List<HmTxpRecord> selectByPrimaryKeyAll(String guid);

    int updateByPrimaryKeySelective(HmTxpRecord record);

    int updateByPrimaryKey(HmTxpRecord record);
}