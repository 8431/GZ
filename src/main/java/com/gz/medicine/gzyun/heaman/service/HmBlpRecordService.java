package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmBlpRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmBlpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmBlpRecordRequest;

/**
 * 血压service层
 * 
 * 舵主
 * @author Administrator
 *
 */
@Service("hmBlpRecordService")
public interface HmBlpRecordService {
	
	// 加入新数据
    public String addBlp(HmBlpRecordRequest data) throws CommonException;
    // 查询单个数据
    public List<HmBlpRecordReponse> selBlp(String usrguid) throws CommonException; 
}
