package com.gz.medicine.gzyun.heaman.service.impl;


import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkPermsgRecord;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkReport;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkSetTable;
import com.gz.medicine.gzyun.heaman.bean.HmReportVo;
import com.gz.medicine.gzyun.heaman.mapper.HmGzjkPermsgRecordMapper;
import com.gz.medicine.gzyun.heaman.mapper.HmGzjkReportMapper;
import com.gz.medicine.gzyun.heaman.mapper.HmGzjkSetTableMapper;
import com.gz.medicine.gzyun.heaman.service.HmGzjkPermsgRecordService;
import com.gz.medicine.gzyun.user.bean.Usr;
import com.gz.medicine.gzyun.user.mapper.UsrMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by dlf on 2017/8/7 0007.
 */
@Service("GzjkPermsgRecordService")
public class HmGzjkPermsgRecordServiceImpl implements HmGzjkPermsgRecordService {
    @Autowired
    private HmGzjkPermsgRecordMapper gzjkpermsgrecordmapper;
    @Autowired
    private UsrMapper usrmapper;
    @Autowired
    private HmGzjkReportMapper gzjkreportmapper;
    @Autowired
    private HmGzjkSetTableMapper hmgzjksettablemapper;
    public static final Logger LOGGER = Logger.getLogger(HmGzjkPermsgRecordServiceImpl.class);


    public List<HmGzjkPermsgRecord> selectByPrimaryKeyUsrGuid(String guid) throws CommonException {
        List<HmGzjkPermsgRecord> li=null;
        try {
            li=gzjkpermsgrecordmapper.selectByPrimaryKeyUsrGuid(guid);
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：selectByPrimaryKeyUsrGuid）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：selectByPrimaryKeyUsrGuid）");
        }
        return li;
    }

    public String updatePersonMsg(HmGzjkPermsgRecord gd)  throws CommonException {
        String result=null;
        String guid=gd.getUsrguid();
        Integer type=gd.getType();
        try{
            int   total = gzjkpermsgrecordmapper.selectTotalSize(guid);
            if(total>0){
                if(type>0&&type<14){
                    gzjkpermsgrecordmapper.updateByPrimaryKeySelective(gd);
                }else{
                    return "-2";
                }
            }else{
                gzjkpermsgrecordmapper.insertSelective(gd);

            }
            if(type==1){
                Usr u=new Usr();
                u.setGuid(gd.getUsrguid());
                u.setName(gd.getName());
                u.setSex(gd.getSex());
                u.setIdcard(gd.getIdcard());
                u.setMobile(gd.getMobile());
                usrmapper.updateByUsrguidAndChis(u);
            }

        }catch (Exception e){
            LOGGER.error("执行sql异常（方法：updatePersonMsg）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：updatePersonMsg）");
        }
         result="0";
        return result;
    }

    @Override
    public List<HmGzjkReport> selectGzjkReportMsg(String guid) throws CommonException {
        List<HmGzjkReport> li=null;
        try {
             li=gzjkreportmapper.selectGzjkReportMsg(guid);
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：selectGzjkReportMsg）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：selectGzjkReportMsg）");

        }
        return li;
    }

    @Override
    public List<HmReportVo> getHealthyDetail(String guid) throws CommonException {
        List<HmReportVo> hrLi= null;
        try {
            hrLi = gzjkreportmapper.getHealthyDetail(guid);
            if(hrLi!=null&&hrLi.size()>0){
                for(HmReportVo h:hrLi){
                    if(!StringUtils.isEmpty(h.getJdusr())){
                        h.setJdusrnam(usrmapper.getNamebyName(h.getJdusr()));
                    }
                }
            }
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：getHealthyDetail）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：getHealthyDetail）");
        }

        return hrLi;
    }

    @Override
    public List<HmReportVo> getHeaPlanList(String guid) throws CommonException {
        List<HmReportVo> li=null;
        try {
             li=gzjkreportmapper.getHeaPlanList(guid);
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：getHeaPlanList）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：getHeaPlanList）");
        }
        return li;
    }

    @Override
    public List<HmReportVo> getHeaPlanDetails(String guid) throws CommonException {
        List<HmReportVo> hrLi= null;
        try {
            hrLi = gzjkreportmapper.getHeaPlanDetails(guid);
            if(hrLi!=null&&hrLi.size()>0){
                for(HmReportVo h:hrLi){
                    if(!StringUtils.isEmpty(h.getJdusr())){
                        String name=usrmapper.getNamebyName(h.getJdusr());
                        h.setJdusrnam(name);
                    }
                }
            }
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：getHeaPlanDetails）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：getHeaPlanDetails）");
        }

        return hrLi;
    }

    @Override
    public List<HmGzjkSetTable> getComBo() throws CommonException {
        List<HmGzjkSetTable> li=null;
        try {
             li=hmgzjksettablemapper.getCombo();
        } catch (CommonException e) {
            LOGGER.error("执行sql异常（方法：getComBo）"+e.getMessage(),e);
            throw new CommonException("COM001","执行sql异常（方法：getComBo）");
        }
        return li;
    }
}