package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.reponse.HmBloReponse;
import com.gz.medicine.gzyun.heaman.request.HmBloRequest;

/**
 * 血糖
 * jin
 * **/


@Service("bloService")
public interface HmBloService {
	
	
    public List<HmBloReponse> queryBlo(HmBloRequest data) throws CommonException;
    public int insertBlo(HmBloRequest data) throws CommonException;
}
