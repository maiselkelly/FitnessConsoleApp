package com.csc3020.hw5.em0608;

public class HW05Source {
    public static void main(String[] args) {
        String[] mathArray = {"divide 100.0 50.0", "add 25.0 92.0",
                "subtract 225.0 17.0", "multiply 11.0 3.0"};

        String[] practiceArray = {"divide 100.0 50.0"};


        CalculateHelper practice = new CalculateHelper();
        practice.process(practiceArray);


    }
}
