package com.gz.medicine.yun.doctor.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTteamsg;

import java.util.List;
import java.util.Map;

/**
 * Created by 邓岚峰 on 2017/8/17 0017.
 */
public interface DtDoctorQuanService {
    /**
     * 查询医生圈分页
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult getDoctorQuanList(PageModel page) throws CommonException;

    /**
     * 保存聊天信息，文件上传ftp
     * @param msg
     * @return
     * @throws CommonException
     */
    SimpleResult insertDTteamsg(DTteamsg msg) throws CommonException;

    /**
     * lrange分页查询redis数据聊天记录
     * @param page
     * @return
     * @throws CommonException
     */
    SimpleResult queryPageDTteamsg(PageModel page) throws CommonException;

    /**
     *查询医生详情
     * @return
     * @throws CommonException
     */
    SimpleResult queryTeamDetail(String teamguid) throws CommonException;

    /**
     *设置聊天信息存储方式 1521 oracle  其他redis
     *
     * @return
     * @throws CommonException
     */
    SimpleResult setType(String key) throws CommonException;
}