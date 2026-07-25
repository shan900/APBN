package com.summer26.sec01.group06.apbn.zaid.models;

public class Baggage {
    private String baggageId;
    private boolean suspicious;

    public Baggage(String baggageId, boolean suspicious) {
        this.baggageId = baggageId;
        this.suspicious = suspicious;
    }

    public String getBaggageId() {
        return baggageId;
    }

    public boolean isSuspicious() {
        return suspicious;
    }
}