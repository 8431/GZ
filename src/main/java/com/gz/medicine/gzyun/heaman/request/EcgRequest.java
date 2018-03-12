package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 心电  校验所接收的参数
 * @author Administrator
 *
 */
public class EcgRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="患者GUID不能为空！")
	private String USRGUID; // 患者guid
	
	private String MEATIME; // 测量时间

	private String HEARATE; // 平均心率
	private String BRERATE; // 呼吸率
	private String MEADUROF; // 测量持续时间

	private String HEABEAT; // 心搏
	private String ROOMEARLY; // 房早
	private String PREEARLY; // 室早
	
	private String MAXHEARATE; // 最大心率
	private String MINHEARATE; // 最小心率
	
	@NotEmpty(message="REFID标记不能为空！")
	private String REFID; // 数创标记id
	


	public String getUSRGUID() {
		return USRGUID;
	}

	public void setUSRGUID(String uSRGUID) {
		USRGUID = uSRGUID;
	}

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

	
	
	
	

}
