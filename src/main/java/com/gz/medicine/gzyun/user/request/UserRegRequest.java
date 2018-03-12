package com.gz.medicine.gzyun.user.request;

/**
 * 
 * @author fendo
 * @describe 用户注册
 * @version 0.0.1 version
 *
 */

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "phone不能为空！")
	private String phone;

	@NotEmpty(message = "password不能为空！")
	private String password;

	private String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegRequest [phone=" + phone + ", password=" + password + "]";
	}

}
