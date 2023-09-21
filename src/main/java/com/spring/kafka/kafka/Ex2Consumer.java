package com.spring.kafka.kafka;

import com.spring.kafka.domain.kafka.Demo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Ex2Consumer {

    @KafkaListener(topics = TopicConfig.TOPIC_2)
    public void listen(Demo demo) {
        log.info("Ex2Consumer listen topic EX2 : {}", demo);
//        throw new IllegalArgumentException("Ex2Consumer error");
    }

    @KafkaListener(topics = TopicConfig.TOPIC_2_DLT)
    public void listenDlt(byte[] in) {
        log.info("Ex2Consumer listen topic EX2.DLT : {}", new String(in));
    }

}
