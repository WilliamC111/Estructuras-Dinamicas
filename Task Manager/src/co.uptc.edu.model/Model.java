import java.util.LinkedList;

public class Model {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void addTask(String description, String dueDate) {
        tasks.add(new Task(description, dueDate));
    }

    public void assignTask(int index, String assignedTo) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setAssignedTo(assignedTo);
        }
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }
}
