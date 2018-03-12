package com.gz.medicine.yun.common.bean;

import java.util.Date;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName FromBlob
 * @PackageName com.gz.medicine.yun.common.bean
 * @Description 图片 实体类
 * @Data 2017-08-21 10:08
 **/

public class FromBlob {

    private String guid;

    private String grdid;

    private String sytid;

    private Date crtdat;

    private String fileurl;

    private String filename;

    private String formguid;

    private byte[] bdata;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getGrdid() {
        return grdid;
    }

    public void setGrdid(String grdid) {
        this.grdid = grdid == null ? null : grdid.trim();
    }

    public String getSytid() {
        return sytid;
    }

    public void setSytid(String sytid) {
        this.sytid = sytid == null ? null : sytid.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFormguid() {
        return formguid;
    }

    public void setFormguid(String formguid) {
        this.formguid = formguid == null ? null : formguid.trim();
    }

    public byte[] getBdata() {
        return bdata;
    }

    public void setBdata(byte[] bdata) {
        this.bdata = bdata;
    }
}