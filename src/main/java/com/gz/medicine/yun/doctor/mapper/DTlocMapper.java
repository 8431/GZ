package com.gz.medicine.yun.doctor.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.doctor.bean.DTloc;

import java.util.Map;

public interface DTlocMapper {

    int deleteByPrimaryKey(String guid);

    int insert(DTloc record);

    int insertSelective(DTloc record);

    DTloc selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(DTloc record);

    int updateByPrimaryKey(DTloc record);

    /**
     *
     *@Title selectByGuidAndChis
     *@Description: 根据id,获取org=chis的数据
     *@Author fendo
     *@Date 2017年8月24日 上午10:52
     *@param deptIdNum
     *@return DTusr
     */
    DTloc selectByIdAndChis(String deptIdNum);


    Map<String,Object> selectByBloodpressureId(String guid)throws CommonException;
}