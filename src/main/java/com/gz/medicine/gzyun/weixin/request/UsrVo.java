package com.gz.medicine.gzyun.weixin.request;

import com.gz.medicine.gzyun.health.vaild.MobileCheck;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */
public class UsrVo {
    @MobileCheck(message="手机格式不对")
    private String name;
    @NotEmpty(message="密码不能为空")
    private String password;
    @NotEmpty(message="openid不能为空")
    private String openid;
    private String yzm;
    @NotEmpty(message="type不能为空")
    private String type;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
