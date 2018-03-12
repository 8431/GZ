package com.gz.medicine.gzyun.push.controller;

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
import com.gz.medicine.gzyun.push.request.HealthUmengEquipmentRequest;
import com.gz.medicine.gzyun.push.service.HealthUmengEquipmentService;
import com.gz.medicine.gzyun.push.service.PushMessageService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Validator;

/**
 * @Title HealthUmengEquipmentController
 * @Description  友盟推送绑定设备的Controller
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
@Controller
@RequestMapping("/umengequipment")
public class HealthUmengEquipmentController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(HealthUmengEquipmentController.class);

    @Autowired
    Validator validator;


    @Autowired
    private HealthUmengEquipmentService healthUmengEquipmentService;

    @Autowired
    private PushMessageService pushMessageService;


    @Autowired
    private HealthOrderService healthOrderService;

    @RequestMapping(value = "/addumengequipment", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult AddUmengequipment(HealthUmengEquipmentRequest data){
        SimpleResult simpleResult = null;
        try {
            if(validates(validator, data) != null){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
            }

            HealthUmengEquipment healthUmengEquipment =  healthUmengEquipmentService.getByUseridHealthUmengEquipment(data.getUserid());
            if(healthUmengEquipment != null){
                HealthUmengEquipment healthUmengEquipments = new HealthUmengEquipment();
                BeanUtils.copyProperties(data,healthUmengEquipments);
                LOGGER.info("[umengequipment/addumengequipment] : data" + JSONObject.fromObject(data));
                LOGGER.info("[umengequipment/addumengequipment] : healthUmengEquipments" + JSONObject.fromObject(healthUmengEquipments));
                healthUmengEquipmentService.updateHealthUmengEquipment(healthUmengEquipments);
            }else {
                HealthUmengEquipment healthUmengEquipments = new HealthUmengEquipment();
                BeanUtils.copyProperties(data,healthUmengEquipments);
                LOGGER.info("[umengequipment/addumengequipment] : data" + JSONObject.fromObject(data));
                LOGGER.info("[umengequipment/addumengequipment] : healthUmengEquipments" + JSONObject.fromObject(healthUmengEquipments));
                healthUmengEquipmentService.insertHealthUmengEquipment(healthUmengEquipments);
            }

        }catch (Exception e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());
        }
        simpleResult = SimpleResult.success();
        return simpleResult;
    }

    /**
     * 推送测试
     * 测试地址: http://localhost:8081/GZ/umengequipment/testpushmessage?orderid=1510889448370747861000003477
     * @param data
     * @return
     */
    @RequestMapping(value = "/updateumengequipment", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult UpdateUmengequipment(HealthUmengEquipment data){
        SimpleResult simpleResult = null;
        try {
            if(!"".equals(data.getUserid())){
                HealthUmengEquipment healthUmengEquipment =  healthUmengEquipmentService.getByUseridHealthUmengEquipment(data.getUserid());
                HealthUmengEquipment healthUmengEquipments = new HealthUmengEquipment();
                BeanUtils.copyProperties(data,healthUmengEquipments);
                healthUmengEquipmentService.insertHealthUmengEquipment(healthUmengEquipments);
            }else {
                return SimpleResult.error("001","用户不能为空!!");
            }
        }catch (Exception e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());
        }
        simpleResult = SimpleResult.success();
        return simpleResult;
    }

    @RequestMapping(value = "/testpushmessage", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult Testpushmessage(String orderid){
        SimpleResult simpleResult = null;
        try {
           HealthyOrder healthyOrder = healthOrderService.selectOrderById(orderid);
            //同时给患者和医生推送信息
            pushMessageService.PushMessageTask(healthyOrder,"您的咨询服务将在5分钟后开始!","xxx","1");
            pushMessageService.PushMessageTask(healthyOrder,"您的咨询服务将在5分钟后开始!","xxx","2");
        }catch (Exception e){

        }
        simpleResult = SimpleResult.success();
        return simpleResult;
    }


}
