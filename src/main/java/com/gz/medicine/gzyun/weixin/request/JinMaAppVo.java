package com.gz.medicine.gzyun.weixin.request;

import com.gz.medicine.gzyun.health.vaild.IdCardCheck;
import com.gz.medicine.gzyun.health.vaild.InsertCheck;
import com.gz.medicine.gzyun.health.vaild.MobileCheck;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */
public class JinMaAppVo {
    @MobileCheck(message="手机格式不对.")
    @InsertCheck(sql="select * from usr where id=#{0}",message = "该手机号已注册过.")
    private String phone;
    @IdCardCheck(message="身份证格式不对.")
    private String idcard;
    @NotEmpty(message="姓名不能为空.")
    private String name;
    private String type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
