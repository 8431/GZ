/**
 * projectName: GZYUN
 * fileName: DTfollowupPlanService.java
 * packageName: com.gz.medicine.yun.doctor.service
 * date: 2017-12-24 21:11
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.request.SickbldtlRequest;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DTfollowupPlanService
 * @packageName: com.gz.medicine.yun.doctor.service
 * @description: 随访计划Service
 * @data: 2017-12-24 21:11
 **/
public interface DTfollowupPlanService {

    /**
     * 新增随访计划
     * @param DTfollowupPlan
     * @return SimpleResult
     * @throws CommonException
     */
    int addFollowupPlaList(List<DTfollowupPlan> DTfollowupPlan) throws  CommonException;


    /**
     * 随访计划更新
     * @param dTfollowupPlan
     * @return
     * @throws CommonException
     */
    int updateFollowupPlan(DTfollowupPlan dTfollowupPlan)throws CommonException;

    /**
     * 新增随访计划
     * @param dTfollowupPlan
     * @return
     * @throws CommonException
     */
    int insertFollowupPlan(DTfollowupPlan dTfollowupPlan)throws CommonException;

    /**
     * 根据病历ID获取随访计划
     * @param sicguid
     * @return
     * @throws CommonException
     */
    List<DTfollowupPlan> getFollowupPlanList(String sicguid)throws CommonException;

    /**
     * 根据病历ID删除随访计划
     * @param sickguid
     * @return
     * @throws CommonException
     */
    int deleteByFollowupPlan(String sickguid)throws CommonException;
}
