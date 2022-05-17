package com.pyaephyom.basiccalculator;

// To perform a basic mathematical operations
public class Model {
    public double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "/":
                if (num2 == 0) { return 0; }
                return num1 / num2;
            default:
                return 0;
        }
    }
}
