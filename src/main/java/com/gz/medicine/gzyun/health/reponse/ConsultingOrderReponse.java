package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName ConsultingOrderReponse
 * @PackageName com.gz.medicine.gzyun.health.reponse
 * @Description 咨询订单 响应数据
 * @Data 2017-09-21 10:47
 **/
public class ConsultingOrderReponse implements Serializable {
    private static final long serialVersionUID = 3189742347654724006L;

    /**
     * 医生ID
     */
    private  String docid;
    /**
     * 医生名字
     */
    private  String docname;
    /**
     * 医生职称
     */
    private String doctitle;
    /**
     * 咨询价格
     */
    private String consultationprice;
    /**
     * 医生头像
     */
    private String photoid;
    /**
     * 患者姓名
     */
    private String name;
    /**
     * 患者ID
     */
    private String usrid;

    /**
     * 年龄
     */
    private String age;

    /**
     * 患者性别
     */
    private String sex;
    /**
     * 患者出生年月
     */
    private String birthday;
    /**
     * 联系电话
     */
    private String mobile;

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

    public String getConsultationprice() {
        return consultationprice;
    }

    public void setConsultationprice(String consultationprice) {
        this.consultationprice = consultationprice;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ConsultingOrderReponse() {
    }


    public ConsultingOrderReponse(String docid, String docname, String doctitle, String consultationprice, String photoid, String name, String usrid, String age, String sex, String birthday, String mobile) {
        this.docid = docid;
        this.docname = docname;
        this.doctitle = doctitle;
        this.consultationprice = consultationprice;
        this.photoid = photoid;
        this.name = name;
        this.usrid = usrid;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "ConsultingOrderReponse{" +
                "docid='" + docid + '\'' +
                ", docname='" + docname + '\'' +
                ", doctitle='" + doctitle + '\'' +
                ", consultationprice='" + consultationprice + '\'' +
                ", photoid='" + photoid + '\'' +
                ", name='" + name + '\'' +
                ", usrid='" + usrid + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
