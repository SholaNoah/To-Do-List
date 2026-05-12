import java.util.ArrayList;

/** Task Manager 
 * This is the brain of the whole app
 * It handles aading a task, removing a task, marking as completed, listing task,
 * searching for a task, and storing a task in a list
 * @author Shankz
 * Version 1.0
 */

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId = 1; // Assign's unique ID

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add a task
    public void addTask(String title, String description, String dueDate) {
        Task task = new Task(title, description, dueDate, false, nextId++);
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    // Remove a task
    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task removed: " + id);
    }

    // Mark a task as completed
    public void markAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(true);
                System.out.println("Task marked as completed: " + task.getTitle());
                return;
            }
        }
        System.out.println("Task not found: " + id);
    }

    // List all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Search for a task by ID
    public void searchTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("Task found:\n" + task);
                return;
            }
        }
        System.out.println("Task not found: " + id);
    }
}
