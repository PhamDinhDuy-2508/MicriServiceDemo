package com.Notification.Notification.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class ProducerService {
    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate ;

    public  void SendMessage(String smsJSonData) {
        kafkaTemplate.send("phamduy" ,  smsJSonData) ;
    }
}
