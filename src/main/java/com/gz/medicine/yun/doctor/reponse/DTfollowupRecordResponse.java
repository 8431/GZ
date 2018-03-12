package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 视频
 * 
 * @author 维维
 *
 */
public class DTfollowupRecordResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String guid;// '内部唯一编号'

	private String org;// '系统编号'

	private String docguid;// '医生guid'

	private String usrguid;// '患者guid'

	private String sicguid;// '病例guid'

	private String hospital; // 诊室

	private String followoption; // '随访项目

	private String followdatetime;// '随访时间'

	private BigDecimal temperature;// '体温'

	private BigDecimal weight;// '体重'

	private Short heartrate;// '心率'

	private BigDecimal bloodsugar;// '血糖';

	private Short bloodpressureh;// '血压(高)'

	private Short bloodpressurel;// '血压(低)'

	private BigDecimal bloodoxygen;// '血氧'

	private String followconclusion;// '随访结论'

	private String crtusr;// '创建人'

	private String crtdat;// '创建时间'

	private String updateusr;// '更新人'

	private String updatedate;// '更新时间'

	private String status; // 删除标志

	private String usrname;

	private String age;

	private String sex;// 性别

	private String docname; // 医生名字

	private String department; // 科室
	
	private String zhand; //診斷

	/**
	 * 健康方案
	 */
	private String healthprogramme;

	/**
	 * 注意事项
	 */
	private String needattention;

	/**
	 * 门诊复诊时间
	 */
	private String mzfztime;

	/**
	 * 线上复诊时间
	 */
	private String xsfztime;

	/**
	 * 随访计划guid
	 */
	private String followupplanid;



	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDocguid() {
		return docguid;
	}

	public void setDocguid(String docguid) {
		this.docguid = docguid;
	}

	public String getUsrguid() {
		return usrguid;
	}
	
	

	public String getZhand() {
		return zhand;
	}

	public void setZhand(String zhand) {
		this.zhand = zhand;
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

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getFollowoption() {
		return followoption;
	}

	public void setFollowoption(String followoption) {
		this.followoption = followoption;
	}

	

	public String getFollowdatetime() {
		return followdatetime;
	}

	public void setFollowdatetime(String followdatetime) {
		this.followdatetime = followdatetime;
	}

	
	public String getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(String crtdat) {
		this.crtdat = crtdat;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Short getHeartrate() {
		return heartrate;
	}

	public void setHeartrate(Short heartrate) {
		this.heartrate = heartrate;
	}

	public BigDecimal getBloodsugar() {
		return bloodsugar;
	}

	public void setBloodsugar(BigDecimal bloodsugar) {
		this.bloodsugar = bloodsugar;
	}

	public Short getBloodpressureh() {
		return bloodpressureh;
	}

	public void setBloodpressureh(Short bloodpressureh) {
		this.bloodpressureh = bloodpressureh;
	}

	public Short getBloodpressurel() {
		return bloodpressurel;
	}

	public void setBloodpressurel(Short bloodpressurel) {
		this.bloodpressurel = bloodpressurel;
	}

	public BigDecimal getBloodoxygen() {
		return bloodoxygen;
	}

	public void setBloodoxygen(BigDecimal bloodoxygen) {
		this.bloodoxygen = bloodoxygen;
	}

	public String getFollowconclusion() {
		return followconclusion;
	}

	public void setFollowconclusion(String followconclusion) {
		this.followconclusion = followconclusion;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCrtusr() {
		return crtusr;
	}

	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}

	public String getUpdateusr() {
		return updateusr;
	}

	public void setUpdateusr(String updateusr) {
		this.updateusr = updateusr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getMzfztime() {
		return mzfztime;
	}

	public void setMzfztime(String mzfztime) {
		this.mzfztime = mzfztime;
	}

	public String getXsfztime() {
		return xsfztime;
	}

	public void setXsfztime(String xsfztime) {
		this.xsfztime = xsfztime;
	}

	public String getFollowupplanid() {
		return followupplanid;
	}

	public void setFollowupplanid(String followupplanid) {
		this.followupplanid = followupplanid;
	}
}
