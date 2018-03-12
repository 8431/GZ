package com.gz.medicine.yun.doctor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.doctor.bean.DTpreno;
import com.gz.medicine.yun.doctor.mapper.DTprenoMapper;
import com.gz.medicine.yun.doctor.reponse.DTprenoResponse;
import com.gz.medicine.yun.doctor.service.DTPrenoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 线上预约
 * jin
 **/
@Service("DTPrenoService")
public class DTPrenoServiceImpl implements DTPrenoService {
    public static final Logger LOGGER = Logger.getLogger(DTPrenoServiceImpl.class);
    @Autowired
    DTprenoMapper prenomapper;
    public SimpleResult queryPagePreno(PageModel page) throws CommonException {
        SimpleResult sr=null;
        List<Map<String,Object>> lists= null;
        try {
            Page p=page.getPage();
            lists = prenomapper.queryPageGuid(p);
            p.setParameterType(lists);
            sr=SimpleResult.success();
            sr.put("data",p);
        } catch (Exception e) {
            LOGGER.error("DTPrenoServiceImpl异常："+e.getMessage(),e);
            throw new CommonException("COM001","DTPrenoServiceImpl异常");        }
        return sr;
    }

 
}
