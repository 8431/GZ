package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.healthPrice;

public interface healthPriceMapper {

    int insert(healthPrice record);

    int insertSelective(healthPrice record);

    healthPrice selectByID(String id);

}