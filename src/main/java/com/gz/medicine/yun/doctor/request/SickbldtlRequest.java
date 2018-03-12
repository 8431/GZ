/**
 * projectName: GZYUN
 * fileName: SickbldtlRequest.java
 * packageName: com.gz.medicine.yun.doctor.request
 * date: 2017-12-24 19:50
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SickbldtlRequest
 * @packageName: com.gz.medicine.yun.doctor.request
 * @description: 用药方案
 * @data: 2017-12-24 19:50
 **/
public class SickbldtlRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    //1、药品名
    @NotEmpty(message="药品名drunam不能为空！")
    private String drunam;
    //2、规格
    @NotEmpty(message="规格unit不能为空！")
    private String unit;

    @NotEmpty(message="数量单位numnit不能为空！")
    private String numnit;
    //4、剂量
    @NotEmpty(message="剂量pian不能为空！")
    private String pian;
    //5、频次
    @NotEmpty(message="频次pc不能为空！")
    private String pc;
    //6、途径
    @NotEmpty(message="途径kfwyname不能为空！")
    private String kfwyname;


    private String guid;

    private BigDecimal seqid;

    private String formguid;

    private String druid;
    //3、数量
    @DecimalMin(value = "1",message = "数量ypnum不能为空！")
    private Integer ypnum;

    private String ci;

    private String day;

    private String kfwy;

    private String pcname;
    @NotEmpty(message="小剂量单位smlunt不能为空！")
    private String smlunt;

    private BigDecimal stPrice;

    private String stQty;


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
}
