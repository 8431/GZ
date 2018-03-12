package com.gz.medicine.yun.doctor.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 登录查询
 * jin
 **/
public class DTdocRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、id
    @NotEmpty(message="id不能为空！")
    private String id;
    //2、password
 
    private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
   
    
    


}
