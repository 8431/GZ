package com.gz.medicine.gzyun.weixin.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.weixin.bean.Usr;
import com.gz.medicine.gzyun.weixin.request.InsertVo;
import com.gz.medicine.gzyun.weixin.request.UsrVo;
import com.gz.medicine.gzyun.weixin.request.YzmVo;
import com.gz.medicine.gzyun.weixin.response.WeixinUserInfo;
import com.gz.medicine.gzyun.weixin.service.WeiXinService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;

import java.util.List;
import java.util.Map;

import static com.gz.medicine.common.util.ValidateWithException.validates;

/**
 * Created by dlf on 2017/12/01 0028.
 * Email 1429264916@qq.com
 */
@RestController
@RequestMapping("v1/weixin/")
public class WeiXinAdminContrller {
    public static final Logger LOGGER = Logger.getLogger(WeiXinAdminContrller.class);

    @Autowired
    Validator validator;
    @Autowired
    WeiXinService weixinservice;


    //注册用户
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult create(UsrVo u) {
        SimpleResult sr = null;
        WeixinUserInfo wf = null;
        try {
            if (validates(validator, u) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, u));
            }
            weixinservice.create(u);
        } catch (CommonException e) {
            LOGGER.error("贯众注册异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

//    //通过openid获取微信信息
//    @RequestMapping(value = "/getWinXinUsrInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
//    public SimpleResult getWinXinUsrInfo(@RequestParam(value = "openid", required = true) String openid) {
//        SimpleResult sr = null;
//        WeixinUserInfo wf = null;
//        try {
//            wf = weixinservice.getWinXinUsrInfo(openid);
//        } catch (CommonException e) {
//            LOGGER.error("获取微信用户信息异常:" + e.getMessage());
//            return SimpleResult.error(e.getCode(), e.getMessage());
//        }
//        sr = SimpleResult.success();
//        sr.put("data", wf);
//        return sr;
//    }

    @RequestMapping(value = "/getYzm", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult getYzm(YzmVo u) {
        SimpleResult sr = null;
        Map<String, Object> re = new HashedMap();
        try {
            if (validates(validator, u) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, u));
            }
            re = weixinservice.getYzm(u);
        } catch (CommonException e) {
            LOGGER.error("获取验证码异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", re);
        return sr;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult check(UsrVo u) {
        SimpleResult sr = null;
        Map<String, Object> re = new HashedMap();
        try {
            if (validates(validator, u) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, u));
            }
            re = weixinservice.checkUsr(u);
        } catch (CommonException e) {
            LOGGER.error("校验异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", re);
        return sr;
    }

    @RequestMapping(value = "/bingWeixin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult bingWeixin(UsrVo u) {
        SimpleResult sr = null;
        try {
            if (validates(validator, u) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, u));
            }
            weixinservice.bingWeixin(u);
        } catch (CommonException e) {
            LOGGER.error("绑定微信异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    @RequestMapping(value = "/getOpenid", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult getOpenid(@RequestParam(value = "code", required = true) String code) {
        SimpleResult sr = null;
        Map<String,String> openMp =null;
        try {
            openMp = weixinservice.getOpenId(code);
        } catch (CommonException e) {
            LOGGER.error("getOpenid异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", openMp);
        return sr;
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult getInfo(@RequestParam(value = "openid", required = true) String openid) {
        SimpleResult sr = null;
        WeixinUserInfo wf = new WeixinUserInfo();
        try {
            wf = weixinservice.getWinXinUsrInfoByOpenId(openid);


        } catch (CommonException e) {
            LOGGER.error("getOpenid异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", wf);
        return sr;
    }

    //查询有体检数据的月份
    @RequestMapping(value = "/queryDataById", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryDataById(@RequestParam(value = "type", required = true) String type,
                                      @RequestParam(value = "usrid", required = true) String usrid) {
        SimpleResult sr = null;
        List<Map<String, Object>> liMp = null;
        try {
            liMp = weixinservice.queryTjsj(type, usrid);
        } catch (CommonException e) {
            LOGGER.error("queryDataById异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", liMp);
        return sr;
    }

    //根据月份查询体检数据详情
    @RequestMapping(value = "/queryDetailByMonth", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryDetailByMonth(@RequestParam(value = "date", required = true) String date,
                                           @RequestParam(value = "usrid", required = true) String usrid,
                                           @RequestParam(value = "type", required = true) String type) {
        SimpleResult sr = null;
        List<Map<String, Object>> liMp = null;
        try {
            liMp = weixinservice.queryTjsjByMonth(type, usrid, date);
        } catch (CommonException e) {
            LOGGER.error("queryDetailByMonth异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", liMp);
        return sr;
    }

    //新增体温数据
    @RequestMapping(value = "/insertTjsj", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult insertTjsj(InsertVo vo) {
        SimpleResult sr = null;
        try {
            if (validates(validator, vo) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, vo));
            }
            weixinservice.insertSql(vo);
        } catch (CommonException e) {
            LOGGER.error("insertTjsj异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //新增体温数据
    @RequestMapping(value = "/delTjsj", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult delTjsj(@RequestParam(value = "guid", required = true) String guid,
                                @RequestParam(value = "type", required = true) String type) {
        SimpleResult sr = null;
        try {
            weixinservice.delTjsj(guid, type);
        } catch (CommonException e) {
            LOGGER.error("delTjsj异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }
    //获取病例列表
    @RequestMapping(value = "/getsick", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult getsick(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = weixinservice.queryPageSickblhdr(page);
        } catch (CommonException e) {
            LOGGER.error("getsick:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }
    @RequestMapping(value = "/checkOpenid", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult checkOpenid(@RequestParam(value = "openid", required = true) String openid) {
        SimpleResult sr = null;
        Map<String, Object> re = new HashedMap();
        try {

            re = weixinservice.checkOpenId(openid);
        } catch (CommonException e) {
            LOGGER.error("校验异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", re);
        return sr;
    }
    @RequestMapping(value = "/getId", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult idcard(@RequestParam(value = "idcard", required = true) String idcard) {
        SimpleResult sr = null;
        Usr re = null;
        try {
            re = weixinservice.getId(idcard);
        } catch (CommonException e) {
            LOGGER.error("校验异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", re);
        return sr;
    }

}
