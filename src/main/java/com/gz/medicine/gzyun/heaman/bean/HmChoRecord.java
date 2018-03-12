package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;
/**
 * 总胆固醇
 * **/
public class HmChoRecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String totchole;

    private Date crtdat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getMeatime() {
        return meatime;
    }

    public void setMeatime(String meatime) {
        this.meatime = meatime == null ? null : meatime.trim();
    }

    public String getTotchole() {
        return totchole;
    }

    public void setTotchole(String totchole) {
        this.totchole = totchole == null ? null : totchole.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}