package com.gz.medicine.gzyun.heaman.service;

import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.user.request.SelUserRequest;

@Service("EcgService")
public interface EcgService {
	
	// 加入新数据
    public String addEcg(SelUserRequest data) throws CommonException;
    // 查询单个数据
    public void selEcg(String usrguid) throws CommonException; 
}
