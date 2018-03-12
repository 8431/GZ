package com.gz.medicine.gzyun.heaman.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.request.HmSqueRequest;
/**
 * 问卷写入
 * jin
 * **/
@Service("squeService")
public interface HmSqueService {
	
	
    public int insertSque(HmSqueRequest data) throws CommonException;
    
}
