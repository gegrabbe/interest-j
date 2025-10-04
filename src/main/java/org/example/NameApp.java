package org.example;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.NameProperties.FIRST_NAME;
import static org.example.NameProperties.LAST_NAME;

/**
 * Simple main routine that asks for your first and last name then says hello.
 */
public class NameApp {
    NameProperties properties = new NameProperties();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

    public void hello() {
        properties.loadProperties();
        try (Scanner scanner = new Scanner(System.in)) {

            String firstName = promptForValue(scanner, "first name", properties.value(FIRST_NAME));
            String lastName = promptForValue(scanner, "last name", properties.value(LAST_NAME));

            properties.saveProperties(firstName, lastName);

            String formattedTime = LocalTime.now().format(formatter);

            System.out.println("Hello " + firstName + " " + lastName);
            System.out.println("The current time is: " + formattedTime);
        }
    }

    public static void main(String[] args) {
        NameApp app = new NameApp();
        app.hello();
    }

    private static String promptForValue(Scanner scanner, String fieldName, String previousValue) {
        if (previousValue.isEmpty()) {
            System.out.print("Enter your " + fieldName + ": ");
        } else {
            System.out.print("Enter your " + fieldName + " (" + previousValue + "): ");
        }
        String input = StringUtils.capitalize(
                StringUtils.trimToEmpty(scanner.nextLine()).toLowerCase());
        return input.isEmpty() ? previousValue : input;
    }
}
