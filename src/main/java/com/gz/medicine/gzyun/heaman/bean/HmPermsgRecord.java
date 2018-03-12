package com.gz.medicine.gzyun.heaman.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 健康指数
 * jin
 * **/
public class HmPermsgRecord implements Serializable {

    private static final long serialVersionUID = 2407442056134030333L;
    private String guid;

    private String usrguid;

    private String name;//姓名

    private String idcard;//身份证

    private String sex;//性别

    private String age;//年龄

    private String mobile;//电话

    private String urgencyname;//紧急联系人姓名

    private String urgencymobile;//紧急联系人电话

    private String height;//身高

    private String weight;//体重

    private String xbs;//病史

    private String xbsreplenish;

    private String jws;//既往史

    private String jwsreplenish;

    private String surgery;//手术和外伤

    private String surgeryreplenish;

    private String drugallergy;//药物过敏

    private String dareplenish;

    private String foodallergy;//食物过敏

    private String fareplenish;

    private String livinghabits;//其他生活状态

    private String lhreplenish;

    private String smoke;//吸烟

    private String drink;//饮酒

    private String marsta;

    private String healindex;

    private String fertility;

    private Date redate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getUrgencyname() {
        return urgencyname;
    }

    public void setUrgencyname(String urgencyname) {
        this.urgencyname = urgencyname == null ? null : urgencyname.trim();
    }

    public String getUrgencymobile() {
        return urgencymobile;
    }

    public void setUrgencymobile(String urgencymobile) {
        this.urgencymobile = urgencymobile == null ? null : urgencymobile.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getXbs() {
        return xbs;
    }

    public void setXbs(String xbs) {
        this.xbs = xbs == null ? null : xbs.trim();
    }

    public String getXbsreplenish() {
        return xbsreplenish;
    }

    public void setXbsreplenish(String xbsreplenish) {
        this.xbsreplenish = xbsreplenish == null ? null : xbsreplenish.trim();
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws == null ? null : jws.trim();
    }

    public String getJwsreplenish() {
        return jwsreplenish;
    }

    public void setJwsreplenish(String jwsreplenish) {
        this.jwsreplenish = jwsreplenish == null ? null : jwsreplenish.trim();
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery == null ? null : surgery.trim();
    }

    public String getSurgeryreplenish() {
        return surgeryreplenish;
    }

    public void setSurgeryreplenish(String surgeryreplenish) {
        this.surgeryreplenish = surgeryreplenish == null ? null : surgeryreplenish.trim();
    }

    public String getDrugallergy() {
        return drugallergy;
    }

    public void setDrugallergy(String drugallergy) {
        this.drugallergy = drugallergy == null ? null : drugallergy.trim();
    }

    public String getDareplenish() {
        return dareplenish;
    }

    public void setDareplenish(String dareplenish) {
        this.dareplenish = dareplenish == null ? null : dareplenish.trim();
    }

    public String getFoodallergy() {
        return foodallergy;
    }

    public void setFoodallergy(String foodallergy) {
        this.foodallergy = foodallergy == null ? null : foodallergy.trim();
    }

    public String getFareplenish() {
        return fareplenish;
    }

    public void setFareplenish(String fareplenish) {
        this.fareplenish = fareplenish == null ? null : fareplenish.trim();
    }

    public String getLivinghabits() {
        return livinghabits;
    }

    public void setLivinghabits(String livinghabits) {
        this.livinghabits = livinghabits == null ? null : livinghabits.trim();
    }

    public String getLhreplenish() {
        return lhreplenish;
    }

    public void setLhreplenish(String lhreplenish) {
        this.lhreplenish = lhreplenish == null ? null : lhreplenish.trim();
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke == null ? null : smoke.trim();
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink == null ? null : drink.trim();
    }

    public String getMarsta() {
        return marsta;
    }

    public void setMarsta(String marsta) {
        this.marsta = marsta == null ? null : marsta.trim();
    }

    public String getHealindex() {
        return healindex;
    }

    public void setHealindex(String healindex) {
        this.healindex = healindex == null ? null : healindex.trim();
    }

    public String getFertility() {
        return fertility;
    }

    public void setFertility(String fertility) {
        this.fertility = fertility == null ? null : fertility.trim();
    }

    public Date getRedate() {
        return redate;
    }

    public void setRedate(Date redate) {
        this.redate = redate;
    }
}