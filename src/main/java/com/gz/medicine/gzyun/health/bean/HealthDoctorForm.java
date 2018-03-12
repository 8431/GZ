/*
*  HealthDoctorForm.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-10-28
*/
package com.gz.medicine.gzyun.health.bean;

import java.util.Date;
import java.util.List;

/**
 * @Title HEALTHDOCTORFORM表的实体类
 * @Description 医生排班表
 * @version 1.0
 * @param <docid>
 * @Author fendo
 * @Date 2017-10-28 10:03:27
 */
public class  HealthDoctorForm<docid> {
    /**
     * @Fields id 主键
     */
    private String id;

    /**
     * @Fields docid 医生id
     */
    private String docid;

    /**
     * @Fields formdate 排班日期
     */
    private String formdate;

    /**
     * @Fields formstarttime 排班开始时间
     */
    private String formstarttime;

    /**
     * @Fields formendtime 排班结束时间
     */
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


    private String intervaldate;

    private String schedulingdays;
    
    private String name;
    
    private String formtimes;
    
    private String starttime;
    
    /**
     * 获取 主键 字段:HEALTHDOCTORFORM.ID
     *
     * @return HEALTHDOCTORFORM.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTHDOCTORFORM.ID
     *
     * @param id the value for HEALTHDOCTORFORM.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 医生id 字段:HEALTHDOCTORFORM.DOCID
     *
     * @return HEALTHDOCTORFORM.DOCID, 医生id
     */
    public String getDocid() {
        return docid;
    }

    /**
     * 设置 医生id 字段:HEALTHDOCTORFORM.DOCID
     *
     * @param docid the value for HEALTHDOCTORFORM.DOCID, 医生id
     */
    public void setDocid(String docid) {
        this.docid = docid == null ? null : docid.trim();
    }

    /**
     * 获取 排班日期 字段:HEALTHDOCTORFORM.FORMDATE
     *
     * @return HEALTHDOCTORFORM.FORMDATE, 排班日期
     */
    public String getFormdate() {
        return formdate;
    }

    /**
     * 设置 排班日期 字段:HEALTHDOCTORFORM.FORMDATE
     *
     * @param formdate the value for HEALTHDOCTORFORM.FORMDATE, 排班日期
     */
    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    /**
     * 获取 排班开始时间 字段:HEALTHDOCTORFORM.FORMSTARTTIME
     *
     * @return HEALTHDOCTORFORM.FORMSTARTTIME, 排班开始时间
     */
    public String getFormstarttime() {
        return formstarttime;
    }

    /**
     * 设置 排班开始时间 字段:HEALTHDOCTORFORM.FORMSTARTTIME
     *
     * @param formstarttime the value for HEALTHDOCTORFORM.FORMSTARTTIME, 排班开始时间
     */
    public void setFormstarttime(String formstarttime) {
        this.formstarttime = formstarttime;
    }

    /**
     * 获取 排班结束时间 字段:HEALTHDOCTORFORM.FORMENDTIME
     *
     * @return HEALTHDOCTORFORM.FORMENDTIME, 排班结束时间
     */
    public String getFormendtime() {
        return formendtime;
    }

    /**
     * 设置 排班结束时间 字段:HEALTHDOCTORFORM.FORMENDTIME
     *
     * @param formendtime the value for HEALTHDOCTORFORM.FORMENDTIME, 排班结束时间
     */
    public void setFormendtime(String formendtime) {
        this.formendtime = formendtime;
    }

    /**
     * 获取 排班状态(0 未预约 1 已预约 2停诊) 字段:HEALTHDOCTORFORM.FORMSTATE
     *
     * @return HEALTHDOCTORFORM.FORMSTATE, 排班状态(0 未预约 1 已预约 2停诊)
     */
    public String getFormstate() {
        return formstate;
    }

    /**
     * 设置 排班状态(0 未预约 1 已预约 2停诊) 字段:HEALTHDOCTORFORM.FORMSTATE
     *
     * @param formstate the value for HEALTHDOCTORFORM.FORMSTATE, 排班状态(0 未预约 1 已预约 2停诊)
     */
    public void setFormstate(String formstate) {
        this.formstate = formstate == null ? null : formstate.trim();
    }

    /**
     * 获取 状态 字段:HEALTHDOCTORFORM.STATE
     *
     * @return HEALTHDOCTORFORM.STATE, 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 状态 字段:HEALTHDOCTORFORM.STATE
     *
     * @param state the value for HEALTHDOCTORFORM.STATE, 状态
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTHDOCTORFORM.CREATEDATE
     *
     * @return HEALTHDOCTORFORM.CREATEDATE, 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置 创建时间 字段:HEALTHDOCTORFORM.CREATEDATE
     *
     * @param createdate the value for HEALTHDOCTORFORM.CREATEDATE, 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取 创建人 字段:HEALTHDOCTORFORM.CREATENAME
     *
     * @return HEALTHDOCTORFORM.CREATENAME, 创建人
     */
    public String getCreatename() {
        return createname;
    }

    /**
     * 设置 创建人 字段:HEALTHDOCTORFORM.CREATENAME
     *
     * @param createname the value for HEALTHDOCTORFORM.CREATENAME, 创建人
     */
    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTHDOCTORFORM.UPDATEDATE
     *
     * @return HEALTHDOCTORFORM.UPDATEDATE, 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置 更新时间 字段:HEALTHDOCTORFORM.UPDATEDATE
     *
     * @param updatedate the value for HEALTHDOCTORFORM.UPDATEDATE, 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取 更新人 字段:HEALTHDOCTORFORM.UPDATENAME
     *
     * @return HEALTHDOCTORFORM.UPDATENAME, 更新人
     */
    public String getUpdatename() {
        return updatename;
    }

    /**
     * 设置 更新人 字段:HEALTHDOCTORFORM.UPDATENAME
     *
     * @param updatename the value for HEALTHDOCTORFORM.UPDATENAME, 更新人
     */
    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

    public String getIntervaldate() {
        return intervaldate;
    }

    public void setIntervaldate(String intervaldate) {
        this.intervaldate = intervaldate;
    }

    public String getSchedulingdays() {
        return schedulingdays;
    }

    public void setSchedulingdays(String schedulingdays) {
        this.schedulingdays = schedulingdays;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormtimes() {
		return formtimes;
	}

	public void setFormtimes(String formtimes) {
		this.formtimes = formtimes;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
    
    
}