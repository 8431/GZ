package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 登录查询
 * jin
 **/
public class HealthyLoginRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、name
    @NotEmpty(message="name不能为空！")
    private String name;
    //2、password
    @NotEmpty(message="password不能为空！")
    private String password;
    
    private String id;
    
    

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
    
    


}
