package com.gz.medicine.gzyun.health.request;


import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;


public class HealthAddrInfoRequest {
	    private String id;

	    private String usrid;

	    private String consignee;

	    private String phone;

	    private String area;

	    private String address;

	    private String label;

	    private String defaultaddr;

	

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsrid() {
			return usrid;
		}

		public void setUsrid(String usrid) {
			this.usrid = usrid;
		}

		public String getConsignee() {
			return consignee;
		}

		public void setConsignee(String consignee) {
			this.consignee = consignee;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getDefaultaddr() {
			return defaultaddr;
		}

		public void setDefaultaddr(String defaultaddr) {
			this.defaultaddr = defaultaddr;
		}

	
}