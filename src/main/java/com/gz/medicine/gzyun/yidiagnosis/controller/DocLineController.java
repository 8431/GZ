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
import com.gz.medicine.gzyun.heaman.controller.HmCaseupRecordController;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.yidiagnosis.reponse.DocLineReponse;
import com.gz.medicine.gzyun.yidiagnosis.service.DocLineService;

@Controller
@RequestMapping("/EnviveDOC")
public class DocLineController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordController.class);

	@Autowired
	private DocLineService dOCLINEService;
	@Autowired
	Validator validator;

	/**
	 * 推送医生在岗信息
	 * 
	 * @param hmYxDoc
	 * @return
	 */
	@RequestMapping(value = "/InterfaceDOCLINE", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult InterfaceDOCLINE(@Valid DocLineReponse docLineReponse) {
		SimpleResult sr = null;
		String gpRecode = null;
		// DocLineReponse docLineReponse=null;
		try {
			if (validates(validator, docLineReponse) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, docLineReponse));
			}
			gpRecode = dOCLINEService.selectByDOCLINE(docLineReponse);
		} catch (Exception e) {
			LOGGER.error(e);
		}

		sr = SimpleResult.success();
		sr.putData("gpRecode", gpRecode);
		return sr;

	}
}
