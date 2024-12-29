import java.util.ArrayList;
import java.util.List;

public class FitnessApp {
    private List<User> users;

    public FitnessApp() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) { users.add(user); }

    public User searchUserByName(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> filterUsersByWeight(double minWeight) {
        List<User> filtered = new ArrayList<>();
        for (User user : users) {
            if (user.getWeight() >= minWeight) {
                filtered.add(user);
            }
        }
        return filtered;
    }

    public void sortUsersByAge() {
        users.sort((u1, u2) -> Integer.compare(u1.getAge(), u2.getAge()));
    }

    public void displayAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
