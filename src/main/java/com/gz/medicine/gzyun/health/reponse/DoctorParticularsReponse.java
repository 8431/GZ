package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DoctorParticularsReponse
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 心理医生列表 响应数据
 * @Data 2017-09-21 10:47
 **/
public class DoctorParticularsReponse implements Serializable{

    private static final long serialVersionUID = 8037526496546701306L;

    /**
     * 医生ID
     */
    private String docid;
    /**
     * 医生名字
     */
    private String docname;
    /**
     * 医生职称
     */
    private String doctitle;

    /**
     * 头像URL
     */
    private String ftpurl;

    /**
     * 好评率
     */
    private String praise;
    /**
     * 图文咨询价
     */
    private String graphicprice;
    /**
     * 语音咨询价
     */
    private String speechprice;
    /**
     * 视频咨询价
     */
    private String videoprice;
    /**
     * 图文,语音,视频ID
     */
    private String categoryid;
    /**
     * 资质认证图片(数组)
     */
    private String qualificationsids;
    /**
     * 职业描述
     */
    private String perIntroduction;
    /**
     * 专业培训经历
     */
    private String trainingExperience;
    /**
     * 擅长
     */
    private String begood;

    /**
     * 资历图片认证路径
     */
    private String seniorityurl;

    /**
     * 资历认证图片
     */
    private List<String> seniorityftp;

    /**
     * 图文状态
     */
    private String imageservice;

    /**
     * 语音状态
     */
    private String voiceservice;

    /**
     * 视频状态
     */
    private String videoservice;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }

    public String getDoctitle() {
        return doctitle;
    }

    public void setDoctitle(String doctitle) {
        this.doctitle = doctitle;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        if("".equals(praise)||praise==null){
            this.praise = "5";
        }else {
            this.praise = praise;
//            Double d=Double.parseDouble(praise);
//            DecimalFormat df = new DecimalFormat("#.0");
//            this.praise=df.format(d / 1000);
        }
    }

    public String getGraphicprice() {
        return graphicprice;
    }

    public void setGraphicprice(String graphicprice) {
        this.graphicprice = graphicprice;
    }

    public String getSpeechprice() {
        return speechprice;
    }

    public void setSpeechprice(String speechprice) {
        this.speechprice = speechprice;
    }

    public String getVideoprice() {
        return videoprice;
    }

    public void setVideoprice(String videoprice) {
        this.videoprice = videoprice;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getQualificationsids() {
        return qualificationsids;
    }

    public void setQualificationsids(String qualificationsids) {
        this.qualificationsids = qualificationsids;
    }

    public String getPerIntroduction() {
        return perIntroduction;
    }

    public void setPerIntroduction(String perIntroduction) {
        this.perIntroduction = perIntroduction;
    }

    public String getTrainingExperience() {
        return trainingExperience;
    }

    public void setTrainingExperience(String trainingExperience) {
        this.trainingExperience = trainingExperience;
    }

    public String getBegood() {
        return begood;
    }

    public void setBegood(String begood) {
        this.begood = begood;
    }

    public DoctorParticularsReponse() {
    }

    public String getFtpurl() {
        return ftpurl;
    }

    public void setFtpurl(String ftpurl) {
        this.ftpurl = ftpurl;
    }

    public String getSeniorityurl() {
        return seniorityurl;
    }

    public void setSeniorityurl(String seniorityurl) {
        this.seniorityurl = seniorityurl;
    }

    public List<String> getSeniorityftp() {
        return seniorityftp;
    }

    public void setSeniorityftp(List<String> seniorityftp) {
        this.seniorityftp = seniorityftp;
    }

    public String getImageservice() {
        return imageservice;
    }

    public void setImageservice(String imageservice) {
        //this.imageservice = imageservice;
        if("".equals(imageservice)||imageservice==null){
            this.imageservice="1";
        }else{
            this.imageservice = imageservice;
        }
    }

    public String getVoiceservice() {
        return voiceservice;
    }

    public void setVoiceservice(String voiceservice) {
        //this.voiceservice = voiceservice;
        if("".equals(voiceservice)||voiceservice==null){
            this.voiceservice="1";
        }else{
            this.voiceservice = voiceservice;
        }
    }

    public String getVideoservice() {
        return videoservice;
    }

    public void setVideoservice(String videoservice) {
        //this.videoservice = videoservice;
        if("".equals(videoservice)||videoservice==null){
            this.videoservice="1";
        }else{
            this.videoservice = videoservice;
        }
    }
}
