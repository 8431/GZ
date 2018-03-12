package com.gz.medicine.yun.doctor.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTsickblhdr;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrsReponse;

import java.util.List;

/**
 *
 * @Title: DTsickblhdrMapper.java
 * @Package com.gz.medicine.yun.doctor.mapper
 * @Description: 病例接口
 * @Author fendo
 * @Date 2017年8月7日 上午10:23:10
 * @Version V1.0
 */

public interface DTsickblhdrMapper {

    int insert(DTsickblhdr record);

    int insertSelective(DTsickblhdr record);

    DTsickblhdrsReponse selectByGuid(String guid);

    List<DTsickblhdrsReponse> selectByUrguid(String usrguid);

    List<DTsickblhdr> queryPageGuid(Page p);

    List<DTsickblhdrResponse> queryPagedocGuid(Page p);

    List<DTsickblhdrResponse> queryPageGuids(Page p);

    List<DTsickblhdrResponse> queryPageGuidByCrtdatDesc(Page p);
}