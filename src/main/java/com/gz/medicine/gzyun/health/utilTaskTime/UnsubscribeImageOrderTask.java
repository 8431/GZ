package com.gz.medicine.gzyun.health.utilTaskTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.service.HealthCloseOrderService;

/**
 * 24小时到期订单退订 批量处理接口
 * 
 * @author sunff
 *
 */
@Service("unsubscribeImageOrder")
public class UnsubscribeImageOrderTask {
	public static final Logger LOGGER = Logger.getLogger(UnsubscribeImageOrderTask.class);
	@Autowired
	HealthCloseOrderService healthCloseOrderService;

	public void imageOrder() {
		LOGGER.info("unsubscribeImageOrder start ....");

		try {
			healthCloseOrderService.closeOrder();
		} catch (CommonException e) {
			LOGGER.error(e);
		}

		LOGGER.info("unsubscribeImageOrder end ....");
	}

}
