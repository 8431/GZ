package com.gz.medicine.yun.doctor.reponse;

import java.io.Serializable;
import java.util.Date;

/**
 *线上预约查询
 *jin
 **/
public class DTprenoResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String preno;

    private String crtusr;

    private String name;

    private String predat;

    private String tim;

    private String id;

    private String patnam;

    private Date crtdat;

  
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
 

    public String getPreno() {
		return preno;
	}



	public void setPreno(String preno) {
		this.preno = preno;
	}



	public String getCrtusr() {
		return crtusr;
	}



	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPredat() {
		return predat;
	}



	public void setPredat(String predat) {
		this.predat = predat;
	}



	public String getTim() {
		return tim;
	}



	public void setTim(String tim) {
		this.tim = tim;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPatnam() {
		return patnam;
	}



	public void setPatnam(String patnam) {
		this.patnam = patnam;
	}



	public Date getCrtdat() {
		return crtdat;
	}



	public void setCrtdat(Date crtdat) {
		this.crtdat = crtdat;
	}



	public DTprenoResponse(String preno, String crtusr, String name, String predat, String tim, String id, String patnam, Date crtdat) {
        this.preno = preno;
        this.crtusr = crtusr;
        this.name = name;
        this.predat = predat;
        this.tim = tim;
        this.id = id;
        this.patnam = patnam;
        this.crtdat = crtdat;
        
    }
}
