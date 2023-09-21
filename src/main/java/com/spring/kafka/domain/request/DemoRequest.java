package com.spring.kafka.domain.request;

import com.spring.kafka.domain.kafka.Demo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DemoRequest {

    private String name;
    private String desc;

    public Demo toDemo() {
        return new Demo(UUID.randomUUID(), name, desc);
    }

}
