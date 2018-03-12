package com.gz.medicine.gzyun.health.mapper;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;

import com.gz.medicine.gzyun.health.bean.HealthyDoctorform;
import com.gz.medicine.gzyun.health.reponse.HealthyOrderReponse;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorformIdReponse;
import com.gz.medicine.gzyun.health.reponse.HealthyDoctorformreponse;
import com.gz.medicine.gzyun.health.request.HealthDoctorformAllRequest;
import com.gz.medicine.gzyun.health.request.HealthDoctorformIdRequest;
import com.gz.medicine.gzyun.health.request.HealthevaluateRequest;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;
import com.gz.medicine.gzyun.health.request.HealthyDoctorformrequest;


public interface HealthyDoctorformMapper {
    int insert(HealthyDoctorform record);

    int insertSelective(HealthyDoctorform record);

    /**
     * 排班统计  www
     * @return
     * @throws Exception
     */
    List<HealthyOrderReponse> queryPageSchedulingStatistics(Page p) throws Exception;

    /**
     * 排班统计天数 www
     * @return
     * @throws Exception
     */
    HealthyOrderReponse querySchedulingDays(Map<String, Object> maps) throws Exception;

    /**
     * 金雯雯
     * 查询当月排班
     * **/
    List<HealthyDoctorform> queryItemDocId(HealthyDocformRequest data);

    /**
     * 排班管理
     * 舵主
     */
    List<HealthyDoctorformreponse> queryListByMapHealthyDoctorform(HealthyDoctorformrequest data);



    /**
     * 医生搜索排班接口
     * 舵主
     */
    List<HealthDoctorformIdReponse> queryDoctorformseach(HealthDoctorformIdRequest data)throws Exception;


    /**
     * 新增排班信息
     * 舵主
     */
    String createItemDoctorform(HealthyDoctorform data)throws Exception;

    /**
     * 根据医生id和日期查询
     * @param docid
     * @param date
     * @return
     * @throws Exception
     */

    HealthyDoctorform queryDoctorformBydocidAndDate(String docid,String date)throws Exception;

    /**
     * 修改数据
     * @param id
     * @return
     * @throws Exception
     */
    int update(String id)throws Exception;

}