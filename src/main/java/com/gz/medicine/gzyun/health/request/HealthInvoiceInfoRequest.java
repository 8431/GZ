package com.gz.medicine.gzyun.health.request;

import com.gz.medicine.gzyun.health.vaild.InsertCheck;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Description 发票基本信息表
 * @version 1.0
 * @Author fendo
 * @Date 2017-10-16 16:22:23
 */
public class HealthInvoiceInfoRequest {

    private String id;
    @NotEmpty(message = "用户id不能为空")
    private String usrid;
    @NotEmpty(message = "发票类型不能为空")
    private String invoicetype;
    @NotEmpty(message = "发票抬头不能为空")
    private String rise;
    private String taxnumber;
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