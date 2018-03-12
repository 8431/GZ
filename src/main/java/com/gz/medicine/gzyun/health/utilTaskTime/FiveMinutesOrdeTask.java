package com.gz.medicine.gzyun.health.utilTaskTime;

import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.yun.common.service.SendMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName FiveMinutesOrdeTask
 * @PackageName com.gz.medicine.gzyun.health.utilTaskTime
 * @Description 订单咨询前5分钟发送通知
 * 先获取订单中的状态为2(支付成功)的数据,然后获取订单中的预约开始时间，然后和当前时间进行对比，得出分钟数，如果为5就发送信息
 * @Data 2017-11-01 10:47
 **/
@Service("fiveMinutesOrdeTask")
public class FiveMinutesOrdeTask {

    public static final Logger LOGGER = Logger.getLogger(FiveMinutesOrdeTask.class);


    @Autowired
    private HealthOrderService healthOrderService;


    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private SendMessageService sendMessageService;


    /**
     * 1 小时扫描一次 -- 5分钟前 通知    --医生推送 患者短信提示加推送
     */
    public void SendMessage(){

        LOGGER.info("fiveMinutesOrdeTask start ....");

        try {
            //取当前的时分+5
            SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(Calendar.MINUTE, 5);
            String currentTime = df.format(nowTime.getTime());
            LOGGER.info("5分钟前通知----当前时间: " + df.format(new Date()) + "    ----当前时间加5分钟:" + df.format(nowTime.getTime()));
            //获取今天所有的订单
            List<HealthyOrder> healthyOrderList = healthOrderService.MinutesOrderList(currentTime);  //取分钟数
            if(healthyOrderList.size() > 0){
                for (HealthyOrder healthorder : healthyOrderList) {
                        String type = healthorder.getConsultationmethod();
                        String typeContent = null;
                        //（图文、语音、视频）2,3,4
                        if("2".equals(type)){
                            typeContent = "图文咨询";
                        }else if("3".equals(type)){
                            typeContent = "语音咨询";
                        }else  if("4".equals(type)){
                            typeContent = "视频咨询";
                        }
                         LOGGER.info("5分钟前通知 ----给患者和医生推送信息 start ....");
                         LOGGER.info("5分钟前通知  ----" + healthorder.toString());

                        LOGGER.info("给患者发送短信  ---- Start" );
                        //给患者发送短信
                        sendMessageService.SendMessageTaskBegin(healthorder.getId());
                        LOGGER.info("给患者发送短信  ---- end" );

                        //给医生发送短信
                        LOGGER.info("同时给患者和医生推送信息  ---- Start" );
                        //同时给患者和医生推送信息
                        pushMessageService.PushMessageTask(healthorder,"您的" + typeContent + "咨询服务将在5分钟后开始!",typeContent,"1");
                        pushMessageService.PushMessageTask(healthorder,"您的" + typeContent + "咨询服务将在5分钟后开始!",typeContent,"2");
                        LOGGER.info("同时给患者和医生推送信息  ---- end" );
                }
            }
        }catch (Exception e){
            LOGGER.error("订单咨询前5分钟发送通知错误: " + e.getMessage() + e);
        }

        LOGGER.info("fiveMinutesOrdeTask end ....");
    }

}
