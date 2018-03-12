/**
 * projectName: GZYUN
 * fileName: HealthCallStateRecordService.java
 * packageName: com.gz.medicine.gzyun.health.service
 * date: 2017-12-19 15:20
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.health.bean.HealthCallStateRecord;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthCallStateRecordService
 * @packageName: com.gz.medicine.gzyun.health.service
 * @description: 呼叫状态记录表Service
 * @data: 2017-12-19 15:20
 **/
public interface HealthCallStateRecordService {

    /**新增数据**/
    int insert(HealthCallStateRecord healthCallStateRecord) throws CommonException;

    /**根据ID获取单个对象**/
    HealthCallStateRecord find(String id) throws CommonException;
}
