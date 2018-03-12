package com.gz.medicine.yun.doctor.request;

import java.io.Serializable;
import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTsickbldtlRequestList
 * @PackageName com.gz.medicine.yun.doctor.request
 * @Description 病历请求List数据封装
 * @Data 2017-08-19 14:21
 **/
public class DTsickbldtlRequestList implements Serializable {

    private List<DTsickbldtlRequest> dts;


    public List<DTsickbldtlRequest> getDts() {
        return dts;
    }

    public void setDts(List<DTsickbldtlRequest> dts) {
        this.dts = dts;
    }

    public DTsickbldtlRequestList() {
    }
}
