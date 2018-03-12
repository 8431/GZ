package com.gz.medicine.gzyun.push.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.bean.healthDoctor;
import com.gz.medicine.gzyun.health.mapper.HealthPushMessageMapper;
import com.gz.medicine.gzyun.health.mapper.healthDoctorMapper;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.health.service.HealthPushMessageService;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
import com.gz.medicine.gzyun.push.comm.SendMessage;
import com.gz.medicine.gzyun.push.service.HealthUmengEquipmentService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.gzyun.user.request.PushRequest;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Title PushMessageService
 * @Description 消息推送的ServiceImpl
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
@Service
public class PushMessageServiceImpl implements PushMessageService {

    public static final Logger LOGGER = Logger.getLogger(PushMessageServiceImpl.class);

    @Autowired
    private HealthPushMessageService healthPushMessageService;


    @Autowired
    private HealthUmengEquipmentService healthUmengEquipmentService;


    @Autowired
    private HealthPushMessageMapper healthPushMessageMapper;


    @Autowired
    private healthDoctorMapper healthDoctorMappers;

    @Autowired
    private healthDoctorMapper healthDoctorMapper;

    @Autowired
    private HealthOrderService healthOrderService;

    @Override
    public int insertPushMessage(PushRequest data) throws CommonException {
        int isOK;
        HealthPushMessage healthPushMessage = new HealthPushMessage();
        healthPushMessage.setId(UUIDTool.getUUID());
        healthPushMessage.setCreatedate(new Date());
        healthPushMessage.setIsread("0");
        healthPushMessage.setState("1");
        healthPushMessage.setOrderid(data.getOrderId());
        healthPushMessage.setUserid(data.getGuid());
        healthPushMessage.setMessagetype(data.getMessageType());
        healthPushMessage.setPushmessage(data.getMessage());
        //2017-11-04 增加插入订单id by dlf
        healthPushMessage.setOrderid(data.getOrderId());
        if("1".equals(data.getMessageType())){
            healthPushMessage.setMessagename("系统消息");
        }else  if ("2".equals(data.getMessageType())){
            healthPushMessage.setMessagename("咨询消息");
        }else  if("3".equals(data.getMessageType())){
            healthPushMessage.setMessagename("订单消息");
        }
        try {
            isOK = healthPushMessageService.insertHealthPushMessage(healthPushMessage);
        }catch (Exception e){
            LOGGER.error("消息推送入库失败:" + e.getMessage() + e);
            throw  new CommonException("消息推送入库失败",e.getMessage());
        }

        return isOK;
    }

