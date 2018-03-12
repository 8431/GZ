package com.gz.medicine.gzyun.health.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.*;
import com.gz.medicine.gzyun.health.mapper.*;
import com.gz.medicine.gzyun.health.reponse.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.health.request.HealthConsultationRequest;
import com.gz.medicine.gzyun.health.service.HealthDocAppserver;
import com.gz.medicine.gzyun.heaman.service.impl.HmGzjkPermsgRecordServiceImpl;
import com.gz.medicine.gzyun.health.service.*;


@Service("healthDocAppserver")
public class HealthDocAppserverImpl implements HealthDocAppserver {
    @Autowired
    private HealthConsultationMapper healthConsultationMapper;
    @Autowired
    private HealthyOrderMapper healthyOrderMapper;
    @Autowired
    private HealthyDoctorformMapper healthyDoctorformMapper;
    @Autowired
    private HealthServiceConfigMapper ServiceConfigMapper;
    @Autowired
    private HealthPushMessageMapper PushMessageMapper;
    @Autowired
    private HealthDoctorFormMapper healthDoctorFormMapper;
    @Autowired
    private HealthTemplateTypeMapper healthTemplateTypeMapper;
    @Autowired
    private HealthConsultationMapper consultationMapper;
    @Autowired
    private HealthConsultationService healthConsultationService;
    @Autowired
    private HealthUsrAppService healthUsrAppService;
    @Autowired
    private HealthOrderService healthOrderService;

    public static final Logger LOGGER = Logger.getLogger(HmGzjkPermsgRecordServiceImpl.class);

    /**
     * 咨询小结接口
     */
    @Override
    public String updateItemByIdConsultationSummary(HealthConsultationRequest consultation) throws CommonException {
        String result = null;
        String id = consultation.getConsultationid(); // 咨詢id

        try {
            // 查詢是否有這條記錄
            HealthConsultation selectByPrimaryKey = healthConsultationMapper.selectByPrimaryKey(id);
            String orderid = selectByPrimaryKey.getOrderid();
            if (selectByPrimaryKey != null) {
                HealthConsultation healthConsultation = new HealthConsultation();
                //调用询小结后修改订单的状态为完成,并设置订单的发票状态为5的接口
                HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
                healthyOrder.setOrderstate("5");
                healthOrderService.UpdateOrderAndLog(healthyOrder, "咨询小结关闭，订单状态修改!");
                // 插入系統當前時間
                Date Updatedate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                healthConsultation.setUpdatedate(DateUtils.parseDate(formatter.format(Updatedate)));
                //咨询开始时间  String转date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(consultation.getConsultationstarttime());
                healthConsultation.setConsultationstarttime(date);
                healthConsultation.setDocid(consultation.getDocid());
                healthConsultation.setUsrid(consultation.getUsrid());
                healthConsultation.setConsultationsummary(consultation.getConsultationsummary());
                healthConsultation.setId(id);
                healthConsultation.setConsultingstate("2");
                healthConsultationMapper.updateItemByIdConsultationSummary(healthConsultation);
            }
        } catch (Exception e) {
            LOGGER.error("执行sql异常（方法：updateItemByIdConsultationSummary）" + e.getMessage(), e);
            throw new CommonException("COM001", "执行sql异常（方法：updateItemByIdConsultationSummary）");
        }
        result = "0";
        return result;

    }

    /**
     * 图文咨询开始时间提交接口
     */
    @Override
    public String updateItemByIdConsultationStartTime(HealthConsultationRequest consultation) throws CommonException {
        String result = null;
        String id = consultation.getConsultationid(); // 咨詢id
        try {
            // 查詢是否有這條記錄
            HealthConsultation selectByPrimaryKey = healthConsultationMapper.selectByPrimaryKey(id);

            if (selectByPrimaryKey != null) {
                HealthConsultation healthConsultation = new HealthConsultation();
                healthConsultation.setDocid(consultation.getDocid());
                healthConsultation.setUsrid(consultation.getUsrid());

                // date转String
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = sdf.parse(consultation.getConsultationstarttime());
                healthConsultation.setConsultationstarttime(date);
                healthConsultation.setId(id);
                healthConsultationMapper.updateItemByIdConsultationStartTime(healthConsultation);

                result = "0";
            }
        } catch (Exception e) {
            LOGGER.error("执行sql异常（方法：updateItemByIdConsultationStartTime）" + e.getMessage(), e);
            throw new CommonException("COM001", "执行sql异常（方法：updateItemByIdConsultationStartTime）");
        }

        return result;
    }

