package com.pyaephyom.basiccalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class CalculatorController {

    @FXML private AnchorPane field;
    @FXML private Label labelDisplay;
    @FXML private Label labelCalculate;
    private double num1 = 0.0;
    private String operator = "";
    private boolean start = true;
    private final Model model = new Model();
/*
    public void insertNumber(String number) {
        labelCalculate.setText(labelCalculate.getText() + number);
    }

    public void insertOperator(String operator) {
        labelCalculate.setText(labelCalculate.getText() + " " + operator + " ");
    }

    public void clearExpression() {
        labelCalculate.setText("");
        labelDisplay.setText("0.0");
    }

    public void signExpression(String button) {

        String num = labelCalculate.getText();

        switch (button) {
            case "+/-" -> {
                labelCalculate.setText(String.valueOf(num1 * (-1)));
                labelDisplay.setText(String.valueOf(num1 * (-1)));
            }
            case "." -> {
                labelCalculate.setText(labelCalculate.getText() + ".");
                labelDisplay.setText(labelDisplay.getText() + ".");
            }
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {

        Button button = (Button) mouseEvent.getSource();
        String inputBtn = button.getText();

        switch (inputBtn) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0":
                insertNumber(inputBtn);
                break;
            case "+", "-", "x", "/":
                insertOperator(inputBtn);
                break;
            case "AC", "C":
                clearExpression();
                break;
            case "+/=", ".":
                signExpression(inputBtn);
                break;
            case "=":
                double num2 = Double.parseDouble(labelDisplay.getText());
                double result = model.calculate(num1, num2, operator);          // call calculate function
                labelDisplay.setText(String.valueOf(result));
        }
    }*/

    @FXML
    public void onNumberClicked(ActionEvent event) {
        if (start) {
            labelDisplay.setText("");
            labelCalculate.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        labelDisplay.setText(labelDisplay.getText() + value);
        labelDisplay.setVisible(false);
        labelCalculate.setText(labelCalculate.getText() + "" + value + "");
    }

    @FXML
    public void onSymbolClicked(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            }

            operator = value;
            num1 = Double.parseDouble((labelDisplay.getText()));
            labelDisplay.setText("");
            labelCalculate.setText(labelCalculate.getText() + " " + value + " ");
        }
        else {
            if (operator.isEmpty()) return;

            double num2 = Double.parseDouble(labelDisplay.getText());
            double result = model.calculate(num1, num2, operator);          // call calculate function
            labelDisplay.setVisible(true);
            labelDisplay.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    @FXML
    public void onSignClicked(ActionEvent event) {
        String button = ((Button)event.getSource()).getText();
        num1 = Double.parseDouble(labelDisplay.getText());
        switch (button) {
            case "+/-" -> {
                labelCalculate.setText(String.valueOf(num1 * (-1)));
                labelDisplay.setText(String.valueOf(num1 * (-1)));
            }
            case "." -> {
                labelCalculate.setText(labelCalculate.getText() + ".");
                labelDisplay.setText(labelDisplay.getText() + ".");
            }
        }
    }

    @FXML
    public void onClearClicked(ActionEvent event) {
        labelDisplay.setText("");
        labelCalculate.setText("");
    }
}
