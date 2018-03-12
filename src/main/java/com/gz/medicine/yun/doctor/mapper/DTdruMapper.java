package com.gz.medicine.yun.doctor.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTdru;
import com.gz.medicine.yun.doctor.reponse.DTdruResponse;

import java.util.List;

/**
 *
 * @Title: DTdruMapper.java
 * @Package com.gz.medicine.yun.doctor.mapper
 * @Description: 药品接口
 * @Author fendo
 * @Date 2017年8月7日 上午10:23:10
 * @Version V1.0
 */
public interface DTdruMapper {

    int insert(DTdru record);

    int insertSelective(DTdru record);


    List<DTdruResponse> queryPageLikeName(Page p);

}