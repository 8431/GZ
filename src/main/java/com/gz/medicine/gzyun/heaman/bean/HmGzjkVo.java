package com.gz.medicine.gzyun.heaman.bean;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public class HmGzjkVo<T>{
    private  String mwid;
    private  String ftuncid;
    private T modePo;
    public HmGzjkVo(){

    }
    public HmGzjkVo(T t){
        this.modePo=t;

    }
    public String getMwid() {
        return mwid;
    }

    public void setMwid(String mwid) {
        this.mwid = mwid;
    }

    public String getFtuncid() {
        return ftuncid;
    }

    public void setFtuncid(String ftuncid) {
        this.ftuncid = ftuncid;
    }

    public T getModePo() {
        return modePo;
    }

    public void setModePo(T modePo) {
        this.modePo = modePo;
    }
}
