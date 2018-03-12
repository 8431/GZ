/*
* DTfollowupTemplateMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-07
*/
package com.gz.medicine.yun.doctor.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupTemplate;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;

import java.util.List;

/**
 * @Title CHIS_FOLLOWUP_TEMPLATE表的Mapper
 * @Description 随访模板Mapper
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-07 17:37:24
 */
public interface DTfollowupTemplateMapper {
    /**
     *  根据主键删除数据库的记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param record
     */
    int insert(DTfollowupTemplate record);

    /**
     *  动态字段,写入数据库记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param record
     */
    int insertSelective(DTfollowupTemplate record);

    /**
     *  根据指定主键获取一条数据库记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param id
     */
    DTfollowupTemplate selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DTfollowupTemplate record);

    /**
     *  根据主键来更新符合条件的数据库记录:CHIS_FOLLOWUP_TEMPLATE
     *
     * @param record
     */
    int updateByPrimaryKey(DTfollowupTemplate record);

    /**
     * 随访模板  www
     * @return
     */
    List<DTfollowupTemplate> queryPageFollow(Page pm);


    /**
     * 假删 www
     * @param record
     * @return
     */
    int updateState (DTfollowupTemplate record);
}