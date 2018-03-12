package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.healthTitleChart;

public interface healthTitleChartMapper {
    int insert(healthTitleChart record);

    int insertSelective(healthTitleChart record);
}