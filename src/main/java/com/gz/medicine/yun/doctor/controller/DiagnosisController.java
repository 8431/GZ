/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;


import com.gz.medicine.yun.doctor.bean.Diagnosis;
import com.gz.medicine.yun.doctor.service.DiagnosisService;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DiagnosisController
 * @PackageName com.gz.medicine.yun.doctor.controller
 * @Description 诊断表 Controller
 * @Data 2017年12月26日 12时18分34秒 星期二 
 **/
@Controller
@RequestMapping("diagnosis")
public class DiagnosisController {

	public static final Logger LOGGER = Logger.getLogger(DiagnosisController.class);

    @Autowired
    private DiagnosisService diagnosisService;

    /**
     *
     *@Title findById
     *@Description: 根据ID获取诊断表
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二 
     *@param id(主键)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/diagnosis/findById?id=xxxx
     */
    @RequestMapping(value="findById",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult findById(String id){
        LOGGER.info("[/DiagnosisController/findById]");
		SimpleResult simpleResult;
		Diagnosis diagnosis;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            diagnosis = diagnosisService.find(id);
            simpleResult.put("data",diagnosis);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }
    
    
    /**
     *
     *@Title getPage
     *@Description: 分页查询
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二 
     *@param page(分页数据)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/diagnosis/getPage?pageNo=2&pageSize=1
     */
    @RequestMapping(value="getPage",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult getPage(PageModel page){
        LOGGER.info("[/DiagnosisController/getPage]");
        SimpleResult simpleResult;
        Page p;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            p = diagnosisService.getPage(page);
            simpleResult.put("data",p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }


    /**
     *
     *@Title getPage
     *@Description: 分页查询
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二
     *@param page
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/diagnosis/getPage?pageNo=2&pageSize=1
     */
    @RequestMapping(value="like",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult Like(PageModel page){
        LOGGER.info("[/DiagnosisController/Like]");
        SimpleResult simpleResult;
        Page p;
        List<Map<String, Object>> mapList;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            p = diagnosisService.queryPagelike(page);
            simpleResult.put("data",p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title create
     *@Description: 新建诊断表
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二 
     *@param diagnosis
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/diagnosis/create?xxx
     */
    @RequestMapping(value="create",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult create(Diagnosis diagnosis){
    	SimpleResult simpleResult;
	    LOGGER.info("[/DiagnosisController/create]");
        try {
            simpleResult=SimpleResult.success();
            diagnosisService.insert(diagnosis);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult; 
    }

    /**
     *
     *@Title deleteById
     *@Description: 根据主键删除诊断表
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二 
     *@param id
     *@return SimpleResult
     *@测试地址: http://localhost:8080/GZ/diagnosis/deleteById?id=0a1b0361374d4512bbbb897bf9d2afb3
     *@throws
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult deleteById(String id) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/DiagnosisController/deleteById]");
        try {
            simpleResult=SimpleResult.success();
            diagnosisService.delete(id);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title update
     *@Description: 更新诊断表
     *@Author fendo
     *@Date 2017年12月26日 12时18分34秒 星期二 
     *@param diagnosis
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult update(Diagnosis diagnosis) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/DiagnosisController/update]");
        try {
            simpleResult=SimpleResult.success();
            diagnosisService.update(diagnosis);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

}