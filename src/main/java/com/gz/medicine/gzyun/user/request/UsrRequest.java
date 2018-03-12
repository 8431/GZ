package com.gz.medicine.gzyun.user.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UsrRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty(message="guid不能为空！") 
	private String guid;
	@NotEmpty(message="mbid不能为空！") 
	private String mbid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	@Override
	public String toString() {
		return "DEUsrRequest [guid=" + guid + ", mbid=" + mbid + "]";
	}

}
