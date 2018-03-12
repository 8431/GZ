package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmPhyRecord;

public interface HmPhyRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmPhyRecord record);

    int insertSelective(HmPhyRecord record);

    HmPhyRecord selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmPhyRecord record);

    int updateByPrimaryKey(HmPhyRecord record);
    /**
     * 体检报告查询接口（查询）
     * @param usrguid
     * @return
     */
    List<HmPhyRecord> selectByPhyRecord(String usrguid);
    /**
     * 体检报告解读列表接口 （查询）
     * @param usrguid
     * @return
     */
    List<HmPhyRecord> selectByTJInterpretation(String usrguid);
    /**
     * 体检报告解读详情接口（查询）
     * @param guid
     * @return
     */
    List<HmPhyRecord> selectByDetails(String guid);
    
    /**
     * 体检报告写入接口（写入）
     * @param hmPhyRecord
     * @return
     */
    int insertPhyRecord(HmPhyRecord hmPhyRecord);
    
    
}