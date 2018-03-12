package com.gz.medicine.gzyun.heaman.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gz.medicine.gzyun.user.mapper.UsrMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.heaman.bean.HmCaseupRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmCaseupRecordMapper;
import com.gz.medicine.gzyun.heaman.request.HmCaseupRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmCaseupRecordService;

@Service
public class HmCaseupRecordServiceImpl implements HmCaseupRecordService {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordServiceImpl.class);

	@Autowired
	private HmCaseupRecordMapper caseupRecordMapper;

	@Autowired
	private UsrMapper usrmapper;

	/**
	 * 病历上传查询接口（查询）
	 *
	 * @param usrguid
	 * @return
	 */
	@Override
	public List<HmCaseupRecord> selectByCaseup(String usrguid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmCaseupRecord> recordList = new ArrayList<HmCaseupRecord>();
		try {
			recordList = caseupRecordMapper.selectByCaseup(usrguid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return recordList;
	}

	/**
	 * 查询病例表的前十条
	 */
	@Override
	public List<HmCaseupRecordRequest> ListCaseup(HmCaseupRecordRequest caseupRecordRequest) throws CommonException {
		// TODO Auto-generated method stub
		List<HmCaseupRecordRequest> hmCaseup = new ArrayList<HmCaseupRecordRequest>();
		try {
			hmCaseup = caseupRecordMapper.ListCaseup();
		} catch (Exception e) {
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return hmCaseup;

	}

	/**
	 * 病例解读详情接口（查询）
	 */
	@Override
	public List<HmCaseupRecord> selectByDetails(String guid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmCaseupRecord> heamanCases = null;
		try {
			heamanCases = caseupRecordMapper.selectByDetails(guid);
			if (heamanCases != null) {
				for (HmCaseupRecord h : heamanCases) {
					if (!StringUtils.isEmpty(h.getJdusr())) {
						String name = usrmapper.getNamebyName(h.getJdusr());
						h.setJdusr(name);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return heamanCases;
	}
	/**
	 * 病例解读列表接口 （查询）
	 */
	@Override
	public List<HmCaseupRecord> selectByInterpretation(String usrguid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmCaseupRecord> recordList = new ArrayList<HmCaseupRecord>();
		try {
			recordList = caseupRecordMapper.selectByInterpretation(usrguid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return recordList;
	}

	/**
	 * 病历上传查询接口（写入）
	 */
	@Override
	public String insertCaseup(HmCaseupRecordRequest caseupRecordRequest) throws Exception {
		// TODO Auto-generated method stub

		String result = null;
		String Reporttype = caseupRecordRequest.getReporttype();
		String Picture = caseupRecordRequest.getPicture();
		String Reporttime = caseupRecordRequest.getReporttime();
		try {

			if (Reporttype != "" && Picture != "") {
				HmCaseupRecord caseupRecord = new HmCaseupRecord();
				if (Reporttime == null) {
					// 插入系統當前時間
					Date ReportTime = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					caseupRecord.setReporttime(DateUtils.parseDate(formatter.format(ReportTime)));

				caseupRecord.setUsrguid(caseupRecordRequest.getUsrguid());
				caseupRecord.setGuid(UUIDTool.getUUID());
				caseupRecord.setPicture(caseupRecordRequest.getPicture());
				caseupRecord.setReporttype(caseupRecordRequest.getReporttype());
				} else {
					caseupRecord.setReporttime(DateUtils.parseDate(caseupRecordRequest.getReporttime()));
				}
				caseupRecordMapper.insertCaseup(caseupRecord);

			} else {
				return "-2";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("GZ10001", "病例写入出错。。。");

		}
		return result;
	}

}
