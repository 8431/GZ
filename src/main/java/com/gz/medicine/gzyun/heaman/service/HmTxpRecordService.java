package com.gz.medicine.gzyun.heaman.service;

import java.util.List;



import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.reponse.HmTxpRecordReponse;
import com.gz.medicine.gzyun.heaman.request.HmTxpRecordRequest;

/**
 * 
 * 
 * 尿酸service层
 * @author Administrator
 *
 */
@Service("hmTxpRecordService")
public interface HmTxpRecordService {
	
	// 加入新数据
    public String addTxp(HmTxpRecordRequest data) throws CommonException;
    // 查询单个数据
    public List<HmTxpRecordReponse> selTxp(String usrguid) throws CommonException; 
}
