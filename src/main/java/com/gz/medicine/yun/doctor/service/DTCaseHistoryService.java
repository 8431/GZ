package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.reponse.DTsickbldtlResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrsReponse;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequest;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequestList;
import com.gz.medicine.yun.doctor.request.DTsickblhdrRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTCaseHistoryService
 * @PackageName com.gz.medicine.yun.doctor.service
 * @Description 病历 Service接口类
 * @Data 2017-08-17 11:02
 **/
@Service("DTCaseHistoryService")
public interface DTCaseHistoryService {

    /**
     * 分页service
     * @param page 返回分页数据对象
     * @return
     * @throws CommonException
     */
    Page page(PageModel page) throws CommonException;



    /**
     * 新增病历
     * @param dTsickbldtlRequestList,dTsickblhdrRequest
     * @return SimpleResult
     * @throws CommonException
     */
    SimpleResult addMedicalRecords(DTsickbldtlRequestList dTsickbldtlRequestList, DTsickblhdrRequest dTsickblhdrRequest) throws  CommonException;


    /**
     * 根据guid获取病历
     * @param guid
     * @return SimpleResult
     * @throws CommonException
     */
    DTsickblhdrsReponse getMedicalRecordsByGuid(String guid) throws CommonException;


    /**
     * 根据医生ID获取病历
     * @param page
     * @return
     * @throws CommonException
     */
    Page getProfileDetails(PageModel page)throws CommonException;


    /**
     * 根据guid获取用药方案
     * @param formguid
     * @return SimpleResult
     * @throws CommonException
     */
    List<DTsickbldtlResponse> getRegimenByFormGuid(String formguid) throws CommonException;
}
