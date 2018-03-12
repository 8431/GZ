package com.gz.medicine.yun.common.bean;

import java.util.Date;
/**
 * @version V1.0
 * @Author fendo
 * @ClassName FromBlob
 * @PackageName com.gz.medicine.yun.common.bean
 * @Description 短信记录
 * @Data 2017-08-21 10:08
 **/
public class SmsrdLog {

    private String guid;

    private String phone;

    private String type;

    private String platform;

    private String note;

    private Date crtdat;

    private String hospital;

    private String ipaddr;

    private String verifcode;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    public String getVerifcode() {
        return verifcode;
    }

    public void setVerifcode(String verifcode) {
        this.verifcode = verifcode == null ? null : verifcode.trim();
    }
}