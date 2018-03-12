package com.gz.medicine.gzyun.heaman.service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkPermsgRecord;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkReport;
import com.gz.medicine.gzyun.heaman.bean.HmGzjkSetTable;
import com.gz.medicine.gzyun.heaman.bean.HmReportVo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7 0007.
 */
public interface HmGzjkPermsgRecordService {
    /**
     * by dlf
     * 九、	基本健康档案信息查询接口（查询）
     * @param guid 患者账号
     * @return
     */
    List<HmGzjkPermsgRecord> selectByPrimaryKeyUsrGuid(String guid)throws CommonException;

    /**
     * by dlf
     * 十、	个人信息写入接口（写入）
     * @param gd
     * @return
     * @throws Exception
     */
    String updatePersonMsg(HmGzjkPermsgRecord gd) throws  CommonException;

    /**
     * 十一、健康评估列表接口 （查询）
     * @param guid
     * @return
     * @throws Exception
     */
    List<HmGzjkReport> selectGzjkReportMsg(String guid)throws  CommonException;

    /**
     * 十二、健康评估详情接口 （查询）
     * @param guid
     * @return
     * @throws Exception
     */
    List <HmReportVo> getHealthyDetail(String guid)throws  CommonException;

    /**
     * 十三、健康方案列表接口 （查询）
     * @param guid
     * @return
     * @throws Exception
     */
    List <HmReportVo> getHeaPlanList(String guid)throws  CommonException;
    /**
     * 十四、健康方案详情接口 （查询）
     * @param guid
     * @return
     * @throws Exception
     */
    List <HmReportVo> getHeaPlanDetails(String guid)throws  CommonException;

    /**
     * 十五、套餐接口 （查询）
     * @return
     * @throws Exception
     */
    List <HmGzjkSetTable>getComBo()throws  CommonException;
}
