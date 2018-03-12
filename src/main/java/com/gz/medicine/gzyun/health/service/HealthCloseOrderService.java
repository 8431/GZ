package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;

/**
 * 24小时到期退款
 * @author sunff
 *
 */
public interface HealthCloseOrderService  {
/**
 * 关闭订单
 */
 void closeOrder() throws CommonException;
}