    @Override
    public String PushMessage(PushRequest data) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessage*************************]");
        String message = null;
        try {
            LOGGER.info("消息推送--------Start--------" + JSONObject.fromObject(data));
            if("1".equals(data.getPhoneType())){
                    message =  SendMessage.sendIOSCustomizedcast(data);
            }else if("2".equals(data.getPhoneType())){
                message =  SendMessage.sendAndroidCustomizedcast(data);
            }

            HealthPushMessage healthPushMessage = new HealthPushMessage();
            healthPushMessage.setId(UUIDTool.getUUID());
            healthPushMessage.setCreatedate(new Date());
            healthPushMessage.setIsread("0");
            healthPushMessage.setState("1");
            healthPushMessage.setUserid(data.getGuid());
            healthPushMessage.setMessagetype(data.getMessageType());
            healthPushMessage.setMessagename(data.getMessagename());
            healthPushMessage.setPushmessage(data.getMessage());
            healthPushMessage.setOrderid(data.getOrderId());
            if("1".equals(data.getMessageType())){
                healthPushMessage.setMessagename("系统消息");
            }else  if ("2".equals(data.getMessageType())){
                healthPushMessage.setMessagename("咨询消息");
            }else  if("3".equals(data.getMessageType())){
                healthPushMessage.setMessagename("订单消息");
            }
            LOGGER.info("消息推送入库--------" + JSONObject.fromObject(healthPushMessage));
            healthPushMessageService.insertHealthPushMessage(healthPushMessage);
        }catch (Exception e){
            LOGGER.error("消息推送失败:" + e.getMessage() + e);
            throw  new CommonException("消息推送失败",e.getMessage());
        }
        return message;
    }

    @Override
    public String PushMessageEquipmentOK(HealthyOrder healthyOrder) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessageEquipmentOK*************************]");
        LOGGER.info("  HealthyOrder :" + JSONObject.fromObject(healthyOrder).toString());
        HealthPushMessage healthPushMessage = new HealthPushMessage();
        int countsum = 0;
        String contennt = null;
        //给患者
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthyOrder.getUsrid());
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            healthPushMessage.setUserid(healthyOrder.getUsrid());
            countsum = healthPushMessageMapper.countById(healthPushMessage);
            PushRequest pushRequest = new PushRequest();
            if("2".equals(healthUmengEquipment.getPhonetype())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessage("您的订单已成功支付,点击查看详情。");
            pushRequest.setMessagename("点击进入订单详情页");
            pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            pushRequest.setBage(countsum+1);
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            pushRequest.setOrderId(healthyOrder.getId());
            pushRequest.setMessageType("3");
            contennt =  PushMessage(pushRequest);
        }

        HealthUmengEquipment healthUmengEquipments = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthyOrder.getDocid());
        if(healthUmengEquipments != null && !"".equals(healthUmengEquipments)){
            //给医生
            healthPushMessage.setUserid(healthyOrder.getDocid());
            countsum = healthPushMessageMapper.countById(healthPushMessage);
            StringBuffer stringBufferDoctor = new StringBuffer();
            stringBufferDoctor.append("预约提醒,");
            stringBufferDoctor.append(healthyOrder.getUsrname());
            stringBufferDoctor.append("预约了您的");
            stringBufferDoctor.append(isType(healthyOrder.getConsultationmethod()) + "服务,");
            stringBufferDoctor.append("预约时间:");
            stringBufferDoctor.append(healthyOrder.getReservationdate()); //预约时段
            stringBufferDoctor.append(" " +healthyOrder.getReserstarttime());
            stringBufferDoctor.append("-" +healthyOrder.getReserendtime());
            stringBufferDoctor.append("订单号:");
            stringBufferDoctor.append(healthyOrder.getId());
            PushRequest pushRequest = new PushRequest();
            if("2".equals(healthUmengEquipments.getPhonetype())){
                pushRequest.setDeviceToken(healthUmengEquipments.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipments.getPhonetype());
            pushRequest.setGuid(healthUmengEquipments.getUserid());
            pushRequest.setAppkey(healthUmengEquipments.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipments.getAppmastersecret());
            pushRequest.setMessage(stringBufferDoctor.toString());
            pushRequest.setMessagename("点击进入我的预约页");
            pushRequest.setUmengMessageSecret(healthUmengEquipments.getUmengmessagesecret());
            pushRequest.setBage(countsum+1);
            pushRequest.setAlias_type(healthUmengEquipments.getAliasType());
            pushRequest.setAlias(healthUmengEquipments.getAlias());
            pushRequest.setOrderId(healthyOrder.getId());
            pushRequest.setMessageType("3");
            contennt =  PushMessage(pushRequest);
        }

        return contennt;
    }

    @Override
    public String PushMessageEquipmentCancel(String userid) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessageEquipmentCancel*************************]");
        String contennt = null;
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(userid);
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            PushRequest pushRequest = new PushRequest();
            if("2".equals(healthUmengEquipment.getPhonetype())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessage("用户取消订单,您的咨询预约已经被关闭。");
            pushRequest.setMessagename("您的订单已成功取消,所付金额将通过原支付途径退回,点击查看详情。");
            if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            }
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            contennt =  PushMessage(pushRequest);
        }
        return contennt;
    }

    @Override
    public String PushMessageEquipmentRefunds(HealthyOrder healthorder) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessageEquipmentRefunds*************************]");
        LOGGER.info("  HealthyOrder :" + JSONObject.fromObject(healthorder).toString());
        String contennt = null;
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthorder.getUsrid());
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            PushRequest pushRequest = new PushRequest();
            if(healthUmengEquipment.getDevicetokens() != null && !"".equals(healthUmengEquipment.getDevicetokens())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessage("订单号：" + healthorder.getId() + "已退款成功，点击查看详情。");
            pushRequest.setMessagename("订单退款成功。");
            if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            }
            //pushRequest.setBage(countsum);
            pushRequest.setMessageType("3");
            pushRequest.setOrderId(healthorder.getId());
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            pushRequest.setKey1name("PushType");
            pushRequest.setKey1value("5");
            pushRequest.setKey2name("Parameters");
            pushRequest.setKey2value(healthorder.getId());
            LOGGER.info("[PushMessageEquipmentRefunds 退款给用户推送消息]");
            contennt =  PushMessage(pushRequest);
        }
        return contennt;
    }

    @Override
    public String PushMessageTask(HealthyOrder healthyOrder,String pushMessage,String typeContent,String flag) throws CommonException {
        String contennt = null;
        String ids = "";
        StringBuffer stringBuffer = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(healthyOrder.getReservationdate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = df.format(date);
        System.out.println(str);

        healthDoctor healthDoctor = healthDoctorMappers.selectByPrimaryKey(healthyOrder.getDocid());
        //医生
        if("1".equals(flag)){
            ids = healthyOrder.getDocid();
            stringBuffer = new StringBuffer();
            stringBuffer.append(healthyOrder.getUsrname());
            stringBuffer.append("预约了您的");
            stringBuffer.append(typeContent);
            stringBuffer.append("服务将在5分钟后开始,");
            stringBuffer.append("预约时间 ");
            stringBuffer.append(str + " ");
            stringBuffer.append(healthyOrder.getReserstarttime()+"-"+healthyOrder.getReserendtime());
            stringBuffer.append("，点击查看详情。");
        }else {
            //患者
            ids = healthyOrder.getUsrid();
            stringBuffer = new StringBuffer();
            stringBuffer.append("你好,你预约的");
            stringBuffer.append(healthDoctor.getName()+"咨询师,");
            stringBuffer.append(typeContent);
            stringBuffer.append("服务将在5分钟后开始,");
            stringBuffer.append("预约时间");
            stringBuffer.append(str);
            stringBuffer.append(healthyOrder.getReserstarttime()+"-"+healthyOrder.getReserendtime());
            stringBuffer.append("，点击查看详情。");
        }
        LOGGER.info("定时任务推送消息-----");
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(ids);
        LOGGER.info("用户对应的友盟设备-----" + healthUmengEquipment.toString());
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            PushRequest pushRequest = new PushRequest();
            if(healthUmengEquipment.getDevicetokens() != null && !"".equals(healthUmengEquipment.getDevicetokens())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessageType("2");
            //pushRequest.setMessagename("您的"+ typeContent +"服务，请及时登录APP。");
            pushRequest.setMessagename("您的"+ typeContent +"服务将在5分钟后开始，请及时登录APP。");
            pushRequest.setMessage(stringBuffer.toString());
            if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            }
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            pushRequest.setOrderId(healthyOrder.getId());
            pushRequest.setKey1name("PushType");
            pushRequest.setKey1value("6");
            pushRequest.setKey2name("Parameters");
            pushRequest.setKey2value(healthyOrder.getId());
            contennt =  PushMessage(pushRequest);
        }
        return contennt;
    }

    @Override
    public String PushMessageTimeoutOrder(HealthyOrder healthyOrder) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessageTimeoutOrder*************************]");
        String contennt = null;
        LOGGER.info("定时任务订单超时推送消息-----用户端推送");
        HealthPushMessage healthPushMessage = new HealthPushMessage();
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthyOrder.getUsrid());
        LOGGER.info("用户对应的友盟设备-----" + healthUmengEquipment.toString());
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            PushRequest pushRequest = new PushRequest();
            if(healthUmengEquipment.getDevicetokens() != null && !"".equals(healthUmengEquipment.getDevicetokens())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessageType("3");
            pushRequest.setMessagename("点击进入订单详情页");
            pushRequest.setMessage("您有订单超时未支付，系统已自动取消，点击查看详情。");
            if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            }
            //pushRequest.setBage(countsum);
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            pushRequest.setOrderId(healthyOrder.getId());
            pushRequest.setKey1name("PushType");
            pushRequest.setKey1value("5");
            pushRequest.setKey2name("Parameters");
            pushRequest.setKey2value(healthyOrder.getId());
            contennt =  PushMessage(pushRequest);
        }
        return contennt;
    }

    @Override
    public String PushMessageOutDateOrder(HealthyOrder healthyOrder) throws CommonException {
        LOGGER.info("[*************************PushMessageServiceImpl/PushMessageOutDateOrder*************************]");
        LOGGER.info(" HealthyOrder :" + JSONObject.fromObject(healthyOrder).toString());
        String contennt = null;
        LOGGER.info("定时任务订单超时未使用推送消息-----用户端推送");
        HealthPushMessage healthPushMessage = new HealthPushMessage();
        healthPushMessage.setUserid(healthyOrder.getUsrid());
        //healthPushMessage.setMessagetype("3");
        int countsum = healthPushMessageMapper.countById(healthPushMessage);
        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthyOrder.getUsrid());
        LOGGER.info("用户对应的友盟设备-----" + healthUmengEquipment.toString());
        if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
            PushRequest pushRequest = new PushRequest();
            if(healthUmengEquipment.getDevicetokens() != null && !"".equals(healthUmengEquipment.getDevicetokens())){
                pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
            }
            pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
            pushRequest.setGuid(healthUmengEquipment.getUserid());
            pushRequest.setAppkey(healthUmengEquipment.getAppkey());
            pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
            pushRequest.setMessageType("3");
            pushRequest.setMessagename("点击进入订单详情页");
            pushRequest.setMessage("您有订单超时未使用，点击查看详情。");
            if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
            }
            pushRequest.setBage(countsum+1);
            pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
            pushRequest.setAlias(healthUmengEquipment.getAlias());
            pushRequest.setOrderId(healthyOrder.getId());
            pushRequest.setKey1name("PushType");
            pushRequest.setKey1value("5");
            pushRequest.setKey2name("Parameters");
            pushRequest.setKey2value(healthyOrder.getId());
            contennt =  PushMessage(pushRequest);
        }
        return contennt;
    }

    @Override
    public boolean SendHoursPushAndMessage() throws Exception {
        List<HealthyOrder> healthyOrderList = healthOrderService.SendHoursPushAndMessage("5");
        for (HealthyOrder healthyOrder : healthyOrderList) {
            String contennt = null;
            HealthPushMessage healthPushMessage = new HealthPushMessage();
            LOGGER.info("给患者发送短信  ---- 友好提示Start" );

            LOGGER.info("订单信息 1: " + JSONObject.fromObject(healthyOrder).toString());

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("感谢您使用贯众云医进行咨询，欢迎再次预约，如需其他服务请在线咨询或致电客服4001606021，我们将竭诚为您服务，谢谢！");
            MobileCode.sendAuthCode(healthyOrder.getUsrphone(),stringBuffer.toString());
            healthyOrder.setSendok("1");
            healthOrderService.updateByPrimaryKeySelective(healthyOrder);
            LOGGER.info("订单信息 2: " + JSONObject.fromObject(healthyOrder).toString());
            LOGGER.info("给患者发送短信  ---- 友好提示end" );
            LOGGER.info("给患者推送消息  ---- 友好提示Start" );
            HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(healthyOrder.getUsrid());
            if(healthUmengEquipment != null && !"".equals(healthUmengEquipment)){
                PushRequest pushRequest = new PushRequest();
                if(healthUmengEquipment.getDevicetokens() != null && !"".equals(healthUmengEquipment.getDevicetokens())){
                    pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
                }
                pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
                pushRequest.setGuid(healthUmengEquipment.getUserid());
                pushRequest.setAppkey(healthUmengEquipment.getAppkey());
                pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
                pushRequest.setMessage("感谢您使用贯众云医进行咨询，欢迎再次预约，如需其他服务请在线咨询或致电客服4001606021，我们将竭诚为您服务，谢谢！");
                pushRequest.setMessagename("感谢您使用贯众云医进行咨询");
                if(healthUmengEquipment.getUmengmessagesecret() != null && !"".equals(healthUmengEquipment.getUmengmessagesecret())){
                    pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
                }
                pushRequest.setMessageType("3");
                pushRequest.setOrderId(healthyOrder.getId());
                pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
                pushRequest.setAlias(healthUmengEquipment.getAlias());
                pushRequest.setKey1name("PushType");
                pushRequest.setKey1value("6");
                pushRequest.setKey2name("Parameters");
                pushRequest.setKey2value(healthyOrder.getId());
                contennt =  PushMessage(pushRequest);
            }
            LOGGER.info("给患者推送消息 ---- 友好提示end");
        }
        return false;
    }


    public String isType(String type){
        String typeContent = null;
        //（图文、语音、视频）2,3,4
        if("2".equals(type)){
            typeContent = "图文咨询";
        }else if("3".equals(type)){
            typeContent = "语音咨询";
        }else  if("4".equals(type)){
            typeContent = "视频咨询";
        }
        return typeContent;
    }

}
