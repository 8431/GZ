package com.gz.medicine.gzyun.heaman.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;

import com.gz.medicine.gzyun.heaman.reponse.HmHeatReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;
/**
 * 体温
 * jin
 * **/

@Service("heatService")
public interface HmHeatService {
	
	
    public List<HmHeatReponse> queryHeat(HmHeatRequest data) throws CommonException;
    public int insertHeat(HmHeatRequest data) throws CommonException;
}
