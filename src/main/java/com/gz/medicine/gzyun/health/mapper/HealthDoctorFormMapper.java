/*
* HealthDoctorFormMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.mapper;

import java.util.List;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;
import com.gz.medicine.gzyun.health.bean.HealthyDoctorform;
import com.gz.medicine.gzyun.health.reponse.HealthStatisticsReponse;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HealthDoctorFormMapper {
    /**
     *  根据主键删除数据库的记录:HEALTHDOCTORFORM
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
     *  新写入数据库记录:HEALTHDOCTORFORM
     *
     * @param record
     */
    int insert(HealthDoctorForm record);

    /**
     *  动态字段,写入数据库记录:HEALTHDOCTORFORM
     *
     * @param record
     */
    int insertSelective(HealthDoctorForm record);

    /**
     *  根据指定主键获取一条数据库记录:HEALTHDOCTORFORM
     *
     * @param id
     */
    HealthDoctorForm selectByPrimaryKey(String id);

    /**
     * 根据医生主键获取集合数据
     * @param docid
     * @return
     */
    List<HealthDoctorForm> selectByPrimaryKeyList(String docid) throws CommonException;

    List<String> selectByPrimaryKeyStrList(@Param("docid") String docid, @Param("formdate") String formdate) throws CommonException;

    List<HealthDoctorForm> selectByFormdateList(@Param("docid") String docid, @Param("formdate") String formdate) throws  CommonException;

    List<HealthDoctorForm> selectByFormdateListothers(@Param("docid") String docid, @Param("formdate") String formdate) throws  CommonException;


    List<HealthDoctorForm> selectByFormdateListother(@Param("docid") String docid, @Param("formdate") String formdate,@Param("enddate") String enddate) throws  CommonException;



    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:HEALTHDOCTORFORM
     *
     * @param record
     */
    int updateByPrimaryKeySelective(HealthDoctorForm record);

    /**
     *  根据主键来更新符合条件的数据库记录:HEALTHDOCTORFORM
     *
     * @param record
     */
    int updateByPrimaryKey(HealthDoctorForm record) throws Exception;

    /**
     * 根据医生id和日期删除数据
     * @param record
     * @throws Exception
     */
    void deleteHistory(HealthDoctorForm record);

    /**
     * 医生排版时间查询
     * @param date
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryDocFormByDate(Map<String,Object> date)throws Exception;

    /**
     * 医生排版时间段查询
     * @param date
     * @param docid
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryDocFormByDocidAndDate(String date,String docid)throws Exception;


    /**
     * 金雯雯
     * 查询当月排班
     * **/
    List<HealthDoctorForm> queryItemDocId(HealthyDocformRequest data);


    /**
     * 金雯雯
     * 修改指定排版状态为停诊
     * **/
    int updatebyid(String id);


    /**
     * 排班统计  www
     * @return
     * @throws Exception
     */
    List<HealthStatisticsReponse> queryPageSchedulingStatistics(Map<String, Object> maps) throws Exception;

    /**
     * 排班统计天数 www
     * @return
     * @throws Exception
     */
    HealthStatisticsReponse querySchedulingDays(Map<String, Object> maps) throws Exception;

    /**
     * 排班预约
     * @param
     * @return
     * @throws Exception
     */
    List<HealthStatisticsReponse> queryPageIntervalDate(Map<String, Object> maps) throws Exception;

    /**
     * 排班预约统计天数 www
     * @param maps
     * @return
     * @throws Exception
     */
    HealthStatisticsReponse queryIntervalDateDays(Map<String, Object> maps) throws Exception;

    
    /**
     * 排班预约管理查询所有医生当天排班 金
     * **/
    
    List<Map<String,Object>> querybyDdoc(Page p);
    
    /**
     * 排班预约管理查询单个医生当天排班 金
     * **/
    
    List<Map<String,Object>> querybyDdocOne(Page p);

    /**
     * 预约管理
     * @param p
     * @return
     */
    List<Map<String,Object>> queryPageYuYue(Page p) throws Exception;

    /**
     * 根据医生ID,排班开始,结束时间,获取条数
     * @param healthDoctorForm
     * @return
     */
    int countByStateAndEndTime(HealthDoctorForm healthDoctorForm);

    /**
     * 根据医生ID，预约开始时间，结束时间更改，医生预约状态
     * @param healthDoctorForm
     * @return
     * @throws CommonException
     */
    int updateDocFormState(HealthDoctorForm healthDoctorForm)throws CommonException;


    /**
     * 取消订单，更新该订单所预约医生排版时间段由已预约改为未预约
     * @param mp
     * @return
     * @throws Exception
     */
    int updateDocFormTime(Map<String,Object> mp) throws Exception;
    /**
     * 查询停诊状态个数 金
     * **/
    int queryStateId(HealthyDocformRequest data) throws Exception;
    
    
    /**
     * 查询是否存在该数据 金
     * **/
    HealthDoctorForm querydataId(String id) throws Exception;
    

    /**
     * 查询排版是否被预约
     * @param hf
     * @return
     * @throws Exception
     */
    String queryDocFormFormstate(HealthDoctorForm hf)throws Exception;


    List<Map<String,Object>>queryDoctorFormByDate(String docid,String date)throws Exception;
}