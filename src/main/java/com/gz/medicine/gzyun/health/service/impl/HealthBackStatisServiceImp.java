package com.gz.medicine.gzyun.health.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.gz.medicine.common.util.UUIDTool;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.gzyun.health.bean.HealthyDoctorform;
import com.gz.medicine.gzyun.health.bean.HealthyIntervalTime;
import com.gz.medicine.gzyun.health.mapper.HealthConsultationMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyDoctorformMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyIntervalTimeMapper;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import com.gz.medicine.gzyun.health.mapper.OrderLogMapper;
import com.gz.medicine.gzyun.health.mapper.healthDoctorMapper;
import com.gz.medicine.gzyun.health.mapper.healthevaluateMapper;
import com.gz.medicine.gzyun.health.reponse.HealthDocterForm;
import com.gz.medicine.gzyun.health.reponse.HealthDoctorformIdReponse;
import com.gz.medicine.gzyun.health.reponse.HealthForm;
import com.gz.medicine.gzyun.health.reponse.HealthItemByIdSelReponse;
import com.gz.medicine.gzyun.health.reponse.HealthLogIdReponse;
import com.gz.medicine.gzyun.health.reponse.HealthMakeMangeReponse;
import com.gz.medicine.gzyun.health.reponse.HealthyDoctorformreponse;
import com.gz.medicine.gzyun.health.request.HealthDoctorformAllRequest;
import com.gz.medicine.gzyun.health.request.HealthDoctorformIdRequest;
import com.gz.medicine.gzyun.health.request.HealthOrderMakeUpdateRequest;
import com.gz.medicine.gzyun.health.request.HealthOrderStatisRequest;
import com.gz.medicine.gzyun.health.request.HealthyDoctorformrequest;
import com.gz.medicine.gzyun.health.service.HealthBackStatisService;

/**
 * 后台管理serviceimp层
 * @author 舵主
 *
 * 上午11:14:35
 */
@Service("HealthBackStatisService")
public class HealthBackStatisServiceImp implements HealthBackStatisService{
	 public static final Logger LOGGER = Logger.getLogger(HealthBackStatisServiceImp.class);
	
	 @Autowired
	 HealthyDoctorformMapper  healthyDoctorformMapper;
	 
	 @Autowired
	 HealthyOrderMapper  healthyOrderMapper;

	 @Autowired
	 HealthConsultationMapper healthConsultationMapper;
	 
	 @Autowired
	 healthevaluateMapper healthevaluateMapper;
	 
	 @Autowired
	 healthDoctorMapper healthDoctorMapper; 
	 
	 @Autowired
	 HealthyIntervalTimeMapper healthyIntervalTimeMapper;
	 
	 @Autowired
	 OrderLogMapper orderLogMapper;
	 
	/**
	 * 排班管理
	 */
	@Override
	public List<HealthDocterForm>  queryListByMapHealthyDoctorform(HealthyDoctorformrequest data) throws CommonException {
		List<HealthDocterForm> healthDocterFormList = new ArrayList<HealthDocterForm>();
		try {
			List<HealthyDoctorformreponse> healthyDoctorList =healthyDoctorformMapper.queryListByMapHealthyDoctorform(data);
			
			
			if(healthyDoctorList!=null && healthyDoctorList.size()>0){
				String healthytypesettingtime = "";
				List<HealthForm> healthFormList = null;
				HealthDocterForm healthDocterForm = null;
				for(HealthyDoctorformreponse healthyDoctor : healthyDoctorList){
					if(!healthytypesettingtime.equals(healthyDoctor.getHealthytypesettingtime())){
						healthytypesettingtime = healthyDoctor.getHealthytypesettingtime();
						
						healthDocterForm = new HealthDocterForm(); 
						healthDocterForm.setDate(healthytypesettingtime);
						healthFormList = new ArrayList<HealthForm>();
						healthDocterFormList.add(healthDocterForm);
						healthDocterForm.setDoclist(healthFormList);
					}
				    StringBuffer sb=new StringBuffer();
					if(!StringUtils.isEmpty(healthyDoctor.getIntervaldate())){
						//排序管理----------satrt
		 				String[] arr=healthyDoctor.getIntervaldate().split(",");
						List<String> li=new ArrayList();
					    for(String s:arr){
					    	 li.add(s);
					    }
					    Collections.sort(li);
					    for(int i=0;i<li.size();i++){
					    	if(i==li.size()-1){
					    		sb.append(li.get(i));
					    	}else{
					    		sb.append(li.get(i)+",");
					    	}
					  
					    }
					   
					  //排序管理----------end
					}
					HealthForm healthForm = new HealthForm();
					healthForm.setDocname(healthyDoctor.getDocname());
					healthForm.setIntervaldate(sb.toString());
					healthFormList.add(healthForm);
				}
			}
			
        } catch (Exception e) {
            LOGGER.error("排班管理数据查询异常："+e.getMessage(),e);
            throw new CommonException("COM001","排班管理数据查询异常");        
        }
		return healthDocterFormList;
	}



