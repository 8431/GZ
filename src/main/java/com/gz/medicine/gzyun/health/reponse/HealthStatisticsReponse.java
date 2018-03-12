package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by w维维 on 2017/10/31.
 */
public class HealthStatisticsReponse  implements Serializable{
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

    //排班时间段
    private String intervaldate ;

    //排班list
    private List<String> recordList = new ArrayList<String>();

    //排班天数
    private String schedulingdays;

    private String state;
    /**
     * @Fields formstate 排班状态(0 未预约 1 已预约 2停诊)
     */
    private String formstate;

    public HealthStatisticsReponse() {
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

    public String getIntervaldate() {
        return intervaldate;
    }

    public void setIntervaldate(String intervaldate) {
        this.intervaldate = intervaldate;
    }

    public List<String> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<String> recordList) {
        this.recordList = recordList;
    }

    public String getSchedulingdays() {
        return schedulingdays;
    }

    public void setSchedulingdays(String schedulingdays) {
        this.schedulingdays = schedulingdays;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFormstate() {
        return formstate;
    }

    public void setFormstate(String formstate) {
        this.formstate = formstate;
    }
}
