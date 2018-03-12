package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * 排班时段表实体类
 * @author duozhu
 *
 */
public class HealthyIntervalTime {
    private String id;

    private String doctorformid;

    private String intervaldate;

    private String state;

    private Date createdate;

    private String createname;

    private Date updatedate;

    private String updatename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDoctorformid() {
        return doctorformid;
    }

    public void setDoctorformid(String doctorformid) {
        this.doctorformid = doctorformid == null ? null : doctorformid.trim();
    }

    public String getIntervaldate() {
        return intervaldate;
    }

    public void setIntervaldate(String intervaldate) {
        this.intervaldate = intervaldate == null ? null : intervaldate.trim();
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