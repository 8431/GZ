package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;
import java.util.Date;



public class HmPermsgReponse  implements Serializable{
	/**
	 * 健康指数
	 * jin
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "PermsgReponse [ healindex=" + healindex + ", healState=" + healState + ", healState1=" + healState1 + "]";
	}

	
	private int healindex;//健康指数
	private String healState;//健康状态评判(健康、亚健康)
	private String healState1;//健康建议
	public int getHealindex() {
		return healindex;
	}
	public void setHealindex(int healindex) {
		this.healindex = healindex;
	}
	public String getHealState() {
		return healState;
	}
	public void setHealState(String healState) {
		this.healState = healState;
	}
	public String getHealState1() {
		return healState1;
	}
	public void setHealState1(String healState1) {
		this.healState1 = healState1;
	}
	
	
	
	

	
	


	
	
	
	
	
}
