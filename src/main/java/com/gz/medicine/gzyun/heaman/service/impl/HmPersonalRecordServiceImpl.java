package com.gz.medicine.gzyun.heaman.service.impl;

import com.gz.medicine.gzyun.user.mapper.UsrMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.service.HmPersonalRecordService;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.user.reponse.UserReponse;

@Service
public class HmPersonalRecordServiceImpl implements HmPersonalRecordService {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordServiceImpl.class);

	@Autowired
	private UsrMapper usrMapper;

	@Override
	public String selectByRecord(String guid) throws CommonException {
		// TODO Auto-generated method stub
		Usr usr;
		UserReponse reponse = new UserReponse();

		try {
			usr = usrMapper.selectByRecord(guid);
			BeanUtils.copyProperties(usr, reponse);
			if (usr != null) {
				String name = reponse.getName();
				String Idcard = reponse.getIdcard();
				if (name != "" && Idcard != "") {
					return "{\"encode\":\"1000\"}"; // 个人信息已完善
				} else {
					return "{\"encode\":\"10001\"}"; // 未完善个人信息
				}

			} else {
				return "{\"encode\":\"10002\"}"; // 用户不存在
			}

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage(), e);
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);

		}

	}

}
