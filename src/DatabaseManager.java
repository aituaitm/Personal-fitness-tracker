import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/fitness_tracker";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // Establish database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add a new user to the database
    public void addUser(User user) {
        String query = "INSERT INTO \"User\" (name, age, gender, email) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a new workout routine to the database
    public void addWorkoutRoutine(WorkoutRoutine workout) {
        String query = "INSERT INTO \"WorkoutRoutine\" (routineName, description, intensity) VALUES (?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, workout.getRoutineName());
            ps.setString(2, workout.getDescription());
            ps.setString(3, workout.getIntensity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a list of all users from the database
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM \"User\"";
        try (Connection connection = getConnection(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Get a list of all workout routines from the database
    public List<WorkoutRoutine> getWorkoutRoutines() {
        List<WorkoutRoutine> workoutRoutines = new ArrayList<>();
        String query = "SELECT * FROM \"WorkoutRoutine\"";
        try (Connection connection = getConnection(); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                WorkoutRoutine workoutRoutine = new WorkoutRoutine(rs.getInt("id"), rs.getString("routineName"), rs.getString("description"), rs.getString("intensity"));
                workoutRoutines.add(workoutRoutine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workoutRoutines;
    }

    // Update user information
    public void updateUser(User user) {
        String query = "UPDATE \"User\" SET name = ?, age = ?, gender = ?, email = ? WHERE user_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a user from the database
    public void deleteUser(int userId) {
        String query = "DELETE FROM \"User\" WHERE user_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update workout routine information
    public void updateWorkoutRoutine(WorkoutRoutine workout) {
        String query = "UPDATE \"WorkoutRoutine\" SET routineName = ?, description = ?, intensity = ? WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, workout.getRoutineName());
            ps.setString(2, workout.getDescription());
            ps.setString(3, workout.getIntensity());
            ps.setInt(4, workout.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a workout routine from the database
    public void deleteWorkoutRoutine(int workoutId) {
        String query = "DELETE FROM \"WorkoutRoutine\" WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, workoutId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Sort users by name
    public List<User> sortUsersByName() {
        List<User> users = getUsers();
        users.sort((u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()));
        return users;
    }

    // Filter users by age
    public List<User> filterUsersByAge(int minAge) {
        List<User> users = getUsers();
        List<User> filteredUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getAge() >= minAge) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }
}
