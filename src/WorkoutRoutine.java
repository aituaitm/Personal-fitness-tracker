public class WorkoutRoutine {
    private String exerciseName;
    private int duration;
    private int sets;
    private int repetitions;

    public WorkoutRoutine(String exerciseName, int duration, int sets, int repetitions) {
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void displayWorkoutDetails() {
        System.out.println("Exercise: " + exerciseName);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Sets: " + sets + ", Repetitions per set: " + repetitions);
    }
}
