package FitnessApp;

import WorkoutApp.FirstWorkoutTracker;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workout {
        //   File filePath = new File();
        private Scanner keyboard = new Scanner(System.in);
        private String exercise;
        private int sets;
        private int reps;
        private int weight;
        private int totalWeight;
        private List<String> workoutList = new ArrayList<>();
        private List<String> workoutLog = new ArrayList<>();
        private List<WorkoutTracker> tracker = new ArrayList<>();



        public void Workout(){
            workoutList.add("Bench Press");
            workoutList.add("Dead Lift");
            workoutList.add("Squat");
            workoutList.add("Shoulder Press");
        }


        public boolean workingOutToday() {
            System.out.println("Are You Working Out Today?");
            char result = keyboard.next().charAt(0);
            return (result == 'y' || result == 'Y');
        }

        public boolean finishedWorkingOut() {
            System.out.println("Are you done for today?");
            char result = keyboard.next().charAt(0);
            return (result == 'n' || result == 'N');
        }


        public void showWorkoutList() {
            int i = 1;
            for (String workout : workoutList) {
                System.out.println(i++ + ". " + workout);
            }
            System.out.println("Press 0 to Quit.");
        }


        public String whatExercise() {
            System.out.println("Choose a workout to complete.");
            showWorkoutList();
            int choiceOfExercise = keyboard.nextInt();
            String exerciseDone = workoutList.get(choiceOfExercise-1);
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


        public void workoutRoutine() {
            Workout();
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




        public void printResults(){
            System.out.println("Today's workout");
            for(WorkoutTracker stats : tracker){
                System.out.println(stats.toString());
            }
            System.out.println("Total weight lifted is: " + totalWeight);

        }

}

