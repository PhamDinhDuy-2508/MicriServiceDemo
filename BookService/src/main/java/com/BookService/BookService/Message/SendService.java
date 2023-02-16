package com.BookService.BookService.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    KafkaTemplate<String , String> kafkaTemplate ;

    public void SendMessage(String message) {
        kafkaTemplate.send( "phamduy", message);
    }


}
