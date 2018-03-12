package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 排班表
 * jin
 **/
public class HealthyDocformRequest implements Serializable {


    private static final long serialVersionUID = 1L;

    //1、docid
//    @NotEmpty(message="docid不能为空！")
    private String docid;
    //2、startdate
//    @NotEmpty(message="formdate不能为空！")
    
    private String formdate;
    
    private String id;
    
    private String formstate;
    
	public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}
	public String getFormdate() {
		return formdate;
	}
	public void setFormdate(String formdate) {
		this.formdate = formdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormstate() {
		return formstate;
	}
	public void setFormstate(String formstate) {
		this.formstate = formstate;
	}

    
    

    
    
    


}
