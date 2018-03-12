package com.gz.medicine.gzyun.yidiagnosis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.service.impl.HmCaseupRecordServiceImpl;
import com.gz.medicine.gzyun.yidiagnosis.bean.YGyxDoc;
import com.gz.medicine.gzyun.yidiagnosis.mapper.YGyxDocMapper;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGyxDocReponse;
import com.gz.medicine.gzyun.yidiagnosis.service.YGyxDocService;

@Service
public class YGyxDocServiceImpl implements YGyxDocService{

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordServiceImpl.class);

	@Autowired
	private YGyxDocMapper  hmYxDocMapper;
	
	
	@Override
	public YGyxDocReponse selectByDOC(String guid) throws CommonException {
		// TODO Auto-generated method stub
		List<YGyxDoc> hmYxDocList = new ArrayList<YGyxDoc>();
		YGyxDocReponse reponse=new YGyxDocReponse();
	
		try {
			
			// 插入系統當前時間时间戳
			long ReportTime = new Date().getTime();
	
			hmYxDocList = hmYxDocMapper.selectByDOC(guid);
			BeanUtils.copyProperties(hmYxDocList.get(0),reponse);

			reponse.setPartner("fromfuture");
			reponse.setGuid("203E4B220949F456E050AE0AC684E410");
			reponse.setId("1020");
			reponse.setName(reponse.getName());
			reponse.setHospitalId("1231010442503162XW");
			reponse.setHospital(reponse.getHospital());
			reponse.setJobtitle("1");
			reponse.setJobtitleNam("");
			reponse.setSex("1");
			reponse.setEmaill("");
			reponse.setTelephone("");
			reponse.setDepartment("10000078");
			reponse.setDeptnam(reponse.getDeptnam());
			reponse.setBegoodat(reponse.getBegoodat());
			reponse.setUsrstat("1");
			reponse.setType("2");
			reponse.setType2("2");
			reponse.setIsty("");
			reponse.setDepartment2("");
			reponse.setDeptnam2("");
			reponse.setCrtdat("2015-09-21");
			reponse.setUpdtdat("2017-03-01");
			reponse.setTime(ReportTime);
			//
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return reponse;
	}
		
}

