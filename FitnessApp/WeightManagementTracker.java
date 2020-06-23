package FitnessApp;

public class WeightManagementTracker {
    private int age;
    private int weight;
    private int heightInInches;

    public WeightManagementTracker() {
    }

    public WeightManagementTracker(int age){
        this();
        this.age = age;
    }

    public WeightManagementTracker(int age, int weight){
        this(age);
        this.weight = weight;
    }

    public WeightManagementTracker(int age, int weight, int heightInInches){
        this(age, weight);
        this.heightInInches = heightInInches;
    }


}
