package com.gz.medicine.yun.doctor.controller;

import java.util.ArrayList;
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
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.bean.DTmessageRecord;
import com.gz.medicine.yun.doctor.request.DTmessageRecordRequest;
import com.gz.medicine.yun.doctor.service.DTmessageRecordService;

@Controller
@RequestMapping("/Docpre")
public class DTmessageRecordController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(DTmessageRecordController.class);

	@Autowired
	private DTmessageRecordService messageRecordService;
	@Autowired
	Validator validator;

	/**
	 * 短信记录 详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GetDTmessageRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetDTmessageRecord(@Valid DTmessageRecordRequest recordRequest) {
		SimpleResult sr = null;
		DTmessageRecord gpRecode = null;
		List<DTmessageRecord> lists=new ArrayList<DTmessageRecord>();
		try {
			if (validates(validator, recordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, recordRequest));
			}
			gpRecode = messageRecordService.selectByPrimaryKey(recordRequest.getGuid());
		} catch (CommonException e) {
			LOGGER.error(e);
		}
		sr = SimpleResult.success();
		lists.add(gpRecode);
		sr.put("data", lists);
		return sr;
	}
}
