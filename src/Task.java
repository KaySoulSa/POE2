import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public final class Task {
    private static int taskCounter = 0;
    private final static List<Task> tasks = new ArrayList<>();
    
    private final String taskName;
    private final String taskDescription;
    private final String developerName;
    private final int duration;
    private final String taskStatus;

    private final String taskID;

    public Task(String taskName, String taskDescription, String developerName, int duration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.duration = duration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        
        JOptionPane.showMessageDialog(null, printTaskDetails());
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        if (!checkTaskDescription()) {
            return "";
        }
        String initials = taskName.length() >= 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        String devInitials = developerName.split(" ")[0].substring(0, 1) + developerName.split(" ")[1].substring(0, 1);
        return initials + ":" + taskCounter++ + ":" + devInitials.toUpperCase();
    }

    public String printTaskDetails() {
        if (!checkTaskDescription()) {
            return "Task Description is too long.";
        }
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nDuration: %d hrs",
                taskStatus, developerName, taskCounter - 1, taskName, taskDescription, taskID, duration);
    }

    public static int returnTotalHours() {
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.duration;
        }
        return totalHours;
    }
}
