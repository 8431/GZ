package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.bean.HealthInvoiceInfo;
import com.gz.medicine.gzyun.health.bean.HealthInvoiceRecord;
import com.gz.medicine.gzyun.health.bean.OrderLog;
import com.gz.medicine.gzyun.health.request.*;

import java.util.List;
import java.util.Map;


/**
 * Created by json snow on 2017/9/21 0021.
 */
public interface HealthUsrAppService {
    /**
     * 1.我的订单 by json snow
     * @param pm 分页封装查询类
     * @return
     * @throws CommonException
     */

    Page queryMyOrder(PageModel pm)throws CommonException;

    /**
     * 2.订单详情接口(代咨询咨询查看详情) by json snow
     * @param orderId 订单id
     * @return
     * @throws CommonException
     */
    Map<String,Object> queryMyOrderDetail(String orderId)throws CommonException;

    /**
     * 3.我的咨询 by json snow
     * @param pm
     * @return
     * @throws CommonException
     */
    Page queryMyConsultation(PageModel pm)throws CommonException;

    /**
     * 4.我的咨询（查看详情) by json snow
     * @param consultationId
     * @param docId
     * @return
     * @throws CommonException
     */
    Map<String,Object> queryMyConsultationDetail(String consultationId, String docId )throws CommonException;

    /**
     * 5.咨询结束评价接口 by json snow
     * @param hr
     * @return
     * @throws CommonException
     */
    OrderLog insertEvaluateMessageAndLog(HealthevaluateRequest hr)throws CommonException;

    /**
     * 获取医生排版时间
     * @param docid
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> queryDocTime(String docid)throws CommonException;

    /**
     * 修改订单状态
     * @param hr
     * @return
     * @throws CommonException
     */
    OrderLog updateOrderAndLog(HealtheOrderForUpdateRequest hr) throws CommonException;

    /**
     * 增加发票
     * @param hr
     * @throws CommonException
     */
    void insertHealthInvoiceInfo(HealthInvoiceInfoRequest hr) throws CommonException;

    /**
     * 查询发票
     * @param usrid
     * @throws CommonException
     */
    List<HealthInvoiceInfo> queryHealthInvoiceInfoForUsrid(String usrid) throws CommonException;
    /**
     * 修改发票，删除发票
     * @param hf
     * @throws CommonException
     */
    void updateHealthInvoiceInfoForUsrid(HealthInvoiceInfo hf) throws CommonException;

    /**
     * 新增发票记录
     * @param hf
     * @throws CommonException
     */
    HealthPushMessageVo insertHealthInvoiceRecordAndLog(HealthInvoiceRecordRequest hf) throws CommonException;

    /**
     * 查询已开票
     * @param orderid
     * @return
     * @throws CommonException
     */
    HealthInvoiceRecord queryHealthInvoiceRecordForOrderId(String orderid) throws CommonException;

    /**
     * 更新物流信息
     * @param id
     * @return
     * @throws CommonException
     */
    HealthPushMessageVo updateHealthInvoiceRecordForOrderIdAndLog(HealthInvoiceRecord id) throws CommonException;

    /**
     * 订单管理分页
     * @param p
     * @return
     * @throws CommonException
     */
    Page queryPageOrderForMoHo(PageModel p) throws CommonException;

    /**
     * 聊天记录分页查询
     * @param p
     * @return
     * @throws CommonException
     */
    Page queryPageChatMsg(PageModel p) throws CommonException;

    /**
     * 咨询服务分页查询
     * @param p
     * @return
     * @throws CommonException
     */
    Page queryPageMyOrderForV2(PageModel p) throws CommonException;

    /**
     * 取消订单
     * @param orderid
     */
     OrderLog cancelOrderAndLog(String orderid,String loginid)throws CommonException;

    /**
     * 查看订单详情
     * @param orderid
     * @return
     * @throws CommonException
     */
    Map<String, Object>  queryOrderDetail(String orderid)throws CommonException;

    /**
     * 查看详情
     * @param orderid
     * @return
     * @throws CommonException
     */
    Map<String,Object> queryOrderFinshMsg(String orderid)throws CommonException;

    /**
     * 更新咨询时长
     * @param id
     * @param consultinghours
     * @throws CommonException
     */
    OrderLog  updateHoursAndLog(String id,String consultinghours,String usrid)throws CommonException;

    /**
     * 更新咨询开始时间
     * @param id
     * @throws CommonException
     */
    void updateConsultationstarttime(String id)throws CommonException;

    /**
     * 根据日期查询医生排版
     * @param docid
     * @param date
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>>queryDoctorFormByDate(String docid,String date)throws CommonException;
}
