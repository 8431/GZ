package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;

/**
 *总胆固醇 
 ***/


public class HmChoReponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "ChoReponse [guid=" + guid + ", usrguid=" + usrguid + ", meatime=" + meatime + ", totchole=" + totchole + ", stat=" + stat + "]";
	}
	private String guid;//guid
	private String usrguid;//usrguid
	private String meatime;//测量时间
	private String totchole;//总胆固醇
	private int stat;//状态
	
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
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
	public String getTotchole() {
		return totchole;
	}
	public void setTotchole(String totchole) {
		this.totchole = totchole;
	}
	
	

	
	
	
	
	
	
	
}
