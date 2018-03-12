package com.gz.medicine.yun.common.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.*;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.yun.common.config.WechatPayConfig;
import com.gz.medicine.yun.common.service.WechatPayService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName WechatPayServiceImpl
 * @PackageName com.gz.medicine.yun.common.service.impl
 * @Description 微信支付 Service impl
 * @Data 2017-08-17 10:47
 **/
@Service("wechatPayService")
public class WechatPayServiceImpl implements WechatPayService {

	public static final Logger LOGGER = Logger.getLogger(WechatPayServiceImpl.class);

	@Autowired
	private HealthyOrderMapper healthyOrderMapper;

	@Override
	public boolean orderPayRefund(String tradeno, String orderid) throws CommonException {
		Map<String, String> restmap = null;
		try {
			Map<String, String> parm = new HashMap<String, String>();
			parm.put("appid", WechatPayConfig.APP_ID);
			parm.put("mch_id", WechatPayConfig.MCH_ID);
			parm.put("nonce_str", AliPayUtil.getNonceStr());
			parm.put("transaction_id", tradeno);// 微信订单号
			parm.put("out_trade_no", orderid);// 订单号
			parm.put("out_refund_no", AliPayUtil.getRefundNo()); // 退款单号
			parm.put("total_fee", "10"); // 订单总金额 从业务逻辑获取
			parm.put("refund_fee", "10"); // 退款金额
			parm.put("op_user_id", WechatPayConfig.MCH_ID);
			parm.put("refund_account", "REFUND_SOURCE_RECHARGE_FUNDS");// 退款方式
			parm.put("sign", AliPayUtil.getSign(parm, WechatPayConfig.API_SECRET));
			// String restxml = HttpUtils.posts(ORDER_REFUND,
			// XmlUtil.xmlFormat(parm, false));
			String restxml = HttpUtils.posts(WechatPayConfig.ORDER_REFUND, XmlUtil.xmlFormat(parm, false));
			restmap = XmlUtil.xmlParse(restxml);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		Map<String, Object> refundMap = new HashMap<String, Object>();
		if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
			refundMap.put("transaction_id", restmap.get("transaction_id"));
			refundMap.put("out_trade_no", restmap.get("out_trade_no"));
			refundMap.put("refund_id", restmap.get("refund_id"));
			refundMap.put("out_refund_no", restmap.get("out_refund_no"));
			LOGGER.info("订单退款：订单" + restmap.get("out_trade_no") + "退款成功，商户退款单号" + restmap.get("out_refund_no")
					+ "，微信退款单号" + restmap.get("refund_id"));
			// 订单获取成功 refundMap
			return true;
		} else {
			if (CollectionUtil.isNotEmpty(restmap)) {
				LOGGER.info("订单退款失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));

			}

		}
		return false;

	}

}
