package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.util.Date;

public class ExpireOrderReponse implements Serializable{

	/**
	 * 退订bean
	 */
	private static final long serialVersionUID = 1L;
	private String orderid;
	private String ConsultationId;
	private Date createdate;
	private Date consultationStartTime;
	private String paymentMethod;
	private String usrid;
	private String docid;
	private String thirdOrderCode;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getConsultationId() {
		return ConsultationId;
	}
	public void setConsultationId(String consultationId) {
		ConsultationId = consultationId;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getConsultationStartTime() {
		return consultationStartTime;
	}
	public void setConsultationStartTime(Date consultationStartTime) {
		this.consultationStartTime = consultationStartTime;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getUsrid() {
		return usrid;
	}
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getThirdOrderCode() {
		return thirdOrderCode;
	}
	public void setThirdOrderCode(String thirdOrderCode) {
		this.thirdOrderCode = thirdOrderCode;
	}
}
