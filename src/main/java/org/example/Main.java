package org.example;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.MyProperties.FIRST_NAME;
import static org.example.MyProperties.LAST_NAME;

public class Main {
    MyProperties properties = new MyProperties();
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
        Main app = new Main();
        app.hello();
    }

    private static String promptForValue(Scanner scanner, String fieldName, String previousValue) {
        if (StringUtils.isNotEmpty(previousValue)) {
            System.out.print("Enter your " + fieldName + " (" + previousValue + "): ");
        } else {
            System.out.print("Enter your " + fieldName + ": ");
        }
        return StringUtils.capitalize(StringUtils.trim(scanner.nextLine()));
    }
}
