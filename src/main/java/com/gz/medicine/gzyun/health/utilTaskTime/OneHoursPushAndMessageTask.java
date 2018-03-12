/**
 * projectName: gzs
 * fileName: OneHoursPushAndMessageTask.java
 * packageName: com.gz.medicine.gzyun.health.utilTaskTime
 * date: 2018-02-05 10:57
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.gzyun.health.utilTaskTime;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import com.gz.medicine.yun.common.service.SendMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: OneHoursPushAndMessageTask
 * @packageName: com.gz.medicine.gzyun.health.utilTaskTime
 * @description: 给患者推送消息与发送短信
 * 1小时扫描一次-获取订单状态为5(订单完成)-给患者发送短信以及推送消息
 * @data: 2018-02-05 10:57
 **/
@Service("oneHoursPushAndMessageTask")
public class OneHoursPushAndMessageTask {

    public static final Logger LOGGER = Logger.getLogger(OneHoursPushAndMessageTask.class);

    @Autowired
    private PushMessageService pushMessageService;

    public void SendMessage() {
        try {
            pushMessageService.SendHoursPushAndMessage();
        }catch (Exception e){
            LOGGER.error("给患者推送消息与发送短信错误: " + e.getMessage() + e);
        }
    }

}
