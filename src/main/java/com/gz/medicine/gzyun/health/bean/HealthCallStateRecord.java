package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @title HEALTHCALLSTATERECORD表的实体类
 * @description 呼叫状态记录表
 * @version 1.0
 * @author fendo
 * @date 2017-10-16 17:32:15
 */
public class HealthCallStateRecord {

    private String id;

    private String orderid;

    private String callstate;

    private String userid;

    private Date createdate;

    /**
     * 时长
     */
    private String consultinghours;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getCallstate() {
        return callstate;
    }

    public void setCallstate(String callstate) {
        this.callstate = callstate == null ? null : callstate.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getConsultinghours() {
        return consultinghours;
    }

    public void setConsultinghours(String consultinghours) {
        this.consultinghours = consultinghours;
    }
}