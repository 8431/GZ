package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;
import java.util.Date;



public class HmSqueReponse  implements Serializable{
	/**
	 * 问卷
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "SqueReponse [sex=" + sex + ", height=" + height + ", weight=" + weight + ", isdiabete=" + isdiabete + ", ishypert=" + ishypert
				+ ", ishyperl=" + ishyperl + ", quesone=" + quesone + ", questwo=" + questwo + ", questhree=" + questhree + ", quesfour=" + quesfour + ""
				+ ", quesfive=" + quesfive + ", quessix=" + quessix + "]";
	}
	private String usrguid;
	private String sex;
	private String height;
	private String weight;
	private String isdiabete;
	private String ishypert;
	private String ishyperl;
	private String quesone;
	private String questwo;
	private String questhree;
	private String quesfour;
	private String quesfive;
	private String quessix;
	
	
	
	public String getUsrguid() {
		return usrguid;
	}
	public void setUsrguid(String usrguid) {
		this.usrguid = usrguid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getIsdiabete() {
		return isdiabete;
	}
	public void setIsdiabete(String isdiabete) {
		this.isdiabete = isdiabete;
	}
	public String getIshypert() {
		return ishypert;
	}
	public void setIshypert(String ishypert) {
		this.ishypert = ishypert;
	}
	public String getIshyperl() {
		return ishyperl;
	}
	public void setIshyperl(String ishyperl) {
		this.ishyperl = ishyperl;
	}
	public String getQuesone() {
		return quesone;
	}
	public void setQuesone(String quesone) {
		this.quesone = quesone;
	}
	public String getQuestwo() {
		return questwo;
	}
	public void setQuestwo(String questwo) {
		this.questwo = questwo;
	}
	public String getQuesthree() {
		return questhree;
	}
	public void setQuesthree(String questhree) {
		this.questhree = questhree;
	}
	public String getQuesfour() {
		return quesfour;
	}
	public void setQuesfour(String quesfour) {
		this.quesfour = quesfour;
	}
	public String getQuesfive() {
		return quesfive;
	}
	public void setQuesfive(String quesfive) {
		this.quesfive = quesfive;
	}
	public String getQuessix() {
		return quessix;
	}
	public void setQuessix(String quessix) {
		this.quessix = quessix;
	}

	
	
	
	
	
}
