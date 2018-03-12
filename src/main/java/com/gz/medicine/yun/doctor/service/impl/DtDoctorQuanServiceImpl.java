package com.gz.medicine.yun.doctor.service.impl;

import com.google.gson.Gson;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;

import com.gz.medicine.common.util.PropertyUtil;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.ftpUtil.FTPClientPool;
import com.gz.medicine.ftpUtil.Ftp;
import com.gz.medicine.yun.doctor.bean.DTteamsg;
import com.gz.medicine.yun.doctor.mapper.DTschdocteamMapper;
import com.gz.medicine.yun.doctor.mapper.DTteamDocMapper;
import com.gz.medicine.yun.doctor.mapper.DTteamsgMapper;
import com.gz.medicine.yun.doctor.redisService.RedisDaoService;
import com.gz.medicine.yun.doctor.service.DtDoctorQuanService;
import oracle.sql.BLOB;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by 邓岚峰 on 2017/8/17 0017.
 */
@Service("DtDoctorQuanService")
public class DtDoctorQuanServiceImpl implements DtDoctorQuanService {
    public static final Logger LOGGER = Logger.getLogger(DtDoctorQuanServiceImpl.class);

    @Autowired
    DTschdocteamMapper dtschdocteammapper;
    @Autowired
    RedisDaoService redisdaoservice;
    @Autowired
    FTPClientPool ftpclientpool;
    @Autowired
    DTteamsgMapper dtteamsgmapper;
    @Autowired
    DTteamDocMapper dtteamdocmapper;

