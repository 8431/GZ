package com.gz.medicine.gzyun.heaman.request;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @Title: HmOrder.java 
 * @Package com.gz.medicine.gzyun.heaman.bean 
 * @Description: 订单实体类
 * @Author fendo
 * @Date 2017年8月7日 上午11:01:45 
 * @Version V1.0
 */
public class HmOrderRequest {
	
    private String guid;

    private String orderid;

    private String packageid;

    private String ordername;

    private BigDecimal ordermon;

    private String meofpay;

    private String usrid;

    private String usrname;

    private Date ordercrtdat;

    private String medat;

    private String ordertype;

    private String usrguid;

    private String clordernote;

    private String clorderdat;

    private String review;

    private String reviewdat;

    private String refunds;

    private String refundsdat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getPackageid() {
        return packageid;
    }

    public void setPackageid(String packageid) {
        this.packageid = packageid == null ? null : packageid.trim();
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public BigDecimal getOrdermon() {
        return ordermon;
    }

    public void setOrdermon(BigDecimal ordermon) {
        this.ordermon = ordermon;
    }

    public String getMeofpay() {
        return meofpay;
    }

    public void setMeofpay(String meofpay) {
        this.meofpay = meofpay == null ? null : meofpay.trim();
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    public Date getOrdercrtdat() {
        return ordercrtdat;
    }

    public void setOrdercrtdat(Date ordercrtdat) {
        this.ordercrtdat = ordercrtdat;
    }

    public String getMedat() {
        return medat;
    }

    public void setMedat(String medat) {
        this.medat = medat == null ? null : medat.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getClordernote() {
        return clordernote;
    }

    public void setClordernote(String clordernote) {
        this.clordernote = clordernote == null ? null : clordernote.trim();
    }

    public String getClorderdat() {
        return clorderdat;
    }

    public void setClorderdat(String clorderdat) {
        this.clorderdat = clorderdat == null ? null : clorderdat.trim();
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    public String getReviewdat() {
        return reviewdat;
    }

    public void setReviewdat(String reviewdat) {
        this.reviewdat = reviewdat == null ? null : reviewdat.trim();
    }

    public String getRefunds() {
        return refunds;
    }

    public void setRefunds(String refunds) {
        this.refunds = refunds == null ? null : refunds.trim();
    }

    public String getRefundsdat() {
        return refundsdat;
    }

    public void setRefundsdat(String refundsdat) {
        this.refundsdat = refundsdat == null ? null : refundsdat.trim();
    }

	public HmOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HmOrderRequest(String guid, String orderid, String packageid, String ordername, BigDecimal ordermon, String meofpay,
			String usrid, String usrname, Date ordercrtdat, String medat, String ordertype, String usrguid,
			String clordernote, String clorderdat, String review, String reviewdat, String refunds, String refundsdat) {
		super();
		this.guid = guid;
		this.orderid = orderid;
		this.packageid = packageid;
		this.ordername = ordername;
		this.ordermon = ordermon;
		this.meofpay = meofpay;
		this.usrid = usrid;
		this.usrname = usrname;
		this.ordercrtdat = ordercrtdat;
		this.medat = medat;
		this.ordertype = ordertype;
		this.usrguid = usrguid;
		this.clordernote = clordernote;
		this.clorderdat = clorderdat;
		this.review = review;
		this.reviewdat = reviewdat;
		this.refunds = refunds;
		this.refundsdat = refundsdat;
	}

	@Override
	public String toString() {
		return "HmOrder [guid=" + guid + ", orderid=" + orderid + ", packageid=" + packageid + ", ordername="
				+ ordername + ", ordermon=" + ordermon + ", meofpay=" + meofpay + ", usrid=" + usrid + ", usrname="
				+ usrname + ", ordercrtdat=" + ordercrtdat + ", medat=" + medat + ", ordertype=" + ordertype
				+ ", usrguid=" + usrguid + ", clordernote=" + clordernote + ", clorderdat=" + clorderdat + ", review="
				+ review + ", reviewdat=" + reviewdat + ", refunds=" + refunds + ", refundsdat=" + refundsdat + "]";
	}
    
    
    
    
}