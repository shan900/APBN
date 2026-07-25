package com.summer26.sec01.group06.apbn.model;

public class Flight {

    private String flightNo;
    private String destination;
    private String departureTime;
    private String gate;
    private String status;

    public Flight(String flightNo,
                  String destination,
                  String departureTime,
                  String gate,
                  String status) {

        this.flightNo = flightNo;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getGate() {
        return gate;
    }

    public String getStatus() {
        return status;
    }
}