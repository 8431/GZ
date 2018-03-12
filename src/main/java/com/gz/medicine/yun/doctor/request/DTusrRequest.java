package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 修改密码
 * jin
 **/
public class DTusrRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、guid
    @NotEmpty(message="guid不能为空！")
    private String guid;
    //2、oldPass
    private String oldPass;
    //2、newPass
    private String newPass;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	

}
