package com.gz.medicine.gzyun.heaman.service.impl;





import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmQtnRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmQtnRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmSqueReponse;
import com.gz.medicine.gzyun.heaman.request.HmSqueRequest;
import com.gz.medicine.gzyun.heaman.service.HmSqueService;
/**
 * 问卷
 * jin
 * **/

@Service
public class HmSqueServiceImpl implements HmSqueService {
    
    @Autowired
   private HmQtnRecordMapper squeMapper;

    /**
     * 问卷结果写入接口
     */
	public int insertSque(HmSqueRequest data) throws CommonException {
		HmQtnRecord qtn = new HmQtnRecord();
		try {
			BeanUtils.copyProperties(data, qtn);
			squeMapper.insert(data);
			
//			heamanSqueReponse raps=new heamanSqueReponse()
//			BeanUtils.copyProperties(sque,raps);

			
			return 0;
		} catch (Exception s) {
			throw new CommonException("COM001","在添加方法中，出现异常",s);
		}
	
	}
	
}
