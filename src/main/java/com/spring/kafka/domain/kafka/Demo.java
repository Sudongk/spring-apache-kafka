package com.spring.kafka.domain.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Demo {

    private UUID id;
    private String name;
    private String desc;

}
