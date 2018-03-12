package com.gz.medicine.gzyun.health.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.bean.HealthServiceConfig;
import com.gz.medicine.gzyun.health.bean.HealthTemplateType;
import com.gz.medicine.gzyun.health.reponse.HealthPushMessageCentre;
import com.gz.medicine.gzyun.health.reponse.HealthStatisticsReponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.RegexUtils;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.request.HealthConsultationRequest;
import com.gz.medicine.gzyun.health.service.HealthDocAppserver;
import com.gz.medicine.gzyun.heaman.controller.HmCaseupRecordController;

@Controller
@RestController
@RequestMapping("/docApp")
public class HealthDocAppController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordController.class);

	@Autowired
	private HealthDocAppserver docAppserver;
	@Autowired
	Validator validator;

	/**
	 * 咨询小结接口
	 * 
	 * @param consultationRequest
	 * @return
	 */
	@RequestMapping(value = "/updateItemByIdConsultationSummary", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateItemByIdConsultationSummary(@Valid HealthConsultationRequest consultationRequest) {
		SimpleResult sr = null;
		String result = null;
		try {
			if (validates(validator, consultationRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, consultationRequest));
			}
			result = docAppserver.updateItemByIdConsultationSummary(consultationRequest);
			if (result == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("Common","失败");
			}
		} catch (Exception e) {

		}

		return sr;
	}

	/**
	 * 图文咨询开始时间提交接口
	 * 
	 * @param consultationRequest
	 * @return
	 */
	@RequestMapping(value = "/updateItemByIdConsultationStartTime", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateItemByIdConsultationStartTime(@Valid HealthConsultationRequest consultationRequest) {
		if(!RegexUtils.valiDateTimeWithLongFormat(consultationRequest.getConsultationstarttime())){
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入正确的日期格式");
		}
		SimpleResult sr = null;
		String result = null;
		try {
			if (validates(validator, consultationRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, consultationRequest));
			}
			result = docAppserver.updateItemByIdConsultationStartTime(consultationRequest);
			if (result != null){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("Common","失败");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return  SimpleResult.error("Common","失败");
		}

		return sr;
	}

	/**
	 * 咨询接口
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryPageConsultation", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPageConsultation(PageModel page) {
		SimpleResult sr = null;
		Page response = null;
		try {
			response = docAppserver.queryPageConsultation(page);
			sr = SimpleResult.success(); 
		   sr.put("data", response);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 订单消息接口
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryPageHealthyOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPageHealthyOrder(PageModel page) {
		SimpleResult sr = null;
		Page response = null;
		try {
			response = docAppserver.queryPageHealthyOrder(page);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		sr = SimpleResult.success(); 
	    sr.put("data", response);
		return sr;
	}

	/**
	 * 排班统计
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/queryPageSchedulingStatistics", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPageSchedulingStatistics(String docid,String formdate) {
		SimpleResult sr = null;
		HealthStatisticsReponse orderReponse2 = null;
		HealthStatisticsReponse orderReponse3 = null;
		List<HealthStatisticsReponse> response = null;
		List<HealthStatisticsReponse> response3 = null;

		try {

			response = docAppserver.queryPageSchedulingStatistics(docid,formdate);//排班统计
			orderReponse2=docAppserver.querySchedulingDays(docid,formdate);//排班天数
			response3 = docAppserver.queryPageIntervalDate(docid,formdate);  //预约统计
			orderReponse3=docAppserver.queryIntervalDateDays(docid,formdate);//预约次数
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		sr = SimpleResult.success();

		sr.put("data", response);//排班统计
		sr.put("days", orderReponse2);//排班天数
		sr.put("data2", response3);//预约统计
		sr.put("days2", orderReponse3);//预约次数


		return sr;
	}

	/**
	 *
	 *服务设置
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/insertHealthServiceConfig", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult insertHealthServiceConfig(@Valid HealthServiceConfig record) {
		SimpleResult sr = null;
		String result = null;
		try {
			if (validates(validator, record) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			result = docAppserver.insertHealthServiceConfig(record);
		} catch (Exception e) {
		}
		sr = SimpleResult.success();
		return sr;
	}

	/**
	 * 查询这个医生的服务设置
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/selectByHealthServiceConfig", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult selectByHealthServiceConfig(@Valid HealthServiceConfig record) {
		SimpleResult simpleResult = null;
		HealthServiceConfig ServiceConfig = new HealthServiceConfig();

		try {
			if (validates(validator, record) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			ServiceConfig = docAppserver.selectByHealthServiceConfig(record.getDocid());
            if("".equals(ServiceConfig.getVideoservice())||ServiceConfig.getVideoservice()==null){
                ServiceConfig.setVideoservice("1");
            }

            if("".equals(ServiceConfig.getImageservice())||ServiceConfig.getImageservice()==null){
                ServiceConfig.setImageservice("1");
            }
            if("".equals(ServiceConfig.getVoiceservice())||ServiceConfig.getVoiceservice()==null){
                ServiceConfig.setVoiceservice("1");
            }


		} catch (Exception e) {
		}

            simpleResult = SimpleResult.success();
            simpleResult.put("data", ServiceConfig);
		    return simpleResult;
	}

	/**
	 * 我的消息
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryPagePushMessage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPagePushMessage(PageModel page) {
		SimpleResult sr = null;
		Page response = null;
		try {
			response = docAppserver.queryPagePushMessage(page);
			sr = SimpleResult.success();
			sr.put("data", response);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 模板接口
	 * @return
	 */
	@RequestMapping(value = "/selectTemplateType", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult selectTemplateType() {
		SimpleResult sr = null;
		List<HealthTemplateType> ContentReponses = null;
		try {
			ContentReponses = docAppserver.selectTemplateType();
			sr = SimpleResult.success();
			sr.put("data", ContentReponses);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 我的信息详情
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/updateByPushMessage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateByPushMessage(@Valid HealthPushMessage record) {
		SimpleResult sr = null;
		Map<String, Object> response=null;
		try {
			if (validates(validator, record) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			response = docAppserver.updateByPushMessage(record);

			sr = SimpleResult.success();
			sr.put("data", response);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}


	/**
	 * 医生端查看详情
	 */

	@RequestMapping(value = "/queryConsultation", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryConsultation(@RequestParam(value = "id", required = true) String id)  {
		SimpleResult sr = null;
		Map<String,Object> resultMp= null;
		try {
			resultMp = docAppserver.queryConsultation(id);
			sr = SimpleResult.success();
			sr.put("data",resultMp);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}


	/**
	 * 我的消息删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/updateByMessageState", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateByMessageState(@RequestParam(value = "id", required = true) String id)  {
		SimpleResult sr = null;
		String resultMp= null;
		try {
			resultMp = docAppserver.updateByMessageState(id);
			if (resultMp == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}


	/**
	 * 消息中心
	 * @param userid
	 * @return
	 */
	@RequestMapping(value = "/selectPushMessage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult selectPushMessage(@RequestParam(value = "userid", required = true) String userid)  {
		SimpleResult sr = null;
		List<HealthPushMessageCentre> resultMp= null;
		try {
			resultMp = docAppserver.selectPushMessage(userid);
			if (resultMp != null){
				sr = SimpleResult.success();
				sr.put("data",resultMp);
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 *系统消息  修改未读
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/updateByPushMessageSys", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateByPushMessageSys(HealthPushMessage record)  {
		SimpleResult sr = null;
		String resultMp= null;
		try {
			resultMp = docAppserver.updateByPushMessageSys(record);
			if (resultMp == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}


}
