/** To-Do List task
 * Contains title of the task, description, due date and status
 * @author Shankz
 * Version 1.0
 */
public class Task {
    // Static ID counter (shared by all Task objects)
    private static int nextId = 1;

    // Task attributes
    private String title;
    private String description;
    private String dueDate;
    private boolean status; 
    private int id; 

    // Constructor for NEW tasks (auto-assign ID)
    public Task(String title, String description, String dueDate, boolean status) {
        this.id = nextId++;  // auto-increment
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Constructor for LOADED tasks (ID already known)
    public Task(int id, String title, String description, String dueDate, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Allow TaskManager to update nextId after loading
    public static void setNextId(int newNextId) {
        nextId = newNextId;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public int getId() { return id; }

    @Override
    public String toString() {
        String statusIcon = status ? "[✔]" : "[ ]";
        return "ID:" + id + " " + statusIcon + " " + title + " (Due: " + dueDate + ")\n"
             + "Description: " + description;
    }
}
