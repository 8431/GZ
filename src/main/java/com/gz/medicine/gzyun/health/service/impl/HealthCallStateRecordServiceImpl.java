/**
 * projectName: GZYUN
 * fileName: HealthCallStateRecordServiceImpl.java
 * packageName: com.gz.medicine.gzyun.health.service.impl
 * date: 2017-12-19 15:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.HealthCallStateRecord;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.mapper.HealthCallStateRecordMapper;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.service.HealthCallStateRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthCallStateRecordServiceImpl
 * @packageName: com.gz.medicine.gzyun.health.service.impl
 * @description: 呼叫状态记录表Service实现类
 * @data: 2017-12-19 15:22
 **/
@Service
public class HealthCallStateRecordServiceImpl implements HealthCallStateRecordService {

    public static final Logger LOGGER = Logger.getLogger(HealthCallStateRecordServiceImpl.class);

    @Autowired
    public HealthCallStateRecordMapper healthCallStateRecordMapper;

    @Autowired
    public HealthConsultationMapper healthConsultationMapper;

    @Override
    public int insert(HealthCallStateRecord healthCallStateRecord) throws CommonException {
        int flag = 0;
        HealthConsultation healthConsultation;
        healthCallStateRecord.setId(UUIDTool.getUUID());
        SimpleDateFormat myFormatter = new SimpleDateFormat("HH:mm:ss");
        try {
            flag = healthCallStateRecordMapper.insertSelective(healthCallStateRecord);
            //根据订单ID获取咨询信息
            healthConsultation = healthConsultationMapper.selectByPrimaryOrderId(healthCallStateRecord.getOrderid());

            if("1".equals(healthCallStateRecord.getCallstate())){
                healthConsultation.setConsultationstarttime(new Date()); //咨询开始时间
                healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);
            }

            //2.3.4.6
            if("2".equals(healthCallStateRecord.getCallstate())){
                if(healthConsultation != null){
                    if(healthConsultation.getConsultationstarttime() == null || "".equals(healthConsultation.getConsultationstarttime())){
                        healthConsultation.setConsultationstarttime(new Date()); //咨询开始时间
                        healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);
                    }
                }

            }

            if("3".equals(healthCallStateRecord.getCallstate())){
                if(healthConsultation != null){
                    if(healthConsultation.getConsultationstarttime() == null ||"".equals(healthConsultation.getConsultationstarttime())){
                        healthConsultation.setConsultationstarttime(new Date());
                        healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);
                    }
                }

            }
            //挂断
            if("4".equals(healthCallStateRecord.getCallstate())){
                //该订单有咨询
                if(healthConsultation != null){
                        //呼叫时长 3
                        HealthCallStateRecord healthCallStateRecorda = healthCallStateRecordMapper.selectByPrimaryKeySelective(healthCallStateRecord.getOrderid(),"3");

                        //本次通话时长 4
                        HealthCallStateRecord healthCallStateRecordb = healthCallStateRecordMapper.selectByPrimaryKeySelective(healthCallStateRecord.getOrderid(),"4");

                        if(healthCallStateRecorda != null && healthCallStateRecordb != null){
                            //4-3的时间 获得两个时间的毫秒时间差异
                            long diff = healthCallStateRecordb.getCreatedate().getTime() - healthCallStateRecorda.getCreatedate().getTime();//这样得到的差值是微秒级别
                            long nd = 1000 * 24 * 60 * 60;
                            long nh = 1000 * 60 * 60;
                            long nm = 1000 * 60;
                            long ns = 1000;
                            // 计算差多少天
                            long day = diff / nd;
                            // 计算差多少小时
                            long hour = diff % nd / nh;
                            // 计算差多少分钟
                            long min = diff % nd % nh / nm;
                            // 计算差多少秒//输出结果
                            long sec = diff % nd % nh % nm / ns;
                            if(healthConsultation.getConsultinghours() != null){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(myFormatter.parse(healthConsultation.getConsultinghours()));
                                int shi = (int)cal.get(Calendar.HOUR_OF_DAY)+(int)hour;
                                int fendo = (int)cal.get(Calendar.MINUTE)+(int)min;
                                int miao = (int)cal.get(Calendar.SECOND)+(int)sec;
                                if(miao>60){
                                    miao=00;
                                    if(fendo>60){
                                        fendo = 00;
                                        shi = shi+1;
                                    }else {
                                        fendo = fendo + 1;
                                    }
                                }
                                String currentdata = shi + ":" + fendo + ":" + miao;

                                Date dates = myFormatter.parse(shi + ":" + fendo + ":" + miao);
                                LOGGER.info("咨询中有时间: " + myFormatter.format(dates));
                                healthConsultation.setConsultinghours(myFormatter.format(dates));
                            }else {
                                String currentdata = hour + ":" + min + ":" + sec;
                                Date dates = myFormatter.parse(hour + ":" + min + ":" + sec);
                                healthConsultation.setConsultinghours(myFormatter.format(dates));
                                LOGGER.info("咨询中无时间: " + myFormatter.format(dates));

                            }
                        }
                        healthConsultation.setConsultationstarttime(new Date());
                        healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);

                }

            }
            if("6".equals(healthCallStateRecord.getCallstate())){
                if(healthConsultation != null){
                    if(healthConsultation.getConsultationstarttime() == null || "".equals(healthConsultation.getConsultationstarttime())){
                        healthConsultation.setConsultationstarttime(new Date());
                        healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);
                    }
                }
            }
        }catch (Exception e){
            throw new CommonException("COM001","新增呼叫状态异常");
        }
        return flag;
    }

    @Override
    public HealthCallStateRecord find(String id) throws CommonException {
        HealthCallStateRecord healthCallStateRecord;
        try {
            healthCallStateRecord = healthCallStateRecordMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            throw new CommonException("COM001","获取呼叫状态异常");
        }
        return healthCallStateRecord;
    }
}
