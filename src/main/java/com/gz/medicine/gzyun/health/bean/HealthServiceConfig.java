/*
* HealthServiceConfig.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-25
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHSERVICECONFIG表的实体类
 * @Description 医生服务配置表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-25 15:53:13
 */
public class HealthServiceConfig {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields docid 
     */
    private String docid;

    /**
     * @Fields imageservice 图文服务(0关闭 1开启)
     */
    private String imageservice;

    /**
     * @Fields voiceservice 语音服务(0关闭 1开启)
     */
    private String voiceservice;

    /**
     * @Fields videoservice 视频服务(0关闭 1开启)
     */
    private String videoservice;

    /**
     * @Fields state 删除标志位 (0删除 1未删除)
     */
    private String state;

    /**
     * @Fields createdate 创建时间
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
     * 获取 主键 字段:HEALTHSERVICECONFIG.ID
     *
     * @return HEALTHSERVICECONFIG.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTHSERVICECONFIG.ID
     *
     * @param id the value for HEALTHSERVICECONFIG.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 null 字段:HEALTHSERVICECONFIG.DOCID
     *
     * @return HEALTHSERVICECONFIG.DOCID, null
     */
    public String getDocid() {
        return docid;
    }

    /**
     * 设置 null 字段:HEALTHSERVICECONFIG.DOCID
     *
     * @param docid the value for HEALTHSERVICECONFIG.DOCID, null
     */
    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    /**
     * 获取 图文服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.IMAGESERVICE
     *
     * @return HEALTHSERVICECONFIG.IMAGESERVICE, 图文服务(0关闭 1开启)
     */
    public String getImageservice() {
        return imageservice;
    }

    /**
     * 设置 图文服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.IMAGESERVICE
     *
     * @param imageservice the value for HEALTHSERVICECONFIG.IMAGESERVICE, 图文服务(0关闭 1开启)
     */
    public void setImageservice(String imageservice) {
            this.imageservice = imageservice;
    }

    /**
     * 获取 语音服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.VOICESERVICE
     *
     * @return HEALTHSERVICECONFIG.VOICESERVICE, 语音服务(0关闭 1开启)
     */
    public String getVoiceservice() {
        return voiceservice;
    }

    /**
     * 设置 语音服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.VOICESERVICE
     *
     * @param voiceservice the value for HEALTHSERVICECONFIG.VOICESERVICE, 语音服务(0关闭 1开启)
     */
    public void setVoiceservice(String voiceservice) {
            this.voiceservice = voiceservice;
    }

    /**
     * 获取 视频服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.VIDEOSERVICE 
     *
     * @return HEALTHSERVICECONFIG.VIDEOSERVICE , 视频服务(0关闭 1开启)
     */
    public String getVideoservice() {
        return videoservice;
    }

    /**
     * 设置 视频服务(0关闭 1开启) 字段:HEALTHSERVICECONFIG.VIDEOSERVICE 
     *
     * @param videoservice the value for HEALTHSERVICECONFIG.VIDEOSERVICE , 视频服务(0关闭 1开启)
     */
    public void setVideoservice(String videoservice) {
            this.videoservice = videoservice;
    }

    /**
     * 获取 删除标志位 (0删除 1未删除) 字段:HEALTHSERVICECONFIG.STATE
     *
     * @return HEALTHSERVICECONFIG.STATE, 删除标志位 (0删除 1未删除)
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标志位 (0删除 1未删除) 字段:HEALTHSERVICECONFIG.STATE
     *
     * @param state the value for HEALTHSERVICECONFIG.STATE, 删除标志位 (0删除 1未删除)
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTHSERVICECONFIG.CREATEDATE 
     *
     * @return HEALTHSERVICECONFIG.CREATEDATE , 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:HEALTHSERVICECONFIG.CREATEDATE 
     *
     * @param createdate the value for HEALTHSERVICECONFIG.CREATEDATE , 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:HEALTHSERVICECONFIG.CREATENAME
     *
     * @return HEALTHSERVICECONFIG.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:HEALTHSERVICECONFIG.CREATENAME
     *
     * @param createname the value for HEALTHSERVICECONFIG.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTHSERVICECONFIG.UPDATEDATE
     *
     * @return HEALTHSERVICECONFIG.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:HEALTHSERVICECONFIG.UPDATEDATE
     *
     * @param updatedate the value for HEALTHSERVICECONFIG.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:HEALTHSERVICECONFIG.UPDATENAME
     *
     * @return HEALTHSERVICECONFIG.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:HEALTHSERVICECONFIG.UPDATENAME
     *
     * @param updatename the value for HEALTHSERVICECONFIG.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }


    public HealthServiceConfig() {
        }

}