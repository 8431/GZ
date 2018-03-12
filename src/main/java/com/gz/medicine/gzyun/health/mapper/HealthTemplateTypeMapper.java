/*
* HealthTemplateTypeMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthTemplateType;
import com.gz.medicine.gzyun.health.reponse.TemplateContentReponse;

import java.util.List;

public interface HealthTemplateTypeMapper {
    /**
     *  根据主键删除数据库的记录:TEMPLATETYPE
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:TEMPLATETYPE
     *
     * @param record
     */
    int insert(HealthTemplateType record);

    /**
     *  动态字段,写入数据库记录:TEMPLATETYPE
     *
     * @param record
     */
    int insertSelective(HealthTemplateType record);

    /**
     *  根据指定主键获取一条数据库记录:TEMPLATETYPE
     *
     * @param id
     */
    HealthTemplateType selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:TEMPLATETYPE
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthTemplateType record);

    /**
     *  根据主键来更新符合条件的数据库记录:TEMPLATETYPE
     *
     * @param record
     */
    int updateByPrimaryKey(HealthTemplateType record);

    /**
     * 选择模板
     * @paramHealthTemplateTypeMapper
     * @return
     */
    List<HealthTemplateType> selectTemplateType();

    /**
     * 模板内容
     * @param
     * @return
     */
    List<TemplateContentReponse> selectTemplateContent();
}