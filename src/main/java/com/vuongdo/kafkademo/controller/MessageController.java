package com.vuongdo.kafkademo.controller;

import com.vuongdo.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message, @RequestParam String key) {
        kafkaProducer.sendMessage(message, key);
        return ResponseEntity.ok("Message queued successfully");
    }
}
