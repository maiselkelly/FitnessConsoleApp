package FitnessApp;

public class CardioTracker {
    private String cardio;
    private int timeInMinutes;

    public CardioTracker() {
    }

    public CardioTracker(String cardio){
        this();
        this.cardio = cardio;
    }

    public CardioTracker(String cardio, int timeInMinutes){
        this(cardio);
        this.timeInMinutes = timeInMinutes;
    }


}
