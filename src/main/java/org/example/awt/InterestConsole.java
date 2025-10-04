package org.example.awt;

public class InterestConsole {
    private static final String PROPERTIES_FILE = "interest.properties";

    public static void main(String[] args) {
        // Use console display for standalone jar
        Display display = new DisplayConsole();
        UserPrompts prompts = UserPrompts.readProperties(PROPERTIES_FILE);
        prompts = display.promptUser(prompts);

        if (prompts != null) {
            prompts.storeProperties(PROPERTIES_FILE);
            double calculatedAmount = Calculator.calculateAmount(prompts);
            double interestEarned = calculatedAmount - prompts.principal();
            display.displayEarnedInterest(prompts, calculatedAmount, interestEarned);
        }
    }
}
