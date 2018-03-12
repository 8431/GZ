package com.gz.medicine.gzyun.user.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class RegUserRequest  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message="id不能为空！") 
	private String id;
	@NotEmpty(message="idcard不能为空！") 
	private String idcard;
	
	private String meaicarecard;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMeaicarecard() {
		return meaicarecard;
	}
	public void setMeaicarecard(String meaicarecard) {
		this.meaicarecard = meaicarecard;
	}
	
	 
}
