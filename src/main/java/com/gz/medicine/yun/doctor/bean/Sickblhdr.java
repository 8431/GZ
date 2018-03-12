/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.bean;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @Title Sickblhdr表的实体类
 * @Description 病历表
 * @version 1.0
 * @Author fendo
 * @Date 2017年12月22日 10时23分36秒 星期五 
 */
public class Sickblhdr implements Serializable{ 


    private static final long serialVersionUID = 1L;
 
    /**
    *  内部唯一编号
    */  
    private String guid;
    /**
    *  就诊卡号
    */  
    private String cardid;
    /**
    *  姓名
    */  
    private String name;
    /**
    *  性别
    */  
    private String sex;
    /**
    *  科别
    */  
    private String dept;
    /**
    *  年龄
    */  
    private String age;
    /**
    *  过敏史
    */  
    private String gms;
    /**
    *  病例日期
    */  
    private Date bldat;
    /**
    *  主诉
    */  
    private String mainn;
    /**
    *  现病史
    */  
    private String xbs;
    /**
    *  既往史
    */  
    private String jws;
    /**
    *  身高
    */  
    private String height;
    /**
    *  体重
    */  
    private String weight;
    /**
    *  血压上
    */  
    private String xy1;
    /**
    *  血压下
    */  
    private String xy2;
    /**
    *  体温
    */  
    private String tw;
    /**
    *  心率
    */  
    private String xl;
    /**
    *  其他
    */  
    private String other;
    /**
    *  初步诊断
    */  
    private String zhand;
    /**
    *  注意事项
    */  
    private String note;
    /**
    *  保健方案
    */  
    private String bjfa;
    /**
    *  方案类型
    */  
    private String doutyp;
    /**
    *  平台预约日期
    */  
    private String pre;
    /**
    *  医师
    */  
    private String doc;
    /**
    *  日期
    */  
    private Date wdat;
    /**
    *  账套
    */  
    private String acc;
    /**
    *  组织
    */  
    private String org;
    /**
    *  病人帐号guid
    */  
    private String sickguid;
    /**
    *  医生guid
    */  
    private String docguid;
    /**
    *  预约号
    */  
    private String preno;
    /**
    *  预约建议
    */  
    private String prenote;
    /**
    *  诊断名称
    */  
    private String zdnam;
    /**
    *  主诉名称
    */  
    private String mainne;
    /**
    *  现病史名称
    */  
    private String xbsnam;
    /**
    *  创建日期
    */  
    private Date crtdat;
    /**
    *  转诊医生
    */  
    private String changdoc;
    /**
    *  发送渠道
    */  
    private String sendka;
    /**
    *  电话
    */  
    private String telephone;
    /**
    *  随访，0：未随访，1：已随访
    */  
    private String isfollow;
    /**
    *  平台预约时间
    */  
    private String pretim;
    /**
    *  所在机构
    */  
    private String deptid;
    /**
    *  血糖
    */  
    private String clucose;
    /**
    *  血氧
    */  
    private String glucose;
    /**
    *  线下预约日期
    */  
    private String linedate;
    /**
    *  线下预约时间
    */  
    private String linetime;
    /**
    *  订单状态,1：确认，2：未确认，3：正在配送，4：取消，5:已完成
    */  
    private String orderstatus;
    /**
    *  药购买方式，1：线上配送，2:线下自提，3：无需购药
    */  
    private String medicineway;
    /**
    *  LOC表的guid
    */  
    private String locguid;
    /**
    *  处方是否已发送给第三方药店1是0否
    */  
    private String sendflg;
    /**
    *  费别
    */  
    private String ybtyp;
    /**
    *  是否已视频推送；0：未，1：已
    */  
    private String isvideopush;
    /**
    *  进一步检查
    */  
    private String noteext;
    /**
    *  门诊号
    */  
    private String mzid;
    /**
    *  住院号
    */  
    private String zyid;
    /**
    *  心功能
    */  
    private String chkxgn;
    /**
    *  肌力
    */  
    private String chkjl;
    /**
    *  平衡
    */  
    private String chkph;
    /**
    *  柔韧
    */  
    private String chkrr;
    /**
    *  辅助检查
    */  
    private String checkxt;
    /**
    *  复诊诊断
    */  
    private String fzzd;
    /**
    *  复诊疗效小结及评定
    */  
    private String fzzdnote;
    /**
    *  处方类型1康复
    */  
    private String cftyp;
    /**
    *  医保卡号
    */  
    private String medicarecard;
    /**
    *  出生日期
    */  
    private String birthday;
    /**
    *  就诊卡号
    */  
    private String medicalid;

    /**
     * 年龄选项(岁、月、天)
     */
    private String ageoptions;

    /**
     * 就诊科别(case1：来源于布点医疗结构，显示为远程医疗；case2：其他情况，显示为远程咨询)
     */
    private String codon;

    /**
     * 预约门诊就诊时间
     */
    private Date clinicaltime;

    /**
     * 预约门诊就诊时间时段(上午，下午)
     */
    private String periodtime;

