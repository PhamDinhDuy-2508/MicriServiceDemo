package com.Notification.Notification.Controller;

import com.Notification.Notification.Services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class RestControllerNotify {

    @Autowired
    ProducerService producerService  ;
    @GetMapping("/sendmessange")
    public String testSenfSMS() {
        producerService.SendMessage("tetasdasd");
        return ":ojke" ;
    }
}
