/**
 * projectName: GZYUN
 * fileName: DTfollowupPlanServiceImpl.java
 * packageName: com.gz.medicine.yun.doctor.service.impl
 * date: 2017-12-24 21:14
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.doctor.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.mapper.DTfollowupPlanMapper;
import com.gz.medicine.yun.doctor.service.DTfollowupPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DTfollowupPlanServiceImpl
 * @packageName: com.gz.medicine.yun.doctor.service.impl
 * @description: 随访计划ServiceImpl
 * @data: 2017-12-24 21:14
 **/
@Service
public class DTfollowupPlanServiceImpl implements DTfollowupPlanService {

    @Autowired
    private DTfollowupPlanMapper dTfollowupPlanMapper;

    @Override
    public int addFollowupPlaList(List<DTfollowupPlan> DTfollowupPlan) throws CommonException {
        try {
            for (DTfollowupPlan dTfollowupPlan : DTfollowupPlan) {
                dTfollowupPlanMapper.insertSelective(dTfollowupPlan);
            }
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return 0;
    }

    @Override
    public int updateFollowupPlan(DTfollowupPlan dTfollowupPlan) throws CommonException {
        try {
                dTfollowupPlanMapper.updateByPrimaryKeySelective(dTfollowupPlan);
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return 0;
    }

    @Override
    public int insertFollowupPlan(DTfollowupPlan dTfollowupPlan) throws CommonException {
        try {
            dTfollowupPlanMapper.insertSelective(dTfollowupPlan);
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return 0;
    }

    @Override
    public List<DTfollowupPlan> getFollowupPlanList(String sicguid) throws CommonException {
        List<DTfollowupPlan> dTfollowupPlanList;
        try {
            dTfollowupPlanList = dTfollowupPlanMapper.selectDTfollowupPlanList(sicguid);
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return dTfollowupPlanList;
    }

    @Override
    public int deleteByFollowupPlan(String sickguid) throws CommonException {
        try {
            dTfollowupPlanMapper.deleteByFollowupPlan(sickguid);
        }catch (Exception e){
            throw new CommonException("COM001", "Server层异常", e);
        }
        return 0;
    }
}
