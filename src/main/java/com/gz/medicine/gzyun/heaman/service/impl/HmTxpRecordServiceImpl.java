package com.gz.medicine.gzyun.heaman.service.impl;

import java.util.ArrayList;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmTxpRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmTxpRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmTxpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmTxpRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmTxpRecordService;

/**
 * 尿酸serviceimp层
 * 
 * 舵主
 * @author Administrator
 *
 */
@Service
public class HmTxpRecordServiceImpl implements HmTxpRecordService {
    
    @Autowired
   private HmTxpRecordMapper hmTxpMapper;

    
    /**
     * 尿酸数据插入
     */
    @Override
	public String addTxp(HmTxpRecordRequest data) throws CommonException {
		HmTxpRecord record = new HmTxpRecord();
		try {
			BeanUtils.copyProperties(data, record);
			hmTxpMapper.insertSelective(record);
			return record.getUsrguid();
		} catch (Exception e) {
			throw new CommonException("COM001","在新增方法中，出现异常");
		}
	}

	
	/**
	 * 尿酸数据查询
	 */
	@Override
	public List<HmTxpRecordReponse> selTxp(String usrguid) throws CommonException {
		List<HmTxpRecordReponse> listReponse = new ArrayList<HmTxpRecordReponse>();
		List<HmTxpRecord> list = null;
		try {
			if(StringUtils.isNoneBlank(usrguid)){
				list = hmTxpMapper.selectByPrimaryKeyAll(usrguid);
				for (HmTxpRecord hmTxpRecord : list) {
					HmTxpRecordReponse hmTxpRecordReponse = new HmTxpRecordReponse(); 
					BeanUtils.copyProperties(hmTxpRecord, hmTxpRecordReponse);
					listReponse.add(hmTxpRecordReponse);
				}
			}else{
				throw new CommonException("COM001","未获取到患者guid");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在查询方法中，出现异常",e);
		}
		return listReponse;
	}

	
	
}
