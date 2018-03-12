package com.gz.medicine.yun.doctor.mapper;

import java.util.List;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.yun.doctor.bean.DTfollowupPlan;
import com.gz.medicine.yun.doctor.bean.DTfollowupRecord;

import com.gz.medicine.yun.doctor.bean.DTmessageRecord;
import com.gz.medicine.yun.doctor.bean.DTmessageTemplate;
import com.gz.medicine.yun.doctor.reponse.DTfollowupRecordResponse;
import com.gz.medicine.yun.doctor.request.DTfollowupRecordRequest;

/**
 * 随访计划mapper层
 * 
 * @author Administrator
 *
 */
public interface DTfollowupRecordMapper {

	int deleteByPrimaryKey(String guid);

	int insert(DTfollowupRecord record);

	int insertFollowUp(DTfollowupRecordRequest data);

	int insertSelective(DTfollowupRecord record);

	DTfollowupRecord selectByPrimaryKey(String guid);

	int updateByPrimaryKeySelective(DTfollowupRecord record);

	int updateByPrimaryKey(DTfollowupRecord record);

	/**
	 * 视频详情
	 */
	List<DTfollowupRecordResponse> selectDTfollowupRecord(String guid);

	/**
	 * 根据医生的GUID查询随访任务列表（搜索、分页）
	 * 
	 * @author 舵主
	 *
	 *         下午2:20:40
	 */
	List<DTfollowupPlan> follUpTasks(Page p);

	 /**
     * 随访任务选择模板查询内容接口
     * @author 舵主
     *
     * 下午6:15:40
     */
    String sfSMSdetails(String guid);

	/**
	 * 随访任务发送短信
	 * 
	 * @author 舵主
	 *
	 *         下午3:57:54
	 */
	int addSMSreTasks(DTmessageRecord dTmessageRecord);

	/**
	 *
	 * @Title queryPageUserGuid
	 * @Description: 随访信息就诊记录列表 ---- 根据患者ID获取就诊记录列表
	 * @Author fendo
	 * @Date 2017年8月24日 上午10:52
	 * @param page
	 * @return List<DTfollowupRecord>
	 */
	List<DTfollowupRecord> queryPageUserGuid(Page page);

	/**
	 * 根据医生usrguid随访任务加载短信详情
	 * 
	 * @author 舵主 下午3:57:54
	 */
	List<DTmessageTemplate> loadDetails(String docguid);

	/**
	 * pc端 随访记录
	 */
	List<DTfollowupRecord> queryPageMessageRecord(Page page);

}