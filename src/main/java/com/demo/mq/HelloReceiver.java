package com.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

//@Component
//@RabbitListener(queues = "hello")
public class HelloReceiver {

	@RabbitHandler
	public void process(String hello) {
		System.out.println("Receiver  : " + hello);
	}

}
