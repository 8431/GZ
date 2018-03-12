package com.gz.medicine.yun.user.reponse;

import java.io.Serializable;
import java.util.Date;



public class UserReponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "UserReponse [guid=" + guid + ", id=" + id + ", name=" + name + ", Date1=" + date1 + ", age=" + age
				+ ", tel=" + tel + ", adr=" + adr + "]";
	}
	private String guid;
	private String id;
	private String	 name;
	private   	Date date1;
	private  int age;
	private String tel;
	private String adr;
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
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = new  Date();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
}
