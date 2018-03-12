/*
* HealthUmengEquipment.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-01
*/
package com.gz.medicine.gzyun.push.bean;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Title UMENGEQUIPMENT表的实体类
 * @Description 友盟推送绑定
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
public class HealthUmengEquipment {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields userid 用户ID
     */
    private String userid;

    /**
     * @Fields phonetype 手机类型 1 IOS 2 ANDROID
     */
    private String phonetype;

    /**
     * @Fields appmastersecret 注册应用时生成的 masterSecret
     */
    private String appmastersecret;

    /**
     * @Fields umengmessagesecret 注册应用时生成的Umeng Message Secret
     */
    private String umengmessagesecret;

    /**
     * @Fields appkey 注册应用时生成的appKey
     */
    private String appkey;

    /**
     * @Fields aliasType 别名类型
     */
    private String aliasType;

    /**
     * @Fields alias 别名
     */
    private String alias;

    /**
     * @Fields devicetokens 指定的设备
     */
    private String devicetokens;

    /**
     * @Fields state 
     */
    private String state;

    /**
     * @Fields createdate 创建的时间
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
     * 获取 主键 字段:UMENGEQUIPMENT.ID
     *
     * @return UMENGEQUIPMENT.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:UMENGEQUIPMENT.ID
     *
     * @param id the value for UMENGEQUIPMENT.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:UMENGEQUIPMENT.USERID
     *
     * @return UMENGEQUIPMENT.USERID, 用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置 用户ID 字段:UMENGEQUIPMENT.USERID
     *
     * @param userid the value for UMENGEQUIPMENT.USERID, 用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 获取 手机类型 1 IOS 2 ANDROID 字段:UMENGEQUIPMENT.PHONETYPE
     *
     * @return UMENGEQUIPMENT.PHONETYPE, 手机类型 1 IOS 2 ANDROID
     */
    public String getPhonetype() {
        return phonetype;
    }

