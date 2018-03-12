package com.gz.medicine.gzyun.health.common;

import com.gz.medicine.common.exception.CommonException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public enum GzHealthyCodeEnum {
    //1.订单业务相关code从001001-001999
    HEALTHORDER_CODE("001000", "订单主业务模块异常"),
    HEALTHORDER_QUERYORDERDETAIL_CODE("001001", "查看订单详情server异常"),
    HEALTHORDER_CANCELORDERANDLOG_CODE("001002", "取消订单server异常"),
    HEALTHDOCTOR_CODE("002000", "医生信息模块异常"),
    HEALTHDOCTORFORM_CODE("003000", "医生排版表业务模块异常"),
    ORDERLOG_CODE("004000", "订单日志表业务模块异常"),
    HEALTHCONSULTATION_CODE("005000", "咨询表业务模块异常"),
    HEALTHADDRINFO_CODE("006000", "发票收货地址业务模块异常"),
    HEALTHEVALUATE_CODE("007000", "患者评价业务模块异常"),
    HEALTHINVOICEINFO_CODE("008000", "发票信息表业务模块异常"),
    HEALTHINVOICERECORD_CODE("009000", "发票记录表业务模块异常"),


    //微信业务
    WEIXIN_USR_CODE("100000", "微信业务模块异常"),
    WEIXIN_USR_LOGIN_CODE("100001", "微信登录业务模块异常"),
    WEIXIN_USR_GETWINXINUSRINFO_CODE("100002", "openid获取微信用户信息业务模块异常"),
    WEIXIN_USR_CHECKUSR_CODE("100003", "校验用户是否注册过，并是否绑定微信异常"),
    WEIXIN_USR_INSERTSQL_CODE("100004", "体检数据录入异常"),
    WEIXIN_USR_QUERYTJSJ_CODE("100005", "查询体检数据的月份异常"),
    WEIXIN_USR_QUERYTJSJBYMONTH_CODE("100006", "根据月份查询当月所有数据异常"),
    WEIXIN_USR_QUERYPAGESICKBLHDR("100008", "获取病例列表数据异常"),
    WEIXIN_USR_BYIDCARD("100009", "通过身份证查询患者异常"),
    WEIXIN_USR_DELTJSJ_CODE("100007", "删除体检数据的月份异常"),
    //第三方注册
    THRID_USR_REGISTER_CODE("JMY001", "注册业务异常");
    String value;
    String name;

    GzHealthyCodeEnum(String name, String value) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    }
