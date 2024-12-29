import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    private double weight;
    private List<WorkoutRoutine> workouts;

    public User(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
        this.workouts = new ArrayList<>();
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Weight must be positive!");
        }
    }
    public List<WorkoutRoutine> getWorkouts() { return workouts; }
    public void addWorkout(WorkoutRoutine workout) { this.workouts.add(workout); }

    public void sortWorkoutsByDuration() {
        workouts.sort((w1, w2) -> Integer.compare(w1.getDuration(), w2.getDuration()));
    }

    public List<WorkoutRoutine> filterWorkoutsByDuration(int minDuration) {
        List<WorkoutRoutine> filtered = new ArrayList<>();
        for (WorkoutRoutine workout : workouts) {
            if (workout.getDuration() >= minDuration) {
                filtered.add(workout);
            }
        }
        return filtered;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weight + ", Workouts: " + workouts;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Double.compare(user.weight, weight) == 0 && super.equals(user);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 31 * Double.hashCode(weight);
    }
}