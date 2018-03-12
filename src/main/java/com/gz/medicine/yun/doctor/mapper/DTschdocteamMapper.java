package com.gz.medicine.yun.doctor.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTschdocteam;

import java.util.List;
import java.util.Map;

public interface DTschdocteamMapper {
    int insert(DTschdocteam record);

    int insertSelective(DTschdocteam record);

    /**
     * 分页查询医生圈
     * @param p
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryPageDoctorQuan(Page p) throws Exception;

    /**
     * 查询医生圈团队人数
     * @param teamGuid
     * @return
     * @throws Exception
     */
    Map<String,Object> queryTeamNum(String teamGuid)throws Exception;


    /**
     *查询医生团队人员详情
     * @param teamGuid
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> queryTeamDetail(String teamGuid)throws Exception;

    /**
     * 查询医生姓名和图片通过医生guid
     * @param docGuid
     * @return
     * @throws Exception
     */
    Map<String,Object> queryDoctorDetail(String docGuid)throws Exception;
}