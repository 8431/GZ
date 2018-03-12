package com.gz.medicine.gzyun.heaman.service.impl;

import java.util.ArrayList;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmEcgRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmEcgRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmEcgReponse;
import com.gz.medicine.gzyun.heaman.request.HmEcgRequest;
import com.gz.medicine.gzyun.heaman.service.HmEcgRecordService;

/**
 * 心电接口serviceimp层
 * 舵主
 * @author Administrator
 *
 */
@Service
public class HmEcgRecordServiceImpl implements HmEcgRecordService {
    
    @Autowired
   private HmEcgRecordMapper hmEcgMapper;
    
    

   /**
    * 心电最新测量数据入库
    */
	public String addEcg(HmEcgRequest data) throws CommonException {
		HmEcgRecord hmEcgRecord = new HmEcgRecord();
		try {
			if(data.getUsrguid()!=null){
				BeanUtils.copyProperties(data,hmEcgRecord);
				
				hmEcgMapper.insertSelective(hmEcgRecord);
				return hmEcgRecord.getUsrguid();
			}else{
				throw new CommonException("COM001","未获取到患者guid");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在新增方法中，出现异常",e);
		}
		
	}
	
	
	
	
	/**
	 * 根据单个患者编号查询心电数据
	 * @return
	 * @throws CommonException
	 */
	public List<HmEcgReponse> selEcg(String usrguid) throws CommonException {
		List<HmEcgReponse> listEcg = new ArrayList<HmEcgReponse>();
		List<HmEcgRecord> list =null;
		try {
			if(usrguid!=null){
				list = hmEcgMapper.selectByPrimaryUsrKey(usrguid);
				for (HmEcgRecord hmEcgRecord : list) {
					HmEcgReponse ecg = new HmEcgReponse();
					BeanUtils.copyProperties(hmEcgRecord,ecg);
					listEcg.add(ecg);
				}
			}else{
				throw new CommonException("COM001","未获取到患者guid");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在查询方法中，出现异常",e);
		}
		return listEcg;
	}

	
}
