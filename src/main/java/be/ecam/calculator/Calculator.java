package be.ecam.calculator;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0.0) {
            throw new IllegalArgumentException("divided by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.err.println("Should not have been called that way.");
    }

}