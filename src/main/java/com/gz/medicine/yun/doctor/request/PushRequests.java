package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by w维维 on 2017/12/18.
 */
public class PushRequests implements Serializable {

    private static final long serialVersionUID = 1L;

    private String phoneType;

    private String deviceToken;

    private String guid;

    private String appkey;

    private String appMasterSecret;

    private String umengMessageSecret;

    private String message;

    private String messagename;

    private String messageType;

    private String key1name;

    private String key1value;

    private String key2name;

    private String key2value;

    private String alias;

    private String alias_type;

    private String orderId;

    private String sendType;

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    private int bage;

    public int getBage() {
        return bage;
    }

    public void setBage(int bage) {
        this.bage = bage;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getAlias_type() {
        return alias_type;
    }

    public void setAlias_type(String alias_type) {
        this.alias_type = alias_type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKey1name() {
        return key1name;
    }

    public void setKey1name(String key1name) {
        this.key1name = key1name;
    }

    public String getKey1value() {
        return key1value;
    }

    public void setKey1value(String key1value) {
        this.key1value = key1value;
    }

    public String getKey2name() {
        return key2name;
    }

    public void setKey2name(String key2name) {
        this.key2name = key2name;
    }

    public String getKey2value() {
        return key2value;
    }

    public void setKey2value(String key2value) {
        this.key2value = key2value;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppMasterSecret() {
        return appMasterSecret;
    }

    public void setAppMasterSecret(String appMasterSecret) {
        this.appMasterSecret = appMasterSecret;
    }

    public String getUmengMessageSecret() {
        return umengMessageSecret;
    }

    public void setUmengMessageSecret(String umengMessageSecret) {
        this.umengMessageSecret = umengMessageSecret;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }
}
