package com.gz.medicine.yun.doctor.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.mapper.DTBaseDao;
import com.gz.medicine.yun.doctor.mapper.DTfollowupOptionMapper;
import com.gz.medicine.yun.doctor.service.DTBaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/22 0022.
 */
@Service("DTBaseService")
public class DTBaseServiceImpl implements DTBaseService {
    public static final Logger LOGGER = Logger.getLogger(DTBaseServiceImpl.class);
    @Autowired
    DTBaseDao dtbasedao;
    @Autowired
    DTfollowupOptionMapper dtfollowupoptionmapper;
    @Override
    public SimpleResult insertByTableName(Map<String, Object> mp) throws CommonException {
        SimpleResult sr=null;
        try {
            dtfollowupoptionmapper.mybatisInsert(mp);
            sr=SimpleResult.success();
        } catch (Exception e) {
            LOGGER.error("批量新增异常："+e.getMessage(),e);
            throw new CommonException("COM001","批量新增异常");        }
        return sr;
    }
}
