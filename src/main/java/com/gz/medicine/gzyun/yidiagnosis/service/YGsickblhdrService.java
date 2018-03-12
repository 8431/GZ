package com.gz.medicine.gzyun.yidiagnosis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickbldtl;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGsickblhdrReponse;

@Service("yGsickblhdrService")
public interface YGsickblhdrService {
	/**
	 * 推送病人病史
	 * @param sickguid
	 * @retur6
	 * @throws CommonException
	 */
	YGsickblhdrReponse selectBySickguidKey(String sickguid) throws CommonException;
	/**
	 * 推送病人病史   药品
	 * @param formguid
	 * @return
	 * @throws CommonException
	 */
	List<YGsickbldtl> selectBySickbldtlKey(String formguid) throws CommonException;
	
	
	
	
//	public String insertBlguid(YGchisJwslog record) throws CommonException;

}
