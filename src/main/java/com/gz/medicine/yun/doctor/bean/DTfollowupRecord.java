                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              package com.gz.medicine.yun.doctor.bean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 随访记录  视频
 * @author 维维
 *
 */
public class DTfollowupRecord {
	private String guid;// '内部唯一编号'

	private String org;// '系统编号'

	private String docguid;// '医生guid'

	private String usrguid;// '患者guid'

	private String sicguid;// '病例guid'
	
	private String department; //診室

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

	private Date crtdat;// '创建时间'

	private String updateusr;// '更新人'

	private Date updatedate;// '更新时间'

	private String status;  //删除标志
	
	private String name;

	/**
	 * 健康方案
	 */
	private String healthprogramme;

	/**
	 * 注意事项
	 */
	private String needattention;

	private String xsfztime;  //线上复诊时间

	private String mzfztime; //门诊复诊时间

	private String followupplanid; //随访计划id

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

	public String getDocguid() {
		return docguid;
	}

	public void setDocguid(String docguid) {
		this.docguid = docguid == null ? null : docguid.trim();
	}

	public String getUsrguid() {
		return usrguid;
	}

	public void setUsrguid(String usrguid) {
		this.usrguid = usrguid == null ? null : usrguid.trim();
	}

	public String getSicguid() {
		return sicguid;
	}

	public void setSicguid(String sicguid) {
		this.sicguid = sicguid == null ? null : sicguid.trim();
	}

	public String getFollowoption() {
		return followoption;
	}

	public void setFollowoption(String followoption) {
		this.followoption = followoption == null ? null : followoption.trim();
	}


	public BigDecimal getTemperature() {
		return temperature;
	}

	public String getFollowdatetime() {
		return followdatetime;
	}

	public void setFollowdatetime(String followdatetime) {
		this.followdatetime = followdatetime;
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
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setFollowconclusion(String followconclusion) {
		this.followconclusion = followconclusion == null ? null : followconclusion.trim();
	}

	public String getCrtusr() {
		return crtusr;
	}

	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr == null ? null : crtusr.trim();
	}

	public Date getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}

	public String getUpdateusr() {
		return updateusr;
	}

	public void setUpdateusr(String updateusr) {
		this.updateusr = updateusr == null ? null : updateusr.trim();
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
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

	public String getXsfztime() {
		return xsfztime;
	}

	public void setXsfztime(String xsfztime) {
		this.xsfztime = xsfztime;
	}

	public String getMzfztime() {
		return mzfztime;
	}

	public void setMzfztime(String mzfztime) {
		this.mzfztime = mzfztime;
	}

	public String getFollowupplanid() {
		return followupplanid;
	}

	public void setFollowupplanid(String followupplanid) {
		this.followupplanid = followupplanid;
	}
}