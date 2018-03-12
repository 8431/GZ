package com.gz.medicine.gzyun.yidiagnosis.bean;

import java.util.Date;

public class YGchisJwslog {
    private String guid;

    private String blguid;

    private Date crtdat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getBlguid() {
        return blguid;
    }

    public void setBlguid(String blguid) {
        this.blguid = blguid == null ? null : blguid.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}