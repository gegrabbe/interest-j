package org.example.interest;

public class Calculator {

    /**
     * Calculate total amount for after numberOfYears with interestRate
     *
     * @param prompts
     * @return
     */
    public static double calculateAmount(UserPrompts prompts) {
        return prompts.principal()
                * Math.pow(
                (1 + (prompts.interestRate() / prompts.calcPerYear())),
                (prompts.calcPerYear() * prompts.numberOfYears())
        );
    }

}
