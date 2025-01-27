public class WorkoutRoutine {
    private int id;
    private String routineName;
    private String description;
    private String intensity;

    // Constructor
    public WorkoutRoutine(int id, String routineName, String description, String intensity) {
        this.id = id;
        this.routineName = routineName;
        this.description = description;
        this.intensity = intensity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    // Method to display workout details
    public void displayWorkoutInfo() {
        System.out.println("Routine Name: " + routineName);
        System.out.println("Description: " + description);
        System.out.println("Intensity: " + intensity);
    }
}
