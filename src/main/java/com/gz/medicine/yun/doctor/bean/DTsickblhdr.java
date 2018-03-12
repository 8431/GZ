package com.gz.medicine.yun.doctor.bean;

import java.util.Date;


/**
 *
 * @Title: DTsickblhdr.java
 * @Package com.gz.medicine.yun.doctor.bean
 * @Description: 病例表
 * @Author fendo
 * @Date 2017年8月17日 上午10:15
 * @Version V1.0
 */

public class DTsickblhdr {


    private String guid;

    private String cardid;

    private String name;

    private String sex;

    private String dept;

    private String age;

    private String gms;

    private Date bldat;

    private String mainn;

    private String xbs;

    private String jws;

    private String height;

    private String weight;

    private String xy1;

    private String xy2;

    private String tw;

    private String xl;

    private String other;

    private String zhand;

    private String note;

    private String bjfa;

    private String doutyp;

    private String pre;

    private String doc;

    private Date wdat;

    private String acc;

    private String org;

    private String sickguid;

    private String docguid;

    private String preno;

    private String prenote;

    private String zdnam;

    private String mainne;

    private String xbsnam;

    private Date crtdat;

    private String changdoc;

    private String sendka;

    private String telephone;

    private String isfollow;

    private String pretim;

    private String deptid;

    private String clucose;

    private String glucose;

    private String linedate;

    private String linetime;

    private String orderstatus;

    private String medicineway;

    private String locguid;

    private String sendflg;

    private String ybtyp;

    private String isvideopush;

    private String noteext;

    //就诊卡号
    private String medicalid;

    //出生年月
    private String birthday;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getGms() {
        return gms;
    }

    public void setGms(String gms) {
        this.gms = gms == null ? null : gms.trim();
    }

    public Date getBldat() {
        return bldat;
    }

    public void setBldat(Date bldat) {
        this.bldat = bldat;
    }

    public String getMainn() {
        return mainn;
    }

    public void setMainn(String mainn) {
        this.mainn = mainn == null ? null : mainn.trim();
    }

    public String getXbs() {
        return xbs;
    }

    public void setXbs(String xbs) {
        this.xbs = xbs == null ? null : xbs.trim();
    }

    public String getJws() {
        return jws;
    }

