package com.gz.medicine.gzyun.health.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.service.HealthPushMessageService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthPushMessageController
 * @PackageName com.gz.medicine.gzyun.health.controller
 * @Description 消息推送 Controller
 * @Data 2017-09-21 10:47
 **/
@Controller
@RequestMapping("/pushmessage")
public class HealthPushMessageController {

    public static final Logger LOGGER = Logger.getLogger(HealthPushMessageController.class);

    @Autowired
    private HealthPushMessageService healthPushMessageService;


    /**
     *
     *@Title updateAll
     *@Description: 根据状态获取订单
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param userid 用户ID
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8081/GZ/pushmessage/updateall?userid
     */
    @RequestMapping(value="updateall",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult updateAll(String userid){
        SimpleResult simpleResult;
        LOGGER.info("[/pushmessage/updateall]");
        try {
            healthPushMessageService.updateAll(userid);
            simpleResult = SimpleResult.success();
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }
}
