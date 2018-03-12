package com.gz.medicine.yun.common.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.gzyun.health.bean.HealthyLogin;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.bean.healthDoctor;
import com.gz.medicine.gzyun.health.mapper.HealthyLoginMapper;
import com.gz.medicine.gzyun.health.mapper.healthDoctorMapper;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.yun.common.service.SendMessageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.xml.factory.LoggedNodeFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName SendMessageServiceImpl
 * @PackageName com.gz.medicine.yun.common.service.impl
 * @Description 短信发送
 * @Data 2017-11-1 13:50
 **/
@Service
public class SendMessageServiceImpl implements SendMessageService {

    public static final Logger LOGGER = Logger.getLogger(SendMessageServiceImpl.class);

    @Autowired
    private HealthOrderService healthOrderService;

    @Autowired
    private healthDoctorMapper healthDoctorMapper;

    @Autowired
    private HealthyLoginMapper healthyLoginMapper;

    @Autowired
    private PushMessageService pushMessageService;

    @Override
    public boolean SendMeessageOK(String orderid) throws CommonException {
        LOGGER.info("[*************************SendMessageServiceImpl/SendMeessageOK*************************]");
        boolean flag = false;
        try {
            //根据订单ID获取订单
            HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
            LOGGER.info("*************************healthyOrder*************************:"+healthyOrder.toString());
            if("0".equals(healthyOrder.getSendflag())) {

                    LOGGER.info("[推送消息]");
                    //向指定设备推送消息--订单支付成功后
                    pushMessageService.PushMessageEquipmentOK(healthyOrder);

                    //根据订单中的医生ID获取医生
                    healthDoctor healthDoctor = healthDoctorMapper.selectByPrimaryKey(healthyOrder.getDocid());
                    //订单支付成功后,发送短信
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(healthyOrder.getUsrname());
                    stringBuffer.append("你好，您已成功预约");
                    stringBuffer.append(healthDoctor.getName());
                    stringBuffer.append("咨询师");
                    stringBuffer.append(isType(healthyOrder.getConsultationmethod()) + "服务");
                    stringBuffer.append("预约时间:");
                    stringBuffer.append(healthyOrder.getReservationdate()); //预约时段
                    stringBuffer.append(" " + healthyOrder.getReserstarttime());
                    stringBuffer.append("-" + healthyOrder.getReserendtime());
                    stringBuffer.append("订单号:");
                    stringBuffer.append(healthyOrder.getId());
                    stringBuffer.append("请按时打开APP开始服务。如需取消,请在服务开始3小时前取消订单。");

                    HealthyOrder healthyOrders = new HealthyOrder();
                    healthyOrders.setId(healthyOrder.getId());
                    healthyOrders.setSendflag("1");
                    healthOrderService.updateByPrimaryKeySelective(healthyOrders);

                    //给用户发送短信
                    LOGGER.info("[给用户发送短信]");
                    flag = MobileCode.sendAuthCode(healthyOrder.getUsrphone(), stringBuffer.toString());

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
                    //给医生发送短信
                    MobileCode.sendAuthCode(healthDoctor.getPhone(), stringBufferDoctor.toString());
                    LOGGER.info("[给医生发送短信]");

                    StringBuffer stringBufferCustomer = new StringBuffer();
                    stringBufferCustomer.append("预约提醒，");
                    stringBufferCustomer.append(healthyOrder.getUsrname());
                    stringBufferCustomer.append("已成功预约");
                    stringBufferCustomer.append(healthDoctor.getName());
                    stringBufferCustomer.append("咨询师");
                    stringBufferCustomer.append(isType(healthyOrder.getConsultationmethod()) + "服务,");
                    stringBufferCustomer.append("预约时间:");
                    stringBufferCustomer.append(healthyOrder.getReservationdate()); //预约时段
                    stringBufferCustomer.append(" " + healthyOrder.getReserstarttime());
                    stringBufferCustomer.append("-" + healthyOrder.getReserendtime());
                    stringBufferCustomer.append("订单号:");
                    stringBufferCustomer.append(healthyOrder.getId());

                    //给客服发短信
                    List<HealthyLogin> healthyLogin = healthyLoginMapper.selectByState();
                    for (HealthyLogin hl:healthyLogin) {
                        if(StringUtils.isNotEmpty(hl.getDocphone())){
                            MobileCode.sendAuthCode(hl.getDocphone(), stringBufferCustomer.toString());
                            LOGGER.info("[给客服发短信]");
                        }

                    }
                 }
            }catch (Exception e){
                LOGGER.error("订单短信发送失败:" + e.getMessage() + e);
                throw  new CommonException("001","短信发送失败");
            }
        return flag;
    }

    @Override
    public boolean SendMeessageCancel(String orderid) throws CommonException {
        LOGGER.info("[*************************SendMessageServiceImpl/SendMeessageCancel*************************]");
        boolean flag = false;
        try {
            //根据订单ID获取订单
            HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
            //根据订单中的医生ID获取医生
            healthDoctor healthDoctor = healthDoctorMapper.selectByPrimaryKey(healthyOrder.getDocid());
            //订单支付成功后,发送短信
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(healthyOrder.getUsrname());
            stringBuffer.append("你好，您预约的");
            stringBuffer.append(healthDoctor.getName());
            stringBuffer.append("医生");
            stringBuffer.append(healthyOrder.getReservationdate()); //预约时段
            stringBuffer.append("(");
            stringBuffer.append(healthyOrder.getReserstarttime());
            stringBuffer.append("-");
            stringBuffer.append(healthyOrder.getReserendtime());
            stringBuffer.append(") ");
            stringBuffer.append(isType(healthyOrder.getConsultationmethod()) + "服务订单已取消");
            stringBuffer.append("(订单号:");
            stringBuffer.append(healthyOrder.getId());
            stringBuffer.append(") ");
            stringBuffer.append("所付金额将通过原支付途径退回,有疑问请致电客服4001606021咨询。");
            flag = MobileCode.sendAuthCode(healthyOrder.getUsrphone(),stringBuffer.toString());
            LOGGER.info("[给用户发短信]");
        }catch (Exception e){
            LOGGER.error("订单短信发送失败:" + e.getMessage() + e);
            throw  new CommonException("001","短信发送失败");
        }
        return flag;
    }

