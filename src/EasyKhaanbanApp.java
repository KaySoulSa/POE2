

public class EasyKhaanbanApp {
    // Define the attributes of a task
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration;
    private final String taskID;
    private  final String taskStatus;

    // Create a constructor for the EasyKhaanbanApp class
    public EasyKhaanbanApp(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = "To Do";
    }

    // Method to check if the task description is valid
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create the task ID
    public final String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastName = developerDetails.split(" ")[1].substring(0, 3).toUpperCase();
        return initials + ":" + taskNumber + ":" + lastName;
    }

    // Method to print the task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Task ID: " + taskID + "\n" +
                "Task Duration: " + taskDuration + "hrs";
    }

    // Method to return the total hours of all tasks
    public static int returnTotalHours(EasyKhaanbanApp[] tasks) {
        int totalHours = 0;
        for (EasyKhaanbanApp task : tasks) {
            totalHours += task.taskDuration;
        }
        return totalHours;
    }

}