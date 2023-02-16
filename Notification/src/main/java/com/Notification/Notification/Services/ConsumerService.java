package com.Notification.Notification.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "phamduy" , groupId = "group-id")

    public void consume(String jsondata) {
        System.out.println(jsondata);
    }
}
