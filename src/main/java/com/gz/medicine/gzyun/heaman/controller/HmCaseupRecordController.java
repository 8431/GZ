package com.gz.medicine.gzyun.heaman.controller;

import java.util.List;

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
import com.gz.medicine.gzyun.heaman.bean.HmCaseupRecord;
import com.gz.medicine.gzyun.heaman.request.HmCaseupRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmCaseupRecordService;

@Controller
@RequestMapping("/GZJKinterface03")
public class HmCaseupRecordController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordController.class);

	@Autowired
	private HmCaseupRecordService caseupRecordService;
	@Autowired
	Validator validator;

	/**
	 * 病历上传查询接口（查询）
	 * 
	 * @param usrguid
	 * @return
	 */
	@RequestMapping(value = "/GetGZJKcaseupRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetGZJKcaseupRecord(@Valid HmCaseupRecordRequest caseupRecordRequest) {
		SimpleResult sr = null;
		List<HmCaseupRecord> gpRecode = null;
		try {
			if (validates(validator, caseupRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, caseupRecordRequest));
			}
			gpRecode = caseupRecordService.selectByCaseup(caseupRecordRequest.getUsrguid());
			System.out.println(gpRecode.size());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}

	// 查全部
	@RequestMapping(value = "/GZJKcaseupRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GZJKcaseupRecord(@Valid HmCaseupRecordRequest request) {
		SimpleResult sr = null;
		List<HmCaseupRecordRequest> pwd = null;
		System.out.println("request:" + request);
		try {
			if (validates(validator, request) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, request));
			}
			pwd = caseupRecordService.ListCaseup(request);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		sr = SimpleResult.success();
		sr.putData("pwd", pwd);
		return sr;
	}

	/**
	 * 病例解读详情接口（查询）
	 * 
	 * @param caseupRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetBLInterpretationDetails", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetBLInterpretationDetails(@Valid HmCaseupRecordRequest caseupRecordRequest) {
		SimpleResult sr = null;
		List<HmCaseupRecord> gpRecode = null;
		try {
			if (validates(validator, caseupRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, caseupRecordRequest));
			}
			gpRecode = caseupRecordService.selectByDetails(caseupRecordRequest.getGuid());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);

		return sr;

	}

	/**
	 * 病例解读列表接口 （查询）
	 * 
	 * @param caseupRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetBLInterpretationList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetBLInterpretationList(@Valid HmCaseupRecordRequest caseupRecordRequest) {
		SimpleResult sr = null;
		List<HmCaseupRecord> gpRecode = null;
		try {
			if (validates(validator, caseupRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, caseupRecordRequest));
			}
			gpRecode = caseupRecordService.selectByInterpretation(caseupRecordRequest.getUsrguid());
			System.out.println(gpRecode.size());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}

	/**
	 * 病历上传查询接口（写入）
	 * 
	 * @param caseupRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/WriteGZJKcaseupRecord ", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult WriteGZJKcaseupRecord(@Valid HmCaseupRecordRequest caseupRecordRequest) {
		SimpleResult sr = null;
		String result = null;
		try {
			if (validates(validator, caseupRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, caseupRecordRequest));
			}
			result = caseupRecordService.insertCaseup(caseupRecordRequest);
		} catch (Exception e) {
		}
		sr = SimpleResult.success();
		;
		return sr;
	}
}
