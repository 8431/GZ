/*
* DTfollowupTemplate.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-07
*/
package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

/**
 * @Title CHIS_FOLLOWUP_TEMPLATE表的实体类
 * @Description 随访模板
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-07 17:37:24
 */
public class DTfollowupTemplate {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields userid 用户ID
     */
    private String userid;

    /**
     * @Fields title 标题
     */
    private String title;

    /**
     * @Fields content 内容
     */
    private String content;

    /**
     * @Fields type 模板类型
     */
    private String type;

    /**
     * @Fields state 状态位
     */
    private String state;

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

    private String followtype;

    /**
     * 获取 主键 字段:CHIS_FOLLOWUP_TEMPLATE.ID
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:CHIS_FOLLOWUP_TEMPLATE.ID
     *
     * @param id the value for CHIS_FOLLOWUP_TEMPLATE.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:CHIS_FOLLOWUP_TEMPLATE.USERID
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.USERID, 用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置 用户ID 字段:CHIS_FOLLOWUP_TEMPLATE.USERID
     *
     * @param userid the value for CHIS_FOLLOWUP_TEMPLATE.USERID, 用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 获取 标题 字段:CHIS_FOLLOWUP_TEMPLATE.TITLE
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.TITLE, 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 标题 字段:CHIS_FOLLOWUP_TEMPLATE.TITLE
     *
     * @param title the value for CHIS_FOLLOWUP_TEMPLATE.TITLE, 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 内容 字段:CHIS_FOLLOWUP_TEMPLATE.CONTENT
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.CONTENT, 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 内容 字段:CHIS_FOLLOWUP_TEMPLATE.CONTENT
     *
     * @param content the value for CHIS_FOLLOWUP_TEMPLATE.CONTENT, 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 模板类型 字段:CHIS_FOLLOWUP_TEMPLATE.TYPE
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.TYPE, 模板类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 模板类型 字段:CHIS_FOLLOWUP_TEMPLATE.TYPE
     *
     * @param type the value for CHIS_FOLLOWUP_TEMPLATE.TYPE, 模板类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取 状态位 字段:CHIS_FOLLOWUP_TEMPLATE.STATE
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.STATE, 状态位
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 状态位 字段:CHIS_FOLLOWUP_TEMPLATE.STATE
     *
     * @param state the value for CHIS_FOLLOWUP_TEMPLATE.STATE, 状态位
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 创建日期 字段:CHIS_FOLLOWUP_TEMPLATE.CREATEDATE
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.CREATEDATE, 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建日期 字段:CHIS_FOLLOWUP_TEMPLATE.CREATEDATE
     *
     * @param createdate the value for CHIS_FOLLOWUP_TEMPLATE.CREATEDATE, 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:CHIS_FOLLOWUP_TEMPLATE.CREATENAME
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:CHIS_FOLLOWUP_TEMPLATE.CREATENAME
     *
     * @param createname the value for CHIS_FOLLOWUP_TEMPLATE.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:CHIS_FOLLOWUP_TEMPLATE.UPDATEDATE
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:CHIS_FOLLOWUP_TEMPLATE.UPDATEDATE
     *
     * @param updatedate the value for CHIS_FOLLOWUP_TEMPLATE.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:CHIS_FOLLOWUP_TEMPLATE.UPDATENAME
     *
     * @return CHIS_FOLLOWUP_TEMPLATE.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:CHIS_FOLLOWUP_TEMPLATE.UPDATENAME
     *
     * @param updatename the value for CHIS_FOLLOWUP_TEMPLATE.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    public String getFollowtype() {
        return followtype;
    }

    public void setFollowtype(String followtype) {
        this.followtype = followtype;
    }
}