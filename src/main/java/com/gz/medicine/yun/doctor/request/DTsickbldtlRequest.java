package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTsickbldtlRequest
 * @PackageName com.gz.medicine.yun.doctor.request
 * @Description 用药方案请求数据
 * @Data 2017-08-18 14:21
 **/
public class DTsickbldtlRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、药品名
    @NotEmpty(message="药品名drunam不能为空！")
    private String drunam;
    //2、规格
    @NotEmpty(message="规格unit不能为空！")
    private String unit;
    //3、数量
    @NotEmpty(message="数量numnit不能为空！")
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

    public String getNumnit() {
        return numnit;
    }

    public void setNumnit(String numnit) {
        this.numnit = numnit;
    }

    public String getPian() {
        return pian;
    }

    public void setPian(String pian) {
        this.pian = pian;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getKfwyname() {
        return kfwyname;
    }

    public void setKfwyname(String kfwyname) {
        this.kfwyname = kfwyname;
    }

    public DTsickbldtlRequest() {
    }

    public DTsickbldtlRequest(String drunam, String unit, String numnit, String pian, String pc, String kfwyname) {
        this.drunam = drunam;
        this.unit = unit;
        this.numnit = numnit;
        this.pian = pian;
        this.pc = pc;
        this.kfwyname = kfwyname;
    }

    @Override
    public String toString() {
        return "DTsickbldtlRequest{" +
                "drunam='" + drunam + '\'' +
                ", unit='" + unit + '\'' +
                ", numnit='" + numnit + '\'' +
                ", pian='" + pian + '\'' +
                ", pc='" + pc + '\'' +
                ", kfwyname='" + kfwyname + '\'' +
                '}';
    }
}
