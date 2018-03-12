package com.gz.medicine.gzyun.health.common.service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;

import java.util.List;



/**   
 * @Title: BaseService.java 
 * @Package com.fendo.service 
 * @Description: Service基类
 * @author fendo
 * @date 2017年12月3日 下午4:05:40 
 * @version V1.0   
*/
public interface BaseService<T> {
    
	/**根据ID获取单个对象**/
    T find(String id) throws CommonException;
    
    /**根据条件获取多个对象**/
    List<T> findList(T bean) throws CommonException;
    
    /**分页**/
    Page getPage(PageModel page) throws CommonException;
    
    /**根据条件更新数据**/
    T update(T bean) throws CommonException;  
    
    /**新增数据**/
    int insert(T bean) throws CommonException;
    
    /**删除数据**/
    int delete(String id) throws CommonException; 
	
}
