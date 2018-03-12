package com.gz.medicine.yun.doctor.mapper;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTpreoff;

public interface DTpreoffMapper {
    int insert(DTpreoff record);

    int insertSelective(DTpreoff record);
    
    List<Map<String,Object>> queryPageUsrid(Page p) throws Exception;
}