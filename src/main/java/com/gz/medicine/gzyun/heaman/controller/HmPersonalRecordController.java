package com.gz.medicine.gzyun.heaman.controller;


import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.service.HmPersonalRecordService;
import com.gz.medicine.gzyun.user.reponse.UserReponse;
import com.gz.medicine.gzyun.user.request.UserRegRequest;

@Controller
@RequestMapping("/GZJKinterface03")
public class HmPersonalRecordController extends ValidateWithException {


	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordController.class);

	@Autowired
	private HmPersonalRecordService recordService;
	@Autowired
	Validator validator;

	/**
	 * 个人信息查询
	 * 4DF60C3C69D878C3E053AA0012ACAEF9
	 * @param hmPhyRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetPersonalRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetPersonalRecord(@Valid UserReponse userReponse) {
		SimpleResult sr = null;
		String gpRecode = null;
		try {
			if (validates(validator, userReponse) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, userReponse));
			}
			gpRecode = recordService.selectByRecord(userReponse.getGuid());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}
}
