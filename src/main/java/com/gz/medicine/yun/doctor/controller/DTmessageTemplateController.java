package com.gz.medicine.yun.doctor.controller;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupTemplate;
import com.gz.medicine.yun.doctor.request.DTfollowupTemplateRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.service.DTmessageRecordService;

@Controller
@RequestMapping("/Docpre")
public class DTmessageTemplateController extends ValidateWithException {

	public static final Logger LOGGER = Logger.getLogger(DTmessageTemplateController.class);

	@Autowired
	private DTmessageRecordService messageRecordService;
	@Autowired
	Validator validator;

	/**
	 * 随访短信模板   分页模糊查询 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/GetDTmessageTemplate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult GetDTmessageTemplate(PageModel page) {
		SimpleResult sr = null;
		try {
			sr = messageRecordService.queryPageSelectPrimary(page);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 随访短信模板新增
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/AddDTmessageRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult AddDTmessageRecord(DTmessageTemplate record) {
		SimpleResult sr = null;
		int result = 0;
		 try {
       	  if(validates(validator, record)!=null){
         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
        	  	}
			 result = messageRecordService.AddPrimary(record);
			 if (result == 0){
				 sr = SimpleResult.success();
			 }else {
				 sr=SimpleResult.error("001","失败");
			 }
		 } catch (Exception e) {
			 //e.printStackTrace();
			 return SimpleResult.error("001", "失败");
		 }
	          return sr;

	}

	/**
	 * 随访短信模板修改
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/UpdateDTmessageRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult UpdateDTmessageRecord( DTmessageTemplate record) {
		SimpleResult sr = null;
		int result = 0;
		 try {
	       	  if(validates(validator, record)!=null){
	         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
	        	  	}
			 result= messageRecordService.updateByTemplate(record);
			 if (result == 0){
				 sr = SimpleResult.success();
			 }else {
				 sr=SimpleResult.error("001","失败");
			 }
		 } catch (Exception e) {
			 //e.printStackTrace();
			 return SimpleResult.error("001", "失败");
		 }
		          return sr;
	}

	/**
	 * 随访短信模板刪除
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/DeleteDTmessageRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult DeleteDTmessageRecord(@Valid DTmessageTemplate record) {
		SimpleResult sr = null;
		try {
	       	  if(validates(validator, record)!=null){
	         		return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
	        	  	}
	       	  messageRecordService.deleteByTemplate(record);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          return sr;
	}

	/**
	 * 随访模板 www
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryPageFollow", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult queryPageFollow(PageModel page) {
		SimpleResult sr = null;
		Page pages= null;
		try {
			pages = messageRecordService.queryPageFollow(page);
			sr = SimpleResult.success();
			sr.put("data", pages);
		} catch (CommonException e) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
		}
		return sr;
	}

	/**
	 * 随访模板 新增
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/insertFollow", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult insertFollow(DTfollowupTemplateRequest record) {
		SimpleResult sr = null;
		String result = null;
		try {
			if(validates(validator, record)!=null){
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));

			}
			result = messageRecordService.insertFollow(record);
			if (result == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return SimpleResult.error("001", "失败");
		}
		return sr;

	}

	/**
	 * 随访模板 修改
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateByPrimaryKeySelective(DTfollowupTemplateRequest record) {
		SimpleResult sr = null;
		String  result = null;
		try {
			if(validates(validator, record)!=null){
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			result = messageRecordService.updateByPrimaryKeySelective(record);
			if (result == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return SimpleResult.error("001", "失败");
		}
		return sr;
	}

	/**
	 * 假删  模板 www
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/updateState", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public SimpleResult updateState(@Valid DTfollowupTemplate record) {
		SimpleResult sr = null;
		String result = null;
		try {
			if(validates(validator, record)!=null){
				return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, record));
			}
			result = messageRecordService.updateState(record) ;
			if (result == "0"){
				sr = SimpleResult.success();
			}else {
				sr=SimpleResult.error("001","失败");
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return SimpleResult.error("001", "失败");
		}
		return sr;
	}

}
