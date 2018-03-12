package com.gz.medicine.gzyun.health.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;


/**
 * 查询评价
 * jin
 * **/


@Service("EvaService")
public interface HealthEvaluateService {
	
	/**
     * 分页查询评价，@jin
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPageMyid(PageModel page) throws CommonException;

}