    /**
     * 设置 手机类型 1 IOS 2 ANDROID 字段:UMENGEQUIPMENT.PHONETYPE
     *
     * @param phonetype the value for UMENGEQUIPMENT.PHONETYPE, 手机类型 1 IOS 2 ANDROID
     */
    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype == null ? null : phonetype.trim();
    }

    /**
     * 获取 注册应用时生成的 masterSecret 字段:UMENGEQUIPMENT.APPMASTERSECRET
     *
     * @return UMENGEQUIPMENT.APPMASTERSECRET, 注册应用时生成的 masterSecret
     */
    public String getAppmastersecret() {
        return appmastersecret;
    }

    /**
     * 设置 注册应用时生成的 masterSecret 字段:UMENGEQUIPMENT.APPMASTERSECRET
     *
     * @param appmastersecret the value for UMENGEQUIPMENT.APPMASTERSECRET, 注册应用时生成的 masterSecret
     */
    public void setAppmastersecret(String appmastersecret) {
        this.appmastersecret = appmastersecret == null ? null : appmastersecret.trim();
    }

    /**
     * 获取 注册应用时生成的Umeng Message Secret 字段:UMENGEQUIPMENT.UMENGMESSAGESECRET
     *
     * @return UMENGEQUIPMENT.UMENGMESSAGESECRET, 注册应用时生成的Umeng Message Secret
     */
    public String getUmengmessagesecret() {
        return umengmessagesecret;
    }

    /**
     * 设置 注册应用时生成的Umeng Message Secret 字段:UMENGEQUIPMENT.UMENGMESSAGESECRET
     *
     * @param umengmessagesecret the value for UMENGEQUIPMENT.UMENGMESSAGESECRET, 注册应用时生成的Umeng Message Secret
     */
    public void setUmengmessagesecret(String umengmessagesecret) {
        this.umengmessagesecret = umengmessagesecret == null ? null : umengmessagesecret.trim();
    }

    /**
     * 获取 注册应用时生成的appKey 字段:UMENGEQUIPMENT.APPKEY
     *
     * @return UMENGEQUIPMENT.APPKEY, 注册应用时生成的appKey
     */
    public String getAppkey() {
        return appkey;
    }

    /**
     * 设置 注册应用时生成的appKey 字段:UMENGEQUIPMENT.APPKEY
     *
     * @param appkey the value for UMENGEQUIPMENT.APPKEY, 注册应用时生成的appKey
     */
    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    /**
     * 获取 别名类型 字段:UMENGEQUIPMENT.ALIAS_TYPE
     *
     * @return UMENGEQUIPMENT.ALIAS_TYPE, 别名类型
     */
    public String getAliasType() {
        return aliasType;
    }

    /**
     * 设置 别名类型 字段:UMENGEQUIPMENT.ALIAS_TYPE
     *
     * @param aliasType the value for UMENGEQUIPMENT.ALIAS_TYPE, 别名类型
     */
    public void setAliasType(String aliasType) {
        this.aliasType = aliasType == null ? null : aliasType.trim();
    }

    /**
     * 获取 别名 字段:UMENGEQUIPMENT.ALIAS
     *
     * @return UMENGEQUIPMENT.ALIAS, 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置 别名 字段:UMENGEQUIPMENT.ALIAS
     *
     * @param alias the value for UMENGEQUIPMENT.ALIAS, 别名
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * 获取 指定的设备 字段:UMENGEQUIPMENT.DEVICETOKENS
     *
     * @return UMENGEQUIPMENT.DEVICETOKENS, 指定的设备
     */
    public String getDevicetokens() {
        return devicetokens;
    }

    /**
     * 设置 指定的设备 字段:UMENGEQUIPMENT.DEVICETOKENS
     *
     * @param devicetokens the value for UMENGEQUIPMENT.DEVICETOKENS, 指定的设备
     */
    public void setDevicetokens(String devicetokens) {
        this.devicetokens = devicetokens == null ? null : devicetokens.trim();
    }

    /**
     * 获取 null 字段:UMENGEQUIPMENT.STATE
     *
     * @return UMENGEQUIPMENT.STATE, null
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 null 字段:UMENGEQUIPMENT.STATE
     *
     * @param state the value for UMENGEQUIPMENT.STATE, null
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 创建的时间 字段:UMENGEQUIPMENT.CREATEDATE
     *
     * @return UMENGEQUIPMENT.CREATEDATE, 创建的时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建的时间 字段:UMENGEQUIPMENT.CREATEDATE
     *
     * @param createdate the value for UMENGEQUIPMENT.CREATEDATE, 创建的时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:UMENGEQUIPMENT.CREATENAME
     *
     * @return UMENGEQUIPMENT.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:UMENGEQUIPMENT.CREATENAME
     *
     * @param createname the value for UMENGEQUIPMENT.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:UMENGEQUIPMENT.UPDATEDATE
     *
     * @return UMENGEQUIPMENT.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:UMENGEQUIPMENT.UPDATEDATE
     *
     * @param updatedate the value for UMENGEQUIPMENT.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:UMENGEQUIPMENT.UPDATENAME
     *
     * @return UMENGEQUIPMENT.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:UMENGEQUIPMENT.UPDATENAME
     *
     * @param updatename the value for UMENGEQUIPMENT.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    @Override
    public String toString() {
        return "HealthUmengEquipment{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", phonetype='" + phonetype + '\'' +
                ", appmastersecret='" + appmastersecret + '\'' +
                ", umengmessagesecret='" + umengmessagesecret + '\'' +
                ", appkey='" + appkey + '\'' +
                ", aliasType='" + aliasType + '\'' +
                ", alias='" + alias + '\'' +
                ", devicetokens='" + devicetokens + '\'' +
                ", state='" + state + '\'' +
                ", createdate=" + createdate +
                ", createname='" + createname + '\'' +
                ", updatedate=" + updatedate +
                ", updatename='" + updatename + '\'' +
                '}';
    }
}