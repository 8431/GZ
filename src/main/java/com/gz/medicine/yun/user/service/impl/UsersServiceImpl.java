package com.gz.medicine.yun.user.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.yun.user.bean.Usr;
import com.gz.medicine.yun.user.mapper.UsrsMapper;
import com.gz.medicine.yun.user.request.SelUserRequest;
import com.gz.medicine.yun.user.service.UserService;

@Service
public class UsersServiceImpl implements UserService {
    
    @Autowired
    private UsrsMapper usrMapper;

    /**
     * 整合数据库操作 
     */
	public String queryUser(SelUserRequest data) throws CommonException {
		Usr usr = null;
		String passwd = "";
		try {
			usr = usrMapper.selectByPrimaryKey(data.getId());
			Usr usrNew = new Usr();
			// 判断是否为空
			if(usr!=null){  
				usrNew.setGuid(usr.getGuid());
				usrNew.setGzguid(data.getUuidKey());
				if(usr.getGzguid()==null){
					//gzguid为空更新数据
					updateUser(usrNew);
				}
				passwd = usr.getPasswd();
			}else{
				//为空  新增
				addAllUser(data);
				passwd = data.getPasswd();
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return passwd;
	}

	@Override
	public Usr findById(String id) throws CommonException {
		Usr usr;
		try {
			usr = usrMapper.selectByUsr(id);
		}catch (Exception e){
			throw  new CommonException("COM001","Service层出现异常",e);
		}
		return usr;
	}

	/**
	 * 修改某用户不为空的数据
	 * @return
	 * @throws CommonException
	 */
	public void updateUser(Usr usr) throws CommonException {
		try {
			//BeanUtils.copyProperties(data,usr);
			usrMapper.updateByPrimaryKeySelective(usr);
		} catch (Exception a) {
			throw new CommonException("COM001","在修改方法中出现异常",a);
		}
	}
	
	/**
	 * 无此用户，新增用户数据
	 * @return
	 * @throws CommonException
	 */
	 @SuppressWarnings("all")  // 抵制所有类型的警告
	public String addAllUser(SelUserRequest data) throws CommonException {
		 Usr usr = new Usr();
		try {
			// 吧data赋值到usr  String类型转换成Date

			usr.setCrtdat(DateUtils.parseDate(data.getCrtdat()));
			usr.setStrdat(DateUtils.parseDate(data.getStrdat()));
			usr.setDat1(DateUtils.parseDate(data.getDat1()));

			usr.setDat2(DateUtils.parseDate(data.getDat2()));
			usr.setUpddat(DateUtils.parseDate(data.getUpddat()));
			usr.setCurrenttime(DateUtils.parseDate(data.getCurrenttime()));
			
			BeanUtils.copyProperties(data,usr);
			usr.setGzguid(data.getUuidKey());
			usrMapper.insertSelective(usr);
			
			String passwd =data.getPasswd();
			return passwd;
		} catch (Exception a) {
			throw new CommonException("COM001","在新增方法中出现异常",a);
		}
	}
}
