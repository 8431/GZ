package com.gz.medicine.gzyun.heaman.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class HmSqueRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message="USRGUID不能为空！")
	private String usrguid;
	
	private String guid;
	
//	@NotEmpty(message="性别不能为空！")
	private String sex; // 性别
	
//	@NotEmpty(message="身高不能为空！")
	private String height; // 身高
	
//	@NotEmpty(message="体重不能为空！")
	private String weight; // 体重
	
//	@NotEmpty(message="选项不能为空！")
	private String isdiabete; // 是否糖尿病
	
//	@NotEmpty(message="选项不能为空！")
	private String ishypert; // 是否高血压
	
//	@NotEmpty(message="选项不能为空！")
	private String ishyperl; // 是否高血脂
	
//	@NotEmpty(message="选项不能为空！")
	private String quesone; // 问题一
	
//	@NotEmpty(message="选项不能为空！")
	private String questwo; // 问题二
	
	
//	@NotEmpty(message="选项不能为空！")
	private String questhree; // 问题三
	
//	@NotEmpty(message="选项不能为空！")
	private String quesfour; // 问题四
	
//	@NotEmpty(message="选项不能为空！")
	private String quesfive; // 问题五
	
//	@NotEmpty(message="选项不能为空！")
	private String quessix; // 问题六

	
	
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
