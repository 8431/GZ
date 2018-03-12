package com.gz.medicine.yun.doctor.bean;

public class DTsms {
	/**
	 * @author 舵主
	 *
	 * 下午4:06:43
	 */
	
	private String id;  // 患者手机号
	
	private String name;  // 患者名称
	
	private String docguid;   // 医生GUID
	
	private String templatename;  // 短信名称
	private String messagesendcontent;  // 短信内容
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getMessagesendcontent() {
		return messagesendcontent;
	}
	public void setMessagesendcontent(String messagesendcontent) {
		this.messagesendcontent = messagesendcontent;
	}
	@Override
	public String toString() {
		return "DTsms [id=" + id + ", name=" + name + ", docguid=" + docguid + ", templatename=" + templatename
				+ ", messagesendcontent=" + messagesendcontent + "]";
	}
	
	
	
	
}
