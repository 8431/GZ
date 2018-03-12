/*
* HealthServiceConfigMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-25
*/
package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.bean.HealthServiceConfig;

import java.util.List;

public interface HealthServiceConfigMapper {
    /**
     *  根据主键删除数据库的记录:HEALTHSERVICECONFIG
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:HEALTHSERVICECONFIG
     *
     * @param record
     */
    int insert(HealthServiceConfig record);

    /**
     *  动态字段,写入数据库记录:HEALTHSERVICECONFIG
     *
     * @param record
     */
    int insertSelective(HealthServiceConfig record);

    /**
     *  根据指定主键获取一条数据库记录:HEALTHSERVICECONFIG
     *
     * @param id
     */
    HealthServiceConfig selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:HEALTHSERVICECONFIG
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthServiceConfig record);

    /**
     *  根据主键来更新符合条件的数据库记录:HEALTHSERVICECONFIG
     *
     * @param record
     */
    int updateByPrimaryKey(HealthServiceConfig record);

    /**
     * 新增
     * @param record
     * @return
     */
   int  insertHealthServiceConfig(HealthServiceConfig record);

    /**
     * 修改
     * @param record
     * @return
     */
   int updateHealthServiceConfig(HealthServiceConfig record);

    /**
     * 查询这个医生的服务状态
     * @param docid
     * @return
     */
    HealthServiceConfig selectByHealthServiceConfig(String docid);
}