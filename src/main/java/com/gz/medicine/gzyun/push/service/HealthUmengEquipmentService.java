package com.gz.medicine.gzyun.push.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;

/**
 * @Title HealthUmengEquipmentService
 * @Description  友盟推送绑定设备的Service
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
public interface HealthUmengEquipmentService {

    /**
     *插入友盟推送绑定设备
     * @return
     * @throws CommonException
     */
    int insertHealthUmengEquipment(HealthUmengEquipment healthUmengEquipment) throws CommonException;

    /**
     * 根据主键获取友盟推送绑定设备数据
     * @param id
     * @return
     * @throws CommonException
     */
    HealthUmengEquipment getHealthUmengEquipment(String id) throws  CommonException;

    /**
     * 根据用户ID获取友盟推送绑定设备数据
     * @param id
     * @return
     * @throws CommonException
     */
    HealthUmengEquipment getByUseridHealthUmengEquipment(String id) throws  CommonException;

    /**
     * 更改信息
     * @param healthUmengEquipment
     * @return
     * @throws CommonException
     */
    int updateHealthUmengEquipment(HealthUmengEquipment healthUmengEquipment)throws CommonException;
}
