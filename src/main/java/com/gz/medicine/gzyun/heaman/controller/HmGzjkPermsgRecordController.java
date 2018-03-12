package com.gz.medicine.gzyun.heaman.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.ftpUtil.Ftp;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkPermsgRecord;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkReport;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkSetTable;
import com.gz.medicine.gzyun.heaman.bean.HmReportVo;
import com.gz.medicine.gzyun.heaman.service.HmGzjkPermsgRecordService;

import com.gz.medicine.yun.doctor.bean.DTteamsg;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/GZJKinterface03")
public class HmGzjkPermsgRecordController extends ValidateWithException {
    
    public static final Logger LOGGER = Logger.getLogger(HmGzjkPermsgRecordController.class);
    @Autowired
    private HmGzjkPermsgRecordService gzjkpermsgrecordservice;
    @Autowired
    Validator validator;
//    @Autowired
//    RedisDaoService redisdaoservice;
    //九、测试文件上传
    @RequestMapping(value = "/test ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult test(DTteamsg file, HttpServletRequest  request) throws Exception {
        Object ob=request.getParameter("file");
       Map mp= request.getParameterMap();
//            String fileName = file.getOriginalFilename();
//        // 获取文件的后缀名
//        // 文件上传后的路径
//        //Ftp ftp=new Ftp("106.14.139.5",11221,"gzyy","gzyy2017");
//        Ftp ftp=new Ftp("39.108.53.12",21,"administrator","Qq16899199");
//        ftp.ftpLogin();
//        InputStream in=null;
//    ftp.uploadFile(file.getInputStream(),file.getOriginalFilename(),"/");
//        ftp.ftpLogOut();
//
        SimpleResult m=SimpleResult.success();
       // m.put("img", file.getBytes());

////        redisdaoservice.set(fileName,m,null);
        return  m;
    }
//    //九、测试文件上传
//    @RequestMapping(value = "/getImg ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
//    public SimpleResult test( @RequestParam("img") String img) throws Exception {
//        SimpleResult s=SimpleResult.success();
//
//        SimpleResult m= (SimpleResult) redisdaoservice.get(img);
//        s.putData("img",m.get(img));
//        return  s;
//    }
    //九、	基本健康档案信息查询接口（查询）
    @RequestMapping(value = "/GzjkPermsgRecord ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult GzjkPermsgRecord(@Valid HmGzjkPermsgRecord gz ) {
    	  SimpleResult sr=null;
        List<HmGzjkPermsgRecord> gpRecode = new ArrayList<HmGzjkPermsgRecord>();
          try {
        	  if(validates(validator, gz)!=null){
        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gz));
        	  }
              gpRecode= gzjkpermsgrecordservice.selectByPrimaryKeyUsrGuid(gz.getUsrguid());
		} catch (Exception e) {
			LOGGER.error(e);
              return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());
          }
        sr = SimpleResult.success();;
        sr.put("data",gpRecode);
        return  sr;
    }
    //十、	个人信息写入接口（写入）
    @RequestMapping(value = "/WriteGZJKpermsgRecord ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult WriteGZJKpermsgRecord(@Valid HmGzjkPermsgRecord gr ) {
        SimpleResult sr=null;
       String result=null;
        try {
            if(validates(validator, gr)!=null){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gr));
            }
            result=gzjkpermsgrecordservice.updatePersonMsg(gr);
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());

        }
        sr = SimpleResult.success();;
        return  sr;
    }
    //十一、	健康评估列表接口 （查询）
    @RequestMapping(value = "/heaAssList ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult heaAssList(@Valid HmGzjkReport gr ) {
        SimpleResult sr=null;
        List<HmGzjkReport> result=null;
        try {
            if(validates(validator, gr)!=null){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gr));
            }
            result=gzjkpermsgrecordservice.selectGzjkReportMsg(gr.getUsrguid());
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());        }
        sr = SimpleResult.success();;
        sr.put("data",result);
        return  sr;
    }
    //十二、	健康评估详情接口 （查询）
    @RequestMapping(value = "/heaAssDetails ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult heaAssDetails(@Valid HmReportVo gr,BindingResult re) {
        SimpleResult sr=null;
        List<HmReportVo> result=null;
        try {
            if(re.hasErrors()){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gr));
            }
            result=gzjkpermsgrecordservice.getHealthyDetail(gr.getGuid());
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());        }
        sr = SimpleResult.success();;
        sr.put("data",result);
        return  sr;
    }
    //十三、	健康方案列表接口 （查询）
    @RequestMapping(value = "/heaPlanList ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult heaPlanList(@Valid HmReportVo gr,BindingResult re) {
        SimpleResult sr=null;
        List<HmReportVo> result=null;
        try {
            if(re.hasErrors()){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gr));
            }
            result=gzjkpermsgrecordservice.getHeaPlanList(gr.getUsrguid());
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());        }
        sr = SimpleResult.success();;
        sr.put("data",result);
        return  sr;
    }
    //十四、	健康方案详情接口 （查询）
    @RequestMapping(value = "/heaPlanDetails ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult heaPlanDetails(@Valid HmReportVo gr,BindingResult re) {
        SimpleResult sr=null;
        List<HmReportVo> result=null;
        try {
            if(re.hasErrors()){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, gr));
            }
            result=gzjkpermsgrecordservice.getHeaPlanDetails(gr.getGuid());
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());        }
        sr = SimpleResult.success();;
        sr.put("data",result);
        return  sr;
    }
    //十五、	套餐接口 （查询）
    @RequestMapping(value = "/getCombo ", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public SimpleResult getCombo() {
        SimpleResult sr=null;
        List<HmGzjkSetTable> result=null;
        try {
            result=gzjkpermsgrecordservice.getComBo();
        } catch (Exception e) {
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());        }
        sr = SimpleResult.success();;
        sr.put("data",result);
        return  sr;
    }

}