    /**
     * 咨詢接口
     *
     * @param page
     * @return
     * @throws CommonException
     */
    @Override
    public Page queryPageConsultation(PageModel page) throws CommonException {
        List<HealthConsultationReponse> response = null;
        List<HealthConsultationReponse> responses = new ArrayList<HealthConsultationReponse>();
        Page p = page.getPage();
        Long current = System.currentTimeMillis();
        Date date = new Date(current);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = simpleDateFormat.format(date);
        try {
//			if(p.get("docid")==null||p.get("consultationmethod")==null||p.get("consultingstate")==null){
//				throw new CommonException("医生id和咨询类型 咨询状态不能为空");
//
//			}
            // 咨詢列表
            response = healthConsultationMapper.queryPageConsultation(p);
            for (HealthConsultationReponse ConsultationReponse : response) {

                //usrname与usrid相等则隐藏usrname中间4位
                String usrname = ConsultationReponse.getUsrname();
                String usrids = ConsultationReponse.getUsrids();
                if (usrname.equals(usrids)) {
                    usrname = usrname.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    ConsultationReponse.setUsrname(usrname);
                }
                List<String> stringList = new ArrayList<String>();
                String imgs = ConsultationReponse.getReservationphotoid();
                if (StringUtils.isNotEmpty(imgs)) {
                    String[] imgpath = imgs.split(",");
                    for (int i = 0; i < imgpath.length; i++) {
                        stringList.add(ConsultationReponse.getFtpurl() + imgpath[i]);
                    }

                }
                ConsultationReponse.setReservationphotoidList(stringList);
                responses.add(ConsultationReponse);
            }

            p.setParameterType(responses);

        } catch (Exception e) {
            LOGGER.error("咨詢列表Server层异常：" + e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return p;
    }

    /**
     * 订单消息接口
     */
    @Override
    public Page queryPageHealthyOrder(PageModel page) throws CommonException {
        List<HealthyOrderReponse> response = null;
        List<HealthyOrderReponse> responses = new ArrayList<HealthyOrderReponse>();
        Page p = page.getPage();
        try {
            if (p.get("docid") == null) {
                throw new CommonException("医生id不能为空");
            }
            // 随访列表
            response = healthyOrderMapper.queryPageHealthyOrder(p);
            if (response.size() > 0) {
                for (HealthyOrderReponse healthyOrderReponse : response) {
                    List<String> stringList = new ArrayList<String>();
                    //时间格式化
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					String dateString = sdf.format(healthyOrderReponse.getUpdatedate());
                    String imgs = healthyOrderReponse.getReservationphotoid();
                    if (StringUtils.isNotEmpty(imgs)) {
                        String[] imgpath = imgs.split(",");
                        for (int i = 0; i < imgpath.length; i++) {
                            stringList.add(healthyOrderReponse.getFtpurl() + imgpath[i]);
                        }
                    }
                    healthyOrderReponse.setReservationphotoidList(stringList);
                    //	healthyOrderReponse.setUpdatedate(dateString);
                    responses.add(healthyOrderReponse);
                }
            }
            p.setParameterType(responses);

        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return p;
    }

    /**
     * 排班统计
     *
     * @param
     * @return
     * @throws CommonException
     */
    @Override
    public List<HealthStatisticsReponse> queryPageSchedulingStatistics(String docid, String formdate) throws CommonException {
        List<HealthStatisticsReponse> record = new ArrayList<HealthStatisticsReponse>();
        List<HealthStatisticsReponse> records = new ArrayList<HealthStatisticsReponse>();
        Map<String, Object> mapm = new HashMap<String, Object>();
        mapm.put("docid", docid);
        mapm.put("formdate", formdate);

        try {
            if (!StringUtils.isEmpty(formdate) && docid != "") {
                mapm.put("formdate", "" + formdate + "");
            }

            //排班统计
            record = healthDoctorFormMapper.queryPageSchedulingStatistics(mapm);
            if (record.size() > 0) {
                for (HealthStatisticsReponse healthDoctorForm : record) {
                    List<String> stringList = new ArrayList<String>();
                    String Intervaldate = healthDoctorForm.getIntervaldate();
                    stringList.add(Intervaldate);
                    healthDoctorForm.setRecordList(stringList);
                    records.add(healthDoctorForm);
                }
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return records;
    }

    /**
     * 排班天数
     */
    @Override
    public HealthStatisticsReponse querySchedulingDays(String docid, String formdate) throws CommonException {
        HealthStatisticsReponse orderReponse2 = null;
        Map<String, Object> mapm = new HashMap<String, Object>();
        mapm.put("docid", docid);
        mapm.put("formdate", formdate);
        try {
            //排班天数
            orderReponse2 = healthDoctorFormMapper.querySchedulingDays(mapm);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return orderReponse2;
    }

    /**
     * 预约统计
     *
     * @param
     * @return
     * @throws CommonException
     */
    @Override
    public List<HealthStatisticsReponse> queryPageIntervalDate(String docid, String formdate) throws CommonException {
        List<HealthStatisticsReponse> record = null;
        List<HealthStatisticsReponse> records = new ArrayList<HealthStatisticsReponse>();
        Map<String, Object> mapm = new HashMap<String, Object>();
        mapm.put("docid", docid);
        mapm.put("formdate", formdate);
        try {
            if (!StringUtils.isEmpty(formdate) && docid != "") {
                mapm.put("formdate", "" + formdate + "");
            }
            //预约统计
            record = healthDoctorFormMapper.queryPageIntervalDate(mapm);
            if (record.size() > 0) {
                for (HealthStatisticsReponse healthDoctorForm : record) {
                    List<String> stringList = new ArrayList<String>();
                    String Intervaldate = healthDoctorForm.getIntervaldate();
                    stringList.add(Intervaldate);
                    healthDoctorForm.setRecordList(stringList);
                    records.add(healthDoctorForm);
                }
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return records;
    }

    /**
     * 预约天数
     *
     * @param docid
     * @param formdate
     * @return
     * @throws CommonException
     */
    @Override
    public HealthStatisticsReponse queryIntervalDateDays(String docid, String formdate) throws CommonException {
        HealthStatisticsReponse orderReponse2 = null;
        Map<String, Object> mapm = new HashMap<String, Object>();
        mapm.put("docid", docid);
        mapm.put("formdate", formdate);
        try {
            //排班天数
            orderReponse2 = healthDoctorFormMapper.queryIntervalDateDays(mapm);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return orderReponse2;
    }

    /**
     * 医生端服务设置
     *
     * @param record
     * @return
     * @throws CommonException
     */
    public String insertHealthServiceConfig(HealthServiceConfig record) throws CommonException {
        String result = null;
        HealthServiceConfig ServiceConfig = null;
        HealthServiceConfig healthServiceConfig = new HealthServiceConfig();
        String Imageservice = record.getImageservice();
        String Videoservice = record.getVideoservice();
        String Voiceservice = record.getVoiceservice();
        String id = record.getId();
        Date Updatedate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            ServiceConfig = ServiceConfigMapper.selectByHealthServiceConfig(record.getDocid());
            // 判断是否为空
            if (ServiceConfig != null) {
                healthServiceConfig.setImageservice(Imageservice);
                healthServiceConfig.setVideoservice(Videoservice);
                healthServiceConfig.setVoiceservice(Voiceservice);

                //系统当前时间
                healthServiceConfig.setUpdatedate(DateUtils.parseDate(formatter.format(Updatedate)));
                //	healthServiceConfig.setUpdatename(record.getUpdatename());
                healthServiceConfig.setId(record.getId());
                healthServiceConfig.setDocid(record.getDocid());
                ServiceConfigMapper.updateHealthServiceConfig(healthServiceConfig);
            } else {
                if (Imageservice != null && Videoservice != null && Voiceservice != null) {
                    healthServiceConfig.setId(UUIDTool.getUUID());
                    healthServiceConfig.setImageservice(Imageservice);
                    healthServiceConfig.setVideoservice(Videoservice);
                    healthServiceConfig.setVoiceservice(Voiceservice);
                    healthServiceConfig.setState("1");
                    healthServiceConfig.setDocid(record.getDocid());
                    healthServiceConfig.setUpdatedate(DateUtils.parseDate(formatter.format(Updatedate)));
                    healthServiceConfig.setCreatedate(DateUtils.parseDate(formatter.format(Updatedate)));
                    ServiceConfigMapper.insertHealthServiceConfig(healthServiceConfig);
                }
            }
        } catch (Exception e) {
            LOGGER.error("执行sql异常（方法：insertHealthServiceConfig）" + e.getMessage(), e);
            throw new CommonException("COM001", "执行sql异常（方法：insertHealthServiceConfig）");
        }
        return result;
    }

    /**
     * 查询这个医生的服务设置
     *
     * @param docid
     * @return
     * @throws CommonException
     */
    @Override
    public HealthServiceConfig selectByHealthServiceConfig(String docid) throws CommonException {
        HealthServiceConfig ServiceConfig = null;
        try {
            ServiceConfig = ServiceConfigMapper.selectByHealthServiceConfig(docid);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return ServiceConfig;

    }

    /**
     * 我的消息
     *
     * @param page
     * @return
     * @throws CommonException
     */
    @Override
    public Page queryPagePushMessage(PageModel page) throws CommonException {
        List<HealthPushMessageReponse> response;
        Page p = page.getPage();
        try {
            if (p.get("userid") == null) {
                throw new CommonException("患者id不能为空");
            }
            response = PushMessageMapper.queryPagePushMessage(p);
            p.setParameterType(response);
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return p;
    }

    /**
     * 选择模板
     *
     * @param
     * @return
     * @throws CommonException
     */
    @Override
    public List<HealthTemplateType> selectTemplateType() throws CommonException {
        List<HealthTemplateType> templateContentLists = null;
        List<TemplateContentReponse> TemplateContentLists = null;
        HealthTemplateType healthTemplateTypes = null;
        List<HealthTemplateType> HealthTemplateTypes = new ArrayList<HealthTemplateType>();
        try {
            //一级模板
            templateContentLists = healthTemplateTypeMapper.selectTemplateType();
            //二级模板
            TemplateContentLists = healthTemplateTypeMapper.selectTemplateContent();
            //一级模板不为空
            if (templateContentLists != null && templateContentLists.size() > 0 && TemplateContentLists != null && TemplateContentLists.size() > 0) {
                //遍历一级模板
                for (HealthTemplateType healthTemplateType : templateContentLists) {
                    String TemplateTypeCode = healthTemplateType.getTypecode();
                    List<TemplateContentReponse> ContentRep = new ArrayList<TemplateContentReponse>();
                    for (TemplateContentReponse templateContentReponse : TemplateContentLists) {
                        if (templateContentReponse.getTypecode().equals(TemplateTypeCode)) {
                            ContentRep.add(templateContentReponse);
                        }
                    }
                    healthTemplateType.setTemplateContentList(ContentRep);
                    HealthTemplateTypes.add(healthTemplateType);
                }
            }

        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }

        return HealthTemplateTypes;
    }

    /**
     * 我的消息详情
     *
     * @param
     * @return
     * @throws CommonException
     */
    @Override
    public Map<String, Object> updateByPushMessage(HealthPushMessage record) throws CommonException {
        Map<String, Object> pushMessage = null;
        HealthPushMessage PushMessages = null;
        try {
            if (org.springframework.util.StringUtils.isEmpty(record.getId())) {
                throw new CommonException("消息id不能为空");
            }
            //根据id查单个
            PushMessages = PushMessageMapper.selectByPrimaryKey(record.getId());
            if (PushMessages == null) {
                throw new CommonException("该消息不存在，请检查消息号");
            }
            //订单号
            String orderid = PushMessages.getOrderid();

            if (org.springframework.util.StringUtils.isEmpty(orderid)) {
                throw new CommonException("订单id不能为空");
            }
            //调用详情页面数据
            pushMessage = healthUsrAppService.queryOrderDetail(orderid);

            HealthPushMessage healthPushMessage = new HealthPushMessage();
            healthPushMessage.setIsread("1");
            healthPushMessage.setId(record.getId());
            //修改未读为已读
            PushMessageMapper.updateByPushMessage(healthPushMessage);

        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return pushMessage;

    }


    /**
     * 系统消息  修改未读 为已读
     *
     * @param record
     * @return
     * @throws CommonException
     */
    @Override
    public String updateByPushMessageSys(HealthPushMessage record) throws CommonException {
        HealthPushMessage PushMessages = null;
        try {
            if (org.springframework.util.StringUtils.isEmpty(record.getId())) {
                throw new CommonException("消息id不能为空");
            }
            //根据id查单个
            PushMessages = PushMessageMapper.selectByPrimaryKey(record.getId());
            if (PushMessages == null) {
                throw new CommonException("该消息不存在，请检查消息号");
            }
            HealthPushMessage healthPushMessage = new HealthPushMessage();
            healthPushMessage.setIsread("1");
            healthPushMessage.setId(record.getId());
            //修改未读为已读
            PushMessageMapper.updateByPushMessage(healthPushMessage);

        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return "0";

    }

    /**
     * 我的消息删除
     *
     * @param id
     * @return
     * @throws CommonException
     */
    @Override
    public String updateByMessageState(String id) throws CommonException {
        HealthPushMessage PushMessages = null;
        try {
            if (org.springframework.util.StringUtils.isEmpty(id)) {
                throw new CommonException("消息id不能为空");
            }
            //根据id查单个
            PushMessages = PushMessageMapper.selectByPrimaryKey(id);
            if (PushMessages == null) {
                throw new CommonException("该消息不存在，请检查消息号");
            }
            HealthPushMessage healthPushMessage = new HealthPushMessage();
            healthPushMessage.setState("0");
            healthPushMessage.setId(id);
            PushMessageMapper.updateByMessageState(healthPushMessage);
        } catch (Exception e) {

            LOGGER.error("我的消息删除Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "我的消息删除Server层异常:", e);
        }
        return "0";
    }

    /**
     * 消息中心
     *
     * @param userid
     * @return
     * @throws CommonException
     */
    @Override
    public List<HealthPushMessageCentre> selectPushMessage(String userid) throws CommonException {
        List<HealthPushMessageCentre> response;
        HealthPushMessageCentre responses = null;
        try {
            if (userid == null) {
                throw new CommonException("患者id不能为空");
            }
            response = PushMessageMapper.selectPushMessage(userid);
            responses = PushMessageMapper.selectHealtheValuate(userid);
            if (responses != null) {
                for (HealthPushMessageCentre MessageCentre : response) {
                    String Valuatenum = responses.getValuatenum();
                    MessageCentre.setValuatenum(Valuatenum);
                }
            }
        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new CommonException("GZ10001", "request user center exception.", e);
        }
        return response;
    }

    /**
     * 医生端结束详情
     *
     * @param id
     * @return
     * @throws CommonException
     */
    @Override
    public Map<String, Object> queryConsultation(String id) throws CommonException {
        if (org.springframework.util.StringUtils.isEmpty(id)) {
            throw new CommonException("咨询id不能为空");
        }
        Map<String, Object> consultation = null;
//		Map<String, Object> result = new HashMap();
        try {
            consultation = consultationMapper.queryConsultation(id);
            /*if (consultation != null && consultation.size() > 0) {
                result.put("consultation", consultation);
			}*/
        } catch (Exception e) {

            LOGGER.error("医生端结束详情Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "医生端结束详情Server层异常:", e);
        }
        return consultation;
    }


}
