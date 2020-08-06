package com.demo.controller;

import com.demo.timingWheel.Timer;
import com.demo.timingWheel.TimerWheel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    final static Timer timer = new TimerWheel();
    @GetMapping("/hello")
    public boolean send(){
        kafkaTemplate.send("testTopic","hello");
        log.info("-------kafka发送--------");
        return true;
    }

    @GetMapping("/time")
    public boolean testTimer(){
        kafkaTemplate.send("testTopic","hello");
        log.info("-------kafka发送--------");
        return true;
    }

}