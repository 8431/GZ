package com.gz.medicine.yun.doctor.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.yun.doctor.bean.DTdru;
import com.gz.medicine.yun.doctor.bean.DTsickbldtl;
import com.gz.medicine.yun.doctor.bean.DTsickblhdr;
import com.gz.medicine.yun.doctor.mapper.DTsickbldtlMapper;
import com.gz.medicine.yun.doctor.mapper.DTsickblhdrMapper;
import com.gz.medicine.yun.doctor.reponse.DTsickbldtlResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrResponse;
import com.gz.medicine.yun.doctor.reponse.DTsickblhdrsReponse;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequest;
import com.gz.medicine.yun.doctor.request.DTsickbldtlRequestList;
import com.gz.medicine.yun.doctor.request.DTsickblhdrRequest;
import com.gz.medicine.yun.doctor.service.DTCaseHistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName DTCaseHistoryServiceImpl
 * @PackageName com.gz.medicine.yun.doctor.service.impl
 * @Description 病历实现类
 * @Data 2017-08-17 14:18
 **/
@Service
public class DTCaseHistoryServiceImpl implements DTCaseHistoryService {


    public static final Logger LOGGER = Logger.getLogger(DTCaseHistoryServiceImpl.class);

    //病例接口
    @Autowired
    private DTsickblhdrMapper dTsickblhdrMapper;


    //药品接口
    @Autowired
    private DTsickbldtlMapper dTsickbldtlMapper;


    @Override
    public Page page(PageModel page) throws CommonException {
        Page p=page.getPage();
        List<DTsickblhdrResponse> lists=dTsickblhdrMapper.queryPageGuids(p);
        p.setParameterType(lists);
        return p;
    }

    @Override
    public SimpleResult addMedicalRecords(DTsickbldtlRequestList dTsickbldtlRequestList, DTsickblhdrRequest dTsickblhdrRequest) throws CommonException {
        SimpleResult simpleResult=null;
        String uuid=UUIDTool.getUUID();
        try{

            //病历
            DTsickblhdr dTsickblhdr=new DTsickblhdr();

            dTsickblhdr.setGuid(uuid);

            //医生名字
            dTsickblhdr.setDoc(dTsickblhdrRequest.getDoc());
            //患者姓名
            dTsickblhdr.setName(dTsickblhdrRequest.getName());
            //性别
            dTsickblhdr.setSex(dTsickblhdrRequest.getSex());
            //出生年月
            dTsickblhdr.setBirthday(dTsickblhdrRequest.getBirthday());
            //医保卡号
            dTsickblhdr.setCardid(dTsickblhdrRequest.getCardid());
            //就诊卡号
            dTsickblhdr.setMedicalid(dTsickblhdrRequest.getMedicalid());
            //主诉
            dTsickblhdr.setMainn(dTsickblhdrRequest.getMainn());
            //既往史
            dTsickblhdr.setJws(dTsickblhdrRequest.getJws());
            //诊断
            dTsickblhdr.setZhand(dTsickblhdrRequest.getZhand());

            //患者id
            dTsickblhdr.setSickguid(dTsickblhdrRequest.getGuid());

            dTsickblhdr.setDocguid(dTsickblhdrRequest.getDocguid());

            //设置部门
            dTsickblhdr.setAcc("CHIS");
            dTsickblhdr.setOrg("CHIS");

            //创建日期
            dTsickblhdr.setCrtdat(new Date());

            dTsickblhdr.setWdat(new Date());

            //插入病历
            dTsickblhdrMapper.insert(dTsickblhdr);

            //用药方案
            if(dTsickbldtlRequestList.getDts()!=null){
                for (int i=0;i<dTsickbldtlRequestList.getDts().size();i++){

                    DTsickbldtlRequest dTsickbldtlRequest=dTsickbldtlRequestList.getDts().get(i);

                    //用药方案
                    DTsickbldtl dTsickbldtl=new DTsickbldtl();

                    //设置guid
                    dTsickbldtl.setGuid(UUIDTool.getUUID());

                    //设置关联关系
                    dTsickbldtl.setFormguid(uuid);
                    //药品名
                    dTsickbldtl.setDrunam(dTsickbldtlRequest.getDrunam());

                    //规格
                    dTsickbldtl.setUnit(dTsickbldtlRequest.getUnit());

                    //数量
                    dTsickbldtl.setNumnit(dTsickbldtlRequest.getNumnit());

                    //剂量
                    dTsickbldtl.setPian(dTsickbldtlRequest.getPian());

                    //频次
                    dTsickbldtl.setPc(dTsickbldtlRequest.getPc());

                    //途径
                    dTsickbldtl.setKfwyname(dTsickbldtlRequest.getKfwyname());

                    dTsickbldtlMapper.insert(dTsickbldtl);
                }
            }

        }catch (Exception e){
            LOGGER.error("新增病历时出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }

        simpleResult=SimpleResult.success();
        simpleResult.put("guid",uuid);
        return simpleResult;
    }



    @Override
    public DTsickblhdrsReponse getMedicalRecordsByGuid(String guid) throws CommonException {

        DTsickblhdrsReponse dTsickblhdr;
        try{
            dTsickblhdr  = dTsickblhdrMapper.selectByGuid(guid);
        }catch (Exception e){
            LOGGER.error("获取患者病历时出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }
        return dTsickblhdr;
    }

    @Override
    public Page getProfileDetails(PageModel page) throws CommonException {

        List<DTsickblhdrResponse> dTsickblhdrResponseList=null;
        Page p=page.getPage();
        try{

            dTsickblhdrResponseList=dTsickblhdrMapper.queryPagedocGuid(p);
            p.setParameterType(dTsickblhdrResponseList);
        }catch (Exception e){
            LOGGER.error("问诊记录时出现异常："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }

        return p;
    }

    @Override
    public List<DTsickbldtlResponse> getRegimenByFormGuid(String formguid) throws CommonException {

        List<DTsickbldtlResponse> dTsickbldtlResponseList;
        try{
            dTsickbldtlResponseList =dTsickbldtlMapper.selectByformGuid(formguid);
        }catch (Exception e){
            LOGGER.error("根据guid获取用药方案："+e.getMessage(),e);
            throw new CommonException("COM001","在执行SQL时出现异常",e);
        }

        return dTsickbldtlResponseList;
    }
}
