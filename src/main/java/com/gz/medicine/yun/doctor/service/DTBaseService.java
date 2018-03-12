package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;

import java.util.Map;

/**
 * Created by 邓岚峰 on 2017/8/22 0022.
 */
public interface DTBaseService {
    /**
     * 批量新增 by 表名
     * @return
     * @throws CommonException
     */
    SimpleResult insertByTableName(Map<String,Object> mp) throws Exception;
}
