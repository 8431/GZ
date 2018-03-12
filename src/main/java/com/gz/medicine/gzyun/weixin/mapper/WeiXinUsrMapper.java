package com.gz.medicine.gzyun.weixin.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.weixin.bean.Usr;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface WeiXinUsrMapper {
	 /**
     * 登录
     * @param u
     * @return
     * @throws CommonException
     */
    Usr login(Usr u) throws CommonException;
    Usr checkUsr(Usr u) throws CommonException;
    Usr queryId(String openid) throws CommonException;
    int insertSelective(Usr record)throws CommonException;
    int updateThirdpartyid(Usr record);
    @Select("select * from usr where THIRDPARTYID=#{0}")
    Usr checkOpenid(String openid) throws CommonException;
    @Select("select * from usr where idcard=#{0}")
    Usr getUsr(String idcard) throws CommonException;

    /**
     * 执行sql
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> exSql(Map<String,Object> param)throws CommonException;

    /**
     * 插入sql
     * @param param
     * @throws CommonException
     */
    void insertSql(Map<String,Object> param)throws CommonException;

    /**
     * 更新
     * @param param
     * @throws CommonException
     */
    void updateSql(Map<String,Object> param)throws CommonException;



    /**
     * 病例列表分页数据
     * @param page
     * @return
     * @throws CommonException
     */
    List<Map<String,Object>> queryPageSickblhdr(Page page)throws CommonException;

}