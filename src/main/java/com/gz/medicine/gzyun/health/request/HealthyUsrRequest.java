package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 修改密码
 * jin
 **/
public class HealthyUsrRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、id
    @NotEmpty(message="id不能为空！")
    private String id;
    //2、oldPass
    private String oldPass;
    //2、newPass
    private String newPass;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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