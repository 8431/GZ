package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.common.exception.CommonException;
import java.util.List;
import java.util.Map;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzyun.health.bean.healthevaluate;
import com.gz.medicine.gzyun.health.reponse.HealthEvaluteResponse;
import com.gz.medicine.gzyun.health.reponse.HealthValuaCumReponse;
import com.gz.medicine.gzyun.health.reponse.UserRatingReponse;
import com.gz.medicine.gzyun.health.request.HealthOrderStatisRequest;

import java.util.List;

public interface healthevaluateMapper {

    int insert(healthevaluate record);

    int insertSelective(healthevaluate record);

    /**
     * 根据医生id获取用户评论
     * @param p
     * @return
     * @throws CommonException
     */
    List<UserRatingReponse> queryPageDocid(Page p)throws CommonException;

    /**
     * 根据医生ID统计数量
     * @param docid
     * @return
     */
    String selectCountByDocid(String docid);

    //分页查询评价
    List<HealthEvaluteResponse> queryPageMyid(Page p) throws Exception;
    
    /**
     * 累计评价数
     * @author 舵主
     *
     * 下午3:30:31
     */
    List<Map<String,Object>> queryListByeValuaCum(HealthOrderStatisRequest data) throws CommonException;
    
    /**
     * 修改评价消息状态为已读
     * **/

    int updatIsread(Page p);
}
