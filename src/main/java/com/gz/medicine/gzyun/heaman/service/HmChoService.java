package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.reponse.HmChoReponse;
import com.gz.medicine.gzyun.heaman.request.HmChoRequest;
/**
 * 胆固醇
 * jin
 * **/
@Service("choService")
public interface HmChoService {
	
	
   
    int insert(HmChoRequest data) throws CommonException;
	List<HmChoReponse> queryCho(HmChoRequest data) throws CommonException;
}
