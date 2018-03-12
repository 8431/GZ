package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.reponse.HmPermsgReponse;
import com.gz.medicine.gzyun.heaman.request.HmPermsgRequest;


/**
 * 健康指数
 * jin
 * **/

@Service("perService")
public interface HmPermsgService {
	
	
    public HmPermsgReponse select(HmPermsgRequest data) throws CommonException;
   
}
