package org.example.interest;

public interface Display {

    void displayEarnedInterest(UserPrompts prompts, double calculatedAmount, double interestEarned);

    UserPrompts promptUser(UserPrompts previous);
}
