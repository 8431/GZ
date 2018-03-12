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
 *线上预约
 *jin
 **/

public interface DTPrenoService {

    /**
     * 分页查询Preno，@金雯雯 把注释写上
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult queryPagePreno(PageModel page) throws CommonException;

}
