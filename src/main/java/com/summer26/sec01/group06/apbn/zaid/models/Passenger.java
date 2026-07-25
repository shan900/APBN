package com.summer26.sec01.group06.apbn.zaid.models;

import java.io.Serializable;

public class Passenger implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String passportNumber;
    private String visaStatus;

    public Passenger(String name, String passportNumber, String visaStatus) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.visaStatus = visaStatus;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", visaStatus='" + visaStatus + '\'' +
                '}';
    }
}