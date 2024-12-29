public class WorkoutRoutine {
    private String exerciseName;
    private int duration; // in minutes
    private int sets;
    private int repetitions;

    public WorkoutRoutine(String exerciseName, int duration, int sets, int repetitions) {
        this.exerciseName = exerciseName;
        this.duration = duration;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getExerciseName() { return exerciseName; }
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }
    public int getRepetitions() { return repetitions; }
    public void setRepetitions(int repetitions) { this.repetitions = repetitions; }

    @Override
    public String toString() {
        return "Workout: " + exerciseName + " (" + sets + " sets, " + repetitions + " reps, " + duration + " mins)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WorkoutRoutine that = (WorkoutRoutine) obj;
        return duration == that.duration && sets == that.sets && repetitions == that.repetitions &&
                exerciseName.equals(that.exerciseName);
    }

    @Override
    public int hashCode() {
        return exerciseName.hashCode() + 31 * duration + 31 * sets + 31 * repetitions;
    }
}
