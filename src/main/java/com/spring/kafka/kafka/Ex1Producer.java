package com.spring.kafka.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class Ex1Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Async
    public void send(String message) {
        CompletableFuture<SendResult<String, String>> resultCompletableFuture =
                kafkaTemplate.send(TopicConfig.TOPIC_1, message);

        log.info("Ex1Producer send message: {}", message);

        resultCompletableFuture.thenAccept(
                result -> log.info("send after: {}", result.getProducerRecord().value())
        );
    }

}
