package com.tdd.calculator;

public class StringCalculatorTdd {

    private String[] operations = {"+", "-", "*", "/"};

    public int calculate(String param){
        String[] characters = param.split(" ");
        String operator = "";

        int result = Integer.parseInt(characters[0]);

        for(String chracter : characters) {
            if(checkOperator(chracter)) {
                operator = chracter;
            } else {
                result = unitCalculate(operator, result, Integer.parseInt(chracter));
            }
        }
        return result;
    }

    public int unitCalculate(String operator, int result, int num){

        switch (operator){
            case "+":
                return plus(result, num);
            case "-":
                return minus(result, num);
            case "*":
                return multiply(result, num);
            case "/":
                return division(result, num);
            default:
                throw new IllegalArgumentException();
        }

    }

    private boolean checkOperator(String chracter){
        for(String operator : operations){
            if(chracter.equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public int plus(int result, int num){
        return result + num;
    }

    public int minus(int result, int num){
        return result - num;
    }

    public int multiply(int result, int num){
        return result * num;
    }

    public int division(int result, int num){
        return result / num;
    }

}
