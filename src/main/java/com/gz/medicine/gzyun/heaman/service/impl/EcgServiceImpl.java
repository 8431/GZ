//package com.gz.medicine.gzyun.heaman.service.impl;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.gz.medicine.common.exception.CommonException;
//import com.gz.medicine.common.util.DateUtils;
//import com.gz.medicine.gzyun.heaman.service.EcgService;
//import com.gz.medicine.yun.user.request.SelUserRequest;
//
//@Service
//public class EcgServiceImpl implements EcgService {
//    
//    @Autowired
//   private WeiXinUsrMapper usrMapper;
//
//   /**
//    * 心电最新测量数据入库
//    */
//	public String addEcg(SelUserRequest data) throws CommonException {
//		Usr usr;
//		try {
//			usr = usrMapper.selectByPrimaryKey(data.getId());
//			Usr usrNew = new Usr();
//			// 判断是否为空
//			if(usr!=null){  // 空，进行新增
//				if(usr.getGzguid()!=null){
//					usrNew.setGuid(usr.getGuid());
//					usrNew.setGzguid(data.getUuidKey());
//					
//				}
//				
//			}else{// 不为空，进行修改
//				
//			}
//			UserReponse rep=new UserReponse();
//			
//			BeanUtils.copyProperties(usr,rep);
//			String  passwd= usr.getPasswd();
//			
//			return passwd;
//		} catch (Exception e) {
//			throw new CommonException("COM001","在整合方法中，出现异常",e);
//		}
//		
//	}
//	
//	/**
//	 * 根据单个患者编号查询心电数据
//	 * @return
//	 * @throws CommonException
//	 */
//	public void selEcg(String usrguid) throws CommonException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public String addEcg(SelUserRequest data) throws CommonException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//
//	
//	
//	
//	
//
//	
//	
//	
//	
//}
