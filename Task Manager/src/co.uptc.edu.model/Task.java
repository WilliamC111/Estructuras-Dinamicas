
public class Task {

    private String description;
    private String dueDate;
    private String assignedTo;

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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Task(String description, String dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.assignedTo = "No asignado";
    }

}

