package com.gz.medicine.yun.bloodpressure.controller;

import com.gz.medicine.common.util.*;
import com.gz.medicine.yun.bloodpressure.bean.BloodPressure;
import com.gz.medicine.yun.bloodpressure.request.BloodPressureRequest;
import com.gz.medicine.yun.bloodpressure.service.BloodPressureService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName UploadController
 * @PackageName com.gz.medicine.yun.bloodpressure.controller
 * @Description 统一数据上传
 * @Data 2017-08-17 10:47
 **/
@Controller
@RequestMapping("/rest/record/un/")
public class UploadController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(UploadController.class);

    @Autowired
    private BloodPressureService bloodPressureService;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/upload", method = RequestMethod.POST,produces="application/json; charset=utf-8")
    @ResponseBody
    public SimpleResult upload(@RequestBody Map map, HttpServletRequest request){
        SimpleResult simpleResult=new SimpleResult();;
        String uid=null;
        String unionRecId=null;

        //bp
        String high=null; //高压
        String low=null; //低压
        String heartbeat=null;//心跳
        String deviceId=null; //设备ID
        String testTime=null; //测试时间

        //bmi
        String bmiweight=null; //体重
        String height=null; //身高
        String bmibmi=null; //bmi值

        //bo
        String bloodOxygen=null; //血氧含量
        String pulse=null; //脉搏

        //temp
        String temp=null; //体温

        //gl
        String testType=null; //血糖监测类型:空腹 / 饭后
        String glucose=null;//血糖值

        //chol
        String chol=null;//胆固醇值

        //ecg
        String ecg=null;//心电图记录结果

        //ua
        String ua=null;//尿酸值

        //wl
        String wl=null;//腰围

        //urine
        String uro=null;//尿胆原
        String bld=null;//潜血
        String bil=null;//胆红素
        String ket=null;//酮体
        String glu=null;//葡萄糖
        String pro=null;//蛋白质
        String ph=null;//ph 值
        String nit=null;//亚硝酸盐
        String leu=null;//白细胞
        String sg=null;//比重
        String vc=null;//维生素 C

        //bci
        String bciweight=null;//bci体重
        String fat=null;//脂肪含量
        String visceralFat=null;//内脏脂肪
        String bcibmi=null;//bci bmi 值
        String kcal=null;//卡路里
        String boneMass=null;//骨量
        String moistureRate=null;//水分比例
        String leanMuscleMass=null;//肌肉含量
        String bodyImpedance=null;//人体阻抗

        try {

            JSONObject jsonObject=JSONObject.fromObject(map);
            //身份证号
            if(StringUtils.isNotEmpty(jsonObject.getString("uid"))){
                uid=jsonObject.getString("uid");
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "uid不能为空!");
            }

            if(StringUtils.isNotEmpty(jsonObject.getString("unionRecId"))){
                unionRecId=jsonObject.getString("unionRecId");
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "unionRecId不能为空!");
            }

            String records=jsonObject.getString("records");
            if(StringUtils.isNotEmpty(records)){
                JSONArray jsonArray=JSONArray.fromObject(records);
                for (int i = 0; i <jsonArray.size() ; i++) {


                    JSONObject object=jsonArray.getJSONObject(i);
                    String type=object.getString("dataType");
                    JSONObject data= JSONObject.fromObject(object.getString("data"));

                    //取第一个作为时间
                    if(i == 0) {
                        testTime=object.getString("testTime");
                    }

                    //bp
                    if("bp".equals(type)){
                        high=data.getString("high"); //高压
                        low=data.getString("low"); //低压
                        heartbeat=data.getString("heartbeat");//心跳
                    }
                    //bmi
                    if("bmi".equals(type)){
                        bmiweight=data.getString("weight"); //体重
                        height=data.getString("height"); //身高
                        bmibmi=data.getString("bmi"); //bmi值
                    }
                    //bo
                    if("bo".equals(type)){
                        bloodOxygen=data.getString("bloodOxygen"); //血氧含量
                        pulse=data.getString("pulse"); //脉搏
                    }
                    //temp
                    if("temp".equals(type)){
                        temp=data.getString("temp"); //体温
                    }
                    //gl
                    if("gl".equals(type)){
                        testType=data.getString("testType"); //血糖监测类型:空腹 / 饭后
                        glucose=data.getString("glucose");//血糖值
                    }
                    //chol
                    if("chol".equals(type)){
                        chol=data.getString("chol");//胆固醇值
                    }
                    //ecg
                    if("ecg".equals(type)){
                        ecg=data.getString("ecg");//心电图记录结果
                    }
                    //ua
                    if("ua".equals(type)){
                        ua=data.getString("ua");//尿酸值
                    }
                    //wl
                    if("wl".equals(type)){
                        wl=data.getString("wl");//腰围
                    }
                    //urine
                    if("urine".equals(type)){
                        uro=data.getString("uro");//尿胆原
                        bld=data.getString("bld");//潜血
                        bil=data.getString("bil");//胆红素
                        ket=data.getString("ket");//酮体
                        glu=data.getString("glu");//葡萄糖
                        pro=data.getString("pro");//蛋白质
                        ph=data.getString("ph");//ph 值
                        nit=data.getString("nit");//亚硝酸盐
                        leu=data.getString("leu");//白细胞
                        sg=data.getString("sg");//比重
                        vc=data.getString("vc");//维生素 C
                    }
                    //bci
                    if("bci".equals(type)){
                        bciweight=data.getString("weight");//bci体重
                        fat=data.getString("fat");//脂肪含量
                        visceralFat=data.getString("visceralFat");//内脏脂肪
                        bcibmi=data.getString("bmi");//bci bmi 值
                        kcal=data.getString("kcal");//卡路里
                        boneMass=data.getString("boneMass");//骨量
                        moistureRate=data.getString("moistureRate");//水分比例
                        leanMuscleMass=data.getString("leanMuscleMass");//肌肉含量
                        bodyImpedance=data.getString("bodyImpedance");//人体阻抗
                    }
                }

                BloodPressureRequest bloodPressureRequest = new BloodPressureRequest();

                //bloodPressureRequest.setGuid(unionRecId);

                //身份证
                bloodPressureRequest.setIdcode(uid);

                bloodPressureRequest.setTestTime(testTime);

                //bp血压
                bloodPressureRequest.setHighpressure(high);  //（收缩压）高
                bloodPressureRequest.setLowpressure(low);//（舒张压）低压
                bloodPressureRequest.setHeartbeat(heartbeat); //心跳


                //bmi 体质
                bloodPressureRequest.setWeight(bmiweight);
                bloodPressureRequest.setHeight(height);
                bloodPressureRequest.setBmi(bmibmi);

                //bo 血氧
                bloodPressureRequest.setOxygen(bloodOxygen);
                bloodPressureRequest.setPulse(pulse);

                //temp 体温
                bloodPressureRequest.setTemperature(temp);

                //gl 血糖
                bloodPressureRequest.setBloodsugartype(testType);
                bloodPressureRequest.setBloodsugar(glucose);

                //chol  胆固醇
                bloodPressureRequest.setChol(chol);

                //ecg 心电
                bloodPressureRequest.setEcg(ecg);

                //ua 尿酸
                bloodPressureRequest.setUa(ua);

                //wl 腰围
                bloodPressureRequest.setWaistline(wl);

                //urine 尿液
                bloodPressureRequest.setUro(uro);
                bloodPressureRequest.setBld(bld);
                bloodPressureRequest.setBil(bil);
                bloodPressureRequest.setKet(bil);
                bloodPressureRequest.setGlu(glu);
                bloodPressureRequest.setPro(pro);
                bloodPressureRequest.setPh(ph);
                bloodPressureRequest.setNit(nit);
                bloodPressureRequest.setLeu(leu);
                bloodPressureRequest.setSg(sg);
                bloodPressureRequest.setVc(vc);
                bloodPressureRequest.setKet(ket);
                bloodPressureRequest.setBodyImpedance(bodyImpedance);

                // bci 人体成分
                bloodPressureRequest.setFat(fat);
                bloodPressureRequest.setViscera(visceralFat);
                bloodPressureRequest.setBasicmetabolism(kcal);
                bloodPressureRequest.setBmc(boneMass);
                bloodPressureRequest.setWaterrate(moistureRate);
                bloodPressureRequest.setMuscle(leanMuscleMass);
                bloodPressureService.saveUpload(bloodPressureRequest);
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "records不能为空!");
            }


        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("e:"+e);
            simpleResult.put("resultCode", "5000");
            //simpleResult.put("message", "返回值或错误信息");
            return simpleResult;
        }
        simpleResult.put("resultCode", "2000");
        //simpleResult.put("message", "上传成功");
        return  simpleResult;

    }

}
