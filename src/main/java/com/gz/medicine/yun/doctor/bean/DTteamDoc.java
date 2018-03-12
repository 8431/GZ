package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

public class DTteamDoc {
    private String guid;

    private String org;

    private Date crtdat;

    private String teamguid;

    private String docguid;

    private String node;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getTeamguid() {
        return teamguid;
    }

    public void setTeamguid(String teamguid) {
        this.teamguid = teamguid == null ? null : teamguid.trim();
    }

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid == null ? null : docguid.trim();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }
}