    @Override
    public SimpleResult getDoctorQuanList(PageModel page) throws CommonException {
        SimpleResult sr = null;
        Page p = page.getPage();
        List<Map<String, Object>> pageJson = null;
        try {
            pageJson = dtschdocteammapper.queryPageDoctorQuan(p);
            p.setParameterType(pageJson);
            sr = SimpleResult.success();
            sr.put("data", p);
        } catch (Exception e) {
            LOGGER.error("分页查询医生圈异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "分页查询医生圈异常：",e);
        }
        return sr;
    }

    @Override
    public SimpleResult insertDTteamsg(DTteamsg msg) throws CommonException {
        SimpleResult sr = null;
        String type = msg.getType();
        msg.setGuid(UUIDTool.getUUID());//消息唯一guid
        msg.setCrtdat(new Date());//插入数据库时间
        String key = "DTteamsg:" + msg.getGuid() + ":" + msg.getTeamguid();
        try {
            if ("2".equals(type)) {
                MultipartFile file = msg.getFile();
                if (file != null) {
                    String name = file.getOriginalFilename();
                    String filePath = PropertyUtil.getPropery("ftp.filePath");
                    StringBuilder fileName = getFileName(name);
                    msg.setMsgs(filePath + "/" + fileName.toString());
                    //上传至ftp服务器，并替换文件名称
                    uploadFile(file, filePath, fileName.toString());
                    msg.setFile(null);
                }
            }
            String dataKey = (String) redisdaoservice.get("DtDoctorQuanServiceImpl:insertDTteamsg");
            if ("1521".equals(dataKey)) {
                if (StringUtils.isEmpty(msg.getBlguid())) {
                    msg.setBlobguid("00000000");
                }
                if (StringUtils.isEmpty(msg.getBlguid())) {
                    msg.setBlguid("00000000");
                }
                //1.更新团队中未读信息数量
                String teamDoc = msg.getTeamDocList();
                Gson gn = new Gson();
                List<String> teamLi = gn.fromJson(teamDoc, List.class);
                Map<String, Object> mp = new HashedMap();
                mp.put("teamList", teamLi);
                mp.put("teamguid", msg.getTeamguid());
                dtteamdocmapper.UpdateMessagestat(mp);
                //2.新增聊天信息到聊天表
                msg.setCrtdat(null);
                msg.setTeamguid(null);
                dtteamsgmapper.insertSelective(msg);

            } else {
                //存储到redis
                redisdaoservice.set(key, msg);
                redisdaoservice.lpush("DTteamsgLpush:" + msg.getTeamguid(), key);
            }
            //存到oracle
            sr = SimpleResult.success();
        } catch (Exception e) {
            LOGGER.error("分页查询医生圈异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "分页查询医生圈异常",e);
        }
        return sr;
    }

    private void uploadFile(MultipartFile file, String filePath, String name) throws Exception {
        Ftp f = ftpclientpool.borrowObject();

        f.uploadFile(file.getInputStream(), name, filePath);
        ftpclientpool.returnObject(f);
    }

    private StringBuilder getFileName(String name) throws Exception {
        StringBuilder sb = new StringBuilder(name);
        String gs = sb.substring(sb.lastIndexOf("."));
        StringBuilder fileName = new StringBuilder();
        fileName.append(TimeUtil.getCurrentTimeNumByDay());
        String uuid = (int) ((Math.random() * 9 + 1) * 10000000) + "";
        fileName.append(uuid);
        fileName.append(gs);
        return fileName;
    }

    @Override
    public SimpleResult queryPageDTteamsg(PageModel page) throws CommonException {
        SimpleResult sr = null;
        try {
            Page p = page.getPage();
            String dataKey = (String) redisdaoservice.get("DtDoctorQuanServiceImpl:insertDTteamsg");
            String teamGuid = (String) p.get("teamGuid");
            String docGuid = (String) p.get("docGuid");
            //进入聊天室，更新未读消息为0；
            dtteamdocmapper.updateUnreadMsg(docGuid, teamGuid);
            if ("1521".equals(dataKey)) {
                List<Map<String, Object>> mpLi = dtteamsgmapper.queryPageTeamsg(p);
                p.setParameterType(mpLi);
                sr = SimpleResult.success();
                Map teamMp = dtschdocteammapper.queryTeamNum(teamGuid);
                p.put("team", teamMp);
                sr.put("data", p);
            } else {
                Long pageNo = Long.parseLong(String.valueOf(p.getPageNo()));
                Long pageSize = Long.parseLong(String.valueOf(p.getPageSize()));
                Map mp = queryPageRedis(pageSize, pageNo, teamGuid);
                sr = SimpleResult.success();
                sr.put("data", mp);
            }
        } catch (Exception e) {
            LOGGER.error("分页查询redis聊天记录异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "分页查询redis聊天记录异常",e);
        }

        return sr;
    }

    private Map queryPageRedis(Long pageSize, Long pageNo, String teamGuid) throws Exception {
        List<DTteamsg> liPage = new ArrayList<DTteamsg>();
        Map mp = new HashMap();
        if (pageNo <= 0) {
            pageNo = 1l;
        }
        if (pageSize <= 0) {
            pageNo = 10l;
        }
        Long satrt = (pageNo - 1l) * pageSize;
        Long end = pageNo * pageSize;

        List<String> keys = (List<String>) redisdaoservice.lrange("DTteamsgLpush:" + teamGuid, satrt, end);
        for (String k : keys) {
            DTteamsg dg = (DTteamsg) redisdaoservice.get(k);
            if (dg != null) {
                Map<String, Object> docMp = dtschdocteammapper.queryDoctorDetail(dg.getMsgsusrguid());
                if (docMp != null) {
                    dg.setName((String) docMp.get("NAME"));
                    dg.setImg((String) docMp.get("IMG"));
                }

                liPage.add(dg);

            }
        }
        Map teamMp = dtschdocteammapper.queryTeamNum(teamGuid);
        mp.put("pageNo", pageNo);
        mp.put("pageSize", pageSize);
        mp.put("team", teamMp);
        mp.put("parameterType", liPage);
        return mp;
    }

    @Override
    public SimpleResult queryTeamDetail(String teamguid) throws CommonException {
        SimpleResult sr = null;
        List<Map<String, Object>> li = null;
        try {
            if (!StringUtils.isEmpty(teamguid)) {
                li = dtschdocteammapper.queryTeamDetail(teamguid);
            }
            sr = SimpleResult.success();
            sr.put("data", li);
        } catch (Exception e) {
            LOGGER.error("查询医生详情异常：" + e.getMessage(), e);
            throw new CommonException("COM001", "查询医生详情异常",e);
        }
        return sr;
    }

    @Override
    public SimpleResult setType(String key) throws CommonException {
        SimpleResult sr = null;
        try {
            if (!StringUtils.isEmpty(key)) {
                redisdaoservice.set("DtDoctorQuanServiceImpl:insertDTteamsg", key);
            } else {
                throw new CommonException();
            }
            sr = SimpleResult.success();
        } catch (Exception e) {
            LOGGER.error("key不能为空：" + e.getMessage(), e);
            throw new CommonException("COM001", "key不能为空:",e);
        }

        return sr;
    }


}
