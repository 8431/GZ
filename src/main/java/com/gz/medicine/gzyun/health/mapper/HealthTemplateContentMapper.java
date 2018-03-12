/*
* HealthTemplateContentMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthTemplateContent;

public interface HealthTemplateContentMapper {
    /**
     *  根据主键删除数据库的记录:TEMPLATECONTENT
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:TEMPLATECONTENT
     *
     * @param record
     */
    int insert(HealthTemplateContent record);

    /**
     *  动态字段,写入数据库记录:TEMPLATECONTENT
     *
     * @param record
     */
    int insertSelective(HealthTemplateContent record);

    /**
     *  根据指定主键获取一条数据库记录:TEMPLATECONTENT
     *
     * @param id
     */
    HealthTemplateContent selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:TEMPLATECONTENT
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthTemplateContent record);

    /**
     *  根据主键来更新符合条件的数据库记录:TEMPLATECONTENT
     *
     * @param record
     */
    int updateByPrimaryKey(HealthTemplateContent record);
}