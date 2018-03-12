package com.gz.medicine.gzyun.yidiagnosis.mapper;

import com.gz.medicine.gzyun.yidiagnosis.bean.YGchisJwslog;

public interface YGchisJwslogMapper {
    int insert(YGchisJwslog record);

    int insertSelective(YGchisJwslog record);
    /**
     * 先查询一下CHIS_JWSLOG表中是否有这条数据 中间表
     * @param blguid
     * @return
     */
   String selectCount(String blguid);
   /**
    * 执行一次向CHIS_JWSLOG插入一条数据
    * @param blguid
    * @return
    */
   int  insertBlguid(YGchisJwslog record);
}