package com.gz.medicine.gzyun.yidiagnosis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gz.medicine.gzyun.user.mapper.UsrMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.BeanUtil;
import com.gz.medicine.common.util.HttpRequest;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.gzyun.heaman.service.impl.HmCaseupRecordServiceImpl;
import com.gz.medicine.gzyun.user.bean.ObcUsr;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.yidiagnosis.reponse.DocLineReponse;
import com.gz.medicine.gzyun.yidiagnosis.service.DocLineService;

@Service
public class DocLineServiceImpl implements DocLineService {

	public static final Logger LOGGER = Logger.getLogger(HmCaseupRecordServiceImpl.class);

	@Autowired
	private UsrMapper usrMapper;

	/**
	 * 推送医生在岗信息
	 */
	@Override
	public String selectByDOCLINE(DocLineReponse reponse) throws CommonException {
		// TODO Auto-generated method stub
		String res = null;
		List<ObcUsr> usrList = new ArrayList<ObcUsr>();
		//String G_URL="https://qa.envive.cn/";
		Map<String, String> param = new HashMap<String, String>();
	//	DocLineReponse reponse = new DocLineReponse();
		try {

			// 插入系統當前時間时间戳
			long ReportTime = new Date().getTime();
			//long转String
			String ReportTimes = String.valueOf(ReportTime);
			
			usrList = usrMapper.selectByDOCLINE(reponse.getGuid());
			if (usrList.size() > 0) {
 				param = BeanUtil.transBean2Map(usrList.get(0));
//				// 医生编号
				param.put("Guid", reponse.getGuid());


			}
			// Isol和Stat有值，则在岗，为0
			if (usrList.get(0).getIsol() != "" && usrList.get(0).getIsol() != null && usrList.get(0).getStat() != ""
					&& usrList.get(0).getStat() != null) {
				reponse.setIs_online("1");
			} else {
				// 不在岗
				reponse.setIs_online("0");
			}
			param.put("Hospital", "1231010442503162XW");
			param.put("Partner", "fromfuture");
			param.put("Time", ReportTimes);
			

			String url = PropertyUtil.getPropery("G_URL") +"api/doctor/v1/add-doctor";
			try {
				// 请求用户中心获取用户uuid
				res = HttpRequest.sendPost(url, param);
			} catch (Exception e) {
				throw new CommonException("GZ10001", "request user center exception.", e);
			}
			
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		return res;

	}

	public DocLineReponse selectByDOCLINE(String guid) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
