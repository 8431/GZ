package com.gz.medicine.gzyun.weixin.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.weixin.bean.Usr;
import com.gz.medicine.gzyun.weixin.request.InsertVo;
import com.gz.medicine.gzyun.weixin.request.JinMaAppVo;
import com.gz.medicine.gzyun.weixin.request.UsrVo;
import com.gz.medicine.gzyun.weixin.request.YzmVo;
import com.gz.medicine.gzyun.weixin.response.WeixinUserInfo;
import com.gz.medicine.gzyun.weixin.service.WeiXinService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;
import java.util.List;
import java.util.Map;

import static com.gz.medicine.common.util.ValidateWithException.validates;

/**
 * Created by dlf on 2017/12/01 0028.
 * Email 1429264916@qq.com
 */
@RestController
@RequestMapping("v1/api/")
public class ThridAppContrller {
    public static final Logger LOGGER = Logger.getLogger(ThridAppContrller.class);

    @Autowired
    Validator validator;
    @Autowired
    WeiXinService weixinservice;


    //注册用户
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult register(JinMaAppVo u) {
        SimpleResult sr = null;
        String guid="";
        try {
            if (validates(validator, u) != null) {
                return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, u));
            }
            guid=weixinservice.register(u);
        } catch (CommonException e) {
            LOGGER.error("贯众注册异常:" + e.getMessage());
            return SimpleResult.error(e.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data",guid);
        return sr;
    }


}
