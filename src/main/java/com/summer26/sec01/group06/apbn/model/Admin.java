package com.summer26.sec01.group06.apbn.model;

public class Admin extends User {

    private String adminId;

    public Admin() {
    }

    public Admin(String username,
                 String password,
                 String adminId) {

        super(username, password, "Admin");

        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}