package com.gz.medicine.gzyun.yidiagnosis.mapper;

import java.util.List;

import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickbldtl;

public interface YGsickbldtlMapper {
    int insert(YGsickbldtl record);

    int insertSelective(YGsickbldtl record);
    /**
     * 推送病人病史   药品
     * @param formguid
     * @return
     */
    List<YGsickbldtl> selectBySickbldtlKey(String formguid);
}