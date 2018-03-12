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


import com.gz.medicine.yun.doctor.bean.InspectionItems;
import com.gz.medicine.yun.doctor.service.InspectionItemsService;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName InspectionItemsController
 * @PackageName com.gz.medicine.yun.doctor.controller
 * @Description 病历中的-检查项目 Controller
 * @Data 2017年12月22日 16时28分09秒 星期五 
 **/
@Controller
@RequestMapping("inspectionitems")
public class InspectionItemsController {

	public static final Logger LOGGER = Logger.getLogger(InspectionItemsController.class);

    @Autowired
    private InspectionItemsService inspectionItemsService;

    /**
     *
     *@Title findById
     *@Description: 根据ID获取病历中的-检查项目
     *@Author fendo
     *@Date 2017年12月22日 16时28分09秒 星期五 
     *@param id(主键)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/inspectionitems/findById?id=xxxx
     */
    @RequestMapping(value="findById",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult findById(String id){
        LOGGER.info("[/InspectionItemsController/findById]");
		SimpleResult simpleResult;
		InspectionItems inspectionItems;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            inspectionItems = inspectionItemsService.find(id);
            simpleResult.put("data",inspectionItems);
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
     *@Date 2017年12月22日 16时28分09秒 星期五 
     *@param page(分页数据)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/inspectionitems/getPage?pageNo=2&pageSize=1
     */
    @RequestMapping(value="getPage",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult getPage(PageModel page){
        LOGGER.info("[/InspectionItemsController/getPage]");
        SimpleResult simpleResult;
        Page p;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            p = inspectionItemsService.getPage(page);
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
     *@Description: 新建病历中的-检查项目
     *@Author fendo
     *@Date 2017年12月22日 16时28分09秒 星期五 
     *@param inspectionItems
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/inspectionitems/create?xxx
     */
    @RequestMapping(value="create",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult create(InspectionItems inspectionItems){
    	SimpleResult simpleResult;
	    LOGGER.info("[/InspectionItemsController/create]");
        try {
            simpleResult=SimpleResult.success();
            inspectionItemsService.insert(inspectionItems);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult; 
    }

    /**
     *
     *@Title deleteById
     *@Description: 根据主键删除病历中的-检查项目
     *@Author fendo
     *@Date 2017年12月22日 16时28分09秒 星期五 
     *@param id
     *@return SimpleResult
     *@测试地址: http://localhost:8080/GZ/inspectionitems/deleteById?id=0a1b0361374d4512bbbb897bf9d2afb3
     *@throws
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult deleteById(String id) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/InspectionItemsController/deleteById]");
        try {
            simpleResult=SimpleResult.success();
            inspectionItemsService.delete(id);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title update
     *@Description: 更新病历中的-检查项目
     *@Author fendo
     *@Date 2017年12月22日 16时28分09秒 星期五 
     *@param inspectionItems
     *@return SimpleResult
     *@throws
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult update(InspectionItems inspectionItems) throws Exception {
        SimpleResult simpleResult;
	    LOGGER.info("[/InspectionItemsController/update]");
        try {
            simpleResult=SimpleResult.success();
            inspectionItemsService.update(inspectionItems);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

}