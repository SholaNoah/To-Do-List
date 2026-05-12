import java.util.Scanner;

/** Main class for To-Do List
 * This is the interactive part of the program
 * @author Shankz
 * Version 1.0
 */

public class Main {
    public static void main(String [] args) {
        TaskManager taskmanager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        // ---- Menu Setup ----
        int choice;
        do{
            System.out.println("\n==== To-Do List Menu ====");
            System.out.println("1. Display Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");
               System.out.println("Enter your choice: ");
               choice = scanner.nextInt();
               scanner.nextLine();
               // consume newline

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
                    break;

                case 3: System.out.println("Enter task ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.removeTask(removeId);
                    break;

                case 4: System.out.println("Enter task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.markAsCompleted(completeId);
                    break;

                case 5: System.out.println("Enter task ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    taskmanager.searchTask(searchId);
                    break;

                case 6: System.out.println("Adios Amigo...");
                    break;

                    default:
                        System.out.println("Invalid choice, try again.");
                        break;
               }
        } while (choice != 6);
        scanner.close();
    }
}