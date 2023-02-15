package com.example.Employee.Command.event;

import lombok.Data;

@Data
public class AddEmployeeEvent {
    private String Id;

    private String username;
    private String firstname;
    private String lastname;
    private String kin;
    private Boolean isDiscipline;

    public AddEmployeeEvent(String id, String username, String firstname, String lastname, String kin, Boolean isDiscipline) {
        Id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.kin = kin;
        this.isDiscipline = isDiscipline;
    }

    public AddEmployeeEvent() {
    }

}
