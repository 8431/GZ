package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;
/**
 * 体温
 * **/
public class HmHeatrecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String heat;

    private String org;

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

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat == null ? null : heat.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}