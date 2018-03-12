package com.gz.medicine.gzyun.health.reponse;

/**预约统计
 * @author 舵主
 *
 * 下午4:29:57
 */
public class HealthOrderNumReponse {
 
	// 预约日期
	private String reservationdate;
	
	// 预约数量
	private String reservationnum;

	public String getReservationdate() {
		return reservationdate;
	}

	public void setReservationdate(String reservationdate) {
		this.reservationdate = reservationdate;
	}

	public String getReservationnum() {
		return reservationnum;
	}

	public void setReservationnum(String reservationnum) {
		this.reservationnum = reservationnum;
	}

	@Override
	public String toString() {
		return "HealthOrderNumReponse [reservationdate=" + reservationdate + ", reservationnum=" + reservationnum + "]";
	}
	
	
	
	
	
}
