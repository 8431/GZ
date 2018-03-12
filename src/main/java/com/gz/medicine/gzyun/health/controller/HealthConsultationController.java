package com.gz.medicine.gzyun.health.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.Validator;

import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.HealthActionRecord;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.mapper.HealthActionRecordMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.reponse.ConsultingOrderReponse;
import com.gz.medicine.gzyun.health.reponse.DoctorParticularsReponse;
import com.gz.medicine.gzyun.health.reponse.HealthConsultationReponse;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorFormReponse;
import com.gz.medicine.gzyun.health.request.OrderSubmittedRequest;
import com.gz.medicine.gzyun.health.service.HealthConsultationService;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthConsultationController
 * @PackageName com.gz.medicine.gzyun.health.controller
 * @Description 心理咨询 Controller
 * @Data 2017-09-21 10:47
 **/
@Controller
@RequestMapping("consultaion")
public class HealthConsultationController extends ValidateWithException{

    public static final Logger LOGGER = Logger.getLogger(HealthConsultationController.class);

    @Autowired
    private HealthConsultationService healthConsultationService;

    @Autowired
    private HealthActionRecordMapper healthActionRecordMapper;

    @Autowired
    Validator validator;


    /**
     *
     *@Title Psychologist
     *@Description: 心理医生列表
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param page(咨询类型 consultationmethod,价格 price,综合排序 comprehensive,医生名 docname)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/psychologist?pageNo=1&pageSize=12&consultationmethod=1&price=100,400&comprehensive=1&docname=邓
     */
    @RequestMapping(value="psychologistdel",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult Psychologist(PageModel page){
        SimpleResult simpleResult;
        Page p=page.getPage();
        LOGGER.info("[/consultaion/psychologist]");
        try {
            simpleResult=SimpleResult.success();
            p= healthConsultationService.PsychoLogistList(page);
            //simpleResult.put("data",p);
            simpleResult.putDataAll(p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title DoctorParticulars
     *@Description: 医生详情
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param docid
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8081/GZ/consultaion/particulars?docid=59AAFCEA1FEEA121E050007F010057C5
     */
    @RequestMapping(value="particulars",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult DoctorParticulars(String docid,String usrid){
        SimpleResult simpleResult;
        DoctorParticularsReponse doctorParticularsReponseList = null;
        LOGGER.info("[/consultaion/particulars]");
        if("".equals(docid)&&docid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入医生ID!!!");
        }

        try {

            if(!"".equals(usrid) && usrid!=null){
                HealthActionRecord healthActionRecord = new HealthActionRecord();
                healthActionRecord.setId(UUIDTool.getUUID());
                healthActionRecord.setUsrid(usrid);
                healthActionRecord.setDocid(docid);
                healthActionRecord.setModulcode("000002");
                healthActionRecordMapper.insertSelective(healthActionRecord);
            }

            simpleResult=SimpleResult.success();
            doctorParticularsReponseList=healthConsultationService.DoctorParticulars(docid);
            if(!"".equals(doctorParticularsReponseList)&&doctorParticularsReponseList!=null){
                simpleResult.put("data",doctorParticularsReponseList);
            }
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }


    /**
     *
     *@Title DoctorParticulars
     *@Description: 用户评论
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param page
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/userevaluation?docid=59AAFCEA1FEEA121E050007F010057C5
     */
    @RequestMapping(value="userevaluation",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult UserEvaluation(PageModel page){
        SimpleResult simpleResult;
        LOGGER.info("[/consultaion/userevaluation]");
        String docid=page.getPage().get("docid").toString();
        Page p=page.getPage();
        if("".equals(docid)&&docid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入医生ID!!!");
        }
        try {
            simpleResult=SimpleResult.success();
            p=healthConsultationService.UserEvaluation(page);
            simpleResult.putDataAll(p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }


    /**
     *
     *@Title ConsultOrder
     *@Description: 咨询订单页面接口
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param consultationmethod,docid,usrid
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/consultorder?consultationmethod=1&docid=59AAFCEA1FEEA121E050007F010057C5&usrid=52FD15424393C46DE050A8C0E60029EC
     */
    @RequestMapping(value="consultorder",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult ConsultOrder(String consultationmethod,String docid,String usrid){
        SimpleResult simpleResult;
        ConsultingOrderReponse consultingOrderReponse;
        LOGGER.info("[/consultaion/consultorder]");
        if("".equals(consultationmethod)||consultationmethod==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入咨询类型!!!");
        }
        if("".equals(docid)||docid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入医生ID!!!");
        }
        if("".equals(usrid)||usrid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入患者ID!!!");
        }
        try {
          simpleResult=SimpleResult.success();
          consultingOrderReponse=healthConsultationService.ConsultOrder(consultationmethod,docid,usrid);
          simpleResult.put("data",consultingOrderReponse);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title ConsultOrder
     *@Description: 医生排班接口
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param docid
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/doctorscheduling?docid=59AAFCEA1FEEA121E050007F010057C5
     */
    @RequestMapping(value="doctorscheduling",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult DoctorScheduling(String docid){
        SimpleResult simpleResult;
        List<Map<String,String>> stringMap;
        LOGGER.info("[/consultaion/doctorscheduling]");
        if("".equals(docid)||docid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入医生ID!!!");
        }
        try {
            simpleResult=SimpleResult.success();
            stringMap=healthConsultationService.DoctorScheduling(docid);
            simpleResult.put("data",stringMap);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title OrderSubmitted
     *@Description: 订单提交接口
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param orderSubmittedRequest
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/ordersubmitted?docid=59AAFCEA1FEEA121E050007F010057C5
     */
    @RequestMapping(value="ordersubmitted",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult OrderSubmitted(OrderSubmittedRequest orderSubmittedRequest){
        SimpleResult simpleResult;
        LOGGER.info("[/consultaion/ordersubmitted]");
        if(validates(validator, orderSubmittedRequest)!=null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, orderSubmittedRequest));
        }
        try {
            simpleResult=healthConsultationService.OrderSubmitted(orderSubmittedRequest);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title getorder
     *@Description: 根据状态获取订单数量
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param usrid 患者ID
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8081/GZ/consultaion/getorder?pageNo=1&pageSize=12&orderstate=1&usrid=xxx
     */
    @RequestMapping(value="getordersum",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetOrderSum(String usrid){
        SimpleResult simpleResult;
        Map map = new HashMap();
        LOGGER.info("[/consultaion/getordersum]");
        if(StringUtils.isEmpty(usrid)){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入患者ID");
        }
        try {
            map = healthConsultationService.getOrderSum(usrid);
            simpleResult = SimpleResult.success();
            simpleResult.put("data",map);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }


    /**
     *
     *@Title getconsultaion
     *@Description: 根据用户ID获取咨询小结
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param page 患者ID
     *@return SimpleResult
     *@throws
     *@测试地址:http://localhost:8081/GZ/consultaion/getconsultaion?pageNo=1&pageSize=12&usrid=5B2EB74FF5DD94FCE050007F010023D6
     */
    @RequestMapping(value="getconsultaion",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult getConsultaion(PageModel page){
        SimpleResult simpleResult;
        Page p = null;
        LOGGER.info("[/consultaion/getconsultaion]");
        try {
            p = healthConsultationService.getConsultaion(page);
            simpleResult = SimpleResult.success();
            simpleResult.put("data",p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     *
     *@Title getorder
     *@Description: 根据状态获取订单
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param page 订单状态
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8081/GZ/consultaion/getorder?pageNo=1&pageSize=12&orderstate=1&usrid=xxx
     */
    @RequestMapping(value="getorder",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetOrder(PageModel page){
        SimpleResult simpleResult;
        Page p = null;
        LOGGER.info("[/consultaion/ordersubmitted]");
        String usrid = page.getPage().get("usrid").toString();
        if(StringUtils.isEmpty(usrid)){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入患者ID");
        }
        try {
            p = healthConsultationService.getOrderAll(page);
            simpleResult = SimpleResult.success();
            simpleResult.put("data",p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }


    /**
     *
     *@Title CheckDate
     *@Description: 订单提交接口
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param startTime,endTime,userid
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8081/GZ/consultaion/checkDate?userid=5B2EB74FF5DD94FCE050007F010023D6&startTime=11:00&endTime=11:50
     */
    @RequestMapping(value="checkDate",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult CheckDate(String startTime,String endTime,String userid){
        boolean flag = false;
        SimpleResult simpleResult = null;
        if(StringUtils.isEmpty(startTime)){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入预约开始时间!!");
        }
        try {

            flag = healthConsultationService.checkData(startTime,endTime,userid);
            if(flag){
                simpleResult = SimpleResult.success();
                simpleResult.put("flag",true);
            }else{
                simpleResult = SimpleResult.error();
                simpleResult.put("flag",flag);
            }
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return simpleResult;
    }

    /**
     *
     *@Title QualificationPath
     *@Description: 资质认证图片获取
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/qualificationpath
     */
    @RequestMapping(value="qualificationpath",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult QualificationPath(String docid){
        SimpleResult simpleResult=SimpleResult.success();
        simpleResult.putData("imagepath","xuhuiyun");
        return  simpleResult;
    }

    /**
     *
     *@Title UpdateOrder
     *@Description: 订单状态修改
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/updateorder
     */
    @RequestMapping(value="updateorder",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult UpdateOrder(String orderid){
        SimpleResult simpleResult=null;

        if("".equals(orderid)||orderid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "订单ID不能为空！");
        }

        try {
            Boolean booleans=healthConsultationService.UpdateOrderState(orderid);
            if(booleans){
                simpleResult=SimpleResult.success();
            }else {
                simpleResult=SimpleResult.error();
            }

        } catch (CommonException e) {
            e.printStackTrace();
        }

        return simpleResult;
    }


    /**
     *
     *@Title UpdateOrder
     *@Description: 订单状态修改
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/updateorder
     */
    @RequestMapping(value="updateorders",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult UpdateOrders(String orderid,String orderfalg){
        SimpleResult simpleResult=null;

        if("".equals(orderid)||orderid==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "订单ID不能为空！");
        }

        if("".equals(orderfalg)||orderfalg==null){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "订单状态不能为空！");
        }

        try {
            Boolean booleans=healthConsultationService.UpdateOrderState(orderid,orderfalg);
            if(booleans){
                simpleResult=SimpleResult.success();
            }else {
                simpleResult=SimpleResult.error();
            }

        } catch (CommonException e) {
            e.printStackTrace();
        }

        return simpleResult;
    }


    /**
     * 根据ID获取患者详情
     * @param usrid
     * @return
     */
    @RequestMapping(value="getusr",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetUsr(String usrid){
        SimpleResult simpleResult;
        Map<String,String> maps;
        try {
            simpleResult =SimpleResult.success();
            maps=healthConsultationService.GetUsr(usrid);
            simpleResult.putDataAll(maps);
        }catch (CommonException e){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return simpleResult;
    }


    /**
     * 根据医生ID获取排班时间
     * @param docid
     * @return
     * @测试地址: http://localhost:8080/GZ/consultaion/getdoctorform?docid=
     */
    @RequestMapping(value="/getdoctorform",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetDoctorForm(String docid,String formdate){
        SimpleResult simpleResult;
        List<HealthDoctorFormReponse> healthDoctorFormReponseList;
        try {
            simpleResult = SimpleResult.success();
            healthDoctorFormReponseList = healthConsultationService.GetDoctorForm(docid,formdate);
            simpleResult.put("data",healthDoctorFormReponseList);
        }catch (CommonException e){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return simpleResult;
    }


    /**
     *
     *@Title Psychologist
     *@Description: 心理医生列表
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param page(咨询类型 consultationmethod,价格 price,综合排序 comprehensive,医生名 docname)
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/consultaion/testpsychologist?pageNo=1&pageSize=12&consultationmethod=1&price=100,400&comprehensive=1&docname=邓
     */
    @RequestMapping(value="psychologist",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult TestPsychologist(PageModel page){
        SimpleResult simpleResult;
        Page p = page.getPage();
        LOGGER.info("[/consultaion/psychologist]");
        try {
            if(page.getPage().get("usrid") != null){
                HealthActionRecord healthActionRecord = new HealthActionRecord();
                healthActionRecord.setId(UUIDTool.getUUID());
                healthActionRecord.setUsrid(page.getPage().get("usrid").toString());
                healthActionRecord.setModulcode("000001");
                healthActionRecordMapper.insertSelective(healthActionRecord);
            }
            simpleResult=SimpleResult.success();
            p= healthConsultationService.GetPsychoLogist(page);
            simpleResult.putDataAll(p);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        return  simpleResult;
    }

    /**
     * 评价消息点击查看详情
     * jin
     * **/
    @RequestMapping(value = "/querymes", method = RequestMethod.GET,produces="text/html;charset=UTF-8")  
    @ResponseBody
    public SimpleResult querymes(@Valid String orderid) {
    	SimpleResult sr = null;
    	List<HealthConsultationReponse> list = new ArrayList<HealthConsultationReponse>();
		try { 
	       	 list= healthConsultationService.queryMessage(orderid);
			 } catch (Exception e) {
					LOGGER.error(e);
					return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
				}
		          sr = SimpleResult.success();
		          sr.putData("list", list);
		          return sr;
    }

}
