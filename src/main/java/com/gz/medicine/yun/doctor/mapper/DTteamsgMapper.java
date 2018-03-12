package com.gz.medicine.yun.doctor.mapper;


import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTteamsg;

import java.util.List;
import java.util.Map;

public interface DTteamsgMapper {
    int insert(DTteamsg record);

    int insertSelective(DTteamsg record);

    /**
     * 聊天信息分页查询
     * @param p
     * @return
     */
    List<Map<String,Object>>  queryPageTeamsg(Page p);
}