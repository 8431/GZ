package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;
import java.util.Date;


/**
 * 尿酸接口     返回给前端
 * @author Administrator
 *
 */
public class HmTxpRecordReponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private String guid;

    private String usrguid;

    private String meatime;

    private String toturiac;

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

	public String getToturiac() {
		return toturiac;
	}

	public void setToturiac(String toturiac) {
		this.toturiac = toturiac;
	}

	public Date getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}

	@Override
	public String toString() {
		return "HmTxpRecordReponse [guid=" + guid + ", usrguid=" + usrguid + ", meatime=" + meatime + ", toturiac="
				+ toturiac + ", crtdat=" + crtdat + "]";
	}
	
	
    
	
	
	
	
}
