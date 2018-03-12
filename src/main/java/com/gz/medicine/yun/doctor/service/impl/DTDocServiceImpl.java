package com.gz.medicine.yun.doctor.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.yun.doctor.bean.DTdoc;
import com.gz.medicine.yun.doctor.mapper.DTdocMapper;
import com.gz.medicine.yun.doctor.reponse.DTdocReponse;
import com.gz.medicine.yun.doctor.request.DTdocRequest;
import com.gz.medicine.yun.doctor.service.DTDocService;

/**
 *登录
 *jin
 **/
@Service
public class DTDocServiceImpl implements DTDocService {


    public static final Logger LOGGER = Logger.getLogger(DTDocServiceImpl.class);
    
    @Autowired
    private DTdocMapper docmapper; 
	
    @Override
	public DTdocReponse select(DTdocRequest data) throws CommonException {
		DTdoc doc = new DTdoc();
		DTdocReponse reponse = new DTdocReponse();
		try {
			doc = docmapper.select(data);
			if(doc != null){
				BeanUtils.copyProperties(doc,reponse);
				String usrpw = data.getPassword();//前端传来密码
				String passwd = doc.getPasswd();//数据库查出密码
				if(passwd.equals(usrpw)){
					return reponse;
				}else{					
					throw new CommonException("001","用户名或密码错误!");	
				}
			}else{
				throw new CommonException("001", "用户名或密码错误!!");
			}
		} catch (Exception e) {
			LOGGER.debug(e.getMessage(), e);
			throw new CommonException("001", "用户名或密码错误!!!", e);
		}
	}
    /**
     * @author jin
     * 分页查询在岗医生
     * **/
	@Override
	public SimpleResult queryPageDocin(PageModel page) throws CommonException {
		 SimpleResult sr=null;
	        List<Map<String,Object>> lists= null;
	        try {
	            Page p=page.getPage();
	            lists = docmapper.queryPageId(p);
	            p.setParameterType(lists);
	            sr=SimpleResult.success();
	            sr.put("data",p);
	        } catch (Exception e) {
	            LOGGER.error("DTDocServiceImpl异常："+e.getMessage(),e);
	            throw new CommonException("COM001","DTDocServiceImpl异常");        }
	        return sr;
	    }

}