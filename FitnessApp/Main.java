package FitnessApp;

public class Main {
    public static void main(String[] args) {
        ExerciseClass workout1 = new ExerciseClass();
        workout1.workoutRoutine();
        workout1.cardioRoutine();
        workout1.printResults();

        System.out.println("");
        System.out.println("Let's track your BMI: ");
        WeightClass firstWeighIn = new WeightClass();
        firstWeighIn.returnBMI();

        System.out.println("");
        System.out.println("Let's track your BMR: ");
        firstWeighIn.returnBMR();

        System.out.println("");
        firstWeighIn.returnActivityLevel();

    }
}
