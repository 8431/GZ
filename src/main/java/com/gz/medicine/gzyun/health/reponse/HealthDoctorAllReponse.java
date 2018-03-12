package com.gz.medicine.gzyun.health.reponse;

/**
 * 查所有医生接口
 * @author 舵主
 *
 * 下午4:04:41
 */
public class HealthDoctorAllReponse {

	private String docid;
	
	private String docname;

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

	@Override
	public String toString() {
		return "HealthDoctorAllReponse [docid=" + docid + ", docname=" + docname + "]";
	}
	
	
	
	
}
