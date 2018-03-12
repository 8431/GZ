package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

public class DTmonthwork {
    private String guid;

    private String crtusr;

    private String morning;

    private String afternoon;

    private String org;

    private Short ordernum;

    private Short usernum;

    private Short ordernumaf;

    private Short usernumaf;

    private String morning1;

    private String morning2;

    private String afternoon1;

    private String afternoon2;

    private String doc;

    private String docxw;

    private String dat;

    private String docswnam;

    private String docxwnam;

    private Date crtdat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning == null ? null : morning.trim();
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon == null ? null : afternoon.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public Short getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Short ordernum) {
        this.ordernum = ordernum;
    }

    public Short getUsernum() {
        return usernum;
    }

    public void setUsernum(Short usernum) {
        this.usernum = usernum;
    }

    public Short getOrdernumaf() {
        return ordernumaf;
    }

    public void setOrdernumaf(Short ordernumaf) {
        this.ordernumaf = ordernumaf;
    }

    public Short getUsernumaf() {
        return usernumaf;
    }

    public void setUsernumaf(Short usernumaf) {
        this.usernumaf = usernumaf;
    }

    public String getMorning1() {
        return morning1;
    }

    public void setMorning1(String morning1) {
        this.morning1 = morning1 == null ? null : morning1.trim();
    }

    public String getMorning2() {
        return morning2;
    }

    public void setMorning2(String morning2) {
        this.morning2 = morning2 == null ? null : morning2.trim();
    }

    public String getAfternoon1() {
        return afternoon1;
    }

    public void setAfternoon1(String afternoon1) {
        this.afternoon1 = afternoon1 == null ? null : afternoon1.trim();
    }

    public String getAfternoon2() {
        return afternoon2;
    }

    public void setAfternoon2(String afternoon2) {
        this.afternoon2 = afternoon2 == null ? null : afternoon2.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public String getDocxw() {
        return docxw;
    }

    public void setDocxw(String docxw) {
        this.docxw = docxw == null ? null : docxw.trim();
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat == null ? null : dat.trim();
    }

    public String getDocswnam() {
        return docswnam;
    }

    public void setDocswnam(String docswnam) {
        this.docswnam = docswnam == null ? null : docswnam.trim();
    }

    public String getDocxwnam() {
        return docxwnam;
    }

    public void setDocxwnam(String docxwnam) {
        this.docxwnam = docxwnam == null ? null : docxwnam.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}