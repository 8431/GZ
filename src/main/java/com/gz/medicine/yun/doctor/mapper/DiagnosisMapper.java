/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.mapper;

import java.util.*;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzyun.health.common.mapper.BaseMapper;
import com.gz.medicine.yun.doctor.bean.Diagnosis;
import com.gz.medicine.yun.doctor.bean.Diagnosisrecords;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DiagnosisMapper
 * @PackageName com.gz.medicine.yun.doctor.mapper
 * @Description 诊断表 Mapper
 * @Data 2017年12月26日 12时18分34秒 星期二 
 **/
public interface DiagnosisMapper extends BaseMapper<Diagnosis> {

    /**
     * 模糊查询
     * @param p
     * @return
     * @throws CommonException
     */
    List<Map<String, Object>> queryPagelike(Page p)throws CommonException;
    /**
     * 查询诊断
     * **/
    List<Diagnosisrecords> queryAll(String sickid);
}