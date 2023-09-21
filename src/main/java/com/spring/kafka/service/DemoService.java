package com.spring.kafka.service;

import com.spring.kafka.domain.request.DemoRequest;
import com.spring.kafka.kafka.Ex1Producer;
import com.spring.kafka.kafka.Ex2Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final Ex1Producer ex1Producer;
    private final Ex2Producer ex2Producer;

    public void sendStringMessage(String message) {
        ex1Producer.send(message);
        log.info("DemoService send message: {}", message);
    }

    public void save(DemoRequest request) {
        // Demo demo = repository.save(request.toDemo());
        ex2Producer.send(request.toDemo());
    }

}
