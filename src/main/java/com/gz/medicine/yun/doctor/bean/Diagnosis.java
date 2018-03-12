/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.bean;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @Title Diagnosis表的实体类
 * @Description 诊断表
 * @version 1.0
 * @Author fendo
 * @Date 2017年12月26日 12时18分34秒 星期二 
 */
public class Diagnosis implements Serializable{ 


    private static final long serialVersionUID = 1L;
 
    /**
    *  唯一ID
    */  
    private String guid;
    /**
    *  系统号
    */  
    private String org;
    /**
    *  
    */  
    private String id;
    /**
    *  
    */  
    private String name;
    /**
    *  
    */  
    private String acc;
    /**
    *  
    */  
    private String syt;
    /**
    *  创建时间
    */  
    private Date crtdat;
    /**
    *  拼音
    */  
    private String py;
    /**
    *  五笔
    */  
    private String wb;
     
    public Diagnosis(){
    } 
    
    public String getGuid(){    
      return this.guid;    
    }

    public void setGuid(String guid){    
      this.guid = guid;    
    }    
    public String getOrg(){    
      return this.org;    
    }

    public void setOrg(String org){    
      this.org = org;    
    }    
    public String getId(){    
      return this.id;    
    }

    public void setId(String id){    
      this.id = id;    
    }    
    public String getName(){    
      return this.name;    
    }

    public void setName(String name){    
      this.name = name;    
    }    
    public String getAcc(){    
      return this.acc;    
    }

    public void setAcc(String acc){    
      this.acc = acc;    
    }    
    public String getSyt(){    
      return this.syt;    
    }

    public void setSyt(String syt){    
      this.syt = syt;    
    }    
    public Date getCrtdat(){    
      return this.crtdat;    
    }

    public void setCrtdat(Date crtdat){    
      this.crtdat = crtdat;    
    }    
    public String getPy(){    
      return this.py;    
    }

    public void setPy(String py){    
      this.py = py;    
    }    
    public String getWb(){    
      return this.wb;    
    }

    public void setWb(String wb){    
      this.wb = wb;    
    }    
  
      
}  