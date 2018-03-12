package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.request.DTusrRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.Validator;

/**
 * Created by w维维 on 2017/12/15.
 */
@Controller
@RequestMapping("/sendAuthCodePush")
public class SendAuthCodePushController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(SendAuthCodePushController.class);

        @Autowired
        Validator validator;

    /**
     * 短信推送
     * @param mobile
     * @param content
     * @return
     */
    @RequestMapping(value = "/SMSPush", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public boolean SMSPush(@Valid String mobile,String content) {
        boolean flag = false;
        MobileCode mobileCode = new MobileCode();
        try {
            if(mobile!=null||content!=null){
                flag=mobileCode.sendAuthCode(mobile,content);
            }
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return  flag;
    }
}
