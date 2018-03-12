/*
* HealthInvoiceRecord.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-16
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHINVOICERECORD表的实体类
 * @Description 发票记录表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 17:32:15
 */
public class HealthInvoiceRecord {
    /**
     * @Fields id id
     */
    private String id;

    /**
     * @Fields usrid 用户id
     */
    private String usrid;

    /**
     * @Fields orderid 订单id
     */
    private String orderid;

    /**
     * @Fields consignee  收货人
     */
    private String consignee;

    /**
     * @Fields phone 联系方式
     */
    private String phone;

    /**
     * @Fields addr 收货地址
     */
    private String addr;

    /**
     * @Fields invoicetype 发票类型
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
     * @Fields expressnumber 快递单号
     */
    private String expressnumber;

    /**
     * @Fields expresstype 快递类型
     */
    private String expresstype;

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
     * 获取 id 字段:HEALTHINVOICERECORD.ID
     *
     * @return HEALTHINVOICERECORD.ID, id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 id 字段:HEALTHINVOICERECORD.ID
     *
     * @param id the value for HEALTHINVOICERECORD.ID, id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户id 字段:HEALTHINVOICERECORD.USRID
     *
     * @return HEALTHINVOICERECORD.USRID, 用户id
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 用户id 字段:HEALTHINVOICERECORD.USRID
     *
     * @param usrid the value for HEALTHINVOICERECORD.USRID, 用户id
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 订单id 字段:HEALTHINVOICERECORD.ORDERID
     *
     * @return HEALTHINVOICERECORD.ORDERID, 订单id
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * 设置 订单id 字段:HEALTHINVOICERECORD.ORDERID
     *
     * @param orderid the value for HEALTHINVOICERECORD.ORDERID, 订单id
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * 获取  收货人 字段:HEALTHINVOICERECORD.CONSIGNEE
     *
     * @return HEALTHINVOICERECORD.CONSIGNEE,  收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置  收货人 字段:HEALTHINVOICERECORD.CONSIGNEE
     *
     * @param consignee the value for HEALTHINVOICERECORD.CONSIGNEE,  收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * 获取 联系方式 字段:HEALTHINVOICERECORD.PHONE
     *
     * @return HEALTHINVOICERECORD.PHONE, 联系方式
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 联系方式 字段:HEALTHINVOICERECORD.PHONE
     *
     * @param phone the value for HEALTHINVOICERECORD.PHONE, 联系方式
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 收货地址 字段:HEALTHINVOICERECORD.ADDR
     *
     * @return HEALTHINVOICERECORD.ADDR, 收货地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置 收货地址 字段:HEALTHINVOICERECORD.ADDR
     *
     * @param addr the value for HEALTHINVOICERECORD.ADDR, 收货地址
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * 获取 发票类型 字段:HEALTHINVOICERECORD.INVOICETYPE
     *
     * @return HEALTHINVOICERECORD.INVOICETYPE, 发票类型
     */
    public String getInvoicetype() {
        return invoicetype;
    }

    /**
     * 设置 发票类型 字段:HEALTHINVOICERECORD.INVOICETYPE
     *
     * @param invoicetype the value for HEALTHINVOICERECORD.INVOICETYPE, 发票类型
     */
    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype == null ? null : invoicetype.trim();
    }

    /**
     * 获取 发票抬头 字段:HEALTHINVOICERECORD.RISE
     *
     * @return HEALTHINVOICERECORD.RISE, 发票抬头
     */
    public String getRise() {
        return rise;
    }

    /**
     * 设置 发票抬头 字段:HEALTHINVOICERECORD.RISE
     *
     * @param rise the value for HEALTHINVOICERECORD.RISE, 发票抬头
     */
    public void setRise(String rise) {
        this.rise = rise == null ? null : rise.trim();
    }

    /**
     * 获取 税号 字段:HEALTHINVOICERECORD.TAXNUMBER
     *
     * @return HEALTHINVOICERECORD.TAXNUMBER, 税号
     */
    public String getTaxnumber() {
        return taxnumber;
    }

    /**
     * 设置 税号 字段:HEALTHINVOICERECORD.TAXNUMBER
     *
     * @param taxnumber the value for HEALTHINVOICERECORD.TAXNUMBER, 税号
     */
    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber == null ? null : taxnumber.trim();
    }

    /**
     * 获取 快递单号 字段:HEALTHINVOICERECORD.EXPRESSNUMBER
     *
     * @return HEALTHINVOICERECORD.EXPRESSNUMBER, 快递单号
     */
    public String getExpressnumber() {
        return expressnumber;
    }

    /**
     * 设置 快递单号 字段:HEALTHINVOICERECORD.EXPRESSNUMBER
     *
     * @param expressnumber the value for HEALTHINVOICERECORD.EXPRESSNUMBER, 快递单号
     */
    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber == null ? null : expressnumber.trim();
    }

    /**
     * 获取 快递类型 字段:HEALTHINVOICERECORD.EXPRESSTYPE
     *
     * @return HEALTHINVOICERECORD.EXPRESSTYPE, 快递类型
     */
    public String getExpresstype() {
        return expresstype;
    }

    /**
     * 设置 快递类型 字段:HEALTHINVOICERECORD.EXPRESSTYPE
     *
     * @param expresstype the value for HEALTHINVOICERECORD.EXPRESSTYPE, 快递类型
     */
    public void setExpresstype(String expresstype) {
        this.expresstype = expresstype == null ? null : expresstype.trim();
    }

    /**
     * 获取 null 字段:HEALTHINVOICERECORD.CREATEDATE
     *
     * @return HEALTHINVOICERECORD.CREATEDATE, null
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 null 字段:HEALTHINVOICERECORD.CREATEDATE
     *
     * @param createdate the value for HEALTHINVOICERECORD.CREATEDATE, null
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 null 字段:HEALTHINVOICERECORD.CREATENAME
     *
     * @return HEALTHINVOICERECORD.CREATENAME, null
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 null 字段:HEALTHINVOICERECORD.CREATENAME
     *
     * @param createname the value for HEALTHINVOICERECORD.CREATENAME, null
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 null 字段:HEALTHINVOICERECORD.UPDATEDATE
     *
     * @return HEALTHINVOICERECORD.UPDATEDATE, null
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 null 字段:HEALTHINVOICERECORD.UPDATEDATE
     *
     * @param updatedate the value for HEALTHINVOICERECORD.UPDATEDATE, null
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 null 字段:HEALTHINVOICERECORD.UPDATENAME
     *
     * @return HEALTHINVOICERECORD.UPDATENAME, null
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 null 字段:HEALTHINVOICERECORD.UPDATENAME
     *
     * @param updatename the value for HEALTHINVOICERECORD.UPDATENAME, null
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    /**
     * 获取 删除标志位 1正常 0删除 字段:HEALTHINVOICERECORD.STATE
     *
     * @return HEALTHINVOICERECORD.STATE, 删除标志位 1正常 0删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标志位 1正常 0删除 字段:HEALTHINVOICERECORD.STATE
     *
     * @param state the value for HEALTHINVOICERECORD.STATE, 删除标志位 1正常 0删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}