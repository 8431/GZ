package com.gz.medicine.gzyun.health.utilTaskTime;

import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthDoctorFormMapper;
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
 * @ClassName FiveMinutesOrdeTask
 * @PackageName com.gz.medicine.gzyun.health.utilTaskTime
 * @Description 1分钟扫描一次----超时没支付(30分钟未支付,按订单创建时间来算) ----订单状态改为订单已取消(3)
 *  也就是根据订单中的状态未待支付(1)的条件取获取订单的下单时间，然后和当前的时间进行判断，看订单中的时间是否大于30分钟
 * @Data 2017-11-01 10:47
 **/
@Service("aminuteTimeoutOrderTask")
public class AminuteTimeoutOrderTask {

    public static final Logger LOGGER = Logger.getLogger(AminuteTimeoutOrderTask.class);

    @Autowired
    private HealthOrderService healthOrderService;

    @Autowired
    private HealthDoctorFormMapper healthDoctorFormMapper;

    @Autowired
    private PushMessageService pushMessageService;


    /**
     * 超时没支付 -- 更改状态
     */
    public void SendMessage(){
        LOGGER.info("fiveMinutesOrdeTask start ....");

        try {
            //获取今天所有的订单
            //取当前的时分-30
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Calendar nowTime2 = Calendar.getInstance();
            nowTime2.add(Calendar.MINUTE, -30);//30分钟前的时间
            LOGGER.info("超时没支付----当前时间: " + df.format(new Date()) + "  ----30分钟前的时间" + df.format(nowTime2.getTime()));
            String currentTime = df.format(nowTime2.getTime());
            List<HealthyOrder> healthyOrderList = healthOrderService.TimeoutOrderList(currentTime);
            if(healthyOrderList.size() > 0){
                for (HealthyOrder healthorder : healthyOrderList) {
                            HealthyOrder healthyOrder = new HealthyOrder();
                            BeanUtils.copyProperties(healthorder,healthyOrder);
                            //更改订单的状态为订单已取消(3),并记录日志
                            healthyOrder.setOrderstate("3");
                            healthorder.setUpdatename("系统");
                            healthOrderService.UpdateOrderAndLog(healthyOrder,"订单超时没支付,状态更改");
                            LOGGER.info("超时没支付----更改状态healthyOrder start ...." + healthyOrder.toString());
                            LOGGER.info("超时没支付----订单信息healthorder start ...." + healthorder.toString());

                            //同时给患者推送消息
                            pushMessageService.PushMessageTimeoutOrder(healthorder);
                            //更改医生排班状态
                            HealthDoctorForm healthDoctorForm = new HealthDoctorForm();
                            healthDoctorForm.setDocid(healthorder.getDocid()); //医生ID
                            healthDoctorForm.setFormdate(healthorder.getReservationdate()); //预约日期
                            healthDoctorForm.setFormstarttime(healthorder.getReserstarttime());//预约开始时间
                            healthDoctorForm.setFormendtime(healthorder.getReserendtime()); //预约结束时间
                            healthDoctorForm.setFormstate("0");//设置状态为 0 未预约
                            healthDoctorFormMapper.updateDocFormState(healthDoctorForm);

                }
            }

        }catch (Exception e){
            LOGGER.error("订单咨询前5分钟发送通知错误: " + e.getMessage() + e);
        }

        LOGGER.info("fiveMinutesOrdeTask end ....");
    }
}
