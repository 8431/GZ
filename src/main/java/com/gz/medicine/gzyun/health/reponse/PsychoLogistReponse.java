package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName PsychoLogistReponse
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 心理医生列表 响应数据
 * @Data 2017-09-21 10:47
 **/
public class PsychoLogistReponse implements Serializable{

    private static final long serialVersionUID = -8397153891324351719L;

    /**
     * 医生ID
     */
    private String docid;
    /**
     * 医生名字
     */
    private String docname;

    /**
     * 医生头像
     */
    private String ftpurl;

    /**
     * 好评率
     */
    private String score;

    /**
     * 职称
     */
    private String titlename;

    /**
     * 图文价格
     */
    private String begood;

    /**
     * 图文价格
     */
    private String graphicprice;

    /**
     * 语音价格
     */
    private String speechprice;

    /**
     * 视频价格
     */
    private String videoprice;


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

    private String ordersum;

    private String state;

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        if("".equals(score)||score==null){
            this.score = "5";
        }else{
            this.score = score;
//        else
        }
//        {
//            Double d=Double.parseDouble(score);
//            DecimalFormat df = new DecimalFormat("#.0");
//            this.score=df.format(d / 1000);
//        }

    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getBegood() {
        return begood;
    }

    public void setBegood(String begood) {
        this.begood = begood;
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

    public String getFtpurl() {
        return ftpurl;
    }

    public void setFtpurl(String ftpurl) {
        this.ftpurl = ftpurl;
    }

    public PsychoLogistReponse() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(String ordersum) {
        this.ordersum = ordersum;
    }

    @Override
    public String toString() {
        return "PsychoLogistReponse{" +
                "docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", ftpurl='" + ftpurl + '\'' +
                ", score='" + score + '\'' +
                ", titlename='" + titlename + '\'' +
                ", begood='" + begood + '\'' +
                ", graphicprice='" + graphicprice + '\'' +
                ", speechprice='" + speechprice + '\'' +
                ", videoprice='" + videoprice + '\'' +
                ", imageservice='" + imageservice + '\'' +
                ", voiceservice='" + voiceservice + '\'' +
                ", videoservice='" + videoservice + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
