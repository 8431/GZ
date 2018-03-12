package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTdruResponse
 * @PackageName com.gz.medicine.yun.doctor.reponse
 * @Description 药品响应数据
 * @Data 2017-08-18 9:52
 **/
public class DTdruResponse implements Serializable {

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

    private String spec;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSyt() {
        return syt;
    }

    public void setSyt(String syt) {
        this.syt = syt;
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
        this.yfid = yfid;
    }

    public String getMinqty() {
        return minqty;
    }

    public void setMinqty(String minqty) {
        this.minqty = minqty;
    }

    public String getMinun() {
        return minun;
    }

    public void setMinun(String minun) {
        this.minun = minun;
    }

    public String getMaxqty() {
        return maxqty;
    }

    public void setMaxqty(String maxqty) {
        this.maxqty = maxqty;
    }

    public String getMaxun() {
        return maxun;
    }

    public void setMaxun(String maxun) {
        this.maxun = maxun;
    }

    public String getUseflg() {
        return useflg;
    }

    public void setUseflg(String useflg) {
        this.useflg = useflg;
    }

    public String getSeqid() {
        return seqid;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid;
    }

    public String getRefcorp() {
        return refcorp;
    }

    public void setRefcorp(String refcorp) {
        this.refcorp = refcorp;
    }

    public DTdruResponse() {
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public DTdruResponse(String id, String name, String sp, String unit, String corp, String guid, String acc, String org, String syt, String crtdat, String yfid, String minqty, String minun, String maxqty, String maxun, String useflg, String seqid, String refcorp, String spec) {
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
        this.spec = spec;
    }
}
