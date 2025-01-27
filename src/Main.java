import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessApp fitnessApp = new FitnessApp();

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Filter Users by Age");
            System.out.println("5. Sort Users by Age");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (choice) {
                case 1: {
                    // Add user
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    User user = new User(0, name, age, gender, email);
                    fitnessApp.addUser(user);
                    break;
                }
                case 2: {
                    // Update user
                    System.out.print("Enter user ID to update: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();  // consume the newline
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();

                    fitnessApp.updateUser(userId, name, age, gender, email);
                    break;
                }
                case 3: {
                    // Delete user
                    System.out.print("Enter user ID to delete: ");
                    int userId = scanner.nextInt();
                    fitnessApp.deleteUser(userId);
                    break;
                }
                case 4: {
                    // Filter users by age
                    System.out.print("Enter age to filter: ");
                    int age = scanner.nextInt();
                    fitnessApp.filterUsersByAge(age);
                    break;
                }
                case 5: {
                    // Sort users by age
                    fitnessApp.sortUsersByAge();
                    break;
                }
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
