package com.summer26.sec01.group06.apbn.model;

public class ImmigrationOfficer extends User {

    private String officerId;
    private String department;

    public ImmigrationOfficer() {
    }

    public ImmigrationOfficer(String username,
                              String password,
                              String officerId,
                              String department) {

        super(username, password, "Immigration");

        this.officerId = officerId;
        this.department = department;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}