package com.spring.kafka.controller;

import com.spring.kafka.domain.request.DemoRequest;
import com.spring.kafka.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/{message}")
    public void save(@PathVariable String message) {
        demoService.sendStringMessage(message);
    }

    @PostMapping
    public void save(@RequestBody DemoRequest request) {
        demoService.save(request);
    }

}
