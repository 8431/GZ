package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;




public class HmHeatReponse  implements Serializable{
	/**
	 * 体温
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "HeatReponse [guid=" + guid + ", usrguid=" + usrguid + ", meatime=" + meatime + ", heat=" + heat + ", stat=" + stat + "]";
	}
	private String guid;//guid
	private String usrguid;//usrguid
	private String meatime;//测量时间
	private String heat;//体温
	private int stat;//状态
	

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
	public String getHeat() {
		return heat;
	}
	public void setHeat(String heat) {
		this.heat = heat;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	
	
	
	
	
	
	
	
}
