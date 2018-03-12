package com.gz.medicine.yun.doctor.mapper;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTpreno;
import com.gz.medicine.yun.doctor.reponse.DTprenoResponse;


public interface DTprenoMapper {
    int insert(DTpreno record);

    int insertSelective(DTpreno record);
    
    List<Map<String,Object>> queryPageGuid(Page p) throws Exception;
}