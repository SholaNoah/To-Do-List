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
        int choice = 0;
        do{
            System.out.println("\n==== To-Do List Menu ====");
            System.out.println("1. Display Tasks");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Search Task");
            System.out.println("6. Exit");
               System.out.println("Enter your choice: ");
               
                // --- INPUT VALIDATION STARTS HERE ---
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    scanner.nextLine(); // clear the wrong input
                    continue;           // restart the loop
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (choice < 1 || choice > 6) {
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

            
               }
        } while (choice != 6);
        scanner.close();
    }
}