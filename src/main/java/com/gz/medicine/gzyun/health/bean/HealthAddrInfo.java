/*
* HealthAddrInfo.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-16
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;

/**
 * @Title HEALTHADDRINFO表的实体类
 * @Description null
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 17:32:15
 */
public class HealthAddrInfo {
    /**
     * @Fields id id
     */
    private String id;

    /**
     * @Fields usrid 用户id
     */
    private String usrid;

    /**
     * @Fields consignee 收货人(名字)
     */
    private String consignee;

    /**
     * @Fields phone 手机号(联系方式)
     */
    private String phone;

    /**
     * @Fields area 所在区域
     */
    private String area;

    /**
     * @Fields address 详细地址
     */
    private String address;

    /**
     * @Fields label 地址标签，家，公司，学校
     */
    private String label;

    /**
     * @Fields defaultaddr 是否默认地址 1是0否
     */
    private String defaultaddr;

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
     * 获取 id 字段:HEALTHADDRINFO.ID
     *
     * @return HEALTHADDRINFO.ID, id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 id 字段:HEALTHADDRINFO.ID
     *
     * @param id the value for HEALTHADDRINFO.ID, id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 用户id 字段:HEALTHADDRINFO.USRID
     *
     * @return HEALTHADDRINFO.USRID, 用户id
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 用户id 字段:HEALTHADDRINFO.USRID
     *
     * @param usrid the value for HEALTHADDRINFO.USRID, 用户id
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 收货人(名字) 字段:HEALTHADDRINFO.CONSIGNEE
     *
     * @return HEALTHADDRINFO.CONSIGNEE, 收货人(名字)
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 设置 收货人(名字) 字段:HEALTHADDRINFO.CONSIGNEE
     *
     * @param consignee the value for HEALTHADDRINFO.CONSIGNEE, 收货人(名字)
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * 获取 手机号(联系方式) 字段:HEALTHADDRINFO.PHONE
     *
     * @return HEALTHADDRINFO.PHONE, 手机号(联系方式)
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 手机号(联系方式) 字段:HEALTHADDRINFO.PHONE
     *
     * @param phone the value for HEALTHADDRINFO.PHONE, 手机号(联系方式)
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 所在区域 字段:HEALTHADDRINFO.AREA
     *
     * @return HEALTHADDRINFO.AREA, 所在区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置 所在区域 字段:HEALTHADDRINFO.AREA
     *
     * @param area the value for HEALTHADDRINFO.AREA, 所在区域
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取 详细地址 字段:HEALTHADDRINFO.ADDRESS
     *
     * @return HEALTHADDRINFO.ADDRESS, 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 详细地址 字段:HEALTHADDRINFO.ADDRESS
     *
     * @param address the value for HEALTHADDRINFO.ADDRESS, 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取 地址标签，家，公司，学校 字段:HEALTHADDRINFO.LABEL
     *
     * @return HEALTHADDRINFO.LABEL, 地址标签，家，公司，学校
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置 地址标签，家，公司，学校 字段:HEALTHADDRINFO.LABEL
     *
     * @param label the value for HEALTHADDRINFO.LABEL, 地址标签，家，公司，学校
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * 获取 是否默认地址 1是0否 字段:HEALTHADDRINFO.DEFAULTADDR
     *
     * @return HEALTHADDRINFO.DEFAULTADDR, 是否默认地址 1是0否
     */
    public String getDefaultaddr() {
        return defaultaddr;
    }

    /**
     * 设置 是否默认地址 1是0否 字段:HEALTHADDRINFO.DEFAULTADDR
     *
     * @param defaultaddr the value for HEALTHADDRINFO.DEFAULTADDR, 是否默认地址 1是0否
     */
    public void setDefaultaddr(String defaultaddr) {
        this.defaultaddr = defaultaddr == null ? null : defaultaddr.trim();
    }

    /**
     * 获取 null 字段:HEALTHADDRINFO.CREATEDATE
     *
     * @return HEALTHADDRINFO.CREATEDATE, null
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 null 字段:HEALTHADDRINFO.CREATEDATE
     *
     * @param createdate the value for HEALTHADDRINFO.CREATEDATE, null
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 null 字段:HEALTHADDRINFO.CREATENAME
     *
     * @return HEALTHADDRINFO.CREATENAME, null
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 null 字段:HEALTHADDRINFO.CREATENAME
     *
     * @param createname the value for HEALTHADDRINFO.CREATENAME, null
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 null 字段:HEALTHADDRINFO.UPDATEDATE
     *
     * @return HEALTHADDRINFO.UPDATEDATE, null
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 null 字段:HEALTHADDRINFO.UPDATEDATE
     *
     * @param updatedate the value for HEALTHADDRINFO.UPDATEDATE, null
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 null 字段:HEALTHADDRINFO.UPDATENAME
     *
     * @return HEALTHADDRINFO.UPDATENAME, null
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 null 字段:HEALTHADDRINFO.UPDATENAME
     *
     * @param updatename the value for HEALTHADDRINFO.UPDATENAME, null
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    /**
     * 获取 删除标志位 1正常 0删除 字段:HEALTHADDRINFO.STATE
     *
     * @return HEALTHADDRINFO.STATE, 删除标志位 1正常 0删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标志位 1正常 0删除 字段:HEALTHADDRINFO.STATE
     *
     * @param state the value for HEALTHADDRINFO.STATE, 删除标志位 1正常 0删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}