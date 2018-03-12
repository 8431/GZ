/*
* HealthPushMessageMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.reponse.HealthPushMessageCentre;
import com.gz.medicine.gzyun.health.reponse.HealthPushMessageReponse;

import java.util.List;

public interface HealthPushMessageMapper {
    /**
     *  根据主键删除数据库的记录:PUSHMESSAGE
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     * 根据条件统计条数
     */
    int countById(HealthPushMessage healthPushMessage);

    /**
     *  新写入数据库记录:PUSHMESSAGE
     *
     * @param record
     */
    int insert(HealthPushMessage record);

    /**
     *  动态字段,写入数据库记录:PUSHMESSAGE
     *
     * @param record
     */
    int insertSelective(HealthPushMessage record);

    /**
     *  根据指定主键获取一条数据库记录:PUSHMESSAGE
     *
     * @param id
     */
    HealthPushMessage selectByPrimaryKey(String id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:PUSHMESSAGE
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthPushMessage record);

    /**
     *  根据主键来更新符合条件的数据库记录:PUSHMESSAGE
     *
     * @param record
     */
    int updateByPrimaryKey(HealthPushMessage record);

    /**
     * 我的消息
     * @param p
     * @return
     * @throws Exception
     */
    List<HealthPushMessageReponse> queryPagePushMessage(Page p) throws Exception;

    /**
     * 我的消息详情，修改是否已读
     * @param record
     * @return
     */
    int updateByPushMessage(HealthPushMessage record);

    /**
     * 删除
     * @param record
     * @return
     */
    int updateByMessageState(HealthPushMessage record);

    /**
     * 消息中心
     * @param userid
     * @return
     */
    List<HealthPushMessageCentre> selectPushMessage(String userid);

    /**
     * 我的评价
     * @return
     */
    HealthPushMessageCentre selectHealtheValuate(String userid);


    /**
     * 根据用户ID更改所有的消息
     * @param userid
     * @return
     */
    int updateAll(String userid);

    /**
     * 停诊插入数据库系统消息
     * **/
    int insertsysmes(HealthPushMessage mess);
}