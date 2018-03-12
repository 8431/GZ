/**
 * projectName: GZYUN
 * fileName: SmsrdLogMapper.java
 * packageName: com.gz.medicine.yun.common.mapper
 * date: 2018-01-23 15:17
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.common.mapper;

import com.gz.medicine.yun.common.bean.SmsrdLog;
import org.apache.ibatis.annotations.Param;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SmsrdLogMapper
 * @packageName: com.gz.medicine.yun.common.mapper
 * @description: 公共SQL执行
 * @data: 2018-01-23 15:17
 **/
public interface SmsrdLogMapper {

    /**
     * 根据ip获取统计数
     * @param ip
     * @return
     */
    Integer getCountIp(@Param("ip") String ip);

    /**
     * 根据手机号获取统计数
     * @param phone
     * @return
     */
    Integer getCountPhone(@Param("phone") String phone);

    /**
     *
     * @param phone
     * @return
     */
    /*Integer getCountCnt(@Param("phone") String phone);*/

    Integer getCountMin(@Param("phone") String phone);

    Integer getCountCntNum(@Param("phone") String phone);

    int insertSelective(SmsrdLog record);

}
