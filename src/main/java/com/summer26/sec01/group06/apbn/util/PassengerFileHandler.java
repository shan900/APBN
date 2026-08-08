package com.summer26.sec01.group06.apbn.util;

import com.summer26.sec01.group06.apbn.model.Passenger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PassengerFileHandler {

    private static final String FILE_NAME = "data/passengers.txt";

    public static void savePassenger(Passenger passenger) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(passenger.toString());
            writer.newLine();

            System.out.println("Passenger saved successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}