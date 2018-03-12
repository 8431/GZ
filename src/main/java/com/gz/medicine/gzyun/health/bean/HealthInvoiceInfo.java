/*
* HealthInvoiceInfo.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-16
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHINVOICEINFO表的实体类
 * @Description 发票基本信息表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 17:32:15
 */
public class HealthInvoiceInfo {
    /**
     * @Fields id id
     */
    private String id;

    /**
     * @Fields usrid 用户id
     */
    private String usrid;

    /**
     * @Fields invoicetype 发票类型--1个人，2公司
     */
    private String invoicetype;

    /**
     * @Fields rise 发票抬头
     */
    private String rise;

    /**
     * @Fields taxnumber 税号
     */
    private String taxnumber;

    /**
     * @Fields createdate 
     */
    private Date createdate;

    /**
     * @Fields createname 
     */
    private String createname;

    /**
     * @Fields updatedate 
     */
    private Date updatedate;

    /**
     * @Fields updatename 
     */
    private String updatename;

    /**
     * @Fields state 删除标志位 1正常 0删除
     */
    private String state;

    /**
     * 获取 id 字段:HEALTHINVOICEINFO.ID
     *
     * @return HEALTHINVOICEINFO.ID, id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 id 字段:HEALTHINVOICEINFO.ID
     *
     * @param id the value for HEALTHINVOICEINFO.ID, id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户id 字段:HEALTHINVOICEINFO.USRID
     *
     * @return HEALTHINVOICEINFO.USRID, 用户id
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 用户id 字段:HEALTHINVOICEINFO.USRID
     *
     * @param usrid the value for HEALTHINVOICEINFO.USRID, 用户id
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 发票类型--1个人，2公司 字段:HEALTHINVOICEINFO.INVOICETYPE
     *
     * @return HEALTHINVOICEINFO.INVOICETYPE, 发票类型--1个人，2公司
     */
    public String getInvoicetype() {
        return invoicetype;
    }

    /**
     * 设置 发票类型--1个人，2公司 字段:HEALTHINVOICEINFO.INVOICETYPE
     *
     * @param invoicetype the value for HEALTHINVOICEINFO.INVOICETYPE, 发票类型--1个人，2公司
     */
    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype == null ? null : invoicetype.trim();
    }

    /**
     * 获取 发票抬头 字段:HEALTHINVOICEINFO.RISE
     *
     * @return HEALTHINVOICEINFO.RISE, 发票抬头
     */
    public String getRise() {
        return rise;
    }

    /**
     * 设置 发票抬头 字段:HEALTHINVOICEINFO.RISE
     *
     * @param rise the value for HEALTHINVOICEINFO.RISE, 发票抬头
     */
    public void setRise(String rise) {
        this.rise = rise == null ? null : rise.trim();
    }

    /**
     * 获取 税号 字段:HEALTHINVOICEINFO.TAXNUMBER
     *
     * @return HEALTHINVOICEINFO.TAXNUMBER, 税号
     */
    public String getTaxnumber() {
        return taxnumber;
    }

    /**
     * 设置 税号 字段:HEALTHINVOICEINFO.TAXNUMBER
     *
     * @param taxnumber the value for HEALTHINVOICEINFO.TAXNUMBER, 税号
     */
    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber == null ? null : taxnumber.trim();
    }

    /**
     * 获取 null 字段:HEALTHINVOICEINFO.CREATEDATE
     *
     * @return HEALTHINVOICEINFO.CREATEDATE, null
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 null 字段:HEALTHINVOICEINFO.CREATEDATE
     *
     * @param createdate the value for HEALTHINVOICEINFO.CREATEDATE, null
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 null 字段:HEALTHINVOICEINFO.CREATENAME
     *
     * @return HEALTHINVOICEINFO.CREATENAME, null
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 null 字段:HEALTHINVOICEINFO.CREATENAME
     *
     * @param createname the value for HEALTHINVOICEINFO.CREATENAME, null
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 null 字段:HEALTHINVOICEINFO.UPDATEDATE
     *
     * @return HEALTHINVOICEINFO.UPDATEDATE, null
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 null 字段:HEALTHINVOICEINFO.UPDATEDATE
     *
     * @param updatedate the value for HEALTHINVOICEINFO.UPDATEDATE, null
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 null 字段:HEALTHINVOICEINFO.UPDATENAME
     *
     * @return HEALTHINVOICEINFO.UPDATENAME, null
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 null 字段:HEALTHINVOICEINFO.UPDATENAME
     *
     * @param updatename the value for HEALTHINVOICEINFO.UPDATENAME, null
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    /**
     * 获取 删除标志位 1正常 0删除 字段:HEALTHINVOICEINFO.STATE
     *
     * @return HEALTHINVOICEINFO.STATE, 删除标志位 1正常 0删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标志位 1正常 0删除 字段:HEALTHINVOICEINFO.STATE
     *
     * @param state the value for HEALTHINVOICEINFO.STATE, 删除标志位 1正常 0删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}