package com.example.labka3.calculator;

public class SampleCalculator { protected final int maxLength = 10;

    protected String number = "";
    protected String memory = "";
    protected String operation = "";

    public SampleCalculator() {
    }

    public String getNumber() {
        return number;
    }

    public String addDigit(String digit) {
        if (number.length() >= maxLength)
            return number;
        if (number.length() > 0 && Long.parseLong(number) == 0)
            number = "";
        return number += digit;
    }

    public boolean setOperation(String operation) {
        if (this.operation.equals("")) {
            memory = number;
            number = "";
            this.operation = operation;
            return true;
        }
        return true;
    }

    public boolean setEqual() {
        switch (this.operation) {
            case "+":
                number = String.valueOf(Long.parseLong(memory) + Long.parseLong(number));
                break;
            case "-":
                number = String.valueOf(Long.parseLong(memory) - Long.parseLong(number));
                break;
            case "*":
                number = String.valueOf(Long.parseLong(memory) * Long.parseLong(number));
                break;
            case "/":
                number = String.valueOf(Long.parseLong(memory) / Long.parseLong(number));
                break;
            default:
                return false;
        }
        this.operation = "";
        memory = "";
        return true;
    }

    public String deleteDigit() {
        if (number.length() > 0)
            number = number.substring(0, number.length() - 1);
        if (number.equals("-"))
            number = "";
        return number;
    }

    public String changeSign() {
        if (number.length() > 0 && Long.parseLong(number) == 0)
            return number;
        if (number.startsWith("-")) {
            number = number.substring(1);
        } else {
            number = "-" + number;
        }
        return number;
    }
}