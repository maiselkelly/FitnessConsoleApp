package FitnessApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightManagement extends WeightManagementTracker{
    private int age;
    protected int weight;
    private int heightInInches;
    private int BMI;
    private double BMR;
    private double activity;
    protected Scanner keyboard = new Scanner(System.in);
    private List<WeightManagementTracker> weightTrackers = new ArrayList<>();


    private int findAge(){
        System.out.println("How old are you in years?");
        int age = keyboard.nextInt();
        return age;
    }

    private int findWeight(){
        System.out.println("How much do you weigh");
       int weight = keyboard.nextInt();
        return weight;
    }

    private int findHeight(){
        System.out.println("How tall are you in inches?");
        int heightInInches = keyboard.nextInt();
        return heightInInches;
    }

    private int findBMI(){
        int BMI;
        BMI = ((weight * 703) / (heightInInches * heightInInches));
        return BMI;
    }

    public void returnBMI(){
        age = findAge();
        weight = findWeight();
        heightInInches = findHeight();
        BMI = findBMI();
        weightTrackers.add(new WeightManagementTracker(age, weight, heightInInches));

        System.out.println("Your BMI is: " + BMI);
    }

    public double findBMR(){
        System.out.println("Are you a male or female?");
        char gender = keyboard.next().charAt(0);
        if(gender == 'm' || gender == 'M'){
            double BMR = (66.47 + (6.24 * weight) + (12.7 * heightInInches) - (6.755 * age));
            return BMR;
        }

        else if(gender == 'f' || gender == 'F'){
            double BMR = (665.1 + (4.35 * weight) + (4.7 * heightInInches) - (4.7 * age));
            return BMR;
        }
        else
            System.out.println("Please try again.");
            return 0;
    }

    public void returnBMR(){
       BMR = findBMR();
        System.out.println("Your BMR is " + String.format("%.1f", BMR));
    }

    public void activityList(){
        System.out.println("Select from one of the following");
        System.out.println("1. Little to no exercise");
        System.out.println("2. Light exercise");
        System.out.println("3. Moderate exercise: 3-5 days a week");
        System.out.println("4. Very active: 6-7 days a week");
    }

    public double setActivity(){
        activityList();
        int choiceOfActivity = keyboard.nextInt();

        switch (choiceOfActivity){
            case 1:
                System.out.println("Little to no exercise");
                double activity = BMR * 1.2;
                return activity;
            case 2:
                System.out.println("Light exercise");
                activity = BMR * 1.375;
                return activity;
            case 3:
                System.out.println("Moderate exercise: 3-5 days a week");
                activity = BMR * 1.55;
                return activity;
            case 4:
                System.out.println("Very active: 6-7 days a week");
                activity = BMR * 1.725;
                return activity;
            default:
                System.out.println("Invalid number entry");
        }
        return 0;
    }

    public void returnActivityLevel(){
        activity = setActivity();
        System.out.println("Your actual calorie intake should be: " + String.format("%.1f", activity) + " cals a day.");
    }

}
