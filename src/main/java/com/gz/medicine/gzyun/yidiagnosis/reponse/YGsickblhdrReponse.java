package com.gz.medicine.gzyun.yidiagnosis.reponse;

import java.io.Serializable;
import java.util.List;

import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickbldtl;

public class YGsickblhdrReponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String blguid;

	private String dx_date;

	private String disease;

	private String med_allergy; 

	private String medication_name; // 药物名称

	private String dosage; // 剂量

	private String frequency; // 频率

	private String route;
	
	private String formguid;

	private String sickguid;
	
	private long time;
	
	List<YGsickblhdrReponse> gpRecodes;
	
	List<YGsickbldtl> lists;
	
	
	public YGsickblhdrReponse() {
		// TODO Auto-generated constructor stub
	}

	public String getMedication_name() {
		return medication_name;
	}

	public void setMedication_name(String medication_name) {
		this.medication_name = medication_name;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getBlguid() {
		return blguid;
	}

	public void setBlguid(String blguid) {
		this.blguid = blguid;
	}

	public String getDx_date() {
		return dx_date;
	}

	public void setDx_date(String dx_date) {
		this.dx_date = dx_date;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getMed_allergy() {
		return med_allergy;
	}

	public void setMed_allergy(String med_allergy) {
		this.med_allergy = med_allergy;
	}

	
	public String getFormguid() {
		return formguid;
	}

	public void setFormguid(String formguid) {
		this.formguid = formguid;
	}

	
	public String getSickguid() {
		return sickguid;
	}

	public void setSickguid(String sickguid) {
		this.sickguid = sickguid;
	}

	
	

	

	public List<YGsickbldtl> getLists() {
		return lists;
	}

	public void setLists(List<YGsickbldtl> lists) {
		this.lists = lists;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<YGsickblhdrReponse> getGpRecodes() {
		return gpRecodes;
	}

	public void setGpRecodes(List<YGsickblhdrReponse> gpRecodes) {
		this.gpRecodes = gpRecodes;
	}
	
	

}
