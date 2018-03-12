package com.gz.medicine.gzyun.health.mapper;

import java.util.List;
import java.util.Map;

import com.gz.medicine.gzyun.health.bean.HealthyDoctorform;
import com.gz.medicine.gzyun.health.bean.healthDoctor;
import com.gz.medicine.gzyun.health.reponse.DoctorParticularsReponse;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;

public interface healthDoctorMapper {

    int insert(healthDoctor record);

    int insertSelective(healthDoctor record);
    healthDoctor selectById(String  docid);

    /**
     * 医生详情
     * @param docid
     * @return
     */
    DoctorParticularsReponse selectDoctorParticularsList(String docid);
    
    
    /**
     * 查询所有医生
     * 舵主
     */
    //List<HealthDoctorAllReponse> queryListDoctorName();
    List<Map<String,Object>> queryListDoctorName();

    /**
     *  根据指定主键获取一条数据库记录:HEALTHDOCTOR
     *
     * @param id
     */
    healthDoctor selectByPrimaryKey(String id);
    
   
}