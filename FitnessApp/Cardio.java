package FitnessApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardio extends Workout {

    private Scanner keyboard = new Scanner(System.in);
    private String cardio;
    private int timeInMinutes;
    private List<String> cardioList = new ArrayList<>();
    private List<CardioTracker> cardioTracker = new ArrayList<>();



    public void Cardio(){
        cardioList.add("Stair Climber");
        cardioList.add("Treadmill");
        cardioList.add("Elliptical");
        cardioList.add("Bike");
    }

    public boolean cardioToday(){
        System.out.println("Are you doing cardio today?");
        char result = keyboard.next().charAt(0);
        return (result == 'y' || result == 'Y');
    }

    public void showCardioList(){
        int i = 1;
        for (String cardio : cardioList){
            System.out.println((i++) + ". " + cardio);
        }
        System.out.println("Press 0 to quit");
    }


    public String whatCardio() {
        System.out.println("Choose a cardio workout");
        showCardioList();
        int choiceOfCardio = keyboard.nextInt();
        String cardioDone = cardioList.get(choiceOfCardio-1);
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


    public int timeInMinutes(){
        System.out.println("How much time did you do on cardio?");
        int timeInMinutes = keyboard.nextInt();
        return timeInMinutes;
    }

    public void cardioRoutine(){
        Cardio();
        System.out.println("Check");
        if(cardioToday()) {
            do {
        System.out.println("HERE");
                cardio = whatCardio();
                timeInMinutes = timeInMinutes();
                cardioTracker.add(new CardioTracker(cardio, timeInMinutes));
            } while (finishedWorkingOut());
        }else {
            System.out.println("See ya next time!");
        }
    }

    public void printResults(){
        System.out.println("Today's cardio");

        for(CardioTracker stats : cardioTracker){
            System.out.println(stats.toString());
        }
        System.out.println("Total time on " + cardio +  "  is: " + timeInMinutes+ " minutes.");
    }

}
