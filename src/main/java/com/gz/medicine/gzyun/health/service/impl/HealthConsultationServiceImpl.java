package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.*;
import com.gz.medicine.gzyun.health.mapper.*;
import com.gz.medicine.gzyun.health.reponse.*;
import com.gz.medicine.gzyun.health.request.OrderSubmittedRequest;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthConsultationServiceImpl
 * @PackageName com.gz.medicine.gzyun.health.service.impl
 * @Description 心理咨询实现类
 * @Data 2017-08-17 14:18
 **/
@Service
public class HealthConsultationServiceImpl implements HealthConsultationService {

    public static final Logger LOGGER = Logger.getLogger(HealthConsultationServiceImpl.class);

    @Autowired
    private HealthConsultationMapper healthConsultationMapper;

    @Autowired
    private healthDoctorMapper healthDoctorMapper;

    @Autowired
    private healthevaluateMapper healthevaluateMapper;

    @Autowired
    private HealthyOrderMapper healthyOrderMapper;

    @Autowired
    private HealthDoctorFormMapper healthDoctorFormMapper;

    @Autowired
    private healthPriceMapper healthPriceMapper;


    @Autowired
    private HealthOrderService healthOrderService;



    @Override
    public Page PsychoLogistList(PageModel page) throws CommonException {
        if(page.getPage().get("price")!=null&&page.getPage().get("price")!=""){
            String price=page.getPage().get("price").toString();
            if(price!=null&&price!=""){
//                0 所有
//                1 100以下
//                2 100-200元
//                3 201-300元
//                4 301-400元
//                5 401-500元
//                6 500以上
                if("0".equals(price) || price==null || "".equals(price)){
                    page.getPage().put("onevalue","0");
                    page.getPage().put("twovalue","100000");
                }
                if("1".equals(price)){
                    page.getPage().put("onevalue","1");
                    page.getPage().put("twovalue","100");
                }

                if("2".equals(price)){
                    page.getPage().put("onevalue","101");
                    page.getPage().put("twovalue","200");
                }

                if("3".equals(price)){
                    page.getPage().put("onevalue","201");
                    page.getPage().put("twovalue","300");
                }

                if("4".equals(price)){
                    page.getPage().put("onevalue","301");
                    page.getPage().put("twovalue","400");
                }

                if("5".equals(price)){
                    page.getPage().put("onevalue","401");
                    page.getPage().put("twovalue","500");
                }


                if("6".equals(price)){
                    page.getPage().put("onevalue","501");
                    page.getPage().put("twovalue","100000");
                }

            }
        }else {
            page.getPage().put("onevalue","1");
            page.getPage().put("twovalue","100000");
        }

        String comprehensive=page.getPage().get("comprehensive").toString();
        //综合排序
//        1.所有
//        2.预约最多
//        3.评价最高
//        if("".equals(comprehensive)){
//            page.getPage().put("comprehensive",1);
//        }
        Page p=page.getPage();
        try {
            List<PsychoLogistReponse> psychoLogistResponseList=healthConsultationMapper.queryPageHealthConsultationaList(p);
            p.setParameterType(psychoLogistResponseList);
        }catch (Exception e){
            LOGGER.error("心理医生列表接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return p;
    }

    @Override
    public DoctorParticularsReponse DoctorParticulars(String docid) throws CommonException {
        DoctorParticularsReponse doctorParticularsReponseList = new DoctorParticularsReponse();
        List<String> list=new ArrayList<String>();
            try{
                doctorParticularsReponseList=healthDoctorMapper.selectDoctorParticularsList(docid);
                if(doctorParticularsReponseList!=null){
                   String imagespath= doctorParticularsReponseList.getQualificationsids();
                   if(!"".equals(imagespath)&&imagespath!=null){
                       String[] ckse=imagespath.split(",");
                       for (int i = 0; i <ckse.length ; i++) {
                           list.add(doctorParticularsReponseList.getSeniorityurl()+ckse[i]);
                       }
                       doctorParticularsReponseList.setSeniorityftp(list);

                   }
                   String praise=doctorParticularsReponseList.getPraise();
                   if("".equals(praise)||praise==null){
                       doctorParticularsReponseList.setPraise("0");
                   }
                }
            }catch (Exception e){
                LOGGER.error("医生详情接口出现异常："+e.getMessage(),e);
                throw new CommonException("COM001","在执行SQL时出现异常",e);
            }

        return doctorParticularsReponseList;
    }

    @Override
    public Page UserEvaluation(PageModel page) throws CommonException {
        List<UserRatingReponse> userRatingReponse=null;
        Page p=page.getPage();
        String docid=page.getPage().get("docid").toString();
        try{
            userRatingReponse  =healthevaluateMapper.queryPageDocid(p);
            p.setParameterType(userRatingReponse);
            String count = healthevaluateMapper.selectCountByDocid(docid);
            if("".equals(count)||count==null){
                count="0";
            }
            p.put("count",count);
        }catch (Exception e){
            LOGGER.error("医生详情接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return p;
    }

    @Override
    public ConsultingOrderReponse ConsultOrder(String consultationmethod, String docid, String usrid) throws CommonException {
        Map<String,Object> stringMap;
        Map<String,String> maps;
        ConsultingOrderReponse consultingOrderReponse=new ConsultingOrderReponse();
        try {
            stringMap=healthConsultationMapper.selectConsultingOrderByDocid(docid);
            if(stringMap!=null){
                if(stringMap.get("DOCID")!=null){
                    consultingOrderReponse.setDocid(stringMap.get("DOCID").toString());
                }

                if(stringMap.get("DOCNAME")!=null){
                    consultingOrderReponse.setDocname(stringMap.get("DOCNAME").toString());
                }

                if(stringMap.get("DOCTITLE")!=null){
                    consultingOrderReponse.setDoctitle(stringMap.get("DOCTITLE").toString());
                }

                if(stringMap.get("PHOTOID")!=null){
                    consultingOrderReponse.setPhotoid(stringMap.get("PHOTOID").toString());
                }

                //图文
                if("1".equals(consultationmethod)){
                    if(stringMap.get("GRAPHICPRICE")!=null){
                        Object ob = stringMap.get("SPEECHPRICE");
                        consultingOrderReponse.setConsultationprice(ob.toString());
                    }
                }

                //语音
                if("2".equals(consultationmethod)){
                    if(stringMap.get("SPEECHPRICE")!=null){
                        Object ob = stringMap.get("SPEECHPRICE");
                        consultingOrderReponse.setConsultationprice(ob.toString());
                    }
                }

                //视频
                if("3".equals(consultationmethod)){
                    if(stringMap.get("VIDEOPRICE")!=null){
                        Object ob = stringMap.get("VIDEOPRICE");
                        consultingOrderReponse.setConsultationprice(ob.toString());
                    }
                }

            }

            maps=healthConsultationMapper.selectByUsrID(usrid);
            if(maps!=null){
                HealthyOrder healthyOrdere = healthyOrderMapper.selectOrderById(maps.get("GUID"));

                if(maps.get("GUID") != null){
                    consultingOrderReponse.setUsrid(maps.get("GUID").toString());
                }
                if(maps.get("AGE")!=null){
                    Object ob = maps.get("AGE");
                    consultingOrderReponse.setAge(ob.toString());
                }
                if(maps.get("SEX")!=null){
                    Object ob = maps.get("SEX");
                    consultingOrderReponse.setSex(ob.toString());
                }else {
                    if(healthyOrdere != null){
                        if("男".equals(healthyOrdere.getUsrsex())){
                            consultingOrderReponse.setSex("1");
                        }else {
                            consultingOrderReponse.setSex("2");
                        }
                    }
                }
                if(maps.get("BIRTHDAY")!=null){
                    consultingOrderReponse.setBirthday(maps.get("BIRTHDAY").toString());
                }else {
                    if(healthyOrdere != null){
                        consultingOrderReponse.setBirthday(healthyOrdere.getUsrbirth());
                    }
                }
                if(maps.get("MOBILE")!=null){
                    consultingOrderReponse.setMobile(maps.get("MOBILE").toString());
                }else {
                    if(healthyOrdere != null){
                        consultingOrderReponse.setMobile(healthyOrdere.getUsrphone());
                    }
                }
                if(maps.get("NAME")!=null){
                    consultingOrderReponse.setName(maps.get("NAME").toString());
                }else {
                    if(healthyOrdere != null){
                        consultingOrderReponse.setName(healthyOrdere.getUsername());
                    }
                }
            }
        }catch (Exception e){
            LOGGER.error("咨询订单接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return consultingOrderReponse;
    }

    @Override
    public List<Map<String,String>> DoctorScheduling(String docid) throws CommonException {
        List<Map<String,String>> stringMap = new ArrayList<Map<String, String>>();
        List<String> stringList = new ArrayList<String>();
        try {
            stringMap=healthConsultationMapper.selectDoctorForm(docid);
            GregorianCalendar ca = new GregorianCalendar();
            Date currentTime = new Date();
            //日期
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(currentTime);
            //当前的时
            Calendar cal = Calendar.getInstance();
            int hour=cal.get(Calendar.HOUR);//小时
            for (int i = 0; i <stringMap.size() ; i++) {
                //时间日期
                String dat = stringMap.get(i).get("HEALTHYTYPESETTINGTIME");
                //等于当天的
                if(dateString.equals(dat)){
                    //获取时间段
                    String intervaldate = stringMap.get(i).get("INTERVALDATE");
                    //上午的不变
                    //下午的删除上午的
                    if (hour >= 14 && hour <= 18) {
                        if(!"上午".equals(intervaldate)){
                            String temp = "";
                            //日期
                            temp += stringMap.get(i).get("HEALTHYTYPESETTINGTIME")+" ";
                            //周
                            temp += stringMap.get(i).get("WEEK_DAY")+" ";
                            //时间段 INTERVALDATE
                            temp += stringMap.get(i).get("INTERVALDATE");
                            stringList.add(temp);
                        }
                    }
                    //晚上的删除下午的
                    if(hour >= 19){
                        if(!"上午".equals(intervaldate)&&!"下午".equals(intervaldate)){
                            String temp = "";
                            //日期
                            temp += stringMap.get(i).get("HEALTHYTYPESETTINGTIME")+" ";
                            //周
                            temp += stringMap.get(i).get("WEEK_DAY")+" ";
                            //时间段 INTERVALDATE
                            temp += stringMap.get(i).get("INTERVALDATE");
                            stringList.add(temp);
                        }
                    }
                }else{
                    String temp = "";
                    //日期
                    temp += stringMap.get(i).get("HEALTHYTYPESETTINGTIME")+" ";
                    //周
                    temp += stringMap.get(i).get("WEEK_DAY")+" ";
                    //时间段 INTERVALDATE
                    temp += stringMap.get(i).get("INTERVALDATE");
                    stringList.add(temp);
                }
            }
        }catch (Exception e){
            LOGGER.error("医生接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return stringMap;
    }

    @Override
    public SimpleResult OrderSubmitted(OrderSubmittedRequest orderSubmittedRequest) throws CommonException {
        Map<String,String> maps=new HashMap<String, String>();
        HealthyOrder healthyOrder=new HealthyOrder();
        Double ordermount = 0.01;
        String dsf;
        int counts = 0;
        Date starTimedate;//开始时间
        Date endTimedate;//结束时间
        Boolean isSchedulingStar = false;
        Boolean isSchedulingEnd = false;
        String orderid=UUIDTool.getUUIDNumber();
        healthyOrder.setId(orderid);
        healthyOrder.setUsrid(orderSubmittedRequest.getUsrid());
        healthyOrder.setDocid(orderSubmittedRequest.getDocid());
        healthyOrder.setOrdercode(orderid);
        healthyOrder.setUsrphone(orderSubmittedRequest.getUsrphone());
        //结束时间
        String endTime = orderSubmittedRequest.getReserendtime();
        //开始时间
        String starTime = orderSubmittedRequest.getReserstarttime();
        SimpleDateFormat format= new SimpleDateFormat("HH:mm");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = df.format(new Date());
        try {
            List<HealthDoctorForm>  healthDoctorFormList = healthDoctorFormMapper.selectByFormdateList(orderSubmittedRequest.getDocid(),orderSubmittedRequest.getReservationdate());
            if(currentTime.equals(orderSubmittedRequest.getReservationdate())){
                if(healthDoctorFormList != null && healthDoctorFormList.size()>0){
                    for (HealthDoctorForm healthDoctorForm : healthDoctorFormList) {
                        if(healthDoctorForm.getFormstarttime().equals(orderSubmittedRequest.getReserstarttime())){
                            isSchedulingStar = true;
                        }
                        if(healthDoctorForm.getFormendtime().equals(orderSubmittedRequest.getReserendtime())){
                            isSchedulingEnd = true;
                        }
                    }
                }
                //开始排班时间
                if(!isSchedulingStar){
                    return  SimpleResult.error("COMM01","当前医生没有这个开始时间的排班");
                }
                //开始排班时间
                if(!isSchedulingEnd){
                    return  SimpleResult.error("COMM01","当前医生没有这个结束时间的排班");
                }
            }else {
                List<HealthDoctorForm>  healthDoctorFormListes = healthDoctorFormMapper.selectByFormdateListothers(orderSubmittedRequest.getDocid(),orderSubmittedRequest.getReservationdate());
                    if (healthDoctorFormListes != null && healthDoctorFormListes.size() > 0) {
                        for (HealthDoctorForm healthDoctorForm : healthDoctorFormListes) {
                            if (healthDoctorForm.getFormstarttime().equals(orderSubmittedRequest.getReserstarttime())) {
                                isSchedulingStar = true;
                            }
                            if (healthDoctorForm.getFormendtime().equals(orderSubmittedRequest.getReserendtime())) {
                                isSchedulingEnd = true;
                            }
                        }
                    }
                    //开始排班时间
                    if (!isSchedulingStar) {
                        return SimpleResult.error("COMM01", "当前医生没有这个开始时间的排班");
                    }
                    //开始排班时间
                    if (!isSchedulingEnd) {
                        return SimpleResult.error("COMM01", "当前医生没有这个结束时间的排班");
                    }

            }

            healthPrice healthPrices =  healthPriceMapper.selectByID(orderSubmittedRequest.getDocid());
            if(healthPrices != null && !"".equals(healthPrices)){
                // 2 图文、3 语音、4 视频
                if("2".equals(orderSubmittedRequest.getConsultationmethod())){//consultationmethod
                    ordermount = Double.parseDouble(healthPrices.getGraphicprice());
                }else if("3".equals(orderSubmittedRequest.getConsultationmethod())){//consultationmethod
                    //SPEECHPRICE
                    ordermount = Double.parseDouble(healthPrices.getSpeechprice());
                }else if("4".equals(orderSubmittedRequest.getConsultationmethod())){//consultationmethod
                    ordermount = Double.parseDouble(healthPrices.getVideoprice());
                }else {
                    return  SimpleResult.error("COMMON","请输入正确的咨询类型,只能为: 2、3、4");
                }
            }
            HealthDoctorForm healthDoctorForm = new HealthDoctorForm();
            healthDoctorForm.setDocid(orderSubmittedRequest.getDocid());
            healthDoctorForm.setFormstarttime(orderSubmittedRequest.getReserstarttime());
            healthDoctorForm.setFormendtime(orderSubmittedRequest.getReserendtime());
            healthDoctorForm.setFormdate(orderSubmittedRequest.getReservationdate());//reservationdate
            counts = healthDoctorFormMapper.countByStateAndEndTime(healthDoctorForm);
            if(counts != 0){
                long nd = 1000*24*60*60;//一天的毫秒数
                long nh = 1000*60*60;//一小时的毫秒数
                long nm = 1000*60;//一分钟的毫秒数
                long ns = 1000;//一秒钟的毫秒数
                //ordermount = counts * ordermount;
                //healthyOrder.setOrderamount(String.valueOf(ordermount));//订单总额
                SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
                Date endTimes = sd.parse(orderSubmittedRequest.getReserstarttime());  //取开始时间
                Calendar cal = Calendar.getInstance();
                cal.setTime(sd.parse(orderSubmittedRequest.getReserendtime()));   //取结束时间
                cal.add(Calendar.MINUTE, 10);
                //获得两个时间的毫秒时间差异
                Long diff =  cal.getTime().getTime() - endTimes.getTime();
                long day = diff/nd;//计算差多少天
                long hour = diff%nd/nh;//计算差多少小时
                long min = diff%nd%nh/nm;//计算差多少分钟
                long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
                LOGGER.info("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
                ordermount = hour * ordermount;
                DecimalFormat dff = new DecimalFormat("#0.00");
                dsf = dff.format(ordermount);
                healthyOrder.setOrderamount(dsf);
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(),"根据时间获取排班失败!");
            }

        } catch (Exception e) {
            throw new CommonException("COM001","时间差出错!!!",e);
        }
        maps = healthConsultationMapper.selectByUsrID(orderSubmittedRequest.getUsrid());
        if(maps.size() > 0){
            healthyOrder.setUpdatename(maps.get("NAME"));//更新人
            healthyOrder.setCreatename(maps.get("NAME"));//创建人
        }

        healthyOrder.setUsrsex(orderSubmittedRequest.getUsersex());
        healthyOrder.setUsrname(orderSubmittedRequest.getUsername());
        healthyOrder.setUsrbirth(orderSubmittedRequest.getUsrbirth());
        healthyOrder.setReserstarttime(orderSubmittedRequest.getReserstarttime());
        healthyOrder.setReserendtime(orderSubmittedRequest.getReserendtime());
        //预约日期
        if(!"".equals(orderSubmittedRequest.getReservationdate())&&orderSubmittedRequest.getReservationdate()!=null){
            healthyOrder.setReservationdate(orderSubmittedRequest.getReservationdate()); //预约日期  取当前时间
        }
        //预约图片
        if(!"".equals(orderSubmittedRequest.getReservationphotoid())&&orderSubmittedRequest.getReservationphotoid()!=null){
            healthyOrder.setReservationphotoid(orderSubmittedRequest.getReservationphotoid());
        }
        healthyOrder.setConsultingdescription(orderSubmittedRequest.getReservationdescription()); //订单描述
        healthyOrder.setState("1");
        healthyOrder.setPathcode("002");
        //订单状态：
        //待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
        healthyOrder.setOrderstate("1");//待支付状态
        healthyOrder.setCreatedate(new Date());//创建时间
        healthyOrder.setUpdatedate(new Date());//更新时间
        //咨询类型 不限、图文、语音、视频（1、2、3、4）
        healthyOrder.setConsultationmethod(orderSubmittedRequest.getConsultationmethod());
        try {
            healthOrderService.insertAndLog(healthyOrder);

            //更改医生排班状态
            HealthDoctorForm healthDoctorForm = new HealthDoctorForm();
            healthDoctorForm.setDocid(orderSubmittedRequest.getDocid()); //医生ID
            healthDoctorForm.setFormdate(orderSubmittedRequest.getReservationdate()); //预约日期
            healthDoctorForm.setFormstarttime(orderSubmittedRequest.getReserstarttime());//预约开始时间
            healthDoctorForm.setFormendtime(orderSubmittedRequest.getReserendtime()); //预约结束时间
            healthDoctorForm.setFormstate("1");//设置状态为 1 已预约
            healthDoctorFormMapper.updateDocFormState(healthDoctorForm);
        }catch (Exception e){
            LOGGER.error("订单提交接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        SimpleResult simpleResult=SimpleResult.success();
        simpleResult.putData("orderid",orderid);
        simpleResult.putData("thirdordercode",orderid);
        simpleResult.putData("createdate",DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));
        simpleResult.putData("orderamount",dsf);
        simpleResult.putData("appointmenttime",orderSubmittedRequest.getReservationdate()+" "+ orderSubmittedRequest.getReserstarttime() + "-" + orderSubmittedRequest.getReserendtime());
        simpleResult.putData("reservationdescription",orderSubmittedRequest.getReservationdescription());
        return simpleResult;
    }

    @Override
    public Boolean UpdateOrderState(String orderid) throws CommonException {
        Map<String,String> stringMap=new HashMap<String, String>();
        stringMap.put("orderid",orderid);
        stringMap.put("orderstate","2");
        try {
            healthyOrderMapper.updateOrderByOrderId(stringMap);
            Integer count=healthConsultationMapper.selectCountById(orderid);
            if(count>0){
            }else {
                HealthConsultation healthConsultation=new HealthConsultation();
                HealthyOrder healthyOrder=healthyOrderMapper.selectOrderById(orderid);
                healthConsultation.setId(UUIDTool.getUUID());
                healthConsultation.setOrderid(orderid);
                healthConsultation.setConsultingstate("1");  //ConsultingState
                healthConsultation.setState("1");
                healthConsultation.setUsrid(healthyOrder.getUsrid());
                healthConsultation.setDocid(healthyOrder.getDocid());
                healthConsultation.setCreatedate(new Date());
                healthConsultation.setUpdatedate(new Date());
                healthConsultation.setCreatename(healthyOrder.getCreatename());
                healthConsultation.setUpdatename(healthyOrder.getUpdatename());
                healthConsultationMapper.insert(healthConsultation);
            }
        } catch (Exception e) {
            LOGGER.error("订单状态修改接口出现异常："+e.getMessage(),e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean UpdateOrderState(String orderid, String orderflag) throws CommonException {
        Map<String,String> stringMap=new HashMap<String, String>();
        stringMap.put("orderid",orderid);
        stringMap.put("orderstate","2");
        try {
            healthyOrderMapper.updateOrderByOrderId(stringMap);
        }catch (Exception e){
            LOGGER.error("订单状态修改接口出现异常："+e.getMessage(),e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateOrder(String orderid) throws CommonException {
        //获取订单
        try {
            Map<String,String> stringMap = new HashMap<String, String>();
            stringMap.put("orderid",orderid);
            stringMap.put("orderstate","5");
            healthyOrderMapper.updateOrderStateByOrderId(stringMap);
        }catch (Exception e){
            LOGGER.error("订单状态修改接口出现异常："+e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Map<String,String> GetUsr(String usrid) throws CommonException {
        Map<String,String> maps = new HashMap<String, String>();
        try {
            maps=healthConsultationMapper.selectByUsrID(usrid);
            HealthyOrder healthyOrder = healthyOrderMapper.selectTopByUserId(usrid);
            if(maps.size() > 0){
                if(StringUtils.isEmpty(maps.get("SEX"))){
                    if(healthyOrder != null){
                        if("男".equals(healthyOrder.getUsrsex())){
                            maps.put("SEX","1");
                        }else {
                            maps.put("SEX","2");
                        }
                    }
                }

                if(StringUtils.isEmpty(maps.get("BIRTHDAY"))){
                    if(healthyOrder != null){
                        maps.put("BIRTHDAY",healthyOrder.getUsrbirth());
                    }
                }
                if(StringUtils.isEmpty(maps.get("MOBILE"))){
                    if(healthyOrder != null){
                        maps.put("MOBILE",healthyOrder.getUsrphone());
                    }
                }
            }
        }catch (Exception e){
            LOGGER.error("患者详情接口出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return maps;
    }

    @Override
    public List<HealthDoctorFormReponse> GetDoctorForm(String docid,String formdate) throws CommonException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentTime = df.format(new Date());
        List<HealthDoctorFormReponse> healthDoctorFormReponseList = new ArrayList<HealthDoctorFormReponse>();
        List<String> stringList = healthDoctorFormMapper.selectByPrimaryKeyStrList(docid,formdate);
        for (String str : stringList) {
            HealthDoctorFormReponse healthDoctorFormReponse = new HealthDoctorFormReponse();
            healthDoctorFormReponse.setFormDate(str);
            if(currentTime.equals(str)){
                List<HealthDoctorForm>  healthDoctorFormList = healthDoctorFormMapper.selectByFormdateList(docid,str);
                if(healthDoctorFormList != null && healthDoctorFormList.size()>0){
                    healthDoctorFormReponse.setHealthDoctorFormReponseList(healthDoctorFormList);
                    healthDoctorFormReponseList.add(healthDoctorFormReponse);
                }
            }else {
                List<HealthDoctorForm>  healthDoctorFormList = healthDoctorFormMapper.selectByFormdateListother(docid,str,currentTime);
                if(healthDoctorFormList != null && healthDoctorFormList.size()>0){
                    healthDoctorFormReponse.setHealthDoctorFormReponseList(healthDoctorFormList);
                    healthDoctorFormReponseList.add(healthDoctorFormReponse);
                }
            }


        }
        return healthDoctorFormReponseList;
    }

    @Override
    public List<HealthDoctorForm> GetHealthDoctorFormList(String id) throws CommonException {
        List<HealthDoctorForm> healthDoctorFormList = null;
        try {
            healthDoctorFormList = healthDoctorFormMapper.selectByPrimaryKeyList(id);
        }catch (CommonException e){
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return healthDoctorFormList;
    }


    @Override
    public Page GetPsychoLogist(PageModel page) throws CommonException {
        Page p = page.getPage();
        try {
            Boolean flages = false;
            StringBuffer sql = new StringBuffer();
            sql.append("select configs.VIDEOSERVICE,configs.VOICESERVICE,configs.IMAGESERVICE,doc.id as docid,doc.name as docname,doc.begood,rice.graphicprice,rice.speechprice,rice.videoprice,chart.titleName,hpath.FTPURL||doc.PHOTOID as ftpurl,luate.score,doc.state as state, case when orders.ordersum is null then 0 else orders.ordersum end as ordersum from (select * from HEALTHDOCTOR where STATE='1') doc");
            sql.append("   left join HealthServiceConfig configs on doc.id=configs.docid\n" +
                      "    left join HEALTHPRICE rice on doc.id=rice.docid\n" +
                      "    left join healthTitleChart chart on doc.titlecode=chart.TITLECODE\n" +
                      "    left join HEALTHFTPPATH hpath on doc.PATHCODE=hpath.PATHCODE\n" +
                      "    left join (select round(avg(score),1) as score,docid from healthevaluate GROUP BY docid) luate on doc.id=luate.docid ");
            /**
             * comprehensive   综合排序
             *   1.所有
             *   2.预约最多
             *   3.评价最高
             */
            String comprehensive = page.getPage().get("comprehensive").toString();

            /**价格**/
            String price = page.getPage().get("price").toString();
            sql.append(" left join (select count(*) as ordersum,docid from HealthyOrder GROUP BY docid ) orders on doc.id=orders.docid ");
//            if("1".equals(comprehensive)){
//                sql.append(" left join (select count(*) as ordersum,docid from HealthyOrder GROUP BY docid ) orders on doc.id=orders.docid ");
//            }
//            if("2".equals(comprehensive)){
//                sql.append(" left join (select count(*) as ordersum,docid from HealthyOrder GROUP BY docid  ) orders on doc.id=orders.docid ");
//            }

            String docname = page.getPage().get("docname").toString();
            if(StringUtils.isNotEmpty(docname)){
                sql.append(" where doc.name like '%");
                sql.append(docname);
                sql.append("%'");
            }
            /**
             * consultationmethod  咨询类型
             * 1.所有
               2.图文咨询
               3.语音咨询
               4.视频咨询
             */
            String consultationmethod = page.getPage().get("consultationmethod").toString();
            if("1".equals(consultationmethod)){
                if(StringUtils.isNotEmpty(docname)){
                    sql.append(" and rice.VIDEOPRICE ");
                }else {
                    sql.append(" where rice.VIDEOPRICE ");
                }

            //图文咨询
            }else if("2".equals(consultationmethod)){
                if(StringUtils.isNotEmpty(docname)){
                    if(!"0".equals(price)){
                        sql.append(" and configs.ImageService!='0' and rice.GRAPHICPRICE ");
                    }else {
                        sql.append(" and configs.ImageService!='0' OR configs.IMAGESERVICE is NULL ");
                        flages = true;
                    }
                }else {
                    if(!"0".equals(price)){
                        sql.append(" where configs.ImageService!='0' and rice.GRAPHICPRICE ");
                    }else {
                        sql.append(" where configs.ImageService!='0' OR configs.ImageService is NULL");
                        flages = true;
                    }
                }

            //语音咨询
            }else if("3".equals(consultationmethod)){
                if(StringUtils.isNotEmpty(docname)){
                    if(!"0".equals(price)){
                        sql.append(" and configs.VoiceService!='0' and rice.SPEECHPRICE ");
                    }else {
                        sql.append(" and configs.VoiceService!='0' OR configs.VoiceService is NULL");
                        flages = true;
                    }
                }else {
                    if(!"0".equals(price)){
                        sql.append(" where configs.VoiceService!='0' and rice.SPEECHPRICE ");
                    }else {
                        sql.append(" where configs.VoiceService!='0' ");
                        flages = true;
                    }
                }

            //视频咨询
            }else if("4".equals(consultationmethod)){
                if(StringUtils.isNotEmpty(docname)){
                    if(!"0".equals(price)){
                        sql.append(" and configs.videoService!='0' and rice.VIDEOPRICE ");
                    }else {
                        sql.append(" and configs.videoService!='0' ");
                        flages = true;
                    }

                }else {
                    if(!"0".equals(price)){
                        sql.append(" where configs.videoService!='0' and rice.VIDEOPRICE ");
                    }else {
                        sql.append(" where configs.videoService!='0' ");
                        flages = true;
                    }
                }

            }


            /**
             *    price
             *    价格
             *    0 .所有
             *    1 .100以下
             *    2 .100-200元
             *    3 .201-300元
             *    4 .301-400元
             *    5 .401-500元
             *    6 .500以上
             */
            String onevalue = "";
            String twovalue = "";
            if(!flages){
                if("0".equals(price)){
                    sql.append(" >= 0 ");
                }
            }

            if("1".equals(price)){
                sql.append(" <= 100 ");
            }
            if("2".equals(price)){
                sql.append(" BETWEEN  ");
                sql.append(" 100 and 200 ");
            }
            if("3".equals(price)){
                sql.append(" BETWEEN  ");
                sql.append(" 201 and 300 ");
            }
            if("4".equals(price)){
                sql.append(" BETWEEN  ");
                sql.append(" 301 and 401 ");
            }
            if("5".equals(price)){
                sql.append(" BETWEEN  ");
                sql.append(" 401 and 500 ");
            }
            if("6".equals(price)){
                sql.append(" > 500 ");
            }

            if("3".equals(comprehensive)){
                sql.append(" order by luate.score desc ");
            }

            if("2".equals(comprehensive)){
                sql.append(" order by orders.ordersum asc ");
            }

            if("2".equals(comprehensive)||"3".equals(comprehensive)){
                sql.append(" ,docid ");
            }else {
                sql.append(" order by doc.createdate desc,docid ");
            }


            System.out.println(sql.toString());

            page.getPage().put("SQL",sql.toString());
            List<PsychoLogistReponse> psychoLogistResponseList=healthConsultationMapper.queryPageHealthConsultationa(p);

            if(page.getPage().get("usrid") != null){
                String usrid = page.getPage().get("usrid").toString();
                int counts = healthConsultationMapper.getCountUserTest(usrid);
                if(counts<=0){
                    for (int i = psychoLogistResponseList.size()-1; i >=0; i--) {
                        BigDecimal big = new BigDecimal(1);
                        BigDecimal Graphicprice = new BigDecimal(psychoLogistResponseList.get(i).getGraphicprice());//图文价格
                        BigDecimal Speechprice = new BigDecimal(psychoLogistResponseList.get(i).getSpeechprice());//语音价格
                        BigDecimal Videoprice = new BigDecimal(psychoLogistResponseList.get(i).getVideoprice());//视频价格
                        if(Graphicprice.compareTo(big)<0 || Graphicprice.compareTo(big)==0 || Speechprice.compareTo(big)<0 || Speechprice.compareTo(big)==0 || Videoprice.compareTo(big)<0 || Videoprice.compareTo(big)==0){//小于1或等于1
                            psychoLogistResponseList.remove(i);
                        }
                    }
                }

            }else {
                for (int i = psychoLogistResponseList.size()-1; i >=0; i--) {
                    BigDecimal big = new BigDecimal(1);
                    BigDecimal Graphicprice = new BigDecimal(psychoLogistResponseList.get(i).getGraphicprice());//图文价格
                    BigDecimal Speechprice = new BigDecimal(psychoLogistResponseList.get(i).getSpeechprice());//语音价格
                    BigDecimal Videoprice = new BigDecimal(psychoLogistResponseList.get(i).getVideoprice());//视频价格
                    if(Graphicprice.compareTo(big)<0 || Graphicprice.compareTo(big)==0 || Speechprice.compareTo(big)<0 || Speechprice.compareTo(big)==0 || Videoprice.compareTo(big)<0 || Videoprice.compareTo(big)==0){//小于1或等于1
                        psychoLogistResponseList.remove(i);
                    }
                }
            }
            p.setParameterType(psychoLogistResponseList);
        }catch (Exception e){
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }

        return p;
    }

    @Override
    public HealthConsultation selectByPrimaryOrderId(String orderid) throws CommonException {
        HealthConsultation healthConsultation = null;
        try {
            healthConsultation = healthConsultationMapper.selectByPrimaryOrderId(orderid);
        }catch (CommonException e){
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return healthConsultation;
    }

    @Override
    public int updateByPrimaryKeySelective(HealthConsultation healthConsultation) throws CommonException {
        int flag = 0;
        try {
            flag = healthConsultationMapper.updateByPrimaryKeySelective(healthConsultation);
        }catch (CommonException e){
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return flag;
    }

	@Override
	public List<HealthConsultationReponse> queryMessage(String orderid) throws CommonException {
		
			// TODO Auto-generated method stub
			List<HealthConsultationReponse> rep = null;
			List<HealthConsultationReponse> responses = new ArrayList<HealthConsultationReponse>();
	        try {
	        	rep = healthConsultationMapper.queryMessage(orderid);
	        	for (HealthConsultationReponse ConsultationReponse : rep) {
					List<String> stringList=new ArrayList<String>();
					String imgs = ConsultationReponse.getReservationphotoid();
					if(StringUtils.isNotEmpty(imgs)){
						String[] imgpath = imgs.split(",");
						for (int i = 0; i < imgpath.length; i++) {
							stringList.add(ConsultationReponse.getFtpurl() + imgpath[i]);
						}
					}
					ConsultationReponse.setReservationphotoidList(stringList);
					responses.add(ConsultationReponse);
				}
	        		
			} catch (Exception e) {
				// TODO: handle exception
				throw new CommonException("COM001","在执行SQL时出现异常",e);
			}
	        return responses;
		}

	@Override
	/**
	 * 点击咨询消息触发消除未读以及判断当前时间是否在订单时间内
	 * **/
	public String updateMess(HealthConsultation data) throws CommonException {
		HealthConsultation con = new HealthConsultation();
		try {
			healthConsultationMapper.updateNotRead(data);
			con = healthConsultationMapper.queryTime(data.getOrderid());
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String starttime = con.getStartime();
				String endtime = con.getEndtime();
				Date start = sd.parse(starttime);
				Date end = sd.parse(endtime);
				String now = sd.format(System.currentTimeMillis());
				Date nowtime = sd.parse(now);
				if("5".equals(con.getOrderstate())){
					return "3";
				}else if(nowtime.getTime()<start.getTime()){
					return "1";
				}else if(nowtime.getTime()>=end.getTime()){
					return "2";
				}else{
					return "0";
				}	
		} catch (Exception e) {
			// TODO: handle exception
			throw new CommonException("COM001","在执行updateMess,SQL时出现异常",e);
		}
		
	}

    @Override
    public boolean checkData(String startTime, String endTime,String userid) throws CommonException {
        try {
          int count = healthConsultationMapper.checkDate(startTime,endTime,userid);
          if(count>0){
              return true;
          }
        }catch (Exception e){
            throw new CommonException("COM001","在执行updateMess,SQL时出现异常",e);
        }
        return false;
    }

    @Override
    public Page getOrderAll(PageModel page) throws CommonException {
        Page p=page.getPage();
        try {
            List<HealthyOrder> healthyOrderList = healthyOrderMapper.queryPageOrderBystate(p);
            p.setParameterType(healthyOrderList);
        }catch (Exception e){
            throw new CommonException("COM001","getOrderAll,SQL时出现异常",e);
        }
        return p;
    }

    @Override
    public Map getOrderSum(String usrid) throws CommonException {
	    Map map = new HashMap();
        try {
            int all = healthyOrderMapper.countByOrderState(usrid,""); //所有订单
            int waitPay = healthyOrderMapper.countByOrderState(usrid,"1"); //待支付
            int waitConsulting = healthyOrderMapper.countByOrderState(usrid,"2"); //待咨询
            int complete = healthyOrderMapper.countByOrderState(usrid,"5"); //已完成
            map.put("all",all);
            map.put("waitpay",waitPay);
            map.put("waitconsulting",waitConsulting);
            map.put("complete",complete);
        }catch (Exception e){
            throw new CommonException("COM001","getOrderSum,SQL时出现异常",e);
        }
        return map;
    }

    @Override
    public Page getConsultaion(PageModel page) throws CommonException {
	    List<HealthyOrderlistResponse> healthyOrderList = null;
        Page p = page.getPage();
        try {
            healthyOrderList = healthyOrderMapper.queryPageConsultaion(p);
            p.setParameterType(healthyOrderList);
        }catch (Exception e){
            throw new CommonException("COM001","getConsultaion,SQL时出现异常",e);
        }
        return p;
    }
}








