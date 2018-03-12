package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthInvoiceRecord;

public interface HealthInvoiceRecordMapper {

    int insert(HealthInvoiceRecord record);

    int insertSelective(HealthInvoiceRecord record) throws Exception;

    /**
     * 查询发票记录通过订单ID
     * @param orderid
     * @return
     * @throws Exception
     */
    HealthInvoiceRecord queryHealthInvoiceRecordForOrderId(String orderid)throws Exception;

    /**
     * 更新物流信息
     * @param record
     * @return
     * @throws Exception
     */
    Integer  updateHealthInvoiceRecordForOrderId(HealthInvoiceRecord record)throws Exception;
    HealthInvoiceRecord queryByid(String id) throws Exception;

}