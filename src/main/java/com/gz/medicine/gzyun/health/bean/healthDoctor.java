package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHDOCTOR表的实体类
 * @Description 医生表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 17:32:15
 */
public class healthDoctor {

    private String id;

    private String loginid;

    private String name;

    private String titlecode;

    private String begood;

    private String photoid;

    private String qualificationsid;

    private String perintroduction;

    private String trainingexperience;

    private String state;

    private Date createdate;

    private String createname;

    private Date updatedate;

    private String updatename;

    /**
     * 手机号
     */
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid == null ? null : loginid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitlecode() {
        return titlecode;
    }

    public void setTitlecode(String titlecode) {
        this.titlecode = titlecode == null ? null : titlecode.trim();
    }

    public String getBegood() {
        return begood;
    }

    public void setBegood(String begood) {
        this.begood = begood == null ? null : begood.trim();
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid == null ? null : photoid.trim();
    }

    public String getQualificationsid() {
        return qualificationsid;
    }

    public void setQualificationsid(String qualificationsid) {
        this.qualificationsid = qualificationsid == null ? null : qualificationsid.trim();
    }

    public String getPerintroduction() {
        return perintroduction;
    }

    public void setPerintroduction(String perintroduction) {
        this.perintroduction = perintroduction == null ? null : perintroduction.trim();
    }

    public String getTrainingexperience() {
        return trainingexperience;
    }

    public void setTrainingexperience(String trainingexperience) {
        this.trainingexperience = trainingexperience == null ? null : trainingexperience.trim();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}