package com.summer26.sec01.group06.apbn.zaid.services;

public class ImmigrationService {

    public boolean fetchPassenger(String passportNumber) {

        return passportNumber.equalsIgnoreCase("P1001");

    }

    public boolean verifyPassenger(String passportNumber) {

        return !passportNumber.isEmpty();

    }

    public boolean saveVerification() {

        return true;

    }

}