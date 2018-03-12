/**
 * projectName: GZYUN
 * fileName: SmsrdLogServiceImpl.java
 * packageName: com.gz.medicine.yun.common.service
 * date: 2018-01-23 15:21
 * copyright(c) 2017-2020 xxx公司
 */
package com.gz.medicine.yun.common.service;


/**
 * @version: V1.0
 * @author: fendo
 * @className: SmsrdLogService
 * @packageName: com.gz.medicine.yun.common.service
 * @description: sql执行Service
 * @data: 2018-01-23 15:21
 **/
public interface SmsrdLogService {

    boolean sendCode(String mobile,String content) throws Exception;
}
