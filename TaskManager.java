import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
        Task task = new Task(nextId++, title, description, dueDate, false);
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

    // Call for a task (for editting a task)
    public Task getTaskById(int id){
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // Return null if not found
    }

    // Where to save and load data
    private final String FILE_NAME = "tasks.txt";

    // Save tasks to file
    public void saveTasksToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
        for (Task task : tasks) {
            writer.println(
                task.getId() + "|" +
                task.getTitle() + "|" +
                task.getDescription() + "|" +
                task.getDueDate() + "|" +
                task.isStatus()
            );
        }
        System.out.println("Tasks saved successfully.");
    } catch (IOException e) {
        System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // Load task from file
    public void loadTasksFromFile() {
    File file = new File(FILE_NAME);
    if (!file.exists()) {
        return; // No file yet, nothing to load
    }

    try (Scanner fileScanner = new Scanner(file)) {
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split("\\|");

            if (parts.length == 5) {
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description = parts[2];
                String dueDate = parts[3];
                boolean status = Boolean.parseBoolean(parts[4]);

                Task task = new Task(id, title, description, dueDate, status);
                tasks.add(task);
            }
        }
        System.out.println("Tasks loaded successfully.");
        if (!tasks.isEmpty()) {
        Task.setNextId(tasks.get(tasks.size() - 1).getId() + 1);
           }

    } catch (Exception e) {
        System.out.println("Error loading tasks: " + e.getMessage());
    }
}


}
