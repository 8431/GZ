package com.gz.medicine.gzyun.health.mapper;

import java.util.List;

import com.gz.medicine.gzyun.health.bean.HealthAddrInfo;
import com.gz.medicine.gzyun.health.request.HealthAddrInfoRequest;

/**
 *地址
 */
public interface HealthAddrInfoMapper {

    int insert(HealthAddrInfo record);

    int insertSelective(HealthAddrInfo record);
    
 //   int insertadd(HealthAddrInfo record) throws Exception;
    
    //修改状态为0
    int updatestate(String usrid) throws Exception;
    
   //修改该条状态为1
    int updateone(String id) throws Exception;
    
    //修改收货地址内容
    int updatebyid(HealthAddrInfo record) throws Exception;
    
    //删除
    int deletebyid(HealthAddrInfo record) throws Exception;
    
    //查询所有地址
    List<HealthAddrInfo> selectbyuid(HealthAddrInfo record) throws Exception;
    
    
    
}