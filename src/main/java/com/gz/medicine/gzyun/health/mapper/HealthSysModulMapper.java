/*
* HealthSysModulMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-24
*/
package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthSysModul;

public interface HealthSysModulMapper {
    /**
     *  根据主键删除数据库的记录:HEALTHSYSMODUL
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:HEALTHSYSMODUL
     *
     * @param record
     */
    int insert(HealthSysModul record);

    /**
     *  动态字段,写入数据库记录:HEALTHSYSMODUL
     *
     * @param record
     */
    int insertSelective(HealthSysModul record);

    /**
     *  根据指定主键获取一条数据库记录:HEALTHSYSMODUL
     *
     * @param id
     */
    HealthSysModul selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:HEALTHSYSMODUL
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthSysModul record);

    /**
     *  根据主键来更新符合条件的数据库记录:HEALTHSYSMODUL
     *
     * @param record
     */
    int updateByPrimaryKey(HealthSysModul record);
}