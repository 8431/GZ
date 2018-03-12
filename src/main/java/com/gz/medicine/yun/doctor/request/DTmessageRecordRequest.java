package com.gz.medicine.yun.doctor.request;

import java.io.Serializable;

public class DTmessageRecordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @NotEmpty(message="guid不能为空！")
	private String guid;// '内部唯一编号';

	private String usrguid;// '内部唯一编号';

	private String docguid;// '内部唯一编号';

	public DTmessageRecordRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getUsrguid() {
		return usrguid;
	}

	public void setUsrguid(String usrguid) {
		this.usrguid = usrguid;
	}

	public String getDocguid() {
		return docguid;
	}

	public void setDocguid(String docguid) {
		this.docguid = docguid;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	// public Date getMessagesenddate() {
	// return messagesenddate;
	// }
	//
	// public void setMessagesenddate(Date messagesenddate) {
	// this.messagesenddate = messagesenddate;
	// }
	//
	// public String getMessagesendcontent() {
	// return messagesendcontent;
	// }
	//
	// public void setMessagesendcontent(String messagesendcontent) {
	// this.messagesendcontent = messagesendcontent;
	// }

}
