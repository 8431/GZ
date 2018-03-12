package com.gz.medicine.gzyun.health.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.common.OrderTypeEnum;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.reponse.ExpireOrderReponse;
import com.gz.medicine.gzyun.health.service.HealthCloseOrderService;
import com.gz.medicine.yun.common.service.AlipayService;
import com.gz.medicine.yun.common.service.WechatPayService;

/**
 * 24到期退款
 * 更新订单状态为已退订
 * 咨询状态已结束
 * @author sunff
 *
 */
@Service("healthCloseOrderService")
public class HealthCloseOrderServiceImp implements HealthCloseOrderService {
	public static final Logger LOGGER = Logger.getLogger(HealthCloseOrderServiceImp.class);
	public static final String CONSULTINGSTATE = "4";
	@Autowired
	HealthyOrderMapper healthyOrderMapper;
	@Autowired
	HealthConsultationMapper healthConsultationMapper;
	@Autowired
	WechatPayService wechatPayService;
	@Autowired
	AlipayService alipayService;

	@Override
	public void closeOrder() throws CommonException {
		LOGGER.info("healthCloseOrderService  closeOrder start......");
		List<ExpireOrderReponse> beanList = healthyOrderMapper.queryExpireOrder();
		boolean flag = false;
		if (beanList.size() > 0) {
			for (ExpireOrderReponse re : beanList) {
				LOGGER.info("re.getPaymentMethod()  wechat"+re.getPaymentMethod());
				if (re.getPaymentMethod().equals("1")) {
					// to do 调用微信退订接口
					flag = wechatPayService.orderPayRefund(re.getOrderid(), re.getThirdOrderCode());
					LOGGER.info("flag wechat"+flag);
				} else if (re.getPaymentMethod().equals("2")) {
					LOGGER.info("re.getPaymentMethod()   alipay"+re.getPaymentMethod());
					// to do 调用支付宝退订接口
					flag = alipayService.orderPayRefund(re.getOrderid(), re.getThirdOrderCode());
					LOGGER.info("flag alipay"+flag);
				}
				if (flag) {
					Map<String, Object> parm = new HashMap<String, Object>();
					parm.put("id", re.getOrderid());
					parm.put("orderState", OrderTypeEnum.UNSUBSCRIBE_ORDER.getValue());
					// 更新订单状态
					try {
						healthyOrderMapper.updateOrderByOrderId(parm);
					} catch (Exception e) {
						 throw new CommonException("COM001","更新订单状态异常");        
					}
					// 更新咨询状态
					HealthConsultation bean=new HealthConsultation();
					bean.setId(re.getConsultationId());
					bean.setConsultingstate(CONSULTINGSTATE);
					healthConsultationMapper.updateByPrimaryKeySelective(bean);
				}

			}
		}
	}

}
