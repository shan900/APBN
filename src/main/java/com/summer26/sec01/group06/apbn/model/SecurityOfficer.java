package com.summer26.sec01.group06.apbn.model;

public class SecurityOfficer {

    private String officerId;
    private String name;
    private String shift;
    private String status;

    public SecurityOfficer(String officerId, String name, String shift, String status) {
        this.officerId = officerId;
        this.name = name;
        this.shift = shift;
        this.status = status;
    }

    public String getOfficerId() {
        return officerId;
    }

    public String getName() {
        return name;
    }

    public String getShift() {
        return shift;
    }

    public String getStatus() {
        return status;
    }
}