package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;


import java.util.List;

/**
 *线下预约
 *jin
 **/

public interface DTPreoffService {

    /**
     * 分页查询Preoff，@jin
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult queryPagePreoff(PageModel page) throws CommonException;

}
