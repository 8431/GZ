package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.reponse.ConsultingOrderReponse;
import com.gz.medicine.gzyun.health.reponse.DoctorParticularsReponse;
import com.gz.medicine.gzyun.health.reponse.HealthConsultationReponse;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorFormReponse;
import com.gz.medicine.gzyun.health.request.OrderSubmittedRequest;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthConsultationService
 * @PackageName com.gz.medicine.gzyun.health.service
 * @Description 心理咨询 service
 * @Data 2017-09-21 10:47
 **/
public interface HealthConsultationService {

    /**
     * 心理医生列表接口
     * @param page
     * @return
     * @throws CommonException
     */
    Page PsychoLogistList(PageModel page)throws CommonException;

    /**
     * 医生详情
     * @param docid
     * @return
     * @throws CommonException
     */
    DoctorParticularsReponse DoctorParticulars(String docid)throws CommonException;

    /**
     * 用户评价
     * @param page
     * @return
     * @throws CommonException
     */
    Page UserEvaluation(PageModel page)throws CommonException;

    /**
     * 咨询订单页面接口
     * @return
     * @throws CommonException
     */
    ConsultingOrderReponse ConsultOrder(String consultationmethod, String docid, String usrid)throws  CommonException;


    /**
     * 医生排班
     * @param docid
     * @return
     * @throws CommonException
     */
    List<Map<String,String>> DoctorScheduling(String docid)throws CommonException;

    /**
     * 订单提交
     * @return
     * @throws CommonException
     */
    SimpleResult OrderSubmitted(OrderSubmittedRequest orderSubmittedRequest)throws CommonException;


    /**
     * 更改订单的状态
     * @param orderid
     * @return
     * @throws CommonException
     */
    Boolean UpdateOrderState(String orderid)throws CommonException;


    /**
     * 更改订单的状态
     * @param orderid
     * @return
     * @throws CommonException
     */
    Boolean UpdateOrderState(String orderid,String orderflag)throws CommonException;

    /**
     * 咨询小结后修改订单的状态为完成,并设置订单的发票状态为
     * @return
     * @param orderid
     * @throws CommonException
     */
    Boolean updateOrder(String orderid)throws  CommonException;

    /**
     * 根据患者ID获取详情
     */
    Map<String,String> GetUsr(String usrid)throws  CommonException;

    /**
     * 根据医生ID获取排班时间
     */
    List<HealthDoctorFormReponse> GetDoctorForm(String docid,String formDate) throws CommonException;

    /**
     * 获取当前月的记录
     * @param id
     * @return
     * @throws CommonException
     */
    List<HealthDoctorForm> GetHealthDoctorFormList(String id)throws CommonException;



    Page GetPsychoLogist(PageModel page)throws CommonException;

    /**
     * 根据订单ID获取咨询信息
     * @param orderid
     * @return
     * @throws CommonException
     */
    HealthConsultation selectByPrimaryOrderId(String orderid) throws CommonException;

    /**
     * 更改咨询信息
     * @param healthConsultation
     * @return
     * @throws CommonException
     */
    int updateByPrimaryKeySelective(HealthConsultation healthConsultation) throws CommonException;

    /**
     * 评价消息点击查看详情
     * **/
    List<HealthConsultationReponse> queryMessage(String orderid) throws CommonException;

    /**
     * 点击咨询消息触发消除未读以及判断当前时间是否在订单时间内
     * **/
    String updateMess(HealthConsultation data) throws CommonException;

    /**
     * 根据预约开始时间与结束时间去数据库匹配数据
     * @param startTime
     * @param endTime
     * @return
     * @throws CommonException
     */
    boolean checkData(String startTime, String endTime,String userid)throws CommonException;

    /**
     * 根据订单状态获取订单
     * @param page
     * @return
     * @throws CommonException
     */
    Page getOrderAll(PageModel page)throws CommonException;


    /**
     * 根据用户ID获取所有订单数
     * @param usrid
     * @return
     * @throws CommonException
     */
    Map getOrderSum(String usrid)throws CommonException;


    /**
     * 根据用户ID获取咨询小结
     * @param page
     * @return
     * @throws CommonException
     */
    Page getConsultaion(PageModel page)throws CommonException;
}
