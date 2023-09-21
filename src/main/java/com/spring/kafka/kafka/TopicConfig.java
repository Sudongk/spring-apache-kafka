package com.spring.kafka.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    public static final String TOPIC_1 = "EX1";
    public static final String TOPIC_2 = "EX2";
    public static final String TOPIC_2_DLT = "EX2.DLT";

    @Bean
    public NewTopic topic1() {
//        return new NewTopic(topic1, 1, (short) 1);
        return TopicBuilder
                .name(TOPIC_1)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder
                .name(TOPIC_2)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder
                .name(TOPIC_2_DLT)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
