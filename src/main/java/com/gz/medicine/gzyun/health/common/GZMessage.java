package com.gz.medicine.gzyun.health.common;

/**
 * Created by dlf on 2017/11/13 0013.
 * Email 1429264916@qq.com
 */
public class GZMessage {
    /**
     * @Fields sendMsgContent 发送短信内容
     */

    private String sendMsgContent;
    /**
     * @Fields phoneNum 接受短信手机号
     */

    private String phoneNum;



    public String getSendMsgContent() {
        return sendMsgContent;
    }

    public void setSendMsgContent(String sendMsgContent) {
        this.sendMsgContent = sendMsgContent;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
