package com.gz.medicine.gzyun.health.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.bean.HealthPushMessage;
import com.gz.medicine.gzyun.health.bean.HealthServiceConfig;
import com.gz.medicine.gzyun.health.bean.HealthTemplateType;
import com.gz.medicine.gzyun.health.reponse.HealthPushMessageCentre;
import com.gz.medicine.gzyun.health.reponse.HealthStatisticsReponse;
import com.gz.medicine.gzyun.health.request.HealthConsultationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 维维
 * <p>
 * Title:HealthDocAppserver
 * </p>
 * <p>
 * Description:TODO(心理医生端App)
 * </p>
 * <p>
 * Company:贯众
 * </p>
 * <p>
 * 数据库:
 * </p>
 * @author
 * @date 2017年9月21日
 */
@Service("healthDocAppserver")
public interface HealthDocAppserver {
    /**
     * 咨询小结接口
     *
     * @param consultation
     * @return
     * @throws CommonException
     */
    String updateItemByIdConsultationSummary(HealthConsultationRequest consultation) throws CommonException;

    /**
     * 图文咨询开始时间提交接口
     *
     * @param consultation
     * @return
     * @throws CommonException
     */
    String updateItemByIdConsultationStartTime(HealthConsultationRequest consultation) throws CommonException;

    /**
     * 咨詢接口
     *
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPageConsultation(PageModel page) throws CommonException;

    /**
     * 医生端订单接口
     *
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPageHealthyOrder(PageModel page) throws CommonException;


    /**
     * 排班统计
     *
     * @return
     * @throws CommonException
     */
   // SimpleResult queryPageSchedulingStatistics(PageModel page) throws CommonException;
    public List<HealthStatisticsReponse> queryPageSchedulingStatistics(String docid,String formdate) throws CommonException;

    /**
     * 排班天数
     * @param
     * @return
     * @throws CommonException
     */
    public HealthStatisticsReponse querySchedulingDays(String docid,String formdate) throws CommonException;

    /**
     *预约统计
     * @param
     * @return
     * @throws CommonException
     */
    public List<HealthStatisticsReponse> queryPageIntervalDate   (String docid, String formdate) throws CommonException;

    /**
     * 预约天数
     * @param docid
     * @param formdate
     * @return
     * @throws CommonException
     */
    public HealthStatisticsReponse queryIntervalDateDays(String docid, String formdate) throws CommonException;
    /**
     * 服务设置
     * @param record
     * @return
     * @throws CommonException
     */
    String insertHealthServiceConfig (HealthServiceConfig record) throws CommonException;

    /**
     * 服务设置查询
     * @param docid
     * @return
     * @throws CommonException
     */
    HealthServiceConfig selectByHealthServiceConfig(String  docid) throws CommonException;


    /**
     * 我的消息
     * @param page
     * @return
     * @throws CommonException
     */
    Page queryPagePushMessage(PageModel page) throws CommonException;

    /**
     * 选择模板
     * @param
     * @return
     * @throws CommonException
     */
    List<HealthTemplateType> selectTemplateType() throws CommonException;


    /**
     * 我的消息详情
     * @param
     * @return
     * @throws CommonException
     */
    Map<String, Object> updateByPushMessage(HealthPushMessage record) throws CommonException;


    /**
     * 系统消息  修改未读 为已读
     * @param record
     * @return
     * @throws CommonException
     */
   String updateByPushMessageSys (HealthPushMessage record) throws CommonException;
    /**
     * 医生端结束详情
     * @param
     * @return
     * @throws CommonException
     */
    Map<String,Object> queryConsultation(String id)throws CommonException;

    /**
     * 我的消息删除
     * @param id
     * @return
     * @throws CommonException
     */
   String  updateByMessageState(String id)throws CommonException;


    /**
     * 消息中心
     * @param userid
     * @return
     * @throws CommonException
     */
    List<HealthPushMessageCentre> selectPushMessage(String userid)throws CommonException;

}
