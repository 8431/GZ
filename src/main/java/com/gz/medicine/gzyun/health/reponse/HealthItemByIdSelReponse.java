package com.gz.medicine.gzyun.health.reponse;

import java.util.List;

/**
 * 查看预约信息 
 * @author 舵主
 *
 * 下午1:55:05
 */
public class HealthItemByIdSelReponse {
	
	private String sendstatus;
	
	private String consultationmethod;
	private String orderdate;
	private String healthytypesettingtime;
	
	private String orderid;
	private String orderamount;
	private String usrname;
	
	private String sex;
	private String birthday;
	private String usrphone;
	
	private String reservationdate;
	private String reservationperiod;
	private String reservationdescription;
	
	private List<HealthLogIdReponse> logifo;
	public List<HealthLogIdReponse> getLogifo() {
		return logifo;
	}
	public void setLogifo(List<HealthLogIdReponse> logifo) {
		this.logifo = logifo;
	}
	public String getSendstatus() {
		return sendstatus;
	}
	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}
	public String getConsultationmethod() {
		return consultationmethod;
	}
	public void setConsultationmethod(String consultationmethod) {
		this.consultationmethod = consultationmethod;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getHealthytypesettingtime() {
		return healthytypesettingtime;
	}
	public void setHealthytypesettingtime(String healthytypesettingtime) {
		this.healthytypesettingtime = healthytypesettingtime;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(String orderamount) {
		this.orderamount = orderamount;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUsrphone() {
		return usrphone;
	}
	public void setUsrphone(String usrphone) {
		this.usrphone = usrphone;
	}
	public String getReservationdate() {
		return reservationdate;
	}
	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}
	public String getReservationperiod() {
		return reservationperiod;
	}
	public void setReservationperiod(String reservationperiod) {
		this.reservationperiod = reservationperiod;
	}
	public String getReservationdescription() {
		return reservationdescription;
	}
	public void setReservationdescription(String reservationdescription) {
		this.reservationdescription = reservationdescription;
	}
	@Override
	public String toString() {
		return "HealthItemByIdSelReponse [sendstatus=" + sendstatus + ", consultationmethod=" + consultationmethod
				+ ", orderdate=" + orderdate + ", healthytypesettingtime=" + healthytypesettingtime + ", orderid="
				+ orderid + ", orderamount=" + orderamount + ", usrname=" + usrname + ", sex=" + sex + ", birthday="
				+ birthday + ", usrphone=" + usrphone + ", reservationdate=" + reservationdate + ", reservationperiod="
				+ reservationperiod + ", reservationdescription=" + reservationdescription + ", logifo=" + logifo + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
