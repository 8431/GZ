package com.gz.medicine.gzyun.heaman.bean;

import java.util.Date;


/**
 * 
 * @Title: HmEcgabno.java 
 * @Package com.gz.medicine.gzyun.heaman.bean 
 * @Description: 心电图
 * @Author fendo
 * @Date 2017年8月8日 下午4:54:46 
 * @Version V1.0
 */

public class HmEcgabno {
	
    private String guid;

    private Date crtdat;

    private String type;

    private String value;

    private String usrguid;

    private String flg;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg == null ? null : flg.trim();
    }

	public HmEcgabno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HmEcgabno(String guid, Date crtdat, String type, String value, String usrguid, String flg) {
		super();
		this.guid = guid;
		this.crtdat = crtdat;
		this.type = type;
		this.value = value;
		this.usrguid = usrguid;
		this.flg = flg;
	}

	@Override
	public String toString() {
		return "HmEcgabno [guid=" + guid + ", crtdat=" + crtdat + ", type=" + type + ", value=" + value + ", usrguid="
				+ usrguid + ", flg=" + flg + "]";
	}
    
    
}