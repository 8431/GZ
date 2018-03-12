package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.user.service.UsrService;
import com.gz.medicine.yun.doctor.service.DTCaseHistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName InterrogationController
 * @PackageName com.gz.medicine.yun.doctor.controller
 * @Description 问诊记录 Controller
 * @Data 2017-08-17 10:43
 **/
@Controller
@RequestMapping(value="interrogation")
public class DTInterrogationController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(DTInterrogationController.class);


    @Autowired
    private DTCaseHistoryService dtCaseHistoryService;

    @Autowired
    private UsrService usrService;

    /**
     *
     *@Title Particulars
     *@Description: 患者详情,根据用户
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param record
     *@return int
     *@throws
     */
    @RequestMapping(value = "getparticulars",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetParticulars(PageModel page){
        SimpleResult simpleResult=null;
        Usr usr=null;
        Page p=null;
        try {
        	// TODO 代码未提交自己修改
//            usr=usrService.selectByGuid((String) page.getPage().get("sickguid"));
            p=dtCaseHistoryService.page(page);
        } catch (Exception e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
        }

        simpleResult=SimpleResult.success();
        Map<String,String> map=new HashMap<String, String>();
        map.put("guid",usr.getGuid());
        map.put("sex",usr.getSex());
        map.put("mobile",usr.getMobile());
        map.put("IDCARD",usr.getIdcard());
        map.put("MEDICARECARD",usr.getMedicarecard());
        p.put("usr",map);

        simpleResult.put("data",p);
        return  simpleResult;
    }



}
