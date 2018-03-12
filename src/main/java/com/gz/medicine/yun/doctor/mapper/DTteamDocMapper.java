package com.gz.medicine.yun.doctor.mapper;


import com.gz.medicine.yun.doctor.bean.DTteamDoc;

import java.util.Map;

public interface DTteamDocMapper {
    int insert(DTteamDoc record);

    int insertSelective(DTteamDoc record);

    /**
     * 批量更新聊天成员未读信息数
     * @param mp
     * @return
     * @throws Exception
     */
    int UpdateMessagestat(Map<String,Object>mp)throws Exception;

    /**
     * 更新未读消息为0
     * @param docid
     * @return
     * @throws Exception
     */
    int updateUnreadMsg(String docid,String teamGuid)throws Exception;


}