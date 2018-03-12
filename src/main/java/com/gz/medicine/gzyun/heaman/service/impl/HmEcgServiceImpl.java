package com.gz.medicine.gzyun.heaman.service.impl;


import com.gz.medicine.common.util.MobileCode;
import com.gz.medicine.gzyun.user.mapper.UsrMapper;
import com.gz.medicine.gzyun.user.service.UsrService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.UUIDTool;
import com.gz.medicine.gzyun.heaman.bean.HmEcgabno;
import com.gz.medicine.gzyun.heaman.mapper.HmEcgabnoMapper;
import com.gz.medicine.gzyun.heaman.service.HmEcgService;
import com.gz.medicine.gzyun.user.bean.Usr;

/**
 *
 * @Title: HmEcgServiceImpl.java
 * @Package com.gz.medicine.gzyun.heaman.service.impl
 * @Description: 心电 服务接口实现类
 * @Author fendo
 * @Date 2017年8月8日 下午5:03:12
 * @Version V1.0
 */
@Service
public class HmEcgServiceImpl implements HmEcgService {

	@Autowired
	HmEcgabnoMapper hmEcgabnoMapper;

	@Autowired
	UsrService usrService;

	@Autowired
	UsrMapper usrMapper;


	/**
	 * 日志对象
	 */
    public static final Logger LOGGER = Logger.getLogger(HmEcgServiceImpl.class);

	@Override
	public SimpleResult ECGabno(String usrguid,String type,String value) throws CommonException {

		int areCount=0;//房早异常数
		int avaCount=0;//室早异常数
		int liaCount=0;//长间歇异常数
		SimpleResult simpleResult=null;

		if(!StringUtils.isNotBlank(usrguid)) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "usrguid不能为空!");
		}

		if(!StringUtils.isNotBlank(type)) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "type不能为空!");
		}

		if(!StringUtils.isNotBlank(value)) {
			return SimpleResult.error(SimpleCode.ERROR.getCode(), "value不能为空!");
		}

		try {

			HmEcgabno data=new HmEcgabno();

			//插入数据
			data.setGuid(UUIDTool.getUUID());
			data.setUsrguid(usrguid);
			data.setType(type);
			data.setValue(value);
			hmEcgabnoMapper.insert(data);

			//如果心电异常超过五次发短信提醒
			int count=hmEcgabnoMapper.selectCountByUsrguid(data);

			if(count*1>=30) {

				//房早异常
				areCount=hmEcgabnoMapper.selectCountByUsrguidAre(data);

				//室早异常
				avaCount=hmEcgabnoMapper.selectCountByUsrguidAva(data);

				//长间歇异常
				liaCount=hmEcgabnoMapper.selectCountByUsrguidLia(data);

				//获取统计数
				int scount=hmEcgabnoMapper.selectNavByUsrguid(data);

					if(scount*1>=10) {

						Usr usr = usrMapper.selectByPrimaryKey(data.getUsrguid());
						String content="您的心电有异常：房早异常"+areCount+"次、室早异常"+avaCount+"次、长间歇异常"+liaCount+"次，请及时处理";
						boolean flag = MobileCode.sendAuthCode(usr.getMobile(), content);
						//String result=usrService.sendAuthContent(usr.getMobile(), content);
						if(flag) {
							simpleResult=new SimpleResult("000","短信发送成功!");
							return simpleResult;
						}else {
							simpleResult=new SimpleResult("001","短信发送失败!");
							return simpleResult;
						}
					}


				}

				simpleResult=new SimpleResult("000","数据录入成功!");
				return simpleResult;

			} catch (Exception e) {
				LOGGER.error(e);
				return SimpleResult.error(SimpleCode.ERROR.getCode(), "心电异常写入失败!");
			}


	}

}
