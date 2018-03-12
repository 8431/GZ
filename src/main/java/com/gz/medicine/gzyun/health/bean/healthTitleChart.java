package com.gz.medicine.gzyun.health.bean;

public class healthTitleChart {
    private String id;

    private String titlecode;

    private String titlename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitlecode() {
        return titlecode;
    }

    public void setTitlecode(String titlecode) {
        this.titlecode = titlecode == null ? null : titlecode.trim();
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename == null ? null : titlename.trim();
    }
}