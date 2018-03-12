package com.gz.medicine.yun.user.bean;

public class Usrr {
 
	 	private String guid;

	    private String org;

	    private String id;

	    private String loc;

	    private String name;

	    private String passwd;
	    
	    public Usrr() {
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

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getLoc() {
			return loc;
		}

		public void setLoc(String loc) {
			this.loc = loc;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}

		@Override
		public String toString() {
			return "Usrr [guid=" + guid + ", org=" + org + ", id=" + id + ", loc=" + loc + ", name=" + name
					+ ", passwd=" + passwd + "]";
		}
	    
	    
}
