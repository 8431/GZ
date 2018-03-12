package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * 
 * @author 维维
 *         <p>
 *         Title:HealthConsultation
 *         </p>
 *         <p>
 *         Description:TODO(咨询信息表)
 *         </p>
 *         <p>
 *         Company:贯众
 *         </p>
 *         <p>
 *         数据库:HealthConsultation
 *         </p>
 * @author
 * @date 2017年9月21日
 */
public class HealthConsultation {

	private String id;

	private String orderid;

	private String messagesendcontent;// '短信发送内容';
	
	private Date messagesenddate;// '短信发送时间';

	private String phone;

	private String usrid;

	private String docid;

	private String consultingstate;

	private Date consultationstarttime;

	private Date consultationbookingtime;

	private String consultinghours;

	private String consultationsummary;

	private String state;

	private Date createdate;

	private String createname;

	private Date updatedate;

	private String updatename;
	
	private String messagename;
	
	private String messagetype;
	
	private String pushtime;
	
	private String startime;
	
	private String endtime;
	
	private String notreadnum;
	
	private String pushmessage;
	
	private String consultingdescription;
	
	private String reservationphotoid;
	
	private String orderstate;

	private Date onlinedate;	 //线上复诊时间

	private Date outpatientdate;   //门诊复诊时间


	public Date getMessagesenddate() {
		return messagesenddate;
	}

	public void setMessagesenddate(Date messagesenddate) {
		this.messagesenddate = messagesenddate;
	}

	public String getMessagesendcontent() {
		return messagesendcontent;
	}

	public void setMessagesendcontent(String messagesendcontent) {
		this.messagesendcontent = messagesendcontent;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid == null ? null : orderid.trim();
	}

	public String getUsrid() {
		return usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid == null ? null : usrid.trim();
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid == null ? null : docid.trim();
	}

	public String getConsultingstate() {
		return consultingstate;
	}

	public void setConsultingstate(String consultingstate) {
		this.consultingstate = consultingstate == null ? null : consultingstate.trim();
	}

	public Date getConsultationstarttime() {
		return consultationstarttime;
	}

	public void setConsultationstarttime(Date consultationstarttime) {
		this.consultationstarttime = consultationstarttime;
	}

	public Date getConsultationbookingtime() {
		return consultationbookingtime;
	}

	public void setConsultationbookingtime(Date consultationbookingtime) {
		this.consultationbookingtime = consultationbookingtime;
	}

	public String getConsultinghours() {
		return consultinghours;
	}

	public void setConsultinghours(String consultinghours) {
		this.consultinghours = consultinghours == null ? null : consultinghours.trim();
	}

	public String getConsultationsummary() {
		return consultationsummary;
	}

	public void setConsultationsummary(String consultationsummary) {
		this.consultationsummary = consultationsummary == null ? null : consultationsummary.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreatename() {
		return createname;
	}

	public void setCreatename(String createname) {
		this.createname = createname == null ? null : createname.trim();
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUpdatename() {
		return updatename;
	}

	public void setUpdatename(String updatename) {
		this.updatename = updatename == null ? null : updatename.trim();
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

	public String getNotreadnum() {
		return notreadnum;
	}

	public void setNotreadnum(String notreadnum) {
		this.notreadnum = notreadnum;
	}

	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getOrderstate() {
		return orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}


	public Date getOnlinedate() {
		return onlinedate;
	}

	public void setOnlinedate(Date onlinedate) {
		this.onlinedate = onlinedate;
	}

	public Date getOutpatientdate() {
		return outpatientdate;
	}

	public void setOutpatientdate(Date outpatientdate) {
		this.outpatientdate = outpatientdate;
	}
}