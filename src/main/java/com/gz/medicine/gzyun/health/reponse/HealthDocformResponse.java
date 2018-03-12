package com.gz.medicine.gzyun.health.reponse;

import java.io.Serializable;
import java.util.List;

import com.gz.medicine.gzyun.health.bean.HealthDoctorForm;




public class HealthDocformResponse  implements Serializable{
	/**
	 * 排班查询
	 * jin
	 */
	private static final long serialVersionUID = 1L;

    /**
     * @Fields formdate 排班日期
     */
    private String formdate;
    
    private List<HealthDoctorForm> doctorformlist;


	public String getFormdate() {
		return formdate;
	}

	public void setFormdate(String formdate) {
		this.formdate = formdate;
	}

	public List<HealthDoctorForm> getDoctorformlist() {
		return doctorformlist;
	}

	public void setDoctorformlist(List<HealthDoctorForm> doctorformlist) {
		this.doctorformlist = doctorformlist;
	}

}
