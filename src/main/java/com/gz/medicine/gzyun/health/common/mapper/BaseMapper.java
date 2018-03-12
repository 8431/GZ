package com.gz.medicine.gzyun.health.common.mapper;

import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;

import java.util.List;


/**   
 * @Title: BaseMapper.java 
 * @Package com.fendo.mapper 
 * @Description: mapper基类
 * @author fendo
 * @date 2017年12月2日 下午5:33:05 
 * @version V1.0   
*/
public interface  BaseMapper<T> {
	
    /**获取所有数据(不分页)**/
	List<T> selectAll(T record);

	/**根据主键逻辑删除**/
    int deleteByPrimaryKey(String id);
    
    /**新增数据**/
    int insert(T record);

    /**新增数据**/
    int insertSelective(T record);

    /**根据主键获取数据**/
    T selectByPrimaryKey(String id) throws Exception;

    /**根据条件更新数据**/
    int updateByPrimaryKey(T record);
    
    /**根据条件更新数据**/
    
    int updateByPrimaryKeySelective(T record);
    
    /**获取所有数据(分页)**/
    List<T> queryPage(Page p);

}
