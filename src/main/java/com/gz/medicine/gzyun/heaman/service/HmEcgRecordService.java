package com.gz.medicine.gzyun.heaman.service;

import java.util.List;



import org.springframework.stereotype.Service;




import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmEcgRecord;
import com.gz.medicine.gzyun.heaman.reponse.HmEcgReponse;
import com.gz.medicine.gzyun.heaman.request.HmEcgRequest;

/**
 * 心电接口service层
 * 舵主
 * @author Administrator
 *
 */
@Service("hmEcgService")
public interface HmEcgRecordService {
	
	// 加入新数据
    public String addEcg(HmEcgRequest data) throws CommonException;
    // 查询单个数据
    public List<HmEcgReponse> selEcg(String usrguid) throws CommonException; 
}
