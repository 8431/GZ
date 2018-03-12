package com.gz.medicine.gzyun.health.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gz.medicine.gzyun.health.mapper.HealthAddrInfoMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.HealthAddrInfo;
import com.gz.medicine.gzyun.health.service.HealthAddrInfoService;


/**
 *地址
 *jin
 **/
@Service
public class HealthAddrInfoServiceImpl implements HealthAddrInfoService{


    public static final Logger LOGGER = Logger.getLogger(HealthAddrInfoServiceImpl.class);
    
    @Autowired
    private HealthAddrInfoMapper infomapper;
	
   /***
    * 新增地址
    * @author jin
    * **/
	@Override
	public int insertSelective(HealthAddrInfo record) throws CommonException {
		HealthAddrInfo info = new HealthAddrInfo();
		try {
				if("0".equals(record.getDefaultaddr())){
				info.setId(UUIDTool.getUUID());
				info.setAddress(record.getAddress());
				info.setUsrid(record.getUsrid());
				info.setPhone(record.getPhone());
				info.setArea(record.getArea());
				info.setConsignee(record.getConsignee());
				info.setDefaultaddr(record.getDefaultaddr());
				info.setLabel(record.getLabel());
				infomapper.insertSelective(info);
				}else if("1".equals(record.getDefaultaddr())){
					infomapper.updatestate(record.getUsrid());
					info.setId(UUIDTool.getUUID());
					info.setAddress(record.getAddress());
					info.setUsrid(record.getUsrid());
					info.setPhone(record.getPhone());
					info.setArea(record.getArea());
					info.setConsignee(record.getConsignee());
					info.setDefaultaddr(record.getDefaultaddr());
					info.setLabel(record.getLabel());
					infomapper.insertSelective(info);		
				}

		} catch (Exception e) {
			throw new CommonException("COM001","在地址新增方法中出错",e);
		}
		return 0;
}

	   /***
	    * 修改地址
	    * @author jin
	    * **/

	@Override
	public int updatebyid(HealthAddrInfo record) throws CommonException {
		// TODO Auto-generated method stub
//		HealthAddrInfo info = new HealthAddrInfo();
		try {
			if("1".equals(record.getDefaultaddr())){
			infomapper.updatestate(record.getUsrid());
			infomapper.updatebyid(record);
			}else{
				
				infomapper.updatebyid(record);
				
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在地址修改方法中出错",e);
		}
		return 0;
	}


	   /***
	    * 假删除地址
	    * @author jin
	    * **/
	@Override
	public int deletebuid(HealthAddrInfo record) throws CommonException {
		// TODO Auto-generated method stub
		HealthAddrInfo info = new HealthAddrInfo();
		try {
			info.setId(record.getId());
			infomapper.deletebyid(info);
		} catch (Exception e) {
			throw new CommonException("COM001","在地址删除方法中出错",e);
		}
		return 0;
	}
	
	
	   /***
	    * 查询地址
	    * @author jin
	    * **/
	@Override
	public List<HealthAddrInfo> selectbyuid(HealthAddrInfo record) throws CommonException {
		// TODO Auto-generated method stub
		List<HealthAddrInfo> list = new ArrayList<HealthAddrInfo>();
		try {
			list = infomapper.selectbyuid(record);
		} catch (Exception e) {
			throw new CommonException("COM001","在查询地址方法中出错",e);
		}
		
		return list;
	}
	}