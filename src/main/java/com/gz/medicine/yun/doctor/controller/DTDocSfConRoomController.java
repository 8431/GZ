package com.gz.medicine.yun.doctor.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.reponse.DTmessageRoom;
import com.gz.medicine.yun.doctor.reponse.DTusrReponse;
import com.gz.medicine.yun.doctor.request.DTfollowupPlanRequest;
import com.gz.medicine.yun.doctor.request.DTfollowupRecordRequest;
import com.gz.medicine.yun.doctor.request.DTmessageRequest;
import com.gz.medicine.yun.doctor.service.DTDocSfConRoomService;
import com.gz.medicine.yun.doctor.service.DTDoctorSfhzglService;
import com.gz.medicine.yun.doctor.service.DTUsrService;

/**
 * 随访9大接口
 * @author 舵主
 *
 */
@Controller
@RequestMapping("dtdocsfconroom")
public class DTDocSfConRoomController extends ValidateWithException {

	 public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryController.class);	
	
	/**
	 * 随访计划查询
	 */
	@Autowired
	private DTDocSfConRoomService dTDocSfConRoomService;
	
	/**
	 * 用户查询
	 */
	@Autowired
	private DTUsrService dTUsrService;
	
	/**
	 * 随访诊室结束随访
	 */
	@Autowired
	private DTDoctorSfhzglService dTDoctorSfhzglService;  
	
	/**
	 * 校验
	 */
	@Autowired
    Validator validator;

	/**
	 *
	 *@Title GetSleepFollowUp
	 *@Description: 云随访诊室进入随访成员接口  ---- 根据医生ID和今天的时间去随访表查询今天的记录
	 *@Author fendo
	 *@Date 2017年8月21日 上午10:52
	 *@param docguid 医生ID
	 *@return SimpleResult
	 *@throws
	 *@测试: localhost:8996/GZ/dtdocsfconroom/getsleepfollowup
	 */
	@RequestMapping(value = "/getsleepfollowup", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetSleepFollowUp(String docguid){
		SimpleResult simpleResult=null;
		SimpleResult sr = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> docMap = new HashMap<String, String>();
		docMap.put("guid","1111111111");
		docMap.put("name", "馬小苏");
		docMap.put("sex", "男");
		docMap.put("age", "43");
		docMap.put("FOLLOWSTATE","0");
		List<Map<String, String>> docList = new ArrayList<Map<String, String>>();
		docList.add(docMap);
		map.put("parameterType", docList);
		map.put("pageNo", 1);
		map.put("totalPage", 1);
		map.put("pageSize", 15);
		map.put("totalRecord", 1);
		simpleResult=SimpleResult.success();
		simpleResult.putDataAll(map);
		return simpleResult;
	}


	/**
	 *@Title setFollowUpEnd
	 *@Description: 云随访诊室结束随访接口---- 根据患者GUID
	 *@Author 舵主
	 *@Date 2017年8月21日 上午10:52
	 *@return SimpleResult
	 *@throws
	 *@测试: localhost:8996/GZ/dtdocsfconroom/setfollowupend
	 */
	@RequestMapping(value = "/setfollowupend", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult setFollowUpEnd(@Valid DTfollowupPlanRequest data){
		SimpleResult simpleResult = null;
		try {
			dTDoctorSfhzglService.setFollowUpEnd(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
		}
		simpleResult=SimpleResult.success();
		return simpleResult;
	}


	/**
	 *
	 *@Title getfollowuplist
	 *@Description: 随访信息"获取数据"接口 ---- 根据患者id获取随访信息
	 *@Author fendo
	 *@Date 2017年8月21日 上午10:52
	 *@param guid  患者ID
	 *@return SimpleResult
	 *@throws
	 *@测试:  localhost:8996/GZ/dtdocsfconroom/getfollowuplist
	 */
	@RequestMapping(value = "/getfollowuplist", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
 	public SimpleResult GetFollowUpList(String guid) throws CommonException {
//		SimpleResult simpleResult=null;
//
//		//deptIdNum：机构码
//		String deptIdNum="52750B1FF4F4D368E053AA0012AC681E";
//		guid="591D597C76C917F3E050007F01005E79";
//		simpleResult=dTDocSfConRoomService.getData(deptIdNum,guid);
//		simpleResult=SimpleResult.success();
//		return simpleResult;

		SimpleResult simpleResult=null;
		Map<String, String> docMap = new HashMap<String, String>();
		docMap.put("TEMPERATURE","0");  //体温
		docMap.put("HEARTRATE", "0"); //心率
		docMap.put("BLOODPRESSUREH", "0"); //血压 上
		docMap.put("BLOODPRESSUREL","0");//血压 下
		docMap.put("WEIGHT", "0"); //体重
		docMap.put("FOLLOWSTATE","0"); //血糖
		docMap.put("BLOODOXYGEN","0");//血氧
		simpleResult=SimpleResult.success();
		simpleResult.put("data",docMap);
		return simpleResult;

	}

	/**
	 *
	 *@Title AddCaseHistory
	 *@Description: 随访信息保存 ()
	 *@Author fendo
	 *@Date 2017年8月21日 上午10:52
	 *@param data
	 *@return SimpleResult
	 *@throws
	 *@测试:  localhost:8996/GZ/dtdocsfconroom/addfollowup
	 */
	@RequestMapping(value = "/addfollowup", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult addFollowUp(DTfollowupRecordRequest data){

		SimpleResult simpleResult=null;

		try {
			if(validates(validator, data)!=null){
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data));
			}
			dTDocSfConRoomService.saveFollowUp(data);
		} catch (CommonException e) {
			LOGGER.error(e);
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
		}
		simpleResult=SimpleResult.success();
		return simpleResult;
	}

	/**
	 *
	 *@Title getFollowUpList
	 *@Description: 随访信息就诊记录列表 ---- 根据患者ID,医生ID,获取就诊记录列表(查病历表)
	 *@Author fendo
	 *@Date 2017年8月21日 上午10:52
	 *@param page
	 *@return SimpleResult
	 *@throws
	 *@测试:  
	 */
	@RequestMapping(value = "/getmedicalrecordslist", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult getMedicalRecordsList(PageModel page){
		SimpleResult simpleResult=null;
		Page pages=null;
		if(StringUtils.isNotEmpty((String) page.getPage().get("usrguid"))&& StringUtils.isNotEmpty((String)page.getPage().get("docguid"))){
			try {
				pages=dTDocSfConRoomService.getMedicalRecordsList(page);
			} catch (CommonException e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
			}
		}else {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入usrguid,docguid!!!");
		}
		simpleResult=SimpleResult.success();
		simpleResult.put("data",pages);
		return  simpleResult;
	}
	
	
	
	/**
	 *
	 *@Title AddCaseHistory
	 *@Description: 随访任务列表（搜索、分页）  云随访诊室进入随访成员接口 
	 *@Author 舵主
	 *@Date 2017年8月21日 上午10:52
	 *@return SimpleResult
	 *@throws
	 *@测试:
	 */
	@RequestMapping(value = "/follUpTasks", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult follUpTasks(PageModel page){
		SimpleResult simpleResult = null;
		Page pages=null;
		// 判断docguid是否为空
		if(StringUtils.isNoneEmpty((String) page.getPage().get("docguid"))){
			try {
				pages=dTDocSfConRoomService.follUpTasks(page);
			} catch (CommonException e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
			}
		}else{
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入docguid!!!");
		}
		simpleResult=SimpleResult.success();
		simpleResult.put("data",pages);
		return  simpleResult;
	}

	
	/**
	 *
	 *@Title AddCaseHistory
	 *@Description: 随访任务发送短信（新增短信记录）
	 *@Author 舵主
	 *@Date 2017年8月21日 上午10:52
	 *@return SimpleResult
	 *@throws
	 *@测试:
	 */
	@RequestMapping(value = "/addSMSreTasks", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult addSMSreTasks(DTmessageRequest record){
		SimpleResult simpleResult=null;
		try{
			// 判断是否为空
		  if(validates(validator, record)!=null){
	        return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record)); 
	      }
		   simpleResult =  dTDocSfConRoomService.addSMSreTasks(record);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
		simpleResult=SimpleResult.success();
		return simpleResult;
	}
	
	
	/**
	 *
	 *@Title AddCaseHistory
	 *@Description: 随访任务选择模板查询内容接口
	 *@Author 舵主
	 *@Date 2017年8月21日 上午10:52
	 *@return SimpleResult
	 *@throws
	 *@测试:
	 */
	@RequestMapping(value = "/sfSMSdetails", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody 
	public SimpleResult sfSMSdetails(@Valid String  guid){
		SimpleResult simpleResult=null;
		try{
			// 判断是否为空
			  if(validates(validator, guid)!=null){
		        return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, guid)); 
		      }
			  simpleResult =  dTDocSfConRoomService.sfSMSdetails(guid);
    		 return simpleResult;
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
	}
	
	
	
	/**
	 *
	 *@Title AddCaseHistory
	 *@Description: 随访任务加载短信详情
	 *@Author 舵主
	 *@Date 2017年8月21日 上午10:52
	 *@param usrguid
	 *@return SimpleResult
	 *@throws
	 *@测试:
	 */
	@RequestMapping(value = "/loadDetails", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody 
	public SimpleResult loadDetails(String  usrguid,String docguid){
		SimpleResult simpleResult=null;
		DTusr usr=null;
		DTusrReponse dTusrReponse = new DTusrReponse();
		try{
			 List<DTmessageRoom> mrList =new ArrayList<DTmessageRoom>();
			  List<DTmessageTemplate> list = new ArrayList<DTmessageTemplate>();
			  // 判断是否为空
			  if(validates(validator, usrguid)!=null){
		        return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, usrguid)); 
		      }
			  if(validates(validator, docguid)!=null){
				  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, docguid)); 
			  }
			  // 根据usrguid查询患者信息
			  usr= dTUsrService.selGuid(usrguid);
			  dTusrReponse.setId(usr.getId());
			  dTusrReponse.setName(usr.getName());  
			  // 根docguid查询短信模板信息
			  list = dTDocSfConRoomService.loadDetails(docguid);
			  for (DTmessageTemplate dTmessageTemplate : list) {
				  DTmessageRoom dTmessageRoom = new DTmessageRoom();
				  dTmessageRoom.setGuid(dTmessageTemplate.getGuid());
				  dTmessageRoom.setTemplatename(dTmessageTemplate.getTemplatename());
				  dTmessageRoom.setTemplatecontent(dTmessageTemplate.getTemplatecontent());
				  mrList.add(dTmessageRoom);
			  }
			  Map<String, Object> map = new HashMap<String, Object>();
			  map.put("usr", dTusrReponse);
			  map.put("tempList", mrList);
			  simpleResult=SimpleResult.success();
			  simpleResult.putDataAll(map);
			  return simpleResult;
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
	}
	
	
	
	
}
