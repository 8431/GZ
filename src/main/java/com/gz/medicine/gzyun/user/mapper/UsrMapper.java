package com.gz.medicine.gzyun.user.mapper;

import com.gz.medicine.common.exception.CommonException;

import org.apache.ibatis.annotations.Param;

import com.gz.medicine.gzyun.user.bean.ObcUsr;
import com.gz.medicine.gzyun.user.bean.Usr;

import java.util.List;

public interface UsrMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Usr record);

    int insertSelective(Usr record);

    Usr selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Usr record);

    int updateByPrimaryKey(Usr record);
    
    Usr selectByMobile(@Param("mobile") String mobile);

    /**
     * 20170807新增 by dlf
     * @param record
     * @return
     * @throws Exception
     */
    int updateByUsrguidAndChis(Usr record) throws CommonException;

    /**
     * 20170807新增 by dlf
     * @param name
     * @return
     * @throws Exception
     */
    String getNamebyName(String name)throws CommonException;

    
    
    /**
     * 根据用户guid查询用户密码
     * 舵主
     * @return
     * @throws CommonException
     */
    String selGuidPwd(String guid) throws  CommonException;
    
    
    /**
     * 根据用户手机号查询用户密码
     * 舵主
     * @return
     * @throws CommonException
     */
    String selIdPwd(String mobile) throws  CommonException;
    
    
    /**
     * 根据用户guid修改用户密码
     * 舵主
     * @return
     * @throws CommonException
     */
    int upGuidPwd(Usr record) throws  CommonException;
    
    
    
    /**
     * 根据用户手机号修改用户密码
     * 舵主
     * @return
     * @throws CommonException
     */
    int upIdPwd(Usr record) throws  CommonException;

    
    /**
     * 推送医生在岗信息
     * @param guid
     * @return
     * @throws CommonException
     */
    List<ObcUsr> selectByDOCLINE(String guid) throws CommonException;
    
    /**
     * 个人信息查询
     * @param guid
     * @return
     * @throws CommonException
     */
    Usr selectByRecord(String guid) throws CommonException;


    
    

}