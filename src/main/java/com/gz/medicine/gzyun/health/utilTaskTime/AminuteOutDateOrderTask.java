package com.gz.medicine.gzyun.health.utilTaskTime;

import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.yun.common.service.SendMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName AminuteOutDateOrderTask
 * @PackageName com.gz.medicine.gzyun.health.utilTaskTime
 * 订单过期-咨询时间后一小时-(咨询时间不为空)
 * 订单过期: 订单付款-咨询有开始时间-更改订单状态为8
 * 扫描过程: 1分钟一次-取当前时间减去一个小时-获取咨询开始时间小于获取等于当前时间的
 * @Description 1分钟扫描一次----订单已过期(1小时,按预约结束时间来算,有开始时间--预约结束时间往后一小时)(付款成功2 ，未咨询，设置8退款成功，咨询表设置为取消)
 * 描述: 订单过期
 * @Data 2017-11-01 10:47
 **/
@Service("aminuteOutDateOrderTask")
public class AminuteOutDateOrderTask {

    public static final Logger LOGGER = Logger.getLogger(AminuteOutDateOrderTask.class);

    @Autowired
    private HealthOrderService healthOrderService;

    @Autowired
    private HealthConsultationService healthConsultationService;


    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private PushMessageService pushMessageService;

    /**
     * 订单付款-咨询有开始时间-- 更改状态
     */
    public void SendMessage(){
        LOGGER.info("aminuteOutDateOrderTask start ....");

        try {
            //取当前小时减一个小时如: 10 把小于9点或等于9点的数据更改
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);//当前时间减一个小时
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            LOGGER.info("订单已过期(1小时)--------当前时间: " + df.format(new Date()) + "    ----一个小时前的时间:" + df.format(calendar.getTime()));
            //前一个小时
            String frontTime = df.format(calendar.getTime());
            List<HealthyOrder> healthyOrderList = healthOrderService.OutDateOrderList(frontTime);
            if(healthyOrderList.size() > 0){
                for (HealthyOrder healthorder : healthyOrderList) {
                        HealthyOrder healthyOrder = new HealthyOrder();
                        BeanUtils.copyProperties(healthorder,healthyOrder);
                        //更改订单的状态为8,并记录日志
                        healthyOrder.setOrderstate("8");
                        healthyOrder.setUpdatename("系统");
                        healthOrderService.UpdateOrderAndLog(healthyOrder,"订单已过期,状态更改");
                        LOGGER.info("订单已过期 -- 更改状态 start ....");
                        LOGGER.info("订单已过期(1小时)--------订单信息 start ...." + healthorder.toString());
                        //同时更改咨询信息为取消
                        HealthConsultation healthConsultation = healthConsultationService.selectByPrimaryOrderId(healthorder.getId());
                        if(healthConsultation != null && !"".equals(healthConsultation)){
                            healthConsultation.setConsultingstate("4");//咨询状态（1.待咨询、2.已咨询、3.已预约、4.已取消）
                            healthConsultationService.updateByPrimaryKeySelective(healthConsultation);
                        }
                        LOGGER.info("订单已过期 -- 给医生发送短信 start ....");
                        //同时给医生发送短信
                        sendMessageService.SendMessageTaskOutDate(healthyOrder.getId());
                        LOGGER.info("订单已过期 -- 给患者推送消息 start ....");
                        //患者推送消息
                        pushMessageService.PushMessageOutDateOrder(healthorder);
                }
            }

        }catch (Exception e){
            LOGGER.error("订单已过期扫描错误: " + e.getMessage() + e);
        }

        LOGGER.info("aminuteOutDateOrderTask end ....");
    }
}
