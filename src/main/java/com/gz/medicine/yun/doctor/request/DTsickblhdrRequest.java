package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTsickblhdrRequest
 * @PackageName com.gz.medicine.yun.doctor.request
 * @Description 病历请求数据
 * @Data 2017-08-18 14:17
 **/
public class DTsickblhdrRequest implements Serializable {


    //患者ID
    @NotEmpty(message = "患者guid不能为空！")
    private String guid;

    //1、患者姓名
    @NotEmpty(message="患者姓名name不能为空！")
    private String name;
    //2、性别
    @NotEmpty(message="性别sex不能为空！")
    private String sex;
    //3、出生年月
    @NotEmpty(message="出生年月birthday不能为空！")
    private String birthday;
    //4、医保卡号
    @NotEmpty(message="医保卡号cardid不能为空！")
    private String cardid;
    //5、就诊卡号
    @NotEmpty(message="就诊卡号medicalid不能为空！")
    private String medicalid;

    //6、主诉
    @NotEmpty(message="主诉mainn不能为空！")
    private String mainn;

    //7、既往史
    @NotEmpty(message="既往史jws不能为空！")
    private String jws;

    //8、诊断
    @NotEmpty(message="诊断zhand不能为空！")
    private String zhand;

    @NotEmpty(message = "医生ID不能为空")
    private String docguid;

    private String doc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(String medicalid) {
        this.medicalid = medicalid;
    }

    public String getMainn() {
        return mainn;
    }

    public void setMainn(String mainn) {
        this.mainn = mainn;
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws;
    }

    public String getZhand() {
        return zhand;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setZhand(String zhand) {
        this.zhand = zhand;
    }


    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public DTsickblhdrRequest() {
    }



}

