package com.spring.kafka.kafka;

import com.spring.kafka.domain.kafka.Demo;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.util.backoff.FixedBackOff;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @Bean
    public CommonErrorHandler errorHandler(KafkaOperations<Object, Object> operations) {
        return new DefaultErrorHandler(
                new DeadLetterPublishingRecoverer(operations),
                new FixedBackOff(1000L, 2L)
        );
    }

    @Bean
    public ConsumerFactory<String, Demo> consumerFactory(Map<String, Object> props) {
        JsonDeserializer<Demo> deserializer = new JsonDeserializer<>(Demo.class);

        deserializer.setRemoveTypeHeaders(false);
        deserializer.setUseTypeHeaders(true);
//        deserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Demo> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Demo> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory(kafkaProperties.buildConsumerProperties()));

        return factory;
    }

}
