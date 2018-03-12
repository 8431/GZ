package com.gz.medicine.gzyun.yidiagnosis.reponse;

import java.io.Serializable;

public class DocLineReponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private String guid;
	
	private String id;

	private String hospital;

	private String partner;

	private String is_online;

	private long time;

	private String stat;

	private String isol;

	public DocLineReponse() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getGuid() {
		return guid;
	}



	public void setGuid(String guid) {
		this.guid = guid;
	}



	public String getStat() {
		return stat;
	}


	public void setStat(String stat) {
		this.stat = stat;
	}


	public String getIsol() {
		return isol;
	}


	public void setIsol(String isol) {
		this.isol = isol;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getIs_online() {
		return is_online;
	}

	public void setIs_online(String is_online) {
		this.is_online = is_online;
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

}
