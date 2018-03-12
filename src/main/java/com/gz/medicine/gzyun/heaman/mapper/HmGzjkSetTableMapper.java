package com.gz.medicine.gzyun.heaman.mapper;


import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkSetTable;

import java.util.List;

public interface HmGzjkSetTableMapper {
    int insert(HmGzjkSetTable record);

    int insertSelective(HmGzjkSetTable record);

    /**
     * 查询所有套餐
     * @return
     * @throws Exception
     */
    List<HmGzjkSetTable> getCombo() throws CommonException;
}