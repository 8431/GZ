package com.gz.medicine.gzyun.kafka.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.medicine.gzyun.kafka.service.KafkaProductorService;

/**
 * kafka定时任务
 * 
 * @author sunff
 *
 */
@Service("kafkaProductorServiceTask")
public class KafkaProductorServiceTask {

	@Autowired
	KafkaProductorService kafkaProductorService;

	public void startTask() {
		kafkaProductorService.sendInfo("kafka-topic");
	}

}
