package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;
import java.util.Date;


/**
 * 心电     返回给前端
 * @author Administrator
 *
 */
public class EcgReponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String MEATIME; // 测量时间

	private String HEARATE; // 平均心率
	private String BRERATE; // 呼吸率
	private String MEADUROF; // 测量持续时间

	private String HEABEAT; // 心搏
	private String ROOMEARLY; // 房早
	private String PREEARLY; // 室早
	
	private String MAXHEARATE; // 最大心率
	private String MINHEARATE; // 最小心率
	private String REFID; // 数创标记id
	
	private Date CRTDAT; // 创建时间
	
	private String hestat; // 心率状态
	private String brestat; // 呼吸率状态
	public String getMEATIME() {
		return MEATIME;
	}
	public void setMEATIME(String mEATIME) {
		MEATIME = mEATIME;
	}
	public String getHEARATE() {
		return HEARATE;
	}
	public void setHEARATE(String hEARATE) {
		HEARATE = hEARATE;
	}
	public String getBRERATE() {
		return BRERATE;
	}
	public void setBRERATE(String bRERATE) {
		BRERATE = bRERATE;
	}
	public String getMEADUROF() {
		return MEADUROF;
	}
	public void setMEADUROF(String mEADUROF) {
		MEADUROF = mEADUROF;
	}
	public String getHEABEAT() {
		return HEABEAT;
	}
	public void setHEABEAT(String hEABEAT) {
		HEABEAT = hEABEAT;
	}
	public String getROOMEARLY() {
		return ROOMEARLY;
	}
	public void setROOMEARLY(String rOOMEARLY) {
		ROOMEARLY = rOOMEARLY;
	}
	public String getPREEARLY() {
		return PREEARLY;
	}
	public void setPREEARLY(String pREEARLY) {
		PREEARLY = pREEARLY;
	}
	public String getMAXHEARATE() {
		return MAXHEARATE;
	}
	public void setMAXHEARATE(String mAXHEARATE) {
		MAXHEARATE = mAXHEARATE;
	}
	public String getMINHEARATE() {
		return MINHEARATE;
	}
	public void setMINHEARATE(String mINHEARATE) {
		MINHEARATE = mINHEARATE;
	}
	public String getREFID() {
		return REFID;
	}
	public void setREFID(String rEFID) {
		REFID = rEFID;
	}
	public Date getCRTDAT() {
		return CRTDAT;
	}
	public void setCRTDAT(Date cRTDAT) {
		CRTDAT = cRTDAT;
	}
	public String getHestat() {
		return hestat;
	}
	public void setHestat(String hestat) {
		this.hestat = hestat;
	}
	public String getBrestat() {
		return brestat;
	}
	public void setBrestat(String brestat) {
		this.brestat = brestat;
	}
	@Override
	public String toString() {
		return "EcgReponse [MEATIME=" + MEATIME + ", HEARATE=" + HEARATE + ", BRERATE=" + BRERATE + ", MEADUROF="
				+ MEADUROF + ", HEABEAT=" + HEABEAT + ", ROOMEARLY=" + ROOMEARLY + ", PREEARLY=" + PREEARLY
				+ ", MAXHEARATE=" + MAXHEARATE + ", MINHEARATE=" + MINHEARATE + ", REFID=" + REFID + ", CRTDAT="
				+ CRTDAT + ", hestat=" + hestat + ", brestat=" + brestat + "]";
	}
	
	
	
	
}
