//package com.gz.medicine.gzyun.heaman.service.impl;
//
//import com.google.gson.Gson;
//import com.gz.medicine.common.util.SimpleResult;
//import com.gz.medicine.gzyun.heaman.bean.HmGzjkPermsgRecord;
//import com.gz.medicine.gzyun.heaman.bean.HmGzjkReport;
//import com.gz.medicine.gzyun.heaman.bean.HmGzjkSetTable;
//import com.gz.medicine.gzyun.heaman.bean.HmReportVo;
//import com.gz.medicine.gzyun.heaman.service.HmGzjkPermsgRecordService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by dlf on 2017/8/8 0008.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring.xml"})
//public class GzjkPermsgRecordServiceImplTest {
//    @Autowired
//    private HmGzjkPermsgRecordService gzjkpermsgrecordservice;
//
//    /**
//     * by dlf
//     * 九、	基本健康档案信息查询接口（查询）
//     */
//    @Test
//    public void selectByPrimaryKeyUsrGuid() throws Exception {
//        String uuid="5328C0D374EE512FE050A8C08700F41E";
//        List<HmGzjkPermsgRecord> hrLi=gzjkpermsgrecordservice.selectByPrimaryKeyUsrGuid(uuid);
//        SimpleResult sr = SimpleResult.success();;
//        if(hrLi!=null&&hrLi.size()>0){
//            sr.put("code","0");
//            sr.put("msgcode","");
//            sr.put("content",hrLi);
//        }else{
//            sr.put("code","1");
//            sr.put("data",hrLi);
//            sr.put("content","查询无数据");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//    }
//    /**
//     * by dlf
//     *十、	个人信息写入接口（写入）
//     */
//    @Test
//    public void updatePersonMsg() throws Exception {
//        HmGzjkPermsgRecord hd=new HmGzjkPermsgRecord();
//        hd.setMobile("854212");
//        hd.setAge("11");
//        hd.setSex("1");
//        hd.setIdcard("785215452252152");
//        hd.setName("小鱼");
//        hd.setType(1);//测试从type=1-13
//        hd.setUsrguid("A42B93850FCE050A8C0E236B4");
//        String result=gzjkpermsgrecordservice.updatePersonMsg(hd);
//        SimpleResult sr = SimpleResult.success();;
//        if("0".equals(result)){
//            sr.put("code",result);
//            sr.put("msgcode","成功");
//        }
//        if("-2".equals(result)){
//            sr.put("code",result);
//            sr.put("msgcode","TYPE错误");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//    }
//    /**
//     * by dlf
//     * 十一、	健康评估列表接口 （查询）
//     */
//    @Test
//    public void selectGzjkReportMsg() throws Exception {
//        String uuid="51E7145836F8F227E050A8C0E600132F";
//        List<HmGzjkReport> result=gzjkpermsgrecordservice.selectGzjkReportMsg(uuid);
//        SimpleResult sr = SimpleResult.success();;
//        if(result!=null&&result.size()>0){
//            sr.put("content",result);
//            sr.put("code","0");
//        }else{
//            sr.put("content","没有您的健康评估");
//            sr.put("code","1");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//
//    }
//    /**
//     * by dlf
//     *十二、	健康评估详情接口 （查询）
//     */
//    @Test
//    public void getHealthyDetail() throws Exception {
//        String uuid="532A639532D61B1DE050A8C08700FD39";
//        List <HmReportVo> result= gzjkpermsgrecordservice.getHealthyDetail(uuid);
//        SimpleResult sr = SimpleResult.success();;
//        if(result!=null&&result.size()>0){
//            sr.put("content",result);
//            sr.put("code","0");
//        }else{
//            sr.put("content","没有您的健康评估");
//            sr.put("code","1");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//
//
//
//    }
//    /**
//     * by dlf
//     *十三、	健康方案列表接口 （查询）
//     */
//    @Test
//    public void getHeaPlanList() throws Exception {
//        String uuid="51E7145836F8F227E050A8C0E600132F";
//        List <HmReportVo> result= gzjkpermsgrecordservice.getHeaPlanList(uuid);
//        SimpleResult sr = SimpleResult.success();;
//        if(result!=null&&result.size()>0){
//            sr.put("content",result);
//            sr.put("code","0");
//        }else{
//            sr.put("content","没有您的健康评估");
//            sr.put("code","1");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//
//    }
//    /**
//     * by dlf
//     *十四、	健康方案详情接口 （查询）
//     */
//    @Test
//    public void getHeaPlanDetails() throws Exception {
//        String uuid="532A639532D61B1DE050A8C08700FD39";
//        List <HmReportVo> result= gzjkpermsgrecordservice.getHeaPlanDetails(uuid);
//        SimpleResult sr = SimpleResult.success();;
//        if(result!=null&&result.size()>0){
//            sr.put("content",result);
//            sr.put("code","0");
//        }else{
//            sr.put("content","没有您的健康评估");
//            sr.put("code","1");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//
//    }
//    /**
//     * by dlf
//     *十五、	套餐接口 （查询）
//     */
//    @Test
//    public void getComBo() throws Exception {
//        List <HmGzjkSetTable> result= gzjkpermsgrecordservice.getComBo();
//        SimpleResult sr = SimpleResult.success();;
//        if(result!=null&&result.size()>0){
//            sr.put("data",result);
//        }else{
//            sr.put("data","没有您的健康评估");
//        }
//        Gson gn=new Gson();
//        System.out.println(gn.toJson(sr));
//    }
//
//}