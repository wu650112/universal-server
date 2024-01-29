package com.us.bizs.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者
 *
 * @author wufan
 * @date 2024/1/29
 */
@Component
public class DealMyMsg {

    @KafkaListener(topics = "faker")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
