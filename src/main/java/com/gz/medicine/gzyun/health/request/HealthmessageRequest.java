package com.gz.medicine.gzyun.health.request;



import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 发送短信
 * 
 * @author 舵主
 *
 */
public class HealthmessageRequest {
	
	
	@NotEmpty(message="orderid不能为空！")
	private String orderid;// 订单编号id;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	
}