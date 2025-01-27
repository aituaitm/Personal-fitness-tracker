public class User extends Person {
    private int userId;

    // Constructor
    public User(int userId, String name, int age, String gender, String email) {
        super(name, age, gender, email);  // Call to the parent constructor (Person)
        this.userId = userId;
    }

    // Getter and Setter for userId
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Override displayPersonInfo() to include userId
    @Override
    public void displayPersonInfo() {
        super.displayPersonInfo();  // Call the parent class method to display common info
        System.out.println("User ID: " + userId);  // Display user-specific info
    }
}
