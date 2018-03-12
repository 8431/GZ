package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 排班管理数据校验类
 * @author 舵主
 *
 * 下午5:19:16
 */
public class HealthyDoctorformrequest {
	@NotEmpty(message="日期不能为空")
	private String schedate;

	public String getSchedate() {
		return schedate;
	}

	public void setSchedate(String schedate) {
		this.schedate = schedate;
	}
	
	
	
	
	
}
