package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthyIntervalTime;

import java.util.List;

public interface HealthyIntervalTimeMapper {
    int insert(HealthyIntervalTime record);

    int insertSelective(HealthyIntervalTime record);
    
    /**
     * 新增排班时段信息
     * 舵主
     */
    void insertIntervalTime(HealthyIntervalTime data);

    /**
     * 查询排版时间断
     * @param id
     * @return
     * @throws Exception
     */
    List<String> queryHealthyIntervalTime(String id)throws Exception;

    /**
     * 修改数据
     * @param id
     * @return
     * @throws Exception
     */
    int update(String id)throws Exception;

    /**
     * 修改数据通过时段和排班主键
     * @param id
     * @param name
     * @return
     * @throws Exception
     */
    int updateByIntervaldate(String id,String name)throws Exception;
}