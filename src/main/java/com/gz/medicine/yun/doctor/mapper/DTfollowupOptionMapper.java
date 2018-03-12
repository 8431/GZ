package com.gz.medicine.yun.doctor.mapper;


import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupOption;

import java.util.List;
import java.util.Map;

public interface DTfollowupOptionMapper {
    int deleteByPrimaryKey(String guid);

    int insert(DTfollowupOption record);

    int insertSelective(DTfollowupOption record);

    DTfollowupOption selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(DTfollowupOption record);

    int updateByPrimaryKey(DTfollowupOption record);

    /**
     *查询随访患者管理分页
     * @param p
     * @return
     */
    List<Map<String,Object>> queryPageSfhzgl(Page p) throws Exception;

    /**
     * 随访计划，可配置项目列表
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> querySfjhList() throws Exception;

    /**
     * 批量新增
     * @param mp
     * @return
     * @throws Exception
     */
    int mybatisInsert(Map<String,Object> mp) throws Exception;

    /**
     * 患者随访记录管理详情，通过医生和患者guid查询最近记录的一条
     * @param mp
     * @return
     * @throws Exception
     */
    Map<String,Object> querySfjlList (Map<String,Object> mp)throws Exception;

}