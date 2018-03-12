package com.gz.medicine.yun.doctor.bean;

import java.util.Date;

public class DTpreno {
    private String guid;

    private String acc;

    private String org;

    private String syt;

    private String formguid;

    private Date crtdat;

    private String flg;

    private Long seqid;

    private String preno;

    private String predat;

    private String usrid;

    private String stat;

    private String monstat;

    private String pbtype;

    private String tim;

    private String type;
    
    private String crtusr;
    private String name;
    private String id;
    private String patnam;
    private String age;
    private String sex;

    
    
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getSyt() {
        return syt;
    }

    public void setSyt(String syt) {
        this.syt = syt == null ? null : syt.trim();
    }

    public String getFormguid() {
        return formguid;
    }

    public void setFormguid(String formguid) {
        this.formguid = formguid == null ? null : formguid.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg == null ? null : flg.trim();
    }

    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    public String getPreno() {
        return preno;
    }

    public void setPreno(String preno) {
        this.preno = preno == null ? null : preno.trim();
    }

    public String getPredat() {
        return predat;
    }

    public void setPredat(String predat) {
        this.predat = predat == null ? null : predat.trim();
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getMonstat() {
        return monstat;
    }

    public void setMonstat(String monstat) {
        this.monstat = monstat == null ? null : monstat.trim();
    }

    public String getPbtype() {
        return pbtype;
    }

    public void setPbtype(String pbtype) {
        this.pbtype = pbtype == null ? null : pbtype.trim();
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim == null ? null : tim.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public String getCrtusr() {
		return crtusr;
	}

	public void setCrtusr(String crtusr) {
		this.crtusr = crtusr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatnam() {
		return patnam;
	}

	public void setPatnam(String patnam) {
		this.patnam = patnam;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
    
    
}