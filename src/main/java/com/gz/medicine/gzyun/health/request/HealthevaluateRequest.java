package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.bean.OrderLog;
import com.gz.medicine.gzyun.health.vaild.DateCheck;
import com.gz.medicine.gzyun.health.vaild.IdCardCheck;
import com.gz.medicine.gzyun.health.vaild.InsertCheck;
import org.hibernate.validator.constraints.NotEmpty;


public class HealthevaluateRequest {
    @NotEmpty(message = "医生ID不能为空！")
    private String docid;
    @NotEmpty(message = "患者ID不能为空！")
    private String usrid;

    private String score;

    private String consultationstarttime;

    private String consultinghours;
    private String evaluationdescription;
    @InsertCheck(sql="select * from healthevaluate where state='1' and  consultationid=#{consultationid}",message = "一条咨询只能有一条评价，不允许重复插入")
    private String consultationid ;
    @NotEmpty(message = "订单ID不能为空！")
    private String orderid;

    private String operationaccount;

    private String createname;

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        if(isNumber(score)){
            this.score = score;
        }

    }

    public String getConsultationstarttime() {
        return consultationstarttime;
    }

    public void setConsultationstarttime(String consultationstarttime) {
        this.consultationstarttime = consultationstarttime;
    }

    public String getConsultinghours() {
        return consultinghours;
    }

    public void setConsultinghours(String consultinghours) {
        this.consultinghours = consultinghours;
    }

    public String getEvaluationdescription() {
        return evaluationdescription;
    }

    public void setEvaluationdescription(String evaluationdescription) {
        this.evaluationdescription = evaluationdescription;
    }
    public String getConsultationid() {
        return consultationid;
    }

    public void setConsultationid(String consultationid) {
        this.consultationid = consultationid;
    }


    public static void main(String[] args) {
        System.out.println(isNumber("123"));
    }

    public static boolean isNumber(String s) {
        if(s.trim().isEmpty()){
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if(s.trim().matches(regex)){
            return true;
        }else{
            return false;
        }
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOperationaccount() {
        return operationaccount;
    }

    public void setOperationaccount(String operationaccount) {
        this.operationaccount = operationaccount;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }
}