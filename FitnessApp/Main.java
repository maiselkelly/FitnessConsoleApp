package FitnessApp;

public class Main {
    public static void main(String[] args) {
//        Workout workout1 = new Workout();
//        workout1.workoutRoutine();
//        workout1.printResults();
//
//        Cardio cardio1 = new Cardio();
//        cardio1.cardioRoutine();
//        cardio1.printResults();

        System.out.println("");
        System.out.println("Let's track your BMI: ");
        WeightManagement firstWeighIn = new WeightManagement();
        firstWeighIn.returnBMI();

        System.out.println("");
        System.out.println("Let's track your BMR: ");
        firstWeighIn.returnBMR();

        System.out.println("");
        firstWeighIn.returnActivityLevel();


        MacroCalculator first = new MacroCalculator();
        first.cutMaintainBulk();



    }
}
