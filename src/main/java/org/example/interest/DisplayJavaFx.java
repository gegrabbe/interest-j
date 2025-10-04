package org.example.interest;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class DisplayJavaFx implements Display {

    public void displayEarnedInterest(UserPrompts prompts, double calculatedAmount, double interestEarned) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Interest Calculation Results");
        alert.setHeaderText("Calculation Complete");

        String content = String.format(
            "Principal: $%d%n" +
            "Interest Rate: %.4f%n" +
            "Number of Years: %d%n" +
            "Calculations Per Year: %d%n%n" +
            "Total Amount: $%.2f%n" +
            "Interest Earned: $%.2f",
            Double.valueOf(prompts.principal()).longValue(),
            prompts.interestRate(),
            prompts.numberOfYears(),
            prompts.calcPerYear(),
            calculatedAmount,
            interestEarned
        );

        alert.setContentText(content);
        alert.showAndWait();
    }

    public UserPrompts promptUser(UserPrompts previous) {
        Dialog<UserPrompts> dialog = new Dialog<>();
        dialog.setTitle("Interest Calculator");
        dialog.setHeaderText("Enter Calculation Parameters");

        ButtonType calculateButtonType = new ButtonType("Calculate", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(calculateButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField principalField = new TextField(String.valueOf(Double.valueOf(previous.principal()).longValue()));
        TextField interestRateField = new TextField(String.valueOf(previous.interestRate()));
        TextField numberOfYearsField = new TextField(String.valueOf(previous.numberOfYears()));
        TextField calcPerYearField = new TextField(String.valueOf(previous.calcPerYear()));

        grid.add(new Label("Principal Amount:"), 0, 0);
        grid.add(principalField, 1, 0);
        grid.add(new Label("Interest Rate (decimal):"), 0, 1);
        grid.add(interestRateField, 1, 1);
        grid.add(new Label("Number of Years:"), 0, 2);
        grid.add(numberOfYearsField, 1, 2);
        grid.add(new Label("Calculations Per Year:"), 0, 3);
        grid.add(calcPerYearField, 1, 3);

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> principalField.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == calculateButtonType) {
                try {
                    double principal = Double.parseDouble(principalField.getText());
                    double interestRate = Double.parseDouble(interestRateField.getText());
                    int numberOfYears = Integer.parseInt(numberOfYearsField.getText());
                    int calcPerYear = Integer.parseInt(calcPerYearField.getText());
                    return new UserPrompts(principal, interestRate, numberOfYears, calcPerYear);
                } catch (NumberFormatException e) {
                    return previous;
                }
            }
            return null;
        });

        Optional<UserPrompts> dialogResult = dialog.showAndWait();
        return dialogResult.orElse(null);
    }

}
