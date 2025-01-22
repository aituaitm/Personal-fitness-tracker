public class Main {
    public static void main(String[] args) {
        FitnessApp app = new FitnessApp();

        User user1 = new User("Alice", 25, 60.0);
        user1.addWorkout(new WorkoutRoutine("Running", 30, 1, 0));
        user1.addWorkout(new WorkoutRoutine("Push-ups", 10, 3, 15));

        User user2 = new User("Bob", 30, 80.0);
        user2.addWorkout(new WorkoutRoutine("Cycling", 40, 1, 0));

        app.addUser(user1);
        app.addUser(user2);

        System.out.println("All Users:");
        app.displayAllUsers();

        System.out.println("\nUsers sorted by age:");
        app.sortUsersByAge();
        app.displayAllUsers();

        System.out.println("\nSearch for Bob:");
        System.out.println(app.searchUserByName("Bob"));
    }
}
