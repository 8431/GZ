package com.gz.medicine.gzyun.push.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description 友盟推送绑定 请求数据
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
public class HealthUmengEquipmentRequest{

    /**
     * @Fields userid 用户ID
     */
    @NotEmpty(message = "用户ID不能为空!")
    private String userid;

    /**
     * @Fields phonetype 手机类型 1 IOS 2 ANDROID
     */
    @NotEmpty(message = "手机类型不能为空!")
    private String phonetype;

    /**
     * @Fields appmastersecret 注册应用时生成的 masterSecret
     */
    @NotEmpty(message = "masterSecret不能为空!")
    private String appmastersecret;

    /**
     * @Fields umengmessagesecret 注册应用时生成的Umeng Message Secret
     */
    private String umengmessagesecret;

    /**
     * @Fields appkey 注册应用时生成的appKey
     */
    @NotEmpty(message = "appkey不能为空!")
    private String appkey;

    /**
     * @Fields aliasType 别名类型
     */
    private String aliasType;

    /**
     * @Fields alias 别名
     */
    @NotEmpty(message = "alias不能为空!")
    private String alias;

    /**
     * @Fields devicetokens 指定的设备
     */
    private String devicetokens;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getAppmastersecret() {
        return appmastersecret;
    }

    public void setAppmastersecret(String appmastersecret) {
        this.appmastersecret = appmastersecret;
    }

    public String getUmengmessagesecret() {
        return umengmessagesecret;
    }

    public void setUmengmessagesecret(String umengmessagesecret) {
        this.umengmessagesecret = umengmessagesecret;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAliasType() {
        return aliasType;
    }

    public void setAliasType(String aliasType) {
        this.aliasType = aliasType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDevicetokens() {
        return devicetokens;
    }

    public void setDevicetokens(String devicetokens) {
        this.devicetokens = devicetokens;
    }
}