	/**
	  * 预约统计接口（订单总数）
	  * @author 舵主
	  *
	  * 下午1:53:06
	  */
	@Override
	public List<Map<String,Object>> queryListByOrderNum(HealthOrderStatisRequest data) throws CommonException {
		List<Map<String,Object>> list = null;
		try {
			list =healthyOrderMapper.queryListByOrderNum(data);
        } catch (Exception e) {
            LOGGER.error("预约统计接口查询异常："+e.getMessage(),e);
            throw new CommonException("COM001","预约统计接口查询异常");        
        }
		return list;
	}


	/**
	  * 累计问诊量(已咨询的咨询信息)
	  * @author 舵主
	  *
	  * 下午3:07:50
	  */
	@Override
	public List<Map<String,Object>> queryListByInterCum(HealthOrderStatisRequest data) throws CommonException {
		List<Map<String,Object>> list = null;
		try {
			list =healthConsultationMapper.queryListByInterCum(data);
		} catch (Exception e) {
			 LOGGER.error("累计问诊量查询异常："+e.getMessage(),e);
	         throw new CommonException("COM001","累计问诊量查询异常");  
		}
		return list;
	}
	
	
	
	/**
	  * 累计评价数
	  * @author 舵主
	  *
	  * 下午3:07:50
	  */
	@Override
	public List<Map<String,Object>> queryListByeValuaCum(HealthOrderStatisRequest data) throws CommonException {
		List<Map<String,Object>> list = null;
		try {
			list =healthevaluateMapper.queryListByeValuaCum(data);
		} catch (Exception e) {
			 LOGGER.error("累计评价数查询异常："+e.getMessage(),e);
	            throw new CommonException("COM001","累计评价数查询异常");  
		}
		return list;
	}



	/**
	 * 查所有医生
	 * 舵主
	 */
	@Override
	public List<Map<String,Object>> queryListDoctorName() throws CommonException {
		List<Map<String,Object>> list = null;
		try {
			list =healthDoctorMapper.queryListDoctorName();
		} catch (Exception e) {
			 LOGGER.error("查所有医生异常："+e.getMessage(),e);
	         throw new CommonException("COM001","查所有医生异常");  
		}
		return list;
	}


	/**
     * 医生搜索排班接口
     * 舵主
     */
	@Override
	public List<HealthDoctorformIdReponse> queryDoctorformseach(HealthDoctorformIdRequest data) throws CommonException {
		List<HealthDoctorformIdReponse> list = null;
		try {
			list =healthyDoctorformMapper.queryDoctorformseach(data);
		} catch (Exception e) {
			 LOGGER.error("医生搜索排班异常："+e.getMessage(),e);
	         throw new CommonException("COM001","医生搜索排班异常");  
		}
		return list;
	}



	/**
	 * 新增排班信息
	 * 舵主
	 */
	@Override
	public String createItemDoctorform(HealthDoctorformAllRequest data) throws CommonException {
		HealthyDoctorform 	healthDoctorform = new HealthyDoctorform();	
		HealthyIntervalTime healthyIntervalTime	 = new HealthyIntervalTime();
		List<HealthDoctorformIdReponse> listReponse = null;
		HealthDoctorformIdRequest aa = new HealthDoctorformIdRequest();
		List<String> list = new ArrayList<String>();
		try {
			// 根据传过来的时间和医生ID查询医生所有排班信息
			BeanUtils.copyProperties(aa, data);
			listReponse = healthyDoctorformMapper.queryDoctorformseach(aa);
			for (HealthDoctorformIdReponse sss : listReponse) {
				list.add(sss.getDatea());
			}
			// 判断传过来的值是否和list中的值一致，如：一致就修改时段表中的时段     不一致：就新增排班信息  再新增排班时段表
			for (String str : list) {
				// 遍历多次 如何统一判断
				if(str.contains(data.getDatea())){
					// 判断有此日期  修改时段表
				}else{
					// copy
					BeanUtils.copyProperties(healthDoctorform, data);
					// 新增信息
					healthyDoctorformMapper.createItemDoctorform(healthDoctorform);
					// 取出表中的唯一标识
					String doctorformId = healthDoctorform.getId();
					healthyIntervalTime.setDoctorformid(healthDoctorform.getId());
					healthyIntervalTime.setIntervaldate(healthDoctorform.getIntervaldate());
					//给排班时段表新增时段
					healthyIntervalTimeMapper.insertIntervalTime(healthyIntervalTime); 
				}
			}
		} catch (Exception e) {
			 LOGGER.error("医生搜索排班异常："+e.getMessage(),e);
	         throw new CommonException("COM001","医生搜索排班异常");  
		}
		return null;
	}


