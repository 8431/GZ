package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;

/**
 * 血压接口
 * 舵主
 * @author Administrator
 *
 */
public class HmBlpRecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String diablopre;

    private String sysblopre;

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

    public String getDiablopre() {
        return diablopre;
    }

    public void setDiablopre(String diablopre) {
        this.diablopre = diablopre == null ? null : diablopre.trim();
    }

    public String getSysblopre() {
        return sysblopre;
    }

    public void setSysblopre(String sysblopre) {
        this.sysblopre = sysblopre == null ? null : sysblopre.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}