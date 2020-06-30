package com.csc3020.hw5.em0608;

public class CalculateHelper {
    double leftValue;
    double rightValue;
    double result;
    MathCommand command;


    public void process(String[] input){
           String[] parts = input.split(" ");
           leftValue = Double.parseDouble(parts[1]);
           rightValue = Double.parseDouble(parts[2]);

            if(parts[0] == "divide") {
                Divider divider = new Divider(leftValue, rightValue);
                divider.calculate();
                divider.getResult();
            }

            else if(parts[0] == "add") {
                command = MathCommand.add;
                Adder adder = new Adder(leftValue, rightValue);
                adder.calculate();
                adder.getResult();
            }

            else if(parts[0] == "subtract") {
                command = MathCommand.subtract;
                Subtractor subtractor = new Subtractor(leftValue, rightValue);
                subtractor.calculate();
                subtractor.getResult();
            }

            else if(parts[0] == "multiply") {
                Multiplier multiplier = new Multiplier(leftValue, rightValue);
                multiplier.calculate();
                multiplier.getResult();
            }

        if(command == MathCommand.divide) {
            System.out.println("/");
        }

        else if(command == MathCommand.add){
            System.out.println("+");
        }

        else if(command == MathCommand.subtract){
            System.out.println("-");
        }

        else if(command == MathCommand.multiply){
            System.out.println("*");
        }
    }

    @Override
    public String toString() {
        return
                " " + leftValue +
                " " + command +
                " " + rightValue +
                " = " + result;
    }
}

