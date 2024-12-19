import java.util.ArrayList;

public class FitnessApp {
    private ArrayList<User> userList;

    public FitnessApp() {
        userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void displayAllUsers() {
        for (User user : userList) {
            user.displayUserDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        WorkoutRoutine routine1 = new WorkoutRoutine("Push-ups", 15, 3, 20);
        WorkoutRoutine routine2 = new WorkoutRoutine("Squats", 20, 4, 15);

        User user1 = new User("Alice", 25, 65.5);
        User user2 = new User("Bob", 30, 80.0);

        user1.addWorkout(routine1);
        user2.addWorkout(routine2);

        FitnessApp app = new FitnessApp();
        app.addUser(user1);
        app.addUser(user2);

        app.displayAllUsers();
    }
}

