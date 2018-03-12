package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTsickbldtlResponse
 * @PackageName com.gz.medicine.yun.doctor.reponse
 * @Description 用药方案响应数据
 * @Data 2017-08-19 11:07
 **/
public class DTsickbldtlResponse implements Serializable {


    private String guid;

    private Integer seqid;

    private String formguid;

    private String druid;

    private String drunam;

    private String unit;

    private Long ypnum;

    private String ci;

    private String pian;

    private String day;

    private String numnit;

    private String kfwy;

    private String pc;

    private String pcname;

    private String kfwyname;

    private String smlunt;

    private Integer stPrice;

    private String stQty;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

    public String getFormguid() {
        return formguid;
    }

    public void setFormguid(String formguid) {
        this.formguid = formguid;
    }

    public String getDruid() {
        return druid;
    }

    public void setDruid(String druid) {
        this.druid = druid;
    }

    public String getDrunam() {
        return drunam;
    }

    public void setDrunam(String drunam) {
        this.drunam = drunam;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getYpnum() {
        return ypnum;
    }

    public void setYpnum(Long ypnum) {
        this.ypnum = ypnum;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPian() {
        return pian;
    }

    public void setPian(String pian) {
        this.pian = pian;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNumnit() {
        return numnit;
    }

    public void setNumnit(String numnit) {
        this.numnit = numnit;
    }

    public String getKfwy() {
        return kfwy;
    }

    public void setKfwy(String kfwy) {
        this.kfwy = kfwy;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname;
    }

    public String getKfwyname() {
        return kfwyname;
    }

    public void setKfwyname(String kfwyname) {
        this.kfwyname = kfwyname;
    }

    public String getSmlunt() {
        return smlunt;
    }

    public void setSmlunt(String smlunt) {
        this.smlunt = smlunt;
    }

    public Integer getStPrice() {
        return stPrice;
    }

    public void setStPrice(Integer stPrice) {
        this.stPrice = stPrice;
    }

    public String getStQty() {
        return stQty;
    }

    public void setStQty(String stQty) {
        this.stQty = stQty;
    }

    public DTsickbldtlResponse() {
    }

    public DTsickbldtlResponse(String guid, Integer seqid, String formguid, String druid, String drunam, String unit, Long ypnum, String ci, String pian, String day, String numnit, String kfwy, String pc, String pcname, String kfwyname, String smlunt, Integer stPrice, String stQty) {
        this.guid = guid;
        this.seqid = seqid;
        this.formguid = formguid;
        this.druid = druid;
        this.drunam = drunam;
        this.unit = unit;
        this.ypnum = ypnum;
        this.ci = ci;
        this.pian = pian;
        this.day = day;
        this.numnit = numnit;
        this.kfwy = kfwy;
        this.pc = pc;
        this.pcname = pcname;
        this.kfwyname = kfwyname;
        this.smlunt = smlunt;
        this.stPrice = stPrice;
        this.stQty = stQty;
    }

    @Override
    public String toString() {
        return "DTsickbldtlResponse{" +
                "guid='" + guid + '\'' +
                ", seqid=" + seqid +
                ", formguid='" + formguid + '\'' +
                ", druid='" + druid + '\'' +
                ", drunam='" + drunam + '\'' +
                ", unit='" + unit + '\'' +
                ", ypnum=" + ypnum +
                ", ci='" + ci + '\'' +
                ", pian='" + pian + '\'' +
                ", day='" + day + '\'' +
                ", numnit='" + numnit + '\'' +
                ", kfwy='" + kfwy + '\'' +
                ", pc='" + pc + '\'' +
                ", pcname='" + pcname + '\'' +
                ", kfwyname='" + kfwyname + '\'' +
                ", smlunt='" + smlunt + '\'' +
                ", stPrice=" + stPrice +
                ", stQty='" + stQty + '\'' +
                '}';
    }
}
