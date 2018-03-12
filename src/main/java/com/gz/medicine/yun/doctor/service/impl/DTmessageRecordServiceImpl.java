package com.gz.medicine.yun.doctor.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gz.medicine.yun.doctor.request.DTfollowupTemplateRequest;
import com.gz.medicine.yun.doctor.bean.DTfollowupTemplate;
import com.gz.medicine.yun.doctor.mapper.DTfollowupTemplateMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.doctor.bean.DTfollowupRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.mapper.DTfollowupRecordMapper;
import com.gz.medicine.yun.doctor.mapper.DTmessageRecordMapper;
import com.gz.medicine.yun.doctor.mapper.DTmessageTemplateMapper;
import com.gz.medicine.yun.doctor.reponse.DTfollowupRecordResponse;
import com.gz.medicine.yun.doctor.reponse.DTmessageRecordResponse;
import com.gz.medicine.yun.doctor.service.DTmessageRecordService;
import com.gz.medicine.yun.user.bean.Usr;
import com.gz.medicine.yun.user.mapper.UsrsMapper;


@Service
public class DTmessageRecordServiceImpl implements DTmessageRecordService {

	public static final Logger LOGGER = Logger.getLogger(DTmessageRecordServiceImpl.class);

	@Autowired
	private DTmessageRecordMapper messageRecordMapper;
	@Autowired
	private DTmessageTemplateMapper messageTemplateMapper;
	@Autowired
	private DTfollowupRecordMapper followupRecordMapper;
	@Autowired
	private UsrsMapper usrMapper;
	@Autowired
	private DTfollowupTemplateMapper followupTemplateMapper;
	/**
	 * 短信记录 详情
	 */
	@Override
	public DTmessageRecord selectByPrimaryKey(String guid) throws CommonException {
		// TODO Auto-generated method stub
		DTmessageRecord record = null;
		try {
			record = messageRecordMapper.selectByPrimaryKey(guid);
		} catch (Exception e) {			
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return record;
	}

	/**
	 * 短信模板 模糊查询 分页
	 */
	@Override
	public SimpleResult queryPageSelectPrimary(PageModel pm) throws CommonException {
		// TODO Auto-generated method stub
		SimpleResult sr = null;
		Page pe = pm.getPage();
		List<DTmessageTemplate> list = new ArrayList<DTmessageTemplate>();
		try {
			String templatename = (String) pe.get("templatename");
			if (!StringUtils.isEmpty(templatename)) {
				pe.put("templatename", "%" + templatename + "%");
			}
			list = messageTemplateMapper.queryPageSelectPrimary(pe);
			pe.setParameterType(list);
			sr = SimpleResult.success();
			sr.put("data", pe);
		} catch (Exception e) {
			LOGGER.error("分页查询随访短信模板Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "分页查询随访短信模板Server层异常");
		}
		return sr;
	}

	/**
	 * 模板新增
	 */
	@Override
	public int AddPrimary(DTmessageTemplate dTmessageTemplate) throws CommonException {
		DTmessageTemplate template = new DTmessageTemplate();
		try {
			// 插入系統當前時間
			Date ReportTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			template.setCrtdat(DateUtils.parseDate(formatter.format(ReportTime)));
			template.setGuid(UUIDTool.getUUID());
			template.setTemplatecontent(dTmessageTemplate.getTemplatecontent());
			template.setTemplatename(dTmessageTemplate.getTemplatename());
			template.setDocguid(dTmessageTemplate.getDocguid()); // 医生的guid
			template.setOrg("chis");
			template.setStatus("1");
			messageTemplateMapper.insertTemplate(template);
		} catch (Exception e) {
			LOGGER.error("模板新增Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "模板新增Server层异常");
		}
		return 0;
	}

	/**
	 * 短信记录详情 list
	 */
	@Override
	public List<DTmessageRecord> selectByGuidKey(String guid) throws CommonException {
		// TODO Auto-generated method stub
		List<DTmessageRecord> record = null;
		try {
			record = messageRecordMapper.selectByGuidKey(guid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return record;
	}

	/**
	 * 模板修改
	 */
	@Override
	public int updateByTemplate(DTmessageTemplate record) throws CommonException {

		DTmessageTemplate template = new DTmessageTemplate();
		DTmessageTemplate template2 = null;
		try {
			// 查单个
			template2 = messageTemplateMapper.selectByPrimaryKey(record.getGuid());
			if (template2 != null) {// 有数据
				// 插入系統當前時間
				Date ReportTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				template.setUpdatedate(DateUtils.parseDate(formatter.format(ReportTime))); // 更新时间
				template.setTemplatecontent(record.getTemplatecontent());// 模板内容
				template.setTemplatename(record.getTemplatename());// 模板名称
				template.setGuid(record.getGuid());
				messageTemplateMapper.updateByTemplate(template);
			}
		} catch (Exception e) {
			LOGGER.error("模板修改Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "模板修改Server层异常");
		}

		return 0;
	}

	/**
	 * 假删除 短信模板
	 */
	@Override
	public int deleteByTemplate(DTmessageTemplate record) throws CommonException {
		DTmessageTemplate template = new DTmessageTemplate();
		DTmessageTemplate template2 = null;
		try {
			// 查单个
			template2 = messageTemplateMapper.selectByPrimaryKey(record.getGuid());
			if (template2 != null) {// 有数据
				template.setStatus("0");
				template.setGuid(record.getGuid());
				messageTemplateMapper.deleteByTemplate(template);
			}
		} catch (Exception e) {
			LOGGER.error("模板假删除Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "模板假删除Server层异常");
		}

		return 0;
	}

	/**
	 * 视频详情
	 */
	@Override
	public List<DTfollowupRecordResponse> selectDTfollowupRecord(String guid) throws CommonException {
		List<DTfollowupRecordResponse> response = null;
		try {
			response = followupRecordMapper.selectDTfollowupRecord(guid);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return response;

	}

	/**
	 * 随访记录 列表
	 */
	@Override
	public SimpleResult selectByMessageRecord(PageModel page) throws CommonException {
		SimpleResult sr = null;
		List<DTmessageRecord> response = null;
		DTmessageRecordResponse dtreponse = new DTmessageRecordResponse();
		Page p = page.getPage();
		try {
			String usruid = p.get("usrguid").toString();
			// 用户基本信息
			Usr usr = usrMapper.selectByRecordMessage(usruid);
			if (usr != null) {
				dtreponse.setUsrname(usr.getName());
				dtreponse.setSex(usr.getSex());
				dtreponse.setAge(usr.getAge());
				dtreponse.setMobile(usr.getMobile());
				// 随访列表
				response = messageRecordMapper.queryPageByMessageRecord(p);
				 p.setParameterType(response);
				sr = SimpleResult.success();
				p.put("usr", dtreponse);
				sr.put("data", p);
				
			}else{
				sr = SimpleResult.success();
				p.setParameterType(response);
				p.put("usr", dtreponse);
				sr.put("data", p);
			}

		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return sr;
	}

	/**
	 * 随访记录 列表 pc端 分页
	 */
	@Override
	public SimpleResult queryPageMessageRecord(PageModel page) throws CommonException {
		SimpleResult sr = null;
		List<DTfollowupRecord> response = null;
		Page p = page.getPage();
		try {
			// 随访列表1503676800000
			response = followupRecordMapper.queryPageMessageRecord(p);
			p.setParameterType(response);
			sr = SimpleResult.success();
			sr.put("data", p);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return sr;
	}


	/**
	 * 随访模板
	 * @param
	 * @return
	 * @throws CommonException
	 */
	@Override
	public Page queryPageFollow(PageModel page) throws CommonException {
		List<DTfollowupTemplate> response = null;
		Page p = page.getPage();
		try {
			if(p.get("userid")==null||p.get("type")==null) {
				throw new CommonException("医生id和模板类型不能为空");
			}
			String title = (String) p.get("title");
			if (!StringUtils.isEmpty(title)) {
				p.put("title", "%" + title + "%");
			}
			response = followupTemplateMapper.queryPageFollow(p);
			p.setParameterType(response);

		} catch (Exception e) {
			LOGGER.error("随访模板Server层异常：" + e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return p;
	}

	/**
	 * 新增随访模板 www
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String insertFollow(DTfollowupTemplateRequest record) throws CommonException {
		String result = null;

		try {
			DTfollowupTemplate  followupTemplate = new DTfollowupTemplate();
				// 插入系統當前時間
				Date Createdate = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			followupTemplate.setCreatedate(DateUtils.parseDate(formatter.format(Createdate)));
			followupTemplate.setId(UUIDTool.getUUID());
			followupTemplate.setUserid(record.getUserid());
			followupTemplate.setTitle(record.getTitle());
			followupTemplate.setContent(record.getContent());
			followupTemplate.setType(record.getType());
			followupTemplate.setState("1");
			followupTemplateMapper.insert(followupTemplate);
		} catch (Exception e) {
			LOGGER.error("执行sql异常（方法：updateItemByIdConsultationSummary）" + e.getMessage(), e);
			throw new CommonException("COM001", "执行sql异常（方法：updateItemByIdConsultationSummary）");
		}
		result = "0";
		return result;
	}


	/**
	 * 随访模板 修改  www
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String updateByPrimaryKeySelective(DTfollowupTemplateRequest record) throws CommonException {
		String result = null;
		DTfollowupTemplate template = new DTfollowupTemplate();
		DTfollowupTemplate template2 = null;
		try {
			// 查单个
			template2 = followupTemplateMapper.selectByPrimaryKey(record.getId());
			if (template2 != null) {// 有数据
				// 插入系統當前時間
				Date ReportTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				template.setUpdatedate(DateUtils.parseDate(formatter.format(ReportTime))); // 更新时间
				template.setUserid(record.getUserid());
				template.setTitle(record.getTitle());
				template.setContent(record.getContent());
				template.setType(record.getType());
				template.setId(record.getId());
				followupTemplateMapper.updateByPrimaryKeySelective(template);
			}
		} catch (Exception e) {
			LOGGER.error("模板修改Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "模板修改Server层异常");
		}
		result = "0";
		return result;
	}

	/**
	 * 假删 www
	 * @param record
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String updateState(DTfollowupTemplate record) throws CommonException {
		String result = null;
		DTfollowupTemplate template = new DTfollowupTemplate();
		DTfollowupTemplate template2 = null;
		try {
			// 查单个
			template2 = followupTemplateMapper.selectByPrimaryKey(record.getId());
			if (template2 != null) {// 有数据
				// 插入系統當前時間
				Date ReportTime = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				template.setUpdatedate(DateUtils.parseDate(formatter.format(ReportTime))); // 更新时间
				template.setId(record.getId());
				template.setState("0");
				followupTemplateMapper.updateState(template);
			}
		} catch (Exception e) {
			LOGGER.error("模板修改Server层异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "模板修改Server层异常");
		}
		result = "0";
		return result;
	}

}
