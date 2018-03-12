package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;




public class HealthLoginResponse  implements Serializable{
	/**
	 * 登录
	 * jin
	 */
	private static final long serialVersionUID = 1L;

    private String id;
    private String name;
  
    private String titlename;
    private String begood;	    
    private String photoid;	    
    private String qualificationsid;
    private String perintroduction;
    private String trainingexperience;
    private String docphone;
    
    private String docid;//医生唯一标识
	 
	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDocphone() {
			return docphone;
	}

	public void setDocphone(String docphone) {
		this.docphone = docphone;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitlename() {
		return titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public String getBegood() {
		return begood;
	}

	public void setBegood(String begood) {
		this.begood = begood;
	}

	public String getPhotoid() {
		return photoid;
	}

	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}

	public String getQualificationsid() {
		return qualificationsid;
	}

	public void setQualificationsid(String qualificationsid) {
		this.qualificationsid = qualificationsid;
	}

	public String getPerintroduction() {
		return perintroduction;
	}

	public void setPerintroduction(String perintroduction) {
		this.perintroduction = perintroduction;
	}

	public String getTrainingexperience() {
		return trainingexperience;
	}

	public void setTrainingexperience(String trainingexperience) {
		this.trainingexperience = trainingexperience;
	}
}
