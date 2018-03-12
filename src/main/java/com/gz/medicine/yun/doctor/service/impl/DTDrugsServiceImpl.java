package com.gz.medicine.yun.doctor.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.yun.doctor.bean.DTdru;
import com.gz.medicine.yun.doctor.mapper.DTdruMapper;
import com.gz.medicine.yun.doctor.reponse.DTdruResponse;
import com.gz.medicine.yun.doctor.service.DTDrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTDrugsServiceImpl
 * @PackageName com.gz.medicine.yun.doctor.service.impl
 * @Description 药品Service 实现类
 * @Data 2017-08-18 9:29
 **/
@Service
public class DTDrugsServiceImpl implements DTDrugsService{

    @Autowired
    DTdruMapper dTdruMapper;

    @Override
    public Page page(PageModel page) throws CommonException {
        Page p=page.getPage();
        List<DTdruResponse> pageJson=dTdruMapper.queryPageLikeName(p);
        p.setParameterType(pageJson);
        return p;
    }
}
