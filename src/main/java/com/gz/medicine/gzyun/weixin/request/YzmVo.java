package com.gz.medicine.gzyun.weixin.request;

import com.gz.medicine.gzyun.health.vaild.MobileCheck;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */
public class YzmVo {
    @MobileCheck(message="手机格式不对")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
