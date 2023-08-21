import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class View extends JFrame {
    private Presenter presenter;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public View() {
        setTitle("Gestor de Actividades");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        getContentPane().setBackground(Color.BLUE);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JButton addButton = new JButton("Agregar tarea");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addTaskButtonClicked();
            }
        });

        JButton assignButton = new JButton("Asignar tarea");
        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    presenter.assignTaskButtonClicked(selectedIndex);
                }
            }
        });

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue()); 
        buttonPanel.add(addButton);
        buttonPanel.add(assignButton);
        buttonPanel.add(Box.createHorizontalGlue());

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void updateTaskList(DefaultListModel<String> model) {
        taskListModel = model;
        taskList.setModel(taskListModel);
    }

    public void showView() {
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}


