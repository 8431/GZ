package com.gz.medicine.gzyun.heaman.bean;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

public class HmGzjkPermsgRecord implements Serializable {
    private static final long serialVersionUID = -1621234354630939455L;
    private String guid;
    @NotEmpty(message="usrguid不能为空！")
    private String usrguid;

    private String name;

    private String idcard;

    private String sex;

    private String age;

    private String mobile;

    private String urgencyname;

    private String urgencymobile;

    private String height;

    private String weight;

    private String xbs;

    private String xbsreplenish;

    private String jws;

    private String jwsreplenish;

    private String surgery;

    private String surgeryreplenish;

    private String drugallergy;

    private String dareplenish;

    private String foodallergy;

    private String fareplenish;

    private String livinghabits;

    private String lhreplenish;

    private String smoke;

    private String drink;

    private String marsta;

    private String healindex;

    private String fertility;

    private Date redate;
    //新增字段
    private Integer type;



    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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