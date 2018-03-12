package com.gz.medicine.gzyun.yidiagnosis.mapper;

import java.util.List;

import com.gz.medicine.gzyun.yidiagnosis.bean.YGsickblhdr;
import com.gz.medicine.gzyun.yidiagnosis.reponse.YGsickblhdrReponse;

public interface YGsickblhdrMapper {
    int insert(YGsickblhdr record);

    int insertSelective(YGsickblhdr record);
    /**
     * 病史
     * @param sickguid
     * @return
     */
    List<YGsickblhdr> selectBySickguidKey(String sickguid);
}