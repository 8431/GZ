package com.gz.medicine.gzyun.health.utilTaskTime;

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
 * @ClassName aminuteOutDateOrderRefundTask
 * @PackageName com.gz.medicine.gzyun.health.utilTaskTime
 * 医生24小时未回复-(咨询时间为空)
 * 订单关闭: 取当前时间的前24小时并减10分钟，然后去数据库匹配，等于当前时间，并且咨询时间为空的数据-更改订单状态为6退款中
 * 扫描过程: 1小时扫一次-取当前时间的前24小时并减10分钟-订单状态为2-咨询开始时间为空-咨询的开始时间等于当前时间
 * @Description 1小时扫描一次----付款成功->订单关闭(自动退款)(医生24小时未回复--1小时扫描一次: 过程---如预约时间为:11:00-11:50  然后在12点时开始扫描 去当前时间减10分钟，获取订单状态为2的，并且咨询时间为空的)(最终状态)-更改订单状态为6退款中
 * @Data 2017-11-01 10:47
 **/
@Service("aminuteOutDateOrderRefundTask")
public class AminuteOutDateOrderRefundTask {

    public static final Logger LOGGER = Logger.getLogger(AminuteOutDateOrderRefundTask.class);

    @Autowired
    private HealthOrderService healthOrderService;

    @Autowired
    private HealthConsultationService healthConsultationService;


    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private PushMessageService pushMessageService;



    /**
     * 医生24小时未回复-订单关闭-自动退款
     */
    public void SendMessage(){
        LOGGER.info("AminuteOutDateOrderRefundTask start ....");
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            //获取某时刻过去的24小时
            Calendar date = Calendar.getInstance();
            date.setTime(new Date()); //定时器一小时一次
            date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);//24小时前
            date.add(Calendar.MINUTE, -10);// 10分钟之前的时间
            String defaultEndDate = df.format(date.getTime());
            LOGGER.info("医生未回复-当前的时间是: " + defaultEndDate);
            System.out.println("医生24小时未回复--------当前时间: " + df.format(new Date()) + "    ----24小时前的时间:" + df.format(date.getTime()));
            List<HealthyOrder> healthyOrderList = healthOrderService.OutDateOrderRefundList(defaultEndDate);
            if(healthyOrderList.size() > 0) {
                for (HealthyOrder healthorder : healthyOrderList) {
                    HealthyOrder healthyOrder = new HealthyOrder();
                    healthyOrder.setUpdatename("系统");
                    BeanUtils.copyProperties(healthorder,healthyOrder);
                    //更改订单的状态为5(退款审核中),并记录日志
                    healthyOrder.setOrderstate("6");
                    LOGGER.info("医生24小时未回复-订单关闭-自动退款 -- 更改状态 start ....");
                    LOGGER.info("医生24小时未回复-订单关闭-自动退款 -- 更改状态--------订单信息 start ...." + healthyOrder.toString());
                    healthOrderService.UpdateOrderAndLog(healthyOrder, "医生未回复,订单状态更改更改为退款审核中");
                }
            }

        }catch (Exception e){
            LOGGER.error("医生24小时未回复-订单关闭-自动退款: " + e.getMessage() + e);
        }
        LOGGER.info("aminuteOutDateOrderTask end ....");
    }


}
