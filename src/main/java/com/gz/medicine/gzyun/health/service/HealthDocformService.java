package com.gz.medicine.gzyun.health.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.reponse.HealthDocformResponse;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;


/**
 * 排班查询
 * jin
 * **/


@Service("docfService")
public interface HealthDocformService {
	
	//查询排版
	List<HealthDocformResponse> queryItemDocId(HealthyDocformRequest data) throws CommonException;
    
   //修改排版状态为停诊
	 String update(HealthyDocformRequest data) throws CommonException;
	 
   //排班预约管理查询所有医生当天排班
	 SimpleResult querybyDdoc(PageModel page) throws CommonException;
	 
   //排班预约管理查询单个医生当天排班
	 SimpleResult querybyDdocOne(PageModel page) throws CommonException;

	 //查询停诊状态个数
	 int queryStateId(HealthyDocformRequest data) throws CommonException;

}
