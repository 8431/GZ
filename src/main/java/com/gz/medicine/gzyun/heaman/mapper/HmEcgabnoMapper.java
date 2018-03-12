package com.gz.medicine.gzyun.heaman.mapper;

import com.gz.medicine.gzyun.heaman.bean.HmEcgabno;
/**
 * 
 * @Title: HmEcgabnoMapper.java 
 * @Package com.gz.medicine.gzyun.heaman.mapper 
 * @Description: 心电图 接口类
 * @Author fendo
 * @Date 2017年8月8日 下午4:55:01 
 * @Version V1.0
 */
public interface HmEcgabnoMapper {
	
    int deleteByPrimaryKey(String guid);

    int insert(HmEcgabno data);

    int insertSelective(HmEcgabno data);

    HmEcgabno selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(HmEcgabno data);

    int updateByPrimaryKey(HmEcgabno data);
    
    /**
     * 
     *@Title selectCountByUsrguid 
     *@Description: 根据usrguid统计心电异常次数
     *@Author fendo
     *@Date 2017年8月8日 下午5:16:20
     *@param data
     *@return
     *@throws
     */
    int selectCountByUsrguid(HmEcgabno data);
    
    /**
     * 
     *@Title selectCountByUsrguidAre 
     *@Description: 根据usrguid统计房早异常
     *@Author fendo
     *@Date 2017年8月8日 下午5:16:20
     *@param data
     *@return
     *@throws
     */
    int selectCountByUsrguidAre(HmEcgabno data);
    
    /**
     * 
     *@Title selectCountByUsrguidAva 
     *@Description: 根据usrguid统计室早异常
     *@Author fendo
     *@Date 2017年8月8日 下午5:16:20
     *@param data
     *@return
     *@throws
     */
    int selectCountByUsrguidAva(HmEcgabno data);
    
    /**
     * 
     *@Title selectCountByUsrguidLia 
     *@Description: 根据usrguid统计长间歇异常
     *@Author fendo
     *@Date 2017年8月8日 下午5:16:20
     *@param data
     *@return
     *@throws
     */
    int selectCountByUsrguidLia(HmEcgabno data);
    
    /**
     * 
     *@Title selectNavByUsrguid 
     *@Description: 根据Usrguid统计
     *@Author fendo
     *@Date 2017年8月8日 下午6:07:51
     *@param data
     *@return
     *@throws
     */
    int selectNavByUsrguid(HmEcgabno data);
}