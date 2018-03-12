package com.gz.medicine.gzyun.yidiagnosis.controller;

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
import com.gz.medicine.gzyun.yidiagnosis.bean.YGyxDoc;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGyxDocReponse;
import com.gz.medicine.gzyun.yidiagnosis.service.YGyxDocService;


@Controller
@RequestMapping("/EnviveDOC")
public class HmYxDocController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmYxDocController.class);

	@Autowired
	private YGyxDocService hmYxDocService;
	@Autowired
	Validator validator;

	/**
	 * 推送医生信息
	 * 
	 * @param hmYxDoc
	 * @return
	 */
	@RequestMapping(value = "/InterfaceDOC", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult InterfaceDOC(@Valid YGyxDoc hmYxDoc) {
		SimpleResult sr = null;
		YGyxDocReponse gpRecode = null;
		try {
			if (validates(validator, hmYxDoc) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hmYxDoc));
			}
			gpRecode = hmYxDocService.selectByDOC(hmYxDoc.getGuid());
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}
}
