package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class HmBloRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@NotEmpty(message="GUID不能为空！")
	private String guid;
	
//	@NotEmpty(message="usrguid不能为空！")
	private String usrguid; 
	
	
//	@NotEmpty(message="page不能为空！")
	private String page; 
//	@NotEmpty(message="血糖数据不能为空！")
	private String blglu; // 血糖
	
//	@NotEmpty(message="状态不能为空！")
	private String state; // 状态（饭后空腹）STATE=0指饭后，=1指空腹,=2随机

	public String getGuid() {
		return guid;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
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

	public String getBlglu() {
		return blglu;
	}

	public void setBlglu(String blglu) {
		this.blglu = blglu;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	

	
	
	
	

	

}
