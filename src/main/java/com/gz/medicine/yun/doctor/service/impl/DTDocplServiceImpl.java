package com.gz.medicine.yun.doctor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.doctor.mapper.DTdocplMapper;
import com.gz.medicine.yun.doctor.service.DTDocplService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业绩考核
 * jin
 **/
@Service("DTDocplService")
public class DTDocplServiceImpl implements DTDocplService {
    public static final Logger LOGGER = Logger.getLogger(DTDocplServiceImpl.class);
    @Autowired
    DTdocplMapper docplmapper;
    public SimpleResult queryPageDocpl(PageModel page) throws CommonException {
        SimpleResult sr=null;
        List<Map<String,Object>> lists= null;
        try {
            Page p=page.getPage();
            lists = docplmapper.queryPageMyid(p);
            p.setParameterType(lists);
            sr=SimpleResult.success();
            sr.put("data",p);
        } catch (Exception e) {
            LOGGER.error("DTDocplServiceImpl异常："+e.getMessage(),e);
            throw new CommonException("COM001","DTDocplServiceImpl异常");        }
        return sr;
    }

 
}
