package com.gz.medicine.gzyun.heaman.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmHeatrecord;
import com.gz.medicine.gzyun.heaman.mapper.HmHeatrecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmHeatReponse;
import com.gz.medicine.gzyun.heaman.request.HmHeatRequest;
import com.gz.medicine.gzyun.heaman.service.HmHeatService;

/**
 * 体温
 * jin
 * **/

@Service
public class HmHeatServiceImpl implements HmHeatService {
    
    @Autowired
   private HmHeatrecordMapper heatMapper;

    /**
     * 体温查询
     */


	public List<HmHeatReponse> queryHeat(HmHeatRequest data) throws CommonException {
		List<HmHeatReponse> heatRepList = new ArrayList<HmHeatReponse>();
		try {
			List<HmHeatrecord> heatList = heatMapper.queryHeat(data);
			if(heatList!=null&&heatList.size()>0){
				for(HmHeatrecord heat : heatList){
					HmHeatReponse heatRep = new HmHeatReponse();
					BeanUtils.copyProperties(heat,heatRep);
					Double heatDouble = Double.valueOf(heat.getHeat());
					//stat=1指不正常，=0正常
					if( heatDouble >= 36.0 && heatDouble <= 37.3 ){
						heatRep.setStat(0);
					}else{
						heatRep.setStat(1);
					}
					heatRepList.add(heatRep);
				}
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return heatRepList;
	}
    /**
     * 体温写入
     */
	public int insertHeat(HmHeatRequest data) throws CommonException {
		HmHeatrecord heatrecord = new HmHeatrecord();
		try {
			BeanUtils.copyProperties(data, heatrecord);
			heatMapper.insertHeat(heatrecord);
//			heamanSqueReponse raps=new heamanSqueReponse()
//			BeanUtils.copyProperties(sque,raps);

			
			return 0;
		} catch (Exception e) {
			throw new CommonException("COM001","在添加方法中，出现异常",e);
		}
	
	}

	
}
