package com.gz.medicine.gzyun.push.controller;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.mapper.HealthPushMessageMapper;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
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

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.push.comm.SendMessage;
import com.gz.medicine.gzyun.user.request.PushRequest;

@Controller
@RequestMapping("/push")
public class PushMessageController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(PushMessageController.class);


    @Autowired
    Validator validator;

    @Autowired
	private PushMessageService pushMessageService;

	@Autowired
	private HealthPushMessageMapper healthPushMessageMapper;

	@Autowired
	private HealthUmengEquipmentService healthUmengEquipmentService;

	 /**
	  * 消息推送
	  * @param data
	  * @return
	  */
    @RequestMapping(value = "/pushMessage", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult pushMessage(PushRequest data) {
    	SimpleResult sr = null;
    	String message = null;
		int countsum = 0;
        try {
				if(validates(validator, data) != null){
					return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
				}
				HealthPushMessage healthPushMessage = new HealthPushMessage();
				healthPushMessage.setUserid(data.getGuid());
				countsum = healthPushMessageMapper.countById(healthPushMessage);
				data.setBage(countsum+1);
                LOGGER.info("[push/pushMessage]" + JSONObject.fromObject(data).toString());
				HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(data.getGuid());
                PushRequest pushRequest = new PushRequest();
			    BeanUtils.copyProperties(data,pushRequest);
                pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
                pushRequest.setGuid(healthUmengEquipment.getUserid());
                pushRequest.setAppkey(healthUmengEquipment.getAppkey());
                pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
                pushRequest.setMessage(data.getMessage());
                pushRequest.setMessagename(data.getMessagename());
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
                pushRequest.setBage(countsum+1);
                pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
                pushRequest.setAlias(healthUmengEquipment.getAlias());
                pushRequest.setOrderId(data.getOrderId());
                pushRequest.setMessageType(data.getMessageType());
				if(healthUmengEquipment!=null){
					if("1".equals(healthUmengEquipment.getPhonetype())){
						message=SendMessage.sendIOSCustomizedcast(pushRequest);
					}else if("2".equals(healthUmengEquipment.getPhonetype())){
						pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
						message =  SendMessage.sendAndroidCustomizedcast(pushRequest);
					}
				}else {
					return SimpleResult.error(SimpleCode.ERROR.getCode(),"没有当前设备!");
				}
			    pushMessageService.insertPushMessage(data);
			} catch ( Exception e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());
			}
	        sr = SimpleResult.success();
	        sr.setMessage(message);
	        return sr;
    }
    
    
    /**
	  * 消息推送
	  * @param data
	  * @return
	  */
   @RequestMapping(value = "/pushCustomizedcast", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
   @ResponseBody
   public SimpleResult pushCustomizedcast(PushRequest data) {
	   SimpleResult sr = null;
	   String message = null;
	   int countsum = 0;
	   String id = null;
       try {
				if(validates(validator, data)!=null){
					return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
				}
			    HealthPushMessage healthPushMessage = new HealthPushMessage();
			    healthPushMessage.setUserid(data.getGuid());
			    countsum = healthPushMessageMapper.countById(healthPushMessage);
                LOGGER.info("[push/pushMessage]" + JSONObject.fromObject(data).toString());
		        HealthUmengEquipment healthUmengEquipment = healthUmengEquipmentService.getByUseridHealthUmengEquipment(data.getGuid());
                PushRequest pushRequest = new PushRequest();
		        BeanUtils.copyProperties(data,pushRequest);
                pushRequest.setPhoneType(healthUmengEquipment.getPhonetype());
                pushRequest.setGuid(healthUmengEquipment.getUserid());
                pushRequest.setAppkey(healthUmengEquipment.getAppkey());
                pushRequest.setAppMasterSecret(healthUmengEquipment.getAppmastersecret());
                pushRequest.setMessage(data.getMessage());
                pushRequest.setMessagename(data.getMessagename());
                pushRequest.setUmengMessageSecret(healthUmengEquipment.getUmengmessagesecret());
                pushRequest.setBage(countsum+1);
                pushRequest.setAlias_type(healthUmengEquipment.getAliasType());
                pushRequest.setAlias(healthUmengEquipment.getAlias());
                pushRequest.setOrderId(data.getOrderId());
                pushRequest.setMessageType(data.getMessageType());
		        if(healthUmengEquipment!=null){
					if("1".equals(healthUmengEquipment.getPhonetype())){
						message=SendMessage.sendIOSCustomizedcast(pushRequest);
					}else if("2".equals(healthUmengEquipment.getPhonetype())){
						pushRequest.setDeviceToken(healthUmengEquipment.getDevicetokens());
						message =  SendMessage.sendAndroidCustomizedcast(pushRequest);
					}
				}else {
					return SimpleResult.error(SimpleCode.ERROR.getCode(),"没有当前设备!");
				}
		        pushMessageService.insertPushMessage(data);
			} catch ( Exception e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getMessage());
			}
	        sr = SimpleResult.success();
	        sr.setMessage(message);
	        return sr;
   }
}
