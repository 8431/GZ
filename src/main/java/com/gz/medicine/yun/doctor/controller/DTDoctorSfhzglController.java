package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.bean.DTteamsg;
import com.gz.medicine.yun.doctor.service.DTDoctorSfhzglService;
import com.gz.medicine.yun.doctor.service.DtDoctorQuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by 邓岚峰 on 2017/8/17 0017.
 */
@RestController
@RequestMapping("/v1/cloud/")
public class DTDoctorSfhzglController {
    @Autowired
    DTDoctorSfhzglService dtdoctorsfhzglservice;
    //患者随访计划管理
    @RequestMapping(value = "/queryPageSfhzgl", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult queryPageSfhzgl( PageModel page) {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.queryPageSfhzgl(page);
        } catch (CommonException e) {
             return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }
   //保存或者更新随访计划
    @RequestMapping(value = "/insertFollowupPlan",produces="text/html;charset=UTF-8")
    public SimpleResult insertFollowupPlan( @RequestBody  List<DTfollowupPlan> dp) {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.insertDTfollowupPlan(dp);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }
    //随访计划列表
    @RequestMapping(value = "/getSfjhList",produces="text/html;charset=UTF-8")
    public SimpleResult getSfjhList() {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.querySfjhList();
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }
    //患者随访计划列表
    @RequestMapping(value = "/queryPageHzsfjh", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult queryPageHzsfjh( PageModel page) {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.queryPageHzsfjh(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }
    //患者随访计划列表
    @RequestMapping(value = "/queryPlan", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult queryPlan(@RequestParam(value = "docGuid", required = true) String docGuid,
                                  @RequestParam(value = "usrGuid", required = true) String usrGuid) {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.queryPlan(docGuid,usrGuid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }
    //云诊室，随访患者详情
    @RequestMapping(value = "/querySfjhToYzs", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult querySfjhToYzs(@RequestParam(value = "guid", required = true) String guid
                                ) {
        SimpleResult sr=null;
        try {
            sr=dtdoctorsfhzglservice.querySfjhToYzs(guid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
        }
        return  sr;
    }


}
