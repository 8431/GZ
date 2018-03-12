package com.gz.medicine.gzyun.health.reponse;

/**
 * @author 舵主
 *
 * 下午6:26:11
 */
public class HealthQueryIdByOrder {
	 

  private String reservationdate;
  private String reservationperiod;
  private String reservationtime;
  
  private String consultationmethod;
  private String orderamount;
  private String usrphone;
  
  private String name;
  private String sendstatus;
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
public String getReservationtime() {
	return reservationtime;
}
public void setReservationtime(String reservationtime) {
	this.reservationtime = reservationtime;
}
public String getConsultationmethod() {
	return consultationmethod;
}
public void setConsultationmethod(String consultationmethod) {
	this.consultationmethod = consultationmethod;
}
public String getOrderamount() {
	return orderamount;
}
public void setOrderamount(String orderamount) {
	this.orderamount = orderamount;
}
public String getUsrphone() {
	return usrphone;
}
public void setUsrphone(String usrphone) {
	this.usrphone = usrphone;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSendstatus() {
	return sendstatus;
}
public void setSendstatus(String sendstatus) {
	this.sendstatus = sendstatus;
}
@Override
public String toString() {
	return "HealthQueryIdByOrder [reservationdate=" + reservationdate + ", reservationperiod=" + reservationperiod
			+ ", reservationtime=" + reservationtime + ", consultationmethod=" + consultationmethod + ", orderamount="
			+ orderamount + ", usrphone=" + usrphone + ", name=" + name + ", sendstatus=" + sendstatus + "]";
}
	  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
