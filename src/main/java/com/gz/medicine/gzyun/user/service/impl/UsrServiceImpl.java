package com.gz.medicine.gzyun.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.BeanUtil;
import com.gz.medicine.common.util.HttpRequest;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.RegexUtils;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.user.mapper.UsrMapper;
import com.gz.medicine.gzyun.user.request.RegUserRequest;
import com.gz.medicine.gzyun.user.request.UpDatePwdRequest;
import com.gz.medicine.gzyun.user.request.UpDateRequest;
import com.gz.medicine.gzyun.user.request.UserRegRequest;
import com.gz.medicine.gzyun.user.request.UsrRequest;
import com.gz.medicine.gzyun.user.service.UsrService;

@Service
public class UsrServiceImpl implements UsrService {

	@Autowired
	private UsrMapper usrMapper;

	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

	public String retrieveUserPWD(UsrRequest usrRequest) throws CommonException {
		String pwd = null;
		String res = null;
		Map<String, String> param = new HashMap<String, String>();
		Usr usr = usrMapper.selectByPrimaryKey(usrRequest.getGuid());
		if (usr != null) {
			param = BeanUtil.transBean2Map(usr);
			param.put("mbid", usrRequest.getMbid());
		}else {
			throw new CommonException("GZ10001", "该用户不存在!");
		}
		// 读取配置文件中的用户中心url
		String url = PropertyUtil.getPropery("USER_CENTER_URL") + "/user/getUser";
		try {
			// 请求用户中心获取用户密码
			res = HttpRequest.sendPost(url, param);
		} catch (Exception e) {
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		if (StringUtils.isNotBlank(res)) {
			JSONObject jsonObj = JSON.parseObject(res);
			String code = jsonObj.get("code").toString();
			if ("000".equals(code)) {
				try {
					String data = jsonObj.get("data").toString();
					JSONObject jsonData = JSON.parseObject(data);
					pwd = jsonData.get("pwd").toString();
					String gzGuid = jsonData.get("gzguid").toString();
					if(usr!=null&&usr.getGzguid()==null){
						Usr record = new Usr();
						record.setGuid(usr.getGuid());
						record.setGzguid(gzGuid);
						usrMapper.updateByPrimaryKeySelective(record);
					}
				} catch (Exception e) {
					throw new CommonException("GZ10001", "获取数据失败!",e);
				}
			} else {
				String message = jsonObj.get("message").toString();
				throw new CommonException("GZ10001", message);
			}
		} else {
			throw new CommonException("GZ10001", "request user center exception.reponse is null");
		}
		return pwd;
	}

	public String retrieveUserGzguid(RegUserRequest regUserRequest) throws CommonException {
		String guid = null;
		String res = null;
		Map<String, String> param = new HashMap<String, String>();
		if (regUserRequest != null) {
			param = BeanUtil.transBean2Map(regUserRequest);
		}
		String url = PropertyUtil.getPropery("USER_CENTER_URL") + "/user/register";
		try {
			// 请求用户中心获取用户uuid
			res = HttpRequest.sendPost(url, param);
		} catch (Exception e) {
			throw new CommonException("GZ10001", "request user center exception.", e);
		}
		if (StringUtils.isNotBlank(res)) {
			JSONObject jsonObj = JSON.parseObject(res);
			String code = jsonObj.get("code").toString();
			if ("000".equals(code)) {
				String data = jsonObj.get("data").toString();
				JSONObject jsonData = JSON.parseObject(data);
				guid = jsonData.get("guid").toString();
			} else {
				String message = jsonObj.get("message").toString();
				throw new CommonException("GZ10001", message);
			}
		} else {
			throw new CommonException("GZ10001", "request user center exception.reponse is null");
		}
		return guid;
	}

	/**
	 * @author fendo
	 * @Describe 用户注册
	 * @param userRegRequest
	 * @return
	 * @throws CommonException
	 */
	public String userRegister(UserRegRequest userRegRequest) throws CommonException {
		
	  if (RegexUtils.isMobile(userRegRequest.getPhone())) {
			Usr usr = usrMapper.selectByMobile(userRegRequest.getPhone());
			//根据手机号判断当前数据库中是否存在该用户
			if (usr == null) {
				RegUserRequest regUserRequest = new RegUserRequest();
				regUserRequest.setId(userRegRequest.getPhone());
				//获取gzguid
				String gzguid = retrieveUserGzguid(regUserRequest);
				Usr usrNew = new Usr();
				usrNew.setGuid(UUIDTool.getUUID());
				usrNew.setOrg("CHIS");
				usrNew.setId(userRegRequest.getPhone());
				String begin = userRegRequest.getPhone().substring(0,3);
				String end = userRegRequest.getPhone().substring(7,userRegRequest.getPhone().length());
				usrNew.setName(begin + "****" +end);
				usrNew.setPasswd(userRegRequest.getPassword());
				usrNew.setUseflg("1");
				usrNew.setSytext("1");
				usrNew.setGzguid(gzguid);

				try {
					usrMapper.insert(usrNew);
					return "OK";
				} catch (Exception e) {
					throw new CommonException("GZ10001", "用户保存出错。。。");
				}
			} else {
				throw new CommonException("GZ10001", "该手机号已被注册，请更换或通过微信与系统管理员联系....");
			}
		} else {
			throw new CommonException("GZ10001", "请输入正确的手机号!!!");
		}
	}

	/**
	 * 
	 * @author fendo
	 * @Describe 根据手机号发送短信验证码
	 * @param mobile
	 * @return
	 * @throws CommonException
	 */
	public String sendAuthCode(String mobile) throws CommonException {

		Usr usr = usrMapper.selectByMobile(mobile);
		if (usr == null) {

			// 短信验证返回内容
			String restResource = null;

			// 请求URL
			String url = "http://sms.51sxun.com/sms.aspx";

			// 实例化一个请求参数Map
			Map<String, String> params = new HashMap<String, String>();

			// 实例化一个随机的验证码
			long authCode = Math.round(Math.floor((Math.random() * 9 + 1) * 100000)); // 验证码

			// 请求内容
			String content = "短信验证码为：" + authCode + "，请勿将验证码提供给他人。";

			// 验证手机
			if (!RegexUtils.isMobile(mobile)) {
				throw new CommonException("GZ10001", "请输入正确的手机号!!");
			} else {
				params.put("extno", "");
				params.put("sendTime", "");
				params.put("content", content);
				params.put("mobile", mobile);
				params.put("account", "gzjk");
				params.put("password", "gzjk0805");
				params.put("userid", "318");
				params.put("action", "send");

				restResource = HttpRequest.sendPost(url, params);
				SAXReader reader = new SAXReader();
				try {
					Document document = DocumentHelper.parseText(restResource);
					Element root = document.getRootElement();
					String returnstatus = root.element("returnstatus").getText();
					if ("Success".equals(returnstatus)) {
						return "" + authCode;
					} else {
						return "";
					}
				} catch (DocumentException e) {
					throw new CommonException("GZ10001", "XML解析错误!!");
				}
			}
		} else {
			throw new CommonException("GZ10001", "该手机号已被注册，请更换或通过微信与系统管理员联系....");
		}
	}


	
	/**
	 * 根据guid查询密码
	 * 舵主
	 */
	@Override
	public String selGuidPwd(String guid) throws CommonException {
		String uu = null;
		uu= usrMapper.selGuidPwd(guid);
		return uu;
	}

	/**
	 * 根据id查询密码
	 * 舵主
	 */
	@Override
	public String selIdPwd(String mobile) throws CommonException {
		String uu = null;
		uu= usrMapper.selIdPwd(mobile);
		return uu;
	}
	
	

	/**
	 * 根据guid修改密码
	 * 舵主
	 * @return 
	 */
	@Override
	public void upGuidPwd(UpDatePwdRequest data) throws CommonException {
		Usr record = new Usr();
		BeanUtils.copyProperties(data, record);
		usrMapper.upGuidPwd(record);
	}
	

	/**
	 * 根据id修改密码
	 * 舵主
	 */
	@Override
	public void upIdPwd(UpDateRequest data) throws CommonException {
		Usr record = new Usr();
		BeanUtils.copyProperties(data, record);
		usrMapper.upIdPwd(record);
	}
	
	
	/**
	 * 根据guid修改密码
	 * 舵主
	 */
	@Override
	public String updateGuidAll(UpDatePwdRequest data) throws CommonException {
		String passwd = null;
		try {
			String guid = data.getGuid();
			// 根据guid查询用户密码
			passwd =usrMapper.selGuidPwd(guid);
			// 判断密码是否为空
			if(StringUtils.isNotBlank(passwd)){
				// 判断传的密码是否与查出来的密码是否一致
				if(passwd==data.getOldpwd()){
					upGuidPwd(data);
					return "修改成功";
				}else{
					return "旧密码错误";
				}
			}else{
				throw new CommonException("该用户guid在数据库中不存在！");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在guid修改密码方法中出错",e);
		}
	}
	
	
	/**
	 * 根据手机号（ID）修改密码（忘记密码）
	 * 舵主
	 */
	@Override
	public String updateIdPwd(UpDateRequest data) throws CommonException {
		String passwd = null;
		try {
			String mobile = data.getMobile();
			// 根据guid查询用户密码
			passwd =usrMapper.selIdPwd(mobile);
			// 判断密码是否为空
			if(StringUtils.isNotBlank(passwd)){
				// 判断传的密码是否与查出来的密码是否一致
				if(passwd==data.getPwd()){
					return "密码存在，没有修改";
				}else{
					upIdPwd(data);
					return "修改成功";
				}
			}else{
				throw new CommonException("电话号码不存在");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在根据手机号修改密码方法中出错",e);
		}
	}
	
	
	/**
	 * 根据手机号（ID）修改密码（忘记密码）
	 * 舵主
	 */
	@Override
	public String updateIdPwdPC(UpDateRequest data) throws CommonException {
		String passwd = null;
		try {
			
			String mobile = data.getMobile();
			// 根据guid查询用户密码
			passwd =usrMapper.selIdPwd(mobile);
			// 判断密码是否为空
			if(StringUtils.isNotBlank(passwd)){
				// 判断传的密码是否与查出来的密码是否一致
				if(passwd==data.getPwd()){
					return "旧密码与新密码不能相同";
				}else{
					upIdPwd(data);
					return "修改成功";
				}
			}else{
				throw new CommonException("电话号码不存在");
			}
		} catch (Exception e) {
			throw new CommonException("COM001","在根据手机号修改PC端密码方法中出错",e);
		}
	}
	


	@Override
	public String sendAuthContent(String mobile, String content) throws CommonException {

		// 短信验证返回内容
		String restResource = null;

		if (org.apache.commons.lang3.StringUtils.isNotEmpty(mobile) && org.apache.commons.lang3.StringUtils.isNotEmpty(content)) {

			if (RegexUtils.isMobile(mobile)) {

				// 请求URL
				String url = "http://sms.51sxun.com/sms.aspx";
				// 实例化一个请求参数Map
				Map<String, String> params = new HashMap<String, String>();
				params.put("extno", "");
				params.put("sendTime", "");
				params.put("content", content);
				params.put("mobile", mobile);
				params.put("account", "gzjk");
				params.put("password", "gzjk0805");
				params.put("userid", "318");
				params.put("action", "send");
				restResource = HttpRequest.sendPost(url, params);
				SAXReader reader = new SAXReader();
				try {
					Document document = DocumentHelper.parseText(restResource);
					Element root = document.getRootElement();
					String returnstatus = root.element("returnstatus").getText();
					if ("Success".equals(returnstatus)) {
						return "OK";
					} else {
						return "";
					}
				} catch (DocumentException e) {
					throw new CommonException("GZ10001", "XML解析错误!!");
				}
			}

		}
		return "";
		
	}

}
