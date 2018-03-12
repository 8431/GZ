package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;


import com.gz.medicine.gzyun.heaman.reponse.HmSignReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;
/**
 * 获取日常体征检测数据
 * jin
 * **/

@Service("signService")
public interface HmSignService {
	
	
    public List<HmSignReponse> selectSign(HmHeatRequest data) throws CommonException;
   
}
