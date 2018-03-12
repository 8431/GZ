package com.gz.medicine.gzyun.heaman.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.heaman.bean.HmEcgRecord;

/**
 * 
 * @Title: HmEcgService.java 
 * @Package com.gz.medicine.gzyun.heaman.service 
 * @Description: 心电 服务接口
 * @Author fendo
 * @Date 2017年8月8日 下午4:58:34 
 * @Version V1.0
 */
public interface HmEcgService {
	
	
	/**
	 * 
	 *@Title ECGabno 
	 *@Description: 心电异常写入,根据患者guid,报警类型(TYPE),异常值(Value)更新数据
	 *@Author fendo
	 *@Date 2017年8月8日 下午4:59:47
	 *@param data
	 *@return SimpleResult
	 *@throws CommonException
	 */
	SimpleResult ECGabno(String usrguid,String type,String value)throws CommonException;

}
