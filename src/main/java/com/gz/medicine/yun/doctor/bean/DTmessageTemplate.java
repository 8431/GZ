package com.gz.medicine.yun.doctor.bean;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 短信模板
 * @author 舵主
 *
 */
public class DTmessageTemplate {
    private String guid;

    private String org;

    private String docguid;

    private String templatename;//'模板名称';

    @Size(min=15,message = "长度最小为15个字符串")
    private String templatecontent;//'模板内容';

    private String crtusr;//  '创建人';

    private Date crtdat;// '创建时间';

    private String updateusr;// '更新人';

    private Date updatedate;

    private String status;  //删除标志位

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

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid == null ? null : docguid.trim();
    }

    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename == null ? null : templatename.trim();
    }

    public String getTemplatecontent() {
        return templatecontent;
    }

    public void setTemplatecontent(String templatecontent) {
        this.templatecontent = templatecontent == null ? null : templatecontent.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getUpdateusr() {
        return updateusr;
    }

    public void setUpdateusr(String updateusr) {
        this.updateusr = updateusr == null ? null : updateusr.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}