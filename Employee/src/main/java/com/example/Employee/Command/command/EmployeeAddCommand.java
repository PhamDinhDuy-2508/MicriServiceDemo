package com.example.Employee.Command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class EmployeeAddCommand {
    @TargetAggregateIdentifier
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private String username;
    private String firstname;
    private String lastname;
    private String kin;
    private Boolean isDiscipline;

    public EmployeeAddCommand() {
    }

    public EmployeeAddCommand(String id, String username, String firstname, String lastname, String kin, Boolean isDiscipline) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.kin = kin;
        this.isDiscipline = isDiscipline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getKin() {
        return kin;
    }

    public void setKin(String kin) {
        this.kin = kin;
    }

    public Boolean getDiscipline() {
        return isDiscipline;
    }

    public void setDiscipline(Boolean discipline) {
        isDiscipline = discipline;
    }
}
