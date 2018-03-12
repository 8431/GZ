package com.gz.medicine.yun.doctor.request;

import java.io.Serializable;

public class DTmessageTemplateRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String guid;

	private String templatename;// '模板名称';

	private String templatecontent;// '模板内容';

	private String crtusr;// '创建人';

	private String crtdat;// '创建时间';

	public DTmessageTemplateRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getTemplatecontent() {
		return templatecontent;
	}

	public void setTemplatecontent(String templatecontent) {
		this.templatecontent = templatecontent;
	}

	public String getCrtusr() {
		return crtusr;
	}

	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}

	public String getCrtdat() {
		return crtdat;
	}

	public void setCrtdat(String crtdat) {
		this.crtdat = crtdat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
