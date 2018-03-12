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

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.heaman.bean.HmPhyRecord;
import com.gz.medicine.gzyun.heaman.request.HmPhyRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmPhyRecordService;

@Controller
@RequestMapping("/GZJKinterface03")
public class HmPhyRecordController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordController.class);

	@Autowired
	private HmPhyRecordService hmPhyRecordService;
	@Autowired
	Validator validator;

	/**
	 * 体检报告查询接口（查询）
	 * 
	 * @param hmPhyRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetGZJKphyRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetGZJKphyRecord(@Valid HmPhyRecordRequest hmPhyRecordRequest) {
		SimpleResult sr = null;
		List<HmPhyRecord> gpRecode = null;
		try {
			if (validates(validator, hmPhyRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hmPhyRecordRequest));
			}
			gpRecode = hmPhyRecordService.selectByPhyRecord(hmPhyRecordRequest.getUsrguid());
			System.out.println(gpRecode.size());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}

	/**
	 * 体检报告解读列表接口 （查询）
	 * 
	 * @param hmPhyRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetTJInterpretationList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetTJInterpretationList(@Valid HmPhyRecordRequest hmPhyRecordRequest) {
		SimpleResult sr = null;
		List<HmPhyRecord> gpRecode = null;
		try {
			if (validates(validator, hmPhyRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hmPhyRecordRequest));
			}
			gpRecode = hmPhyRecordService.selectByTJInterpretation(hmPhyRecordRequest.getUsrguid());
		} catch (CommonException e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}

	/**
	 * 体检报告解读详情接口（查询）
	 * 
	 * @param hmPhyRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/GetTJInterpretationDetails", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetTJInterpretationDetails(@Valid HmPhyRecordRequest hmPhyRecordRequest) {
		SimpleResult sr = null;
		List<HmPhyRecord> gpRecode = null;
		try {
			if (validates(validator, hmPhyRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hmPhyRecordRequest));
			}
			gpRecode = hmPhyRecordService.selectByDetails(hmPhyRecordRequest.getGuid());
			System.out.println(gpRecode.size());
		} catch (CommonException e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}

	/**
	 * 体检报告写入接口（写入）
	 * 
	 * @param hmPhyRecordRequest
	 * @return
	 */
	@RequestMapping(value = "/WriteGZJKphyRecord ", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult WriteGZJKphyRecord(@Valid HmPhyRecordRequest hmPhyRecordRequest) {
		SimpleResult sr = null;
		String result = null;
		try {
			if (validates(validator, hmPhyRecordRequest) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hmPhyRecordRequest));
			}
			result = hmPhyRecordService.insertPhyRecord(hmPhyRecordRequest);
		} catch (CommonException e) {
		}
		sr = SimpleResult.success();
		;
		return sr;
	}
}
