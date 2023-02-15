package com.example.Employee.Command.model;

import lombok.Builder;


public class EmployeeModel {
    private String id;

    private String username;
    private String firstname;
    private String lastname;
    private String kin;
    private Boolean isDiscipline;

    public EmployeeModel(String id, String username, String firstname, String lastname, String kin, Boolean isDiscipline) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.kin = kin;
        this.isDiscipline = isDiscipline;
        this.id = id ;
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
