package com.gz.medicine.yun.doctor.controller;

import com.google.gson.Gson;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTteamsg;
import com.gz.medicine.yun.doctor.service.DtDoctorQuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邓岚峰 on 2017/8/17 0017.
 */
@RestController
@RequestMapping("/v1/doctorApp/")
public class DtDoctorQuanController {
    @Autowired
    DtDoctorQuanService dtdoctorquanservice;

    //获取医生圈列表
    @RequestMapping(value = "/doctorQuanList ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult doctorQuanList(PageModel page) {
        SimpleResult sr = null;
        try {
            sr = dtdoctorquanservice.getDoctorQuanList(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return sr;
    }

    //保存聊天信息
    @RequestMapping(value = "/insertDTteamsg ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult insertDTteamsg(DTteamsg msg) {
        SimpleResult sr = null;
        try {
            sr=dtdoctorquanservice.insertDTteamsg(msg);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return sr;
    }

    //查询聊天信息
    @RequestMapping(value = "/queryPageDTteamsg ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult queryPageDTteamsg(PageModel page) {
        SimpleResult sr = null;
        try {
            sr = dtdoctorquanservice.queryPageDTteamsg(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return sr;
    }

    //查询成员信息
    @RequestMapping(value = "/queryTeamDetail ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult queryTeamDetail(
            @RequestParam(value = "teamguid", required = true) String teamguid) {
        SimpleResult sr = null;
        try {
            sr = dtdoctorquanservice.queryTeamDetail(teamguid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return sr;
    }
    //查询成员信息
    @RequestMapping(value = "/setType ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult setType(
            @RequestParam(value = "key", required = true) String key) {
        SimpleResult sr = null;
        try {
            sr = dtdoctorquanservice.setType(key);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return sr;
    }
}
