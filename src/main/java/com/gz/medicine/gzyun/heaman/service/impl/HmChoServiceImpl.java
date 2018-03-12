package com.gz.medicine.gzyun.heaman.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmChoRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmChoRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmChoReponse;
import com.gz.medicine.gzyun.heaman.request.HmChoRequest;
import com.gz.medicine.gzyun.heaman.service.HmChoService;


/**
 * 胆固醇
 * jin
 * **/

@Service
public class HmChoServiceImpl implements HmChoService {
    
    @Autowired
   private HmChoRecordMapper choMapper;

    /**
     * 胆固醇查询
     */

	@Override
	public List<HmChoReponse> queryCho(HmChoRequest data) throws CommonException {
		List<HmChoReponse> choRepList = new ArrayList<HmChoReponse>();
		try {
			List<HmChoRecord> choList = choMapper.queryCho(data);
			if(choList!=null&&choList.size()>0){
				for(HmChoRecord cho : choList){
					HmChoReponse choRep = new HmChoReponse();
					BeanUtils.copyProperties(cho,choRep);
					Double totcholeDouble = Double.valueOf(cho.getTotchole());
					//stat=1指不正常，=0正常
					if( totcholeDouble < 2.1 || totcholeDouble > 5.2 ){
						choRep.setStat(1);
					}else{
						choRep.setStat(0);
					}
					choRepList.add(choRep);
				}
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return choRepList;
	}


    /**
     * 胆固醇写入
     */
	public int insert(HmChoRequest data) throws CommonException {
		HmChoRecord chorecord = new HmChoRecord();
		try {
			BeanUtils.copyProperties(data, chorecord);
			choMapper.insert(chorecord);
//			heamanSqueReponse raps=new heamanSqueReponse()
//			BeanUtils.copyProperties(sque,raps);

			
			return 0;
		} catch (Exception e) {
			throw new CommonException("COM001","在添加方法中，出现异常",e);
		}
	
	}


	
}
