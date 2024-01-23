package com.vuongdo.kafkademo.controller;

import com.vuongdo.kafkademo.payload.User;
import com.vuongdo.kafkademo.producer.KafkaJsonProducer;
import com.vuongdo.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/sendStr")
    public ResponseEntity<String> sendStrMsg(@RequestBody String message, @RequestParam String key) {
        kafkaProducer.sendMessage(message, key);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/sendJson")
    public ResponseEntity<String> sendJsonMsg(@RequestBody User user) {
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Message queued successfully as Json");
    }
}
