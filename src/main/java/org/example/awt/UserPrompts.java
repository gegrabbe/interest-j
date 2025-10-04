package org.example.awt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public record UserPrompts(double principal, double interestRate, int numberOfYears, int calcPerYear) {

    /**
     * Read previous values from file.
     *
     * @return
     */
    public static UserPrompts readProperties(String fileName) {
        Properties properties = new Properties();
        double principal = 100;
        double interestRate = 0.02;
        int numberOfYears = 5;
        int calcPerYear = 12;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
            principal = Double.parseDouble(properties.getProperty("principal", "100"));
            interestRate = Double.parseDouble(properties.getProperty("interestRate", "0.02"));
            numberOfYears = Integer.parseInt(properties.getProperty("numberOfYears", "5"));
            calcPerYear = Integer.parseInt(properties.getProperty("calcPerYear", "12"));
        } catch (IOException e) {
            // If file doesn't exist or can't be read, use default values
        }

        return new UserPrompts(principal, interestRate, numberOfYears, calcPerYear);
    }

    /**
     * Save updated values to file.
     */
    public void storeProperties(String fileName) {
        Properties properties = new Properties();
        properties.setProperty("principal", String.valueOf(principal));
        properties.setProperty("interestRate", String.valueOf(interestRate));
        properties.setProperty("numberOfYears", String.valueOf(numberOfYears));
        properties.setProperty("calcPerYear", String.valueOf(calcPerYear));

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            properties.store(fos, "Interest calculation properties");
        } catch (IOException e) {
            System.err.println("Error saving properties: " + e);
        }
    }
}
