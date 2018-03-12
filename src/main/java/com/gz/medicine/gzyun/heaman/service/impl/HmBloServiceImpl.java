package com.gz.medicine.gzyun.heaman.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmBlgRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmBlgRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmBloReponse;
import com.gz.medicine.gzyun.heaman.request.HmBloRequest;
import com.gz.medicine.gzyun.heaman.service.HmBloService;

/**
 * 血糖
 * jin
 * **/

@Service
public class HmBloServiceImpl implements HmBloService {
    
    @Autowired
   private HmBlgRecordMapper blgMapper;

    /**
     * 血糖查询
     */


	public List<HmBloReponse> queryBlo(HmBloRequest data) throws CommonException {
		List<HmBloReponse> bloRepList = new ArrayList<HmBloReponse>();
		
		try {
			String pg = data.getPage();
			if("1".equals(pg)){
			List<HmBlgRecord> blgList = blgMapper.selectOne(data.getUsrguid());
			if(blgList!=null&&blgList.size()>0){
				for(HmBlgRecord blg : blgList){
					HmBloReponse bloRep = new HmBloReponse();
					BeanUtils.copyProperties(blg,bloRep);
					Double blgDouble = Double.valueOf(blg.getBlglu());
					String state = blg.getState();
					//STATE=0指饭后，=1指空腹，=2随机 stat=1指不正常，=0正常
					if(state=="0"){

						if(blgDouble>3.9&&blgDouble<11.1){
							
								bloRep.setStat(0);
					 }else{
							bloRep.setStat(1);
							}
								  }else if(state=="1"){
					
						if(blgDouble>3.9&&blgDouble<6.1){
							bloRep.setStat(0);
						}else{
							bloRep.setStat(1);
							 }
					}else if(state=="2"){
						if(blgDouble>=4.0&&blgDouble<=10.0){
							bloRep.setStat(0);
						}else{
							bloRep.setStat(1);
						}
						
					}
					bloRepList.add(bloRep);	
			}

		}
		}else if("2".equals(pg)){
			List<HmBlgRecord> blgList = blgMapper.selectAll(data.getUsrguid());
			if(blgList!=null&&blgList.size()>0){
				for(HmBlgRecord blg : blgList){
					HmBloReponse bloRep = new HmBloReponse();
					BeanUtils.copyProperties(blg,bloRep);
					Double blgDouble = Double.valueOf(blg.getBlglu());
					String state = blg.getState();
					//STATE=0指饭后，=1指空腹，=2随机 stat=1指不正常，=0正常
					if(state=="0"){

						if(blgDouble>3.9&&blgDouble<11.1){
							
							bloRep.setStat(0);
						}
						else{
							bloRep.setStat(1);
						}
					}else if(state=="1"){
					
						if(blgDouble>3.9&&blgDouble<6.1){
							bloRep.setStat(0);
						}else{
							bloRep.setStat(1);
						}
					}else if(state=="2"){
						if(blgDouble>=4.0&&blgDouble<=10.0){
							bloRep.setStat(0);
						}else{
							bloRep.setStat(1);
						}
					}
					bloRepList.add(bloRep);
			}

		}
			
		}
	}
		catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return bloRepList;
	}
    /**
     * 血糖写入
     */
	public int insertBlo(HmBloRequest data) throws CommonException {
		HmBlgRecord blgrecord = new HmBlgRecord();
		try {
			BeanUtils.copyProperties(data, blgrecord);
			blgMapper.insert(blgrecord);			
			return 0;
		} catch (Exception e) {
			throw new CommonException("COM001","在添加方法中，出现异常",e);
		}
	
	}



	
}
