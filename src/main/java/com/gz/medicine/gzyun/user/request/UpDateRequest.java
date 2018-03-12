package com.gz.medicine.gzyun.user.request;

import org.hibernate.validator.constraints.NotEmpty;

public class UpDateRequest {
	/**
	 * @author 舵主
	 *
	 * 下午2:19:21
	 */
	@NotEmpty(message="mobile不能为空！") 
	private String mobile;
	@NotEmpty(message="pwd不能为空！") 
	private String pwd;
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UpDateRequest [mobile=" + mobile + ", pwd=" + pwd + "]";
	}
	
	
	
	
	
}
