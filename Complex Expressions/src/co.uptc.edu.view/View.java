import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;
    private JButton evaluateButton;

    public View() {
        setTitle("Calculadora Expresiones complejas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBackground(Color.WHITE);
        inputField.setForeground(Color.BLACK);

        evaluateButton = new JButton("Evaluar");
        evaluateButton.setBackground(Color.BLACK);
        evaluateButton.setForeground(Color.WHITE);
        evaluateButton.setFocusPainted(false);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultArea.setBackground(Color.BLACK);
        resultArea.setForeground(Color.WHITE);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.BLACK);
        topPanel.add(new JLabel("Ingrese la expresion:"), BorderLayout.WEST);
        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(evaluateButton, BorderLayout.EAST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    public void addEvaluateListener(ActionListener listener) {
        evaluateButton.addActionListener(listener);
    }

    public String getInputExpression() {
        return inputField.getText();
    }

    public void setResultText(String result) {
        resultArea.setText("Resultado: " + result);
    }
}