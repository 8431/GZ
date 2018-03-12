package com.gz.medicine.gzyun.push.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.controller.HealthAddrInfoController;
import com.gz.medicine.gzyun.push.bean.HealthUmengEquipment;
import com.gz.medicine.gzyun.push.mapper.HealthUmengEquipmentMapper;
import com.gz.medicine.gzyun.push.service.HealthUmengEquipmentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title HealthUmengEquipmentServiceImpl
 * @Description 友盟推送绑定设备的ServiceImpl
 * @version 1.0
 * @Author fendo
 * @Date 2017-11-01 10:57:55
 */
@Service
public class HealthUmengEquipmentServiceImpl implements HealthUmengEquipmentService {

    public static final Logger LOGGER = Logger.getLogger(HealthUmengEquipmentServiceImpl.class);

    @Autowired
    private HealthUmengEquipmentMapper healthUmengEquipmentMapper;

    @Override
    public int insertHealthUmengEquipment(HealthUmengEquipment healthUmengEquipment) throws CommonException {
        int falg = 0;
        try {
            healthUmengEquipment.setId(UUIDTool.getUUID());
            healthUmengEquipmentMapper.insertSelective(healthUmengEquipment);
        }catch (Exception e){
            throw new CommonException(SimpleCode.ERROR.getCode(),"插入时失败!!!");
        }
        return falg;
    }

    @Override
    public HealthUmengEquipment getHealthUmengEquipment(String id) throws CommonException {
        HealthUmengEquipment healthUmengEquipment = null;
        try {
            healthUmengEquipment = healthUmengEquipmentMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            LOGGER.error("根据ID获取友盟推送绑定设备时出错" + e.getMessage() + e);
            throw new CommonException("根据ID获取友盟推送绑定设备时出错",e.getMessage());
        }
        return healthUmengEquipment;
    }

    @Override
    public HealthUmengEquipment getByUseridHealthUmengEquipment(String id) throws CommonException {
        HealthUmengEquipment healthUmengEquipment = null;
        try {
            healthUmengEquipment = healthUmengEquipmentMapper.selectByUserID(id);
        }catch (Exception e){
            LOGGER.error("根据ID获取友盟推送绑定设备时出错" + e.getMessage() + e);
            throw new CommonException("根据ID获取友盟推送绑定设备时出错",e.getMessage());
        }
        return healthUmengEquipment;
    }

    @Override
    public int updateHealthUmengEquipment(HealthUmengEquipment healthUmengEquipment) throws CommonException {
        int falg = 0;
        try {
            falg = healthUmengEquipmentMapper.updateByUserId(healthUmengEquipment);
        }catch (Exception e){
            LOGGER.error("根据ID获取友盟推送绑定设备时出错" + e.getMessage() + e);
            throw new CommonException("根据ID获取友盟推送绑定设备时出错",e.getMessage());
        }
        return falg;
    }
}
