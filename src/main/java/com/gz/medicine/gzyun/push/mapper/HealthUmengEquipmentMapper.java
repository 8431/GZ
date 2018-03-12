/*
* HealthUmengEquipmentMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-01
*/
package com.gz.medicine.gzyun.push.mapper;

import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
/**
 * @Title UMENGEQUIPMENT表的Mapper
 * @Description 友盟推送绑定
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
public interface HealthUmengEquipmentMapper {
    /**
     *  根据主键删除数据库的记录:UMENGEQUIPMENT
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:UMENGEQUIPMENT
     *
     * @param record
     */
    int insert(HealthUmengEquipment record);

    /**
     *  动态字段,写入数据库记录:UMENGEQUIPMENT
     *
     * @param record
     */
    int insertSelective(HealthUmengEquipment record);

    /**
     *  根据指定主键获取一条数据库记录:UMENGEQUIPMENT
     *
     * @param id
     */
    HealthUmengEquipment selectByPrimaryKey(String id);

    /**
     *  根据用户ID获取一条数据库记录:UMENGEQUIPMENT
     *
     * @param id
     */
    HealthUmengEquipment selectByUserID(String id);


    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:UMENGEQUIPMENT
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthUmengEquipment record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:UMENGEQUIPMENT
     *
     * @param record
     */
    int updateByUserId(HealthUmengEquipment record);

    /**
     *  根据主键来更新符合条件的数据库记录:UMENGEQUIPMENT
     *
     * @param record
     */
    int updateByPrimaryKey(HealthUmengEquipment record);

    /**
     * 通过usrid查询信息
     * @param id
     * @return
     */
    HealthUmengEquipment selectByUsrid(String id);
}