package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.service.DTBaseService;
import com.gz.medicine.yun.doctor.service.DTDoctorSfhzglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 邓岚峰 on 2017/8/17 0017.
 */
@RestController
@RequestMapping("/v1/common/")
public class DTBaseController {
    @Autowired
    DTBaseService dtbaseservice;
    //批量新增
    @RequestMapping(value = "/insert", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult queryPageSfhzgl( PageModel page) {
        SimpleResult sr=null;
        try {
            sr=dtbaseservice.insertByTableName(page.getPage());
        } catch (Exception e) {
             return SimpleResult.error(SimpleCode.ERROR.getCode(),SimpleCode.ERROR.getMessage());
        }
        return  sr;
    }
}
