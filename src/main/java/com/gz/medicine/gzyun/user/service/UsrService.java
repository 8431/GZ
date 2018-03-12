package com.gz.medicine.gzyun.user.service;

import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.user.request.RegUserRequest;
import com.gz.medicine.gzyun.user.request.UpDatePwdRequest;
import com.gz.medicine.gzyun.user.request.UpDateRequest;
import com.gz.medicine.gzyun.user.request.UserRegRequest;
import com.gz.medicine.gzyun.user.request.UsrRequest;

@Service("usrService")
public interface UsrService {
	
	public String retrieveUserPWD(UsrRequest usrRequest) throws CommonException;
	
	public String retrieveUserGzguid(RegUserRequest regUserRequest) throws CommonException;
	
	/**
	 * 
	 *@Title userRegister 
	 *@Description: 用户注册
	 *@Author fendo
	 *@Date 2017年8月8日 下午6:26:03
	 *@param userRegRequest
	 *@return String
	 *@throws CommonException
	 */
	String userRegister(UserRegRequest userRegRequest) throws CommonException;
	
	/**
	 * 
	 *@Title sendAuthCode 
	 *@Description: 根据手机号发送验证码
	 *@Author fendo
	 *@Date 2017年8月8日 下午6:25:14
	 *@param mobile
	 *@return String
	 *@throws CommonException
	 */
	String sendAuthCode(String mobile) throws CommonException;

	
	/**
	 * 根据GUID查询用户密码
	 * @param mobile
	 * @return
	 * @throws CommonException
	 */
	String selGuidPwd(String guid) throws CommonException;
	
	/**
	 * 根据ID查询用户密码
	 * @param mobile
	 * @return
	 * @throws CommonException
	 */
	String selIdPwd(String mobile) throws CommonException;
	
	
	/**
	 * 根据GUID修改用户密码
	 * @param mobile
	 * @return
	 * @throws CommonException
	 */
	void upGuidPwd(UpDatePwdRequest data) throws CommonException;
	
	
	/**
	 * 根据ID修改用户密码
	 * @param mobile
	 * @return
	 * @throws CommonException
	 */
	void upIdPwd(UpDateRequest data) throws CommonException;

	/**
	 * 修改密码整合方法(根据GUID)
	 * @author 舵主
	 *
	 * 下午3:14:16
	 */
	String updateGuidAll(UpDatePwdRequest data) throws CommonException;

	/**
	 * 忘记密码整合方法（）
	 * @author 舵主
	 *
	 * 下午3:14:43
	 */
	String updateIdPwd(UpDateRequest data) throws CommonException;

	String updateIdPwdPC(UpDateRequest data) throws CommonException;



	

	/**
	 * 
	 *@Title sendAuthContent 
	 *@Description: 根据手机号发送指定内容
	 *@Author fendo
	 *@Date 2017年8月8日 下午6:25:06
	 *@param mobile
	 *@param content
	 *@return String
	 *@throws CommonException
	 */
	String sendAuthContent(String mobile,String content)throws CommonException;

}
