package com.gz.medicine.yun.user.service;

import com.gz.medicine.yun.user.bean.Usr;
import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.user.request.SelUserRequest;

@Service("userService")
public interface UserService {
	
    public String queryUser(SelUserRequest data) throws CommonException;

    /**
     * 根据患者ID获取患者信息
     * @param id
     * @return
     * @throws CommonException
     */
    Usr findById(String id)throws CommonException;
} 
