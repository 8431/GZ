package com.gz.medicine.yun.doctor.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.mapper.DTfollowupOptionMapper;
import com.gz.medicine.yun.doctor.mapper.DTfollowupPlanMapper;
import com.gz.medicine.yun.doctor.request.DTfollowupPlanRequest;
import com.gz.medicine.yun.doctor.service.DTDoctorSfhzglService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/8/19 0019.
 */
@Service("DTDoctorSfhzglService")
public class DTDoctorSfhzglServiceImpl implements DTDoctorSfhzglService {
    public static final Logger LOGGER = Logger.getLogger(DTDoctorSfhzglServiceImpl.class);

    @Autowired
    DTfollowupOptionMapper dtfollowupoptionmapper;
    @Autowired
    DTfollowupPlanMapper dtfollowupplanmapper;

    @Override
    public SimpleResult queryPageSfhzgl(PageModel pm) throws CommonException {
        SimpleResult sr = null;
        Page pe = pm.getPage();
        List<Map<String, Object>> mpLi = null;
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpLi = dtfollowupoptionmapper.queryPageSfhzgl(pe);
            if (mpLi != null && mpLi.size() > 0) {
                for (int i = 0; i < mpLi.size(); i++) {
                    String sickguid = (String) mpLi.get(i).get("sickguid");
                    pe.put("usrguid", sickguid);
                    Map<String, Object> mpMange = dtfollowupoptionmapper.querySfjlList(pe);
                    if(mpMange!=null){
                        mpMange.put("R", i + 1);
                    }
                    mpMangeLi.add(mpMange);
                }

            }
            pe.setParameterType(mpMangeLi);
            sr = SimpleResult.success();
            sr.put("data", pe);
        } catch (Exception e) {
            LOGGER.error("分页查询随访患者管理Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "分页查询随访患者管理Server层异常:" ,e);
        }
        return sr;
    }

    @Override
    public SimpleResult insertDTfollowupPlan(List<DTfollowupPlan> dpLi) throws CommonException {
        SimpleResult sr = null;
        //最多12条记录，所以不做批量新增更新
        for (DTfollowupPlan d : dpLi) {
            try {
                //判断更新还是新增
                String guid = d.getGuid();
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                if (!StringUtils.isEmpty(d.getFollowtime())) {
                    Date time = date.parse(d.getFollowtime());
                    d.setFollowdatetime(time);
                }

                if (StringUtils.isEmpty(guid)) {
                    d.setGuid(null);
                    d.setCrtdat(new Date());
                    dtfollowupplanmapper.insertSelective(d);
                } else {
                    //更新
                    d.setUpdatedate(new Date());
                    dtfollowupplanmapper.updateByPrimaryKeySelective(d);
                }
                sr = SimpleResult.success();
            } catch (Exception e) {
                LOGGER.error("新增随访记录异常：" + e.getMessage(), e);
                throw new CommonException("COM001", "新增随访记录Server层异常:" ,e);
            }

        }
        return sr;
    }

    @Override
    public SimpleResult querySfjhList() throws CommonException {
        SimpleResult sr = null;
        try {
            List<Map<String, Object>> li = dtfollowupoptionmapper.querySfjhList();
            sr = SimpleResult.success();
            sr.put("data", li);
        } catch (Exception e) {
            LOGGER.error("查询随访计划，项目列表：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询随访计划，项目列表:" ,e);
        }
        return sr;
    }

    @Override
    public SimpleResult queryPageHzsfjh(PageModel pm) throws CommonException {
        SimpleResult sr = null;
        Page pe = pm.getPage();
        List<Map<String, Object>> mpLi = null;
        try {
            mpLi = dtfollowupplanmapper.queryPageHzsfjh(pe);
            pe.setParameterType(mpLi);
            sr = SimpleResult.success();
            sr.put("data", pe);
        } catch (Exception e) {
            LOGGER.error("分页查询随访患者管理Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "分页查询随访患者管理Server层异常:" ,e);
        }
        return sr;
    }




    /**
     * 云随访诊室结束随访接口 根据患者GUID  serviceImp层
     *
     * @author 舵主
     */
    @Override
    public SimpleResult setFollowUpEnd(DTfollowupPlanRequest data) throws CommonException {
        SimpleResult simpleResult = null;
        DTfollowupPlan dTfollowupPlan = new DTfollowupPlan();
        try {
            BeanUtils.copyProperties(data, dTfollowupPlan);
            dtfollowupplanmapper.setFollowUpEnd(dTfollowupPlan);
        } catch (Exception e) {
            LOGGER.error("随访任务发送短信：" + e.getMessage(), e);
            throw new CommonException("COM001", "在执行SQL时出现异常:" ,e);
        }
        return simpleResult;
    }


    @Override
    public SimpleResult queryPlan(String docguid, String usrguid) throws CommonException {
        SimpleResult sr = null;
        Map<String, Object> m = new HashedMap();
        List<Map<String, Object>> plan = null;
        try {
            plan = dtfollowupplanmapper.queryPlan(docguid, usrguid);
            Map<String, Object> usrmp = dtfollowupplanmapper.queryUsrDetail(usrguid);
            sr = SimpleResult.success();
            m.put("usrDetail", usrmp);
            m.put("sfjhDetail", plan);
            sr.put("data", m);
        } catch (Exception e) {
            LOGGER.error("获取患者随访计划异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "获取患者随访计划异常:" ,e);
        }
        return sr;
    }

    @Override
    public SimpleResult querySfjhToYzs(String guid) throws CommonException {
        SimpleResult sr=null;
        try {
        if(StringUtils.isEmpty(guid)){
            sr=SimpleResult.error("001","guid不能为空");
        }else{
            DTfollowupPlan dp= dtfollowupplanmapper.selectByPrimaryKey(guid);
            if(dp==null||dp.getDocguid()==null||dp.getUsrguid()==null||dp.getSicguid()==null){
                throw new CommonException("没有找到该医生信息，请检查guid合法性");
            }
            Map<String,Object> doc=dtfollowupplanmapper.queryDoctor(dp.getDocguid());
            Map<String,Object> usr= dtfollowupplanmapper.queryUsrDetail(dp.getUsrguid());
            Map<String,Object> sic= dtfollowupplanmapper.querySic(dp.getSicguid());

            if(doc!=null){
                if(usr!=null){
                    doc.put("usrName",usr.get("name"));
                    doc.put("usrAge",usr.get("age"));
                    doc.put("usrSex",usr.get("sex"));

                }
                if(sic!=null){
                    doc.put("zdnam",sic.get("zdnam"));
                    doc.put("sicguid",dp.getSicguid());
                }
                doc.put("followoption",dp.getFollowoption());

            }
            sr=SimpleResult.success();
            sr.put("data",doc);
             }
        } catch (Exception e) {
            LOGGER.error("云诊室随访计划详情异常：" + e.getMessage(), e);
            throw new CommonException("COM001", e.getMessage() ,e);
        }
        return sr;
    }


}
