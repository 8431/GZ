package com.gz.medicine.yun.doctor.reponse;

import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.yun.doctor.bean.DTsickblhdr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName PatientsDetailsReponse
 * @PackageName com.gz.medicine.yun.doctor.reponse
 * @Description 患者详情
 * @Data 2017-08-17 14:02
 **/
public class PatientsDetailsReponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 患者
     */
    private Map<String,String> usr;

    /**
     *就诊记录
     */
    private List<DTsickblhdr> dTsickblhdr;


    public Map<String, String> getUsr() {
        return usr;
    }

    public void setUsr(Map<String, String> usr) {
        this.usr = usr;
    }

    public List<DTsickblhdr> getdTsickblhdr() {
        return dTsickblhdr;
    }

    public void setdTsickblhdr(List<DTsickblhdr> dTsickblhdr) {
        this.dTsickblhdr = dTsickblhdr;
    }

    public PatientsDetailsReponse() {
    }

    public PatientsDetailsReponse(Map<String, String> usr, List<DTsickblhdr> dTsickblhdr) {
        this.usr = usr;
        this.dTsickblhdr = dTsickblhdr;
    }

    @Override
    public String toString() {
        return "PatientsDetailsReponse{" +
                "usr=" + usr +
                ", dTsickblhdr=" + dTsickblhdr +
                '}';
    }
}
