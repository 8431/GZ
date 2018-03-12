package com.gz.medicine.gzyun.heaman.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class HmGzjkSetTable implements Serializable {
    private static final long serialVersionUID = -8748562361024353688L;
    private String guid;

    private String packageid;

    private String packname;

    private BigDecimal packmon;

    private String packtype;

    private Date credat;

    private String favorable;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid == null ? null : packageid.trim();
    }

    public String getPackname() {
        return packname;
    }

    public void setPackname(String packname) {
        this.packname = packname == null ? null : packname.trim();
    }

    public BigDecimal getPackmon() {
        return packmon;
    }

    public void setPackmon(BigDecimal packmon) {
        this.packmon = packmon;
    }

    public String getPacktype() {
        return packtype;
    }

    public void setPacktype(String packtype) {
        this.packtype = packtype == null ? null : packtype.trim();
    }

    public Date getCredat() {
        return credat;
    }

    public void setCredat(Date credat) {
        this.credat = credat;
    }

    public String getFavorable() {
        return favorable;
    }

    public void setFavorable(String favorable) {
        this.favorable = favorable == null ? null : favorable.trim();
    }
}