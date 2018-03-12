package com.gz.medicine.yun.doctor.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.mapper.DTusrMapper;
import com.gz.medicine.yun.doctor.request.DTusrRequest;
import com.gz.medicine.yun.doctor.service.DTUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTUsrServiceImpl
 * @PackageName com.gz.medicine.yun.doctor.service.impl
 * @Description 用户实现类
 * @Data 2017-08-19 12:02
 **/
@Service
public class DTUsrServiceImpl implements DTUsrService{


    @Autowired
    private DTusrMapper usrMapper;



	@Override
	public String update(DTusrRequest data) throws CommonException {
		String oldpa = data.getOldPass();//前端传来的旧密码
		String newpa = data.getNewPass();//前端传来的新密码
		String password = usrMapper.select(data);//数据库查到的密码
		try {
			if(oldpa.equals(password)){
				DTusr usr = new DTusr();
				usr.setGuid(data.getGuid());
				usr.setPasswd(data.getNewPass());
				usrMapper.update(usr);
				return "密码修改成功！";
			}else{
				return "旧密码输入错误！";
				
			}

		} catch (Exception e) {
			throw new CommonException("COM001","在修改密码方法中出错",e);
		}
	}



	@Override
	public DTusr selectByGuid(String guid) throws CommonException {
		DTusr dTusr=null;
		try {
			dTusr=usrMapper.selectByPrimaryKey(guid);
		}catch (Exception e){
			throw new CommonException("COM001","在查询用户时失败",e);
		}
		return dTusr;
	}



	/**
	 * 根据患者guid查询手机号与姓名 
	 * 舵主
	 */
	@Override
	public DTusr selGuid(String usrguid) throws CommonException {
		DTusr usr = new DTusr();
		try {
			usr =usrMapper.selGuid(usrguid);
			if(usr!=null){
				return usr;
			}else{
				throw new CommonException("COM001","没有此用户");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在查询手机号与姓名方法中出错",e);
		}
	}


	@Override
	public Map<String,String> selectByGuidAndChis(String usrguid) throws CommonException {
		Map<String,String> map=null;
		try {
			map = usrMapper.selectByGuidAndChis(usrguid);
		} catch (Exception e) {
			throw new CommonException("COM001","在查询根据用户ID获取机构是CHIS的数据出错",e);
		}
		return map;
	}


}
