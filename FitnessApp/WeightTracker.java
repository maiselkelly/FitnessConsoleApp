package FitnessApp;

public class WeightTracker {
    private int age;
    private int weight;
    private int heightInInches;

    public WeightTracker() {
    }

    public WeightTracker(int age){
        this();
        this.age = age;
    }

    public WeightTracker(int age, int weight){
        this(age);
        this.weight = weight;
    }

    public WeightTracker(int age, int weight, int heightInInches){
        this(age, weight);
        this.heightInInches = heightInInches;
    }


}
