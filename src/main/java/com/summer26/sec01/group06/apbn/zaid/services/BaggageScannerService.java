package com.summer26.sec01.group06.apbn.zaid.services;

public class BaggageScannerService {

    // -------- Information --------

    public boolean scanBaggage(String passengerName, String baggageId) {
        return !passengerName.isEmpty() && !baggageId.isEmpty();
    }

    public boolean approveBaggage(String baggageId) {
        return !baggageId.isEmpty();
    }

    public boolean rejectBaggage(String baggageId) {
        return !baggageId.isEmpty();
    }

    public boolean searchBaggage(String baggageId) {
        return baggageId.equalsIgnoreCase("B1001");
    }

    // -------- Security --------

    public boolean detectDangerousItem(String baggageId) {
        return !baggageId.isEmpty();
    }

    public boolean rejectDangerousBaggage(String baggageId) {
        return !baggageId.isEmpty();
    }

    public boolean trackSuspiciousBaggage(String trackingId) {
        return !trackingId.isEmpty();
    }

    // -------- Reports --------

    public boolean monitorScanner(String scannerName) {
        return !scannerName.isEmpty();
    }

    public boolean generateReport(String reportType) {
        return !reportType.isEmpty();
    }

    public boolean saveReport() {
        return true;
    }

}