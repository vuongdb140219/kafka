package com.vuongdo.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg, String key){
        log.info(String.format("%s Sending message... :: %s", key,msg));
        kafkaTemplate.send("myTopic",String.format("%s : Sending message... :: %s", key,msg));
    }
}
