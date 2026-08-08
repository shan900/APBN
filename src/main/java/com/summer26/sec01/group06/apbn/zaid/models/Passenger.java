package com.summer26.sec01.group06.apbn.zaid.models;

import java.io.Serializable;

public class Passenger implements Serializable {

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
        return name + " | " + passportNumber + " | " + visaStatus;
    }
    public void setName(String name){
        this.name=name;
    }


    public void setPassportNumber(String passportNumber){
        this.passportNumber=passportNumber;
    }


    public void setVisaStatus(String visaStatus){
        this.visaStatus=visaStatus;
    }
}