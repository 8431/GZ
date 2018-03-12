package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;
import java.util.List;

import com.gz.medicine.yun.doctor.bean.DTmessageRecord;

/**
 * 短信记录
 * 
 * @author 维维
 *
 */
public class DTmessageRecordResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String age;

	private String sex;

	private String usrname;

	private String mobile;

	List<DTmessageRecord> lists;

	public DTmessageRecordResponse() {
		// TODO Auto-generated constructor stub
	}


	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DTmessageRecord> getLists() {
		return lists;
	}

	public void setLists(List<DTmessageRecord> lists) {
		this.lists = lists;
	}

}
