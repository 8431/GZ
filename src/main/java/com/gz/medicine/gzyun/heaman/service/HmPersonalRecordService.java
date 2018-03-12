package com.gz.medicine.gzyun.heaman.service;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.user.bean.Usr;

@Service("hmPersonalRecord")
public interface HmPersonalRecordService {

	 /**
     * 个人信息查询
     * @param guid
     * @return
     * @throws CommonException
     */
    String selectByRecord(String guid) throws CommonException;
}
