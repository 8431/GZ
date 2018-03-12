package com.gz.medicine.yun.doctor.mapper;


import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTdocpl;

public interface DTdocplMapper {
    int insert(DTdocpl record);

    int insertSelective(DTdocpl record);
    
    List<Map<String,Object>> queryPageMyid(Page p) throws Exception;
}