package com.spring.kafka.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Ex1Consumer {

    @KafkaListener(topics = TopicConfig.TOPIC_1)
    public void listen(String message) {
        log.info("Ex1Consumer listen topic EX1 : {}", message);
    }

}
