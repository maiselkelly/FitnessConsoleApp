package com.csc3020.hw5.em0608;

public class Divider extends CalculateBase {
    double quotient;


    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }


    @Override
    public void calculate() {
        if (rightVal != 0) {
            quotient = leftVal / rightVal;
            System.out.print("Result= ");
            System.out.println(quotient);
        }else
            System.out.println("Can't divide by 0");
    }

}