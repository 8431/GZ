package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

public class DTdocpl {
    private String guid;

    private String myid;

    private String crtusr;

    private String star;

    private String content;

    private Date dat;
    
    private String imgguid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getMyid() {
        return myid;
    }

    public void setMyid(String myid) {
        this.myid = myid == null ? null : myid.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

	public String getImgguid() {
		return imgguid;
	}

	public void setImgguid(String imgguid) {
		this.imgguid = imgguid;
	}
    
    
}