package com.gz.medicine.gzyun.heaman.service.impl;


import java.util.ArrayList;




import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmBlpRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmBlpRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmBlpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmBlpRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmBlpRecordService;

/**
 * 血压接口serviceimp层
 * 
 * 舵主
 * @author Administrator
 *
 */
@Service
public class HmBlpServiceImpl implements HmBlpRecordService {
    
    @Autowired
   private HmBlpRecordMapper hmBlpMapper;

    /**
     * 血压数据新增接口
     */
	@Override
	public String addBlp(HmBlpRecordRequest data) throws CommonException {
		HmBlpRecord bb = new HmBlpRecord();
		try {
			if(data.getUsrguid()!=null||data.getUsrguid()!=""){
				BeanUtils.copyProperties(data,bb);
				hmBlpMapper.insertSelective(bb);
				return "数据插入成功";
			}else{
				throw new CommonException("COM001","未获取到患者guid");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在新增方法中出现异常",e);
		}
	}

	/**
	 * 血压接口查询接口
	 */
	@Override
	public List<HmBlpRecordReponse> selBlp(String usrguid) throws CommonException {
		List<HmBlpRecordReponse> listReponse = new ArrayList<HmBlpRecordReponse>();
		List<HmBlpRecord> listHmBlp = null;
		try {
			if(StringUtils.isNoneBlank(usrguid)){
				listHmBlp = hmBlpMapper.selectByPrimaryKeyAll(usrguid);
				for (HmBlpRecord hmBlpRecord : listHmBlp) {
					HmBlpRecordReponse hmBlp = new HmBlpRecordReponse();
					BeanUtils.copyProperties(hmBlpRecord,hmBlp);
					listReponse.add(hmBlp);
				}
			}else{
				throw new CommonException("COM001","用户usrguid不能为空");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在查询方法中，出现异常",e);
		}
		return listReponse;
	}



  

	
	
	








	

	

	
	
	
	

	
	
	
	
}
