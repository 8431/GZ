package com.gz.medicine.gzyun.weixin.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.weixin.bean.Usr;
import com.gz.medicine.gzyun.weixin.request.InsertVo;
import com.gz.medicine.gzyun.weixin.request.JinMaAppVo;
import com.gz.medicine.gzyun.weixin.request.UsrVo;
import com.gz.medicine.gzyun.weixin.request.YzmVo;
import com.gz.medicine.gzyun.weixin.response.WeixinUserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2017/12/1 0001.
 * Email 1429264916@qq.com
 */
public interface WeiXinService {
    /**
     * 登录
     * @return
     * @throws CommonException
     */
    void create(UsrVo u ) throws CommonException;
    /**
     * 1分钟获取6位数，数字验证码
     * @return
     * @throws CommonException
     */
    Map<String,Object> getYzm(YzmVo u ) throws CommonException;

    /**
     * 根据openid获取用户微信信息
     * @param openid
     * @return
     * @throws CommonException
     */
    WeixinUserInfo getWinXinUsrInfo(String openid) throws CommonException;

    /**
     * 校验是否有账号或者绑定过微信
     * @param u
     * @return
     * @throws CommonException
     */
    Map<String,Object> checkUsr(UsrVo u)throws CommonException;

    /**
     * 绑定微信
     * @param u
     * @throws CommonException
     */
    void  bingWeixin(UsrVo u)throws CommonException;

    /**
     * 插入体温，血压，血氧
     * @throws CommonException
     */
    void insertSql(InsertVo param)throws CommonException;

    /**
     * 查询体检数据的月份
     * @param type  类型
     * @param usrid 患者id
     * @return
     * @throws CommonException
     */
     List<Map<String,Object>> queryTjsj(String type,String usrid)throws CommonException;

    /**
     * 根据月份查询当月所有数据
     * @param type  类型
     * @param usrid 患者id
     * @param month 月份
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> queryTjsjByMonth(String type,String usrid,String month)throws CommonException;
    /**
     * 根据code获取用户微信信息
     * @param openId
     * @return
     * @throws CommonException
     */
    WeixinUserInfo getWinXinUsrInfoByOpenId(String openId) throws CommonException;

    /**
     * 获取openId
     * @param code
     * @return
     * @throws CommonException
     */
    Map<String,String>  getOpenId(String code) throws CommonException;

    /**
     * 删除体检数据
     * @param guid
     * @param type
     * @throws CommonException
     */
    void delTjsj(String guid,String type)throws CommonException;


    /**
     * 病例列表分页数据
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPageSickblhdr(PageModel page)throws CommonException;
    /**
     * 校验openid是否是贯众用户
     * @param openid
     * @return
     * @throws CommonException
     */
    Map<String,Object> checkOpenId(String openid)throws CommonException;

    /**
     * 通过身份证查询用户
     * @param idcard
     * @return
     * @throws CommonException
     */
    Usr getId(String idcard)throws CommonException;

    /**
     * 第三方用户注册
     * @param jv
     * @return
     * @throws CommonException
     */
    String  register(JinMaAppVo jv)throws CommonException;


}
