//package com.gz.medicine.yun.doctor.utilTaskTime;
//
//import com.google.gson.Gson;
//import com.gz.medicine.yun.doctor.bean.DTteamsg;
//import com.gz.medicine.yun.doctor.mapper.DTfollowupOptionMapper;
//import com.gz.medicine.yun.doctor.mapper.DTteamsgextMapper;
//import com.gz.medicine.yun.doctor.redisService.RedisDaoService;
//import com.gz.medicine.yun.doctor.service.DTBaseService;
//import org.apache.commons.collections.MapUtils;
//import org.apache.commons.collections.SetUtils;
//import org.apache.commons.collections.map.HashedMap;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.util.StringUtils;
//
//import java.util.*;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Administrator on 2017/8/22 0022.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring.xml"})
//public class updateOracleDataTest {
//
//    @Autowired
//    RedisDaoService redisdaoservice;
//    @Autowired
//    DTBaseService dtbaseservice;
////    @Autowired
////    DTfollowupOptionMapper dtfollowupoptionmapper;
//
//    @Test
//    public void updateData() {
//        try {
//            //1.获取所有key的数量分页批量更新
//            LinkedHashSet<String> setLi = (LinkedHashSet<String>) redisdaoservice.keys("DTteamsg:*");
//            int totalSize = setLi.size();
//            Gson gn = new Gson();
//            int pageSize = 100;
//            int i = 0;
//            int pageNo = 1;
//            List<Map<String, Object>> dgLi = new ArrayList<Map<String, Object>>();
//            List<String> keys=new ArrayList<String>();
//            for (String s : setLi) {
//                i++;
//                keys.add(s);
//                DTteamsg dg = (DTteamsg) redisdaoservice.get(s);
//                dg.setCrtdat(null);
//                dg.setTeamguid(null);
//                if (StringUtils.isEmpty(dg.getBlguid())) {
//                    dg.setBlobguid("00000000");
//                }
//                if (StringUtils.isEmpty(dg.getBlguid())) {
//                    dg.setBlguid("00000000");
//                }
//                String dgJson = gn.toJson(dg);
//                TreeMap<String, Object> dgMp = gn.fromJson(dgJson, TreeMap.class);
//                dgLi.add(dgMp);
//                if (i == pageNo * pageSize || i == totalSize) {//101
//                    pageNo++;
//                    Map<String, Object> mp = new HashedMap();
//                    mp.put("tableName", "CHIS_TEAMSG");//聊天消息表
//                    mp.put("cloumn", dgLi.get(0).keySet());//聊天消息表
//                    mp.put("val", dgLi);
//                    dtbaseservice.insertByTableName(mp);
//                    redisdaoservice.del(keys);
//                    keys.clear();
//                    dgLi.clear();
//                }
//            }
//
//        } catch (Exception e) {
//        }
//
//    }
//
//
//}