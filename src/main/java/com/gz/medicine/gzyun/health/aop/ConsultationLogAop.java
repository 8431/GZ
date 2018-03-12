package com.gz.medicine.gzyun.health.aop;

import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.*;
import com.gz.medicine.gzyun.health.common.GZMessage;
import com.gz.medicine.gzyun.health.mapper.HealthyLoginMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.mapper.OrderLogMapper;
import com.gz.medicine.gzyun.health.mapper.healthDoctorMapper;
import com.gz.medicine.gzyun.health.request.HealthPushMessageVo;
import com.gz.medicine.gzyun.health.service.HealthPushMessageService;
import com.gz.medicine.gzyun.health.service.impl.HealthOrderServiceImpl;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
import com.gz.medicine.gzyun.push.comm.SendMessage;
import com.gz.medicine.gzyun.push.mapper.HealthUmengEquipmentMapper;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.gzyun.user.request.PushRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/9/23 0023.
 */
@Service("ConsultationLogAop")
public class ConsultationLogAop {
    public static final Logger LOGGER = Logger.getLogger(HealthOrderServiceImpl.class);

    @Autowired
    OrderLogMapper orderlogmapper;
    //友盟推送消息日志接口
    @Autowired
    HealthPushMessageService healthpushmessageservice;
    @Autowired
    HealthUmengEquipmentMapper healthumengequipmentmapper;
    @Autowired
    PushMessageService pushmessageservice;
    @Autowired
    HealthyLoginMapper healthyloginmapper;
    @Autowired
    HealthyOrderMapper healthyordermapper;
    @Autowired
    healthDoctorMapper healthdoctormapper;

    public void AfterConsultationLog(JoinPoint joinPoint, Object retValue) {
        //1.对OrderLog日志表进行记录
        if (retValue instanceof OrderLog) {
            //模拟插入队列
            try {
                orderlogmapper.insertSelective((OrderLog) retValue);
                OrderLog logInfo = (OrderLog) retValue;
                HealthPushMessageVo hv = logInfo.getHealthpushmessagevo();
                if (hv != null) {
                    pushMessage(hv);
                }
                Map<String, Object> orderMp = healthyordermapper.queryOrderById(logInfo.getOrderid());
                String docname = (String) orderMp.get("docname");
                String usrname = (String) orderMp.get("usrname");
                String consultationmethodname = (String) orderMp.get("consultationmethodname");
                String usrphone = (String) orderMp.get("usrphone");
                String createdate = (String) orderMp.get("createdate");
                String docid = (String) orderMp.get("docid");
                if (logInfo.getQxdd()) {
                    String zxsContent = MessageFormat.format(PropertyUtil.getPropery("gz.qxdx.zxsdx"), usrname, consultationmethodname, logInfo.getOrderid());
                    //by dlf for 2017/11/24 将医生提醒加入pushmessage
                    hv.setId(UUIDTool.getUUID());
                    hv.setPushmessage(zxsContent);
                    hv.setMessagename("订单信息");
                    hv.setMessagetype("3");
                    hv.setPushtime(new Date());
                    hv.setUserid(docid);
                    HealthPushMessage hp = new HealthPushMessage();
                    BeanUtils.copyProperties(hv, hp);
                    healthpushmessageservice.insertHealthPushMessage(hp);
                }
                //退款中的订单发送短信通知管理员  下个版本优化流程，优化逻辑
                if ("6".equals(logInfo.getOrderstate()) && logInfo.getQxdd()) {
                    List<HealthyLogin> hgLi = healthyloginmapper.queryAdminByRole("8");
                    healthDoctor doctorMsg = healthdoctormapper.selectByPrimaryKey(docid);
                    HealthyLogin loginMsg = healthyloginmapper.queryHealthyLogin(doctorMsg.getLoginid());
                    //客服短信
                    String content = MessageFormat.format(PropertyUtil.getPropery("gz.qxdx.kfdx"), usrname, usrphone, docname, loginMsg.getName(), consultationmethodname, createdate, logInfo.getOrderid());
                    for (HealthyLogin h : hgLi) {
                        if (!StringUtils.isEmpty(h.getPhone())) {
                            MobileCode.sendAuthCode(h.getPhone(), content);
                        }
                    }
                    //用户短信
                    String yhContent = MessageFormat.format(PropertyUtil.getPropery("gz.qxdx.yhdx"), docname, consultationmethodname, logInfo.getOrderid());
                    MobileCode.sendAuthCode(usrphone, yhContent);
                    //医生短信
                    String zxsContent = MessageFormat.format(PropertyUtil.getPropery("gz.qxdx.zxsdx"), usrname, consultationmethodname, logInfo.getOrderid());
                    MobileCode.sendAuthCode(loginMsg.getName(), zxsContent);


                }
                LOGGER.info("订单id：" + logInfo.getOrderid() + ".订单状态:" + logInfo.getOrderstate() + ".操作内容:" + logInfo.getOperationcontent());
            } catch (Exception e) {
                LOGGER.error("对OrderLog日志表进行记录异常:" + e.getMessage(), e);
            }
        }
        //2.使用友盟接口推送消息
        if (retValue != null && retValue instanceof HealthPushMessageVo) {
            pushMessage((HealthPushMessageVo) retValue);
        }
    }

