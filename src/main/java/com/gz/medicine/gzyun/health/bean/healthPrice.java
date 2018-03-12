package com.gz.medicine.gzyun.health.bean;

import java.math.BigDecimal;
import java.util.Date;

public class healthPrice {

    private String id;

    private String docid;

    private String graphicprice;

    private String speechprice;

    private String videoprice;

    private String state;

    private Date createdate;

    private Date updatedate;

    private String createname;

    private String updatename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    public String getGraphicprice() {
        return graphicprice;
    }

    public void setGraphicprice(String graphicprice) {
        this.graphicprice = graphicprice;
    }

    public String getSpeechprice() {
        return speechprice;
    }

    public void setSpeechprice(String speechprice) {
        this.speechprice = speechprice;
    }

    public String getVideoprice() {
        return videoprice;
    }

    public void setVideoprice(String videoprice) {
        this.videoprice = videoprice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }
}