package com.gz.medicine.yun.doctor.request;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTfollowupRecordRequest
 * @PackageName com.gz.medicine.yun.doctor.request
 * @Description 随访信息请求实体类
 * @Data 2017-08-24 13:23
 **/
public class DTfollowupRecordRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "病历ID不能为空")
    private String sicguid;

    @NotEmpty(message = "随访内容不能为空")
    private String followoption;

    @NotEmpty(message = "医生ID不能为空!")
    private String docguid;// '医生guid'

    @NotEmpty(message = "患者ID不能为空!")
    private String usrguid;// '患者guid'

    //@Min(value=1, message="体温不能为空最低为1")
    @NotNull(message = "体温不能为空!")
    private Double temperature;// '体温'

    //@Min(value=1, message="体重不能为空最低为1")
    @NotNull(message = "体重不能为空!")
    private Double weight;// '体重'

    //@Min(value=1, message="心率不能为空最低为1")
    @NotNull(message = "心率不能为空!")
    private Double heartrate;// '心率'

    //@Min(value=1, message="血糖不能为空最低为1")
    @NotNull(message = "血糖不能为空!")
    private Double bloodsugar;// '血糖';

    //@Min(value=1, message="血压(高)不能为空最低1")
    @NotNull(message = "血压(高)不能为空!")
    private Double bloodpressureh;// '血压(高)'

    //@Min(value=1, message="血压(低)不能为空最低1")
    @NotNull(message = "血压(低)不能为空!")
    private Double bloodpressurel;// '血压(低)'

    //@Min(value=1, message="血氧不能为空最低1")
    @NotNull(message = "血氧不能为空!")
    private Double bloodoxygen;// '血氧'

    @NotEmpty(message = "随访结论不能为空!")
    private String followconclusion;// '随访结论'

    private String crtusr;

    private String org;// '系统编号'

    private String guid;// '内部唯一编号'

    private Date crtdat;// '创建时间'

    private Date followdatetime;//随访时间

    private String planguid;  //随访ID

    /**
     * 健康方案
     */
    private String healthprogramme;

    /**
     * 注意事项
     */
    private String needattention;

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid;
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid;
    }

    public String getSicguid() {
        return sicguid;
    }

    public void setSicguid(String sicguid) {
        this.sicguid = sicguid;
    }

    public String getFollowoption() {
        return followoption;
    }

    public void setFollowoption(String followoption) {
        this.followoption = followoption;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(Double heartrate) {
        this.heartrate = heartrate;
    }

    public Double getBloodsugar() {
        return bloodsugar;
    }

    public void setBloodsugar(Double bloodsugar) {
        this.bloodsugar = bloodsugar;
    }

    public Double getBloodpressureh() {
        return bloodpressureh;
    }

    public void setBloodpressureh(Double bloodpressureh) {
        this.bloodpressureh = bloodpressureh;
    }

    public Double getBloodpressurel() {
        return bloodpressurel;
    }

    public void setBloodpressurel(Double bloodpressurel) {
        this.bloodpressurel = bloodpressurel;
    }

    public Double getBloodoxygen() {
        return bloodoxygen;
    }

    public void setBloodoxygen(Double bloodoxygen) {
        this.bloodoxygen = bloodoxygen;
    }

    public String getFollowconclusion() {
        return followconclusion;
    }

    public void setFollowconclusion(String followconclusion) {
        this.followconclusion = followconclusion;
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public Date getFollowdatetime() {
        return followdatetime;
    }

    public void setFollowdatetime(Date followdatetime) {
        this.followdatetime = followdatetime;
    }

    public String getPlanguid() {
        return planguid;
    }

    public void setPlanguid(String planguid) {
        this.planguid = planguid;
    }

    public String getHealthprogramme() {
        return healthprogramme;
    }

    public void setHealthprogramme(String healthprogramme) {
        this.healthprogramme = healthprogramme;
    }

    public String getNeedattention() {
        return needattention;
    }

    public void setNeedattention(String needattention) {
        this.needattention = needattention;
    }
}

