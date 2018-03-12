package com.gz.medicine.yun.doctor.service;

import java.util.List;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTdoc;
import com.gz.medicine.yun.doctor.reponse.DTdocReponse;
import com.gz.medicine.yun.doctor.request.DTdocRequest;

/**
 * 登录
 * jin
 * **/


@Service("docService")
public interface DTDocService {
	
	
    DTdocReponse select(DTdocRequest data) throws CommonException;
    
    /**
     * 分页查询在岗医生，@jin
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult queryPageDocin(PageModel page) throws CommonException;

}
