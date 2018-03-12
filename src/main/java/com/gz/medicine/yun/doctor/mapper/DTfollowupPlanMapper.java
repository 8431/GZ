package com.gz.medicine.yun.doctor.mapper;


import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.reponse.DTfollowupPlanResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DTfollowupPlanMapper {
    int deleteByPrimaryKey(String guid);

    int insert(DTfollowupPlan record);

    int insertSelective(DTfollowupPlan record) throws Exception;

    DTfollowupPlan selectByPrimaryKey(String guid) throws Exception;;

    int updateByPrimaryKeySelective(DTfollowupPlan record) throws CommonException;

    int updateByPrimaryKey(DTfollowupPlan record) throws CommonException;

    //根据随访记录ID更改随访计划状态为1,表示已随访
    int updateByfollowState(DTfollowupPlan record);

    /**
     * PC端App端患者随访计划列表
     * @param p
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryPageHzsfjh(Page p)throws Exception;
    
    
    /**
     * 云随访诊室结束随访接口---- 根据患者GUID
     * @param p
     * @return
     * @throws Exception
     */
    int setFollowUpEnd(DTfollowupPlan dTfollowupPlan)throws Exception;


    
    /**
     * 随访任务列表（搜索、分页）
     * @param p
     * @return
     * @throws Exception
     */
    List<DTfollowupPlanResponse> queryPageFollUpTasks(Page page)throws Exception;


    /**
     * 查询患者随访计划
     * @param docguid 医生guid
     * @param usrguid  患者guid
     * @return
     * @throws Exception
     */
    List<Map<String,Object>>  queryPlan(String docguid,String usrguid) throws Exception;

    /**
     * 查询患者详情
     * @param guid
     * @return
     * @throws Exception
     */
    Map<String,Object>  queryUsrDetail(String guid) throws Exception;

    /**
     * 查询医生信息
     * @param docguid
     * @return
     * @throws Exception
     */
    Map<String,Object>  queryDoctor(String docguid) throws Exception;

    /**
     * 查询病例诊断
     * @param sicguid
     * @return
     * @throws Exception
     */
    Map<String,Object>  querySic(String sicguid) throws Exception;

    /**
     * 今日随访，带随访人数
     * @param page
     * @return
     * @throws Exception
     */
    int queryFollUpTasksNum(String page)throws Exception;

    /**
     * 根据病历ID获取随访信息
     * @param sickguid
     * @return
     * @throws Exception
     */
    List<DTfollowupPlan> selectDTfollowupPlanList(String sickguid)throws Exception;

    /**
     * 根据病历ID删除随访计划
     * @param sickguid
     * @return
     * @throws CommonException
     */
    int deleteByFollowupPlan(@Param("sickguid") String sickguid)throws CommonException;

}