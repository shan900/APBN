package com.summer26.sec01.group06.apbn.zaid.models;

public class ScannerMachine {
    private String machineId;
    private String status;

    public ScannerMachine(String machineId, String status) {
        this.machineId = machineId;
        this.status = status;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getStatus() {
        return status;
    }
}