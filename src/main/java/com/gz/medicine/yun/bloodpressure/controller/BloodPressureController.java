package com.gz.medicine.yun.bloodpressure.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.bloodpressure.request.BloodPressureRequest;
import com.gz.medicine.yun.bloodpressure.service.BloodPressureService;

@Controller
@RequestMapping("/bloodpressure")
public class BloodPressureController extends ValidateWithException {
    
    /**
	 * 用户血压信息同步
	 */

	public static final Logger LOGGER = Logger.getLogger(BloodPressureController.class);
    
    @Autowired
    private BloodPressureService bloodPressureService;
    @Autowired
    Validator validator; 
    
    /**
     * 接受第三方的血压信息
     * @param date
     * @return
     * @throws IOException 
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST,produces="application/json; charset=utf-8")  
    @ResponseBody
    public SimpleResult save(   BloodPressureRequest date ,HttpServletRequest request ) throws IOException {
    	LOGGER.info("jsonDate:"+date); 
    	LOGGER.info("request.url:"+request.getRequestURI());
    	SimpleResult  sr=new SimpleResult(); 
	    BloodPressureRequest bean = new BloodPressureRequest();
         try {
        	 request.setCharacterEncoding("UTF-8");
         	// 获取request传输过来的字符流
         	BufferedReader bf = request.getReader();
         	StringBuilder sb = new StringBuilder();
         	String line;
         	// 循环读取字符流所有字符
          	while ((line = bf.readLine()) != null) {sb.append(line);}
          	String jsonString = sb.toString();
          	JSONObject jsonObj = JSON.parseObject(jsonString);
        	String MachineId = jsonObj.get("MachineId") ==null?null:jsonObj.get("MachineId").toString();
          	String UnitNo=jsonObj.get("UnitNo")==null?null:jsonObj.get("UnitNo").toString();
          	String UnitName=jsonObj.get("UnitName")==null?null:jsonObj.get("UnitName").toString();
          	String MacAddr=jsonObj.get("MacAddr")==null?null:jsonObj.get("MacAddr").toString();
          	String RecordNo=jsonObj.get("RecordNo")==null?null:jsonObj.get("RecordNo").toString();
          	String MeasureTime=jsonObj.get("MeasureTime")==null?null:jsonObj.get("MeasureTime").toString();
          	String DeviceType=jsonObj.get("DeviceType")==null?null:jsonObj.get("DeviceType").toString();
          	String LoginType=jsonObj.get("LoginType")==null?null:jsonObj.get("LoginType").toString();
          	String BloodFat=jsonObj.get("BloodFat")==null?null:jsonObj.get("BloodFat").toString();
          	String Cardiovascular=jsonObj.get("Cardiovascular")==null?null:jsonObj.get("Cardiovascular").toString();
          	String BMD=jsonObj.get("BMD")==null?null:jsonObj.get("BMD").toString();
          	String Alcohol=jsonObj.get("Alcohol")==null?null:jsonObj.get("Alcohol").toString();
          	String Hb=jsonObj.get("Hb")==null?null:jsonObj.get("Hb").toString();
          	String Lung=jsonObj.get("Lung")==null?null:jsonObj.get("Lung").toString();
          	bean.setMachineid(MachineId);
          	bean.setUnitno(UnitNo);
          	bean.setUnitname(UnitName);
          	bean.setMacaddr(MacAddr);
          	bean.setRecordno(RecordNo);
          	bean.setMeasuretime(MeasureTime);
          	bean.setDevicetype(DeviceType);
          	bean.setLogintype(LoginType);
          	bean.setBloodfat(BloodFat);
          	bean.setCardiovascular(Cardiovascular);
          	bean.setBmd(BMD);
          	bean.setAlcohol(Alcohol);
          	bean.setHb(Hb);
          	bean.setLung(Lung);
          	//Member
          	String Member = jsonObj.get("Member") ==null?null:jsonObj.get("Member").toString();
          	if(null !=Member){
          	JSONObject jsonData = JSON.parseObject(Member);
          	String Name = jsonData.get("Name")==null?null:jsonData.get("Name").toString();
          	String Mobile = jsonData.get("Mobile")==null?null:jsonData.get("Mobile").toString();
          	String IdCode = jsonData.get("IdCode")==null?null:jsonData.get("IdCode").toString();
          	String Age = jsonData.get("Age")==null?null:jsonData.get("Age").toString();
          	String Sex = jsonData.get("Sex")==null?null:jsonData.get("Sex").toString();
          	String Address = jsonData.get("Address")==null?null:jsonData.get("Address").toString();
          	String Birthday = jsonData.get("Birthday")==null?null:jsonData.get("Birthday").toString();
          	String UserIcon = jsonData.get("UserIcon")==null?null:jsonData.get("UserIcon").toString();
          	String Nation = jsonData.get("Nation")==null?null:jsonData.get("Nation").toString();
          	String StartDate = jsonData.get("StartDate")==null?null:jsonData.get("StartDate").toString();
        	String EndDate = jsonData.get("EndDate")==null?null:jsonData.get("EndDate").toString();
        	String Department = jsonData.get("Department")==null?null:jsonData.get("Department").toString();
        	String BarCode = jsonData.get("BarCode")==null?null:jsonData.get("BarCode").toString();
        	String IcCode = jsonData.get("IcCode")==null?null:jsonData.get("IcCode").toString();
        	String SocialCode = jsonData.get("SocialCode")==null?null:jsonData.get("SocialCode").toString();
        	String UserID = jsonData.get("UserID")==null?null:jsonData.get("UserID").toString();
          	
        	bean.setName(Name);
        	bean.setMobile(Mobile);
        	bean.setIccode(IcCode);
        	bean.setAge(Age);
        	bean.setSex(Sex);
        	bean.setAddress(Address);
        	bean.setBirthday(Birthday);
        	bean.setUsericon(UserIcon);
        	bean.setNation(Nation);
        	bean.setStartdate(StartDate);
        	bean.setEnddate(EndDate);
        	bean.setDepartment(Department);
        	bean.setBloodfat(BloodFat);
        	bean.setBarcode(BarCode);
        	bean.setSocialcode(SocialCode);
        	bean.setUserid(UserID);
        	bean.setIdcode(IdCode);}
        	//Height
          	
        	String Heights = jsonObj.get("Height")==null?null:jsonObj.get("Height").toString();
        	if(null !=Heights){
          	JSONObject jsonDataHeight = JSON.parseObject(Heights);
          	String Height = jsonDataHeight.get("Height")==null?null:jsonDataHeight.get("Height").toString();
          	String Weight = jsonDataHeight.get("Weight")==null?null:jsonDataHeight.get("Weight").toString();
          	String IdealWeight = jsonDataHeight.get("IdealWeight")==null?null:jsonDataHeight.get("IdealWeight").toString();
          	String Result = jsonDataHeight.get("Result")==null?null:jsonDataHeight.get("Result").toString();
          	 bean.setHeight(Height);
          	 bean.setWeight(Weight);
          	 bean.setIdealweight(IdealWeight);
          	}
          	//Fat
          	String Fats = jsonObj.get("Fat")==null?null:jsonObj.get("Fat").toString();
        	if(null !=Fats){
          	JSONObject jsonDataFat = JSON.parseObject(Fats);
          	String FatRate = jsonDataFat.get("FatRate")==null?null:jsonDataFat.get("FatRate").toString();
          	String Fat = jsonDataFat.get("Fat")==null?null:jsonDataFat.get("Fat").toString();
          	String ExceptFat = jsonDataFat.get("ExceptFat")==null?null:jsonDataFat.get("ExceptFat").toString();
          	String WaterRate = jsonDataFat.get("WaterRate")==null?null:jsonDataFat.get("WaterRate").toString();
          	String Water = jsonDataFat.get("Water")==null?null:jsonDataFat.get("Water").toString();
          	String Minerals = jsonDataFat.get("Minerals")==null?null:jsonDataFat.get("Minerals").toString();
          	String Protein = jsonDataFat.get("Protein")==null?null:jsonDataFat.get("Protein").toString();
          	String Fic = jsonDataFat.get("Fic")==null?null:jsonDataFat.get("Fic").toString();
          	String Foc = jsonDataFat.get("Foc")==null?null:jsonDataFat.get("Foc").toString();
          	String Muscle = jsonDataFat.get("Muscle")==null?null:jsonDataFat.get("Muscle").toString();
          	String FatAdjust = jsonDataFat.get("FatAdjust")==null?null:jsonDataFat.get("FatAdjust").toString();
          	String WeightAdjust = jsonDataFat.get("WeightAdjust")==null?null:jsonDataFat.get("WeightAdjust").toString();
          	String MuscleAdjust = jsonDataFat.get("MuscleAdjust")==null?null:jsonDataFat.get("MuscleAdjust").toString();
          	String BasicMetabolism = jsonDataFat.get("BasicMetabolism")==null?null:jsonDataFat.get("BasicMetabolism").toString();
          	String Viscera = jsonDataFat.get("Viscera")==null?null:jsonDataFat.get("Viscera").toString();
          	String Bmc = jsonDataFat.get("Bmc")==null?null:jsonDataFat.get("Bmc").toString();
          	String MuscleRate = jsonDataFat.get("MuscleRate")==null?null:jsonDataFat.get("MuscleRate").toString();
          	String QuganMuscle = jsonDataFat.get("QuganMuscle")==null?null:jsonDataFat.get("QuganMuscle").toString();
          	String QuganFat = jsonDataFat.get("QuganFat")==null?null:jsonDataFat.get("QuganFat").toString();
          	String ZuotuiMuscle = jsonDataFat.get("ZuotuiMuscle")==null?null:jsonDataFat.get("ZuotuiMuscle").toString();
          	String ZuobiMuscle = jsonDataFat.get("ZuobiMuscle")==null?null:jsonDataFat.get("ZuobiMuscle").toString();
          	String YoubiMuscle = jsonDataFat.get("YoubiMuscle")==null?null:jsonDataFat.get("YoubiMuscle").toString();
          	String YoutuiMuscle = jsonDataFat.get("YoutuiMuscle")==null?null:jsonDataFat.get("YoutuiMuscle").toString();
          	String ZuobiFat = jsonDataFat.get("ZuobiFat")==null?null:jsonDataFat.get("ZuobiFat").toString();
          	String ZuotuiFat = jsonDataFat.get("ZuotuiFat")==null?null:jsonDataFat.get("ZuotuiFat").toString();
          	String YoubiFat = jsonDataFat.get("YoubiFat")==null?null:jsonDataFat.get("YoubiFat").toString();
          	String YoutuiFat = jsonDataFat.get("YoutuiFat")==null?null:jsonDataFat.get("YoutuiFat").toString();
          	//String Results = jsonDataFat.get("Result")==null?null:jsonDataFat.get("Results").toString();
          	bean.setFatrate(FatRate);bean.setYoubifat(YoubiFat);bean.setYoutuifat(YoutuiFat);bean.setZuotuifat(ZuotuiFat);
          	bean.setFat(Fat);bean.setZuobimuscle(ZuobiMuscle);bean.setYoubimuscle(YoubiMuscle);bean.setYoutuimuscle(YoutuiMuscle);
          	bean.setExceptfat(ExceptFat);bean.setZuotuifat(ZuotuiFat);
          	bean.setWaterrate(WaterRate);
          	bean.setWater(Water);
          	bean.setMinerals(Minerals);
          	bean.setProtein(Protein);
          	bean.setFic(Fic);
          	bean.setFoc(Foc);
          	bean.setMuscle(Muscle);
          	bean.setFatadjust(FatAdjust);
          	bean.setWeightadjust(WeightAdjust);
          	bean.setMuscleadjust(MuscleAdjust);
          	bean.setBasicmetabolism(BasicMetabolism);
          	bean.setViscera(Viscera);
          	bean.setBmc(Bmc);
          	bean.setQuganmuscle(QuganMuscle);
          	bean.setQuganfat(QuganFat);
          	bean.setZuotuimuscle(ZuotuiMuscle);
          	bean.setZuotuifat(ZuotuiFat);
          	bean.setMinfat(MuscleRate);
        	}
          	//BloodPressure
        	String BloodPressure = jsonObj.get("BloodPressure")==null?null:jsonObj.get("BloodPressure").toString();
        	if(null !=BloodPressure){
          	JSONObject jsonDataBloodPressure = JSON.parseObject(BloodPressure);
          	String HighPressure = jsonDataBloodPressure.get("HighPressure")==null?null:jsonDataBloodPressure.get("HighPressure").toString();
          	String LowPressure = jsonDataBloodPressure.get("LowPressure")==null?null:jsonDataBloodPressure.get("LowPressure").toString();
          	String Pulse = jsonDataBloodPressure.get("Pulse")==null?null:jsonDataBloodPressure.get("Pulse").toString();
          	String Result1 = jsonDataBloodPressure.get("Result")==null?null:jsonDataBloodPressure.get("Result").toString();
          	bean.setHighpressure(HighPressure);
          	bean.setLowpressure(LowPressure);
          	bean.setPulse(Pulse);
        	}
          //Bo
        	String Bo = jsonObj.get("Bo")==null?null:jsonObj.get("Bo").toString();
        	if(null !=Bo){
          	JSONObject jsonDataBo = JSON.parseObject(Bo);
          	String Oxygen = jsonDataBo.get("Oxygen")==null?null:jsonDataBo.get("Oxygen").toString();
          	String Bpm = jsonDataBo.get("Bpm")==null?null:jsonDataBo.get("Bpm").toString();
          	String OxygenList = jsonDataBo.get("OxygenList")==null?null:jsonDataBo.get("OxygenList").toString();
          	String BpmList = jsonDataBo.get("BpmList")==null?null:jsonDataBo.get("BpmList").toString();
          	String Result2 = jsonDataBo.get("Result")==null?null:jsonDataBo.get("Result").toString();
          	String StartTime = jsonDataBo.get("StartTime")==null?null:jsonDataBo.get("StartTime").toString();
          	String EndTime = jsonDataBo.get("EndTime")==null?null:jsonDataBo.get("EndTime").toString();
          	String SecondCount = jsonDataBo.get("SecondCount")==null?null:jsonDataBo.get("SecondCount").toString();
          	bean.setOxygen(Oxygen);
          	bean.setBpm(Bpm);
          	bean.setOxygenlist(OxygenList);
          	bean.setBpmlist(BpmList);
          	bean.setStarttime(StartTime);
          	bean.setEndtime(EndTime);
          	bean.setSecondcount(SecondCount);
        	}
          //Temperature
        	String Temperature = jsonObj.get("Temperature")==null?null:jsonObj.get("Temperature").toString();
        	if(null !=Temperature){
          	JSONObject jsonDataTemperature = JSON.parseObject(Temperature);
          	String Temperature1 = jsonDataTemperature.get("Temperature")==null?null:jsonDataTemperature.get("Temperature").toString();
          	String Result3 = jsonDataTemperature.get("Result")==null?null:jsonDataTemperature.get("Result").toString();
          	bean.setTemperature(Temperature1);
        	}
          //Whr
        	String Whr = jsonObj.get("Whr")==null?null:jsonObj.get("Whr").toString();
        	if(null !=Whr){
          	JSONObject jsonDataWhr = JSON.parseObject(Whr);
          	String Waistline = jsonDataWhr.get("Waistline")==null?null:jsonDataWhr.get("Waistline").toString();
          	String Hipline = jsonDataWhr.get("Hipline")==null?null:jsonDataWhr.get("Hipline").toString();
          	String Whr1 = jsonDataWhr.get("Whr")==null?null:jsonDataWhr.get("Whr").toString();
          	String Result4 = jsonDataWhr.get("Result")==null?null:jsonDataWhr.get("Result").toString();
          	bean.setWaistline(Waistline);
          	bean.setHipline(Hipline);
          	bean.setWhr(Whr1);
        	}
            //BloodSugar
          	String BloodSugar = jsonObj.get("BloodSugar")==null?null:jsonObj.get("BloodSugar").toString();
          	if(null !=BloodSugar){
        	JSONObject jsonDataBloodSugar = JSON.parseObject(BloodSugar);
        	String BloodSugar1 = jsonDataBloodSugar.get("BloodSugar")==null?null:jsonDataBloodSugar.get("BloodSugar").toString();
        	String BloodsugarType = jsonDataBloodSugar.get("BloodsugarType")==null?null:jsonDataBloodSugar.get("BloodsugarType").toString();
        	String Result5 = jsonDataBloodSugar.get("Result")==null?null:jsonDataBloodSugar.get("Result").toString();
        	bean.setBloodsugar(BloodSugar1);
        	bean.setBloodsugartype(BloodsugarType);
          	}
        	//Ua
          	String Ua = jsonObj.get("Ua")==null?null:jsonObj.get("Ua").toString();
          	if(null !=BloodSugar){
        	JSONObject jsonDataUa = JSON.parseObject(Ua);
        	String Ua1 = jsonDataUa.get("Ua")==null?null:jsonDataUa.get("Ua").toString();
        	
        	//Ua
          	String PEEcg = jsonObj.get("PEEcg")==null?null:jsonObj.get("PEEcg").toString();
        	JSONObject jsonDataPEEcg = JSON.parseObject(PEEcg);
        	String Hr = jsonDataPEEcg.get("Hr")==null?null:jsonDataPEEcg.get("Hr").toString();
        	bean.setHr(Hr);
          	}
          	LOGGER.info("beanString:"+bean);  
 			bloodPressureService.saveBloodPressureInfo(bean);
		} catch (Exception e) {
			LOGGER.info("e:"+e);  
			sr.put("success", "false");
            sr.put("message", "返回值或错误信息");
			return sr;
		}   
             sr.put("success", "true");
             sr.put("message", "上传成功");
     return  sr;
    }

     
}
