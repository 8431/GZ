package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.gzyun.health.bean.HealthyLogin;
import com.gz.medicine.gzyun.health.reponse.HealthLoginResponse;
import com.gz.medicine.gzyun.health.request.HealthyLoginRequest;
import com.gz.medicine.gzyun.health.request.HealthyUsrRequest;
import com.gz.medicine.yun.doctor.request.DTusrRequest;

import java.util.List;

/**
 * @author jin
 * 登陆
 * 修改密码
 **/
public interface HealthyLoginMapper {


    int insert(HealthyLogin record);

    int insertSelective(HealthyLogin record);
    
    HealthyLogin queryItemByName(HealthyLoginRequest data);
    
    int updateItemById(HealthyLogin data);
    
    String queryItemById(HealthyUsrRequest data);

    /**
     * 获取状态为8的客服
     * @return
     */
    List<HealthyLogin> selectByState();

    /**
     * 查询管理员
     * @return
     * @throws Exception
     */
   List<HealthyLogin> queryAdminByRole(String state) throws  Exception;


    /**
     * 通过主键查询
     * @param id
     * @return
     * @throws Exception
     */
    HealthyLogin queryHealthyLogin(String  id)throws  Exception;

    HealthyLogin login(String name,String password)throws  Exception;



}