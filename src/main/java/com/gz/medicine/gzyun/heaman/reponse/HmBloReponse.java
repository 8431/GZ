package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;




public class HmBloReponse  implements Serializable{
	/**
	 * 血糖
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "BloReponse [guid=" + guid+ ", usrguid=" + usrguid+ ", blglu=" + blglu+ ", state=" + state+ ", stat=" + stat+ "]";
	}
	private String guid;//guid
	private String usrguid;//usrguid
	private String meatime;//测量时间
	private String blglu;//血糖
	private String state;//状态（饭后空腹）STATE=0指饭后，=1指空腹,=2随机
	private int stat;//状态(stat=1指不正常，=0正常)
	
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
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}

	
	
	
	
	
	
}
