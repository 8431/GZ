package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

/**
 * 
 *随访项目
 * @author 维维
 *
 */
public class DTfollowupOption {
    private String guid;//内部唯一编号';

    private String org;//系统编号';

    private String followoptionid;//'随访项目编号';

    private String followoption;//随访项目

    private String followoptiondesc;//随访项目描述

    private String crtusr;//创建人'

    private Date crtdat;//创建时间

    private String updateusr;//更新人

    private Date updatedate;//更新时间


    private String status;  //删除标志位

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

    public String getFollowoptionid() {
        return followoptionid;
    }

    public void setFollowoptionid(String followoptionid) {
        this.followoptionid = followoptionid == null ? null : followoptionid.trim();
    }

    public String getFollowoption() {
        return followoption;
    }

    public void setFollowoption(String followoption) {
        this.followoption = followoption == null ? null : followoption.trim();
    }

    public String getFollowoptiondesc() {
        return followoptiondesc;
    }

    public void setFollowoptiondesc(String followoptiondesc) {
        this.followoptiondesc = followoptiondesc == null ? null : followoptiondesc.trim();
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
}