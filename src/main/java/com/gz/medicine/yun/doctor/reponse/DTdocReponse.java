package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;




public class DTdocReponse  implements Serializable{
	/**
	 * 登录
	 * jin
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "docReponse [guid=" + guid+ ", id=" + id+ ", name=" + name+ ", img=" + img+ ", Jobtitle=" + Jobtitle+ "]";
	}
	private String guid;//guid
	private String id;//医生id
	private String name;//名字
	private String img;//头像
	private String Jobtitle;//职称
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getJobtitle() {
		return Jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		Jobtitle = jobtitle;
	}

	

	
	
	
	
	
	
}
