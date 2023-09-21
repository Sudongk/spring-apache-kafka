package com.spring.kafka.kafka;

import com.spring.kafka.domain.kafka.Demo;
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
public class Ex2Producer {

    private final KafkaTemplate<String, Demo> kafkaTemplate;

    @Async
    public void send(Demo demo) {
        CompletableFuture<SendResult<String, Demo>> resultCompletableFuture = kafkaTemplate.send(TopicConfig.TOPIC_2, demo);

        log.info("Ex2Producer send message: {}", demo.toString());

        resultCompletableFuture.thenAccept(
                result -> log.info("send after: {}", result.getProducerRecord().value())
        );
    }

}