	/**
	 * 预约管理
	 * @author 舵主
	 *
	 * 下午2:06:08
	 */
	@Override
	public Page  queryPageMakeMange(PageModel page) throws CommonException {
		List<HealthMakeMangeReponse> list = null;
		Page p = page.getPage();
		try {
			list = healthConsultationMapper.queryPageMakeMange(p);
			for (HealthMakeMangeReponse hh : list) {
				// 判断时间字段
				System.out.println("aaaa");
				if(hh.getReservationtime()!=""&&hh.getReservationtime()!=null){
					hh.setSendstatus("1");
				}else{
					hh.setSendstatus("2");
				}
			}
			p.setParameterType(list);
		} catch (Exception e) {
			 LOGGER.error("预约管理异常："+e.getMessage(),e);
	         throw new CommonException("COM001","预约管理异常");  
		}
		return p;
	}



	/**
	 * 预约修改接口
	 * 舵主
	 */
	@Override
	public void updateIdMake(HealthOrderMakeUpdateRequest data) throws CommonException {
		try {
			healthyOrderMapper.updateIdMake(data);
			
			HealthOrderMakeUpdateRequest logaa = new HealthOrderMakeUpdateRequest();
			BeanUtils.copyProperties(logaa,data );
			if(data.getDatea()!=null&&data.getDatea()!=""||data.getTimea()!=null&&data.getTimea()!=""){
				logaa.setOpencontent("预约时间改为："+data.getDatea()+" "+data.getTimea());
				// 新增日志
				orderLogMapper.insertItemByIdSelLog(logaa);
			}
		} catch (Exception e) {
			 LOGGER.error("预约修改异常："+e.getMessage(),e);
	         throw new CommonException("COM001","预约修改异常");  
		}
	}




