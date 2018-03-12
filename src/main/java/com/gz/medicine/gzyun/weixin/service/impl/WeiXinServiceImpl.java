package com.gz.medicine.gzyun.weixin.service.impl;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.HttpRequest;
import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.health.common.GzHealthyCodeEnum;
import com.gz.medicine.gzyun.user.request.RegUserRequest;
import com.gz.medicine.gzyun.user.service.UsrService;
import com.gz.medicine.gzyun.weixin.bean.Usr;
import com.gz.medicine.gzyun.weixin.commonUtil.WeiXinUtil;
import com.gz.medicine.gzyun.weixin.mapper.WeiXinUsrMapper;
import com.gz.medicine.gzyun.weixin.request.InsertVo;
import com.gz.medicine.gzyun.weixin.request.JinMaAppVo;
import com.gz.medicine.gzyun.weixin.request.UsrVo;
import com.gz.medicine.gzyun.weixin.request.YzmVo;
import com.gz.medicine.gzyun.weixin.response.WeixinUserInfo;
import com.gz.medicine.gzyun.weixin.service.WeiXinService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */

@Service("WeiXinService")
public class WeiXinServiceImpl implements WeiXinService {
    public static final Logger LOGGER = Logger.getLogger(WeiXinServiceImpl.class);
    public static final Map<String, Object> YZMKEY = new HashedMap();
    @Autowired
    WeiXinUsrMapper weixinusrmapper;
    @Autowired
    private UsrService usrService;
    @Override
    public void create(UsrVo u) throws CommonException {
        try {
            if (StringUtils.isEmpty(u.getOpenid()) || StringUtils.isEmpty(u.getPassword())) {
                throw new CommonException("openid和密码不能为空");
            }
            Usr usr = new Usr();
            usr.setId(u.getName());
            usr.setPasswd(u.getPassword());
            usr.setThirdpartyid(u.getOpenid());
            weixinusrmapper.insertSelective(usr);
        } catch (Exception e) {
            LOGGER.error("登录异常:" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_LOGIN_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_LOGIN_CODE, e);
            }
        }

    }

    @Override
    public Map<String, Object> getYzm(YzmVo u) throws CommonException {
        Map<String, Object> result = new HashedMap();
        try {
            String phone = u.getPhone();
            String yzm = (int) ((Math.random() * 9 + 1) * 100000) + "";
            //判断上次获取时间是否超过1分钟
            Map<String, Object> m1 = (Map<String, Object>) YZMKEY.get(phone);
            if (m1 != null && m1.size() > 0) {
                Long lastTime = (Long) m1.get("time");
                if (lastTime != null) {
                    Long nowTime = new Date().getTime();
                    //距离上次发送验证码超过1分钟才可再次发送
                    if (nowTime - lastTime >= 1000 * 60) {
                        MobileCode.sendAuthCode(phone, "您的验证码是:" + yzm);
                        //返回验证码
                        result.put("yzm", yzm);
                        result.put("msg", "发送成功");
                        result.put("time", new Date().getTime());
                        YZMKEY.put(phone, result);

                    } else {
                        result.put("msg", "距离上一次发送验证码还剩：" + (60 - (nowTime - lastTime) / 1000) + "秒");
                        result.put("yzm", "");
                        result.put("time", new Date().getTime());
                        result.put("djs", (60 - (nowTime - lastTime) / 1000));
                    }
                }
            } else {
                //初次加载，获取验证码
                result.put("yzm", yzm);
                result.put("msg", "发送成功");
                result.put("time", new Date().getTime());
                YZMKEY.put(phone, result);
                MobileCode.sendAuthCode(phone, "您的验证码是:" + yzm);
            }


        } catch (Exception e) {
            LOGGER.error("发送验证码异常：" + e.getMessage(), e);
        }

        return result;
    }

    @Override
    public WeixinUserInfo getWinXinUsrInfo(String openid) throws CommonException {
        WeixinUserInfo wx = null;
        try {
            if (StringUtils.isEmpty(openid)) {
                throw new CommonException("openid不能为空");
            }
            //注册过返回微信信息
            wx = WeiXinUtil.getWeiXinUsrInfo(openid);
            if (wx != null && wx.getOpenid() != null) {
                Usr usr = weixinusrmapper.queryId(openid);
                if (usr != null) {
                    wx.setGzcoount(usr.getId());
                }
            }
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e);
            }
        }
        return wx;
    }

    @Override
    public Map<String, Object> checkUsr(UsrVo u) throws CommonException {
        Map<String, Object> resut = new HashedMap();
        try {
            //校验验证码是否正确
            if (StringUtils.isEmpty(u.getYzm())) {
                throw new CommonException("验证码不能为空");
            } else {
                Map<String, Object> m1 = (Map<String, Object>) YZMKEY.get(u.getName());
                if (m1 != null) {
                    String yzm = (String) m1.get("yzm");
                    if (u.getYzm().equals(yzm)) {
                        //校验通过
                        Usr usr = new Usr();
                        usr.setId(u.getName());
                        Usr reVo = weixinusrmapper.checkUsr(usr);
                        if (reVo != null && reVo.getThirdpartyid() != null) {
                            //绑定过微信
                            resut.put("code", "1");
                            resut.put("msg", "绑定过微信");
                            resut.put("acounnt", usr.getId());
                            resut.put("usrguid", reVo.getGuid());
                        } else if (reVo == null) {
                            //没注册过用户，需要重新注册
                            resut.put("code", "2");
                            resut.put("msg", "没注册过用户，需要重新注册");
                        } else if (reVo != null && reVo.getThirdpartyid() == null) {
                            //用户注册过，但是没有绑定微信
                            resut.put("code", "3");
                            resut.put("msg", "用户注册过，但是没有绑定微信");
                            resut.put("usrguid", reVo.getGuid());
                            resut.put("acounnt", usr.getId());
                        }
                    } else {
                        throw new CommonException("验证码输入错误");
                    }
                } else {
                    throw new CommonException("验证码输入错误");
                }

            }
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e);
            }
        }
        return resut;
    }

    @Override
    public void bingWeixin(UsrVo u) throws CommonException {
        try {
            if (StringUtils.isEmpty(u.getYzm())||StringUtils.isEmpty(u.getType())) {
                throw new CommonException("验证码,type不能为空");
            }
            Map<String,Object> yzmJson= (Map<String, Object>) YZMKEY.get(u.getName());
            String yzm = (String) yzmJson.get("yzm");
            if (u.getYzm().equals(yzm)) {
                Usr usr = new Usr();
                usr.setId(u.getName());
                usr.setThirdpartyid(u.getOpenid());
                if(!"1".equals(u.getType())){
                    usr.setPasswd(u.getPassword());
                    usr.setName(u.getName());
                    usr.setOrg("CHIS");
                    weixinusrmapper.insertSelective(usr);
                }else{
                    weixinusrmapper.updateThirdpartyid(usr);
                }
            } else {
                throw new CommonException("验证码不正确，或者失效，请重新登录！");
            }

        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e);
            }
        }

    }

    @Override
    public void insertSql(InsertVo vo) throws CommonException {

        try {
            Integer type = Integer.parseInt(vo.getType());
            Map<String, Object> param = new HashedMap();
            param.put("usrguid", vo.getUsrguid());
            param.put("meatime", vo.getMeatime());
            StringBuffer sb = new StringBuffer();
            sb.append("insert into ");
            switch (type) {
                case 1: {
                    //GZJK_heatRecord--体温--
                    sb.append("GZJK_heatRecord (usrguid,meatime,heat)values(#{usrguid},#{meatime},#{heat})");
                    param.put("heat", vo.getValue1());
                    break;
                }
                case 2: {
                    //GZJK_blgRecord --血糖--
                    sb.append("GZJK_blgRecord (usrguid,meatime,blglu,state)values(#{usrguid},#{meatime},#{blglu},#{state})");
                    param.put("blglu", vo.getValue1());
                    param.put("state", vo.getStatekey());//空腹或者饭后
                    break;
                }
                case 3: {
                    //GZJK_blpRecord --血压
                    sb.append("GZJK_blpRecord (usrguid,meatime,sysblopre,diablopre)values(#{usrguid},#{meatime},#{sysblopre},#{diablopre})");
                    param.put("sysblopre", vo.getValue1());//收缩
                    param.put("diablopre", vo.getValue2());//收张
                    break;
                }
                case 4: {
                    //GZJK_ecgRecord--心率--
                    sb.append("GZJK_ecgRecord (usrguid,meatime,heabeat)values(#{usrguid},#{meatime},#{heabeat})");
                    param.put("heabeat", vo.getValue1());//心博
                    break;
                }
                case 5:
                case 6: {
                    //GZJK_TJSJ--体重--
                    //GZJK_TJSJ--血氧--
                    sb.append("GZJK_TJSJ (usrguid,meatime,value,type)values(#{usrguid},#{meatime},#{value},#{type})");
                    param.put("type", vo.getType());//5体重，6血氧
                    param.put("value", vo.getValue1());
                    break;
                }
            }
            param.put("sql", sb.toString());
            weixinusrmapper.insertSql(param);
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_INSERTSQL_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_INSERTSQL_CODE, e);
            }
        }
    }

    @Override
    public List<Map<String, Object>> queryTjsj(String type, String usrid) throws CommonException {
        List<Map<String, Object>> liMp = new ArrayList<Map<String, Object>>();
        try {
            if (StringUtils.isEmpty(type) || StringUtils.isEmpty(usrid)) {
                throw new CommonException("类型和患者id不能为空");
            }
            Map<String, Object> param = new HashedMap();
            param.put("usrid", usrid);
            StringBuffer sb = new StringBuffer();

            sb.append("select substr(MEATIME,0,7) as time from ");
            getTable(type, sb);

            sb.append("where usrguid=#{usrid} and del='1'   ");
            if ("5".equals(type)) {
                sb.append("  and type='5'");
            }
            if ("6".equals(type)) {
                sb.append("  and type='6' ");
            }
            sb.append(" group by substr(MEATIME,0,7) order by time desc ");
            param.put("sql", sb.toString());
            liMp = weixinusrmapper.exSql(param);
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYTJSJ_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYTJSJ_CODE, e);
            }
        }
        return liMp;
    }

    @Override
    public List<Map<String, Object>> queryTjsjByMonth(String type, String usrid, String month) throws CommonException {
        List<Map<String, Object>> liMp = new ArrayList<Map<String, Object>>();
        try {
            if (StringUtils.isEmpty(type) || StringUtils.isEmpty(usrid) || StringUtils.isEmpty(month)) {
                throw new CommonException("类型和患者id和月份不能为空");
            }
            Map<String, Object> param = new HashedMap();
            param.put("usrid", usrid);
            param.put("date", month);
            StringBuffer sb = new StringBuffer();
            sb.append("select * from ");
            getTable(type, sb);

            sb.append(" where usrguid=#{usrid} and substr(MEATIME,0,7)=#{date} and del='1'");
            if ("5".equals(type)) {
                sb.append("  and type='5' ");
            }
            if ("6".equals(type)) {
                sb.append("  and type='6' ");
            }
            sb.append("order by MEATIME desc");
            param.put("sql", sb.toString());
            liMp = weixinusrmapper.exSql(param);
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYTJSJBYMONTH_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYTJSJBYMONTH_CODE, e);
            }
        }
        return liMp;
    }

    private void getTable(String type, StringBuffer sb) throws Exception {
        switch (Integer.parseInt(type)) {
            case 1: {
                //GZJK_heatRecord--体温--
                sb.append("GZJK_heatRecord ");
                break;
            }
            case 2: {
                //GZJK_blgRecord --血糖--
                sb.append("GZJK_blgRecord ");
                break;
            }
            case 3: {
                //GZJK_blpRecord --血压
                sb.append("GZJK_blpRecord ");
                break;
            }
            case 4: {
                //GZJK_ecgRecord--心率--
                sb.append("GZJK_ecgRecord ");
                break;
            }
            case 5:
            case 6: {
                //GZJK_TJSJ--体重--
                //GZJK_TJSJ--血氧--
                sb.append("GZJK_TJSJ ");
                break;
            }
        }
    }

    @Override
    public WeixinUserInfo getWinXinUsrInfoByOpenId(String openid) throws CommonException {

        WeixinUserInfo wx = new WeixinUserInfo();
        try {
            if (StringUtils.isEmpty(openid)) {
                throw new CommonException("openid不能为空");
            }
            wx = WeiXinUtil.getWeiXinUsrInfoByOpenId(openid);

        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e);
            }
        }
        return wx;
    }

    @Override
    public Map<String, String> getOpenId(String code) throws CommonException {
        Map<String, String> result = new HashedMap();
        try {
            if (StringUtils.isEmpty(code)) {
                throw new CommonException("code不能为空");
            }
            String re = WeiXinUtil.getWeiXinUsrInfoByCode(code);
            result.put("openid", re);
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_GETWINXINUSRINFO_CODE, e);
            }
        }

        return result;
    }

    @Override
    public void delTjsj(String guid, String type) throws CommonException {
        String result = "";
        try {
            if (StringUtils.isEmpty(guid) || StringUtils.isEmpty(type)) {
                throw new CommonException("guid不能为空");
            }
            Map<String, Object> param = new HashedMap();
            param.put("guid", guid);
            StringBuffer sb = new StringBuffer();
            sb.append("update ");
            getTable(type, sb);
            sb.append(" set del='0' where guid=#{guid}");
            param.put("sql", sb.toString());
            weixinusrmapper.updateSql(param);
        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_DELTJSJ_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_DELTJSJ_CODE, e);
            }
        }

    }

    @Override
    public Page queryPageSickblhdr(PageModel page) throws CommonException {
        Page pe = page.getPage();
        if (StringUtils.isEmpty(pe.get("usrguid"))) {
            throw new CommonException("患者id不能为空");
        }
        List<Map<String, Object>> mpMangeLi = new ArrayList<Map<String, Object>>();
        try {
            mpMangeLi = weixinusrmapper.queryPageSickblhdr(pe);
            pe.setParameterType(mpMangeLi);
        } catch (Exception e) {
            LOGGER.error("获取病例异常：" + e.getMessage(), e);
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYPAGESICKBLHDR, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_QUERYPAGESICKBLHDR, e);
            }
        }
        return pe;
    }

    @Override
    public Map<String, Object> checkOpenId(String openid) throws CommonException {
        Map<String, Object> resut = new HashedMap();
        try {
            //校验验证码是否正确
            if (StringUtils.isEmpty(openid)) {
                throw new CommonException("openid不能为空");
            } else {
                //校验openid
                Usr reVo = weixinusrmapper.checkOpenid(openid);
                if (reVo != null && reVo.getThirdpartyid() != null) {
                    //绑定过微信
                    resut.put("code", "1");
                    resut.put("msg", "绑定过微信");
                    resut.put("acounnt", reVo.getId());
                    resut.put("usrguid", reVo.getGuid());
                } else if (reVo == null) {
                    //没注册过用户，需要重新注册
                    resut.put("code", "2");
                    resut.put("msg", "没注册过用户，需要重新注册,跳转到短信验证码界面");
                }
            }

        } catch (Exception e) {
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_CHECKUSR_CODE, e);
            }
        }
        return resut;
    }

    @Override
    public Usr getId(String idcard) throws CommonException {
        Usr u=new Usr();
        try {
            if (StringUtils.isEmpty(idcard)) {
                throw new CommonException("身份证不能为空");
            }
            u= weixinusrmapper.getUsr(idcard);
        }catch (Exception e){
            if (e instanceof CommonException) {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_BYIDCARD, e.getMessage(), e);
            } else {
                throw new CommonException(GzHealthyCodeEnum.WEIXIN_USR_BYIDCARD, e);
            }
        }
        return u;
    }

    @Override
    public String register(JinMaAppVo jv) throws CommonException {
        String uuid="";
        try{
            RegUserRequest rt=new RegUserRequest();
            rt.setId(jv.getPhone());
            rt.setIdcard(jv.getIdcard());
            String gzguid=usrService.retrieveUserGzguid(rt);
            Map<String, Object> param = new HashedMap();
            param.put("IDCARD",jv.getIdcard());
            param.put("MOBILE",jv.getPhone());
            param.put("NAME",jv.getName());
            param.put("ID", jv.getPhone());
            if(StringUtils.isEmpty(jv.getType())){
                param.put("REGTYPE", "GZ_JMY");
            }else{
                param.put("REGTYPE",jv.getType());
            }
            uuid=UUIDTool.getUUID();
            param.put("GUID",uuid);
            String idcard=jv.getIdcard();
            param.put("PASSWD",idcard.substring(idcard.length()-6));
            param.put("GZGUID",gzguid);
            //调取用户中心接口
            param.put("sql","insert into USR(IDCARD,MOBILE,NAME,GUID,ID,REGTYPE,PASSWD,GZGUID)values(#{IDCARD},#{MOBILE},#{NAME},#{GUID},#{ID},#{REGTYPE},#{PASSWD},#{GZGUID})");
            weixinusrmapper.insertSql(param);
        }catch (Exception e){
            throw new CommonException(GzHealthyCodeEnum.THRID_USR_REGISTER_CODE, e);
        }
        return uuid;
    }

}