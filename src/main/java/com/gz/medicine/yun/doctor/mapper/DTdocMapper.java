package com.gz.medicine.yun.doctor.mapper;


import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTdoc;
import com.gz.medicine.yun.doctor.bean.DoctorOnDuty;
import com.gz.medicine.yun.doctor.bean.SourceDoc;
import com.gz.medicine.yun.doctor.reponse.DTdocReponse;
import com.gz.medicine.yun.doctor.request.DTdocRequest;

public interface DTdocMapper {

    int deleteByPrimaryKey(String guid);

    int insert(DTdoc record);

    int insertSelective(DTdoc record);

    DTdoc selectByPrimaryKey(String guid);


    DTdoc selectByPrimaryKeys(String guid);

    DTdoc selectByid(String guid);

    int updateByPrimaryKeySelective(DTdoc record);

    int updateByPrimaryKey(DTdoc record);
    
    DTdoc select(DTdocRequest data);

    List<Map<String,Object>> queryPageId(Page p) throws Exception;
    
    List<DoctorOnDuty> selectDocList() ;
}