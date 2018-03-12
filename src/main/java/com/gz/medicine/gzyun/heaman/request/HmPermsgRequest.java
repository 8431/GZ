package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class HmPermsgRequest implements Serializable{

	/**
	 * 健康指数
	 * jin
	 */
	private static final long serialVersionUID = 1L;
//	@NotEmpty(message="GUID不能为空！")
	private String guid;
	
	@NotEmpty(message="usrguid不能为空！")
	private String usrguid; // usrguid

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUsrguid() {
		return usrguid;
	}

	public void setUsrguid(String usrguid) {
		this.usrguid = usrguid;
	}
	


	
	
	
	
	

	

}
