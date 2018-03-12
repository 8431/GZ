package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * 医生排班表实体类
 * @author duozhu
 *
 */
public class HealthyDoctorform {
    private String id;

    private String docid;

    private String healthytypesettingtime;

    private String state;

    private Date createdate;

    private String createname;

    private Date updatedate;

    private String updatename;
    
    private String intervaldate;
    
    

    public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
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

    public String getHealthytypesettingtime() {
        return healthytypesettingtime;
    }

    public void setHealthytypesettingtime(String healthytypesettingtime) {
        this.healthytypesettingtime = healthytypesettingtime;
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
}