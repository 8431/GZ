package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

/**
 *
 * @Title: DTdru.java
 * @Package com.gz.medicine.yun.doctor.bean
 * @Description: 药品类
 * @Author fendo
 * @Date 2017年8月17日 上午10:15
 * @Version V1.0
 */
public class DTdru {

    private String id;

    private String name;

    private String sp;

    private String unit;

    private String corp;

    private String guid;

    private String acc;

    private String org;

    private String syt;

    private String crtdat;

    private String yfid;

    private String minqty;

    private String minun;

    private String maxqty;

    private String maxun;

    private String useflg;

    private String seqid;

    private String refcorp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp == null ? null : corp.trim();
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getSyt() {
        return syt;
    }

    public void setSyt(String syt) {
        this.syt = syt == null ? null : syt.trim();
    }

    public String getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(String crtdat) {
        this.crtdat = crtdat;
    }

    public String getYfid() {
        return yfid;
    }

    public void setYfid(String yfid) {
        this.yfid = yfid == null ? null : yfid.trim();
    }

    public String getMinqty() {
        return minqty;
    }

    public void setMinqty(String minqty) {
        this.minqty = minqty == null ? null : minqty.trim();
    }

    public String getMinun() {
        return minun;
    }

    public void setMinun(String minun) {
        this.minun = minun == null ? null : minun.trim();
    }

    public String getMaxqty() {
        return maxqty;
    }

    public void setMaxqty(String maxqty) {
        this.maxqty = maxqty == null ? null : maxqty.trim();
    }

    public String getMaxun() {
        return maxun;
    }

    public void setMaxun(String maxun) {
        this.maxun = maxun == null ? null : maxun.trim();
    }

    public String getUseflg() {
        return useflg;
    }

    public void setUseflg(String useflg) {
        this.useflg = useflg == null ? null : useflg.trim();
    }

    public String getSeqid() {
        return seqid;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid == null ? null : seqid.trim();
    }

    public String getRefcorp() {
        return refcorp;
    }

    public void setRefcorp(String refcorp) {
        this.refcorp = refcorp == null ? null : refcorp.trim();
    }

    public DTdru() {
    }

    public DTdru(String id, String name, String sp, String unit, String corp, String guid, String acc, String org, String syt, String crtdat, String yfid, String minqty, String minun, String maxqty, String maxun, String useflg, String seqid, String refcorp) {
        this.id = id;
        this.name = name;
        this.sp = sp;
        this.unit = unit;
        this.corp = corp;
        this.guid = guid;
        this.acc = acc;
        this.org = org;
        this.syt = syt;
        this.crtdat = crtdat;
        this.yfid = yfid;
        this.minqty = minqty;
        this.minun = minun;
        this.maxqty = maxqty;
        this.maxun = maxun;
        this.useflg = useflg;
        this.seqid = seqid;
        this.refcorp = refcorp;
    }

    @Override
    public String toString() {
        return "DTdru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sp='" + sp + '\'' +
                ", unit='" + unit + '\'' +
                ", corp='" + corp + '\'' +
                ", guid='" + guid + '\'' +
                ", acc='" + acc + '\'' +
                ", org='" + org + '\'' +
                ", syt='" + syt + '\'' +
                ", crtdat=" + crtdat +
                ", yfid='" + yfid + '\'' +
                ", minqty='" + minqty + '\'' +
                ", minun='" + minun + '\'' +
                ", maxqty='" + maxqty + '\'' +
                ", maxun='" + maxun + '\'' +
                ", useflg='" + useflg + '\'' +
                ", seqid='" + seqid + '\'' +
                ", refcorp='" + refcorp + '\'' +
                '}';
    }
}