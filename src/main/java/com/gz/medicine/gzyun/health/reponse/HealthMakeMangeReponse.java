package com.gz.medicine.gzyun.health.reponse;
/**
 * 预约管理 输出实体类
 * @author 舵主
 *
 * 下午2:07:18
 */
public class HealthMakeMangeReponse {
	// 订单ID
	private String orderid;
	
	// 预约日期
	private String reservationdate;
	
	// 时段
	private String intervaldate;
	
	// 患者姓名
	private String usrname;
	
	
	// 患者guid
	private String usrid;
	
	// 性别
	private String sex;
	
	// 年龄	
	private String age;
	
	//  咨询方式
	private String consultationmethod;
	
	// 咨询状态
	private String consultingstate;

	// 医生名字
	private String docname;

	// 患者手机号
	private String usrphone;

	// 医生id
	private String docid;
	
	private String reservationtime;
	
	private String sendstatus;

	public String getSendstatus() {
		return sendstatus;
	}

	public void setSendstatus(String sendstatus) {
		this.sendstatus = sendstatus;
	}

	public String getReservationtime() {
		return reservationtime;
	}

	public void setReservationtime(String reservationtime) {
		this.reservationtime = reservationtime;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}

	public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getConsultationmethod() {
		return consultationmethod;
	}

	public void setConsultationmethod(String consultationmethod) {
		this.consultationmethod = consultationmethod;
	}

	public String getConsultingstate() {
		return consultingstate;
	}

	public void setConsultingstate(String consultingstate) {
		this.consultingstate = consultingstate;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getUsrphone() {
		return usrphone;
	}

	public void setUsrphone(String usrphone) {
		this.usrphone = usrphone;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	@Override
	public String toString() {
		return "HealthMakeMangeReponse [orderid=" + orderid + ", reservationdate=" + reservationdate + ", intervaldate="
				+ intervaldate + ", usrname=" + usrname + ", usrid=" + usrid + ", sex=" + sex + ", age=" + age
				+ ", consultationmethod=" + consultationmethod + ", consultingstate=" + consultingstate + ", docname="
				+ docname + ", usrphone=" + usrphone + ", docid=" + docid + ", reservationtime=" + reservationtime
				+ ", sendstatus=" + sendstatus + "]";
	}



	

	
	
	


}
