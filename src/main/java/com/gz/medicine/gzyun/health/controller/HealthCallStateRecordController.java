/**
 * projectName: GZYUN
 * fileName: HealthCallStateRecordController.java
 * packageName: com.gz.medicine.gzyun.health.controller
 * date: 2017-12-19 15:18
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.gzyun.health.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.bean.HealthCallStateRecord;
import com.gz.medicine.gzyun.health.mapper.HealthCallStateRecordMapper;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.service.HealthCallStateRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Validator;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthCallStateRecordController
 * @packageName: com.gz.medicine.gzyun.health.controller
 * @description: 呼叫状态记录表Controller
 * @data: 2017-12-19 15:18
 **/
@Controller
@RequestMapping("/callstate")
public class HealthCallStateRecordController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(HealthCallStateRecordController.class);


    @Autowired
    Validator validator;


    @Autowired
    private HealthCallStateRecordService healthCallStateRecordService;


    @Autowired
    private HealthConsultationMapper healthConsultationMapper;


    @RequestMapping(value = "/findById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult findById(String orderid){
        SimpleResult simpleResult;
        HealthCallStateRecord healthCallStateRecord;
        Date createDate;
        try {
            simpleResult = new SimpleResult();
            simpleResult.put("code","000");
            simpleResult.put("message","成功");
            healthCallStateRecord = healthCallStateRecordService.find(orderid);
            if(healthCallStateRecord != null){
                if("1".equals(healthCallStateRecord.getCallstate())){
                    createDate  =  healthCallStateRecord.getCreatedate();
                    Date a = healthConsultationMapper.getCurrentDates();
                    long interval = ( a.getTime() - createDate.getTime() )/1000;
                    if(interval > 60){
                        simpleResult.put("data","6");
                    }else {
                        simpleResult.put("data",healthCallStateRecord.getCallstate());
                    }
                }else {
                    simpleResult.put("data",healthCallStateRecord.getCallstate());
                }

            }else {
                simpleResult.put("data","0");
            }

        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult create(HealthCallStateRecord data){
        SimpleResult simpleResult;
        try {
            simpleResult=SimpleResult.success();
            healthCallStateRecordService.insert(data);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

}