    public void setJws(String jws) {
        this.jws = jws == null ? null : jws.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getXy1() {
        return xy1;
    }

    public void setXy1(String xy1) {
        this.xy1 = xy1 == null ? null : xy1.trim();
    }

    public String getXy2() {
        return xy2;
    }

    public void setXy2(String xy2) {
        this.xy2 = xy2 == null ? null : xy2.trim();
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw == null ? null : tw.trim();
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl == null ? null : xl.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getZhand() {
        return zhand;
    }

    public void setZhand(String zhand) {
        this.zhand = zhand == null ? null : zhand.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getBjfa() {
        return bjfa;
    }

    public void setBjfa(String bjfa) {
        this.bjfa = bjfa == null ? null : bjfa.trim();
    }

    public String getDoutyp() {
        return doutyp;
    }

    public void setDoutyp(String doutyp) {
        this.doutyp = doutyp == null ? null : doutyp.trim();
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre == null ? null : pre.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public Date getWdat() {
        return wdat;
    }

    public void setWdat(Date wdat) {
        this.wdat = wdat;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getSickguid() {
        return sickguid;
    }

    public void setSickguid(String sickguid) {
        this.sickguid = sickguid == null ? null : sickguid.trim();
    }

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid == null ? null : docguid.trim();
    }

    public String getPreno() {
        return preno;
    }

    public void setPreno(String preno) {
        this.preno = preno == null ? null : preno.trim();
    }

    public String getPrenote() {
        return prenote;
    }

    public void setPrenote(String prenote) {
        this.prenote = prenote == null ? null : prenote.trim();
    }

    public String getZdnam() {
        return zdnam;
    }

    public void setZdnam(String zdnam) {
        this.zdnam = zdnam == null ? null : zdnam.trim();
    }

    public String getMainne() {
        return mainne;
    }

    public void setMainne(String mainne) {
        this.mainne = mainne == null ? null : mainne.trim();
    }

    public String getXbsnam() {
        return xbsnam;
    }

    public void setXbsnam(String xbsnam) {
        this.xbsnam = xbsnam == null ? null : xbsnam.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getChangdoc() {
        return changdoc;
    }

    public void setChangdoc(String changdoc) {
        this.changdoc = changdoc == null ? null : changdoc.trim();
    }

    public String getSendka() {
        return sendka;
    }

    public void setSendka(String sendka) {
        this.sendka = sendka == null ? null : sendka.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getIsfollow() {
        return isfollow;
    }

    public void setIsfollow(String isfollow) {
        this.isfollow = isfollow == null ? null : isfollow.trim();
    }

    public String getPretim() {
        return pretim;
    }

    public void setPretim(String pretim) {
        this.pretim = pretim == null ? null : pretim.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getClucose() {
        return clucose;
    }

    public void setClucose(String clucose) {
        this.clucose = clucose == null ? null : clucose.trim();
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose == null ? null : glucose.trim();
    }

    public String getLinedate() {
        return linedate;
    }

    public void setLinedate(String linedate) {
        this.linedate = linedate == null ? null : linedate.trim();
    }

    public String getLinetime() {
        return linetime;
    }

    public void setLinetime(String linetime) {
        this.linetime = linetime == null ? null : linetime.trim();
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public String getMedicineway() {
        return medicineway;
    }

    public void setMedicineway(String medicineway) {
        this.medicineway = medicineway == null ? null : medicineway.trim();
    }

    public String getLocguid() {
        return locguid;
    }

    public void setLocguid(String locguid) {
        this.locguid = locguid == null ? null : locguid.trim();
    }

    public String getSendflg() {
        return sendflg;
    }

    public void setSendflg(String sendflg) {
        this.sendflg = sendflg == null ? null : sendflg.trim();
    }

    public String getYbtyp() {
        return ybtyp;
    }

    public void setYbtyp(String ybtyp) {
        this.ybtyp = ybtyp == null ? null : ybtyp.trim();
    }

    public String getIsvideopush() {
        return isvideopush;
    }

    public void setIsvideopush(String isvideopush) {
        this.isvideopush = isvideopush == null ? null : isvideopush.trim();
    }

    public String getNoteext() {
        return noteext;
    }

    public void setNoteext(String noteext) {
        this.noteext = noteext == null ? null : noteext.trim();
    }

    public String getMedicalid() {
        return medicalid;
    }

    public void setMedicalid(String medicalid) {
        this.medicalid = medicalid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public DTsickblhdr() {
    }

    public DTsickblhdr(String guid, String cardid, String name, String sex, String dept, String age, String gms, Date bldat, String mainn, String xbs, String jws, String height, String weight, String xy1, String xy2, String tw, String xl, String other, String zhand, String note, String bjfa, String doutyp, String pre, String doc, Date wdat, String acc, String org, String sickguid, String docguid, String preno, String prenote, String zdnam, String mainne, String xbsnam, Date crtdat, String changdoc, String sendka, String telephone, String isfollow, String pretim, String deptid, String clucose, String glucose, String linedate, String linetime, String orderstatus, String medicineway, String locguid, String sendflg, String ybtyp, String isvideopush, String noteext, String medicalid, String birthday) {
        this.guid = guid;
        this.cardid = cardid;
        this.name = name;
        this.sex = sex;
        this.dept = dept;
        this.age = age;
        this.gms = gms;
        this.bldat = bldat;
        this.mainn = mainn;
        this.xbs = xbs;
        this.jws = jws;
        this.height = height;
        this.weight = weight;
        this.xy1 = xy1;
        this.xy2 = xy2;
        this.tw = tw;
        this.xl = xl;
        this.other = other;
        this.zhand = zhand;
        this.note = note;
        this.bjfa = bjfa;
        this.doutyp = doutyp;
        this.pre = pre;
        this.doc = doc;
        this.wdat = wdat;
        this.acc = acc;
        this.org = org;
        this.sickguid = sickguid;
        this.docguid = docguid;
        this.preno = preno;
        this.prenote = prenote;
        this.zdnam = zdnam;
        this.mainne = mainne;
        this.xbsnam = xbsnam;
        this.crtdat = crtdat;
        this.changdoc = changdoc;
        this.sendka = sendka;
        this.telephone = telephone;
        this.isfollow = isfollow;
        this.pretim = pretim;
        this.deptid = deptid;
        this.clucose = clucose;
        this.glucose = glucose;
        this.linedate = linedate;
        this.linetime = linetime;
        this.orderstatus = orderstatus;
        this.medicineway = medicineway;
        this.locguid = locguid;
        this.sendflg = sendflg;
        this.ybtyp = ybtyp;
        this.isvideopush = isvideopush;
        this.noteext = noteext;
        this.medicalid = medicalid;
        this.birthday = birthday;
    }
}