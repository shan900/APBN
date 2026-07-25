package com.summer26.sec01.group06.apbn.model;

public class Passenger {

    private String passengerId;
    private String name;
    private String passportNo;
    private String nationality;
    private String flightNo;
    private String gate;

    public Passenger(String passengerId,
                     String name,
                     String passportNo,
                     String nationality,
                     String flightNo,
                     String gate) {

        this.passengerId = passengerId;
        this.name = name;
        this.passportNo = passportNo;
        this.nationality = nationality;
        this.flightNo = flightNo;
        this.gate = gate;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getNationality() {
        return nationality;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getGate() {
        return gate;
    }

    @Override
    public String toString() {

        return passengerId + "," +
                name + "," +
                passportNo + "," +
                nationality + "," +
                flightNo + "," +
                gate;
    }
}