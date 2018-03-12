/*
* HealthActionRecord.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-24
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHACTIONRECORD表的实体类
 * @Description 用户行为记录表
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-24 15:46:20
 */
public class HealthActionRecord {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields usrid 用户ID
     */
    private String usrid;

    /**
     * @Fields modulcode 系统模块编号
     */
    private String modulcode;

    /**
     * @Fields docid 医生ID
     */
    private String docid;

    /**
     * @Fields createdate 创建时间
     */
    private Date createdate;

    /**
     * @Fields createname 创建人
     */
    private String createname;

    /**
     * 获取 主键 字段:HEALTHACTIONRECORD.ID
     *
     * @return HEALTHACTIONRECORD.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTHACTIONRECORD.ID
     *
     * @param id the value for HEALTHACTIONRECORD.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户ID 字段:HEALTHACTIONRECORD.USRID
     *
     * @return HEALTHACTIONRECORD.USRID, 用户ID
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 用户ID 字段:HEALTHACTIONRECORD.USRID
     *
     * @param usrid the value for HEALTHACTIONRECORD.USRID, 用户ID
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 系统模块编号 字段:HEALTHACTIONRECORD.MODULCODE
     *
     * @return HEALTHACTIONRECORD.MODULCODE, 系统模块编号
     */
    public String getModulcode() {
        return modulcode;
    }

    /**
     * 设置 系统模块编号 字段:HEALTHACTIONRECORD.MODULCODE
     *
     * @param modulcode the value for HEALTHACTIONRECORD.MODULCODE, 系统模块编号
     */
    public void setModulcode(String modulcode) {
        this.modulcode = modulcode == null ? null : modulcode.trim();
    }

    /**
     * 获取 医生ID 字段:HEALTHACTIONRECORD.DOCID
     *
     * @return HEALTHACTIONRECORD.DOCID, 医生ID
     */
    public String getDocid() {
        return docid;
    }

    /**
     * 设置 医生ID 字段:HEALTHACTIONRECORD.DOCID
     *
     * @param docid the value for HEALTHACTIONRECORD.DOCID, 医生ID
     */
    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTHACTIONRECORD.CREATEDATE
     *
     * @return HEALTHACTIONRECORD.CREATEDATE, 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:HEALTHACTIONRECORD.CREATEDATE
     *
     * @param createdate the value for HEALTHACTIONRECORD.CREATEDATE, 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:HEALTHACTIONRECORD.CREATENAME
     *
     * @return HEALTHACTIONRECORD.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:HEALTHACTIONRECORD.CREATENAME
     *
     * @param createname the value for HEALTHACTIONRECORD.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }
}