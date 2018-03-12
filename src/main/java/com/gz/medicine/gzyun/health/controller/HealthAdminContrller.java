package com.gz.medicine.gzyun.health.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthyLogin;
import com.gz.medicine.gzyun.health.mapper.HealthyLoginMapper;
import com.gz.medicine.gzyun.health.request.HealthDoctorFormRequest;
import com.gz.medicine.gzyun.health.service.HealthAdminServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import static com.gz.medicine.common.util.ValidateWithException.validates;

/**
 * Created by dlf on 2017/10/28 0028.
 * Email 1429264916@qq.com
 */
@RestController
@RequestMapping("/v2/admin/")
public class HealthAdminContrller {
    @Autowired
    Validator validator;
    @Autowired
    HealthAdminServer healthadminserver;
  
    /**---------------后台界面排版管理功能模块【start】-------------*/
    //新建排班
    @RequestMapping(value = "/addScheduling", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult addScheduling(@RequestBody List<HealthDoctorFormRequest> request)  {
        SimpleResult sr = null;
        StringBuffer sb=new StringBuffer();
        if(request!=null&&request.size()>0){

            for(HealthDoctorFormRequest r:request){
                String result=validates(validator, r);
               if(result!=null){
                   sb.append(result);
               }
            }
        }
        if(!StringUtils.isEmpty(sb.toString())){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), sb.toString());
        }
        try {
            healthadminserver.insertDocFromAndLog(request);
      } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        return sr;
    }
    //排班查询
    @RequestMapping(value = "/queryScheduling", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryScheduling(@RequestParam(value = "schedate", required = true) String schedate,
                                        @RequestParam(value = "docname", required = false) String docname) {
        SimpleResult sr = null;
        List<Map<String,Object>> list= null;
        try {
            list = healthadminserver.queryScheduling(schedate,docname);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("data",list);
        return sr;
    }
    //排班时间段查询
    @RequestMapping(value = "/queryFormTime", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryFormTime(@RequestParam(value = "docid", required = true) String docid,
                                        @RequestParam(value = "date", required = true) String date
                                        ) {
        SimpleResult sr = null;
        List<Map<String,Object>> list= null;
        try {
            list = healthadminserver.queryDocFormBy(date,docid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("date",list);
        return sr;
    }
    //排班删除
    @RequestMapping(value = "/deleteForm", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult deleteForm(@RequestParam(value = "id", required = true) String id ) {
        SimpleResult sr = null;
        try {
            healthadminserver.deleteForm(id);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        return sr;
    }
    /**---------------后台界面排版管理功能模块【end】-------------*/
    //--------------------------------------------------完美分割线----------------------------------------------------------//

    /**---------------后台界面订单管理功能模块【start】-------------*/

    //订单分页查询
    @RequestMapping(value = "/queryPageOrderForMoHo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryPageOrderForMoHo(PageModel p) {
        SimpleResult sr = null;
        Page page= null;
        try {
            page = healthadminserver.queryPageOrderForMoHo(p);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("data",page);
        return sr;
    }
    //订单详情查询
    @RequestMapping(value = "/queryOrderManageDetail ", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryOrderManageDetail (@RequestParam(value = "orderid", required = true)String orderid)  {
        SimpleResult sr = null;
        Map<String,Object> mp= null;
        try {
            mp = healthadminserver.queryOrderManageDetail(orderid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("data",mp);
        return sr;
    }
    /********************************************预约管理****************************************************/

    //预约管理
    @RequestMapping(value = "/queryYuYue ", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryYuYue (PageModel p) {
        SimpleResult sr = null;
        Page pg= null;
        try {
            pg = healthadminserver.queryYuYue(p);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("data",pg);
        return sr;
    }
    //后台登录
    @RequestMapping(value = "/login ", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult login (@RequestParam(value = "name", required = true)String name,
                               @RequestParam(value = "password", required = true)String password) {
        SimpleResult sr = null;
        HealthyLogin   hn= null;
        try {
           hn= healthadminserver.loginAdminManage(name,password);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr=SimpleResult.success();
        sr.put("data",hn);
        return sr;
    }


}
