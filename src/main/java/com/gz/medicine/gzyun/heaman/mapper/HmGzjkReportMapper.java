package com.gz.medicine.gzyun.heaman.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkReport;
import com.gz.medicine.gzyun.heaman.bean.HmReportVo;

import java.util.List;

public interface HmGzjkReportMapper {
    int insert(HmGzjkReport record);

    int insertSelective(HmGzjkReport record);
    /**
     * 20170807新增 by dlf
     *  健康评估列表接口
     * @param guid
     * @return
     */
    List<HmGzjkReport> selectGzjkReportMsg(String guid) throws CommonException;

    /**
     *
     * 20170808新增 by dlf
     * @param guid
     * @return
     * @throws Exception
     */
   List <HmReportVo> getHealthyDetail(String guid) throws  CommonException;

    /**
     * 20170808新增 by dlf
     * @param guid
     * @return
     * @throws Exception
     */
   List <HmReportVo> getHeaPlanList(String guid) throws  CommonException;

    /**
     * 20170808新增 by dlf
     * @param guid
     * @return
     * @throws Exception
     */
   List <HmReportVo> getHeaPlanDetails(String guid) throws  CommonException;




}