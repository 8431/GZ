package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName UserRatingReponse
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 用户评价 响应数据
 * @Data 2017-09-21 10:47
 **/
public class UserRatingReponse implements Serializable {
    private static final long serialVersionUID = -4072793419720615486L;

    /**
     * 患者姓名
     */
    private String name;

    /**
     * 评价分数
     */
    private String score;


    /**
     * 评价日期
     */
    private String updatedate;
    /**
     * 评价内容
     */
    private String evaluationdescription;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getEvaluationdescription() {
        return evaluationdescription;
    }

    public void setEvaluationdescription(String evaluationdescription) {
        this.evaluationdescription = evaluationdescription;
    }

    public UserRatingReponse() {
    }

    public UserRatingReponse(String name, String score, String updatedate, String evaluationdescription) {
        this.name = name;
        this.score = score;
        this.updatedate = updatedate;
        this.evaluationdescription = evaluationdescription;
    }

    @Override
    public String toString() {
        return "UserRatingReponse{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", updatedate='" + updatedate + '\'' +
                ", evaluationdescription='" + evaluationdescription + '\'' +
                '}';
    }
}
