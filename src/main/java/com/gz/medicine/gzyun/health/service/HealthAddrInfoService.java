package com.gz.medicine.gzyun.health.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthAddrInfo;


/**
 * 收货地址
 * jin
 * **/


@Service("InfoService")
public interface HealthAddrInfoService {
	
    //新增
	int insertSelective(HealthAddrInfo record) throws CommonException; 
	
	//修改收货地址
	 int updatebyid(HealthAddrInfo record) throws CommonException;
	 
	//删除
	 int deletebuid(HealthAddrInfo record) throws CommonException;
    
	 //查询
	 List<HealthAddrInfo> selectbyuid(HealthAddrInfo record) throws CommonException;
}
