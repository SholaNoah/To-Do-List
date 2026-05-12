/** To-Do List task
 * Contains title of the task, description, due date and status
 * @author Shankz
 * Version 1.0
 */
public class Task {
    // Task attributes
    private String title;
    private String description;
    private String dueDate;
    private boolean status; // true for completed, false for pending
    private int id; // Unique identifier for each task

    // Constructor
    public Task(String title, String description, String dueDate, boolean status, int id) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.id = id;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    // Task setting
        @Override
        public String toString() {
            String statusIcon = status ? "[✔]" : "[ ]";
            return "ID:" + id + " " + statusIcon + " " + title + " (Due: " + dueDate + ")\n"
                 + "Description: " + description;
}


}