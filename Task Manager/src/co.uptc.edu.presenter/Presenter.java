import java.util.LinkedList;
import javax.swing.*;

public class Presenter {
   
    private Model taskManager;
    private View taskView;

    public Presenter(Model model, View view) {
        this.taskManager = model;
        this.taskView = view;    
        this.taskView.setPresenter(this);
    }
  
    public void addTaskButtonClicked() {
        String description = JOptionPane.showInputDialog(taskView, "Describa la actividad:");
        String dueDateInput = JOptionPane.showInputDialog(taskView, "Ingrese una fecha (dd/mm/yyyy):");

        if (description != null && dueDateInput != null) {
            if (isValidDate(dueDateInput)) {
                String dueDate = formatDate(dueDateInput);
                taskManager.addTask(description, dueDate);
                updateTaskList();
            } else {
                JOptionPane.showInputDialog(taskView, "Por favor use el formato dd/mm/yyyy.");
            }
        }
    }

    public void assignTaskButtonClicked(int selectedIndex) {
        String[] users = {"Eva", "Camilo", "Lucy"};
        String assignedTo = (String) JOptionPane.showInputDialog(taskView, "Assignar tarea a:", "Asignar tarea",
                JOptionPane.PLAIN_MESSAGE, null, users, users[0]);

        if (assignedTo != null) {
            taskManager.assignTask(selectedIndex, assignedTo);
            updateTaskList();
        }
    }

    private boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    private String formatDate(String inputDate) {
        String[] parts = inputDate.split("/");
        return parts[2] + "-" + parts[1] + "-" + parts[0];
    }

    private void updateTaskList() {
        LinkedList<Task> tasks = taskManager.getTasks();
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        
        for (Task task : tasks) {
            taskListModel.addElement(task.getDescription() + " (Asignado a: " + task.getAssignedTo() + ")");
        }

        taskView.updateTaskList(taskListModel);
    }

    public void showView() {
        taskView.setVisible(true);
    }

    public void generarConjuntoPotencia() {
    }
}