/**
 * projectName: GZYUN
 * fileName: ExceSQLServiceImpl.java
 * packageName: com.gz.medicine.yun.common.service.impl
 * date: 2018-01-23 15:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.common.service.impl;

import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.common.bean.SmsrdLog;
import com.gz.medicine.yun.common.mapper.SmsrdLogMapper;
import com.gz.medicine.yun.common.service.SmsrdLogService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ExceSQLServiceImpl
 * @packageName: com.gz.medicine.yun.common.service.impl
 * @description:
 * @data: 2018-01-23 15:22
 **/
@Service
public class SmsrdLogServiceImpl implements SmsrdLogService {

    public static final Logger LOGGER = Logger.getLogger(SmsrdLogServiceImpl.class);


    @Autowired
    private SmsrdLogMapper smsrdLogMapper;


    @Override
    public boolean sendCode(String mobile,String content) throws Exception {
        String ip = getIpAddr();
        if(StringUtils.isNotEmpty(ip)){
            //获取IP
            Integer num = smsrdLogMapper.getCountIp(ip);
            LOGGER.error("num------------------------:"+num);
            if(num >= 10){
                return  Boolean.FALSE;
            }
        }else {
            return  Boolean.FALSE;
        }
        Integer cnt = smsrdLogMapper.getCountPhone(mobile); //根据手机号获取数据
        LOGGER.error("cnt------------------------:"+cnt);
        if(cnt>0){
            Integer min = smsrdLogMapper.getCountMin(mobile); //获取最近一条数据的时间,如果为0，就说明是在同一分钟
            LOGGER.error("min------------------------:"+min);
            if(min<1){
                return  Boolean.FALSE;
            }else{
                cnt = smsrdLogMapper.getCountCntNum(mobile);
                if(cnt!=null){
                    if(cnt > 10){
                        return  Boolean.FALSE;
                    }
                }

            }
        }
        MobileCode.sendAuthCode(mobile,content);
        SmsrdLog smsrdLog = new SmsrdLog();
        smsrdLog.setPhone(mobile);
        smsrdLog.setGuid(UUIDTool.getUUID());
        smsrdLog.setHospital(PropertyUtil.getPropery("hospital"));
        smsrdLog.setType("验证码");
        smsrdLog.setPlatform("51sxun");
        smsrdLog.setNote(content);
        smsrdLog.setIpaddr(ip);
        smsrdLogMapper.insertSelective(smsrdLog);
        return Boolean.TRUE;
    }

    public String getIpAddr(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
