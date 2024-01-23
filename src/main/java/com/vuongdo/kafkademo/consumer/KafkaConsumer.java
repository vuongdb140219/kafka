package com.vuongdo.kafkademo.consumer;

import com.vuongdo.kafkademo.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {
//    @KafkaListener(topics = "myTopic",groupId = "myGroup")
    public void consumeMsg(String msg) {
        log.info(format("Consuming the message from myTopic:: %s",msg));
    }

    @KafkaListener(topics = "myTopic",groupId = "myGroup")
    public void consumeJsonMsg(User user) {
        log.info(format("Consuming the message from myTopic:: %s",user.toString()));
    }
}
