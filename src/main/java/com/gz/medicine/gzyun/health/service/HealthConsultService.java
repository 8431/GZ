package com.gz.medicine.gzyun.health.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;


/**
 * 咨询消息
 * jin
 * **/


@Service("ConService")
public interface HealthConsultService {
	
	/**
     * 分页查询咨询消息，@jin
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPageDocid(PageModel page) throws CommonException;

}
