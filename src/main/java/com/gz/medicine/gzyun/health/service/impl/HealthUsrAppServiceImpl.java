package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.*;
import com.gz.medicine.gzyun.health.common.CommonExceptionUtil;
import com.gz.medicine.gzyun.health.common.GzHealthyCodeEnum;
import com.gz.medicine.gzyun.health.common.GZMessage;
import com.gz.medicine.gzyun.health.mapper.*;
import com.gz.medicine.gzyun.health.request.*;
import com.gz.medicine.gzyun.health.service.HealthUsrAppService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by json snow on 2017/9/21 0021.
 */
@Service("HealthUsrAppService")
public class HealthUsrAppServiceImpl implements HealthUsrAppService {
    public static final Logger LOGGER = Logger.getLogger(HealthUsrAppServiceImpl.class);

    @Autowired
    HealthyOrderMapper healthyordermapper;
    @Autowired
    HealthConsultationMapper healthconsultationmapper;
    @Autowired
    healthevaluateMapper healthevaluatemapper;
    @Autowired
    HealthInvoiceInfoMapper healthinvoiceinfomapper;
    @Autowired
    HealthInvoiceRecordMapper healthinvoicerecordmapper;
    @Autowired
    OrderLogMapper orderlogmapper;
    @Autowired
    healthDoctorMapper healthdoctormapper;
    @Autowired
    HealthDoctorFormMapper healthdoctorformmapper;
    @Autowired
    HealthyLoginMapper healthyloginmapper;


    @Override
    public Page queryMyOrder(PageModel pm) throws CommonException {
        Page pe = pm.getPage();
        if (StringUtils.isEmpty(pe.get("usrid"))) {
            throw new CommonException("患者id不能为空");
        }
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageMyOrder(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("我的订单Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的订单Server层异常:", e);
        }
        return pe;
    }

    @Override
    public Map<String, Object> queryMyOrderDetail(String orderId) throws CommonException {
        Map<String, Object> mpMangeLi = null;
        if (StringUtils.isEmpty(orderId)) {
            throw new CommonException("订单id不能为空");
        }
        try {
            mpMangeLi = healthyordermapper.queryMyOrderDetail(orderId);
        } catch (Exception e) {
            LOGGER.error("我的订单详情Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的订单详情Server层异常:", e);
        }
        return mpMangeLi;
    }

    @Override
    public Page queryMyConsultation(PageModel pm) throws CommonException {

        Page pe = pm.getPage();
        if (StringUtils.isEmpty(pe.get("usrid")) || StringUtils.isEmpty(pe.get("consultingstate"))) {
            throw new CommonException("患者id和咨询状态不能为空");
        }
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageMyConsultation(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("我的咨询Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的咨询Server层异常:", e);
        }
        return pe;
    }


    @Override
    public Map<String, Object> queryMyConsultationDetail(String consultationId, String docId) throws CommonException {
        if (StringUtils.isEmpty(consultationId) || StringUtils.isEmpty(docId)) {
            throw new CommonException("医生id和咨询id不能为空");
        }
        Map<String, Object> result = new HashedMap();
        List<Map<String, Object>> consultation = null;
        try {
            consultation = healthyordermapper.queryConsultationScore(consultationId);
            Map<String, Object> docScore = healthyordermapper.queryDocScore(docId);
            if (StringUtils.isEmpty(docScore.get("rate"))) {
                docScore.put("rate", "5");
            }
            result.put("docdetail", docScore);
            if (consultation != null && consultation.size() > 1) {
                throw new CommonException();
            } else if (consultation.size() == 1) {
                result.put("consultation", consultation.get(0));
            } else if (consultation.size() == 0) {
                result.put("consultation", null);
            }

        } catch (Exception e) {
            if (consultation != null && consultation.size() > 1) {
                throw new CommonException("1001", "一个订单只能有一份咨询记录，结果有：" + consultation.size() + "条");
            }
            LOGGER.error("我的咨询详情Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的咨询详情Server层异常:", e);
        }

        return result;
    }

