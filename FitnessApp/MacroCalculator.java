package FitnessApp;

import java.util.Scanner;

public class MacroCalculator extends WeightManagement {
    protected int weight;
    protected Scanner keyboard = new Scanner(System.in);
    double cCalories;
    double cProtein;
    double cFat;
    double cCarbs;
    double mCalories;
    double mProtein;
    double mFat;
    double mCarbs;
    double bCalories;
    double bProtein;
    double bFat;
    double bCarbs;


    public double cuttingCalories(){
         cCalories = weight * 11;
        return cCalories;
    }

    public double cuttingProtein(){
         cProtein = weight * 1.1;
        return cProtein;
    }

    public double cuttingFat(){
         cFat = weight * 0.3;
        return cFat;
    }

    public double cuttingCarbs(){
        cCarbs = (cCalories - cProtein*4 - cFat * 9) /4;
        return cCarbs;
    }

    public double maintainCalories(){
        mCalories = weight * 11;
        return mCalories;
    }

    public double maintainProtein(){
        mProtein = weight * 1.1;
        return mProtein;
    }

    public double maintainFat(){
        mFat = weight * 0.3;
        return mFat;
    }

    public double maintainCarbs(){
        mCarbs = (cCalories - cProtein*4 - cFat * 9) /4;
        return mCarbs;
    }

    public double bulkCalories(){
        bCalories = weight * 11;
        return bCalories;
    }

    public double bulkProtein(){
        bProtein = weight * 1.1;
        return bProtein;
    }

    public double bulkFat(){
        bFat = weight * 0.3;
        return bFat;
    }

    public double bulkCarbs(){
        bCarbs = (cCalories - cProtein*4 - cFat * 9) /4;
        return bCarbs;
    }


    public void MacroCalculator(){
        System.out.println("Select from one of the following");
        System.out.println("1. Cutting");
        System.out.println("2. Maintaining");
        System.out.println("3. Bulking");
    }


    public void cutMaintainBulk(){
        MacroCalculator();
        int choice = keyboard.nextInt();

        switch (choice){
            case 1:
                System.out.println("Cutting");
                System.out.println("Your weight is " + weight);
                cuttingCalories();
                cuttingProtein();
                cuttingFat();
                cuttingCarbs();
                System.out.println("Protein: " + cProtein + "Fat: " + cFat + "Carbs: " + cCarbs);
                break;
            case 2:
                System.out.println("Maintaining");
                System.out.println("Your weight is " + weight);
                maintainCalories();
                maintainProtein();
                maintainFat();
                maintainCarbs();
                System.out.println("Protein: " + mProtein + "Fat: " + mFat + "Carbs: " + mCarbs);
                break;
            case 3:
                System.out.println("Bulking");
                System.out.println("Your weight is " + weight);
                bulkCalories();
                bulkProtein();
                bulkFat();
                bulkCarbs();
                System.out.println("Protein " + bProtein + "Fat: " + bFat + "Carbs: " + bCarbs);
                break;
        }
    }

}
