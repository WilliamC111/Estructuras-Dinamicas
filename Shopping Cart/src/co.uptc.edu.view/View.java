import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class View extends JFrame {
    private Presenter presenter;
    private DefaultListModel<String> articleListModel;
    private JList<String> articleList;
    private JLabel totalPriceLabel;

    public View() {
        setTitle("Carrito de Compras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(173, 216, 230)); 
        

        articleListModel = new DefaultListModel<>();
        articleList = new JList<>(articleListModel);

        JButton addArticleButton= new JButton("Agregar Artículo");
        addArticleButton.setBackground(new Color(173, 216, 230));
        addArticleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.addArticleButtonClicked();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addArticleButton);
        totalPriceLabel = new JLabel("Total: $0.00");
        totalPriceLabel.setBackground(new Color(173, 216, 230));

        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(articleList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(totalPriceLabel, BorderLayout.NORTH);

        getContentPane().add(mainPanel);
    }

    public void updateArticleList(Vector<String> items) {
        articleListModel.clear();
        for (String item : items) {
            articleListModel.addElement(item);
        }
    }

    public void updateTotalPrice(double totalPrice) {
        totalPriceLabel.setText("Total: $" + String.format("%.2f", totalPrice));
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}

