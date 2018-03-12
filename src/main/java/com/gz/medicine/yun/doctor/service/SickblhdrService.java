/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.service;

import java.util.*;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTsickbldtl;
import com.gz.medicine.yun.doctor.bean.Sickblhdr;
import com.gz.medicine.gzyun.health.common.service.BaseService;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequestList;
import com.gz.medicine.yun.doctor.request.DTsickblhdrRequest;
import com.gz.medicine.yun.doctor.request.SickbldtlRequest;


/**   
 * @Title: Sickblhdr.java 
 * @Package com.gz.medicine.yun.doctor.service
 * @Description: 病历表 Service
 * @author fendo
 * @date 2017年12月22日 10时23分36秒 星期五 
 * @version V1.0   
*/
public interface SickblhdrService extends BaseService<Sickblhdr>{

    /**
     * 新增用药方案
     * @param sickbldtlRequest
     * @return SimpleResult
     * @throws CommonException
     */
    int addRegimenList(List<SickbldtlRequest> sickbldtlRequest) throws  CommonException;

    /**
     * 新增用药方案
     * @param dtsickbldtl
     * @return
     * @throws CommonException
     */
    int insertDTsickbldtl(DTsickbldtl dtsickbldtl)throws CommonException;

    /**
     * 更新用药方案
     * @param dtsickbldtl
     * @return
     * @throws CommonException
     */
    int updateDTsickbldtl(DTsickbldtl dtsickbldtl)throws CommonException;

    /**
     * 根据病历ID删除用药方案
     * @param sickguid
     * @return
     * @throws CommonException
     */
    int deleteDTsickbldtl(String sickguid)throws CommonException;


}