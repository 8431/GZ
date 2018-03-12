package com.gz.medicine.yun.doctor.service.impl;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.gz.medicine.common.util.*;
import com.gz.medicine.yun.doctor.bean.*;
import com.gz.medicine.yun.doctor.mapper.*;
import com.gz.medicine.yun.doctor.reponse.DTfollowupPlanResponse;

import com.gz.medicine.yun.doctor.reponse.DTsickblhdrResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.yun.doctor.request.DTfollowupRecordRequest;
import com.gz.medicine.yun.doctor.request.DTmessageRequest;
import com.gz.medicine.yun.doctor.service.DTDocSfConRoomService;

/**
 * @author 舵主
 *
 * 下午2:01:44
 */
@Service
public class DTDocSfConRoomServiceImp implements  DTDocSfConRoomService{

	public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryServiceImpl.class);
	
	// 随访任务计划接口
	@Autowired
	private DTfollowupRecordMapper dTfollowupRecordMapper; 
	
	// 随访计划接口
	@Autowired
	private DTfollowupPlanMapper dTfollowupPlanMapper; 
	
	// 短信详情接口
	@Autowired
	private  DTmessageTemplateMapper dTmessageTemplateMapper;

	@Autowired
	private DTusrMapper dTusrMapper;

	@Autowired
	private DTlocMapper dTlocMapper;


	@Autowired
	private DTdocMapper dTdocMapper;

	@Autowired
	private DTsickblhdrMapper dTsickblhdrMapper;

	/**
	 * 随访任务列表（搜索、分页）serviceImp层
	 * @author 舵主
	 *
	 * 下午2:12:45
	 */
	@Override
	public Page follUpTasks(PageModel page) throws CommonException {
		Page p=page.getPage();
	    String docguid= (String) p.get("docguid");
		try {
			List<DTfollowupPlanResponse> list  = dTfollowupPlanMapper.queryPageFollUpTasks(p);
			p.setParameterType(list);
			int num=dTfollowupPlanMapper.queryFollUpTasksNum(docguid);
			p.put("totalnum",num);
		} catch (Exception e) {
			LOGGER.error("随访任务列表（搜索、分页）："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);		
		}
		return p;
	}




	/**
	 * 随访任务选择模板查询内容接口）serviceImp层
	 * @author 舵主
	 *
	 * 下午2:12:45
	 */
	@Override
	public SimpleResult sfSMSdetails(String  guid) throws CommonException {
		SimpleResult simpleResult=null;
		String templatecontent = null;
		try {
			templatecontent = dTfollowupRecordMapper.sfSMSdetails(guid);
		} catch (Exception e) {
			LOGGER.error("新随访任务选择模板查询内容接口："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		simpleResult=SimpleResult.success();
		simpleResult.putData("templatecontent", templatecontent);
        return simpleResult;
	}



	/**
	 * 随访任务发送短信 serviceImp层
	 * @author 舵主
	 */
	@Override
	public SimpleResult addSMSreTasks(DTmessageRequest record) throws CommonException {
		SimpleResult simpleResult=null;
		DTmessageRecord dTmessageRecord = new  DTmessageRecord();
		try {
			BeanUtils.copyProperties(record, dTmessageRecord);
			// 根据用户guid获取手机号和姓名
			DTusr usr = new DTusr();
			usr= dTusrMapper.selGuid(dTmessageRecord.getUsrguid());
			
			// 推送信息给指定人
			MobileCode code  = new MobileCode();
			code.sendAuthCode(usr.getId(), dTmessageRecord.getMessagesendcontent());
			
			// 获取系统当前时间
			Date date = new Date();
			dTmessageRecord.setMessagesenddate(date);
			dTfollowupRecordMapper.addSMSreTasks(dTmessageRecord);
		} catch (Exception e) {
			LOGGER.error("随访任务发送短信："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		simpleResult=SimpleResult.success();
		return simpleResult;
	}
	


	/**
	 *
	 *@Title getMedicalRecordsList
	 *@Description: 随访信息就诊记录列表 ---- 根据患者ID,医生ID,获取就诊记录列表(病厉表)
	 *@Author fendo
	 *@Date 2017年8月24日 上午10:52
	 *@param page
	 *@return SimpleResult
	 */
	@Override
	public Page getMedicalRecordsList(PageModel page) throws CommonException {
		page.getPage().put("sickguid",page.getPage().get("usrguid"));
		Page p=page.getPage();
		List<Map<String,String>> mapList=new ArrayList<Map<String, String>>();
		try {

			List<DTsickblhdrResponse> lists=dTsickblhdrMapper.queryPageGuidByCrtdatDesc(p);
			if(lists.size()>0) {

 			for (int i = 0; i <lists.size() ; i++) {
					Map<String,String> stringMap=new HashMap<String, String>();
					//stringMap.put("guid",""+lists.get(i).getGuid());
					stringMap.put("docguid",""+lists.get(i).getDocguid()); //医生ID
					stringMap.put("sicguid",""+lists.get(i).getGuid());//病例guid
					stringMap.put("usrguid",""+lists.get(i).getSickguid());//用户ID
					stringMap.put("crtusr",""+lists.get(i).getDoc());//医生名
					//stringMap.put("crtdat",DateUtils.formatDate(lists.get(i).getCrtdat(),"yyyy-MM-dd HH:mm:ss")); //创建时间
					stringMap.put("crtdat",lists.get(i).getCrtdat());
					mapList.add(stringMap);
				}
				p.setParameterType(mapList);

//			List<DTfollowupRecord> lists=dTfollowupRecordMapper.queryPageUserGuid(p);
//			if(lists.size()>0){
//				for (int i = 0; i <lists.size() ; i++) {
//					Map<String,String> stringMap=new HashMap<String, String>();
//					stringMap.put("guid",""+lists.get(i).getGuid());
//					stringMap.put("docguid",""+lists.get(i).getDocguid()); //医生ID
//					stringMap.put("sicguid",""+lists.get(i).getSicguid());//病例guid
//					stringMap.put("usrguid",""+lists.get(i).getUsrguid());//用户ID
//					stringMap.put("crtusr",""+lists.get(i).getCrtusr());//医生名
//					stringMap.put("crtdat",DateUtils.formatDate(lists.get(i).getCrtdat(),"yyyy-MM-dd HH:mm:ss")); //创建时间
//					mapList.add(stringMap);
//				}
//				p.setParameterType(mapList);
 			}else{
				p.setParameterType(mapList);
			}
		}catch(Exception e){
			LOGGER.error("随访信息就诊记录列表："+e.getMessage(),e);
			throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		return p;
	}

	/**
	 *
	 *@Title saveFollowUp
	 *@Description: 随访信息保存
	 *@Author fendo
	 *@Date 2017年8月24日 上午10:52
	 *@param data
	 *@return int
	 */
	@Override
	public void saveFollowUp(DTfollowupRecordRequest data) throws CommonException {
		try {
			data.setOrg("CHIS");
			data.setGuid(UUIDTool.getUUID());
			data.setCrtdat(new Date());
			//设置创建人为医生ID
			data.setCrtusr(data.getUsrguid());
			data.setFollowdatetime(new Date());
			//系统编号? 创建人姓名
			dTfollowupRecordMapper.insertFollowUp(data);

			//保存随访记录,之后更改随访计划状态
			DTfollowupPlan dTfollowupPlan=new DTfollowupPlan();
			dTfollowupPlan.setGuid(data.getPlanguid());
			dTfollowupPlan.setFollowstate("1");
			dTfollowupPlanMapper.updateByfollowState(dTfollowupPlan);
		}catch (Exception e){
			LOGGER.error("随访信息保存 ："+e.getMessage(),e);
			throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
	}


	
	
	/**
	 * 根据医生usrguid随访任务加载短信详情 serviceImp层
	 * @author 舵主
	 */
	@Override
	public List<DTmessageTemplate> loadDetails(String docguid) throws CommonException {
		List<DTmessageTemplate> list = new ArrayList<DTmessageTemplate>();
		try {
			list =dTmessageTemplateMapper.loadDetails(docguid);
		
			
			
		} catch (Exception e) {
			LOGGER.error("随访任务发送短信："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		
		return list;
	}


	@Override
	public List<DTfollowupRecord> follUpTasks(String docguid) throws CommonException {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 1.首先获取机构选择的设备
	 * 2.然后用病人账号直接去获取数据
	 */
	@Override
	public SimpleResult getData(String deptIdNum, String guid) throws CommonException {

		/**
		 *  八大件和查体台每测量一项会上传一次数据（所有的，除了测量项有值外其它项都为 0 ）,我们需要最后一次测量的数据
		 *  LogBloodGlucose 血糖
		 *  LogBp 血压
		 *  LogEcg 心电
		 *  LogTemperature 体温
		 *  LogOxygenLevel 血氧
		 */
		SimpleResult simpleResult = null;
		String deptid = equipmentNo(deptIdNum); //根据部门编号获取部门ID
		int systolic = 0;//血压上
		int diastolic = 0;//血压下
		int heartRate = 0;//心电
		int oxygen = 0;//血氧
		int weight =0;//体重
		Double glucose = 0.0d;//血糖 -可为小数
		Double tempera = 0.0d ;//体温 -可为小数
		int pulse = 0;//心率
		String CardNo="0";
		Map msp = new HashMap();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		/**
		 * A001 超思-八大件
		 * A002 超思-查体台
		 * A004 易龙-血压计
		 * A005 超思-大型机
		 * A006 超思-新设备
		 */
		if("A001".equals(deptid )||"A006".equals(deptid)){

			//能用的身份证号:31022619860226071X

			//从八大件上获取数据
			String result = GetCloudValue4(deptid,guid);
			JSONObject obj = new JSONObject().fromObject(result);//将json字符串转换为json对象
			Object oss =  obj.get("Data");
			if(!"".equals(oss)){
				JSONArray jsonArray = JSONArray.fromObject(obj.get("Data"));
				try {
					msp = toConversions(jsonArray,"A001");
					tempera = Double.parseDouble(msp.get("tempera").toString());
					heartRate = Integer.parseInt(msp.get("heartRate").toString());
					systolic = Integer.parseInt(msp.get("systolic").toString());
					diastolic = Integer.parseInt(msp.get("diastolic").toString());
					weight = Integer.parseInt(msp.get("weight").toString());
					glucose = Double.parseDouble(msp.get("glucose").toString());
					oxygen = Integer.parseInt(msp.get("oxygen").toString());
				}catch (Exception e){
					throw new CommonException("COM001","JSON转换异常",e);
				}
			}


		}else if("A002".equals(deptid)){
			//从查体台上获取数据
			String result = GetCloudValue3(CardNo);

			JSONObject obj = new JSONObject().fromObject(result);//将json字符串转换为json对象
			Object oss =  obj.get("Data");
			if(!"".equals(oss)){
				JSONArray jsonArray = JSONArray.fromObject(obj.get("Data"));
				try {
					msp = toConversions(jsonArray,"A002");
					tempera = Double.parseDouble(msp.get("tempera").toString());
					heartRate = Integer.parseInt(msp.get("heartRate").toString());
					systolic = Integer.parseInt(msp.get("systolic").toString());
					diastolic = Integer.parseInt(msp.get("diastolic").toString());
					weight = Integer.parseInt(msp.get("weight").toString());
					glucose = Double.parseDouble(msp.get("glucose").toString());
					oxygen = Integer.parseInt(msp.get("oxygen").toString());
				}catch (Exception e){
					throw new CommonException("COM001","JSON转换异常",e);
				}
			}

		}else if("A003".equals(deptid)){
			//获取动态多参数遥测监护系统

		}else if("A004".equals(deptid)){
			//获取翼龙血压计数据,先查询手机号的数据，若没有就去查布点机构的数据
			String result = getCloudValueOneThere(guid);

			JSONObject obj = new JSONObject().fromObject(result);//将json字符串转换为json对象

			//此时是通过电话号码去取数据，未获取到，接下来使用机构代码为账号去取
			if("RET_USER_NOT_FOUNT".equals(obj.getString("errmsg"))|| "".equals(obj.getString("bpinfo"))){
			    String info = getCloudValueOneTwo(deptIdNum);
				JSONObject jsonObject = new JSONObject().fromObject(result);//将json字符串转换为json对象

				//此时是通过布点机构号码去取数据，未获取到
				if("RET_USER_NOT_FOUNT".equals(jsonObject.getString("errmsg"))){
					LOGGER.error("病人手机账号或所在看病地机构号，还未在检查设备上注册！");
				}else {
					if(!"".equals(jsonObject.getString("bpinfo"))){
//						systolic = info.bpinfo.h;//血压上
//						diastolic = info.bpinfo.l;//血压下
//						heartRate = info.bpinfo.r;//心率
//						tempera = info.bpinfo.t;//体温
					}
				}
			}else{
				if(!"".equals(obj.getString("bpinfo"))){
//					systolic = info.bpinfo.h;//血压上
//					diastolic = info.bpinfo.l;//血压下
//					heartRate = info.bpinfo.r;//心率
//					tempera = info.bpinfo.t;//体温
				}
			}

		}else if("A005".equals(deptid)){
			//获取超思大型设备数据
			Map maps = getdaCloudValue(guid);
			if(!maps.isEmpty()){
				tempera = Double.parseDouble(maps.get("Temperature").toString());//体温
				heartRate = (int)Math.floor(Integer.parseInt(maps.get("Hr").toString()));//心率
				Double dbs = Double.parseDouble(maps.get("Weight").toString());
				weight = (int)Math.floor(dbs);//体重
				glucose = Double.parseDouble(maps.get("BloodSugar").toString());//血糖
				oxygen = (int)Math.floor(Integer.parseInt(maps.get("Oxygen").toString()));//血氧
				systolic = (int)Math.floor(Integer.parseInt(maps.get("HighPressure").toString()));//血压上
				diastolic = (int)Math.floor(Integer.parseInt(maps.get("LowPressure").toString()));//血压下
			}
		}


		simpleResult=SimpleResult.success();
		simpleResult.putData("tempera",Math.round(tempera*10)/10); //体温
		//八大件取 pulse ，查体台取 heartRate
		simpleResult.putData("heartRate",heartRate);//心率
		simpleResult.putData("systolic",systolic);//血压上
		simpleResult.putData("diastolic",diastolic);//血压下
		simpleResult.putData("weight",Math.round(weight*100)/100);//体重
		simpleResult.putData("glucose",Math.round(glucose*100)/100);//血糖
		simpleResult.putData("oxygen",oxygen);//血氧
		return simpleResult;
	}


	/**
	 * 数据转换
	 * @return
	 */
	public Map toConversions(JSONArray jsonArray,String deptid) throws Exception {
		int systolic = 0;//血压上
		int diastolic = 0;//血压下
		int heartRate = 0;//心电
		int oxygen = 0;//血氧
		int weight =0;//体重
		Double glucose = 0.1d;//血糖 -可为小数
		Double tempera = 0.0d ;//体温 -可为小数
		int pulse = 0;//心率
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map maps = new HashMap();
		List<JSONObject> StringList = new ArrayList<JSONObject>();
		if(jsonArray.size()>0){
			DataSort jsonTest = new DataSort();
			for (int i = 0; i < jsonArray.size(); i++){
				JSONObject jsonObject = JSONObject.fromObject(jsonArray.get(i));
				StringList.add(jsonObject);
				System.out.println("InspectDate :" + jsonObject.get("InspectDate").toString());
				Collections.sort(StringList,jsonTest);
			}

		}

		System.err.println("最新时间:"+StringList.get(0));

		JSONObject jsonObject = StringList.get(0);

		//血糖
		JSONObject LogBloodGlucose = JSONObject.fromObject(jsonObject.get("LogBloodGlucose"));
		System.out.println("LogBloodGlucose:"+ LogBloodGlucose.toString());
		glucose = Double.parseDouble(LogBloodGlucose.get("Glucose").toString());//血糖
		maps.put("glucose",glucose);

		//血压
		JSONObject LogBp = JSONObject.fromObject(jsonObject.get("LogBp"));
		System.out.println("LogBp:"+LogBp.toString());
		systolic = Integer.parseInt(LogBp.get("Systolic").toString());//血压上
		maps.put("systolic",systolic);
		diastolic = Integer.parseInt(LogBp.get("Diastolic").toString());//血压下
		maps.put("diastolic",diastolic);
		if("A001".equals(deptid)||"A006".equals(deptid)){
			heartRate = Integer.parseInt(LogBp.get("Pulse").toString());//心率
			maps.put("heartRate",heartRate);
		}


		//心电
		JSONObject LogEcg = JSONObject.fromObject(jsonObject.get("LogEcg"));
		System.out.println("LogEcg:"+LogEcg.toString());
		if("A002".equals(deptid)){
			heartRate = Integer.parseInt(LogBp.get("HeartRate").toString());//心率
			maps.put("heartRate",heartRate);
		}

		//血氧
		JSONObject LogOxygenLevel = JSONObject.fromObject(jsonObject.get("LogOxygenLevel"));
		System.out.println("LogOxygenLevel:"+LogOxygenLevel.toString());
		oxygen = Integer.parseInt(LogOxygenLevel.get("Oxygen").toString());
		maps.put("oxygen",oxygen);

		//体重
		JSONObject LogWeight=JSONObject.fromObject(jsonObject.get("LogWeight"));
		System.out.println("LogWeight:"+LogWeight.toString());
		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
		String ss = decimalFormat.format(LogWeight.get("Weight"));
		weight = Integer.parseInt(ss);
		maps.put("weight",weight);
		//体温
		JSONObject LogTemperature=JSONObject.fromObject(jsonObject.get("LogTemperature"));
		System.out.println("LogTemperature:"+LogTemperature.toString());
		tempera = Double.parseDouble(LogTemperature.get("Tempera").toString());
		maps.put("tempera",tempera);
		return maps;
	}

	/**
	 * 获取部门ID，根据布点编号获取该布点所选择的检验设备
	 * @param deptIdNum
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String equipmentNo(String deptIdNum) throws CommonException {
		String result=null;
		try {
			DTloc dTloc=dTlocMapper.selectByIdAndChis(deptIdNum);
			if(dTloc != null){
				result= dTloc.getDeptid();
			}
		}catch (Exception e){
			LOGGER.error("获取部门："+e.getMessage(),e);
			throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		return result;
	}

	@Override
	public String GetCloudValue4(String deptid, String brguid) throws CommonException {
		String idcard=null;
		String dat1=null;
		String url=null;
		String Result=null;
		try {
			//根据用户ID获取机构身份证
			Map<String,String> map=dTusrMapper.selectByGuidAndChis(brguid);
			if(map.size()>0){
				idcard = map.get("IDCARD");
				//dat1=map.get("DAT1");
			}else {
				idcard="0";  //如果没有获取到身份证，因为是必须的所以给0
			}

			//idcard="31022619860226071X";
			if("A001".equals(deptid)){
				//url = "http://115.29.164.236:8073/Data/Download?AppKey=717BF4F4BC2C4D7982CDD7E19B658AF3&AppSecret=D9B98A9E3F5A4F9CACB359CD41CA3536&CardNo="+idcard+"&StartDateTime="+dat1;
				url = "http://115.29.164.236:8073/Data/Download?AppKey=717BF4F4BC2C4D7982CDD7E19B658AF3&AppSecret=D9B98A9E3F5A4F9CACB359CD41CA3536&CardNo="+idcard;

			}

			if("A006".equals(deptid)){
				url = "http://ytj.huadaifu.cn:8073/Data/Download?AppKey=717BF4F4BC2C4D7982CDD7E19B658AF3&AppSecret=D9B98A9E3F5A4F9CACB359CD41CA3536&CardNo="+idcard+"&StartDateTime="+dat1;
			}

			Result= HttpRequest.sendGet(url);

		}catch (Exception e){
			LOGGER.error("八大件数据接口出错："+e.getMessage(),e);
			throw new CommonException("COM001","在执行SQL时出现异常",e);
		}
		return Result;
	}

	@Override
	public String GetCloudValue3(String CardNo) throws CommonException {
		//查体台测试接口  CardNo 为十位数字关联号
		String Result = null;
		try {
			String  url = "http://cttapi.huadaifu.cn/Data/Download?AppKey=6D4366265BC1436CB9ABA7498AD0500E&AppSecret=BF5DBDCD6EC04EA88AFD44E2C228FB84&CardNo="+CardNo;
			Result = HttpRequest.sendGet(url);
		}catch (Exception e){
			LOGGER.error("网络请求数据错误："+e.getMessage(),e);
			throw new CommonException("COM001","网络请求数据错误",e);
		}

		return Result;
	}

	/**
	 * 佚龙心律血压，以电话号码作为账号，无需密码
	 * @param brguid
	 * @return
	 * @throws CommonException
	 */
	@Override
	public String getCloudValueOneThere(String brguid) throws CommonException {

		String mobile=null;
		// 生成一个GUID数字
		String myguid = "8260822C-B516-4294-8823-2247C143CADC";

		// GUID+"#$%^&YHYJKQAJKZ" 来生成一个MD5编码，要全部小写
		String md5code = myguid+"#$%^&YHYJKQAJKZ";
		md5code = md5code.toLowerCase();
		Map<String, String> param = new HashMap<String, String>();
		String res = null;
		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 计算md5函数
			mdInst.update(md5code.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String ckse = new BigInteger(1, mdInst.digest()).toString(16);

			Map<String,String> stringMap=dTusrMapper.selectByGuidAndChis(brguid);
			if(stringMap.size()>0){
				mobile = stringMap.get("id");
			}

			param.put("mobile",mobile);
			param.put("type","1");
			param.put("reportid","myguid");
			param.put("checksum",ckse);

			String url="http://api.iyijiankang.com/task/getnewbpdatamobile";

			res = HttpRequest.sendPost(url, param);
			if (StringUtils.isNotBlank(res)) {
				com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSON.parseObject(res);
				String code = jsonObj.get("code").toString();
				if (!"200".equals(code)) {
					String message = jsonObj.get("message").toString();
					throw new CommonException("GZ10001", message);
				}

				return res;

			} else {
				throw new CommonException("GZ10001", "HTTP 请求失败");
			}

		} catch (Exception e) {
			LOGGER.error("MD5加密出现错误");
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public String getCloudValueOneTwo(String deptIdNum) throws CommonException {

		String res = null;

		// 生成一个GUID数字
		String myguid = "3CFCBF78-92BF-1279-D76E-E3F89759DA62";

		// GUID+"#$%^&YHYJKQAJKZ" 来生成一个MD5编码，要全部小写
		String md5code= myguid+"#$%^&YHYJKQAJKZ";
		md5code=md5code.toLowerCase();
		Map<String, String> param = new HashMap<String, String>();

		//其他的用户密码如  yjktest01/111111
		param.put("username",deptIdNum);
		param.put("password","123456");
		param.put("type","1");
		param.put("reportid",myguid);
		param.put("checksum",md5code);

		String url="http://api.iyijiankang.com/task/getnewbpdata";
		res = HttpRequest.sendPost(url, param);
		if (StringUtils.isNotBlank(res)) {
			com.alibaba.fastjson.JSONObject jsonObj = com.alibaba.fastjson.JSON.parseObject(res);
			String code = jsonObj.get("code").toString();
			if (!"200".equals(code)) {
				String message = jsonObj.get("message").toString();
				throw new CommonException("GZ10001", message);
			}

			return res;

		} else {
			throw new CommonException("GZ10001", "HTTP 请求失败");
		}
	}

	@Override
	public Map getdaCloudValue(String guid) throws CommonException {
		Map result = new HashMap();
		try {
			 result = dTlocMapper.selectByBloodpressureId(guid);
		}catch (Exception e){
			throw new CommonException("GZ10001", "Service失败");
		}
		return result;
	}


}
