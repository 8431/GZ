package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

public class DTteamsgext {
    private String guid;

    private String msgguid;

    private String usrguid;

    private String teamguid;

    private String stat;

    private Date crtdat;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getMsgguid() {
        return msgguid;
    }

    public void setMsgguid(String msgguid) {
        this.msgguid = msgguid == null ? null : msgguid.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getTeamguid() {
        return teamguid;
    }

    public void setTeamguid(String teamguid) {
        this.teamguid = teamguid == null ? null : teamguid.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }
}