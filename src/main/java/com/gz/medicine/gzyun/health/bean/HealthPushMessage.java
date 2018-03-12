/*
* HealthPushMessage.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Title PUSHMESSAGE表的实体类
 * @Description 消息推送
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-28 15:34:40
 */
public class HealthPushMessage {
    /**
     * @Fields id 主键  
     */
    private String id;

    /**
     * @Fields userid 用户ID
     */
    private String userid;

    /**
     * @Fields orderid 订单号
     */
    private String orderid;

    /**
     * @Fields messagetype 消息类型 1系统 2 咨询 3 订单
     */
    private String messagetype;

    /**
     * @Fields messagename 消息名称
     */
    private String messagename;

    /**
     * @Fields pushtime 推送时间
     */
    private Date pushtime;

    /**
     * @Fields pushmessage 推送内容
     */
    private String pushmessage;

    /**
     * @Fields remarks 备注
     */
    private String remarks;

    /**
     * @Fields state 状态
     */
    private String state;

    /**
     * @Fields isread 是否已读  0 未读 1、已读
     */
    private String isread;

    /**
     * @Fields createdate 创建日期
     */
    private Date createdate;

    /**
     * @Fields createname 创建人
     */
    private String createname;

    /**
     * @Fields updatedate 更新时间
     */
    private Date updatedate;

    /**
     * @Fields updatename 更新人
     */
    private String updatename;

    /**
     * 获取 主键   字段:PUSHMESSAGE.ID
     *
     * @return PUSHMESSAGE.ID, 主键  
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键   字段:PUSHMESSAGE.ID
     *
     * @param id the value for PUSHMESSAGE.ID, 主键  
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:PUSHMESSAGE.USERID
     *
     * @return PUSHMESSAGE.USERID, 用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置 用户ID 字段:PUSHMESSAGE.USERID
     *
     * @param userid the value for PUSHMESSAGE.USERID, 用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 获取 订单号 字段:PUSHMESSAGE.ORDERID
     *
     * @return PUSHMESSAGE.ORDERID, 订单号
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * 设置 订单号 字段:PUSHMESSAGE.ORDERID
     *
     * @param orderid the value for PUSHMESSAGE.ORDERID, 订单号
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * 获取 消息类型 字段:PUSHMESSAGE.MESSAGETYPE
     *
     * @return PUSHMESSAGE.MESSAGETYPE, 消息类型
     */
    public String getMessagetype() {
        return messagetype;
    }

    /**
     * 设置 消息类型 字段:PUSHMESSAGE.MESSAGETYPE
     *
     * @param messagetype the value for PUSHMESSAGE.MESSAGETYPE, 消息类型
     */
    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype == null ? null : messagetype.trim();
    }

    /**
     * 获取 消息名称 字段:PUSHMESSAGE.MESSAGENAME
     *
     * @return PUSHMESSAGE.MESSAGENAME, 消息名称
     */
    public String getMessagename() {
        return messagename;
    }

    /**
     * 设置 消息名称 字段:PUSHMESSAGE.MESSAGENAME
     *
     * @param messagename the value for PUSHMESSAGE.MESSAGENAME, 消息名称
     */
    public void setMessagename(String messagename) {
        this.messagename = messagename == null ? null : messagename.trim();
    }

    /**
     * 获取 推送时间 字段:PUSHMESSAGE.PUSHTIME
     *
     * @return PUSHMESSAGE.PUSHTIME, 推送时间
     */
    public Date getPushtime() {
        return pushtime;
    }

    /**
     * 设置 推送时间 字段:PUSHMESSAGE.PUSHTIME
     *
     * @param pushtime the value for PUSHMESSAGE.PUSHTIME, 推送时间
     */
    public void setPushtime(Date pushtime) {
        this.pushtime = pushtime;
    }

    /**
     * 获取 推送内容 字段:PUSHMESSAGE.PUSHMESSAGE
     *
     * @return PUSHMESSAGE.PUSHMESSAGE, 推送内容
     */
    public String getPushmessage() {
        return pushmessage;
    }

    /**
     * 设置 推送内容 字段:PUSHMESSAGE.PUSHMESSAGE
     *
     * @param pushmessage the value for PUSHMESSAGE.PUSHMESSAGE, 推送内容
     */
    public void setPushmessage(String pushmessage) {
        this.pushmessage = pushmessage == null ? null : pushmessage.trim();
    }

    /**
     * 获取 备注 字段:PUSHMESSAGE.REMARKS
     *
     * @return PUSHMESSAGE.REMARKS, 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置 备注 字段:PUSHMESSAGE.REMARKS
     *
     * @param remarks the value for PUSHMESSAGE.REMARKS, 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取 状态 字段:PUSHMESSAGE.STATE
     *
     * @return PUSHMESSAGE.STATE, 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 状态 字段:PUSHMESSAGE.STATE
     *
     * @param state the value for PUSHMESSAGE.STATE, 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 是否已读 字段:PUSHMESSAGE.ISREAD
     *
     * @return PUSHMESSAGE.ISREAD, 是否已读
     */
    public String getIsread() {
        return isread;
    }

    /**
     * 设置 是否已读 字段:PUSHMESSAGE.ISREAD
     *
     * @param isread the value for PUSHMESSAGE.ISREAD, 是否已读
     */
    public void setIsread(String isread) {
        this.isread = isread == null ? null : isread.trim();
    }

    /**
     * 获取 创建日期 字段:PUSHMESSAGE.CREATEDATE
     *
     * @return PUSHMESSAGE.CREATEDATE, 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建日期 字段:PUSHMESSAGE.CREATEDATE
     *
     * @param createdate the value for PUSHMESSAGE.CREATEDATE, 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:PUSHMESSAGE.CREATENAME
     *
     * @return PUSHMESSAGE.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:PUSHMESSAGE.CREATENAME
     *
     * @param createname the value for PUSHMESSAGE.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:PUSHMESSAGE.UPDATEDATE
     *
     * @return PUSHMESSAGE.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:PUSHMESSAGE.UPDATEDATE
     *
     * @param updatedate the value for PUSHMESSAGE.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:PUSHMESSAGE.UPDATENAME
     *
     * @return PUSHMESSAGE.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:PUSHMESSAGE.UPDATENAME
     *
     * @param updatename the value for PUSHMESSAGE.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }
}