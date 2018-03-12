package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthInvoiceInfo;

import java.util.List;

public interface HealthInvoiceInfoMapper {

    int insert(HealthInvoiceInfo record);

    int insertSelective(HealthInvoiceInfo record) throws  Exception;

    /**
     * 查询发票通过用户ID
     * @param usrid
     * @return
     * @throws Exception
     */
    List<HealthInvoiceInfo> queryHealthInvoiceInfoForUsrid (String usrid)throws  Exception;

    /**
     * 修改或者删除
     * @param hf
     * @return
     * @throws Exception
     */
    Integer updateHealthInvoiceInfo(HealthInvoiceInfo hf)throws  Exception;
}