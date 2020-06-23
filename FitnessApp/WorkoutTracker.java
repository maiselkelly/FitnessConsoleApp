package FitnessApp;

public class WorkoutTracker {

    private String exercise;
    private int sets;
    private int reps;
    private int weight;


    public WorkoutTracker() {
    }

    public WorkoutTracker(String exercise){
        this();
        this.exercise = exercise;
    }

    public WorkoutTracker(String exercise, int sets){
        this(exercise);
        this.sets = sets;
    }

    public WorkoutTracker(String exercise, int sets, int reps){
        this(exercise, sets);
        this.reps = reps;
    }

    public WorkoutTracker(String exercise, int sets, int reps, int weight){
        this(exercise, sets, reps);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Workout: " +
                "exercise ='" + exercise + '\'' +
                ", sets =" + sets +
                ", reps =" + reps +
                ", weight =" + weight;
    }


}
