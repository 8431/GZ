package com.gz.medicine.gzyun.health.reponse;

import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthDoctorFormReponse
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 医生排班 响应数据
 * @Data 2017-09-21 10:47
 **/
public class HealthDoctorFormReponse implements Serializable{

    /**
     * 排班日期
     */
    String formDate;

    List<HealthDoctorForm> healthDoctorFormReponseList;

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public List<HealthDoctorForm> getHealthDoctorFormReponseList() {
        return healthDoctorFormReponseList;
    }

    public void setHealthDoctorFormReponseList(List<HealthDoctorForm> healthDoctorFormReponseList) {
        this.healthDoctorFormReponseList = healthDoctorFormReponseList;
    }
}