	public Integer addDocForm2(List<HealthDoctorformAllRequest> re) throws CommonException {
		Integer result = 0;
		try {
			List<Map<String, Object>> formLi = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> timeLi = new ArrayList<Map<String, Object>>();
			Gson gn = new Gson();
			if (re != null && re.size() > 0) {
				for (HealthDoctorformAllRequest h : re) {
					String uuid = null;
					//删除时段表标志
					boolean key = true;
					HealthyDoctorform df = healthyDoctorformMapper.queryDoctorformBydocidAndDate(h.getDocid(), h.getDatea());
					if (df == null) {
						//新增操作
						Map<String, Object> m = new HashedMap();
						m.put("docid", h.getDocid());
						m.put("healthytypesettingtime", h.getDatea());
						m.put("id", UUIDTool.getUUID());
						formLi.add(m);
						uuid = (String) m.get("id");
						key = false;
					} else {
						uuid = df.getId();
						List<String> intervalLi = healthyIntervalTimeMapper.queryHealthyIntervalTime(uuid);
						String[] idate = h.getIntervaldate().split(",");

						if (intervalLi != null && intervalLi.size() > 0) {
							if (idate.length == intervalLi.size()) {
								for (int i = 0; i < intervalLi.size(); i++) {
									if (!intervalLi.contains(idate[i])) {
										key = false;
									}
								}


							} else {
								key = false;
							}

						}
						if (key) {
							healthyDoctorformMapper.update(df.getId());
						}

						//删除 包含uuid的数据
						healthyIntervalTimeMapper.update(df.getId());
					}
					//排班时段开关
					if (!key) {
						//新增排班时段数据
						String[] idate = h.getIntervaldate().split(",");
						for (String s : idate) {
							//新增操作
							Map<String, Object> t = new HashedMap();
							t.put("intervaldate", s);
							t.put("doctorformid", uuid);
							timeLi.add(t);
						}

					}


				}
			}
			//执行批量新增排班时间
			insertBatch(formLi, "HEALTHYDOCTORFORM");
			//执行批量新增排班时段
			insertBatch(timeLi, "HEALTHYINTERVALTIME");
			result = formLi.size() + timeLi.size();
		} catch (Exception e) {
			LOGGER.error("新建医生排班异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "新建医生排班异常");
		}
		return result;
	}

	private void insertBatch(List<Map<String, Object>> formLi, String tbleName) throws Exception {
		if (formLi.size() > 0) {
			Map<String, Object> mp = new HashedMap();
			mp.put("tableName", tbleName);//聊天消息表
			mp.put("cloumn", formLi.get(0).keySet());//聊天消息表
			mp.put("val", formLi);
			healthyOrderMapper.insertForBatch(mp);
		}

	}

	/**
	 * 新增排班
	 * 舵主
	 */
	@Override
	public Integer addDocForm(List<HealthDoctorformAllRequest> re) throws CommonException {
		Integer result = 0;
		try {
			List<Map<String, Object>> formLi = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> timeLi = new ArrayList<Map<String, Object>>();
			if (re != null && re.size() > 0) {
				for (HealthDoctorformAllRequest h : re) {
					String uuid = null;
					//删除时段表标志
					boolean key = true;
					HealthyDoctorform df = healthyDoctorformMapper.queryDoctorformBydocidAndDate(h.getDocid(), h.getDatea());
					if (df == null) {
						//新增操作
						Map<String, Object> m = new HashedMap();
						m.put("docid", h.getDocid());
						m.put("healthytypesettingtime", h.getDatea());
						m.put("id", UUIDTool.getUUID());
						formLi.add(m);
						//新增排班时段数据
						String[] idate = h.getIntervaldate().split(",");
						for (String s : idate) {
							//新增操作
							Map<String, Object> t = new HashedMap();
							t.put("intervaldate", s);
							t.put("doctorformid", m.get("id"));
							timeLi.add(t);
						}
					} else {
						uuid = df.getId();
						List<String> intervalLi = healthyIntervalTimeMapper.queryHealthyIntervalTime(uuid);
						String[] idate = h.getIntervaldate().split(",");
						if (idate.length == intervalLi.size()) {
							for (int i = 0; i < intervalLi.size(); i++) {
								if (!intervalLi.contains(idate[i])) {
									key = false;
								}
							}

							if(key){
								healthyDoctorformMapper.update(df.getId());
							}

						}
						for (int i = 0; i < idate.length; i++) {
							if (!intervalLi.contains(idate[i])) {
								//新增操作
								Map<String, Object> t = new HashedMap();
								t.put("intervaldate", idate[i]);
								t.put("doctorformid", uuid);
								timeLi.add(t);
							} else {
								//删除操作
								healthyIntervalTimeMapper.updateByIntervaldate(uuid, idate[i]);
							}
						}

					}

				}
				//执行批量新增排班时间
				insertBatch(formLi, "HEALTHYDOCTORFORM");
				//执行批量新增排班时段
				insertBatch(timeLi, "HEALTHYINTERVALTIME");
				result = formLi.size() + timeLi.size();

			}
		} catch (Exception e) {
			LOGGER.error("新建医生排班异常：" + e.getMessage(), e);
			throw new CommonException("COM001", "新建医生排班异常");
		}
		return result;
	}


	
	

	/**
	 * 查询单个预约信息
	 * @author 舵主
	 *
	 * 下午2:11:04
	 */
	@Override
	public HealthItemByIdSelReponse queryItemByIdSel(String orderid) throws CommonException {
		 HealthItemByIdSelReponse healthItemByIdSelReponse = new HealthItemByIdSelReponse();
		 List<HealthLogIdReponse> healthLogIdReponseList = new ArrayList<HealthLogIdReponse>();
		try {
			// 查询预约信息
			healthItemByIdSelReponse =healthyOrderMapper.queryItemByIdSel(orderid);
			// 查询日志信息
			healthLogIdReponseList =orderLogMapper.queryItemByIdSelLog(orderid);
			// 将日志信息加入到返回结果集中
			healthItemByIdSelReponse.setLogifo(healthLogIdReponseList);
		} catch (Exception e) {
			 LOGGER.error("预约修改异常："+e.getMessage(),e);
	         throw new CommonException("COM001","查看单个咨询信息异常");  
		}
		return healthItemByIdSelReponse;
	}

	
	
	
	

}
