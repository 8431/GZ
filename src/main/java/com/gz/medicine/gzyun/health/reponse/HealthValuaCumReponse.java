package com.gz.medicine.gzyun.health.reponse;
/**累计评价
 * @author 舵主
 *
 * 下午4:58:13
 */
public class HealthValuaCumReponse {

	//评价时间 
	private String evaluatedate;
	// 评价人数
	private String evaluatenum;
	public String getEvaluatedate() {
		return evaluatedate;
	}
	public void setEvaluatedate(String evaluatedate) {
		this.evaluatedate = evaluatedate;
	}
	public String getEvaluatenum() {
		return evaluatenum;
	}
	public void setEvaluatenum(String evaluatenum) {
		this.evaluatenum = evaluatenum;
	}
	@Override
	public String toString() {
		return "HealthValuaCumReponse [evaluatedate=" + evaluatedate + ", evaluatenum=" + evaluatenum + "]";
	}
	
	
	
	
	
}
