package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 排班新增接口
 * @author 舵主
 *
 * 上午11:53:29
 */
public class HealthDoctorformAllRequest {
	
	
	// 医生ID
	@NotEmpty(message="医生ID不能为空")
	private String docid;
		
	// 日期
	@NotEmpty(message="日期不能为空")
	private String healthytypesettingtime;
	// 日期
	@NotEmpty(message="日期不能为空")
	private String datea;
	// 排班时段
	@NotEmpty(message="排班时段不能为空")
	private String intervaldate;

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getHealthytypesettingtime() {
		return healthytypesettingtime;
	}

	public void setHealthytypesettingtime(String healthytypesettingtime) {
		this.healthytypesettingtime = healthytypesettingtime;
	}

	public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
	}

	public String getDatea() {
		return datea;
	}

	public void setDatea(String datea) {
		this.datea = datea;
	}
}
