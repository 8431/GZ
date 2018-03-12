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
import com.gz.medicine.gzyun.heaman.bean.HmPhyRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmPhyRecordMapper;
import com.gz.medicine.gzyun.heaman.request.HmPhyRecordRequest;
import com.gz.medicine.gzyun.heaman.service.HmPhyRecordService;

@Service
public class HmPhyRecordServiceImpl implements HmPhyRecordService {

	public static final Logger LOGGER = Logger.getLogger(HmPhyRecordServiceImpl.class);

	@Autowired
	private HmPhyRecordMapper hmPhyRecordMapper;

	@Autowired
	private UsrMapper usrmapper;

	/**
	 * 体检报告查询接口（查询）
	 *
	 * @param usrguid
	 * @return
	 */
	@Override
	public List<HmPhyRecord> selectByPhyRecord(String usrguid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmPhyRecord> recordList = new ArrayList<HmPhyRecord>();
		try {
			recordList = hmPhyRecordMapper.selectByPhyRecord(usrguid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return recordList;
	}

	/**
	 * 体检报告解读列表接口 （查询）
	 *
	 * @param usrguid
	 * @return
	 */
	@Override
	public List<HmPhyRecord> selectByTJInterpretation(String usrguid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmPhyRecord> recordList = new ArrayList<HmPhyRecord>();
		try {
			recordList = hmPhyRecordMapper.selectByTJInterpretation(usrguid);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return recordList;
	}

	/**
	 * 体检报告解读详情接口（查询）
	 *
	 * @param guid
	 * @return
	 */
	@Override
	public List<HmPhyRecord> selectByDetails(String guid) throws CommonException {
		// TODO Auto-generated method stub
		List<HmPhyRecord> recordList = new ArrayList<HmPhyRecord>();
		try {
			recordList = hmPhyRecordMapper.selectByDetails(guid);
			if (recordList != null) {
				for (HmPhyRecord h : recordList) {
					if (!StringUtils.isEmpty(h.getJdusr())) {
						String name = usrmapper.getNamebyName(h.getJdusr());
						h.setJdusr(name);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return recordList;
	}

	/**
	 * 体检报告写入接口（写入）
	 */
	@Override
	public String insertPhyRecord(HmPhyRecordRequest hmPhyRecord) throws CommonException {
		// TODO Auto-generated method stub
		String result = null;
		String Reporttype = hmPhyRecord.getReporttype();
		String Picture = hmPhyRecord.getPicture();
		String Reporttime = hmPhyRecord.getReporttime();
		try {
			if (Reporttype != "" && Picture != "") {
				HmPhyRecord heamanCases = new HmPhyRecord();
				if (Reporttime == null) {
					// 插入系統當前時間
					Date ReportTime = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					heamanCases.setReporttime(DateUtils.parseDate(formatter.format(ReportTime)));

					heamanCases.setUsrguid(hmPhyRecord.getUsrguid());
					heamanCases.setGuid(UUIDTool.getUUID());
					heamanCases.setPicture(hmPhyRecord.getPicture());
					heamanCases.setReporttype(hmPhyRecord.getReporttype());
				} else {
					heamanCases.setReporttime(DateUtils.parseDate(hmPhyRecord.getReporttime()));
				}
				hmPhyRecordMapper.insertPhyRecord(heamanCases);
			} else {
				return "-2";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("GZ10001", "体检报告写入出错。。。");

		}
		return result;
	}

}
