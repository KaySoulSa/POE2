import javax.swing.JOptionPane;


public class POETwo {
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        while (true) {
            if (!isLoggedIn) {
                 JOptionPane.showInputDialog("Enter username:");
                 JOptionPane.showInputDialog("Enter password:");
                
                // Assuming login is successful
                isLoggedIn = true;
                JOptionPane.showMessageDialog(null, "Login successful.");
            }

            String[] options = {"Add tasks", "Show report", "Quit"};
            int option = JOptionPane.showOptionDialog(null, "Select an option:", "EasyKanban Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (option) {
                case 0 -> {
                    int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks to add:"));

                    for (int i = 0; i < numTasks; i++) {
                        String taskName = JOptionPane.showInputDialog("Enter task name:");
                        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
                        String developerName = JOptionPane.showInputDialog("Enter developer name:");
                        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));

                        String[] statusOptions = {"To Do", "Done", "Doing"};
                        int statusOption = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);
                        String taskStatus = statusOptions[statusOption];

                        new Task(taskName, taskDescription, developerName, duration, taskStatus);
                    }
                    JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + Task.returnTotalHours());
                }
                case 1 -> // Show report
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                case 2 -> {
                    // Quit
                    JOptionPane.showMessageDialog(null, "Exiting application.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option, please try again.");
            }
        }
    }
}
