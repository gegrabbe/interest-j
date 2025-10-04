package org.example.awt;

import javafx.application.Application;
import javafx.stage.Stage;

public class InterestFx extends Application {
    private static final String PROPERTIES_FILE = "interest.properties";

    @Override
    public void start(Stage primaryStage) {
        Display display = new DisplayJavaFx();
        UserPrompts prompts = UserPrompts.readProperties(PROPERTIES_FILE);
        prompts = display.promptUser(prompts);

        if (prompts != null) {
            prompts.storeProperties(PROPERTIES_FILE);
            double calculatedAmount = Calculator.calculateAmount(prompts);
            double interestEarned = calculatedAmount - prompts.principal();
            display.displayEarnedInterest(prompts, calculatedAmount, interestEarned);
        }

        primaryStage.close();
    }

    /**
     * Run from command line with ./gradlew run
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
