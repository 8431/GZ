 package com.gz.medicine.gzyun.kafka.service.impl;

import java.util.List;

import com.gz.medicine.yun.doctor.bean.DoctorOnDuty;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gz.medicine.gzyun.kafka.service.KafkaProductorService;
import com.gz.medicine.yun.doctor.bean.SourceDoc;
import com.gz.medicine.yun.doctor.mapper.DTdocMapper;

@Service
public class KafkaProductorServiceImpl implements KafkaProductorService {
	public static final Logger LOGGER = Logger.getLogger(KafkaProductorServiceImpl.class);
	@Autowired
	@Qualifier("pChannel")
	private MessageChannel messageChannel;
	@Autowired
	private DTdocMapper dTdocMapper;
	public final String key = "key";

	public void sendInfo(String topic)   {
		LOGGER.info("---Service:KafkaService------sendInfo------");
		List<DoctorOnDuty> docList =dTdocMapper.selectDocList();

		if (null != docList) {
			for (DoctorOnDuty doc : docList) {
				String json = JSON.toJSONString(doc);
				 Message<String>  msg = MessageBuilder.withPayload(json).setHeader("kafkaUser", key)
						.setHeader(KafkaHeaders.TOPIC, "kafka-topic").build();
				messageChannel.send(msg); 
			}
		}

	}
}
 