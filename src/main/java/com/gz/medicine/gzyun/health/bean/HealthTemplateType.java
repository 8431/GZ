/*
* HealthTemplateType.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.bean;

import com.gz.medicine.gzyun.health.reponse.TemplateContentReponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title TEMPLATETYPE表的实体类
 * @Description 模板类型表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-28 15:34:40
 */
public class HealthTemplateType {
    /**
     * @Fields id 
     */
    private String id;

    /**
     * @Fields typecode 模板类型code
     */
    private String typecode;

    /**
     * @Fields typename 模板类型名称
     */
    private String typename;

    /**
     * @Fields module 所属模块
     */
    private String module;

    /**
     * @Fields state 状态
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
     * @Fields updatename 创建人
     */
    private String updatename;


    private List<TemplateContentReponse> TemplateContentList;

    /**
     * 获取 null 字段:TEMPLATETYPE.ID
     *
     * @return TEMPLATETYPE.ID, null
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 null 字段:TEMPLATETYPE.ID
     *
     * @param id the value for TEMPLATETYPE.ID, null
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 模板类型code 字段:TEMPLATETYPE.TYPECODE
     *
     * @return TEMPLATETYPE.TYPECODE, 模板类型code
     */
    public String getTypecode() {
        return typecode;
    }

    /**
     * 设置 模板类型code 字段:TEMPLATETYPE.TYPECODE
     *
     * @param typecode the value for TEMPLATETYPE.TYPECODE, 模板类型code
     */
    public void setTypecode(String typecode) {
        this.typecode = typecode == null ? null : typecode.trim();
    }

    /**
     * 获取 模板类型名称 字段:TEMPLATETYPE.TYPENAME
     *
     * @return TEMPLATETYPE.TYPENAME, 模板类型名称
     */
    public String getTypename() {
        return typename;
    }

    /**
     * 设置 模板类型名称 字段:TEMPLATETYPE.TYPENAME
     *
     * @param typename the value for TEMPLATETYPE.TYPENAME, 模板类型名称
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * 获取 所属模块 字段:TEMPLATETYPE.MODULE
     *
     * @return TEMPLATETYPE.MODULE, 所属模块
     */
    public String getModule() {
        return module;
    }

    /**
     * 设置 所属模块 字段:TEMPLATETYPE.MODULE
     *
     * @param module the value for TEMPLATETYPE.MODULE, 所属模块
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    /**
     * 获取 状态 字段:TEMPLATETYPE.STATE
     *
     * @return TEMPLATETYPE.STATE, 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 状态 字段:TEMPLATETYPE.STATE
     *
     * @param state the value for TEMPLATETYPE.STATE, 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 创建日期 字段:TEMPLATETYPE.CREATEDATE
     *
     * @return TEMPLATETYPE.CREATEDATE, 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建日期 字段:TEMPLATETYPE.CREATEDATE
     *
     * @param createdate the value for TEMPLATETYPE.CREATEDATE, 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:TEMPLATETYPE.CREATENAME
     *
     * @return TEMPLATETYPE.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:TEMPLATETYPE.CREATENAME
     *
     * @param createname the value for TEMPLATETYPE.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:TEMPLATETYPE.UPDATEDATE
     *
     * @return TEMPLATETYPE.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:TEMPLATETYPE.UPDATEDATE
     *
     * @param updatedate the value for TEMPLATETYPE.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 创建人 字段:TEMPLATETYPE.UPDATENAME
     *
     * @return TEMPLATETYPE.UPDATENAME, 创建人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 创建人 字段:TEMPLATETYPE.UPDATENAME
     *
     * @param updatename the value for TEMPLATETYPE.UPDATENAME, 创建人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    public List<TemplateContentReponse> getTemplateContentList() {
        return TemplateContentList;
    }

    public void setTemplateContentList(List<TemplateContentReponse> templateContentList) {
        TemplateContentList = templateContentList;
    }
}