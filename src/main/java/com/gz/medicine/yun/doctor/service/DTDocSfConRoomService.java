package com.gz.medicine.yun.doctor.service;

import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.yun.doctor.request.DTfollowupRecordRequest;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTfollowupRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.request.DTfollowupPlanRequest;
import com.gz.medicine.yun.doctor.request.DTmessageRequest;

/**
 * @author 舵主
 *
 * 下午2:01:28
 */
@Service("DTDocSfConRoomService")
public interface DTDocSfConRoomService {

	/** 
	 * 随访任务列表（搜索、分页）
	 * @author 舵主
	 * 下午2:12:45
	 */
	List<DTfollowupRecord> follUpTasks(String docguid) throws CommonException;

	/**
	 * 随访任务选择模板查询内容接口
	 * @author 舵主
	 * 下午6:13:28
	 */
	 SimpleResult sfSMSdetails(String templatename) throws CommonException;


	 
	/**
	 * 随访任务发送短信
	 * @author 舵主
	 * 下午4:00:48
	 */
	 SimpleResult addSMSreTasks (DTmessageRequest record) throws CommonException;

	 
	 /**
	  * 根据医生usrguid随访任务加载短信详情
	  * @author 舵主
	  * 上午10:23:43
	  */
   	 List<DTmessageTemplate> loadDetails(String docguid) throws CommonException;

   	 
  
	
	

	/**
	 *
	 *@Title getMedicalRecordsList
	 *@Description: 随访信息就诊记录列表 ---- 根据患者ID获取就诊记录列表
	 *@Author fendo
	 *@Date 2017年8月24日 上午10:52
	 *@param page
	 *@return Page
	 */
	Page getMedicalRecordsList(PageModel page) throws CommonException;


	/**
	 *
	 *@Title saveFollowUp
	 *@Description: 随访信息保存
	 *@Author fendo
	 *@Date 2017年8月24日 上午10:52
	 *@param data
	 *@return int
	 */
	void saveFollowUp(DTfollowupRecordRequest data)throws CommonException;

	
	/**
	 * 随访任务列表（搜索、分页）service层
	 * @author 舵主
	 *
	 * 下午5:45:48
	 */
	Page follUpTasks(PageModel page) throws CommonException;

	/**
	 * 以下是获取数据
	 * @param deptIdNum
	 * @param guid
	 * @return
	 * @Describe 1.首先获取机构选择的设备 2.然后用病人账号直接去获取数据
	 * @throws CommonException
	 */
	SimpleResult getData(String deptIdNum, String guid)throws CommonException;


	String GetCloudValue4(String deptid, String brguid)throws CommonException;


	/**
	 * 获取部门ID
	 * @param deptIdNum
	 * @return
	 * @throws CommonException
	 */
	String equipmentNo(String deptIdNum) throws CommonException;

	/**
	 * 查体台数据接口
	 * @param CardNo
	 * @return
	 * @throws CommonException
	 */
	String GetCloudValue3(String CardNo) throws CommonException;

	/**
	 * 佚龙心律血压，以电话号码作为账号，无需密码
	 * @param brguid
	 * @return
	 * @throws CommonException
	 */
	String getCloudValueOneThere(String brguid) throws CommonException;

	/**
	 *  佚龙心律血压,使用机构码作为账号，需要密码（默认为123456）
	 * @param deptIdNum
	 * @return
	 * @throws CommonException
	 */
	String getCloudValueOneTwo(String deptIdNum)throws CommonException;


	/**
	 * 根据患者ID获取超思大型设备数据
	 * @param guid
	 * @return
	 * @throws CommonException
	 */
	Map getdaCloudValue(String guid)throws CommonException;
}
