package com.gz.medicine.gzyun.health.mapper;

import java.util.*;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzyun.health.bean.HealthConsultation;
import com.gz.medicine.gzyun.health.reponse.PsychoLogistReponse;
import com.gz.medicine.gzyun.health.request.HealthOrderStatisRequest;
import com.gz.medicine.gzyun.health.request.HealthmessageRequest;
import com.gz.medicine.gzyun.health.reponse.HealthConsultationReponse;
import com.gz.medicine.gzyun.health.reponse.HealthMakeMangeReponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthConsultationMapper
 * @PackageName com.gz.medicine.gzyun.health.mapper
 * @Description 心理咨询 Mapper
 * @Data 2017-09-21 10:47
 **/
public interface HealthConsultationMapper {

    int deleteByPrimaryKey(String id);

	int insert(HealthConsultation record);

	int insertSelective(HealthConsultation record);

	HealthConsultation selectByPrimaryKey(String id);

	HealthConsultation selectByPrimaryOrderId(String orderid) throws CommonException;

	int updateByPrimaryKeySelective(HealthConsultation record) throws CommonException;

	int updateByPrimaryKey(HealthConsultation record);

	/**
	 * 咨询小结接口
	 */
	int updateItemByIdConsultationSummary(HealthConsultation record);

	/**
	 * 图文咨询开始时间提交接口
	 */
	int updateItemByIdConsultationStartTime(HealthConsultation record);

	/**
	 * 咨询接口
	 *
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<HealthConsultationReponse> queryPageConsultation(Page p) throws Exception;

	/**
	 * 咨询消息接口
	 *
	 * @param p
	 * @return
	 * @throws Exception
	 */
    List<HealthConsultationReponse> queryPageDocid(Page p) throws Exception;

	/**
	 * 医生端结束详情
	 * @param id
	 * @return
	 */
	Map<String,Object> queryConsultation(String id);

	/**
	 * 心理医生列表
	 * @param p
	 * @return
	 */
	List<PsychoLogistReponse> queryPageHealthConsultationaList(Page p);

	List<PsychoLogistReponse> queryPageHealthConsultationa(Page p);

	/**
	 * 根据医生ID获取排班
	 * @param docid
	 * @return
	 */
	List<Map<String,String>> selectDoctorForm(@Param("docid")String  docid);

	/**
	 * 根据患者获取ID
	 * @param usrid
	 * @return
	 */
	Map<String,String> selectByUsrID(String usrid);

	/**
	 * 订单咨询
	 * @param docid
	 * @return
	 */
	Map<String,Object> selectConsultingOrderByDocid(String docid);
	
	/**
	 * 累计问诊量 
	 * @author 舵主
	 *
	 * 下午3:11:07
	 */
	List<Map<String,Object>> queryListByInterCum(HealthOrderStatisRequest data)throws Exception;
	

	/**
	 * 预约管理 
	 * @author 舵主
	 *
	 * 下午2:06:08
	 */
	List<HealthMakeMangeReponse> queryPageMakeMange(Page p) throws Exception;
	

	
	/**
	 * 通过订单编号查用户id
	 * @author 舵主
	 *
	 */
	HealthConsultation queryIdByOrder(HealthmessageRequest data)throws Exception;

	/**
	 * 通过订单编号修改信息发送状态
	 * @author 舵主
	 *
	 */
	int updateStateById(String orderid)throws Exception;


	/**
	 * 根据订单ID获取咨询信息
	 * @param orderid
	 * @return
	 */
	Integer selectCountById(String orderid);
	/**
	 * 评价消息查询详情接口
	 * **/
	List<HealthConsultationReponse> queryMessage(String orderid) throws Exception;

	/**
	 * 修改其消息为已读
	 * **/
	
	int updateNotRead(HealthConsultation data);
	/**
	 * 查询订单时间
	 * **/
	HealthConsultation queryTime(String orderid);

	/**
	 * 根据
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	int checkDate(@Param("startTime")String startTime, @Param("endTime")String endTime,@Param("userid")String userid);


	/**
	 * 获取当前数据库时间
	 * @return
	 * @throws CommonException
	 */
	Date getCurrentDates()throws CommonException;

	/**
	 * 根据用户ID获取判断是否是测试
	 * @return
	 * @throws CommonException
	 */
	int getCountUserTest(@Param("id") String id)throws CommonException;

}