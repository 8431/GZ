package com.gz.medicine.gzyun.heaman.bean;

import java.io.Serializable;

/**
 * Created by dlf on 2017/8/8 0008.
 */
public class HmReportVo implements Serializable{
    private static final long serialVersionUID = 7779166366834440015L;
    private String scheme;
    private String assess;
    private String jdusr;
    private String jddate;
    private String name;
    private String sex;
    private String age;
    private String usrguid;
    private String guid;
    private String jdusrnam;
    private String summarize;

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public String getJdusr() {
        return jdusr;
    }

    public void setJdusr(String jdusr) {
        this.jdusr = jdusr;
    }

    public String getJdusrnam() {
        return jdusrnam;
    }

    public void setJdusrnam(String jdusrnam) {
        this.jdusrnam = jdusrnam;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public String getJddate() {
        return jddate;
    }

    public void setJddate(String jddate) {
        this.jddate = jddate;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
