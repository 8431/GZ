package com.gz.medicine.yun.doctor.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 随访计划校验类
 * @author 舵主
 *
 * 下午5:19:17
 */
public class DTfollowupPlanRequest {
	
	 private String guid;

	    private String org;
	    
	    @NotEmpty(message="docguid不能为空！")
	    private String docguid;
	    
	    @NotEmpty(message="usrguid不能为空！")
	    private String usrguid;
	    private String sicguid;
	    private String followoption;
	    private Date   followdatetime;
	    private String followtime;

	    private String followstate;

	    private String crtusr;

	    private Date crtdat;

	    private String updateusr;

	    private Date updatedate;

	    /**
	     * 删除标志
	     */
	    private String status;

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

		public void setUsrguid(String usrguid) {
			this.usrguid = usrguid;
		}

		public String getSicguid() {
			return sicguid;
		}

		public void setSicguid(String sicguid) {
			this.sicguid = sicguid;
		}

		public String getFollowoption() {
			return followoption;
		}

		public void setFollowoption(String followoption) {
			this.followoption = followoption;
		}

		public Date getFollowdatetime() {
			return followdatetime;
		}

		public void setFollowdatetime(Date followdatetime) {
			this.followdatetime = followdatetime;
		}

		public String getFollowtime() {
			return followtime;
		}

		public void setFollowtime(String followtime) {
			this.followtime = followtime;
		}

		public String getFollowstate() {
			return followstate;
		}

		public void setFollowstate(String followstate) {
			this.followstate = followstate;
		}

		public String getCrtusr() {
			return crtusr;
		}

		public void setCrtusr(String crtusr) {
			this.crtusr = crtusr;
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
			this.updateusr = updateusr;
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
	
	    
	    
	
}
