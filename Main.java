import java.util.Scanner;

/** Main class for To-Do List
 * This is the interactive part of the program
 * @author Shankz
 * Version 1.0
 */

public class Main {
    public static void main(String [] args) {
        TaskManager taskmanager = new TaskManager();
        taskmanager.loadTasksFromFile(); // Load tasks at startup
        Scanner scanner = new Scanner(System.in);

        // ---- Menu Setup ----
        int choice = 0;
        do{
            System.out.println("\n==== To-Do List Menu ====");
            System.out.println("1. Display Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");
            System.out.println("7. Edit task");
               System.out.println("Enter your choice: ");
               
                // --- INPUT VALIDATION STARTS HERE ---
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    scanner.nextLine(); // clear the wrong input
                    continue;           // restart the loop
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice < 1 || choice > 7) {
                 System.out.println("Choice out of range. Please enter a number between 1 and 6.");
                    continue;
                }
                // --- VALIDATION ENDS HERE ---

               switch (choice) {
                case 1: taskmanager.listTasks();
                    break;
                
                case 2: System.out.println("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.println("Enter task due date (DD-MM-YYYY): ");
                    String dueDate = scanner.nextLine();
                    taskmanager.addTask(title, description, dueDate);
                    taskmanager.saveTasksToFile(); // Save after adding a task
                    break;

                case 3: System.out.println("Enter task ID to remove: ");

                    if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Task ID must be a number.");
                    scanner.nextLine(); // clear wrong input
                    break;              // go back to menu
            }

                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.removeTask(removeId);
                    break;

                case 4: System.out.println("Enter task ID to mark as completed: ");

                    if (!scanner.hasNextInt()){
                        System.out.println("Invalid input. Task ID must be a number.");
                        scanner.nextLine(); // clear wrong input
                        break;              // go back to menu
                    }

                    int completeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.markAsCompleted(completeId);
                    break;

                case 5: System.out.println("Enter task ID to search: ");

                    if (!scanner.hasNextInt()){
                        System.out.println("Invalid input. Task ID must be a number.");
                        scanner.nextLine(); // clear wrong input
                        break;              // go back to menu
                    }

                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.searchTask(searchId);
                    break;

                case 6: System.out.println("Adios Amigo...");
                    break;

                case 7: System.out.print("Enter task ID to edit: ");

                    if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Task ID must be a number.");
                    scanner.nextLine(); // clear wrong input
                    break;
                    }

                    int editId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    Task taskToEdit = taskmanager.getTaskById(editId);

                        if (taskToEdit == null) {
                        System.out.println("Task not found.");
                        break;
                        }

                    System.out.println("\nWhat would you like to edit?");
                    System.out.println("1. Title");
                    System.out.println("2. Description");
                    System.out.println("3. Due Date");
                    System.out.println("4. Status (Completed / Not Completed)");
                    System.out.print("Enter your choice: ");

                        if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number between 1 and 4.");
                        scanner.nextLine();
                        break;
                        }

                    int editChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (editChoice) {
                        case 1:
                        System.out.print("Enter new title: ");
                        String newTitle = scanner.nextLine();
                        taskToEdit.setTitle(newTitle);
                        System.out.println("Title updated.");
                        break;

                        case 2:
                        System.out.print("Enter new description: ");
                        String newDescription = scanner.nextLine();
                        taskToEdit.setDescription(newDescription);
                        System.out.println("Description updated.");
                        break;

                        case 3:
                        System.out.print("Enter new due date (DD-MM-YYYY): ");
                        String newDueDate = scanner.nextLine();
                        taskToEdit.setDueDate(newDueDate);
                        System.out.println("Due date updated.");
                        break;

                        case 4:
                        // You can either toggle or ask explicitly
                        System.out.println("Current status: " + (taskToEdit.isStatus() ? "Completed" : "Not Completed"));
                        System.out.print("Mark as completed? (yes/no): ");
                        String statusInput = scanner.nextLine().trim().toLowerCase();
                        if (statusInput.equals("yes") || statusInput.equals("y")) {
                        taskToEdit.setStatus(true);
                        System.out.println("Status set to Completed.");
                        } else if (statusInput.equals("no") || statusInput.equals("n")) {
                        taskToEdit.setStatus(false);
                        System.out.println("Status set to Not Completed.");
                        } else {
                        System.out.println("Invalid input. Status not changed.");
                        }
                        break;

                    default:
                    System.out.println("Invalid choice. No changes made.");
                    break;
                    }

    System.out.println("Task updated successfully.");
    break;


            
               }
        } while (choice != 6);
        scanner.close();
    }
}