    /**
     *   创建人
     */
    private String createname;
    /**
     *   更新人
     */
    private String updatename;
    /**
     *   更新时间
     */
    private Date updatedate;

    public Sickblhdr(){
    } 
    
    public String getGuid(){    
      return this.guid;    
    }

    public void setGuid(String guid){    
      this.guid = guid;    
    }    
    public String getCardid(){    
      return this.cardid;    
    }

    public void setCardid(String cardid){    
      this.cardid = cardid;    
    }    
    public String getName(){    
      return this.name;    
    }

    public void setName(String name){    
      this.name = name;    
    }    
    public String getSex(){    
      return this.sex;    
    }

    public void setSex(String sex){    
      this.sex = sex;    
    }    
    public String getDept(){    
      return this.dept;    
    }

    public void setDept(String dept){    
      this.dept = dept;    
    }    
    public String getAge(){    
      return this.age;    
    }

    public void setAge(String age){    
      this.age = age;    
    }    
    public String getGms(){    
      return this.gms;    
    }

    public void setGms(String gms){    
      this.gms = gms;    
    }    
    public Date getBldat(){    
      return this.bldat;    
    }

    public void setBldat(Date bldat){    
      this.bldat = bldat;    
    }    
    public String getMainn(){    
      return this.mainn;    
    }

    public void setMainn(String mainn){    
      this.mainn = mainn;    
    }    
    public String getXbs(){    
      return this.xbs;    
    }

    public void setXbs(String xbs){    
      this.xbs = xbs;    
    }    
    public String getJws(){    
      return this.jws;    
    }

    public void setJws(String jws){    
      this.jws = jws;    
    }    
    public String getHeight(){    
      return this.height;    
    }

    public void setHeight(String height){    
      this.height = height;    
    }    
    public String getWeight(){    
      return this.weight;    
    }

    public void setWeight(String weight){    
      this.weight = weight;    
    }    
    public String getXy1(){    
      return this.xy1;    
    }

    public void setXy1(String xy1){    
      this.xy1 = xy1;    
    }    
    public String getXy2(){    
      return this.xy2;    
    }

    public void setXy2(String xy2){    
      this.xy2 = xy2;    
    }    
    public String getTw(){    
      return this.tw;    
    }

    public void setTw(String tw){    
      this.tw = tw;    
    }    
    public String getXl(){    
      return this.xl;    
    }

    public void setXl(String xl){    
      this.xl = xl;    
    }    
    public String getOther(){    
      return this.other;    
    }

    public void setOther(String other){    
      this.other = other;    
    }    
    public String getZhand(){    
      return this.zhand;    
    }

    public void setZhand(String zhand){    
      this.zhand = zhand;    
    }    
    public String getNote(){    
      return this.note;    
    }

    public void setNote(String note){    
      this.note = note;    
    }    
    public String getBjfa(){    
      return this.bjfa;    
    }

    public void setBjfa(String bjfa){    
      this.bjfa = bjfa;    
    }    
    public String getDoutyp(){    
      return this.doutyp;    
    }

    public void setDoutyp(String doutyp){    
      this.doutyp = doutyp;    
    }    
    public String getPre(){    
      return this.pre;    
    }

    public void setPre(String pre){    
      this.pre = pre;    
    }    
    public String getDoc(){    
      return this.doc;    
    }

    public void setDoc(String doc){    
      this.doc = doc;    
    }    
    public Date getWdat(){    
      return this.wdat;    
    }

    public void setWdat(Date wdat){    
      this.wdat = wdat;    
    }    
    public String getAcc(){    
      return this.acc;    
    }

    public void setAcc(String acc){    
      this.acc = acc;    
    }    
    public String getOrg(){    
      return this.org;    
    }

    public void setOrg(String org){    
      this.org = org;    
    }    
    public String getSickguid(){    
      return this.sickguid;    
    }

    public void setSickguid(String sickguid){    
      this.sickguid = sickguid;    
    }    
    public String getDocguid(){    
      return this.docguid;    
    }

    public void setDocguid(String docguid){    
      this.docguid = docguid;    
    }    
    public String getPreno(){    
      return this.preno;    
    }

    public void setPreno(String preno){    
      this.preno = preno;    
    }    
    public String getPrenote(){    
      return this.prenote;    
    }

    public void setPrenote(String prenote){    
      this.prenote = prenote;    
    }    
    public String getZdnam(){    
      return this.zdnam;    
    }

    public void setZdnam(String zdnam){    
      this.zdnam = zdnam;    
    }    
    public String getMainne(){    
      return this.mainne;    
    }

    public void setMainne(String mainne){    
      this.mainne = mainne;    
    }    
    public String getXbsnam(){    
      return this.xbsnam;    
    }

    public void setXbsnam(String xbsnam){    
      this.xbsnam = xbsnam;    
    }    
    public Date getCrtdat(){    
      return this.crtdat;    
    }

    public void setCrtdat(Date crtdat){    
      this.crtdat = crtdat;    
    }    
    public String getChangdoc(){    
      return this.changdoc;    
    }

    public void setChangdoc(String changdoc){    
      this.changdoc = changdoc;    
    }    
    public String getSendka(){    
      return this.sendka;    
    }