    private void pushMessage(HealthPushMessageVo retValue) {
        try {
            //2.1 消息推送-----记录日志，
            HealthPushMessageVo hpv = retValue;
            HealthPushMessage hp = new HealthPushMessage();

            if (!StringUtils.isEmpty(hpv.getPushmessage())) {
                BeanUtils.copyProperties(hpv, hp);
                healthpushmessageservice.insertHealthPushMessage(hp);
            }
            //发送短信
            if (hpv != null && hpv.getSendMsgState() != null && hpv.getSendMsgState()) {
                List<GZMessage> gzLi = hpv.getGzmessage();
                if (gzLi != null) {
                    for (GZMessage g : gzLi) {
                        MobileCode.sendAuthCode(g.getPhoneNum(), g.getSendMsgContent());
                    }
                }
                if (!StringUtils.isEmpty(hpv.getPhoneNum()) && !StringUtils.isEmpty(hpv.getSendMsgContent())) {
                    MobileCode.sendAuthCode(hpv.getPhoneNum(), hpv.getSendMsgContent());
                    MobileCode.sendAuthCode("15779102820", hpv.getSendMsgContent());
                } else {
                    LOGGER.error("发送短信数据错误，手机号不能为空，内容不能为空");
                }
            }
            //2.2 消息推送-----数据还未写入，
            PushRequest data = new PushRequest();
            HealthUmengEquipment ht = healthumengequipmentmapper.selectByUsrid(hp.getUserid());
            if (ht != null) {
                //两个vo类名称不一样，搞死人。手动set
                data.setPhoneType(ht.getPhonetype());
                data.setDeviceToken(ht.getDevicetokens());
                data.setAppkey(ht.getAppkey());
                data.setAppMasterSecret(ht.getAppmastersecret());
                data.setUmengMessageSecret(ht.getUmengmessagesecret());
                data.setMessagename(hp.getMessagename());
                data.setMessageType(hp.getMessagetype());
                data.setMessage(hp.getPushmessage());
                data.setOrderId(hp.getOrderid());
                data.setAlias(ht.getAlias());
                data.setAlias_type(ht.getAliasType());
                //自定义参数
                data.setKey1name("PushType");
                data.setKey2name("Parameters");
                if ("5".equals(hpv.getPushtype())) {//排班推送
                    data.setKey1value("5");
                }
                if ("11".equals(hpv.getPushtype())) {//订单开票
                    data.setKey1value("11");
                    data.setKey2value(hp.getOrderid());
                }
                //套用罗嘉林代码，发送友盟消息
                sendMessage(data);
            } else {
                LOGGER.error("推送失败，在HealthUmengEquipment没有获取到用户信息，在HealthUmengEquipment没有获取到用户信息==null");
            }

        } catch (Exception e) {
            LOGGER.error("使用友盟接口推送消息异常:" + e.getMessage(), e);
        }
    }

    private void sendMessage(PushRequest data) throws Exception {
        if ("1".equals(data.getPhoneType())) {
            SendMessage.sendIOSCustomizedcast(data);

        } else if ("2".equals(data.getPhoneType())) {

            if ("".equals(data.getDeviceToken())) {
                //特定用户
                SendMessage.sendAndroidCustomizedcast(data);
            } else {
                //单通道发送
                SendMessage.sendAndroidUnicast(data);
            }

        }
    }


}
