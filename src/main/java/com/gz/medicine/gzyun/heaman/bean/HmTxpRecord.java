package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;

/**
 * 
 * 
 * 尿酸bean层
 * @author Administrator
 *
 */
public class HmTxpRecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String toturiac;

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

    public String getToturiac() {
        return toturiac;
    }

    public void setToturiac(String toturiac) {
        this.toturiac = toturiac == null ? null : toturiac.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}