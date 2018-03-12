package com.gz.medicine.yun.user.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class SelUserRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message="用户GUID不能为空！")
	private String guid;
	
	@NotEmpty(message="org不能为空！")
    private String org;
	
    @NotEmpty(message="id不能为空！")
    private String id;
    
    @NotEmpty(message="mbid不能为空！")
    private String mbid;

    private String loc;

    private String name;

    private String passwd;

    private String strdat;

    private String mainurl;

    private String post;

    private String crtusr;

    private String crtdat;

    private String useflg;

    private String defloc;

    private String mobile;

    private String ownloc;

    private String deptid;

    private String postnote;

    private String centreid;

    private String teamid;

    private String email;

    private String dat1;

    private String dat2;

    private String describe;

    private String deforg;

    private String updflg;

    private String imgguid;

    private Long seq;

    private String kh;

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    private String upddat;

    private String ifmoren;

    private String refid;

    private String idcard;

    private String sex;

    private String birthday;

    private String mz;

    private String barcod;

    private String isol;

    private String openroom;

    private String currenttime;

    private String voice;

    private String isdoc;

    private String regtype;

    private String medicarecard;

    private String cardno;

    private String sonno;



    private String countrytyp;

    private String groupx;

    private String homeid;

    private String sytext;

    private String vipflg;

    private String address;

    private String thirdpartyid;
    //从数据库useCenter查询的uuid
    private String uuidKey;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getStrdat() {
        return strdat;
    }

    public void setStrdat(String strdat) {
        this.strdat = strdat;
    }

    public String getMainurl() {
        return mainurl;
    }

    public void setMainurl(String mainurl) {
        this.mainurl = mainurl == null ? null : mainurl.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public String getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(String crtdat) {
        this.crtdat = crtdat;
    }

    public String getUseflg() {
        return useflg;
    }

    public void setUseflg(String useflg) {
        this.useflg = useflg == null ? null : useflg.trim();
    }

    public String getDefloc() {
        return defloc;
    }

    public void setDefloc(String defloc) {
        this.defloc = defloc == null ? null : defloc.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOwnloc() {
        return ownloc;
    }

    public void setOwnloc(String ownloc) {
        this.ownloc = ownloc == null ? null : ownloc.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getPostnote() {
        return postnote;
    }

    public void setPostnote(String postnote) {
        this.postnote = postnote == null ? null : postnote.trim();
    }

    public String getCentreid() {
        return centreid;
    }

    public void setCentreid(String centreid) {
        this.centreid = centreid == null ? null : centreid.trim();
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDat1() {
        return dat1;
    }

    public void setDat1(String dat1) {
        this.dat1 = dat1;
    }

    public String getDat2() {
        return dat2;
    }

    public void setDat2(String dat2) {
        this.dat2 = dat2;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getDeforg() {
        return deforg;
    }

    public void setDeforg(String deforg) {
        this.deforg = deforg == null ? null : deforg.trim();
    }

    public String getUpdflg() {
        return updflg;
    }

    public void setUpdflg(String updflg) {
        this.updflg = updflg == null ? null : updflg.trim();
    }

    public String getImgguid() {
        return imgguid;
    }

    public void setImgguid(String imgguid) {
        this.imgguid = imgguid == null ? null : imgguid.trim();
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh == null ? null : kh.trim();
    }

    public String getUpddat() {
        return upddat;
    }

    public void setUpddat(String upddat) {
        this.upddat = upddat;
    }

    public String getIfmoren() {
        return ifmoren;
    }

    public void setIfmoren(String ifmoren) {
        this.ifmoren = ifmoren == null ? null : ifmoren.trim();
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid == null ? null : refid.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz == null ? null : mz.trim();
    }

    public String getBarcod() {
        return barcod;
    }

    public void setBarcod(String barcod) {
        this.barcod = barcod == null ? null : barcod.trim();
    }

    public String getIsol() {
        return isol;
    }

    public void setIsol(String isol) {
        this.isol = isol == null ? null : isol.trim();
    }

    public String getOpenroom() {
        return openroom;
    }

    public void setOpenroom(String openroom) {
        this.openroom = openroom == null ? null : openroom.trim();
    }

    public String getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(String currenttime) {
        this.currenttime = currenttime;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice == null ? null : voice.trim();
    }

    public String getIsdoc() {
        return isdoc;
    }

    public void setIsdoc(String isdoc) {
        this.isdoc = isdoc == null ? null : isdoc.trim();
    }

    public String getRegtype() {
        return regtype;
    }

    public void setRegtype(String regtype) {
        this.regtype = regtype == null ? null : regtype.trim();
    }

    public String getMedicarecard() {
        return medicarecard;
    }

    public void setMedicarecard(String medicarecard) {
        this.medicarecard = medicarecard == null ? null : medicarecard.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getSonno() {
        return sonno;
    }

    public void setSonno(String sonno) {
        this.sonno = sonno == null ? null : sonno.trim();
    }



    public String getCountrytyp() {
        return countrytyp;
    }

    public void setCountrytyp(String countrytyp) {
        this.countrytyp = countrytyp == null ? null : countrytyp.trim();
    }

    public String getGroupx() {
        return groupx;
    }

    public void setGroupx(String groupx) {
        this.groupx = groupx == null ? null : groupx.trim();
    }

    public String getHomeid() {
        return homeid;
    }

    public void setHomeid(String homeid) {
        this.homeid = homeid == null ? null : homeid.trim();
    }

    public String getSytext() {
        return sytext;
    }

    public void setSytext(String sytext) {
        this.sytext = sytext == null ? null : sytext.trim();
    }

    public String getVipflg() {
        return vipflg;
    }

    public void setVipflg(String vipflg) {
        this.vipflg = vipflg == null ? null : vipflg.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getThirdpartyid() {
        return thirdpartyid;
    }

    public void setThirdpartyid(String thirdpartyid) {
        this.thirdpartyid = thirdpartyid == null ? null : thirdpartyid.trim();
    }

    public String getUuidKey() {
        return uuidKey;
    }

    public void setUuidKey(String uuidKey) {
        this.uuidKey = uuidKey;
    }
	
	

}
