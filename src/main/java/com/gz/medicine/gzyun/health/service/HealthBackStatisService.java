package com.gz.medicine.gzyun.health.service;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.reponse.HealthDocterForm;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorformIdReponse;
import com.gz.medicine.gzyun.health.reponse.HealthItemByIdSelReponse;
import com.gz.medicine.gzyun.health.request.HealthDoctorformAllRequest;
import com.gz.medicine.gzyun.health.request.HealthDoctorformIdRequest;
import com.gz.medicine.gzyun.health.request.HealthOrderMakeUpdateRequest;
import com.gz.medicine.gzyun.health.request.HealthOrderStatisRequest;
import com.gz.medicine.gzyun.health.request.HealthyDoctorformrequest;

/**
 * 后台管理service层
 * @author 舵主
 *
 */
public interface HealthBackStatisService {
	/**
	 * 排班管理
	 * @author 舵主
	 *
	 * 下午5:22:32
	 */
	 List<HealthDocterForm> queryListByMapHealthyDoctorform(HealthyDoctorformrequest data )throws CommonException;
	
	 
	 /**
	  * 预约统计接口（订单总数）
	  * @author 舵主
	  *
	  * 下午1:53:06
	  */
	 List<Map<String,Object>> queryListByOrderNum(HealthOrderStatisRequest data) throws CommonException;
	 
	 /**
	  * 累计问诊量(已咨询的咨询信息)
	  * @author 舵主
	  *
	  * 下午3:07:50
	  */
	 List<Map<String,Object>> queryListByInterCum(HealthOrderStatisRequest data) throws CommonException;
	 
	 
	 
	/**
     * 累计评价数
     * @author 舵主
     *
     * 下午3:30:31
     */
	 List<Map<String,Object>> queryListByeValuaCum(HealthOrderStatisRequest data) throws CommonException;
	 
	 /**
	  * 查所有医生
	  * @author 舵主
	  *
	  * 下午4:09:38
	  */
	 List<Map<String,Object>> queryListDoctorName() throws CommonException;
	 
	 
	/**
     * 医生搜索排班接口
     * 舵主
     */
	List<HealthDoctorformIdReponse> queryDoctorformseach(HealthDoctorformIdRequest data)throws CommonException;
	
	
	/**
	 * 新增排班信息
	 * @author 舵主
	 *
	 * 下午5:08:32
	 */
	String createItemDoctorform(HealthDoctorformAllRequest data) throws CommonException;
	

	/**
	 * 预约管理
	 * @author 舵主
	 *
	 * 下午2:06:08
	 */
	Page queryPageMakeMange(PageModel page) throws CommonException;
	/**
	 * 新建排版
	 * @param re
	 * @return
	 * @throws CommonException
	 */
	Integer addDocForm(List<HealthDoctorformAllRequest> re)throws CommonException;


	
	/**
	 * 预约修改接口
	 * 舵主
	 */
	void updateIdMake(HealthOrderMakeUpdateRequest data) throws CommonException;
	
	
	/**
	 * 查询单个预约信息
	 * @author 舵主
	 *
	 * 下午2:11:04
	 */
	HealthItemByIdSelReponse queryItemByIdSel(String orderid)throws CommonException;
	
	
	
	
	
}
