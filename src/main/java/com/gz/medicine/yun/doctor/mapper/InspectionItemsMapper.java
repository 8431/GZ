/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.mapper;

import java.util.*;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.common.mapper.BaseMapper;
import com.gz.medicine.yun.doctor.bean.InspectionItems;
import org.apache.ibatis.annotations.Param;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName InspectionItemsMapper
 * @PackageName com.gz.medicine.yun.doctor.mapper
 * @Description 病历中的-检查项目 Mapper
 * @Data 2017年12月22日 16时28分09秒 星期五 
 **/
public interface InspectionItemsMapper extends BaseMapper<InspectionItems> {

    /**
     * 根据病历ID获取检查项目
     * @param sickguid
     * @return
     * @throws CommonException
     */
    List<InspectionItems> getInspectionItemsList(String sickguid)throws CommonException;

    /**
     * 根据病历ID删除检查项
     * @param sickguid
     * @return
     * @throws CommonException
     */
    int deleteByInspectionItems(@Param("sickguid") String sickguid)throws CommonException;

}