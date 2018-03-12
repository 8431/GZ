package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class HmHeatRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@NotEmpty(message="GUID不能为空！")
	private String guid;
	
	@NotEmpty(message="usrguid不能为空！")
	private String usrguid; // usrguid
	
//	@NotEmpty(message="测量时间不能为空！")
	private String meatime; // 测量时间
	
//	@NotEmpty(message="体温不能为空！")
	private String heat; // 体温

	
	
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

	public String getMeatime() {
		return meatime;
	}

	public void setMeatime(String meatime) {
		this.meatime = meatime;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}


	
	
	
	

	

}
