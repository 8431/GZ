package com.gz.medicine.gzyun.heaman.mapper;

import java.util.List;

import com.gz.medicine.gzyun.heaman.bean.HmEcgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmEcgReponse;

/**
 * 心电接口mapper层
 * 
 * 舵主
 * @author Administrator
 *
 */
public interface HmEcgRecordMapper {
    int deleteByPrimaryKey(String guid);

    int insert(HmEcgRecord record);

    int insertSelective(HmEcgRecord record);

    HmEcgRecord selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmEcgRecord record);

    int updateByPrimaryKey(HmEcgRecord record);

	List<HmEcgRecord> selectByPrimaryUsrKey(String usrguid);
}