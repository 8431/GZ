package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;




public class HmSignReponse  implements Serializable{
	/**
	 * 获取日常体征检测数据
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "SignReponse [guid=" + guid + ", usrguid=" + usrguid + ", "
				+ "blglu=" + blglu + ", heat=" + heat + ", "
				+ "totchole=" + totchole + ", toturiac=" + toturiac + ""
				+ ", diablopre=" + diablopre + ", sysblopre=" + sysblopre + "]";
	}
	private String guid;
    private String usrguid;
    private String blglu;//血糖
    private String heat;//体温
    private String totchole;//总胆固醇
    private String toturiac;//尿酸
    private String diablopre;//舒张压    
    private String sysblopre;//收缩压
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
	public String getBlglu() {
		return blglu;
	}
	public void setBlglu(String blglu) {
		this.blglu = blglu;
	}
	public String getHeat() {
		return heat;
	}
	public void setHeat(String heat) {
		this.heat = heat;
	}
	public String getTotchole() {
		return totchole;
	}
	public void setTotchole(String totchole) {
		this.totchole = totchole;
	}
	public String getToturiac() {
		return toturiac;
	}
	public void setToturiac(String toturiac) {
		this.toturiac = toturiac;
	}
	public String getDiablopre() {
		return diablopre;
	}
	public void setDiablopre(String diablopre) {
		this.diablopre = diablopre;
	}
	public String getSysblopre() {
		return sysblopre;
	}
	public void setSysblopre(String sysblopre) {
		this.sysblopre = sysblopre;
	}

    
    
	

	
	
	
}
