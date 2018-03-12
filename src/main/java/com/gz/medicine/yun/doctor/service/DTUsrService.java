package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.request.DTusrRequest;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthUsrAppServicewww
 * @PackageName com.gz.medicine.yun.doctor.service.HealthUsrAppServicewww
 * @Description 用户 Service接口类
 * @Data 2017-08-17 11:02
 **/
@Service("DTUsrService")
public interface DTUsrService {

    DTusr selectByGuid(String guid)throws CommonException;

	String update(DTusrRequest data) throws CommonException;
	
	/**
	 * 根据患者guid查询手机号与姓名 
	 * @author 舵主
	 *
	 * 上午9:44:19
	 */
	DTusr selGuid(String usrguid)  throws CommonException;

	/**
	 *
	 *@Title selectByGuidAndChis
	 *@Description: 根据用户ID获取机构是CHIS的数据
	 *@Author fendo
	 *@Date 2017年8月24日 上午10:52
	 *@param usrguid
	 *@return Map<String,String>
	 *@throws CommonException
	 */
	Map<String,String> selectByGuidAndChis(String usrguid)throws CommonException;
    
}
