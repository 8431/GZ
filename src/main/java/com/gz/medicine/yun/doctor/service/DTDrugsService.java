package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTDrugsService
 * @PackageName com.gz.medicine.yun.doctor.service
 * @Description 药品 接口类
 * @Data 2017-08-18 9:27
 **/
@Service("DTDrugsService")
public interface DTDrugsService {

    /**
     * 分页service
     * @param page 返回分页数据对象
     * @return
     * @throws CommonException
     */
    Page page(PageModel page) throws CommonException;

}
