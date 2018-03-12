package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthPushMessageService
 * @PackageName com.gz.medicine.gzyun.health.service
 * @Description 消息推送
 * @Data 2017-09-21 10:47
 **/
public interface HealthPushMessageService {

    int insertHealthPushMessage(HealthPushMessage healthPushMessage)throws CommonException;

    int updateAll(String userid)throws CommonException;
}
