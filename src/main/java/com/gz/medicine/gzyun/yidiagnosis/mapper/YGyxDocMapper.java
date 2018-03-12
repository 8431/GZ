package com.gz.medicine.gzyun.yidiagnosis.mapper;

import java.util.List;

import com.gz.medicine.gzyun.yidiagnosis.bean.YGyxDoc;

public interface YGyxDocMapper {
    int deleteByPrimaryKey(String guid);

    int insert(YGyxDoc record);

    int insertSelective(YGyxDoc record);

    YGyxDoc selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(YGyxDoc record);

    int updateByPrimaryKey(YGyxDoc record);
    
    List<YGyxDoc> selectByDOC(String guid);
}