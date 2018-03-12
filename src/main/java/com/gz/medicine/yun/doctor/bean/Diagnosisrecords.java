/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.bean;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @Title Diagnosisrecords表的实体类
 * @Description 诊断表
 * @version 1.0
 * @Author ulrica
 * @Date 2018年1月9日 14时35分15秒 星期二 
 */
public class Diagnosisrecords implements Serializable{ 


    private static final long serialVersionUID = 1L;
 
    /**
    *  唯一ID
    */  
    private String id;
    /**
    * 
    */  
    private String zid;
    /**
    *  
    */  
    private String zname;
    /**
    *  
    */  
    private String sid;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZid() {
		return zid;
	}
	public void setZid(String zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
    
    
}