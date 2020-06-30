package com.csc3020.hw5.em0608;

public class Adder extends CalculateBase {
        double sum;


    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        sum = leftVal + rightVal;
        System.out.print("Result= ");
        System.out.println(sum);
    }

}
