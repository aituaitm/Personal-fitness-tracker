public class User {
    private String username;
    private int age;
    private double weight;
    private WorkoutRoutine workoutRoutine;

    public User(String username, int age, double weight) {
        this.username = username;
        this.age = age;
        this.weight = weight;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addWorkout(WorkoutRoutine workoutRoutine) {
        this.workoutRoutine = workoutRoutine;
    }

    public void displayUserDetails() {
        System.out.println("Username: " + username);
        System.out.println("Age: " + age + ", Weight: " + weight + " kg");
        if (workoutRoutine != null) {
            workoutRoutine.displayWorkoutDetails();
        } else {
            System.out.println("No workout routine assigned.");
        }
    }
}
