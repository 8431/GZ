package com.gz.medicine.gzyun.health.request;

import org.hibernate.validator.constraints.NotEmpty;


public class HealtheOrderForUpdateRequest {

    @NotEmpty(message = "订单id不能为空！")
    private String orderid;
    @NotEmpty(message = "创建账号不能为空！")
    private String operationaccount;

    @NotEmpty(message = "创建人不能为空！")
    private String createname;
    @NotEmpty(message = "状态不能为空！")
    private String state;
    //ip地址
    private String ip;
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOperationaccount() {
        return operationaccount;
    }

    public void setOperationaccount(String operationaccount) {
        this.operationaccount = operationaccount;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}