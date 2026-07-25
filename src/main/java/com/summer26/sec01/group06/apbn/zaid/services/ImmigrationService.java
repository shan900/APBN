package com.summer26.sec01.group06.apbn.zaid.services;

import com.summer26.sec01.group06.apbn.zaid.models.Passenger;

public class ImmigrationService {

    public String verifyPassenger(Passenger passenger) {

        if (passenger.getName().isEmpty() ||
                passenger.getPassportNumber().isEmpty()) {

            return "Please enter passenger name and passport number.";
        }

        if (passenger.getVisaStatus().equals("Valid")) {
            return "Passenger Verified Successfully.";
        }

        return "Verification Failed: Visa is " + passenger.getVisaStatus();
    }

    public String approvePassenger(Passenger passenger) {

        if (passenger.getVisaStatus().equals("Valid")) {
            return "Passenger Approved for Departure.";
        }

        return "Cannot approve. Passenger verification failed.";
    }

    public String rejectPassenger(Passenger passenger) {
        return "Passenger Rejected.";
    }
}