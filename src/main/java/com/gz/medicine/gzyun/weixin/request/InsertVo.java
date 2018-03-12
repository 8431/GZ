package com.gz.medicine.gzyun.weixin.request;

import com.gz.medicine.gzyun.health.vaild.DateCheck;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dlf on 2017/12/4 0004.
 * Email 1429264916@qq.com
 */
public class InsertVo {
    @NotEmpty(message = "患者id不能为空")
    private String usrguid;

    @DateCheck(type = "YYYY-MM-DD HH:MI",message = "时间格式不对")
    private String meatime;

    @NotEmpty(message = "测量值不能为空")
    private String value1;

    private String value2;

    private String statekey;

    @NotEmpty(message = "类型不能为空")
    private String type;
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

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getStatekey() {
        return statekey;
    }

    public void setStatekey(String statekey) {
        this.statekey = statekey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
