package com.gz.medicine.gzyun.health.bean;

import com.gz.medicine.gzyun.health.request.HealthPushMessageVo;

import java.util.Date;

public class OrderLog {

    private String id;

    private Date operatingtime;

    private String orderid;

    private String operationaccount;

    private String operationcontent;

    private Date createdate;

    private String createname;

    private Date updatedate;

    private String updatename;

    private boolean qxdd=false;

    /**
     * 订单状态
     */
    private String orderstate;
    private HealthPushMessageVo healthpushmessagevo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getOperatingtime() {
        return operatingtime;
    }

    public void setOperatingtime(Date operatingtime) {
        this.operatingtime = operatingtime;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getOperationaccount() {
        return operationaccount;
    }

    public void setOperationaccount(String operationaccount) {
        this.operationaccount = operationaccount == null ? null : operationaccount.trim();
    }

    public String getOperationcontent() {
        return operationcontent;
    }

    public void setOperationcontent(String operationcontent) {
        this.operationcontent = operationcontent == null ? null : operationcontent.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public HealthPushMessageVo getHealthpushmessagevo() {
        return healthpushmessagevo;
    }

    public void setHealthpushmessagevo(HealthPushMessageVo healthpushmessagevo) {
        this.healthpushmessagevo = healthpushmessagevo;
    }

    public boolean getQxdd() {
        return qxdd;
    }

    public void setQxdd(boolean qxdd) {
        this.qxdd = qxdd;
    }
}