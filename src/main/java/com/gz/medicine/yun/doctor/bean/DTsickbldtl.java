package com.gz.medicine.yun.doctor.bean;

import java.math.BigDecimal;

/**
 *
 * @Title: DTsickbldtl.java
 * @Package com.gz.medicine.yun.doctor.bean
 * @Description: 用药方案
 * @Author fendo
 * @Date 2017年8月17日 上午10:15
 * @Version V1.0
 */
public class DTsickbldtl {


    private String guid;

    private BigDecimal seqid;

    private String formguid;

    private String druid;

    private String drunam;

    private String unit;

    private Integer ypnum;

    private String ci;

    private String pian;

    private String day;

    private String numnit;

    private String kfwy;

    private String pc;

    private String pcname;

    private String kfwyname;

    private String smlunt;

    private BigDecimal stPrice;

    private String stQty;

    /**
     * 删除标志位 1未删除 0已删除
     */
    private String state;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public BigDecimal getSeqid() {
        return seqid;
    }

    public void setSeqid(BigDecimal seqid) {
        this.seqid = seqid;
    }

    public String getFormguid() {
        return formguid;
    }

    public void setFormguid(String formguid) {
        this.formguid = formguid == null ? null : formguid.trim();
    }

    public String getDruid() {
        return druid;
    }

    public void setDruid(String druid) {
        this.druid = druid == null ? null : druid.trim();
    }

    public String getDrunam() {
        return drunam;
    }

    public void setDrunam(String drunam) {
        this.drunam = drunam == null ? null : drunam.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getYpnum() {
        return ypnum;
    }

    public void setYpnum(Integer ypnum) {
        this.ypnum = ypnum;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci == null ? null : ci.trim();
    }

    public String getPian() {
        return pian;
    }

    public void setPian(String pian) {
        this.pian = pian == null ? null : pian.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getNumnit() {
        return numnit;
    }

    public void setNumnit(String numnit) {
        this.numnit = numnit == null ? null : numnit.trim();
    }

    public String getKfwy() {
        return kfwy;
    }

    public void setKfwy(String kfwy) {
        this.kfwy = kfwy == null ? null : kfwy.trim();
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc == null ? null : pc.trim();
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname == null ? null : pcname.trim();
    }

    public String getKfwyname() {
        return kfwyname;
    }

    public void setKfwyname(String kfwyname) {
        this.kfwyname = kfwyname == null ? null : kfwyname.trim();
    }

    public String getSmlunt() {
        return smlunt;
    }

    public void setSmlunt(String smlunt) {
        this.smlunt = smlunt == null ? null : smlunt.trim();
    }

    public BigDecimal getStPrice() {
        return stPrice;
    }

    public void setStPrice(BigDecimal stPrice) {
        this.stPrice = stPrice;
    }

    public String getStQty() {
        return stQty;
    }

    public void setStQty(String stQty) {
        this.stQty = stQty == null ? null : stQty.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}