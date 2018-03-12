package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;

/**
 * 心电接口
 * 舵主
 * @author Administrator
 *
 */
public class HmEcgRecord {
    private String guid;

    private String usrguid;

    private String meatime;

    private String hearate;

    private String brerate;

    private String meadurof;

    private String heabeat;

    private String roomearly;

    private String preearly;

    private String maxhearate;

    private String minhearate;

    private String refid;

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

    public String getHearate() {
        return hearate;
    }

    public void setHearate(String hearate) {
        this.hearate = hearate == null ? null : hearate.trim();
    }

    public String getBrerate() {
        return brerate;
    }

    public void setBrerate(String brerate) {
        this.brerate = brerate == null ? null : brerate.trim();
    }

    public String getMeadurof() {
        return meadurof;
    }

    public void setMeadurof(String meadurof) {
        this.meadurof = meadurof == null ? null : meadurof.trim();
    }

    public String getHeabeat() {
        return heabeat;
    }

    public void setHeabeat(String heabeat) {
        this.heabeat = heabeat == null ? null : heabeat.trim();
    }

    public String getRoomearly() {
        return roomearly;
    }

    public void setRoomearly(String roomearly) {
        this.roomearly = roomearly == null ? null : roomearly.trim();
    }

    public String getPreearly() {
        return preearly;
    }

    public void setPreearly(String preearly) {
        this.preearly = preearly == null ? null : preearly.trim();
    }

    public String getMaxhearate() {
        return maxhearate;
    }

    public void setMaxhearate(String maxhearate) {
        this.maxhearate = maxhearate == null ? null : maxhearate.trim();
    }

    public String getMinhearate() {
        return minhearate;
    }

    public void setMinhearate(String minhearate) {
        this.minhearate = minhearate == null ? null : minhearate.trim();
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}