//package com.gz.medicine.yun.doctor.service.impl;
//
//import com.gz.medicine.yun.doctor.bean.DTteamsg;
//import com.gz.medicine.yun.doctor.redisService.RedisDaoService;
//import com.gz.medicine.yun.doctor.redisService.impl.NewRole;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.SessionCallback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Administrator on 2017/8/18 0018.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring.xml"})
//public class DtDoctorQuanServiceImplTest {
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    RedisDaoService redisdaoservice;
//    @Test
//    public void insertDTteamsg() throws Exception {
//        Object o=redisTemplate.keys("DTteamsg*");
//        Set<String> sLi= (Set<String>) redisTemplate.keys("DTteamsg*");
//        for(String s:sLi){
//            System.out.println(s);
//        }
//        redisTemplate.delete(sLi);
//    }
//
//}