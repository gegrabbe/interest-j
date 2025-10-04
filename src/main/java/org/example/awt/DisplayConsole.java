package org.example.awt;

import java.util.Scanner;

public class DisplayConsole implements Display {

    /**
     * Display Values to the user.
     *
     * @param prompts
     * @param calculatedAmount
     * @param interestEarned
     */
    public void displayEarnedInterest(UserPrompts prompts, double calculatedAmount, double interestEarned) {
        System.out.println(prompts);
        System.out.printf("Total Amount: %.2f, Interest Earned: %.2f%n", calculatedAmount, interestEarned);
    }

    /**
     * Prompt use for updated values.
     *
     * @return
     */
    public UserPrompts promptUser(UserPrompts previous) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter principal amount (" + previous.principal() + "): ");
            String principalInput = scanner.nextLine().trim();
            double newPrincipal = principalInput.isEmpty() ? previous.principal() : Double.parseDouble(principalInput);

            System.out.print("Enter interest rate as a decimal value (" + previous.interestRate() + "): ");
            String rateInput = scanner.nextLine().trim();
            double newInterestRate = rateInput.isEmpty() ? previous.interestRate() : Double.parseDouble(rateInput);

            System.out.print("Enter number of years (" + previous.numberOfYears() + "): ");
            String yearsInput = scanner.nextLine().trim();
            int newNumberOfYears = yearsInput.isEmpty() ? previous.numberOfYears() : Integer.parseInt(yearsInput);

            System.out.print("Enter calculations per year (" + previous.calcPerYear() + "): ");
            String calcInput = scanner.nextLine().trim();
            int newCalcPerYear = calcInput.isEmpty() ? previous.calcPerYear() : Integer.parseInt(calcInput);

            return new UserPrompts(newPrincipal, newInterestRate, newNumberOfYears, newCalcPerYear);
        }
    }

}
