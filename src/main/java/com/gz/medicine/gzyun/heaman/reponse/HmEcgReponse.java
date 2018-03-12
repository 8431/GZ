package com.gz.medicine.gzyun.heaman.reponse;

import java.io.Serializable;
import java.util.Date;


/**
 * 心电     返回给前端
 * @author Administrator
 *
 */
public class HmEcgReponse  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 private String guid;

	    private String usrguid;

	    private String meatime;

	    private String hearate;

	    private String brerate;

	    private String meadurof;

	    private String heabeat;

	    private String roomearly;

	    private String preearly;

	    private String maxhearate;

	    private String minhearate;

	    private String refid;

	    private Date crtdat;

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

		public String getMeatime() {
			return meatime;
		}

		public void setMeatime(String meatime) {
			this.meatime = meatime;
		}

		public String getHearate() {
			return hearate;
		}

		public void setHearate(String hearate) {
			this.hearate = hearate;
		}

		public String getBrerate() {
			return brerate;
		}

		public void setBrerate(String brerate) {
			this.brerate = brerate;
		}

		public String getMeadurof() {
			return meadurof;
		}

		public void setMeadurof(String meadurof) {
			this.meadurof = meadurof;
		}

		public String getHeabeat() {
			return heabeat;
		}

		public void setHeabeat(String heabeat) {
			this.heabeat = heabeat;
		}

		public String getRoomearly() {
			return roomearly;
		}

		public void setRoomearly(String roomearly) {
			this.roomearly = roomearly;
		}

		public String getPreearly() {
			return preearly;
		}

		public void setPreearly(String preearly) {
			this.preearly = preearly;
		}

		public String getMaxhearate() {
			return maxhearate;
		}

		public void setMaxhearate(String maxhearate) {
			this.maxhearate = maxhearate;
		}

		public String getMinhearate() {
			return minhearate;
		}

		public void setMinhearate(String minhearate) {
			this.minhearate = minhearate;
		}

		public String getRefid() {
			return refid;
		}

		public void setRefid(String refid) {
			this.refid = refid;
		}

		public Date getCrtdat() {
			return crtdat;
		}

		public void setCrtdat(Date crtdat) {
			this.crtdat = crtdat;
		}

		@Override
		public String toString() {
			return "HmEcgReponse [guid=" + guid + ", usrguid=" + usrguid + ", meatime=" + meatime + ", hearate="
					+ hearate + ", brerate=" + brerate + ", meadurof=" + meadurof + ", heabeat=" + heabeat
					+ ", roomearly=" + roomearly + ", preearly=" + preearly + ", maxhearate=" + maxhearate
					+ ", minhearate=" + minhearate + ", refid=" + refid + ", crtdat=" + crtdat + "]";
		}
	    
	    
	
	
	
	
	
	
}
