package com.example.Employee.Command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteCommand {
    @TargetAggregateIdentifier
    private  String id ;

    public DeleteCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
