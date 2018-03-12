package com.gz.medicine.gzyun.weixin.commonUtil;

import com.google.gson.Gson;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.HttpRequest;
import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.gzyun.weixin.response.WeixinUserInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */
public class WeiXinUtil {
    public static final Map<String, String> WEIXIN_TOKEN = new ConcurrentHashMap<String, String>();
    public static final Map<String, String> WEIXIN_RESHTOKEN = new ConcurrentHashMap<String, String>();
    //微信token获取api
    public static final String WEIXIN_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    //获取微信用户信息
    public static final String WEIXIN_USRINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";
    //通过code获取tooken
    public static final String WEIXIN_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    //通过code获取获取微信用户信息
    public static final String WEIXIN_CODE_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
    //刷新token
    public static final String WEIXIN_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
    //检验token是否有效
    public static final String WEIXIN_CHECK_TOKEN_URL = "https://api.weixin.qq.com/sns/auth";


    /**
     * 获取开发者token
     *
     * @return
     */
    public static String getToken() throws Exception {
        String result = "";
        String grantType = PropertyUtil.getPropery("gz.weixin.grant_type");
        String appId = PropertyUtil.getPropery("gz.weixin.appid");
        String secret = PropertyUtil.getPropery("gz.weixin.secret");
        Map<String, String> param = new HashedMap();
        param.put("grant_type", grantType);
        param.put("appid", appId);
        param.put("secret", secret);
        result = HttpRequest.sendGet(WEIXIN_TOKEN_URL, param);
        Gson gn = new Gson();
        Map<String, String> mpJson = gn.fromJson(result, Map.class);
        result = mpJson.get("access_token");
        return result;
    }

    public static WeixinUserInfo getWeiXinUsrInfo(String opendId) throws Exception {
        WeixinUserInfo wf = new WeixinUserInfo();
        String token = getToken();
        Map<String, String> param = new HashedMap();
        param.put("access_token", token);
        param.put("openid", opendId);
        param.put("lang", "zh_CN");
        String result = HttpRequest.sendGet(WEIXIN_USRINFO_URL, param);
        Gson gn = new Gson();
        wf = gn.fromJson(result, WeixinUserInfo.class);
        return wf;
    }

    public static Map<String, String> getToken(String code) throws Exception {
        Map<String, String> resultMp = new HashedMap();
        String grantType = PropertyUtil.getPropery("gz.weixin.grant_type");
        String appId = PropertyUtil.getPropery("gz.weixin.appid");
        String secret = PropertyUtil.getPropery("gz.weixin.secret");
        Map<String, String> param = new HashedMap();
        param.put("grant_type", "authorization_code");
        param.put("appid", appId);
        param.put("secret", secret);
        param.put("code", code);
        String result = HttpRequest.sendGet(WEIXIN_CODE_URL, param);
        Gson gn = new Gson();
        resultMp = gn.fromJson(result, Map.class);
        return resultMp;
    }

    /**
     * 获取openid
     *
     * @param code
     * @return
     * @throws Exception
     */
    public static String getWeiXinUsrInfoByCode(String code) throws Exception {
        String openidKey = "";
        Map<String, String> resultMp = getToken(code);
        Map<String, String> param = new HashedMap();
        String access_token = resultMp.get("access_token");
        String openid = resultMp.get("openid");
        String refresh_token = resultMp.get("refresh_token");
        if (!StringUtils.isEmpty(access_token) && !StringUtils.isEmpty(openid) && !StringUtils.isEmpty(refresh_token)) {
            param.put("access_token", access_token);
            param.put("openid", openid);
            param.put("lang", "zh_CN");
            WEIXIN_TOKEN.put(openid, access_token);
            WEIXIN_RESHTOKEN.put(openid, refresh_token);
            openidKey = openid;
        }
        return openidKey;
    }

    public static WeixinUserInfo getWeiXinUsrInfoByOpenId(String opendId) throws Exception {
        WeixinUserInfo wf = new WeixinUserInfo();
        String token = WEIXIN_TOKEN.get(opendId);
        //检验token是否失效，失效就使用resh,刷新之后还失效的话，需要重新授权
        if (StringUtils.isEmpty(token)) {
            throw new CommonException("缓存中的token为空");
        }
        boolean re = CheckToken(token, opendId);
        Gson gn = new Gson();
        if (!re) {
            String reshToken = WEIXIN_RESHTOKEN.get(opendId);
            Map<String, String> param = new HashedMap();
            String appId = PropertyUtil.getPropery("gz.weixin.appid");
            param.put("appid", appId);
            param.put("grant_type", "refresh_token");
            param.put("refresh_token", reshToken);
            //刷新token---有效期30天
            String result = HttpRequest.sendGet(WEIXIN_REFRESH_TOKEN_URL, param);
            Map<String, String> refrshJson = gn.fromJson(result, Map.class);
            String access_token = refrshJson.get("access_token");
            if (StringUtils.isEmpty(access_token)) {
                throw new CommonException("刷新token异常：" + result);
            } else {
                boolean re2 = CheckToken(access_token, opendId);
                if (re2) {
                    token = access_token;
                    WEIXIN_TOKEN.put(opendId, access_token);
                } else {
                    throw new CommonException("token已过期（微信保留时间最长30天），用户需要重新授权");
                }

            }

        }
        //获取用户信息
        Map<String, String> paramInfo = new HashedMap();
        paramInfo.put("access_token", token);
        paramInfo.put("openid", opendId);
        paramInfo.put("lang", "zh_CN");
        String resultInfo = HttpRequest.sendGet(WEIXIN_CODE_INFO_URL, paramInfo);
        wf = gn.fromJson(resultInfo, WeixinUserInfo.class);
        return wf;
    }

    public static boolean CheckToken(String token, String opendId) throws Exception {
        boolean re = false;
        Map<String, String> param = new HashedMap();
        param.put("access_token", token);
        param.put("openid", opendId);
        String checkRe = HttpRequest.sendGet(WEIXIN_CHECK_TOKEN_URL, param);
        Gson gn = new Gson();
        Map<String, String> result = gn.fromJson(checkRe, Map.class);
        String errcode = result.get("errmsg");
        if ("ok".equals(errcode)) {
            re = true;
        }
        return re;
    }

    ;

    public static void main(String[] args) {
        try {
            //getWeiXinUsrInfo("okNxtvybq507Y0LO--XPM86O9EW8");
            // getToken("0610sSaT11VBm71qEnbT1FEVaT10sSaX");
            System.out.println(getToken("001bfh1s1F7wko0VpF1s1nw51s1bfh1d"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
