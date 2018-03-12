package com.gz.medicine.gzyun.health.reponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 维维
 * <p>
 * Title:HealthyOrderReponse
 * </p>
 * <p>
 * Description:TODO(订单消息接口)
 * </p>
 * <p>
 * Company:贯众
 * </p>
 * <p>
 * 数据库:
 * </p>
 * @author
 * @date 2017年9月22日
 */
public class HealthyOrderReponse {

    private String docid;

    private String usrid;

    private String usrname;

    private String healthytypesettingtime;

    private String consultationmethod;

    private String loginid;

    private String schedulingdays;

    private String intervalDate;

    private String imgguid;

    private String reservationtime;

    private String reservationphotoid;

    private String consultingdescription;

    private String ftpurl;

    private String updatedate;

    private List<String> reservationphotoidList = new ArrayList<String>();

    public HealthyOrderReponse() {
        // TODO Auto-generated constructor stub
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }


    public String getHealthytypesettingtime() {
        return healthytypesettingtime;
    }

    public void setHealthytypesettingtime(String healthytypesettingtime) {
        this.healthytypesettingtime = healthytypesettingtime;
    }

    public String getConsultationmethod() {
        return consultationmethod;
    }

    public void setConsultationmethod(String consultationmethod) {
        this.consultationmethod = consultationmethod;
    }


    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }


    public String getIntervalDate() {
        return intervalDate;
    }

    public void setIntervalDate(String intervalDate) {
        this.intervalDate = intervalDate;
    }

    public String getSchedulingdays() {
        return schedulingdays;
    }

    public void setSchedulingdays(String schedulingdays) {
        this.schedulingdays = schedulingdays;
    }

    public String getImgguid() {
        return imgguid;
    }

    public void setImgguid(String imgguid) {
        this.imgguid = imgguid;
    }

    public String getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(String reservationtime) {
        this.reservationtime = reservationtime;
    }

    public String getReservationphotoid() {
        return reservationphotoid;
    }

    public void setReservationphotoid(String reservationphotoid) {
        this.reservationphotoid = reservationphotoid;
    }

    public String getConsultingdescription() {
        return consultingdescription;
    }

    public void setConsultingdescription(String consultingdescription) {
        this.consultingdescription = consultingdescription;
    }

    public String getFtpurl() {
        return ftpurl;
    }

    public void setFtpurl(String ftpurl) {
        this.ftpurl = ftpurl;
    }

    public List<String> getReservationphotoidList() {
        return reservationphotoidList;
    }

    public void setReservationphotoidList(List<String> reservationphotoidList) {
        this.reservationphotoidList = reservationphotoidList;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate.substring(0,updatedate.length()-2);
    }
}
