package com.gz.medicine.gzyun.health.request;

import java.util.Date;

public class HealthConsultationRequest {
 
	private String consultationid;

    private String orderid;

    private String usrid;

    private String docid;

    private String consultingstate;

    private String consultationstarttime;

    private Date consultationbookingtime;

    private String consultinghours;

    private String consultationsummary;

    private String state;

    private String createdate;

    private String createname;

    private String updatedate;

    private String updatename;
    
    
    public HealthConsultationRequest() {
		// TODO Auto-generated constructor stub
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


	public String getConsultingstate() {
		return consultingstate;
	}


	public void setConsultingstate(String consultingstate) {
		this.consultingstate = consultingstate;
	}


	public String getConsultationstarttime() {
		return consultationstarttime;
	}


	public void setConsultationstarttime(String consultationstarttime) {
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
		this.consultinghours = consultinghours;
	}


	public String getConsultationsummary() {
		return consultationsummary;
	}


	public void setConsultationsummary(String consultationsummary) {
		this.consultationsummary = consultationsummary;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	


	public String getCreatedate() {
		return createdate;
	}


	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}


	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}


	public String getCreatename() {
		return createname;
	}


	public void setCreatename(String createname) {
		this.createname = createname;
	}
 
	


	public String getUpdatedate() {
		return updatedate;
	}


	public String getUpdatename() {
		return updatename;
	}


	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
    
    
    
}
