package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author 舵主
 *
 * 上午11:47:51
 */
public class HealthOrderStatisRequest {
	// 开始时间
	@NotEmpty(message="开始时间不能为空")
	private String strdate;
	
	
	// 结束时间
	@NotEmpty(message="结束时间不能为空")
	private String enddate;
	
	
	public String getStrdate() {
		return strdate;
	}
	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "HealthOrderStatisRequest [strdate=" + strdate + ", enddate=" + enddate + "]";
	}
	
	
	
	
	
	
}
