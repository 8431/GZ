package com.gz.medicine.gzyun.health.reponse;

import java.util.List;

/**
 * @author 舵主
 *
 * 下午5:40:10
 */
public class HealthyDoctorformreponse {
	/**
	 * 排班日期
	 */
	private  String  healthytypesettingtime;
	/**
	 * 医生姓名
	 */
	private  String  docname;
	
	/**
	 * 排班时段
	 */
	private  String  intervaldate;
	
	private List<HealthDocterForm> list;

	public List<HealthDocterForm> getList() {
		return list;
	}

	public void setList(List<HealthDocterForm> list) {
		this.list = list;
	}

	public String getHealthytypesettingtime() {
		return healthytypesettingtime;
	}

	public void setHealthytypesettingtime(String healthytypesettingtime) {
		this.healthytypesettingtime = healthytypesettingtime;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getIntervaldate() {
		return intervaldate;
	}

	public void setIntervaldate(String intervaldate) {
		this.intervaldate = intervaldate;
	}

	@Override
	public String toString() {
		return "HealthyDoctorformreponse [healthytypesettingtime=" + healthytypesettingtime + ", docname=" + docname + ", intervaldate=" + intervaldate
				+ "]";
	}
	
	
	
	
}