    @Override
    public boolean SendMeessageRefunds(String orderid) throws CommonException {
        LOGGER.info("[*************************SendMessageServiceImpl/SendMeessageRefunds*************************]");
        boolean flag = false;
        try {
            //根据订单ID获取订单
            HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
            //订单支付成功后,发送短信
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("订单号:");
            stringBuffer.append(healthyOrder.getId());
            stringBuffer.append("已成功退款,");
            stringBuffer.append("退款金额将在3-7个工作日退回您的支付账户,");
            stringBuffer.append("有疑问请致电客服4001606021咨询。");
            stringBuffer.append("客服工作日为周一至周五 9:00-17:00");
            LOGGER.info("[退款给用户发短信]");
            flag = MobileCode.sendAuthCode(healthyOrder.getUsrphone(),stringBuffer.toString());

            LOGGER.info("[退款给用户推送消息]");
            //向指定设备推送消息--订单退款后
            pushMessageService.PushMessageEquipmentRefunds(healthyOrder);

        }catch (Exception e){
            LOGGER.error("订单短信发送失败:" + e.getMessage() + e);
            throw  new CommonException("001","短信发送失败");
        }
        return flag;
    }

    @Override
    public boolean SendMessageTaskBegin(String orderid) throws CommonException {
        LOGGER.info("[*************************SendMessageServiceImpl/SendMessageTaskBegin*************************]");
        boolean flag = false;
        try {

            //根据订单ID获取订单
            HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);

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

            //根据订单中的医生ID获取医生
            healthDoctor healthDoctor = healthDoctorMapper.selectByPrimaryKey(healthyOrder.getDocid());
            //订单支付成功后,发送短信
            //给患者发送短信
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(healthyOrder.getUsrname());
            stringBuffer.append("您好，您预约的");
            stringBuffer.append(healthDoctor.getName());
            stringBuffer.append("咨询师");
            stringBuffer.append(isType(healthyOrder.getConsultationmethod()) + "服务将在5分钟后开始,");
            stringBuffer.append("预约时间 "+str + " ");
            stringBuffer.append(healthyOrder.getReserstarttime()+"-"+healthyOrder.getReserendtime());
            stringBuffer.append(",请及时打开APP开始咨询。");
            flag = MobileCode.sendAuthCode(healthyOrder.getUsrphone(),stringBuffer.toString());
            LOGGER.info("[给用户发短信]");
            //给医生发送短信
            StringBuffer stringBufferDoctor = new StringBuffer();
            stringBufferDoctor.append(healthDoctor.getName());
            stringBufferDoctor.append("咨询师您好");
            stringBufferDoctor.append("您有");
            stringBufferDoctor.append(isType(healthyOrder.getConsultationmethod()) + "服务将在5分钟后开始");
            stringBufferDoctor.append("预约时间 "+str + " ");
            stringBufferDoctor.append(healthyOrder.getReserstarttime()+"-"+healthyOrder.getReserendtime());
            stringBufferDoctor.append("，请及时打开APP开始咨询。");
            MobileCode.sendAuthCode(healthDoctor.getPhone(),stringBufferDoctor.toString());
            LOGGER.info("[给医生发送短信]");
        }catch (Exception e){
            LOGGER.error("短信发送失败:" + e.getMessage() + e);
            throw  new CommonException("001","订单短信发送失败");
        }
        return flag;
    }

    @Override
    public boolean SendMessageTaskOutDate(String orderid) throws CommonException {
        LOGGER.info("[*************************SendMessageServiceImpl/SendMessageTaskOutDate*************************]");
        boolean flag = false;
        try {
            //根据订单ID获取订单
            HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
            //根据订单中的医生ID获取医生
            healthDoctor healthDoctor = healthDoctorMapper.selectByPrimaryKey(healthyOrder.getDocid());
            //订单支付成功后,发送短信
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(healthyOrder.getUsrname());
            stringBuffer.append("您好，您预约的");
            stringBuffer.append(healthDoctor.getName());
            stringBuffer.append("咨询师");
            stringBuffer.append(healthyOrder.getReservationdate()); //预约时段
            stringBuffer.append("(");
            stringBuffer.append(healthyOrder.getReserstarttime());
            stringBuffer.append("-");
            stringBuffer.append(healthyOrder.getReserendtime());
            stringBuffer.append(") ");
            stringBuffer.append(isType(healthyOrder.getConsultationmethod()) + "服务订单已关闭");
            stringBuffer.append("(订单号:");
            stringBuffer.append(healthyOrder.getId());
            stringBuffer.append(") ");
            stringBuffer.append("您可以重新预约，有疑问请致电客服4001606021咨询。");
            flag = MobileCode.sendAuthCode(healthyOrder.getUsrphone(),stringBuffer.toString());
            LOGGER.info("[给用户发送短信]");
        }catch (Exception e){
            LOGGER.error("短信发送失败:" + e.getMessage() + e);
            throw  new CommonException("001","订单短信发送失败");
        }
        return flag;
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
