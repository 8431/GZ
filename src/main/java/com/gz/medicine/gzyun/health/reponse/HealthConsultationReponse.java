package com.gz.medicine.gzyun.health.reponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.List;

public class HealthConsultationReponse {
 
	private String consultationid; 
	
	private String docid;
	
	private String paymentmethod;
	
	private String usrid;

	private  String usrids;
	
	private String usrname;
	
	private String reservationtime;
	
	private String orderid;
	
	private String imgguid;
	
	private String reserstarttime;
	
	private String reserendtime;
	
	private String consultingstate;
	
	private String reservationperiod;
	
	private String consultationmethod;

	private  String currentTime;

	private String reserEndTime;
	
	private String id;
	
	private String messagename;
	
	private String messagetype;
	
	private String pushtime;
	
	private String pushmessage;
	
	private String createdate;
	
	private String consultingdescription;

	private String reservationphotoid;
	
	private String consultationsummary;

	private String ftpurl;
	
	private String reservationdate;

	private String consultationdate;
	
	private String consultinghours;
	
	private String guid;
	
	private String name;
	
	private List<String> reservationphotoidList = new ArrayList<String>();
	

	
	public HealthConsultationReponse() {
		currentTime = Long.toString(System.currentTimeMillis());
	}


	public String getDocid() {
		return docid;
	}


	public void setDocid(String docid) {
		this.docid = docid;
	}


	public String getPaymentmethod() {
		return paymentmethod;
	}


	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}


	public String getUsrid() {
		return usrid;
	}


	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}


	public String getUsrname() {
		return usrname;
	}


	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}


	public String getReservationtime() {
		return reservationtime;
	}


	public void setReservationtime(String reservationtime) {
		this.reservationtime = reservationtime;
	}


	public String getConsultationid() {
		return consultationid;
	}


	public void setConsultationid(String consultationid) {
		this.consultationid = consultationid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getImgguid() {
		return imgguid;
	}


	public void setImgguid(String imgguid) {
		this.imgguid = imgguid;
	}


	public String getConsultingstate() {
		return consultingstate;
	}


	public void setConsultingstate(String consultingstate) {
		this.consultingstate = consultingstate;
	}

	public String getReservationperiod() {
		return reservationperiod;
	}

	public void setReservationperiod(String reservationperiod) {
		this.reservationperiod = reservationperiod;
	}


	public String getConsultationmethod() {
		return consultationmethod;
	}


	public void setConsultationmethod(String consultationmethod) {
		this.consultationmethod = consultationmethod;
	}

	public String  getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String  currentTime) {
	this.currentTime = currentTime;
	}

	public String getReserEndTime() {
		return reserEndTime;
	}

	public void setReserEndTime(String reserEndTime) {
		this.reserEndTime = reserEndTime;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMessagename() {
		return messagename;
	}


	public void setMessagename(String messagename) {
		this.messagename = messagename;
	}


	public String getMessagetype() {
		return messagetype;
	}


	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}


	public String getPushtime() {
		return pushtime;
	}


	public void setPushtime(String pushtime) {
		this.pushtime = pushtime;
	}


	public String getPushmessage() {
		return pushmessage;
	}


	public void setPushmessage(String pushmessage) {
		this.pushmessage = pushmessage;
	}


	public String getCreatedate() {
		return createdate;
	}


	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}


	public String getConsultingdescription() {
		return consultingdescription;
	}


	public void setConsultingdescription(String consultingdescription) {
		this.consultingdescription = consultingdescription;
	}


	public String getReservationphotoid() {
		return reservationphotoid;
	}


	public void setReservationphotoid(String reservationphotoid) {
		this.reservationphotoid = reservationphotoid;
	}


	public String getConsultationsummary() {
		return consultationsummary;
	}


	public void setConsultationsummary(String consultationsummary) {
		this.consultationsummary = consultationsummary;
	}

	public String getFtpurl() {
		return ftpurl;
	}

	public void setFtpurl(String ftpurl) {
		this.ftpurl = ftpurl;
	}

	public List<String> getReservationphotoidList() {
		return reservationphotoidList;
	}

	public void setReservationphotoidList(List<String> reservationphotoidList) {
		this.reservationphotoidList = reservationphotoidList;
	}


	public String getReservationdate() {
		return reservationdate;
	}


	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}


	public String getConsultationdate() {
		return consultationdate;
	}


	public void setConsultationdate(String consultationdate) {
		this.consultationdate = consultationdate;
	}


	public String getConsultinghours() {
		return consultinghours;
	}


	public void setConsultinghours(String consultinghours) {
		this.consultinghours = consultinghours;
	}


	public String getGuid() {
		return guid;
	}


	public void setGuid(String guid) {
		this.guid = guid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getUsrids() {
		return usrids;
	}

	public void setUsrids(String usrids) {
		this.usrids = usrids;
	}


	public String getReserstarttime() {
		return reserstarttime;
	}


	public void setReserstarttime(String reserstarttime) {
		this.reserstarttime = reserstarttime;
	}


	public String getReserendtime() {
		return reserendtime;
	}


	public void setReserendtime(String reserendtime) {
		this.reserendtime = reserendtime;
	}
	
}
