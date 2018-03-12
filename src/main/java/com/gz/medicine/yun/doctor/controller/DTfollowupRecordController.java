package com.gz.medicine.yun.doctor.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.Validator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.reponse.DTfollowupRecordResponse;
import com.gz.medicine.yun.doctor.request.DTmessageRecordRequest;
import com.gz.medicine.yun.doctor.service.DTmessageRecordService;

@Controller
@RequestMapping("/Docpre")
public class DTfollowupRecordController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(DTfollowupRecordController.class);

	@Autowired
	private DTmessageRecordService messageRecordService;
	@Autowired
	Validator validator;

	/**
	 * 随访记录列表
	 * 
	 * @param
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/GetDTfollowupRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetDTfollowupRecord(PageModel page) {
		SimpleResult sr = null;
		try {
			sr = messageRecordService.selectByMessageRecord(page);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 随访记录列表 PC端
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/GetDTfollowupRecordPC", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetDTfollowupRecordPC(PageModel page) {
		SimpleResult sr = null;
		try {
			sr = messageRecordService.queryPageMessageRecord(page);
		} catch (Exception e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 随访记录视频记录详细信息接口 video
	 * 
	 * @param record
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/GetDTfollowupVideo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetDTfollowupVideo(@Valid DTmessageRecordRequest record) {
		SimpleResult sr = null;
		List<DTfollowupRecordResponse> followup = null;
		try {
			if (validates(validator, record) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			followup = messageRecordService.selectDTfollowupRecord(record.getGuid());
		} catch (CommonException e) {

			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		sr = SimpleResult.success();
		sr.put("data", followup);
		//sr.putData("followup", followup);
		
		return sr;
	}
}
