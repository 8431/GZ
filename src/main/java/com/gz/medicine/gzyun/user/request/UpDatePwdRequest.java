package com.gz.medicine.gzyun.user.request;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class UpDatePwdRequest {
	/**
	 * @author 舵主
	 *
	 * 下午2:14:01
	 */
	@NotEmpty(message="guid不能为空！") 
	private String guid;

	@NotEmpty(message="oldpwd不能为空！") 
    private String oldpwd;

	@NotEmpty(message="newpwd不能为空！") 
    private Date newpwd;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public Date getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(Date newpwd) {
		this.newpwd = newpwd;
	}

	@Override
	public String toString() {
		return "UpDatePwdRequest [guid=" + guid + ", oldpwd=" + oldpwd + ", newpwd=" + newpwd + "]";
	}
   
	
}
