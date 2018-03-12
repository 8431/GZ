package com.gz.medicine.gzyun.yidiagnosis.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.service.impl.HmCaseupRecordServiceImpl;
import com.gz.medicine.gzyun.yidiagnosis.bean.YGchisJwslog;
import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickbldtl;
import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickblhdr;
import com.gz.medicine.gzyun.yidiagnosis.mapper.YGchisJwslogMapper;
import com.gz.medicine.gzyun.yidiagnosis.mapper.YGsickbldtlMapper;
import com.gz.medicine.gzyun.yidiagnosis.mapper.YGsickblhdrMapper;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGsickblhdrReponse;
import com.gz.medicine.gzyun.yidiagnosis.service.YGsickblhdrService;

@Service
public class YGsickblhdrServiceImpl implements YGsickblhdrService {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordServiceImpl.class);

	@Autowired
	private YGsickblhdrMapper hmsickblhdrMapper;

	@Autowired
	private YGsickbldtlMapper ygsickbldtlMapper;

	@Autowired
	private YGchisJwslogMapper ygchisJwslogMapper;

	@Override
	public YGsickblhdrReponse selectBySickguidKey(String sickguid) throws CommonException {
		// TODO Auto-generated method stub
		List<YGsickblhdr> hmsickblhdr;
		YGsickblhdrReponse reponse = new YGsickblhdrReponse();
		// 插入系統當前時間时间戳
		long ReportTime = new Date().getTime();
		try {
			hmsickblhdr = hmsickblhdrMapper.selectBySickguidKey(sickguid);
			YGsickblhdr ygs = hmsickblhdr.get(0);
			BeanUtils.copyProperties(hmsickblhdr.get(0), reponse);
			YGchisJwslog record = new YGchisJwslog();

			if (hmsickblhdr != null) {
				reponse.setBlguid(ygs.getGuid()); // 病例guid
				reponse.setDx_date(DateUtils.formatDateTime(ygs.getCrtdat())); // 诊断日期
				reponse.setDisease(ygs.getZhand()); // 疾病
				reponse.setMed_allergy(ygs.getGms()); // 过敏史
				reponse.setTime(ReportTime);
				// 中间表中没有数据则查询药品
				String gchisJwslog = ygchisJwslogMapper.selectCount(ygs.getGuid());
				if (gchisJwslog != null) {

					return null;

				}
				// 調用藥品的方法 21A6B4988879E399E050AE0AC684393D
				List<YGsickbldtl> gsickbldtls = selectBySickbldtlKey(ygs.getGuid());
				reponse.setLists(gsickbldtls);

				// 执行一次向CHIS_JWSLOG插入一条数据
				ygchisJwslogMapper.insertBlguid(record);

			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}

		return reponse;
	}

	/**
	 * 药品
	 */
	@Override
	public List<YGsickbldtl> selectBySickbldtlKey(String formguid) throws CommonException {
		// TODO Auto-generated method stub

		List<YGsickbldtl> gsickbldtl;
		YGsickblhdrReponse reponse = new YGsickblhdrReponse();
		YGsickbldtl gsickbldtl2 = new YGsickbldtl();
		try {
			gsickbldtl = ygsickbldtlMapper.selectBySickbldtlKey(formguid);
			BeanUtils.copyProperties(gsickbldtl, gsickbldtl2);
			if (gsickbldtl != null) {// 判断blguid是否有药物0
				reponse.setMedication_name(gsickbldtl2.getDrunam()); // 药物名称
				reponse.setDosage(gsickbldtl2.getPian()); // 剂量
				reponse.setFrequency(gsickbldtl2.getPcname()); // 频率
				reponse.setRoute(gsickbldtl2.getKfwyname()); // 途径
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new CommonException("GZ10001", "request user center exception.", e);
		}

		return gsickbldtl;
	}

}
