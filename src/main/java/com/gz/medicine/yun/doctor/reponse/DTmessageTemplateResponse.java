package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;

public class DTmessageTemplateResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String guid;

	private String org;

	private String docguid;

	private String templatename;// '模板名称';

	private String templatecontent;// '模板内容';

	private String crtusr;// '创建人';

	private String crtdat;// '创建时间';

	private String updateusr;// '更新人';

	private String updatedate;

	public DTmessageTemplateResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getDocguid() {
		return docguid;
	}

	public void setDocguid(String docguid) {
		this.docguid = docguid;
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

	public String getUpdateusr() {
		return updateusr;
	}

	public void setUpdateusr(String updateusr) {
		this.updateusr = updateusr;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

}
