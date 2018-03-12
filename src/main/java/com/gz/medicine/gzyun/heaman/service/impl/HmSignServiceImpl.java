package com.gz.medicine.gzyun.heaman.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmHeatrecord;
import com.gz.medicine.gzyun.heaman.bean.HmSignRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmHeatrecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmHeatReponse;
import com.gz.medicine.gzyun.heaman.reponse.HmSignReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;

import com.gz.medicine.gzyun.heaman.service.HmSignService;

/**
 * 获取日常体征检测数据
 * jin
 * **/

@Service
public class HmSignServiceImpl implements HmSignService {
    
    @Autowired
   private HmHeatrecordMapper heatMapper;

    /**
     * 查询
     */


	public List<HmSignReponse> selectSign(HmHeatRequest data) throws CommonException {
		List<HmSignReponse> signRepList = new ArrayList<HmSignReponse>();
		try {
			List<HmSignRecord> signList = heatMapper.selectSign(data);
			if(signList!=null&&signList.size()>0){
				for(HmSignRecord sign : signList){
					HmSignReponse signRep = new HmSignReponse();
					BeanUtils.copyProperties(sign,signRep);
					
					signRepList.add(signRep);
				}
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return signRepList;
	}
  

	
}
