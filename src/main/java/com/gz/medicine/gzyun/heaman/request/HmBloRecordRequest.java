package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 心电  校验所接收的参数
 * @author Administrator
 *
 */
public class HmBloRecordRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="患者GUID不能为空！")
	private String guid;

    private String usrguid;

    private String meatime;

    private String blglu;

    private String state;

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

	public String getBlglu() {
		return blglu;
	}

	public void setBlglu(String blglu) {
		this.blglu = blglu;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}
	


	
	
	
	
	

}
