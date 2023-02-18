package com.Notification.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NotificationApplication {
	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate  ;

	@KafkaListener(topics = "phamduy" , groupId = "json")
	public  void consumeMessage(String message) {
		System.out.println("test: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

}
