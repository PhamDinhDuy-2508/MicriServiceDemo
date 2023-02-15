package com.example.Employee.Command.event;

import lombok.Data;

@Data
public class DeleteEventEvent {
    private  String id ;

    public DeleteEventEvent() {
    }

    public DeleteEventEvent(String id) {
        this.id = id;
    }
}
