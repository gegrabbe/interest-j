package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MyProperties {
    private static final String PROPERTIES_FILE = "properties.properties";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    Properties properties = new Properties();

    public void loadProperties() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            // If file doesn't exist or can't be read, return empty properties
        }
    }

    public void saveProperties(String firstName, String lastName) {
        properties.setProperty(FIRST_NAME, firstName);
        properties.setProperty(LAST_NAME, lastName);

        try (FileOutputStream fos = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(fos, "User information properties");
        } catch (IOException e) {
            System.err.println("Error saving properties: " + e.getMessage());
        }
    }

    public String value(String key) {
        return properties.getProperty(key, "");
    }
}
