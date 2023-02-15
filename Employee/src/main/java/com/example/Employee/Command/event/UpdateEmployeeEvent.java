package com.example.Employee.Command.event;

public class UpdateEmployeeEvent {
    private String Id;

    private String username;
    private String firstname;
    private String lastname;
    private String kin;
    private Boolean isDiscipline;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
