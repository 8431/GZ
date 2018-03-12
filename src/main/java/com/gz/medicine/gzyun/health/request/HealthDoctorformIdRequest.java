package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 新增排班，校验医生当日排班信息
 * @author 舵主
 *
 * 上午11:51:03
 */
public class HealthDoctorformIdRequest {
	
	// 医生ID
	@NotEmpty(message="医生ID不能为空")
	private String docid;
	
	// 日期
	@NotEmpty(message="日期不能为空")
	private String datea;

	private String intervaldate;
	
	public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDatea() {
		return datea;
	}

	public void setDatea(String datea) {
		this.datea = datea;
	}

	@Override
	public String toString() {
		return "HealthDoctorformIdRequest [docid=" + docid + ", datea=" + datea + ", intervaldate=" + intervaldate
				+ "]";
	}

	
	
	
	
	
	
	
}
