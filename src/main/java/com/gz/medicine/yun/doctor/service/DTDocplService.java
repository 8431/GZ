package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;


import java.util.List;

/**
 *业绩考核
 *jin
 **/

public interface DTDocplService {

    /**
     * 分页查询业绩考核，@jin
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult queryPageDocpl(PageModel page) throws CommonException;

}
