package com.gz.medicine.yun.user.mapper;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.yun.user.bean.Usr;


public interface UsrsMapper {
	public int deleteByPrimaryKey(String guid)  throws Exception;

	public int insert(Usr record)  throws Exception;

	public int insertSelective(Usr record)  throws Exception;

	public Usr selectByPrimaryKey(String id)  throws Exception;

	// 修改不为空的数据
	public int updateByPrimaryKeySelective(Usr usr)  throws Exception;
	// 修改此用户全部数据
	public int updateByPrimaryKey(Usr record)  throws Exception;
	
	/**
     * 随访记录  用户信息
     */
    Usr selectByRecordMessage(String guid) throws CommonException;

	/**
	 * 根据患者ID获取患者信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Usr selectByUsr(String id)  throws Exception;
}