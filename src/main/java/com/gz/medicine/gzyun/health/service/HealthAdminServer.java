package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.bean.HealthyLogin;
import com.gz.medicine.gzyun.health.request.HealthDoctorFormRequest;
import com.gz.medicine.gzyun.health.request.HealthPushMessageVo;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/10/28 0028.
 * Email 1429264916@qq.com
 */
public interface HealthAdminServer {
    /**
     * 新建排版
     * @param request
     * @throws CommonException
     */
    HealthPushMessageVo insertDocFromAndLog(List<HealthDoctorFormRequest> request) throws CommonException;

    /**
     *查询排班根据日期
     * @param date
     * @return
     * @throws CommonException
     */
    List<Map<String, Object>>  queryScheduling(String date,String name) throws CommonException;

    /**
     * 查询排班时段根据docid和日期
     * @param docid
     * @param date
     * @return
     * @throws CommonException
     */
    List<Map<String, Object>> queryDocFormBy(String date,String docid)throws CommonException;

    /**
     * 删除排版表
     * @param id
     */
    void  deleteForm(String id )throws CommonException;

    /**
     * 订单管理分页
     * @param p
     * @return
     * @throws CommonException
     */
    Page queryPageOrderForMoHo(PageModel p) throws CommonException;

    /**
     * 订单详情
     * @param id
     * @return
     * @throws CommonException
     */
    Map<String,Object> queryOrderManageDetail(String id)throws CommonException;

    /**
     * 预约管理
     * @param p
     * @return
     * @throws CommonException
     */

    Page queryYuYue (PageModel p) throws CommonException;

    /**
     * 登录界面
     * @param name
     * @param password
     * @return
     * @throws CommonException
     */
    HealthyLogin loginAdminManage (String name, String password) throws CommonException;
}
