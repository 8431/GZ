package com.gz.medicine.gzyun.health.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.bean.*;
import com.gz.medicine.gzyun.health.mapper.*;
import com.gz.medicine.gzyun.health.reponse.HealthLogIdReponse;
import com.gz.medicine.gzyun.health.request.HealthDoctorFormRequest;
import com.gz.medicine.gzyun.health.request.HealthPushMessageVo;
import com.gz.medicine.gzyun.health.service.HealthAdminServer;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by dlf on 2017/10/28 0028.
 * Email 1429264916@qq.com
 */
@Service("HealthAdminServer")
public class HealthAdminServerImpl implements HealthAdminServer {
    @Autowired
    HealthDoctorFormMapper healthdoctorformmapper;
    @Autowired
    HealthyOrderMapper healthyordermapper;
    @Autowired
    HealthInvoiceRecordMapper healthinvoicerecordmapper;
    @Autowired
    OrderLogMapper orderlogmapper;
    @Autowired
    healthDoctorMapper healthdoctormapper;
    @Autowired
    HealthyLoginMapper healthyloginmapper;
    public static final Logger LOGGER = Logger.getLogger(HealthAddrInfoServiceImpl.class);


    @Override
    public HealthPushMessageVo insertDocFromAndLog(List<HealthDoctorFormRequest> request) throws CommonException {
        HealthPushMessageVo hg=new HealthPushMessageVo();
        hg.setId(UUIDTool.getUUID());
        hg.setPushmessage("您的排班已更新，点击查看详情!");
        hg.setMessagename("系统消息");
        hg.setMessagetype("1");
        hg.setCreatedate(new Date());
        hg.setPushtime(new Date());
        hg.setUserid(request.get(0).getDocid());
        hg.setPushtype("5");
        try {
            //数据量较少，循坏操作。占时不做批量处理,傻逼式处理
              Set<HealthDoctorForm> insertli=new HashSet<HealthDoctorForm>();
            for (HealthDoctorFormRequest r : request) {
                HealthDoctorForm hf = new HealthDoctorForm();
                BeanUtils.copyProperties(r, hf);
                //手动设置uuid
                String uuid = UUIDTool.getUUID();
                hf.setId(uuid);
                //已预约的不能删除
                String state=healthdoctorformmapper.queryDocFormFormstate(hf);
                if(!"1".equals(state)){
                    healthdoctorformmapper.deleteHistory(hf);
                    insertli.add(hf);
                }else{
                    LOGGER.info(hf.getDocid()+"该医生"+hf.getFormstate()+hf.getFormstarttime()+"-"+hf.getFormendtime()+"时间段已被预约，不能新增");
                }
            }
            for(HealthDoctorForm f:insertli){
                healthdoctorformmapper.insertSelective(f);
            }

        } catch (Exception e) {
            LOGGER.error("排版新增异常:" + e.getMessage(), e);
            throw new CommonException("001", "排版新增异常", e);
       }
        return hg;
    }

