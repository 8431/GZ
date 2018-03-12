package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 * 血压校验参数
 * 舵主
 * @author Administrator
 *
 */
public class HmBlpRecordRequest implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 private String guid;
	 @NotEmpty(message="患者USRGUID不能为空！")
    private String usrguid;

    private String meatime;

    private String diablopre;

    private String sysblopre;

    private Date crtdat;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUsrguid() {
		return usrguid;
	}

	public void setUsrguid(String usrguid) {
		this.usrguid = usrguid;
	}

	public String getMeatime() {
		return meatime;
	}

	public void setMeatime(String meatime) {
		this.meatime = meatime;
	}

	public String getDiablopre() {
		return diablopre;
	}

	public void setDiablopre(String diablopre) {
		this.diablopre = diablopre;
	}

	public String getSysblopre() {
		return sysblopre;
	}

	public void setSysblopre(String sysblopre) {
		this.sysblopre = sysblopre;
	}

	public Date getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}

	
	
	
	
	
	

}
