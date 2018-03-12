package com.gz.medicine.gzyun.health.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.gzyun.health.reponse.HealthDocterForm;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorformIdReponse;
import com.gz.medicine.gzyun.health.reponse.HealthItemByIdSelReponse;
import com.gz.medicine.gzyun.health.request.*;
import com.gz.medicine.gzyun.health.service.HealthBackStatisService;
import com.gz.medicine.gzyun.health.service.HealthMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;


/**
 * 后台管理controller
 * 
 * @author 舵主
 *
 *         上午11:07:28
 */
@Controller
@RequestMapping("/backStatis")
public class HealthBackStatisController extends ValidateWithException{

	 public static final Logger LOGGER = Logger.getLogger(HealthBackStatisController.class);
	@Autowired
	HealthBackStatisService healthBackStatisService;
	
	@Autowired
	HealthMessageService messageService;
	
	@Autowired
	Validator validator; 
	
	/**
	 * 排班管理
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/typeSetMange", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryMyOrder(@Valid HealthyDoctorformrequest data) {
		SimpleResult sr = new SimpleResult();
		List<HealthDocterForm> healthDocterFormList=null;
		try {
			 healthDocterFormList = healthBackStatisService.queryListByMapHealthyDoctorform(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	        sr.putData("list", healthDocterFormList); 
		return sr;
	}
	
	
	/**
	 * 预约统计接口（订单总数）
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byOrderNum", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryListByOrderNum(@Valid HealthOrderStatisRequest data) {
		SimpleResult sr = new SimpleResult();
		List<Map<String,Object>> list  = null;
		try {
			list = healthBackStatisService.queryListByOrderNum(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	     sr.putData("list", list); 
		return sr;
	}

	
	/**
	 * 累计问诊量（订单总数）
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byInterCum", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryListByInterCum(@Valid HealthOrderStatisRequest data) {
		SimpleResult sr = new SimpleResult();
		List<Map<String,Object>> list = null;
		try {
			list = healthBackStatisService.queryListByInterCum(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	     sr.putData("list", list); 
		return sr;
	}
	
	
	
	/**
	 * 累计评价数   queryListDoctorName
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byValuaCum", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryListByeValuaCum(@Valid HealthOrderStatisRequest data) {
		SimpleResult sr = new SimpleResult();
		List<Map<String,Object>> list = null;
		try {
			list = healthBackStatisService.queryListByeValuaCum(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	     sr.putData("list", list); 
		return sr;
	}   
	
	
	
	/**
	 * 查所有医生接口   
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/bySelDocName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryListDoctorName() {
		SimpleResult sr = new SimpleResult();
		List<Map<String,Object>> list = null;
		try {
			list = healthBackStatisService.queryListDoctorName();
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	     sr.putData("list", list); 
		return sr;
	}  
	
	/**
	 * 查所有医生接口   
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byDoctorformSeach", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryDoctorformseach(HealthDoctorformIdRequest data) {
		SimpleResult sr = new SimpleResult();
		List<HealthDoctorformIdReponse> list = null;
		try {
			list = healthBackStatisService.queryDoctorformseach(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
	     sr.putData("list", list); 
		return sr;
	} 
	

	
	
	/**
	 * 预约管理接口   
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byMakeMange", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPageMakeMange(PageModel page) {
		SimpleResult sr = new SimpleResult();
		Page pages =  null;
		try {
			pages = healthBackStatisService.queryPageMakeMange(page);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
		 sr.put("data", pages); 
		
		return sr;
	} 
	
	
	
	/**
	 * 预约修改接口   
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byMakeId", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateIdMake(HealthOrderMakeUpdateRequest data) {
		SimpleResult sr = null;
		try {
			healthBackStatisService.updateIdMake(data);
		} catch (Exception e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
		}
		 sr = SimpleResult.success(); 
		return sr;
	} 
	
	
	
	

	/**
	 * update短信message
	 * 
	 * @author 舵主 下午5:46:30
	 */
	@RequestMapping(value = "/byUpdateMess", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateMess(HealthmessageRequest record) {
	  	  SimpleResult sr=null;
    	  String message = null;
    	  String code=null;
    	try {
    		 if(validates(validator, record)!=null){
       		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record)); 
       	  }
    		 message = messageService.queryIdByOrder(record);
		} catch (Exception e) {
			LOGGER.error(e);
		}
    	sr = SimpleResult.success(); 
        sr.putData("message",message); 
         return  sr;
    }
	
	
	//医生新建排版
	@RequestMapping(value = "/addDocForm", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult addDocForm(@RequestBody List<HealthDoctorformAllRequest> li) {
		SimpleResult sr=null;
		try {
			if (validates(validator, li) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, li));
			}
			Integer re=healthBackStatisService.addDocForm(li);
			sr=SimpleResult.success();
			sr.put("data",re);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
		return  sr;
	}
	
	
	/**
	 * 查看单个预约信息
	 * @author 舵主
	 *
	 * 下午2:43:06
	 */
	@RequestMapping(value = "/byQueryItemByIdSel", method = RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryItemByIdSel(String orderid) {
		SimpleResult sr=null;
		HealthItemByIdSelReponse healthItemByIdSelReponse = new HealthItemByIdSelReponse();
		try {
			if (validates(validator, orderid) != null) {
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, orderid));
			}
			healthItemByIdSelReponse = healthBackStatisService.queryItemByIdSel(orderid);
			sr=SimpleResult.success();
			sr.put("data",healthItemByIdSelReponse);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(),e.getDesc());
		}
		return  sr;
	}

}
