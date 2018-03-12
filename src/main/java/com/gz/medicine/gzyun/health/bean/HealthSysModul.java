/*
* HealthSysModul.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-11-24
*/
package com.gz.medicine.gzyun.health.bean;

/**
 * @Title HEALTHSYSMODUL表的实体类
 * @Description 系统模块配置表
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-24 15:46:20
 */
public class HealthSysModul {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields code 模块编号
     */
    private String code;

    /**
     * @Fields name 模块名称
     */
    private String name;

    /**
     * 获取 主键 字段:HEALTHSYSMODUL.ID
     *
     * @return HEALTHSYSMODUL.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTHSYSMODUL.ID
     *
     * @param id the value for HEALTHSYSMODUL.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 模块编号 字段:HEALTHSYSMODUL.CODE
     *
     * @return HEALTHSYSMODUL.CODE, 模块编号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置 模块编号 字段:HEALTHSYSMODUL.CODE
     *
     * @param code the value for HEALTHSYSMODUL.CODE, 模块编号
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取 模块名称 字段:HEALTHSYSMODUL.NAME
     *
     * @return HEALTHSYSMODUL.NAME, 模块名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 模块名称 字段:HEALTHSYSMODUL.NAME
     *
     * @param name the value for HEALTHSYSMODUL.NAME, 模块名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}