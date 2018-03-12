/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
*/
package com.gz.medicine.yun.doctor.service;

import java.util.*;
import java.util.Map;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.doctor.bean.InspectionItems;
import com.gz.medicine.gzyun.health.common.service.BaseService;
import com.gz.medicine.yun.doctor.request.SickbldtlRequest;


/**   
 * @Title: InspectionItems.java 
 * @Package com.gz.medicine.yun.doctor.service
 * @Description: 病历中的-检查项目 Service
 * @author fendo
 * @date 2017年12月22日 16时28分09秒 星期五 
 * @version V1.0   
*/
public interface InspectionItemsService extends BaseService<InspectionItems>{

    /**
     * 新增检查项目
     * @param inspectionItemsList
     * @return int
     * @throws CommonException
     */
    int addInspectionItemsList( List<InspectionItems> inspectionItemsList) throws  CommonException;

    /**
     * 根据病历ID获取检查项目
     * @param sickguid
     * @return
     * @throws CommonException
     */
    List<InspectionItems> getInspectionItemsList(String sickguid)throws CommonException;

    /**
     * 根据病历ID,删除检查项
     * @param sickguid
     * @return
     * @throws CommonException
     */
    int deleteByInspectionItems(String sickguid)throws CommonException;
}