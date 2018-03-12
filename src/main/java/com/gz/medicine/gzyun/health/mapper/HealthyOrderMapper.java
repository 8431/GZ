package com.gz.medicine.gzyun.health.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.gzyun.health.bean.HealthyOrder;
import com.gz.medicine.gzyun.health.reponse.*;
import com.gz.medicine.gzyun.health.request.HealthOrderMakeUpdateRequest;
import com.gz.medicine.gzyun.health.request.HealthOrderStatisRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HealthyOrderMapper {

	int insert(HealthyOrder record);

	int insertSelective(HealthyOrder record);

	/**
	 *  动态字段,根据主键来更新符合条件的数据库记录:HEALTHYORDER
	 *
	 * @param record
	 */
	int updateByPrimaryKeySelective(HealthyOrder record);


	/**
	 * 1.我的订单 by json snow
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryPageMyOrder(Page p) throws Exception;

	/**
	 * 2.我的订单详情 by json snow
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> queryMyOrderDetail(String orderId) throws Exception;

	/**
	 * 3.我的咨询列表
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryPageMyConsultation(Page p) throws Exception;

	/**
	 * 查询评价详情
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryConsultationScore(String id) throws Exception;

	/**
	 * 查询医生评价分值详情
	 * 
	 * @param docguid
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> queryDocScore(String docguid) throws Exception;

	/**
	 * 医生端 订单接口
	 * 
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<HealthyOrderReponse> queryPageHealthyOrder(Page p) throws Exception;

	/**
	 * 根据订单ID获取订单
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	HealthyOrder selectOrderById(String orderid)throws Exception;

	
	/**
	 * 预约统计量接口（订单）
	 * @author 舵主
	 *
	 * 下午1:47:27
	 */
	List<Map<String,Object>> queryListByOrderNum(HealthOrderStatisRequest data) throws Exception;


	/**
	 * 预约修改接口
	 * @author 舵主
	 *
	 * 下午6:18:52
	 */
	void updateIdMake(HealthOrderMakeUpdateRequest data)throws Exception;
	


	/**
	 * 根据订单ID更改订单状态
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	int updateOrderStateByOrderId(Map maps)throws Exception;


	/**
	 * 根据订单ID修改支付方式
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	int updatePaymentMethodByOrderId(Map maps)throws Exception;

	/**
	 * 根据订单ID修改第三方支付订单编号
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	int updateThirdOrderCodeByOrderId(Map maps)throws Exception;

	/**
	 * 根据订单ID更改订单
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	int updateOrderByOrderId(Map maps)throws Exception;

	/**
	 * 获取医生排版时间
	 * @param docid
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>>  queryDocTime(String docid)throws Exception;
	/**
	 * 查询24小时退订的订单
	 * @return
	 */
	List<ExpireOrderReponse> queryExpireOrder();
	/**
	 * 批量新增
	 * @param mp
	 * @return
	 * @throws Exception
	 */
	int  insertForBatch(Map<String,Object> mp)throws Exception;



	/**
	 * 查看预约信息 
	 * @author 舵主
	 *
	 * 下午1:53:53
	 */
	HealthItemByIdSelReponse queryItemByIdSel(String orderid) throws Exception;

	
	/**
	 * 短信发送接口校验
	 * 舵主
	 */
	HealthQueryIdByOrder  queryIdByOrder(String orderid) throws Exception;

	/**
	 * 后代订单管理分页查询
	 * @param p
	 * @return
	 * @throws Exception
	 */
   List<Map<String,Object>>queryPageOrderForMoHo(Page p)throws Exception;

	/**
	 * 内部专用sql by  dlf
	 * @param mp
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> exuSql(Map<String,Object> mp)throws Exception;

	/**
	 * 聊天记录分页查询
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> queryPageChatMsg(Page p)throws Exception;

	/**
	 * 查询患者表头像和名称
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> queryUsrMsg(String id)throws Exception;


	/**
	 * 后代订单管理分页查询 v2版本
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>>queryPageOrderForMoHoForV2(Page p)throws Exception;

	/**
	 * 订单详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String,Object> queryOrderById(String id)throws Exception;

	/**
	 * 2017-10-30 v2版本咨询服务接口
	 * @param p
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryPageMyOrderForV2(Page p) throws Exception;

	/**
	 *  *2017-10-30 v2查询评价详情
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> queryConsultationScoreForV2(String id) throws Exception;


	/**
	 * 根据订单ID获取退款进度
	 * @return
	 * @throws CommonException
	 */
	List<Map<String,Object>> selectByOrderLogId(String orderid)throws CommonException;

	/**
	 * 获取所有今天的订单
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> selectByOrderList() throws CommonException;

	/**
	 * 超时没支付(30分钟未支付)
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> TimeoutOrderList(String currentTime) throws CommonException;

	/**
	 * 订单已过期(1小时)
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> OutDateOrderList(String currentTime) throws CommonException;

	/**
	 * 医生24小时未回复
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> OutDateOrderRefundList(String currentTime) throws CommonException;

	/**
	 * 前5分钟
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> MinutesOrderList(String currentTime) throws CommonException;

	/**
	 * 根据用户ID获取最近的一条订单信息
	 * @param userid
	 * @return
	 * @throws CommonException
	 */
	HealthyOrder selectTopByUserId(String userid)throws CommonException;


	/**
	 * 根据
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> selectByTime(@Param("startTime") String startTime,@Param("endTime") String endTime)throws CommonException;

	/**
	 * 根据订单状态分页获取数据
	 * @param page
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> queryPageOrderBystate(Page page)throws CommonException;

	/**
	 * 根据用户ID和订单状态获取订单数
	 * @param usrid
	 * @param orderstate
	 * @return
	 * @throws CommonException
	 */
	int countByOrderState(@Param("usrid")String usrid,@Param("orderstate")String orderstate)throws CommonException;


	/**
	 * 根据患者ID获取咨询小结
	 * @param page
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrderlistResponse> queryPageConsultaion(Page page)throws CommonException;


	/**
	 * 根据订单状态获取订单
	 * @param orderstate
	 * @return
	 * @throws CommonException
	 */
	List<HealthyOrder> selectByStateList(@Param("orderstate") String orderstate)throws CommonException;
}