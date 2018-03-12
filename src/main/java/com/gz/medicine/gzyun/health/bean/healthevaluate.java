package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

public class healthevaluate {
    private String id;

    private String docid;

    private String usrid;

    private String score;

    private String consultationid;

    private String evaluationdescription;

    private String state;

    private Date createdate;

    private String remark;

    private String createname;

    private String usrname;
    
    private Date updatedate;

    private String updatename;

    private String orderid;
    
    public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
        if(Integer.parseInt( this.score)>=5){
            this.score="5";
        }
        if(Integer.parseInt( this.score)<=0){
            this.score="0";
        }
    }

    public String getConsultationid() {
        return consultationid;
    }

    public void setConsultationid(String consultationid) {
        this.consultationid = consultationid == null ? null : consultationid.trim();
    }

    public String getEvaluationdescription() {
        return evaluationdescription;
    }

    public void setEvaluationdescription(String evaluationdescription) {
        this.evaluationdescription = evaluationdescription == null ? null : evaluationdescription.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
    
}