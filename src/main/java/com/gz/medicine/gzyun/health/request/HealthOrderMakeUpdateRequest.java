package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 预约修改接口
 * @author 舵主
 *
 * 下午6:14:32
 */
public class HealthOrderMakeUpdateRequest {
	
	@NotEmpty(message="orderid不能为空")
	private  String orderid;
	
	private String datea;
	
	private String timea;
	
    // 操作名
	private String accname;
	
	private String opencontent;
	public String getOpencontent() {
		return opencontent;
	}

	public void setOpencontent(String opencontent) {
		this.opencontent = opencontent;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getDatea() {
		return datea;
	}

	public void setDatea(String datea) {
		this.datea = datea;
	}

	public String getTimea() {
		return timea;
	}

	public void setTimea(String timea) {
		this.timea = timea;
	}

	@Override
	public String toString() {
		return "HealthOrderMakeUpdateRequest [orderid=" + orderid + ", datea=" + datea + ", timea=" + timea
				+ ", accname=" + accname + ", opencontent=" + opencontent + "]";
	}

	
	
	
	
	
	
}
