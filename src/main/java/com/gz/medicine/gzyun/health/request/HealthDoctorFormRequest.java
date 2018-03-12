/*
*  HealthDoctorForm.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.vaild.DateCheck;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Title HEALTHDOCTORFORM表的实体类
 * @Description 医生排班表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-28 10:03:27
 */
public class HealthDoctorFormRequest {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields docid 医生id
     */
    @NotEmpty(message="医生id不能为空.")
    private String docid;

    /**
     * @Fields formdate 排班日期
     */
    @DateCheck(type = "YYYY-MM-DD",message = "日期格式不正确，必须是YYYY-MM-DD,或者填写日期在系统时间体系中不存在。")
    private String formdate;

    /**
     * @Fields formstarttime 排班开始时间
     */
    @DateCheck(type = "HH:MI" ,message = "排班开始时间格式不正确，必须是HH:MI,或者填写日期在系统时间体系中不存在。")
    private String formstarttime;

    /**
     * @Fields formendtime 排班结束时间
     */
    @DateCheck(type = "HH:MI" ,message = "排班结束时间格式不正确，必须是HH:MI，或者填写日期在系统时间体系中不存在。")
    private String formendtime;

    /**
     * @Fields formstate 排班状态(0 未预约 1 已预约 2停诊)
     */
    private String formstate;

    /**
     * @Fields state 状态
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
     * 获取 主键 字段:HEALTHDOCTORFORM.ID
     *
     * @return HEALTHDOCTORFORM.ID, 主键
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getFormstarttime() {
        return formstarttime;
    }

    public void setFormstarttime(String formstarttime) {
        this.formstarttime = formstarttime;
    }

    public String getFormendtime() {
        return formendtime;
    }

    public void setFormendtime(String formendtime) {
        this.formendtime = formendtime;
    }

    public String getFormstate() {
        return formstate;
    }

    public void setFormstate(String formstate) {
        this.formstate = formstate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename;
    }
}