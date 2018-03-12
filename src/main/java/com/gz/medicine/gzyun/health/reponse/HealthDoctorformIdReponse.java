package com.gz.medicine.gzyun.health.reponse;
/**
 * @author 舵主
 *
 * 下午3:51:26
 */
public class HealthDoctorformIdReponse {
	// 排班表唯一标识
	private String dfid;
	// 医生ID
	private String docid;
	// 医生名字
	private String docname;
	// 日期
	private String datea;
	// 时段
	private String intervaldate;

	public String getDfid() {
		return dfid;
	}

	public void setDfid(String dfid) {
		this.dfid = dfid;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDatea() {
		return datea;
	}

	public void setDatea(String datea) {
		this.datea = datea;
	}

	public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
	}
}
