package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.vaild.DateCheck;
import com.gz.medicine.gzyun.health.vaild.IdCardCheck;
import com.gz.medicine.gzyun.health.vaild.InsertCheck;
import com.gz.medicine.gzyun.health.vaild.MobileCheck;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description 发票记录表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 16:22:23
 */
public class HealthInvoiceRecordRequest {

    private String id;
    @NotEmpty(message = "用户ID不能为空.")
    private String usrid;
    @InsertCheck(sql="select * from HEALTHINVOICERECORD where ORDERID=#{orderid}",message = "不允许重复插入,一个订单只能插入一次记录.")
    private String orderid;
    @NotEmpty(message = "收货人不能为空.")
    private String consignee;
    @MobileCheck(message = "手机号格式不对.")
    private String phone;
    @NotEmpty(message = "收货地址不能为空.")
    private String addr;
    @NotEmpty(message = "发票类型不能为空.")
    private String invoicetype;
    @NotEmpty(message = "发票抬头不能为空.")
    private String rise;
    private String taxnumber;

    private String expressnumber;

    private String expresstype;

    private Date createdate;

    private String createname;

    private Date updatedate;

    private String updatename;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(String invoicetype) {
        this.invoicetype = invoicetype == null ? null : invoicetype.trim();
    }

    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise == null ? null : rise.trim();
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber == null ? null : taxnumber.trim();
    }

    public String getExpressnumber() {
        return expressnumber;
    }

    public void setExpressnumber(String expressnumber) {
        this.expressnumber = expressnumber == null ? null : expressnumber.trim();
    }

    public String getExpresstype() {
        return expresstype;
    }

    public void setExpresstype(String expresstype) {
        this.expresstype = expresstype == null ? null : expresstype.trim();
    }


    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname == null ? null : createname.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdatename() {
        return updatename;
    }

    public void setUpdatename(String updatename) {
        this.updatename = updatename == null ? null : updatename.trim();
    }

}