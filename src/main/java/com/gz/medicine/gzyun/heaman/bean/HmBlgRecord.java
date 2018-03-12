package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;
/**
 * 血糖
 * 
 * **/
public class HmBlgRecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String blglu;

    private String state;

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

    public String getBlglu() {
        return blglu;
    }

    public void setBlglu(String blglu) {
        this.blglu = blglu == null ? null : blglu.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}