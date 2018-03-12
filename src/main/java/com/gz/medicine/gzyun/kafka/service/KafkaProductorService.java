package com.gz.medicine.gzyun.kafka.service;

 
import org.springframework.stereotype.Service;

 
@Service("kafkaProductorService")
public interface KafkaProductorService {
    public void sendInfo(String topic)  ;
}

