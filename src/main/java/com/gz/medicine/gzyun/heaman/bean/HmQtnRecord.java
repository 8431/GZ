package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;
/**
 * 问卷结果写入接口
 * @author Administrator
 *
 */
public class HmQtnRecord {
    private String guid;

    private String usrguid;// 患者guid

    private String sex;// 性别

    private String height;// 身高

    private String weight;// 体重

    private String isdiabete;// 是否糖尿病

    private String ishypert;// 是否高血压

    private String ishyperl;// 是否高血脂

    private String quesone;// 问题一

    private String questwo;// 问题二

    private String questhree;// 问题三

    private String quesfour;// 问题四

    private String quesfive;// 问题五

    private String quessix;// 问题六

  

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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

    public String getIsdiabete() {
        return isdiabete;
    }

    public void setIsdiabete(String isdiabete) {
        this.isdiabete = isdiabete == null ? null : isdiabete.trim();
    }

    public String getIshypert() {
        return ishypert;
    }

    public void setIshypert(String ishypert) {
        this.ishypert = ishypert == null ? null : ishypert.trim();
    }

    public String getIshyperl() {
        return ishyperl;
    }

    public void setIshyperl(String ishyperl) {
        this.ishyperl = ishyperl == null ? null : ishyperl.trim();
    }

    public String getQuesone() {
        return quesone;
    }

    public void setQuesone(String quesone) {
        this.quesone = quesone == null ? null : quesone.trim();
    }

    public String getQuestwo() {
        return questwo;
    }

    public void setQuestwo(String questwo) {
        this.questwo = questwo == null ? null : questwo.trim();
    }

    public String getQuesthree() {
        return questhree;
    }

    public void setQuesthree(String questhree) {
        this.questhree = questhree == null ? null : questhree.trim();
    }

    public String getQuesfour() {
        return quesfour;
    }

    public void setQuesfour(String quesfour) {
        this.quesfour = quesfour == null ? null : quesfour.trim();
    }

    public String getQuesfive() {
        return quesfive;
    }

    public void setQuesfive(String quesfive) {
        this.quesfive = quesfive == null ? null : quesfive.trim();
    }

    public String getQuessix() {
        return quessix;
    }

    public void setQuessix(String quessix) {
        this.quessix = quessix == null ? null : quessix.trim();
    }

  
}