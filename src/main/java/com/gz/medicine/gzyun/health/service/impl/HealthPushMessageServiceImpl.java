package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.mapper.HealthPushMessageMapper;
import com.gz.medicine.gzyun.health.service.HealthPushMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthPushMessageServiceImpl
 * @PackageName com.gz.medicine.gzyun.health.service.impl
 * @Description 消息推送
 * @Data 2017-08-17 14:18
 **/
@Service
public class HealthPushMessageServiceImpl implements HealthPushMessageService {

    @Autowired
    private HealthPushMessageMapper healthPushMessageMapper;

    @Override
    public int insertHealthPushMessage(HealthPushMessage healthPushMessage) throws CommonException {
        return healthPushMessageMapper.insertSelective(healthPushMessage);
    }

    @Override
    public int updateAll(String userid) throws CommonException {
        int count = 0;
        try {
            count = healthPushMessageMapper.updateAll(userid);
        }catch (Exception e){
            e.printStackTrace();
            throw  new CommonException("消息更改错误",e.getMessage());
        }
        return count;
    }
}
