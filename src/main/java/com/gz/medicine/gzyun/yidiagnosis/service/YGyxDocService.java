package com.gz.medicine.gzyun.yidiagnosis.service;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGyxDocReponse;


@Service("hmYxDocService")
public interface YGyxDocService {
	/**
	 * 推送医生信息
	 * 
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	public YGyxDocReponse selectByDOC(String guid) throws CommonException;
}
