package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;

public class HmGzjkReport {
    private String guid;

    private String usrguid;

    private String state;

    private String title;

    private Date time;

    private String assess;

    private String scheme;

    private String summarize;

    private String jdusr;

    private String jddate;

    private Date crtdat;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess == null ? null : assess.trim();
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme == null ? null : scheme.trim();
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize == null ? null : summarize.trim();
    }

    public String getJdusr() {
        return jdusr;
    }

    public void setJdusr(String jdusr) {
        this.jdusr = jdusr == null ? null : jdusr.trim();
    }

    public String getJddate() {
        return jddate;
    }

    public void setJddate(String jddate) {
        this.jddate = jddate == null ? null : jddate.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}