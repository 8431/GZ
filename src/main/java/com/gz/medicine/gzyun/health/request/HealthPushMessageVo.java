/*
* HealthPushMessage.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.common.GZMessage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Title PUSHMESSAGE表的实体类
 * @Description 消息推送
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-28 15:34:40
 */
public class HealthPushMessageVo implements Serializable {
    private static final long serialVersionUID = 1L;
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
     * @Fields sendMsgState 是否发送短信
     */
    private Boolean sendMsgState;
    /**
     * @Fields sendMsgContent 发送短信内容
     */

    private String sendMsgContent;
    /**
     * @Fields phoneNum 接受短信手机号
     */

    private String phoneNum;
    private List<GZMessage> gzmessage;
    private String pushtype;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }

    public Date getPushtime() {
        return pushtime;
    }

    public void setPushtime(Date pushtime) {
        this.pushtime = pushtime;
    }

    public String getPushmessage() {
        return pushmessage;
    }

    public void setPushmessage(String pushmessage) {
        this.pushmessage = pushmessage;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
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
        this.createname = createname;
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
        this.updatename = updatename;
    }

    public Boolean getSendMsgState() {
        return sendMsgState;
    }

    public void setSendMsgState(Boolean sendMsgState) {
        this.sendMsgState = sendMsgState;
    }

    public String getSendMsgContent() {
        return sendMsgContent;
    }

    public void setSendMsgContent(String sendMsgContent) {
        this.sendMsgContent = sendMsgContent;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPushtype() {
        return pushtype;
    }

    public void setPushtype(String pushtype) {
        this.pushtype = pushtype;
    }

    public List<GZMessage> getGzmessage() {
        return gzmessage;
    }

    public void setGzmessage(List<GZMessage> gzmessage) {
        this.gzmessage = gzmessage;
    }
}