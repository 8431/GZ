package com.gz.medicine.gzyun.yidiagnosis.service;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.yidiagnosis.reponse.DocLineReponse;

@Service("dOCLINEService")
public interface DocLineService {
	/**
	 * 推送医生在岗信息
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	String selectByDOCLINE(DocLineReponse docLineReponse) throws CommonException;
	
}
