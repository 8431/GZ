package com.gz.medicine.yun.doctor.bean;


import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

public class DTteamsg implements Serializable{
    private String guid;//唯一ID
    private String type;//消息类型  1 txt 2file 3cf
    private String msgs;//消息体

    private String blobguid;//文件guid

    private String blguid;//处方guid
    private String msgdat;//消息发送时间

    private Date crtdat;//插入数据库时间
    private String msgsusrguid;//消息发送人
    //自定义字段
    private String teamguid;//团队GUID
    private MultipartFile file;
    private String name;//医生姓名
    private String img;//医生头像
    private String teamDocList;//不在在聊天频道的人

    public void setTeamguid(String teamguid) {
        this.teamguid = teamguid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMsgs() {
        return msgs;
    }

    public void setMsgs(String msgs) {
        this.msgs = msgs == null ? null : msgs.trim();
    }

    public String getBlobguid() {
        return blobguid;
    }

    public void setBlobguid(String blobguid) {
        this.blobguid = blobguid == null ? null : blobguid.trim();
    }

    public String getBlguid() {
        return blguid;
    }

    public void setBlguid(String blguid) {
        this.blguid = blguid == null ? null : blguid.trim();
    }

    public String getMsgdat() {
        return msgdat;
    }

    public void setMsgdat(String msgdat) {
        this.msgdat = msgdat == null ? null : msgdat.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getMsgsusrguid() {
        return msgsusrguid;
    }

    public void setMsgsusrguid(String msgsusrguid) {
        this.msgsusrguid = msgsusrguid == null ? null : msgsusrguid.trim();
    }

    public String getTeamguid() {
        return teamguid;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTeamDocList() {
        return teamDocList;
    }

    public void setTeamDocList(String teamDocList) {
        this.teamDocList = teamDocList;
    }
}