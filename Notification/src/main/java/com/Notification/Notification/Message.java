package com.Notification.Notification;

public class Message {
    private  String Id ;
    private  String message ;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {
    }

    public Message(String id, String message) {
        Id = id;
        this.message = message;
    }
}
