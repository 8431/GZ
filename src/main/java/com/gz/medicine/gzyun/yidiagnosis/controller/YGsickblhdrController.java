package com.gz.medicine.gzyun.yidiagnosis.controller;


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
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGsickblhdrReponse;
import com.gz.medicine.gzyun.yidiagnosis.request.GsickblhdrRequest;
import com.gz.medicine.gzyun.yidiagnosis.service.YGsickblhdrService;
@Controller
@RequestMapping("/EnviveDOC")
public class YGsickblhdrController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmYxDocController.class);

	@Autowired
	private YGsickblhdrService ygsickblhdrService;
	@Autowired
	Validator validator;

	/**
	 * 推送病人病史
	 * 
	 * @param hmYxDoc
	 * @return
	 */
	@RequestMapping(value = "/InterfaceUSR", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult InterfaceUSR(@Valid GsickblhdrRequest request) {
		SimpleResult sr = null;
		YGsickblhdrReponse gpRecode = null;
		try {
			if (validates(validator, request) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, request));
			}
			gpRecode = ygsickblhdrService.selectBySickguidKey(request.getSickguid());

		} catch (CommonException e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();

		sr.putData("data", gpRecode);
		return sr;

	}

	// @RequestMapping(value = "/InterfaceUSRs", method = RequestMethod.GET,
	// produces = "text/html;charset=UTF-8")
	// @ResponseBody
	// public SimpleResult InterfaceUSRs(@Valid GsickblhdrRequest request) {
	// SimpleResult sr = null;
	// List<YGsickbldtl> gpRecode = null;
	// try {
	// if (validates(validator, request) != null) {
	// return SimpleResult.error(SimpleCode.ERROR.getCode(),
	// validates(validator, request));
	// }
	// gpRecode =
	// ygsickblhdrService.selectBySickbldtlKey(request.getFormguid());
	// } catch (CommonException e) {
	// LOGGER.error(e);
	// }
	//
	// sr = SimpleResult.success();
	// sr.putData("gpRecode", gpRecode);
	// return sr;
	//
	// }
}
