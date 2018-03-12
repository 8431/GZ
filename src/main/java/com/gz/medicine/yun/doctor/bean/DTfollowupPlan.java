package com.gz.medicine.yun.doctor.bean;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;


/**
 * 舵主
 * @author 随访计划
 *
 */
public class DTfollowupPlan {

    private String guid;

    private String org;
    private String docguid;
    private String usrguid;
    private String sicguid;
    private String followoption;
    private Date   followdatetime;
    private String followtime;

    private String followstate;

    private String crtusr;

    private Date crtdat;

    private String updateusr;

    private Date updatedate;

    /**
     * 删除标志
     */
    private String status;

    /**
     * 备注
     */
    private String remarks;

    List<DTfollowupPlan> dpLi;


    public String getFollowtime() {
        return followtime;
    }

    public void setFollowtime(String followtime) {
        this.followtime = followtime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid == null ? null : docguid.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getSicguid() {
        return sicguid;
    }

    public void setSicguid(String sicguid) {
        this.sicguid = sicguid == null ? null : sicguid.trim();
    }

    public String getFollowoption() {
        return followoption;
    }

    public void setFollowoption(String followoption) {
        this.followoption = followoption == null ? null : followoption.trim();
    }

    public Date getFollowdatetime() {
        return followdatetime;
    }

    public void setFollowdatetime(Date followdatetime) {
        this.followdatetime = followdatetime;
    }

    public String getFollowstate() {
        return followstate;
    }

    public void setFollowstate(String followstate) {
        this.followstate = followstate == null ? null : followstate.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getUpdateusr() {
        return updateusr;
    }

    public void setUpdateusr(String updateusr) {
        this.updateusr = updateusr == null ? null : updateusr.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DTfollowupPlan> getDpLi() {
        return dpLi;
    }

    public void setDpLi(List<DTfollowupPlan> dpLi) {
        this.dpLi = dpLi;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}