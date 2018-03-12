package com.gz.medicine.gzyun.yidiagnosis.bean;

import java.util.Date;
/**
 * 
	* @author 维维
	*<p>Title:YGsickblhdr </p>
	* <p>Description:TODO(病人病史)</p>
	* <p>Company:贯众 </p> 
	*<p>数据库:SICKBLHDR</p>
	* @author 
	* @date  2017年8月31日
 */
public class YGsickblhdr {
    private String guid;	// 内部唯一编号

    private String cardid;	//卡号

    private String name;	//姓名

    private String sex;	//性别

    private String dept;	//科别

    private String age;	//年龄

    private String gms;	//过敏史

    private Date bldat;	//病例日期

    private String mainn;	//主诉

    private String xbs;	//现病史

    private String jws;	//既往史

    private String height;	//身高

    private String weight;	//体重

    private String xy1;		//血压上

    private String xy2;		//血压下

    private String tw;		//体温

    private String xl;		//心率

    private String other;	//其他

    private String zhand;	//初步诊断

    private String note;	//诊疗意见

    private String bjfa;	//保健方案

    private String doutyp;	//方案类型

    private String pre;		//平台预约日期

    private String doc;		//医师

    private Date wdat;		//日期

    private String acc;		//账套

    private String org;		//组织

    private String sickguid;	//病人帐号guid

    private String docguid;		//医生guid

    private String preno;		//预约号

    private String prenote;	//预约建议

    private String zdnam;	//诊断名称

    private String mainne;	//主诉名称

    private String xbsnam;	//现病史名称

    private Date crtdat;	//创建日期

    private String changdoc;	//转诊医生

    private String sendka;		//发送渠道

    private String telephone;	//电话

    private String isfollow;	//  随访，0：未随访，1：已随访  

    private String pretim;		//平台预约时间

    private String deptid;		//所在机构 

    private String clucose;		//血糖 

    private String glucose;		//血氧

    private String linedate;		//线下预约日期

    private String linetime;		//线下预约时间 

    private String orderstatus;//订单状态,1：确认，2：未确认，3：正在配送，4：取消，5:已完成 

    private String medicineway;//药购买方式，1：线上配送，2:线下自提，3：无需购药 

    private String locguid;// LOC表的guid

    private String sendflg;//处方是否已发送给第三方药店1是0否

    private String ybtyp;//费别

    private String isvideopush;//是否已视频推送；0：未，1：已

    private String noteext;//进一步检查

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
}