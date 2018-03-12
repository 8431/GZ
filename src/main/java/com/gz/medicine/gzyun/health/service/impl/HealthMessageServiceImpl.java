package com.gz.medicine.gzyun.health.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.reponse.HealthQueryIdByOrder;
import com.gz.medicine.gzyun.health.request.HealthmessageRequest;
import com.gz.medicine.gzyun.health.service.HealthMessageService;
import com.gz.medicine.yun.doctor.service.impl.DTCaseHistoryServiceImpl;



/**
 *发送短信
 **/
@Service
public class HealthMessageServiceImpl implements HealthMessageService{
	
	public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryServiceImpl.class);
	@Autowired
	private HealthyOrderMapper consultmapper;
	
	@Autowired
	private HealthConsultationMapper healthConsultationMapper;
	
	@Override
	public String queryIdByOrder(HealthmessageRequest record) throws CommonException {
		String simpleResult=null;
		HealthQueryIdByOrder consult = new HealthQueryIdByOrder();
		try {
			String  aa = record.getOrderid();
			//根据订单编号orderid获取用户手机号
			consult = consultmapper.queryIdByOrder(aa);
			// 判断是否已经发送短信
			if(consult.getSendstatus()!="1"){
				String duanxin = "您购买的心理咨询服务已确认。预约时间:";
//				String duanxin = "【贯众云医】您购买的心理咨询服务已确认。预约时间:"+consult.getReservationdate()+"，"+
//				consult.getReservationperiod()+""+consult.getReservationtime()+"，"+consult.getConsultationmethod()+"，"+consult.getName()+"医师，￥"+
//						consult.getOrderamount()+"。医师会在此时间段内与您联系，请及时登录APP查看。";
				if(StringUtils.isNotBlank(consult.getReservationdate())){
					duanxin += consult.getReservationdate()+"，";
				}
				if(StringUtils.isNotBlank(consult.getReservationperiod())){
					duanxin += consult.getReservationperiod()+"";
				}
				if(StringUtils.isNotBlank(consult.getReservationtime())){
					duanxin += consult.getReservationtime()+"，咨询方式是：";
				}
				if(StringUtils.isNotBlank(consult.getConsultationmethod())){
					if(consult.getConsultationmethod().equals("2")){
						duanxin +="图文,";
					}if(consult.getConsultationmethod().equals("3")){
						duanxin +="语音,";
					}if(consult.getConsultationmethod().equals("4")){
						duanxin +="视频,";
					}
				}
				if(StringUtils.isNotBlank(consult.getName())){
					duanxin += consult.getName()+"医生，￥";
				}
				if(StringUtils.isNotBlank(consult.getOrderamount())){
					duanxin += consult.getOrderamount()+"元";
				}
				duanxin+="。医师会在此时间段内与您联系，请及时登录APP查看。";
				// 推送信息给指定人           
				MobileCode code  = new MobileCode();
				code.sendAuthCode(consult.getUsrphone(), duanxin);
				// 修改短信状态
				healthConsultationMapper.updateStateById(record.getOrderid());	
				simpleResult="短信发送成功";
			}else{
				String qq = "此用户接受的短信次数已用完";
				return qq;
			}
		} catch (Exception e) {
			LOGGER.error("发送短信："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		
		return simpleResult;
	}
}