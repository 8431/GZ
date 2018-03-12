package com.gz.medicine.gzyun.heaman.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkPermsgRecord;

import java.util.List;

public interface HmGzjkPermsgRecordMapper {
    /**
     * 新增操作
     * @param record
     * @return
     * @throws Exception
     */
    int insertSelective(HmGzjkPermsgRecord record) throws CommonException;
    /**
     * 更新操作
     * @param record
     * @return
     * @throws Exception
     */
    int updateByPrimaryKeySelective(HmGzjkPermsgRecord record) throws CommonException;

    /**
     * 基本健康档案信息查询接口（查询）
     * @param guid 患者账号
     * @return
     */
    List<HmGzjkPermsgRecord> selectByPrimaryKeyUsrGuid(String guid)throws CommonException;

    /**
     * 查询数据总条数
     * @param guid
     * @return
     * @throws Exception
     */
    int selectTotalSize(String guid)throws CommonException;
}