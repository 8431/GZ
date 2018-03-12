package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.vaild.DateCheck;
import com.gz.medicine.gzyun.health.vaild.MobileCheck;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName OrderSubmittedRequest
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 订单提交 请求数据
 * @Data 2017-09-21 10:47
 **/
public class OrderSubmittedRequest implements Serializable {


    private static final long serialVersionUID = 6500948522947669926L;

    /**
     * 患者ID
     */
    @NotEmpty(message="患者ID不能为空！")
    String usrid;

    /**
     * 患者姓名
     */
    @NotEmpty(message="患者姓名不能为空")
    String username;

    /**
     * 患者性别
     */
    @NotEmpty(message="患者性别不能为空！")
    String usersex;

    /**
     * 出生日期
     */
    @DateCheck(type="YYYY-MM-DD",message="请输入正确的出生日期!!!!")
    @NotEmpty(message="出生日期不能为空！")
    String usrbirth;

    /**
     * 预约日期
     */
    @DateCheck(type="YYYY-MM-DD",message="请输入正确的预约日期!!!!")
    @NotEmpty(message="预约日期不能为空！")
    String reservationdate;

    /**
     * 预约开始时间
     */
    @DateCheck(type="HH:MI",message="请输入正确的预约开始时间!!!!")
    @NotEmpty(message="预约开始时间不能为空！")
    String reserstarttime;

    /**
     * 预约结束时间
     */
    @DateCheck(type="HH:MI",message="请输入正确的预约结束时间!!!!")
    @NotEmpty(message="预约结束时间不能为空！")
    String reserendtime;


    /**
     * 医生ID
     */
    @NotEmpty(message="医生ID不能为空！")
    String docid;
    /**
     * 症状描述
     */
    @NotEmpty(message="症状描述不能为空！")
    String reservationdescription;
    /**
     * 咨询类型
     */
    @NotEmpty(message="咨询类型不能为空！")
    String consultationmethod;

    /**
     * 订单金额
     */
    String orderamount;

    /**
     * 预约时段
     */
    String reservationperiod;

    /**
     * 预约时间
     */
    String reservationtime;


    /**
     * 预约图
     */
    String reservationphotoid;


    /**
     * 创建人
     */
    @NotEmpty(message="创建人不能为空！")
    String createname;


    /**
     * 手机号码
     */
    @NotEmpty(message="手机号码不能为空！")
    @MobileCheck(message="请输入正确的手机号！")
    String usrphone;

    public String getUsrid() {
        return usrid;
    }


    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getReservationdescription() {
        return reservationdescription;
    }

    public void setReservationdescription(String reservationdescription) {
        this.reservationdescription = reservationdescription;
    }

    public String getConsultationmethod() {
        return consultationmethod;
    }

    public void setConsultationmethod(String consultationmethod) {
        this.consultationmethod = consultationmethod;
    }

    public String getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount;
    }

    public String getReservationperiod() {
        return reservationperiod;
    }

    public void setReservationperiod(String reservationperiod) {
        this.reservationperiod = reservationperiod;
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

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getUsrphone() {
        return usrphone;
    }

    public void setUsrphone(String usrphone) {
        this.usrphone = usrphone;
    }

    public String getReservationdate() {
        return reservationdate;
    }

    public void setReservationdate(String reservationdate) {
        this.reservationdate = reservationdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUsrbirth() {
        return usrbirth;
    }

    public void setUsrbirth(String usrbirth) {
        this.usrbirth = usrbirth;
    }

    public String getReserstarttime() {
        return reserstarttime;
    }

    public void setReserstarttime(String reserstarttime) {
        this.reserstarttime = reserstarttime;
    }

    public String getReserendtime() {
        return reserendtime;
    }

    public void setReserendtime(String reserendtime) {
        this.reserendtime = reserendtime;
    }
}