    @Override
    public OrderLog insertEvaluateMessageAndLog(HealthevaluateRequest hr) throws CommonException {
        //构造日志信息-----------start
        OrderLog og = new OrderLog();
        BeanUtils.copyProperties(hr, og);
        og.setOperationcontent("咨询结束，进行评价");//操作内容
        //构造日志信息-----------end
        try {
            healthevaluate he = new healthevaluate();
            BeanUtils.copyProperties(hr, he);
            int evaluat = healthevaluatemapper.insertSelective(he);

            HealthConsultation hn = new HealthConsultation();
            hn.setId(hr.getConsultationid());
            hn.setConsultinghours(hr.getConsultinghours());
            hn.setConsultingstate("2");//已咨询
            //2017-09-21 17:00:21
            // hn.setConsultationstarttime(TimeUtil.pStringToDate(hr.getConsultationstarttime()));
            int consultation = healthconsultationmapper.updateByPrimaryKeySelective(hn);
            //修改订单状态已完成
            HealthyOrder hd = new HealthyOrder();
            hd.setId(hr.getOrderid());
            hd.setOrderstate("5");
            healthyordermapper.updateByPrimaryKeySelective(hd);

        } catch (Exception e) {
            LOGGER.error("提交评价Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "提交评价Server层异常:", e);
        }

        return og;
    }

    /**
     * 获取医生排版时间
     */
    @Override
    public List<Map<String, Object>> queryDocTime(String docid) throws CommonException {

        List<Map<String, Object>> sr = new ArrayList<Map<String, Object>>();
        if (StringUtils.isEmpty(docid)) {
            throw new CommonException("医生id不能为空");
        }
        try {
            sr = healthyordermapper.queryDocTime(docid);
        } catch (Exception e) {
            LOGGER.error("获取医生排版Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "获取医生排版Server层异常:", e);
        }
        return sr;
    }

    /**
     * 需求还未明确
     * 取消/删除 订单
     */
    @Override
    public OrderLog updateOrderAndLog(HealtheOrderForUpdateRequest request) throws CommonException {
        //构造日志信息-----------start
        OrderLog og = new OrderLog();
        BeanUtils.copyProperties(request, og);
        boolean key = true;
        //取消订单
        if ("3".equals(request.getState())) {
            og.setOperationcontent("取消订单");//操作内容
        } else if ("4".equals(request.getState())) {
            og.setOperationcontent("删除订单");//操作内容
        } else {
            //错误操作
            og.setOperationcontent("错误操作，入参为：" + request.getState());//操作内容
            key = false;
        }
        ;
        //构造日志信息-----------end
        if (key) {
            Map<String, Object> mp = new HashedMap();
            mp.put("orderstate", request.getState());
            mp.put("orderid", request.getOrderid());
            try {
                healthyordermapper.updateOrderByOrderId(mp);
            } catch (Exception e) {
                LOGGER.error("updateOrderAndLog()修改订单状态异常：" + e.getMessage(), e);
                throw new CommonException("COM001", "修改订单状态异常:", e);
            }
        }
        return og;
    }

    @Override
    public void insertHealthInvoiceInfo(HealthInvoiceInfoRequest hr) throws CommonException {
        HealthInvoiceInfo hf = new HealthInvoiceInfo();
        BeanUtils.copyProperties(hr, hf);
        try {
            healthinvoiceinfomapper.insertSelective(hf);
        } catch (Exception e) {
            LOGGER.error("新增发票异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "新增发票异常:", e);
        }
    }

    @Override
    public List<HealthInvoiceInfo> queryHealthInvoiceInfoForUsrid(String usrid) throws CommonException {
        List<HealthInvoiceInfo> re = new ArrayList<HealthInvoiceInfo>();
        try {
            re = healthinvoiceinfomapper.queryHealthInvoiceInfoForUsrid(usrid);
        } catch (Exception e) {
            LOGGER.error("查询发票列表异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询发票列表异常:", e);
        }
        return re;

    }

    @Override
    public void updateHealthInvoiceInfoForUsrid(HealthInvoiceInfo usrid) throws CommonException {
        if (StringUtils.isEmpty(usrid)) {
            throw new CommonException("用户id不能为空");
        }
        try {
            healthinvoiceinfomapper.updateHealthInvoiceInfo(usrid);
        } catch (Exception e) {
            LOGGER.error("查询发票列表异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询发票列表异常:", e);
        }

    }

    /**
     * 2017-11-13发票记录新增短信提醒
     * 用户短信:【贯众云医】订单号：********发票申请成功，我们将在2-3个工作日内为您添加物流信息。
     * 客户短信:【贯众云医】发票申请，用户AA（138****6715）申请了《XX咨询》服务发票，订单日期：yyyy-MM-dd hh:mi，订单号：********，请及时给予开票。
     * 财务短信:【贯众云医】发票申请，用户AA（138****6715）申请了《XX咨询》服务发票，订单日期：yyyy-MM-dd hh:mi，订单号：********，请及时给予开票。
     *
     * @param hd
     * @throws CommonException
     */
    @Override
    public HealthPushMessageVo insertHealthInvoiceRecordAndLog(HealthInvoiceRecordRequest hd) throws CommonException {
        HealthInvoiceRecord hf = new HealthInvoiceRecord();
        BeanUtils.copyProperties(hd, hf);
        HealthPushMessageVo hv = new HealthPushMessageVo();
        hv.setSendMsgState(true);
        List<GZMessage> gzLi = new ArrayList<GZMessage>();
        Map<String, Object> orderMp = null;
        try {
            orderMp = healthyordermapper.queryOrderById(hd.getOrderid());
            if (orderMp != null && orderMp.size() > 0) {
                String consultationmethodname = (String) orderMp.get("consultationmethodname");//咨询方式
                String createdate = (String) orderMp.get("createdate");//订单日期
                //用户短信
                GZMessage yhGm = new GZMessage();
                yhGm.setSendMsgContent(MessageFormat.format(PropertyUtil.getPropery("gz.sqfp.yhdx"), hd.getOrderid()));
                yhGm.setPhoneNum(hd.getPhone());
                gzLi.add(yhGm);

                //客服短信
                List<HealthyLogin> kfhgLi = healthyloginmapper.queryAdminByRole("8");
                String kfcontent = MessageFormat.format(PropertyUtil.getPropery("gz.sqfp.kfdx"), hd.getConsignee(), hd.getPhone(), consultationmethodname, createdate, hd.getOrderid());

                for (HealthyLogin l : kfhgLi) {
                    if(!StringUtils.isEmpty(l.getPhone())){
                        GZMessage kfGm = new GZMessage();
                        kfGm.setSendMsgContent(kfcontent);
                        kfGm.setPhoneNum(l.getPhone());
                        gzLi.add(kfGm);
                    }
                }
                // 财务短信
                List<HealthyLogin> cwhgLi = healthyloginmapper.queryAdminByRole("9");
                String cwcontent = MessageFormat.format(PropertyUtil.getPropery("gz.sqfp.cwdx"), hd.getConsignee(), hd.getPhone(), consultationmethodname, createdate, hd.getOrderid());
                for (HealthyLogin k : cwhgLi) {
                    if(!StringUtils.isEmpty(k.getPhone())){
                        GZMessage cwGm = new GZMessage();
                        cwGm.setSendMsgContent(cwcontent);
                        cwGm.setPhoneNum(k.getPhone());
                        gzLi.add(cwGm);
                    }
                }
            } else {
                throw new CommonException("该订单不存在，请检查订单id");
            }
            hv.setGzmessage(gzLi);
            healthinvoicerecordmapper.insertSelective(hf);
            //修改订单状态为已开票
            Map<String, String> mp = new HashedMap();
            mp.put("orderid", hd.getOrderid());
            mp.put("invoicestate", "1");
            healthyordermapper.updateOrderByOrderId(mp);
        } catch (Exception e) {
            hv = null;
            LOGGER.error("新增发票记录异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "新增发票记录异常:", e);
            }
        }
        return hv;
    }


    @Override
    public HealthInvoiceRecord queryHealthInvoiceRecordForOrderId(String orderid) throws CommonException {
        HealthInvoiceRecord hf = null;
        if (StringUtils.isEmpty(orderid)) {
            throw new CommonException("订单id不能为空");
        }
        try {
            hf = healthinvoicerecordmapper.queryHealthInvoiceRecordForOrderId(orderid);
        } catch (Exception e) {
            LOGGER.error("查询发票记录列表异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询发票记录列表异常:", e);
        }

        return hf;
    }

    //物流信息加入推送功能
    @Override
    public HealthPushMessageVo updateHealthInvoiceRecordForOrderIdAndLog(HealthInvoiceRecord hd) throws CommonException {
        if (StringUtils.isEmpty(hd.getId()) || StringUtils.isEmpty(hd.getExpressnumber()) || StringUtils.isEmpty(hd.getExpresstype())) {
            throw new CommonException("id,物流单号,物流名称不能为空！");
        }
        HealthPushMessageVo hg = new HealthPushMessageVo();
        try {
            HealthInvoiceRecord hrd = healthinvoicerecordmapper.queryByid(hd.getId());
            if (hrd != null) {
                hg.setId(UUIDTool.getUUID());
                hg.setMessagename("系统消息");
                hg.setMessagetype("1");
                hg.setCreatedate(new Date());
                hg.setPushtime(new Date());
                hg.setUserid(hrd.getUsrid());
                //发送短信设置
                hg.setSendMsgState(true);
                hg.setPhoneNum(hrd.getPhone());
                Map<String, Object> orderMp = healthyordermapper.queryOrderById(hrd.getOrderid());
                String consultationmethodname = "";
                if (orderMp != null && orderMp.size() > 0) {
                    consultationmethodname = (String) orderMp.get("consultationmethodname");//咨询方式
                } else {
                    throw new CommonException("该订单号不存在");
                }
                String message = MessageFormat.format(PropertyUtil.getPropery("gz.wlxx.tjwldh"), consultationmethodname, hrd.getOrderid(), hd.getExpresstype(), hd.getExpressnumber());
                hg.setSendMsgContent(message);
                //增加订单id by 2017-11-06 zlp
                hg.setOrderid(hrd.getOrderid());
                hg.setPushmessage("您的\"" + consultationmethodname + "\"服务发票已经寄出，点击查看详情!");
                hg.setPushtype("11");
                healthinvoicerecordmapper.updateHealthInvoiceRecordForOrderId(hd);
            } else {
                throw new CommonException("该物流记录不存在，请检查id是否正确");
            }

        } catch (Exception e) {

            LOGGER.error("增加物流信息异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "增加物流信息异常:", e);
            }

        }
        return hg;
    }

    @Override
    public Page queryPageOrderForMoHo(PageModel pm) throws CommonException {
        Page pe = pm.getPage();
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageOrderForMoHo(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("后台订单管理订单Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "后台订单管理订单Server层异常:", e);
        }
        return pe;
    }

    @Override
    public Page queryPageChatMsg(PageModel pm) throws CommonException {

        Page pe = pm.getPage();
        String usrid = (String) pe.get("usrid");
        String tousr = (String) pe.get("tousr");
        if (StringUtils.isEmpty(usrid) || StringUtils.isEmpty(tousr)) {
            throw new CommonException("usrid或者tousr不能为空");
        }
        Map<String, Object> mp = new HashedMap();
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageChatMsg(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("聊天记录查询Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "聊天记录查询Server层异常:", e);
        }
        return pe;
    }

    @Override
    public Page queryPageMyOrderForV2(PageModel p) throws CommonException {
        Page pe = p.getPage();
        if (StringUtils.isEmpty(pe.get("usrid"))) {
            throw new CommonException("患者id不能为空");
        }
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageMyOrderForV2(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("咨询服务Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "咨询服务Server层异常:", e);
        }
        return pe;
    }

    @Override
    public OrderLog cancelOrderAndLog(String orderid, String usrid) throws CommonException {
        if (StringUtils.isEmpty(orderid) || StringUtils.isEmpty(usrid)) {
            throw new CommonException("订单id,用户id不能为空");
        }
        OrderLog og = new OrderLog();
        og.setQxdd(true);
        HealthPushMessageVo hv = new HealthPushMessageVo();
        og.setHealthpushmessagevo(hv);
        hv.setId(UUIDTool.getUUID());
        hv.setMessagename("系统消息");
        hv.setMessagetype("1");
        hv.setCreatedate(new Date());
        hv.setPushtime(new Date());
        //发送短信设置
        hv.setSendMsgState(false);

        Map<String, Object> hd = orderlogmapper.queryUsrById(usrid);
        if (hd != null && hd.size() > 0) {
            og.setUpdatename((String) hd.get("name"));
            og.setCreatename((String) hd.get("name"));
        } else {
            throw new CommonException("该用户不存在！非法操作！");
        }
        try {

            HealthyOrder order = healthyordermapper.selectOrderById(orderid);
            if (order != null) {
                og.setOrderid(orderid);//日志表订单id
                //订单状态：待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
                String state = order.getOrderstate();
                if ("1".equals(state)) {
                    //待支付(1)直接取消订单
                    order.setOrderstate("3");
                    og.setOrderstate("3");
                    og.setOperationcontent("咨询服务，待支付，取消订单");
                    updateDocForm(order);
                } else if ("2".equals(state)) {
                    String time = order.getReservationdate() + order.getReserstarttime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm");
                    Date yuyueTime = sdf.parse(time);
                    long currentTime = new Date().getTime();
                    long timeNum = yuyueTime.getTime() - currentTime;
                    //已付款，取消订单只能在咨询开始前30分钟取消
                    if (timeNum >= 1000 * 60 * 180) {
                        order.setUpdatedate(new Date());
                        order.setOrderstate("6");
                        og.setOrderstate("6");
                        og.setOperationcontent("咨询服务，已付款，取消订单");
                        updateDocForm(order);
                    } else {
                        throw new CommonException("离预约服务开始时间前3小时内不可以取消订单！");
                    }

                } else {
                    throw new CommonException("违法操作，取消订单只能针对，待付款，付款成功状态");
                }
                healthyordermapper.updateByPrimaryKeySelective(order);

            } else {
                throw new CommonException("订单id不存在，数据入参有误！");
            }


            Map<String, Object> orderMp = healthyordermapper.queryOrderById(orderid);
            String consultationmethodname = (String) orderMp.get("consultationmethodname");//咨询方式
            String docname = (String) orderMp.get("docname");//医生名称
            hv.setOrderid(orderid);
            hv.setUserid(order.getUsrid());
            hv.setPushmessage("您已申请取消" + docname + "咨询师\"" + consultationmethodname + "\"服务，点击查看详情!");
            hv.setPushtype("11");
        } catch (Exception e) {
            LOGGER.error("取消订单Server层异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw  new CommonException(GzHealthyCodeEnum.HEALTHORDER_CANCELORDERANDLOG_CODE,e.getMessage(),e);
            } else {
                throw  new CommonException(GzHealthyCodeEnum.HEALTHORDER_CANCELORDERANDLOG_CODE,e);
            }

        }
        return og;
    }

    private void updateDocForm(HealthyOrder order) throws Exception {
        //一旦用户取消订单，用户所预约的医生的排版时段要由已预约改成未预约
        String statrtTime = order.getReserstarttime();//预约开始时间
        String formdate = order.getReservationdate();//预约日期
        String docid = order.getDocid();//医生id
        String statrtEnd = order.getReserendtime();//预约结束时间
        Map<String, Object> paramMp = new HashedMap();
        paramMp.put("docid", docid);
        paramMp.put("formdate", formdate);
        paramMp.put("formstarttime", statrtTime);
        paramMp.put("formendtime", statrtEnd.substring(0, 2) + ":00");
        healthdoctorformmapper.updateDocFormTime(paramMp);
    }

    @Override
    public Map<String, Object> queryOrderDetail(String orderid) throws CommonException {
        Map<String, Object> result = new HashedMap();
        if (StringUtils.isEmpty(orderid)) {
            throw new CommonException("订单id不能为空");
        }
        try {
            Map<String, Object> hdMp = healthyordermapper.queryOrderById(orderid);
            if (hdMp == null || hdMp.size() == 0) {
                throw new CommonException("该订单不存在，请检查订单号");
            }
            String docid = (String) hdMp.get("docid");
            if (StringUtils.isEmpty(docid)) {
                throw new CommonException("该数据不合法，docid是空，请检查！");
            }
            //预约信息
            Map<String, Object> yuyueMp = new HashedMap();
            yuyueMp.put("usrname", hdMp.get("usrname"));//姓名
            yuyueMp.put("usrsex", hdMp.get("usrsex"));//性别
            yuyueMp.put("usrbirth", hdMp.get("usrbirth"));//出生年月
            yuyueMp.put("usrphone", hdMp.get("usrphone"));//联系方式
            yuyueMp.put("reservationdate", hdMp.get("reservationdate"));//预约日期
            yuyueMp.put("reservationtime", hdMp.get("reservationtime"));//预约时间

            //订单信息
            Map<String, Object> orderMp = new HashedMap();
            orderMp.put("createdate", hdMp.get("createdate"));//订单日期
            orderMp.put("ordercode", hdMp.get("ordercode"));//订单编号
            orderMp.put("orderamount", hdMp.get("orderamount"));//订单金额
            //预约咨询师
            Map<String, Object> docScore = healthyordermapper.queryDocScore(docid);
            docScore.put("consultationmethodname", hdMp.get("consultationmethodname"));//咨询方式
            docScore.put("reserstarttime", hdMp.get("reserstarttime"));//预约时间
            docScore.put("orderid", orderid);
            docScore.put("consultationid", hdMp.get("consultationid"));
            //订单状态
            Map<String, Object> orderStateMp = new HashedMap();
            orderStateMp.put("orderstate", hdMp.get("orderstate"));
            orderStateMp.put("createtime", hdMp.get("createtime"));
            orderStateMp.put("invoicestate", hdMp.get("invoicestate"));
            orderStateMp.put("operationcontent", null);
            OrderLog og = orderlogmapper.queryOrderLogByOrderId(orderid);
            if (og != null) {
                orderStateMp.put("operationcontent", og.getOperationcontent());
            }
            result.put("yuyueMp", yuyueMp);
            result.put("orderMp", orderMp);
            result.put("docMp", docScore);
            result.put("orderStateMp", orderStateMp);

        } catch (Exception e) {
            LOGGER.error("查看订单详情Server层异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "查看订单详情Server层异常:", e);
            }
        }

        return result;
    }

    @Override
    public Map<String, Object> queryOrderFinshMsg(String orderid) throws CommonException {
        if (StringUtils.isEmpty(orderid)) {
            throw new CommonException("订单不能为空");
        }
        Map<String, Object> result = new HashedMap();

        try {
            Map<String, Object> consultation = healthyordermapper.queryConsultationScoreForV2(orderid);
            if (consultation != null && consultation.size() > 0) {
                String docid = (String) consultation.get("docid");
                Map<String, Object> docScore = healthyordermapper.queryDocScore(docid);
                result.put("docdetail", docScore);
                result.put("consultation", consultation);
            }
        } catch (Exception e) {

            LOGGER.error("我的咨询详情Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的咨询详情Server层异常:", e);
        }
        return result;
    }

    @Override
    public OrderLog updateHoursAndLog(String id, String consultinghours, String usrid) throws CommonException {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(consultinghours)) {
            throw new CommonException("订单id和时长不能为空");
        }
        OrderLog og = new OrderLog();
        og.setOperationcontent("挂断电话，修改订单状态为【已完成】，并更新咨询时长");
        og.setCreatedate(new Date());
        og.setUpdatedate(new Date());
        og.setOperationaccount(usrid);
        og.setOperatingtime(new Date());
        Map<String, Object> hd = orderlogmapper.queryUsrById(usrid);
        if (hd != null && hd.size() > 0) {
            og.setCreatename((String) hd.get("name"));
            og.setUpdatename((String) hd.get("name"));
        } else {
            throw new CommonException("用户id有误，不存在该用户！");
        }
        try {

            og.setUpdatedate(new Date());
            HealthConsultation hcn = healthconsultationmapper.selectByPrimaryKey(id);
            if (hcn != null) {
                HealthConsultation hn = new HealthConsultation();
                hn.setId(id);
                hn.setConsultinghours(consultinghours);
                hn.setConsultingstate("2");
                healthconsultationmapper.updateByPrimaryKeySelective(hn);
                Map<String, Object> sqlParam = new HashedMap();
                sqlParam.put("orderstate", "5");
                sqlParam.put("orderid", hcn.getOrderid());
                healthyordermapper.updateOrderByOrderId(sqlParam);
                og.setOrderid(hcn.getOrderid());
                og.setOrderstate("5");
            } else {
                throw new CommonException("id有误，该条咨询不存在！");
            }

        } catch (Exception e) {
            LOGGER.error("更新订单时长Server层异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "更新订单时长Server层异常:", e);
            }
        }
        return og;

    }

    @Override
    public void updateConsultationstarttime(String id) throws CommonException {
        try {
            HealthConsultation hc = healthconsultationmapper.selectByPrimaryKey(id);
            if (hc != null && hc.getConsultationstarttime() == null) {
                HealthConsultation hn = new HealthConsultation();
                hn.setId(id);
                hn.setConsultationstarttime(new Date());
                healthconsultationmapper.updateByPrimaryKeySelective(hn);
            } else if (hc != null && hc.getConsultationstarttime() != null) {
                throw new CommonException("已更新，不需要重复更新");
            } else {
                throw new CommonException("不存在的咨询id");
            }
        } catch (Exception e) {
            LOGGER.error("更新咨询开始时间Server层异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "更新咨询开始时间Server层异常:", e);
            }
        }
    }

    @Override
    public List<Map<String, Object>> queryDoctorFormByDate(String docid, String date) throws CommonException {
        List<Map<String, Object>> li=new ArrayList<Map<String, Object>>();
        try {
            if(StringUtils.isEmpty(docid)|| StringUtils.isEmpty(date)){
                throw new CommonException("医生id和日期不能为空");
            }
            li= healthdoctorformmapper.queryDoctorFormByDate(docid,date);
        } catch (Exception e) {
            LOGGER.error("根据日期查询医生排版Server层异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "根据日期查询医生排版Server层异常:", e);
            }
        }
        return li;
    }

}
