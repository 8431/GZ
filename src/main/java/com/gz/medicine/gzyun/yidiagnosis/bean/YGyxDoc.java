package com.gz.medicine.gzyun.yidiagnosis.bean;

/**
 * 
	* @author 维维
	*<p>Title:YGyxDoc </p>
	* <p>Description:TODO(医生)</p>
	* <p>Company:贯众 </p> 
	*<p>数据库:yx_doc</p>
	* @author 
	* @date  2017年8月31日
 */
public class YGyxDoc {
    private String guid;	

    private String id;	//编号

    private String name;//姓名

    private String hospital;//医院

    private String jobtitle;//职称

    private String education;//学历

    private String skill;//技能

    private String note;//个人说明

    private String img;//头像

    private String sex;// 性别

    private String idcphoto;//身份证正反照照片

    private String praphoto;//执业医师照照片

    private String jobphoto;//职称证书照片

    private String refid;//团队编号

    private String readprice;//读片价格

    private String idzphoto;//身份证正面照片

    private String idftphoto;//身份证反面照片

    private String refnme;//团队名称

    private String doclicense;//执照

    private Short flg;//状态  0

    private String teamstat;//团队状态

    private String distribution;//财务分配

    private String flag;//标记属于第一层还是第二层

    private String address;//地址

    private String emaill;//邮箱 

    private String telephone;//电话

    private String password;//密码

    private String licenseid;//医师执照编号

    private String department;//所在科室

    private String position;//所在职位

    private String begoodat;//擅长

    private String eduname;//学历名称

    private String viscera;//擅长

    private String equtype;//设备类型

    private String acctype;//账户类型

    private String accname;//账户

    private String zfbacc;//支付宝账户

    private String flag1;//标记是否已被同意加入团队

    private String zfbnam;//支付宝姓名

    private String accid;//银行卡姓名

    private String accountid;//银行卡姓名

    private String zfbflag;//支付宝（默认）

    private String accflag;//银行（默认）

    private String syt;

    private String acc;

    private String org;

    private String zxflg;

    private String deptnam;

    private String begoodatnam;

    private String usrstat;

    private String crtdat;

    private String sp;

    private String bgp;

    private String openroom;

    private Long sortid;

    private String type;

    private String type2;

    private String iskf;

    private String isty;//医生类型

    private String department2;//子科室

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle == null ? null : jobtitle.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcphoto() {
        return idcphoto;
    }

    public void setIdcphoto(String idcphoto) {
        this.idcphoto = idcphoto == null ? null : idcphoto.trim();
    }

    public String getPraphoto() {
        return praphoto;
    }

    public void setPraphoto(String praphoto) {
        this.praphoto = praphoto == null ? null : praphoto.trim();
    }

    public String getJobphoto() {
        return jobphoto;
    }

    public void setJobphoto(String jobphoto) {
        this.jobphoto = jobphoto == null ? null : jobphoto.trim();
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getReadprice() {
        return readprice;
    }

    public void setReadprice(String readprice) {
        this.readprice = readprice == null ? null : readprice.trim();
    }

    public String getIdzphoto() {
        return idzphoto;
    }

    public void setIdzphoto(String idzphoto) {
        this.idzphoto = idzphoto == null ? null : idzphoto.trim();
    }

    public String getIdftphoto() {
        return idftphoto;
    }

    public void setIdftphoto(String idftphoto) {
        this.idftphoto = idftphoto == null ? null : idftphoto.trim();
    }

    public String getRefnme() {
        return refnme;
    }

    public void setRefnme(String refnme) {
        this.refnme = refnme == null ? null : refnme.trim();
    }

    public String getDoclicense() {
        return doclicense;
    }

    public void setDoclicense(String doclicense) {
        this.doclicense = doclicense == null ? null : doclicense.trim();
    }

    public Short getFlg() {
        return flg;
    }

    public void setFlg(Short flg) {
        this.flg = flg;
    }

    public String getTeamstat() {
        return teamstat;
    }

    public void setTeamstat(String teamstat) {
        this.teamstat = teamstat == null ? null : teamstat.trim();
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution == null ? null : distribution.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill == null ? null : emaill.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid == null ? null : licenseid.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getBegoodat() {
        return begoodat;
    }

    public void setBegoodat(String begoodat) {
        this.begoodat = begoodat == null ? null : begoodat.trim();
    }

    public String getEduname() {
        return eduname;
    }

    public void setEduname(String eduname) {
        this.eduname = eduname == null ? null : eduname.trim();
    }

    public String getViscera() {
        return viscera;
    }

    public void setViscera(String viscera) {
        this.viscera = viscera == null ? null : viscera.trim();
    }

    public String getEqutype() {
        return equtype;
    }

    public void setEqutype(String equtype) {
        this.equtype = equtype == null ? null : equtype.trim();
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype == null ? null : acctype.trim();
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname == null ? null : accname.trim();
    }

    public String getZfbacc() {
        return zfbacc;
    }

    public void setZfbacc(String zfbacc) {
        this.zfbacc = zfbacc == null ? null : zfbacc.trim();
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }

    public String getZfbnam() {
        return zfbnam;
    }

    public void setZfbnam(String zfbnam) {
        this.zfbnam = zfbnam == null ? null : zfbnam.trim();
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid == null ? null : accid.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public String getZfbflag() {
        return zfbflag;
    }

    public void setZfbflag(String zfbflag) {
        this.zfbflag = zfbflag == null ? null : zfbflag.trim();
    }

    public String getAccflag() {
        return accflag;
    }

    public void setAccflag(String accflag) {
        this.accflag = accflag == null ? null : accflag.trim();
    }

    public String getSyt() {
        return syt;
    }

    public void setSyt(String syt) {
        this.syt = syt == null ? null : syt.trim();
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

    public String getZxflg() {
        return zxflg;
    }

    public void setZxflg(String zxflg) {
        this.zxflg = zxflg == null ? null : zxflg.trim();
    }

    public String getDeptnam() {
        return deptnam;
    }

    public void setDeptnam(String deptnam) {
        this.deptnam = deptnam == null ? null : deptnam.trim();
    }

    public String getBegoodatnam() {
        return begoodatnam;
    }

    public void setBegoodatnam(String begoodatnam) {
        this.begoodatnam = begoodatnam == null ? null : begoodatnam.trim();
    }

    public String getUsrstat() {
        return usrstat;
    }

    public void setUsrstat(String usrstat) {
        this.usrstat = usrstat == null ? null : usrstat.trim();
    }

    public String getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(String crtdat) {
        this.crtdat = crtdat == null ? null : crtdat.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getBgp() {
        return bgp;
    }

    public void setBgp(String bgp) {
        this.bgp = bgp == null ? null : bgp.trim();
    }

    public String getOpenroom() {
        return openroom;
    }

    public void setOpenroom(String openroom) {
        this.openroom = openroom == null ? null : openroom.trim();
    }

    public Long getSortid() {
        return sortid;
    }

    public void setSortid(Long sortid) {
        this.sortid = sortid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2 == null ? null : type2.trim();
    }

    public String getIskf() {
        return iskf;
    }

    public void setIskf(String iskf) {
        this.iskf = iskf == null ? null : iskf.trim();
    }

    public String getIsty() {
        return isty;
    }

    public void setIsty(String isty) {
        this.isty = isty == null ? null : isty.trim();
    }

    public String getDepartment2() {
        return department2;
    }

    public void setDepartment2(String department2) {
        this.department2 = department2 == null ? null : department2.trim();
    }
}