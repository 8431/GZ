package com.gz.medicine.gzyun.health.exception;

import com.google.gson.Gson;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.IPUtils;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.gzyun.MonitorSystem.util.Sendmail;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/16 0016.
 * 测试代码
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public SimpleResult handleCommonException(HttpServletRequest request,CommonException ex) {
        SimpleResult sr=null;
        try{
//            Gson gn=new Gson();
//            Map mp=request.getParameterMap();
//            Map<String,String> mpReturn=new HashedMap();
//            mpReturn.put("url",request.getRequestURI());
//            mpReturn.put("ip地址", IPUtils.getIpAddr(request));
//            mpReturn.put("入参",gn.toJson(mp));
//            mpReturn.put("异常信息",ex.getMessage());
//            mpReturn.put("生成时间", TimeUtil.dateTimeFormat(new Date()));
//            String jsonData=gn.toJson(mpReturn);
            //Sendmail.sendEmail("1429264916@qq.com", "贯众心理健康异常日志",jsonData);
            sr= SimpleResult.error(SimpleCode.ERROR.getCode(), ex.getMessage());
        }catch (Exception e){
            LOGGER.error("发送邮件异常："+e.getMessage());
        }
        return  sr;
    }



}
