package com.gz.medicine.yun.doctor.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.yun.doctor.bean.DTdoc;
import com.gz.medicine.yun.doctor.bean.DTusr;
import com.gz.medicine.yun.doctor.mapper.DTdocMapper;
import com.gz.medicine.yun.doctor.reponse.DTsickbldtlResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrsReponse;
import com.gz.medicine.yun.doctor.request.*;
import com.gz.medicine.yun.doctor.service.DTCaseHistoryService;
import com.gz.medicine.yun.doctor.service.DTDocService;
import com.gz.medicine.yun.doctor.service.DTDrugsService;
import com.gz.medicine.yun.doctor.service.DTUsrService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTCaseHistoryController
 * @PackageName com.gz.medicine.yun.doctor.controller
 * @Description 病历 Controller
 * @Data 2017-08-17 10:47
 **/
@Controller
@RequestMapping("dtcasehistory")
public class DTCaseHistoryController extends ValidateWithException {


    public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryController.class);


    /**
     * 病历
     */
    @Autowired
    private DTCaseHistoryService dtCaseHistoryService;

    /**
     * 药品
     */
    @Autowired
    private DTDrugsService dtDrugsService;

    /**
     * 用户
     */
    @Autowired
    private DTUsrService dtUsrService;

    @Autowired
    private DTdocMapper dTdocMapper;

    @Autowired
    Validator validator;

    /**
     *
     *@Title AddCaseHistory
     *@Description: 新增患者病历
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param dTsickblhdrRequest,dTsickblhdrRequest
     *@return int
     *@throws
     *@测试: localhost:8996/GZ/dtcasehistory/addcasehistory?drunam="矮地茶"&unit="15克*1"&numnit="包"&pian=2&pc=bid&kfwyname="bid"&guid=4DF7694521DC7FC1E053AA0012AC45DE&name="ckse"&sex="男"&birthday="2017-3-6"&cardid="123465798"&medicalid="36985274"&mainn="这是主诉"&jws="没有既往史"&zhand="诊断1,诊断2,诊断3"
     */
    @RequestMapping(value = "addcasehistory",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult AddCaseHistory(DTsickblhdrRequest dTsickblhdrRequest,DTsickbldtlRequestList dTsickbldtlRequestList){
        SimpleResult simpleResult=null;
        try{
            if(validates(validator, dTsickblhdrRequest)!=null){
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, dTsickblhdrRequest));
            }

            if(dTsickbldtlRequestList.getDts()!=null){
                for (int j=0;j<dTsickbldtlRequestList.getDts().size();j++){
                    DTsickbldtlRequest dTsickbldtlRequest=dTsickbldtlRequestList.getDts().get(j);
                    if(validates(validator, dTsickbldtlRequest)!=null){
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, dTsickbldtlRequest));
                    }
                }
            }
            simpleResult=dtCaseHistoryService.addMedicalRecords(dTsickbldtlRequestList,dTsickblhdrRequest);
            return simpleResult;
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }


    }



    /**
     *
     *@Title AddCaseHistorys
     *@Description: 新增患者病历 方法2
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param map,request
     *@return int
     *@throws
     *@测试: localhost:8996/GZ/dtcasehistory/addcasehistorys?drunam="矮地茶"&unit="15克*1"&numnit="包"&pian=2&pc=bid&kfwyname="bid"&guid=4DF7694521DC7FC1E053AA0012AC45DE&name="ckse"&sex="男"&birthday="2017-3-6"&cardid="123465798"&medicalid="36985274"&mainn="这是主诉"&jws="没有既往史"&zhand="诊断1,诊断2,诊断3"
     */
    @RequestMapping(value = "addcasehistorys",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult AddCaseHistorys(@RequestBody Map map, HttpServletRequest request){
        SimpleResult simpleResult=null;
        try{


            DTsickblhdrRequest dTsickblhdrRequests=new DTsickblhdrRequest();
            DTsickbldtlRequestList dTsickbldtlRequestList=new DTsickbldtlRequestList();

            JSONObject jsonObject=JSONObject.fromObject(map);


            //guid不为空
            if(jsonObject.get("guid")!=null){

                String guid=jsonObject.get("guid").toString();

                //guid的值不为空
                if(!"".equals(guid)&&guid!=null){
                    dTsickblhdrRequests.setGuid(guid);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者ID不能为空！");
                }

            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者ID不能为空！");
            }

            if(jsonObject.get("docid")!=null){
                String docid=jsonObject.get("docid").toString();
                if(!"".equals(docid)&&docid!=null){
                    dTsickblhdrRequests.setDocguid(docid);
                    DTusr dTdoc=dtUsrService.selectByGuid(docid);
                    if(!"".equals(dTdoc)&&dTdoc!=null){
                        dTsickblhdrRequests.setDoc(dTdoc.getName());
                    }
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "医生ID不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "医生ID不能为空！");
            }

            if(jsonObject.get("name")!=null){
                String name=jsonObject.get("name").toString();
                if(!"".equals(name)&&name!=null){
                    dTsickblhdrRequests.setName(name);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者名字不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者名字不能为空！");
            }


            if(jsonObject.get("sex")!=null){
                String sex=jsonObject.get("sex").toString();
                if(!"".equals(sex)&&sex!=null){
                    if("男".equals(sex)){
                        sex="1";
                    }else if("女".equals(sex)){
                        sex="2";
                    }else {
                        dTsickblhdrRequests.setSex(sex);
                    }
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者性别不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者性别不能为空！");
            }



            if(jsonObject.get("birthday")!=null){
                String birthday=jsonObject.get("birthday").toString();
                if(!"".equals(birthday)&&birthday!=null){
                    dTsickblhdrRequests.setBirthday(birthday);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者出生年月不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者出生年月不能为空！");
            }




            if(jsonObject.get("cardid")!=null){
                String cardid=jsonObject.get("cardid").toString();
                if(!"".equals(cardid)&&cardid!=null){
                    dTsickblhdrRequests.setCardid(cardid);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者医保卡号不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者医保卡号不能为空！");
            }



            if(jsonObject.get("medicalid")!=null){
                String medicalid=jsonObject.get("medicalid").toString();
                if(!"".equals(medicalid)&&medicalid!=null){
                    dTsickblhdrRequests.setMedicalid(medicalid);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者就诊卡号不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "患者就诊卡号不能为空！");
            }



            if(jsonObject.get("jws")!=null){
                String jws=jsonObject.get("jws").toString();
                if(!"".equals(jws)&&jws!=null){
                    dTsickblhdrRequests.setJws(jws);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "既往史不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "既往史不能为空！");
            }



            if(jsonObject.get("mainn")!=null){
                String mainn=jsonObject.get("mainn").toString();
                if(!"".equals(mainn)&&mainn!=null){
                    dTsickblhdrRequests.setMainn(mainn);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "主诉不能为空！");
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "主诉不能为空！");
            }


            if(jsonObject.get("zhand")!=null){
                String zhand=jsonObject.get("zhand").toString();
                if(!"".equals(zhand)&&zhand!=null){
                    dTsickblhdrRequests.setZhand(zhand);
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "诊断不能为空！");

                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "诊断不能为空！");
            }

            //将json格式的字符串转换为json数组对象
            JSONArray array=(JSONArray)jsonObject.fromObject(map).get("dts");
            List<DTsickbldtlRequest> tsickbldtlRequestList=new ArrayList<DTsickbldtlRequest>();
            if(array.size()>0){

                for (int i = 0; i <array.size() ; i++) {
                    DTsickbldtlRequest dTsickblhdrRequest=new DTsickbldtlRequest();

                    //取得json数组中的第一个对象
                    JSONObject o = (JSONObject) array.get(i);//获得第一个array结果
                    String drunam =o.getString("drunam");
                    if(!"".equals(drunam)&&drunam!=null){
                        dTsickblhdrRequest.setDrunam(drunam);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "药品名不能为空！");
                    }

                    String unit =o.getString("unit");
                    if(!"".equals(unit)&&unit!=null){
                        dTsickblhdrRequest.setUnit(unit);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "规格不能为空！");
                    }

                    String numnit =o.getString("numnit");
                    if(!"".equals(numnit)&&numnit!=null){
                        dTsickblhdrRequest.setNumnit(numnit);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "数量不能为空！");
                    }


                    String pian =o.getString("pian");
                    if(!"".equals(pian)&&pian!=null){
                        dTsickblhdrRequest.setPian(pian);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "剂量不能为空！");
                    }

                    String pc =o.getString("pc");
                    if(!"".equals(pc)&&pian!=null){
                        dTsickblhdrRequest.setPc(pc);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "频次不能为空！");
                    }

                    String kfwyname =o.getString("kfwyname");
                    if(!"".equals(kfwyname)&&kfwyname!=null){
                        dTsickblhdrRequest.setKfwyname(kfwyname);
                    }else {
                        return SimpleResult.error(SimpleCode.ERROR.getCode(), "途径不能为空！");
                    }
                    
                    tsickbldtlRequestList.add(dTsickblhdrRequest);
                }
            }else {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), "用药方案不能为空!");
            }

            dTsickbldtlRequestList.setDts(tsickbldtlRequestList);
            simpleResult=dtCaseHistoryService.addMedicalRecords(dTsickbldtlRequestList,dTsickblhdrRequests);

        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }

        return simpleResult;

    }

    /**
     *
     *@Title GetCaseHistory
     *@Description: 获取患者病历
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param guid
     *@return int
     *@throws
     *@测试地址: localhost:8996/GZ/dtcasehistory/getcasehistory?guid=AAA9E0A9B207581AE040007F010063F7
     */
    @RequestMapping(value = "getcasehistory",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetCaseHistory(String guid){
        SimpleResult simpleResult=null;

        //病历
        DTsickblhdrsReponse dt=new DTsickblhdrsReponse();

        if(StringUtils.isNotBlank(guid)){
            try {
                dt=dtCaseHistoryService.getMedicalRecordsByGuid(guid);
                if(dt!=null){
                    List<DTsickbldtlResponse> dTsickbldtlResponseList=dtCaseHistoryService.getRegimenByFormGuid(guid);
                    if(dTsickbldtlResponseList.size()>0){
                        dt.setMedication(dTsickbldtlResponseList);
                    }
                }else {
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "暂无数据！");
                }

            } catch (CommonException e) {
                LOGGER.error(e);
                return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
            }
        }else{
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入guid!!!");
        }


        simpleResult=SimpleResult.success();
        simpleResult.put("data",dt);
        return  simpleResult;
    }



    /**
     *
     *@Title GetInterrogation
     *@Description: 问诊详情
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param page
     *@return SimpleResult
     *@throws
     *@测试: localhost:8996/GZ/dtcasehistory/getinterrogation?pageNo=1&pageSize=10&sickguid=AAA9E0A9B207581AE040007F010063F7
     */
    @RequestMapping(value = "getinterrogation",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetInterrogation(PageModel page){

        SimpleResult simpleResult=null;
        Page p=null;

        try{
            p =dtCaseHistoryService.page(page);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }

        simpleResult=SimpleResult.success();
        simpleResult.put("data",p);
        return  simpleResult;
    }


    /**
     *
     *@Title GetProfileDetails
     *@Description: 问诊记录
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param page
     *@return SimpleResult
     *@throws
     *@测试: localhost:8996/GZ/dtcasehistory/getprofileDetails?pageNo=1&pageSize=2&docguid=174BD3D5879C3BF0E050007F010077DC
     */
    @RequestMapping(value = "getprofileDetails",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetProfileDetails(PageModel page){

        SimpleResult simpleResult=null;
        Page p=null;

        try{
            p =dtCaseHistoryService.getProfileDetails(page);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }

        simpleResult=SimpleResult.success();
        simpleResult.put("data",p);
        return simpleResult;
    }


    /**
     *
     *@Title Particulars
     *@Description: 患者详情,根据用户
     *@Author fendo
     *@Date 2017年8月17日 上午10:52
     *@param page
     *@return SimpleResult
     *@throws
     *@测试地址: localhost:8996/GZ/dtcasehistory/getparticulars?pageNo=1&pageSize=10&sickguid=AAA9E0A9B207581AE040007F010063F7
     */
    @RequestMapping(value = "getparticulars",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetParticulars(PageModel page){
        SimpleResult simpleResult=null;
        DTusr usr=null;
        Page p=null;

        String guids=(String) page.getPage().get("sickguid");
        if(StringUtils.isNotBlank(guids)){
            try {

                usr=dtUsrService.selectByGuid(guids);
                //对用户病历进行分页
                p=dtCaseHistoryService.page(page);

                if(p.size()>0){

                    simpleResult=SimpleResult.success();
                    Map<String,String> map=new HashMap<String, String>();
                    map.put("guid",usr.getGuid());
                    map.put("sex",usr.getSex());
                    map.put("mobile",usr.getMobile());
                    map.put("IDCARD",usr.getIdcard());
                    map.put("MEDICARECARD",usr.getMedicarecard());

                    int age=0;

                    //根据身份证获取年龄
                    String idcard=usr.getIdcard();
                    if(!"".equals(idcard)&&idcard!=null){
                        int leh = idcard.length();
                        String dates="";
                        if (leh == 18) {
                            //int se = Integer.valueOf(idcard.substring(leh - 1)) % 2;
                            dates = idcard.substring(6, 10);
                            SimpleDateFormat df = new SimpleDateFormat("yyyy");
                            String year=df.format(new Date());
                            age=Integer.parseInt(year)-Integer.parseInt(dates);
                        }else{
                            dates = idcard.substring(6, 8);
                            age=Integer.parseInt(dates);
                        }

                    }

                    map.put("name",usr.getName());
                    map.put("age",""+age);
                    p.put("usr",map);

                }else{
                    return SimpleResult.error(SimpleCode.ERROR.getCode(), "暂无数据!!!");
                }

            } catch (Exception e) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
            }
        }else {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), "请输入sickguid!!!");

        }

        simpleResult.put("data",p);
        return  simpleResult;
    }


    /**
     *
     *@Title GetDrugs
     *@Description: 药品搜索
     *@Author fendo
     *@Date 2017年8月18日 上午9:00
     *@param page
     *@return SimpleResult
     *@throws
     *@测试地址: localhost:8996/GZ/dtcasehistory/getdrugs?pageNo=1&pageSize=10&name=尼美舒利片
     */
    @RequestMapping(value = "getdrugs",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetDrugs(PageModel page){
        SimpleResult simpleResult=null;
        Page pages=null;

        try{
            pages = dtDrugsService.page(page);
        }catch (Exception e){
            return SimpleResult.error(SimpleCode.ERROR.getCode(), SimpleCode.ERROR.getMessage());
        }

        simpleResult=SimpleResult.success();
        simpleResult.put("data",pages);
        return  simpleResult;
    }

}
