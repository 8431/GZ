/*
* HealthTemplateContent.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title TEMPLATECONTENT表的实体类
 * @Description 模板内容表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-28 15:34:40
 */
public class HealthTemplateContent {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields typecode 模板类型code
     */
    private String typecode;

    /**
     * @Fields typename 模板名称
     */
    private String typename;

    /**
     * @Fields typecontent 模板内容
     */
    private String typecontent;

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
     * 获取 主键 字段:TEMPLATECONTENT.ID
     *
     * @return TEMPLATECONTENT.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:TEMPLATECONTENT.ID
     *
     * @param id the value for TEMPLATECONTENT.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 模板类型code 字段:TEMPLATECONTENT.TYPECODE
     *
     * @return TEMPLATECONTENT.TYPECODE, 模板类型code
     */
    public String getTypecode() {
        return typecode;
    }

    /**
     * 设置 模板类型code 字段:TEMPLATECONTENT.TYPECODE
     *
     * @param typecode the value for TEMPLATECONTENT.TYPECODE, 模板类型code
     */
    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    /**
     * 获取 模板名称 字段:TEMPLATECONTENT.TYPENAME
     *
     * @return TEMPLATECONTENT.TYPENAME, 模板名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置 模板名称 字段:TEMPLATECONTENT.TYPENAME
     *
     * @param typename the value for TEMPLATECONTENT.TYPENAME, 模板名称
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 获取 模板内容 字段:TEMPLATECONTENT.TYPECONTENT
     *
     * @return TEMPLATECONTENT.TYPECONTENT, 模板内容
     */
    public String getTypecontent() {
        return typecontent;
    }

    /**
     * 设置 模板内容 字段:TEMPLATECONTENT.TYPECONTENT
     *
     * @param typecontent the value for TEMPLATECONTENT.TYPECONTENT, 模板内容
     */
    public void setTypecontent(String typecontent) {
        this.typecontent = typecontent == null ? null : typecontent.trim();
    }

    /**
     * 获取 创建时间 字段:TEMPLATECONTENT.CREATEDATE
     *
     * @return TEMPLATECONTENT.CREATEDATE, 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:TEMPLATECONTENT.CREATEDATE
     *
     * @param createdate the value for TEMPLATECONTENT.CREATEDATE, 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:TEMPLATECONTENT.CREATENAME
     *
     * @return TEMPLATECONTENT.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:TEMPLATECONTENT.CREATENAME
     *
     * @param createname the value for TEMPLATECONTENT.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:TEMPLATECONTENT.UPDATEDATE
     *
     * @return TEMPLATECONTENT.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:TEMPLATECONTENT.UPDATEDATE
     *
     * @param updatedate the value for TEMPLATECONTENT.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:TEMPLATECONTENT.UPDATENAME
     *
     * @return TEMPLATECONTENT.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:TEMPLATECONTENT.UPDATENAME
     *
     * @param updatename the value for TEMPLATECONTENT.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }
}