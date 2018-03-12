package com.gz.medicine.gzyun.health.reponse;

/**
 * @author 舵主
 *
 * 下午4:41:38
 */
public class HealthByInterCumReponse {

	// 问诊日期
	private String consultationdate;
	
	// 问诊人数
	private String consultationnum;

	public String getConsultationdate() {
		return consultationdate;
	}

	public void setConsultationdate(String consultationdate) {
		this.consultationdate = consultationdate;
	}

	public String getConsultationnum() {
		return consultationnum;
	}

	public void setConsultationnum(String consultationnum) {
		this.consultationnum = consultationnum;
	}

	@Override
	public String toString() {
		return "HealthByInterCum [consultationdate=" + consultationdate + ", consultationnum=" + consultationnum + "]";
	}
	
	
	
	
	
}
