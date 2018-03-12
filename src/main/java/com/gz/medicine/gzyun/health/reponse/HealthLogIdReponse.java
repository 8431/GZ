package com.gz.medicine.gzyun.health.reponse;
/**
 * 订单查询
 * @author 舵主
 *
 * 下午6:31:49
 */

import java.util.Date;
public class HealthLogIdReponse {
	
	private String operatingtime; 
	
	
	private String operationaccount;
	
	
	private String operationcontent;

	private String updatename;


	


	public String getOperationaccount() {
		return operationaccount;
	}


	public void setOperationaccount(String operationaccount) {
		this.operationaccount = operationaccount;
	}


	public String getOperationcontent() {
		return operationcontent;
	}


	public void setOperationcontent(String operationcontent) {
		this.operationcontent = operationcontent;
	}


	public String getOperatingtime() {
		return operatingtime;
	}


	public void setOperatingtime(String operatingtime) {
		this.operatingtime = operatingtime;
	}


	@Override
	public String toString() {
		return "HealthLogIdReponse [operatingtime=" + operatingtime + ", operationaccount=" + operationaccount
				+ ", operationcontent=" + operationcontent + "]";
	}


	public String getUpdatename() {
		return updatename;
	}

	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
}
