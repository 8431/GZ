package com.gz.medicine.yun.doctor.mapper;


import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.request.DTusrRequest;

import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTusrMapper
 * @PackageName com.gz.medicine.yun.doctor.mapper.DTusrMapper
 * @Description 用户接口类
 * @Data 2017-08-19 12:02
 **/
public interface DTusrMapper {

    int deleteByPrimaryKey(String guid);
 
    int insert(DTusr record);

    int insertSelective(DTusr record);

    DTusr selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(DTusr record);

    int updateByPrimaryKey(DTusr record);
    
    int update(DTusr data);
    
    String select(DTusrRequest data);
    
    /**
     *根据患者guid查询手机号与姓名 
     * @author 舵主
     * 上午9:42:59
     */
    DTusr selGuid(String usrguid);


    /**
     *
     *@Title selectByGuidAndChis
     *@Description: 根据用户ID获取机构是CHIS的数据
     *@Author fendo
     *@Date 2017年8月24日 上午10:52
     *@param usrguid
     *@return DTusr
     */
    Map<String,String> selectByGuidAndChis(String usrguid);
}