    @Override
    public List<Map<String, Object>> queryScheduling(String date, String name) throws CommonException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Map paramMp = new HashedMap();
            paramMp.put("formdate", date);
            paramMp.put("docname", name);
            List<Map<String, Object>> li = healthdoctorformmapper.queryDocFormByDate(paramMp);
            if (li != null && li.size() > 0) {
                for (Map<String, Object> m : li) {
                    Map<String, Object> map = new HashedMap();
                    String formdate = (String) m.get("formdate");
                    String docnameArr = (String) m.get("docname");
                    String docidArr = (String) m.get("docid");
                    Map<String, Object> dateMp = new HashedMap();
                    List<Map<String, String>> doclist = getList2(docnameArr, docidArr);
                    dateMp.put("name", doclist);
                    dateMp.put("time", formdate);
                    list.add(dateMp);
                }
            }

        } catch (Exception e) {
            LOGGER.error("排版查询异常:" + e.getMessage(), e);
            throw new CommonException("001", "排版查询异常", e);
        }
        return list;

    }

    @Override
    public List<Map<String, Object>> queryDocFormBy(String date, String docid) throws CommonException {
        if (StringUtils.isEmpty(docid) || StringUtils.isEmpty(date)) {
            throw new CommonException("docid和date不能为空");
        }
        List<Map<String, Object>> li = new ArrayList<Map<String, Object>>();
        try {
            li = healthdoctorformmapper.queryDocFormByDocidAndDate(date, docid);
        } catch (Exception e) {
            LOGGER.error("排版时间段查询异常:" + e.getMessage(), e);
            throw new CommonException("001", "排版时间段查询异常", e);
        }


        return li;
    }

    @Override
    public void deleteForm(String id) throws CommonException {
        if (StringUtils.isEmpty(id)) {
            throw new CommonException("id不能为空");
        }
        HealthDoctorForm hm = null;
        try {
            hm = healthdoctorformmapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            LOGGER.error("删除订单异常:" + e.getMessage(), e);
            throw new CommonException("001", "排版时间段查询异常", e);
        }
        if (hm != null) {
            String state = hm.getFormstate();
            if (!"1".equals(state)) {
                hm.setState("0");
                hm.setUpdatedate(new Date());
                healthdoctorformmapper.updateByPrimaryKeySelective(hm);
                //throw new CommonException();
            } else {
                throw new CommonException("预约的排版不能删除！");
            }
        } else {
            throw new CommonException("id错误，没有查到该id的数据，无法删除");
        }

    }

    @Override
    public Page queryPageOrderForMoHo(PageModel p) throws CommonException {
        Page pe = p.getPage();
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = healthyordermapper.queryPageOrderForMoHoForV2(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("后台订单管理订单Server层异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "后台订单管理订单Server层异常:", e);
        }
        return pe;
    }

    @Override
    public Map<String, Object> queryOrderManageDetail(String id) throws CommonException {
        if (StringUtils.isEmpty(id)) {
            throw new CommonException("订单id不能为空");
        }
        Map<String, Object> mp=new HashedMap();
        try {
            //发票记录
            HealthInvoiceRecord hir=healthinvoicerecordmapper.queryHealthInvoiceRecordForOrderId(id);
            //订单日志记录
            List<HealthLogIdReponse> orderLogLi=orderlogmapper.queryItemByIdSelLog(id);

            Map<String,Object> orderMsg=healthyordermapper.queryOrderById(id);
            //订单信息
            Map<String,Object> orderMsgMp=new HashedMap();
            //预约信息
            Map<String,Object> yuyueMsgMp=new HashedMap();
            if(orderMsg!=null&&orderMsg.size()>0){
                //订单信息数据加载
                orderMsgMp.put("consultationmethodname",orderMsg.get("consultationmethodname"));//商品名称
                orderMsgMp.put("createdate",orderMsg.get("createdate"));//订单日期
                orderMsgMp.put("ordercode",orderMsg.get("ordercode"));//订单编号
                orderMsgMp.put("orderamount",orderMsg.get("orderamount"));//订单金额
                //预约信息数据加载
                yuyueMsgMp.put("usrname",orderMsg.get("usrname"));//姓名
                yuyueMsgMp.put("usrsex",orderMsg.get("usrsex"));//性别
                yuyueMsgMp.put("usrbirth",orderMsg.get("usrbirth"));//出生年月
                yuyueMsgMp.put("usrphone",orderMsg.get("usrphone"));//联系方式
                yuyueMsgMp.put("reservationdate",orderMsg.get("reservationdate"));//预约日期
                yuyueMsgMp.put("reservationtime",orderMsg.get("reservationtime"));//时间 09:00-09:50
                yuyueMsgMp.put("docname",orderMsg.get("docname"));//预约医生
                yuyueMsgMp.put("orderstate",orderMsg.get("orderstate"));//订单状态
                yuyueMsgMp.put("orderid",orderMsg.get("orderid"));//订单ID
            }
            mp.put("invoicerecord",hir);
            mp.put("orderLog",orderLogLi);
            mp.put("orderMsgMp",orderMsgMp);
            mp.put("yuyueMsgMp",yuyueMsgMp);
        } catch (Exception e) {
            LOGGER.error("查询发票记录列表异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询发票记录列表异常:", e);
        }

        return mp;
    }

    @Override
    public Page queryYuYue(PageModel p) throws CommonException {
        Page pg=p.getPage();
        try {
            List<Map<String, Object>> resultLi=healthdoctorformmapper.queryPageYuYue(pg);
            List<Map<String, Object>> liArr=new ArrayList<Map<String, Object>>();
            if(resultLi!=null&&resultLi.size()>0){
                for(Map<String, Object> m:resultLi){
                    String docname = (String) m.get("name");//排班医生
                    String formtimesArr = (String) m.get("formtimes");//排班时段
                    String formstateArr = (String) m.get("formstate");//预约情况
                    List<Map<String, String>> listMp=getList(formtimesArr,formstateArr);
                    Map<String,Object> mp=new HashedMap();
                    mp.put("usrname",docname);
                    //为了迎合傻逼的前端格式
                    mp.put("orderid","22222");
                    for(Map<String, String> n:listMp){
                        String time=n.get("docname");
                        String timeKey=time.replaceAll(":","x").replaceAll("-","y");
                        String state=null;
                        if("已预约".equals(n.get("docid"))){
                            state="<span style='color:blue'>";
                        }
                        if("已停诊".equals(n.get("docid"))){
                            state="<span style='color:red'>";
                        }
                        if("未预约".equals(n.get("docid"))){
                            state="<span style='color:black'>";
                        }
                        mp.put("t"+timeKey,state+n.get("docid")+"</span>");

                    }
                    liArr.add(mp);
                }
            }
            pg.setParameterType(liArr);

        } catch (Exception e) {
            LOGGER.error("预约管理查询列表异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "预约管理查询列表异常:", e);        }
        return pg;
    }

    @Override
    public HealthyLogin loginAdminManage(String name, String password) throws CommonException {
        HealthyLogin hn=null;
        try {
            hn=healthyloginmapper.login(name,password);
            if(hn==null){
                throw new CommonException("用户名或者密码错误");
            }else{
                hn.setPassword(null);
            }
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException("COM001", e.getMessage(), e);
            } else {
                throw new CommonException("COM001", "登录异常:", e);
            }
        }
        return hn;
    }

    private  List<Map<String, String>> getList2(String docnameArr, String docidArr) throws Exception {
        List<Map<String, String>> doclist = new ArrayList<Map<String, String>>();
        String[] docnameArrLi = docnameArr.split(",");
        String[] docidArrLi = docidArr.split(",");
        if (docnameArrLi.length == docidArrLi.length) {
            for (int i = 0; i < docnameArrLi.length; i++) {
                Map<String, String> mp = new HashedMap();
                healthDoctor hr=healthdoctormapper.selectById(docidArrLi[i]);
                mp.put("docname",hr.getName() );
                mp.put("docid", docidArrLi[i]);
                doclist.add(mp);
            }
        } else {
            throw new CommonException("数据异常，医生ID和医生名称数据不一致，请检查数据库数据");
        }

        return doclist;
    }

    private  List<Map<String, String>> getList(String docnameArr, String docidArr) throws Exception {
        List<Map<String, String>> doclist = new ArrayList<Map<String, String>>();
        String[] docnameArrLi = docnameArr.split(",");
        String[] docidArrLi = docidArr.split(",");

        if (docnameArrLi.length == docidArrLi.length) {
            for (int i = 0; i < docnameArrLi.length; i++) {
                Map<String, String> mp = new HashedMap();

                mp.put("docname", docnameArrLi[i]);
                mp.put("docid", docidArrLi[i]);
                doclist.add(mp);
            }
        } else {
            throw new CommonException("数据异常，医生ID和医生名称数据不一致，请检查数据库数据");
        }

        return doclist;
    }
}
