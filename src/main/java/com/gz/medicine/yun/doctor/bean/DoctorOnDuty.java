/*
* DoctorOnDuty.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-19
*/
package com.gz.medicine.yun.doctor.bean;

/**
 * @Title DOCTORONDUTY表的实体类
 * @Description 医生在岗信息
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-19 16:41:37
 */
public class DoctorOnDuty {
    /**
     * @Fields guid 用户id
     */
    private String guid;

    /**
     * @Fields docid 医生编号
     */
    private String docid;

    /**
     * @Fields sex 性别
     */
    private String sex;

    /**
     * @Fields positiontitle 职称
     */
    private String positiontitle;

    /**
     * @Fields docname 医生名字
     */
    private String docname;

    /**
     * @Fields birthday 出生日期
     */
    private String birthday;

    /**
     * @Fields idcard 身份证号
     */
    private String idcard;

    /**
     * @Fields deptid 科室编码
     */
    private String deptid;

    /**
     * @Fields deptname 科室名
     */
    private String deptname;

    /**
     * @Fields hospitalid 医院标示编码(所在医院)
     */
    private String hospitalid;

    /**
     * @Fields hospital 医院名称
     */
    private String hospital;

    /**
     * @Fields medicine 擅长
     */
    private String medicine;

    /**
     * @Fields stat 在不在岗
     */
    private String stat;

    /**
     * @Fields isol 是否离开中( 1：离开中 0：未离开)
     */
    private String isol;

    /**
     * 获取 用户id 字段:DOCTORONDUTY.GUID
     *
     * @return DOCTORONDUTY.GUID, 用户id
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 设置 用户id 字段:DOCTORONDUTY.GUID
     *
     * @param guid the value for DOCTORONDUTY.GUID, 用户id
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     * 获取 医生编号 字段:DOCTORONDUTY.DOCID
     *
     * @return DOCTORONDUTY.DOCID, 医生编号
     */
    public String getDocid() {
        return docid;
    }

    /**
     * 设置 医生编号 字段:DOCTORONDUTY.DOCID
     *
     * @param docid the value for DOCTORONDUTY.DOCID, 医生编号
     */
    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    /**
     * 获取 性别 字段:DOCTORONDUTY.SEX
     *
     * @return DOCTORONDUTY.SEX, 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置 性别 字段:DOCTORONDUTY.SEX
     *
     * @param sex the value for DOCTORONDUTY.SEX, 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取 职称 字段:DOCTORONDUTY.POSITIONTITLE
     *
     * @return DOCTORONDUTY.POSITIONTITLE, 职称
     */
    public String getPositiontitle() {
        return positiontitle;
    }

    /**
     * 设置 职称 字段:DOCTORONDUTY.POSITIONTITLE
     *
     * @param positiontitle the value for DOCTORONDUTY.POSITIONTITLE, 职称
     */
    public void setPositiontitle(String positiontitle) {
        this.positiontitle = positiontitle == null ? null : positiontitle.trim();
    }

    /**
     * 获取 医生名字 字段:DOCTORONDUTY.DOCNAME
     *
     * @return DOCTORONDUTY.DOCNAME, 医生名字
     */
    public String getDocname() {
        return docname;
    }

    /**
     * 设置 医生名字 字段:DOCTORONDUTY.DOCNAME
     *
     * @param docname the value for DOCTORONDUTY.DOCNAME, 医生名字
     */
    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    /**
     * 获取 出生日期 字段:DOCTORONDUTY.BIRTHDAY
     *
     * @return DOCTORONDUTY.BIRTHDAY, 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置 出生日期 字段:DOCTORONDUTY.BIRTHDAY
     *
     * @param birthday the value for DOCTORONDUTY.BIRTHDAY, 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取 身份证号 字段:DOCTORONDUTY.IDCARD
     *
     * @return DOCTORONDUTY.IDCARD, 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置 身份证号 字段:DOCTORONDUTY.IDCARD
     *
     * @param idcard the value for DOCTORONDUTY.IDCARD, 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 获取 科室编码 字段:DOCTORONDUTY.DEPTID
     *
     * @return DOCTORONDUTY.DEPTID, 科室编码
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * 设置 科室编码 字段:DOCTORONDUTY.DEPTID
     *
     * @param deptid the value for DOCTORONDUTY.DEPTID, 科室编码
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    /**
     * 获取 科室名 字段:DOCTORONDUTY.DEPTNAME
     *
     * @return DOCTORONDUTY.DEPTNAME, 科室名
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * 设置 科室名 字段:DOCTORONDUTY.DEPTNAME
     *
     * @param deptname the value for DOCTORONDUTY.DEPTNAME, 科室名
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    /**
     * 获取 医院标示编码(所在医院) 字段:DOCTORONDUTY.HOSPITALID
     *
     * @return DOCTORONDUTY.HOSPITALID, 医院标示编码(所在医院)
     */
    public String getHospitalid() {
        return hospitalid;
    }

    /**
     * 设置 医院标示编码(所在医院) 字段:DOCTORONDUTY.HOSPITALID
     *
     * @param hospitalid the value for DOCTORONDUTY.HOSPITALID, 医院标示编码(所在医院)
     */
    public void setHospitalid(String hospitalid) {
        //this.hospitalid = hospitalid == null ? null : hospitalid.trim();
        this.hospitalid = "xuhui";
    }

    /**
     * 获取 医院名称 字段:DOCTORONDUTY.HOSPITAL
     *
     * @return DOCTORONDUTY.HOSPITAL, 医院名称
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * 设置 医院名称 字段:DOCTORONDUTY.HOSPITAL
     *
     * @param hospital the value for DOCTORONDUTY.HOSPITAL, 医院名称
     */
    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    /**
     * 获取 擅长 字段:DOCTORONDUTY.MEDICINE
     *
     * @return DOCTORONDUTY.MEDICINE, 擅长
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * 设置 擅长 字段:DOCTORONDUTY.MEDICINE
     *
     * @param medicine the value for DOCTORONDUTY.MEDICINE, 擅长
     */
    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }

    /**
     * 获取 在不在岗 字段:DOCTORONDUTY.STAT
     *
     * @return DOCTORONDUTY.STAT, 在不在岗
     */
    public String getStat() {
        return stat;
    }

    /**
     * 设置 在不在岗 字段:DOCTORONDUTY.STAT
     *
     * @param stat the value for DOCTORONDUTY.STAT, 在不在岗
     */
    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    /**
     * 获取 是否离开中( 1：离开中 0：未离开) 字段:DOCTORONDUTY.ISOL
     *
     * @return DOCTORONDUTY.ISOL, 是否离开中( 1：离开中 0：未离开)
     */
    public String getIsol() {
        return isol;
    }

    /**
     * 设置 是否离开中( 1：离开中 0：未离开) 字段:DOCTORONDUTY.ISOL
     *
     * @param isol the value for DOCTORONDUTY.ISOL, 是否离开中( 1：离开中 0：未离开)
     */
    public void setIsol(String isol) {
        this.isol = isol == null ? null : isol.trim();
    }
}