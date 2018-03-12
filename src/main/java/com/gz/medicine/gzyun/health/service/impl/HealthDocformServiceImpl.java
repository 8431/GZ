package com.gz.medicine.gzyun.health.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.mapper.HealthDoctorFormMapper;
import com.gz.medicine.gzyun.health.mapper.HealthPushMessageMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.reponse.HealthDocformResponse;
import com.gz.medicine.gzyun.health.request.HealthyDocformRequest;
import com.gz.medicine.gzyun.health.service.HealthDocformService;


/**
 *排班查询
 *jin
 **/
@Service
public class HealthDocformServiceImpl implements HealthDocformService{


    public static final Logger LOGGER = Logger.getLogger(HealthDocformServiceImpl.class);
    
    @Autowired
    private HealthDoctorFormMapper formmapper;
    @Autowired
    private HealthPushMessageMapper pushmes;
	


	@Override
	public List<HealthDocformResponse> queryItemDocId(HealthyDocformRequest data) throws CommonException {
		List<HealthDocformResponse> list = new ArrayList<HealthDocformResponse>();
		List<HealthDoctorForm> doclist = new ArrayList<HealthDoctorForm>();
		try {
			doclist = formmapper.queryItemDocId(data);
			if(doclist != null && doclist.size()>0){
				//得到本月所以排班日期
				List<String> formdateList = new ArrayList<String>();
				for(HealthDoctorForm healthyDoctorform:doclist){
					if(!formdateList.contains(healthyDoctorform.getFormdate())){
						formdateList.add(healthyDoctorform.getFormdate());
					}
				}
				//
				for(String formdate : formdateList){
					List<HealthDoctorForm> docFormList = new ArrayList<HealthDoctorForm>();
					for(HealthDoctorForm healthyDoctorform:doclist){
						if(formdate.equals(healthyDoctorform.getFormdate())){
							docFormList.add(healthyDoctorform);
						}
					}
					HealthDocformResponse healthDocformResponse = new HealthDocformResponse();
					healthDocformResponse.setFormdate(formdate);
					healthDocformResponse.setDoctorformlist(docFormList);
					list.add(healthDocformResponse);
				}
			}
	
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("001", "HealthDocformServiceImpl出现错误！！！", e);
		}
		return list;
	}
	/**
	 * 修改排版状态为停诊
	 * 
	 * **/

		@Override
		public String update(HealthyDocformRequest data) throws CommonException {
			// TODO Auto-generated method stub	
			HealthPushMessage mess = new HealthPushMessage();
			try {	
				//查询是否存在此数据
				HealthDoctorForm form = formmapper.querydataId(data.getId());
				if(form!=null){
					Date sysdat = new Date();
					String dat = form.getStarttime();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date d = sd.parse(dat);
					long time1 = d.getTime();
					long time2 = sysdat.getTime();
					long dif = time1-time2;
					//判断排班开始时间大于(当前时间+24小时)
						if(dif / (60 * 60 * 1000)>=24){
							int a = formmapper.queryStateId(data);
							if(a<2){
								int b=1-a;
								mess.setUserid(data.getDocid());
								mess.setPushmessage("您的停诊次数还剩"+b+"次，请合理安排。");
								//dlf by 2017/11/28
								mess.setId(UUIDTool.getUUID());
								mess.setMessagetype("1");
								mess.setMessagename("系统消息");
								pushmes.insertSelective(mess);

								formmapper.updatebyid(data.getId());

							}else{
								return "每月停诊次数不得超过两次！";
							}
						}else{
							return "停诊需提前24小时！";						
						}				
				}else{				
					return "抱歉，无可操作数据！";			
				}
		
			} catch (Exception e) {
				throw new CommonException("COM001","在排班状态修改方法中出错",e);
			}
			
			
			return "success";
		}
		
	
	 //排班预约管理查询所有医生当天排班
@Override
public SimpleResult querybyDdoc(PageModel page) throws CommonException {
	// TODO Auto-generated method stub
	SimpleResult sr=null;
	 List<Map<String,Object>> lists= null;
	try {
		 Page p=page.getPage();
		 lists = formmapper.querybyDdoc(p);
		 p.setParameterType(lists);
         sr=SimpleResult.success();
         sr.put("data",p);
	} catch (Exception e) {
		throw new CommonException("COM001","在预约管理查询所有医生方法中出错",e);
	}
	return sr;
}


//排班预约管理查询单个医生当天排班
@Override
public SimpleResult querybyDdocOne(PageModel page) throws CommonException {
	// TODO Auto-generated method stub
	SimpleResult sr=null;
	 List<Map<String,Object>> lists= null;
	try {
		Page p=page.getPage();
		lists = formmapper.querybyDdocOne(p);
		 p.setParameterType(lists);
         sr=SimpleResult.success();
         sr.put("data",p);
	} catch (Exception e) {
		throw new CommonException("COM001","在预约管理查询单个医生当天排班方法中出错",e);
	}
	return sr;
}
/**
 * 查询修改状态个数  金
 * **/
@Override
public int queryStateId(HealthyDocformRequest data) throws CommonException {
	// TODO Auto-generated method stub
	int a =0;
	try {
		a = formmapper.queryStateId(data);
	} catch (Exception e) {
		throw new CommonException("COM001","在查询修改状态个数时出错",e);
	}
	return a;
}
	
	
}
	