    public void setSendka(String sendka){    
      this.sendka = sendka;    
    }    
    public String getTelephone(){    
      return this.telephone;    
    }

    public void setTelephone(String telephone){    
      this.telephone = telephone;    
    }    
    public String getIsfollow(){    
      return this.isfollow;    
    }

    public void setIsfollow(String isfollow){    
      this.isfollow = isfollow;    
    }    
    public String getPretim(){    
      return this.pretim;    
    }

    public void setPretim(String pretim){    
      this.pretim = pretim;    
    }    
    public String getDeptid(){    
      return this.deptid;    
    }

    public void setDeptid(String deptid){    
      this.deptid = deptid;    
    }    
    public String getClucose(){    
      return this.clucose;    
    }

    public void setClucose(String clucose){    
      this.clucose = clucose;    
    }    
    public String getGlucose(){    
      return this.glucose;    
    }

    public void setGlucose(String glucose){    
      this.glucose = glucose;    
    }    
    public String getLinedate(){    
      return this.linedate;    
    }

    public void setLinedate(String linedate){    
      this.linedate = linedate;    
    }    
    public String getLinetime(){    
      return this.linetime;    
    }

    public void setLinetime(String linetime){    
      this.linetime = linetime;    
    }    
    public String getOrderstatus(){    
      return this.orderstatus;    
    }

    public void setOrderstatus(String orderstatus){    
      this.orderstatus = orderstatus;    
    }    
    public String getMedicineway(){    
      return this.medicineway;    
    }

    public void setMedicineway(String medicineway){    
      this.medicineway = medicineway;    
    }    
    public String getLocguid(){    
      return this.locguid;    
    }

    public void setLocguid(String locguid){    
      this.locguid = locguid;    
    }    
    public String getSendflg(){    
      return this.sendflg;    
    }

    public void setSendflg(String sendflg){    
      this.sendflg = sendflg;    
    }    
    public String getYbtyp(){    
      return this.ybtyp;    
    }

    public void setYbtyp(String ybtyp){    
      this.ybtyp = ybtyp;    
    }    
    public String getIsvideopush(){    
      return this.isvideopush;    
    }

    public void setIsvideopush(String isvideopush){    
      this.isvideopush = isvideopush;    
    }    
    public String getNoteext(){    
      return this.noteext;    
    }

    public void setNoteext(String noteext){    
      this.noteext = noteext;    
    }    
    public String getMzid(){    
      return this.mzid;    
    }

    public void setMzid(String mzid){    
      this.mzid = mzid;    
    }    
    public String getZyid(){    
      return this.zyid;    
    }

    public void setZyid(String zyid){    
      this.zyid = zyid;    
    }    
    public String getChkxgn(){    
      return this.chkxgn;    
    }

    public void setChkxgn(String chkxgn){    
      this.chkxgn = chkxgn;    
    }    
    public String getChkjl(){    
      return this.chkjl;    
    }

    public void setChkjl(String chkjl){    
      this.chkjl = chkjl;    
    }    
    public String getChkph(){    
      return this.chkph;    
    }

    public void setChkph(String chkph){    
      this.chkph = chkph;    
    }    
    public String getChkrr(){    
      return this.chkrr;    
    }

    public void setChkrr(String chkrr){    
      this.chkrr = chkrr;    
    }    
    public String getCheckxt(){    
      return this.checkxt;    
    }

    public void setCheckxt(String checkxt){    
      this.checkxt = checkxt;    
    }    
    public String getFzzd(){    
      return this.fzzd;    
    }

    public void setFzzd(String fzzd){    
      this.fzzd = fzzd;    
    }    
    public String getFzzdnote(){    
      return this.fzzdnote;    
    }

    public void setFzzdnote(String fzzdnote){    
      this.fzzdnote = fzzdnote;    
    }    
    public String getCftyp(){    
      return this.cftyp;    
    }

    public void setCftyp(String cftyp){    
      this.cftyp = cftyp;    
    }    
    public String getMedicarecard(){    
      return this.medicarecard;    
    }

    public void setMedicarecard(String medicarecard){    
      this.medicarecard = medicarecard;    
    }    
    public String getBirthday(){    
      return this.birthday;    
    }

    public void setBirthday(String birthday){    
      this.birthday = birthday;    
    }    
    public String getMedicalid(){    
      return this.medicalid;    
    }

    public void setMedicalid(String medicalid){    
      this.medicalid = medicalid;    
    }

    public String getAgeoptions() {
        return ageoptions;
    }

    public void setAgeoptions(String ageoptions) {
        this.ageoptions = ageoptions;
    }

    public String getCodon() {
        return codon;
    }

    public void setCodon(String codon) {
        this.codon = codon;
    }

    public Date getClinicaltime() {
        return clinicaltime;
    }

    public void setClinicaltime(Date clinicaltime) {
        this.clinicaltime = clinicaltime;
    }

    public String getPeriodtime() {
        return periodtime;
    }

    public void setPeriodtime(String periodtime) {
        this.periodtime = periodtime;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}