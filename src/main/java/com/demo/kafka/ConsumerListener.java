package com.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "testTopic")
    public void onMessage(String message){
        log.info("-------kafka接收到信息--------: {}",message);
    }

    @KafkaListener(topics = "test2")
    public void onMessage2(String message){
        log.info("-------kafka接收到信息--------: {}",message);
    }

}