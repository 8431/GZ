package com.gz.medicine.gzyun.health.reponse;

import java.util.List;

public class HealthDocterForm {
	/**
	 * @author 舵主
	 *
	 * 下午2:36:07
	 */
	private String date;
	private List<HealthForm> doclist;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<HealthForm> getDoclist() {
		return doclist;
	}
	public void setDoclist(List<HealthForm> doclist) {
		this.doclist = doclist;
	}
	
}
