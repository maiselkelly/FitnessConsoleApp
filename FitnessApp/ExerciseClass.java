package FitnessApp;

import WorkoutApp.FirstWorkoutTracker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciseClass {
    //   File filePath = new File();
    private Scanner keyboard = new Scanner(System.in);
    private String exercise;
    private String cardio;
    private int sets;
    private int reps;
    private int weight;
    private int totalWeight;
    private int timeInMinutes;
    private List<String> workoutList = new ArrayList<>();
    private List<String> workoutLog = new ArrayList<>();
    private List<WorkoutTracker> tracker = new ArrayList<>();
    private List<String> cardioList = new ArrayList<>();
    private List<CardioTracker> cardioTracker = new ArrayList<>();


    public void setWorkoutList() {
        workoutList.add("Bench Press");
        workoutList.add("Dead Lift");
        workoutList.add("Squat");
        workoutList.add("Shoulder Press");
    }


    public void setCardioList(){
        cardioList.add("Stair Climber");
        cardioList.add("Treadmill");
        cardioList.add("Elliptical");
        cardioList.add("Bike");
    }

    public boolean workingOutToday() {
        System.out.println("Are you Ready?");
        char result = keyboard.next().charAt(0);
        return (result == 'y' || result == 'Y');
    }

    public boolean finishedWorkingOut() {
        System.out.println("Are you done for today?");
        char result = keyboard.next().charAt(0);
        return (result == 'n' || result == 'N');
    }

    public boolean cardioToday(){
        System.out.println("Are you doing cardio today?");
        char result = keyboard.next().charAt(0);
        return (result == 'y' || result == 'Y');
    }

    public void showWorkoutList() {
        int i = 1;
        for (String workout : workoutList) {
            System.out.println(i++ + ". " + workout);
        }
        System.out.println("Press 0 to Quit.");
    }

    public void showCardioList(){
        int i = 1;
        for (String cardio : cardioList){
            System.out.println(i++ + ". " + cardio);
        }
        System.out.println("Press 0 to quit");
    }

    public String whatExercise() {
        System.out.println("Choose a workout to complete.");
        showWorkoutList();
        int choiceOfExercise = keyboard.nextInt();
        String exerciseDone = workoutList.get(choiceOfExercise);
        switch (choiceOfExercise) {
            case 1:
                System.out.println("Cool, let's do some " + exerciseDone + ".");
                 return exerciseDone;
            case 2:
                System.out.println("Okay awesome I love " + exerciseDone + "!");
                return exerciseDone;
            case 3:
                System.out.println(exerciseDone + " will get you jacked!");
                return exerciseDone;
            case 4:
                System.out.println(exerciseDone + " sound good!");
                return exerciseDone;
            case 0:
                System.out.println("Okay see ya later!");
                return "";
            default:
                System.out.println("Wrong selection, try again!");
                return "";
        }
    }

    public String whatCardio() {
        System.out.println("Choose a cardio workout");
        showCardioList();
        int choiceOfCardio = keyboard.nextInt();
        String cardioDone = cardioList.get(choiceOfCardio);
        switch (choiceOfCardio) {
            case 1:
                System.out.println("Cool, let's do some " + cardioDone + ".");
                return cardioDone;
            case 2:
                System.out.println("Nice, let's do some " + cardioDone + ".");
                return cardioDone;
            case 3:
                System.out.println("Sweet, let's do some " + cardioDone + ".");
                return cardioDone;
            case 4:
                System.out.println("Awesome, let's do some " + cardioDone + ".");
                return cardioDone;
            case 0:
                System.out.println("Okay, maybe next time!");
            default:
                System.out.println("Invalid input, try again!");
                return "";
        }
    }


    public int numberOfSets() {
        System.out.println("How many sets?");
        int sets = keyboard.nextInt();
        return sets;
    }

    public int numberOfReps() {
        System.out.println("How many reps");
        int reps = keyboard.nextInt();
        return reps;
    }

    public int weightUsed() {
        System.out.println("How much weight did you use?");
        int weight = keyboard.nextInt();
        return weight;
    }

    public int timeInMinutes(){
        System.out.println("How much time did you do on cardio?");
        int timeInMinutes = keyboard.nextInt();
        return timeInMinutes;
    }

    public void workoutRoutine() {
        setWorkoutList();
        if (workingOutToday()) {
            do {
                exercise = whatExercise();
                sets = numberOfSets();
                reps = numberOfReps();
                weight = weightUsed();
                totalWeight += weight;
                tracker.add(new WorkoutTracker(exercise, sets, reps, weight));
            } while (finishedWorkingOut());
        } else {
            System.out.println("See ya next time!");
        }
    }


    public void cardioRoutine(){
        setCardioList();
        if(cardioToday()) {
            do {
                cardio = whatCardio();
                timeInMinutes = timeInMinutes();
                cardioTracker.add(new CardioTracker(cardio, timeInMinutes));
            } while (finishedWorkingOut());
        }else {
            System.out.println("See ya next time!");
        }
    }

    public void printResults(){
        System.out.println("Today's workout");
        for(WorkoutTracker stats : tracker){
            System.out.println(stats.toString());
        }
        System.out.println("Total weight lifted is: " + totalWeight);

        for(CardioTracker stats : cardioTracker){
            System.out.println(stats.toString());
        }
        System.out.println("Total time on " + cardio +  "  is: " + timeInMinutes+ " minutes.");
    }

}



