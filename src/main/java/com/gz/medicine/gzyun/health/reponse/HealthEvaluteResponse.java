package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.util.Date;




public class HealthEvaluteResponse  implements Serializable{
	/**
	 * 评论查询
	 * jin
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private String usrid;
	 
	 private String createdate;
	 
	 private String score;
	 
	 private String evaluationdescription;
	 
	 private String consultationid;
	 
	 private String usrname;
	 
	 private String orderid;

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getEvaluationdescription() {
		return evaluationdescription;
	}

	public void setEvaluationdescription(String evaluationdescription) {
		this.evaluationdescription = evaluationdescription;
	}

	public String getConsultationid() {
		return consultationid;
	}

	public void setConsultationid(String consultationid) {
		this.consultationid = consultationid;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	
	
}
